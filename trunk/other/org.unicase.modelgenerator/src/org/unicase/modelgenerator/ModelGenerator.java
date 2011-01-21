package org.unicase.modelgenerator;

import java.util.LinkedList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;

/**
 * Class for generating Ecore models, static methods only.
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

	/**
	 * The configuration containing settings for the generation process.
	 * 
	 * @see ModelGeneratorConfiguration
	 */
	private static ModelGeneratorConfiguration config;
	
	/**
	 * Random-object to compute random values for deleting EObjects
	 * and setting their attributes and references.
	 */
	private static Random random;
	
	/**
	 * The attributeHandler that actually creates random attribute values.
	 * 
	 * @see AttributeHandler 
	 */
	private static AttributeHandler attributeHandler;
	
	/**
	 * All EObjects including the root and all its direct and indirect contents,
	 * after deleting random EObjects.
	 */
	private static Map<EClass, List<EObject>> allObjectsByEClass;
	
	/**
	 * Map that maps every EClass to its corresponding list of EClasses,
	 * that should be created during the generation process.
	 * 
	 * @see #getElementsToCreate(EClass)
	 */
	private static Map<EClass, List<EClass>> eClassToElementsToCreate;
	
	
	/**
	 * Map that saves the last used index for every EClass
	 * to prevent that every instance of that EClass contains
	 * the same EClasses as children.
	 */
	private static Map<EClass, Integer> eClassToLastUsedIndex;
	
	/**
	 * A set of RuntimeExceptions that occurred during the last generation process.
	 * 
	 * @see #getLog()
	 */
	private static Set<RuntimeException> exceptions;
	
	/**
	 * Private constructor.
	 */
	private ModelGenerator() {
		// all methods should be accessed in a static way
	}
	
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
	 * Generates EObjects using the settings specified in <code>config</code>.
	 * 
	 * @param configuration the ModelGeneratorConfiguration to use for generating EObjects
	 * @see ModelGeneratorConfiguration
	 */
	public static void generateModel(ModelGeneratorConfiguration configuration) {
		config = configuration;
		random = new Random(config.getSeed());
		attributeHandler = new AttributeHandler(random);
		eClassToElementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		eClassToLastUsedIndex = new LinkedHashMap<EClass, Integer>();
		exceptions = new LinkedHashSet<RuntimeException>();
		EObject rootEObject = generateModel();
		allObjectsByEClass = ModelGeneratorUtil.getAllClassesAndObjects(rootEObject);
		for(EClass eClass : allObjectsByEClass.keySet()) {
			for(EObject generatedEObject : allObjectsByEClass.get(eClass)) {
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
		EObject rootEObject = validateRoot(config.getRootEObject());
		List<EObject> remainingObjects = new LinkedList<EObject>();
		remainingObjects.add(rootEObject);
		int currentDepth = 1;
		int remainingElementsInThisDepth = config.getWidth();
		while(!remainingObjects.isEmpty()) {
			EObject nextParentEObject = remainingObjects.remove(0);
			List<EObject> children = generateChildren(nextParentEObject); 
			if(currentDepth < config.getDepth())
				remainingObjects.addAll(children);
			remainingElementsInThisDepth -= config.getWidth();
			if(remainingElementsInThisDepth <= 0) {
				currentDepth++;
				remainingElementsInThisDepth = (int) Math.pow(config.getWidth(), currentDepth);
			}
		}
		return rootEObject;
	}
	
	/**
	 * Generates children for a certain parent EObject. Generation includes
	 * setting containment references and attributes.
	 * @param parentEObject the EObject to generate children for
	 * @return all generated children as a list
	 */
	private static List<EObject> generateChildren(EObject parentEObject) {
		List<EObject> result = new LinkedList<EObject>();
		int index = getStartingIndex(parentEObject.eClass());
		List<EClass> elementsToCreate = getElementsToCreate(parentEObject.eClass());
		EClass currentChildClass = getNextClassToCreate(elementsToCreate, index);
		int createdChildren = 0;
		while(currentChildClass != null && createdChildren<config.getWidth()) {
			List<EReference> validReferences = getValidContainmentReferences(currentChildClass, parentEObject);
			if(validReferences.isEmpty())
				elementsToCreate.remove(currentChildClass);
			for(EReference reference : validReferences) {
				if(createdChildren>=config.getWidth())
					break;
				EObject newChild = setContainment(parentEObject, currentChildClass, reference);
				createdChildren++;
				if(newChild!=null) {
					result.add(newChild);
				}
			}
			currentChildClass = getNextClassToCreate(elementsToCreate, ++index);
		}
		eClassToLastUsedIndex.put(parentEObject.eClass(), index);
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
	 * @see ModelGeneratorUtil#addPerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Object, Set, boolean)
	 * @see ModelGeneratorUtil#setPerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Object, Set, boolean)
	 */
	private static EObject setContainment(EObject parentEObject, EClass childClass, EReference reference) {
		EObject newEObject = EcoreUtil.create(childClass);
		ModelGeneratorUtil.setEObjectAttributes(newEObject, attributeHandler,
			exceptions, config.getIgnoreAndLog());
		if(reference.isMany()) {
			return ModelGeneratorUtil.addPerCommand(parentEObject, reference, newEObject,
				exceptions, config.getIgnoreAndLog());
		}
		else {
			return ModelGeneratorUtil.setPerCommand(parentEObject, reference, newEObject,
				exceptions, config.getIgnoreAndLog());
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
		if(eClassToLastUsedIndex.containsKey(eClass)) {
			return eClassToLastUsedIndex.get(eClass);
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
			ModelGeneratorUtil.setEObjectAttributes(rootEObject, attributeHandler,
				exceptions, config.getIgnoreAndLog());
		}
		return rootEObject;
	}


	
	/**
	 * Returns the Exception-Log for the last {@link #generateModel()}-call.
	 * The log is empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in the last configuration used.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last generation process
	 */
	public static Set<RuntimeException> getLog() {
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
		List<EReference> result = new LinkedList<EReference>();
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
	 * @see ModelGeneratorUtil#setReference(EObject, EClass, EReference, Random, Set, boolean, Map)
	 */
	private static void generateReferences(EObject eObject) {
		for(EReference reference : ModelGeneratorUtil.getValidReferences(eObject)) {
			for(EClass nextReferenceClass : ModelGeneratorUtil.getReferenceClasses(reference, allObjectsByEClass.keySet())) {
				if(allObjectsByEClass.containsKey(nextReferenceClass)) {
					ModelGeneratorUtil.setReference(eObject, nextReferenceClass, reference, random,
						exceptions, config.getIgnoreAndLog(), allObjectsByEClass);
				}
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
	 * @see ModelGeneratorUtil#getAllEClasses(EPackage)
	 */
	private static List<EClass> getElementsToCreate(EClass parentEClass) {
		if(eClassToElementsToCreate.containsKey(parentEClass)) {
			return eClassToElementsToCreate.get(parentEClass);
		} else {
			List<EClass> result = new LinkedList<EClass>(ModelGeneratorUtil.getAllEContainments(parentEClass));
			Set<EClass> modelElementEClasses = ModelGeneratorUtil.getAllEClasses(config.getModelPackage());
			result.retainAll(modelElementEClasses);
			Collections.shuffle(result, random);
			eClassToElementsToCreate.put(parentEClass, result);
			return result;
		}
	}
}
