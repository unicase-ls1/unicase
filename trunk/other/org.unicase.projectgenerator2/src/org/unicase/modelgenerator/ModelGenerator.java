package org.unicase.modelgenerator;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.modelgenerator.attributesetter.IAttributeSetter;
import org.unicase.modelgenerator.util.AttributeHandler;
import org.unicase.modelgenerator.util.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.util.ModelGeneratorUtil;

/**
 * Utility class for generating Ecore models.
 * Generating a model includes:<br>
 * - creating EObjects from a certain model package<br>
 * - building up a hierarchy starting from a certain root EObject<br>
 * - setting random attributes for every created EObject<br>
 * - setting references between the EObjects
 *
 *@see #generateModel(EPackage, EObject)
 *@see #generateModel(ModelGeneratorConfiguration)
 */
public class ModelGenerator {
	private static AttributeHandler attributeHandler;
	private static Random random;
	private static Map<EClass, List<EClass>> elementsToCreate;
	private static Map<EClass, Integer> lastUsedIndex;
	private static Map<EReference, List<EClass>> possibleReferenceClasses;
	private static Map<EClass, Set<EObject>> generatedObjects;
	
	private static List<RuntimeException> exceptions;
	private static ModelGeneratorConfiguration currentConfig;

	/**
	 * Generates EObjects for a certain model indicated by <code>modelPackage</code> and adds them 
	 * as children to <code>rootEObject</code>, setting attributes and references. This method uses
	 * default values for <code>width, depth, seed</code> and <code>ignoreAndLog</code>.<p>
	 * This method call is equivalent to<br>
	 * <code>generateModel(new ModelGeneratorConfiguration(modelPackage, rootEObject))</code>.
	 * 
	 * @param modelPackage the EPackage to create new EObjects from
	 * @param rootEObject the EObject that shall be the root container for all generated EObjects
	 */
	public static void generateModel(EPackage modelPackage, EObject rootEObject) {
		generateModel(new ModelGeneratorConfiguration(modelPackage, rootEObject));
	}
	
	/**
	 * Generates EObjects using the settings declared in <code>config</code>.
	 * 
	 * @param config the configuration to use for generating EObjects
	 * @see ModelGeneratorConfiguration
	 */
	public static void generateModel(ModelGeneratorConfiguration config) {
		currentConfig = config;
		attributeHandler = new AttributeHandler();
		random = new Random(config.getSeed());
		elementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		lastUsedIndex = new LinkedHashMap<EClass, Integer>();
		possibleReferenceClasses = new LinkedHashMap<EReference, List<EClass>>();
		exceptions = new ArrayList<RuntimeException>();
		EObject rootEObject = generateModel();
		generatedObjects = ModelGeneratorUtil.getAllGeneratedClassesAndObjects(rootEObject);
		for(EClass eClass : generatedObjects.keySet()) {
			for(EObject generatedEObject : generatedObjects.get(eClass)) {
				generateReferences(generatedEObject);			
			}
		}
	}

	/**
	 * The method that actually performs the generation. This can only be
	 * accessed by calling {@link #generateModel(EPackage, EObject)} or
	 * {@link #generateModel(ModelGeneratorConfiguration)}
	 * 
	 * @return the valid root EObject used for generating the model
	 * 
	 * @see #generateModel(EPackage, EObject)
	 * @see #generateModel(ModelGeneratorConfiguration)
	 */
	private static EObject generateModel() {
		EObject rootEObject = validateRoot(currentConfig.getRootEObject());
		List<EObject> remainingObjects = new ArrayList<EObject>();
		remainingObjects.add(rootEObject);
		int currentDepth = 1;
		int remainingElementsInThisDepth = currentConfig.getWidth();
		while(!remainingObjects.isEmpty()) {
			EObject nextParentEObject = remainingObjects.remove(0);
			List<EObject> children = generateChildren(nextParentEObject); 
			if(currentDepth < currentConfig.getDepth())
				remainingObjects.addAll(children);
			remainingElementsInThisDepth -= currentConfig.getWidth();
			if(remainingElementsInThisDepth <= 0) {
				currentDepth++;
				remainingElementsInThisDepth = (int) Math.pow(currentConfig.getWidth(), currentDepth);
			}
		}
		return rootEObject;
	}
	
