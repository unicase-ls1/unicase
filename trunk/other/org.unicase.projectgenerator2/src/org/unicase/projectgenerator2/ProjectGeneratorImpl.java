package org.unicase.projectgenerator2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.projectgenerator2.util.AttributSetterEString;
import org.unicase.projectgenerator2.util.AttributeSetterEBigDecimal;
import org.unicase.projectgenerator2.util.AttributeSetterEBigInteger;
import org.unicase.projectgenerator2.util.AttributeSetterEBoolean;
import org.unicase.projectgenerator2.util.AttributeSetterEByte;
import org.unicase.projectgenerator2.util.AttributeSetterEByteArray;
import org.unicase.projectgenerator2.util.AttributeSetterEChar;
import org.unicase.projectgenerator2.util.AttributeSetterEDate;
import org.unicase.projectgenerator2.util.AttributeSetterEDouble;
import org.unicase.projectgenerator2.util.AttributeSetterEFloat;
import org.unicase.projectgenerator2.util.AttributeSetterEInt;
import org.unicase.projectgenerator2.util.AttributeSetterELong;
import org.unicase.projectgenerator2.util.AttributeSetterEShort;
import org.unicase.projectgenerator2.util.IAttributeSetter;
import org.unicase.projectgenerator2.util.ProjectGeneratorConfiguration;
import org.unicase.projectgenerator2.util.ProjectGeneratorUtil;

public class ProjectGeneratorImpl {
	private static Random random;
	private static Date date;
	private static StringBuffer string;
	private static Map<EClass, List<EClass>> elementsToCreate;
	private static Map<EClass, Integer> lastUsedIndex;
	private static Map<EReference, List<EClass>> possibleReferenceClasses;
	private static Map<EClass, Set<EObject>> generatedObjects;
	private static List<RuntimeException> exceptions;
	private static ProjectGeneratorConfiguration currentConfig;

	public static void generateModel(EPackage modelPackage, EObject rootObject) {
		generateModel(new ProjectGeneratorConfiguration(modelPackage, rootObject));
	}
	
	public static void generateModel(ProjectGeneratorConfiguration config) {
		currentConfig = config;
		random = new Random(config.getSeed());
		date = new Date();
		string = new StringBuffer();
		elementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		lastUsedIndex = new LinkedHashMap<EClass, Integer>();
		possibleReferenceClasses = new LinkedHashMap<EReference, List<EClass>>();
		exceptions = new ArrayList<RuntimeException>();
		EObject rootObject = generateModel();
		generatedObjects = ProjectGeneratorUtil.getAllGeneratedClassesAndObjects(rootObject);
		for(EClass eClass : generatedObjects.keySet()) {
			for(EObject generatedEObject : generatedObjects.get(eClass)) {
				generateReferences(generatedEObject);			
			}
		}
		
		

	}

	private static EObject generateModel() {
		EObject rootObject = validateRoot(currentConfig.getRootObject());
		List<EObject> remainingObjects = new ArrayList<EObject>();
		remainingObjects.add(rootObject);
		int currentDepth = 1;
		int remainingElementsInThisDepth = currentConfig.getWidth();
		while(!remainingObjects.isEmpty()) {
			EObject currentParentObject = remainingObjects.remove(0);
			List<EObject> children = generateChildren(currentParentObject); 
			if(currentDepth < currentConfig.getDepth())
				remainingObjects.addAll(children);
			remainingElementsInThisDepth -= currentConfig.getWidth();
			if(remainingElementsInThisDepth <= 0) {
				currentDepth++;
				remainingElementsInThisDepth = (int) Math.pow(currentConfig.getWidth(), currentDepth);
			}
		}
		return rootObject;
	}
	
	private static List<EObject> generateChildren(EObject currentParentObject) {
		List<EObject> result = new ArrayList<EObject>();
		int index = getStartingIndex(currentParentObject);
		List<EClass> elementsToCreate = getElementsToCreate(currentParentObject.eClass());
		EClass currentChildClass = getNextClassToCreate(elementsToCreate, index);
		int createdChildren = 0;
		while(currentChildClass != null && createdChildren<currentConfig.getWidth()) {
			List<EReference> validReferences = getValidContainmentReferences(currentChildClass, currentParentObject);
			if(validReferences.isEmpty())
				elementsToCreate.remove(currentChildClass);
			for(EReference reference : validReferences) {
				if(createdChildren>=currentConfig.getWidth())
					break;
				EObject newChild = setContainment(currentParentObject, currentChildClass, reference);
				createdChildren++;
				if(newChild!=null) {
					result.add(newChild);
				}
			}
			currentChildClass = getNextClassToCreate(elementsToCreate, ++index);
		}
		lastUsedIndex.put(currentParentObject.eClass(), index);
		return result;
	}

