package org.unicase.projectgenerator2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
		for(EAttribute attribute : newObject.eClass().getEAllAttributes()) {
			try {
				EClassifier attributeType = attribute.getEType();
				EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
				if(!attribute.isChangeable() || attribute.isDerived() || attribute.isVolatile())
					continue;
				if (attributeType == ecoreInstance.getEBoolean() || attributeType == ecoreInstance.getEBooleanObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Boolean> newAttributes = new ArrayList<Boolean>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextBoolean());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextBoolean()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEByteArray()){
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						for(int i = 0; i < maxObjects; i++) {
							byte[] bytes = new byte[random.nextInt(100)];
							random.nextBytes(bytes);
							new AddCommand(domain, newObject, attribute, bytes).doExecute();
						}
					} else {
						byte[] bytes = new byte[random.nextInt(100)];
						random.nextBytes(bytes);
						new SetCommand(domain, newObject, attribute, bytes).doExecute();
					}				
				} else if (attributeType == ecoreInstance.getEByte() || attributeType == ecoreInstance.getEByteObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						for(int i = 0; i < maxObjects; i++) {
							byte[] singleByte = new byte[1];
							random.nextBytes(singleByte);
							new AddCommand(domain, newObject, attribute, singleByte).doExecute();
						}
					} else {
						byte[] singleByte = new byte[1];
						random.nextBytes(singleByte);
						new SetCommand(domain, newObject, attribute, singleByte).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEChar() || attributeType == ecoreInstance.getECharacterObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Character> newAttributes = new ArrayList<Character>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add((char) (random.nextInt(94) + 33));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, (char)(random.nextInt(94) + 33)).doExecute();
					}
				} else if(attributeType == ecoreInstance.getEString()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<String> newAttributes = new ArrayList<String>();
						for(int i = 0; i < maxObjects; i++) {
							string.delete(0, string.length());
							for(int j = -5; j<random.nextInt(10); j++) {
								string.append((char)(random.nextInt(94) + 33));
							}
							newAttributes.add(string.toString());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						string.delete(0, string.length());
						for(int j = -5; j<random.nextInt(10); j++) {
							string.append((char)(random.nextInt(94) + 33));
						}
						new SetCommand(domain, newObject, attribute, string.toString()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEDate()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Date> newAttributes = new ArrayList<Date>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(date);
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, date).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEInt() || attributeType == ecoreInstance.getEIntegerObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Integer> newAttributes = new ArrayList<Integer>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEDouble() || attributeType == ecoreInstance.getEDoubleObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Double> newAttributes = new ArrayList<Double>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextDouble() * random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextDouble() * random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEFloat() || attributeType == ecoreInstance.getEFloatObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Float> newAttributes = new ArrayList<Float>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextFloat() * random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextFloat() * random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getELong() || attributeType == ecoreInstance.getELongObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Long> newAttributes = new ArrayList<Long>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextLong());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextLong()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEShort() || attributeType == ecoreInstance.getEShortObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Short> newAttributes = new ArrayList<Short>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add((short) random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, (short) random.nextInt()).doExecute();
					}
				} else if (attributeType ==ecoreInstance.getEBigInteger()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<BigInteger> newAttributes = new ArrayList<BigInteger>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(new BigInteger(20, random));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, new BigInteger(20, random)).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEBigDecimal()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<BigDecimal> newAttributes = new ArrayList<BigDecimal>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(new BigDecimal(random.nextDouble() * random.nextInt()));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, new BigDecimal(random.nextDouble() * random.nextInt())).doExecute();
					}
				}
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