	/**
	 * Generates children for a certain parent EObject
	 * @param parentEObject the EObject to generate children for
	 * @return all generated children as a list
	 */
	private static List<EObject> generateChildren(EObject parentEObject) {
		List<EObject> result = new ArrayList<EObject>();
		int index = getStartingIndex(parentEObject.eClass());
		List<EClass> elementsToCreate = getElementsToCreate(parentEObject.eClass());
		EClass currentChildClass = getNextClassToCreate(elementsToCreate, index);
		int createdChildren = 0;
		while(currentChildClass != null && createdChildren<currentConfig.getWidth()) {
			List<EReference> validReferences = getValidContainmentReferences(currentChildClass, parentEObject);
			if(validReferences.isEmpty())
				elementsToCreate.remove(currentChildClass);
			for(EReference reference : validReferences) {
				if(createdChildren>=currentConfig.getWidth())
					break;
				EObject newChild = setContainment(parentEObject, currentChildClass, reference);
				createdChildren++;
				if(newChild!=null) {
					result.add(newChild);
				}
			}
			currentChildClass = getNextClassToCreate(elementsToCreate, ++index);
		}
		lastUsedIndex.put(parentEObject.eClass(), index);
		return result;
	}

	/**
	 * Creates a valid instance of <code>childClass</code> (includes setting attributes) and sets
	 * it as a child of <code>parentEObject</code> using AddCommand/SetCommand
	 * 
	 * @param parentEObject the EObject that shall contain the new instance of <code>childClass</code>
	 * @param childClass the EClass of the child that shall be contained in <code>parentEObject</code>
	 * @param reference the containment reference
	 * @return the instance of <code>childClass</code> that is contained in <code>parentEObject</code>
	 * or <code>null</code> if the operation failed
	 * 
	 * @see #addPerCommand(EObject, EReference, EObject)
	 * @see #setPerCommand(EObject, EReference, EObject)
	 */
	private static EObject setContainment(EObject parentEObject, EClass childClass, EReference reference) {
		EObject newEObject = EcoreUtil.create(childClass);
		setEObjectAttributes(newEObject);
		if(reference.isMany()) {
			return addPerCommand(parentEObject, reference, newEObject);
		}
		else {
			return setPerCommand(parentEObject, reference, newEObject);
		}
	}