	private static EObject setContainment(EObject currentParentObject, EClass currentChildClass, EReference reference) {
		EObject newObject = EcoreUtil.create(currentChildClass);
		setEObjectAttributes(newObject);
		if(reference.isMany()) {
			return addPerCommand(currentParentObject, reference, newObject);
		}
		else {
			return setPerCommand(currentParentObject, reference, newObject);
		}
	}

	private static EObject setPerCommand(EObject currentParentObject, EReference reference, EObject newObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(currentParentObject);
		try {
			new SetCommand(domain, currentParentObject, reference, newObject).doExecute();
			return newObject;
		} catch(RuntimeException e){
			handle(e, currentConfig.getIgnoreAndLog());
			return null;
		}
	}

	private static EObject addPerCommand(EObject currentParentObject, EReference reference, EObject newObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(currentParentObject);
		try {
			new AddCommand(domain, currentParentObject, reference, newObject).doExecute();
			return newObject;
		} catch(RuntimeException e) {
			handle(e, currentConfig.getIgnoreAndLog());
			return null;
		}
	}

	private static EClass getNextClassToCreate(List<EClass> elementsToCreate, int index) {
		if(elementsToCreate.isEmpty())
			return null;
		index %= elementsToCreate.size();
		EClass result = elementsToCreate.get(index);
		while(result.isInterface()|| result.isAbstract()) {
			elementsToCreate.remove(result);
			if(elementsToCreate.isEmpty())
				return null;
			index %= elementsToCreate.size();
			result = elementsToCreate.get(index);
		}
		return result;
	}

	private static int getStartingIndex(EObject currentParentObject) {
		if(lastUsedIndex.containsKey(currentParentObject.eClass())) {
			return lastUsedIndex.get(currentParentObject.eClass());
		} else {
			return 0;
		}
	}

	private static EObject validateRoot(EObject rootObject) {
		if(rootObject == null)
			return null;
		if(rootObject instanceof EClass) {
			EClass parentClass = (EClass) rootObject;
			if(parentClass.isInterface() || parentClass.isAbstract())
				return null;
			rootObject = EcoreUtil.create(parentClass);
			setEObjectAttributes(rootObject);
		}
		return rootObject;
	}

	private static void handle(RuntimeException e, boolean ignoreAndLog) {
		if(ignoreAndLog)
			exceptions.add(e);
		else
			throw e;
	}
	
	public static List<RuntimeException> getLog() {
		return exceptions;
	}

	private static List<EReference> getValidContainmentReferences(EClass childClass, EObject parentObject) {
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : ProjectGeneratorUtil.getAllPossibleContainingReferences(childClass, parentObject.eClass())) {
			if(reference.isChangeable() && (reference.isMany() || !parentObject.eIsSet(reference)))
				result.add(reference);
		}
		return result;
	}
	
	private static void generateReferences(EObject eObject) {
		for(EReference reference : getValidReferences(eObject)) {
			for(EClass nextReferenceClass : getPossibleReferenceClasses(reference)) {
				if(generatedObjects.containsKey(nextReferenceClass)) {
					setReference(eObject, nextReferenceClass, reference);
				}
			}
		}
	}

	private static void setReference(EObject eObject, EClass nextReferenceClass, EReference reference) {
		List<EObject> possibleReferenceObjects = new ArrayList<EObject>(generatedObjects.get(nextReferenceClass)); 
		Collections.shuffle(possibleReferenceObjects, random);
		if(!possibleReferenceObjects.isEmpty()) {
			int index = 0;
			if(reference.isMany()) {
				int maxObjects = random.nextInt(3);
				if(reference.isRequired()) maxObjects++;
				for(int i = 0; i < maxObjects; i++) {
					addPerCommand(eObject, reference, possibleReferenceObjects.get(index));
					if(++index==possibleReferenceObjects.size()) break;
				}
			} else if (reference.isRequired() || random.nextBoolean()){
				setPerCommand(eObject, reference, possibleReferenceObjects.get(index));
			}
		}
	}

	private static List<EReference> getValidReferences(EObject newObject) {
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(!reference.isContainer() && !reference.isContainment() && reference.isChangeable() && !reference.isVolatile() && !reference.isDerived() && (reference.isMany() || !newObject.eIsSet(reference))) {
				result.add(reference);
			}
		}
		return result;
	}

	private static List<EClass> getPossibleReferenceClasses(EReference reference) {
		if(possibleReferenceClasses.containsKey(reference))
			return possibleReferenceClasses.get(reference);
		else {
			List<EClass> result = new ArrayList<EClass>();
			EClass referenceType = reference.getEReferenceType();
			result.add(referenceType);
			for(EClass eClass : generatedObjects.keySet()) {
				if(referenceType.isSuperTypeOf(eClass)) {
					result.add(eClass);
				}
			}
			possibleReferenceClasses.put(reference, result);
			return result;
		}
	}

	private static void setEObjectAttributes(EObject newObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(newObject);
		EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
		
		LinkedHashMap<EClassifier, IAttributeSetter<?>> map = new LinkedHashMap<EClassifier, IAttributeSetter<?>>();
		IAttributeSetter<?> oAttributeSetter;
		
		oAttributeSetter = new AttributeSetterEBoolean(3, random);
		map.put(ecoreInstance.getEBoolean(), oAttributeSetter);
		map.put(ecoreInstance.getEBooleanObject(), oAttributeSetter);
	
		
		map.put(ecoreInstance.getEByteArray(), new AttributeSetterEByteArray(3, random, 100));
		
		map.put(ecoreInstance.getEString(), new AttributSetterEString(3, random));
		
		oAttributeSetter = new AttributeSetterEInt(3, random);
		map.put(ecoreInstance.getEInt(), oAttributeSetter);
		map.put(ecoreInstance.getEIntegerObject(), oAttributeSetter);
		
		map.put(ecoreInstance.getEDate(), new AttributeSetterEDate(3, random));
		
		oAttributeSetter = new AttributeSetterELong(3, random);
		map.put(ecoreInstance.getELong(), oAttributeSetter);
		map.put(ecoreInstance.getELongObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEByte(3, random);
		map.put(ecoreInstance.getEByte(), oAttributeSetter);
		map.put(ecoreInstance.getEByteObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEChar(3, random);
		map.put(ecoreInstance.getEChar(), oAttributeSetter);
		map.put(ecoreInstance.getECharacterObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEDouble(3, random);
		map.put(ecoreInstance.getEDouble(), oAttributeSetter);
		map.put(ecoreInstance.getEDoubleObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEFloat(3, random);
		map.put(ecoreInstance.getEFloat(), oAttributeSetter);
		map.put(ecoreInstance.getEFloatObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEShort(3, random);
		map.put(ecoreInstance.getEShort(), oAttributeSetter);
		map.put(ecoreInstance.getEShortObject(), oAttributeSetter);
		
		map.put(ecoreInstance.getEBigInteger(),new AttributeSetterEBigInteger(3, random));
		
		map.put(ecoreInstance.getEBigDecimal(),new AttributeSetterEBigDecimal(3, random));
		
		for(EAttribute attribute : newObject.eClass().getEAllAttributes()) {
			try {
				EClassifier attributeType = attribute.getEType();
				
				if(!attribute.isChangeable() || attribute.isDerived() || attribute.isVolatile())
					continue;
				if (map.containsKey(attributeType)) {
					if (attribute.isMany()) {
						new AddCommand(domain, newObject, attribute, map.get(attributeType).createNewAttributes()).doExecute();
					}
					else {
						new SetCommand(domain, newObject, attribute, map.get(attributeType).createNewAttribute()).doExecute();
					}
				}
//				else {
//					System.out.println(attributeType.getName());
//				}
				
			} catch (RuntimeException e) {
			}
		}
	}
	
	private static List<EClass> getElementsToCreate(EClass eClass) {
		if(elementsToCreate.containsKey(eClass)) {
			return elementsToCreate.get(eClass);
		} else {
			List<EClass> result = new ArrayList<EClass>(ProjectGeneratorUtil.getAllEContainments(eClass));
			Set<EClass> modelElementEClasses = ProjectGeneratorUtil.getAllModelElementEClasses(currentConfig.getModelPackage());
			result.retainAll(modelElementEClasses);
			Collections.shuffle(result, random);
			elementsToCreate.put(eClass, result);
			return result;
		}
	}
}