	/**
	 * Sets a reference between <code>parentEObject</code> and <code>newEObject</code>
	 * using a SetCommand. Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject for which <code>reference</code> shall be set
	 * @param reference the EReference that shall be set
	 * @param newEObject the EObject that shall be set as an EReference in <code>parentEObject</code>
	 * @return <code>newEObject</code> if the <code>SetCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 */
	private static EObject setPerCommand(EObject parentEObject, EReference reference, EObject newEObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new SetCommand(domain, parentEObject, reference, newEObject).doExecute();
			return newEObject;
		} catch(RuntimeException e){
			handle(e, currentConfig.getIgnoreAndLog());
			return null;
		}
	}

	/**
	 * Adds <code>newEObject</code> to the many-valued reference of 
	 * <code>parentEObject</code> using an AddCommand. 
	 * Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to which <code>newEObject</code> shall be added
	 * @param reference the EReference that <code>newEObject</code> shall be added to
	 * @param newEObject the EObject that shall be added to an EReference in <code>parentEObject</code>
	 * @return <code>newEObject</code> if the <code>AddCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 */
	private static EObject addPerCommand(EObject parentEObject, EReference reference, EObject newEObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new AddCommand(domain, parentEObject, reference, newEObject).doExecute();
			return newEObject;
		} catch(RuntimeException e) {
			handle(e, currentConfig.getIgnoreAndLog());
			return null;
		}
	}
	
	/**
	 * Gets the next valid EClass from a list of EClasses. A valid EClass is an
	 * EClass that is neither abstract nor an interface and can therefore be
	 * instantiated.
	 * 
	 * @param elementsToCreate the list of usable EClasses
	 * @param index the next index to use
	 * @return the next valid EClass or <code>null</code> if there is none
	 */
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

	/**
	 * Returns an index that hasn't been used before, if existent.
	 * This prevents that an EClass always contains the same EClasses as children,
	 * where <code>eClass</code> is the parentEObject's EClass.
	 * 
	 * @param eClass the EClass to get the index for 
	 * @return the last used index or 0 if this EClass hasn't been instantiated yet
	 */
	private static int getStartingIndex(EClass eClass) {
		if(lastUsedIndex.containsKey(eClass)) {
			return lastUsedIndex.get(eClass);
		} else {
			return 0;
		}
	}

	/**
	 * Validates <code>rootEObject</code> so the root is a valid EObject instance.
	 * If <code>rootEObject</code> is valid already, it is just returned.
	 * Otherwise, if <code>rootEObject</code> is an EClass (not abstract, no interface),
	 * it is instantiated and its attributes are set.
	 * If none of the above is true, null is returned.
	 * @param rootEObject the EObject to validate
	 * @return <code>null</code> if <code>rootEObject</code> is <code>null</code> or an
	 * abstract EClass or interface,<br>
	 * <code>rootEObject</code> if the root is already valid,<br>
	 * a new instance of <code>rootEObject</code> if it is an EClass
	 */
	private static EObject validateRoot(EObject rootEObject) {
		if(rootEObject == null)
			return null;
		if(rootEObject instanceof EClass) {
			EClass parentClass = (EClass) rootEObject;
			if(parentClass.isInterface() || parentClass.isAbstract())
				return null;
			rootEObject = EcoreUtil.create(parentClass);
			setEObjectAttributes(rootEObject);
		}
		return rootEObject;
	}

	/**
	 * Handles exceptions as declared in <code>currentConfig</code>, meaning
	 * that <code>e</code> is thrown if <code>ignoreAndLog</code> is false.
	 * Otherwise <code>e</code> is ignored and added to <code>exceptions</code>.
	 * 
	 * @param e the exception to handle
	 * @param ignoreAndLog shall the exception be ignored?
	 */
	private static void handle(RuntimeException e, boolean ignoreAndLog) {
		if(ignoreAndLog)
			exceptions.add(e);
		else
			throw e;
	}
	
	/**
	 * Returns the Exception-Log for the last <code>generateModel</code>-call.
	 * The log is empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in the last configuration used.
	 * 
	 * @return a list of RuntimeExceptions that occurred during the last generation process
	 */
	public static List<RuntimeException> getLog() {
		return exceptions;
	}

	/**
	 * Returns all valid containment references for a parent EObject and a child EClass.
	 * A reference is valid if it is changeable and either many-valued or not already set.
	 * 
	 * @param childClass the EClass that shall be contained
	 * @param parentEObject the EObject that shall be the container
	 * @return all containment references between <code>parentEObject</code> and 
	 * <code>childClass</code> that are valid 
	 */
	private static List<EReference> getValidContainmentReferences(EClass childClass, EObject parentEObject) {
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : ModelGeneratorUtil.getAllPossibleContainingReferences(childClass, parentEObject.eClass())) {
			if(reference.isChangeable() && (reference.isMany() || !parentEObject.eIsSet(reference)))
				result.add(reference);
		}
		return result;
	}
	
	/**
	 * Generates references (no containment references) for an EObject.
	 * All valid references are set with EObjects generated during the generation process.
	 * 
	 * @param eObject the EObject to set references for
	 * @see #setReference(EObject, EClass, EReference)
	 */
	private static void generateReferences(EObject eObject) {
		for(EReference reference : getValidReferences(eObject)) {
			for(EClass nextReferenceClass : getPossibleReferenceClasses(reference)) {
				if(generatedObjects.containsKey(nextReferenceClass)) {
					setReference(eObject, nextReferenceClass, reference);
				}
			}
		}
	}

	/**
	 * Actually sets or adds to a reference for an eObject with any generated instance
	 * of <code>referenceClass</code> using SetCommand/AddCommand. If the reference is 
	 * not required, <code>random</code> decides whether the reference is set or how 
	 * many EObjects are added to it.
	 *  
	 * @param eObject the EObject to set the reference for
	 * @param referenceClass the EClass all referenced EObject shall be instances of
	 * @param reference the reference to set
	 * 
	 * @see #addPerCommand(EObject, EReference, EObject)
	 * @see #setPerCommand(EObject, EReference, EObject)
	 */
	private static void setReference(EObject eObject, EClass referenceClass, EReference reference) {
		List<EObject> possibleReferenceObjects = new ArrayList<EObject>(generatedObjects.get(referenceClass)); 
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

	/**
	 * Returns all valid references for an EObject. This excludes container/containment references.
	 * A reference is valid if it is neither derived nor volatile and if it is changeable and
	 * either many-valued or not already set.
	 * 
	 * @param eObject the EObject to get references for
	 * @return all valid references as a list
	 */
	private static List<EReference> getValidReferences(EObject eObject) {
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : eObject.eClass().getEAllReferences()) {
			if(!reference.isContainer() && !reference.isContainment() && reference.isChangeable() && !reference.isVolatile() && !reference.isDerived() && (reference.isMany() || !eObject.eIsSet(reference))) {
				result.add(reference);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param reference
	 * @return all EClasses that can be referenced as a list
	 */
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

	/**
	 * Sets all possible attributes of known types to random values using {@link IAttributeSetter}
	 * and SetCommands/AddCommands.
	 * 
	 * @param eObject the EObject to set attributes for 
	 * @see IAttributeSetter
	 * @see #addPerCommand(EObject, EReference, EObject)
	 * @see #setPerCommand(EObject, EReference, EObject)
	 */
	private static void setEObjectAttributes(EObject eObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		Map<EClassifier, IAttributeSetter<?>> attributeSetters = attributeHandler.getAttributeSetters(random);
		
		for(EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			try {
				EClassifier attributeType = attribute.getEType();
				
				if(!attribute.isChangeable() || attribute.isDerived() || attribute.isVolatile())
					continue;
				if (attributeSetters.containsKey(attributeType)) {
					if (attribute.isMany()) {
						new AddCommand(domain, eObject, attribute, attributeSetters.get(attributeType).createNewAttributes()).doExecute();
					}
					else {
						new SetCommand(domain, eObject, attribute, attributeSetters.get(attributeType).createNewAttribute()).doExecute();
					}
				}				
			} catch (RuntimeException e) {
				handle(e, currentConfig.getIgnoreAndLog());
			}
		}
	}
	
	/**
	 * Returns all EClasses that can possibly created as children for <code>parentEClass</code>.
	 * The result is shuffled before it is returned, so different seeds cause different result.
	 * Only EClasses that are also contained in the configuration's <code>modelPackage</code>
	 * are retained.
	 * 
	 * @param parentEClass
	 * @return all possible child-EClasses as a list
	 * @see ModelGeneratorUtil#getAllEContainments(EClass)
	 * @see ModelGeneratorUtil#getAllModelElementEClasses(EPackage)
	 */
	private static List<EClass> getElementsToCreate(EClass parentEClass) {
		if(elementsToCreate.containsKey(parentEClass)) {
			return elementsToCreate.get(parentEClass);
		} else {
			List<EClass> result = new ArrayList<EClass>(ModelGeneratorUtil.getAllEContainments(parentEClass));
			Set<EClass> modelElementEClasses = ModelGeneratorUtil.getAllModelElementEClasses(currentConfig.getModelPackage());
			result.retainAll(modelElementEClasses);
			Collections.shuffle(result, random);
			elementsToCreate.put(parentEClass, result);
			return result;
		}
	}
}
