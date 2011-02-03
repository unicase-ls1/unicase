package org.unicase.modelgenerator;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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

public class ModelGeneratorHelper {
	
	private static ModelGeneratorConfiguration configuration;
	
	/**
	 * A set of RuntimeExceptions that occurred during the last generation process.
	 * 
	 * @see #getExceptionLog()
	 */
	private static Set<RuntimeException> exceptionLog;

	/**
	 * All EClasses that shall be ignored during the generation process.
	 * These EClasses are specified in the configuration.
	 * 
	 * @see #getEClassesToIgnore()
	 */
	private static Set<EClass> eClassesToIgnore;

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
	 * Random-object to compute random values for deleting EObjects
	 * and setting their attributes and references.
	 */
	private static Random random;

	private ModelGeneratorHelper() {
	}
	
	protected static void init(ModelGeneratorConfiguration config) {
		configuration = config;
		random = new Random(config.getSeed());
		AttributeHandler.setRandom(random);
		exceptionLog = new LinkedHashSet<RuntimeException>();
		eClassesToIgnore = getEClassesToIgnore();
		eClassToElementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		eClassToLastUsedIndex = new LinkedHashMap<EClass, Integer>();
	}
	
	/**
	 * The configuration containing settings for the generation process.
	 * 
	 * @see ModelGeneratorConfiguration
	 */
	protected static void setConfiguration(ModelGeneratorConfiguration config) {
		
	}

	/**
	 * Computes the total amount of work to do (in units) during the generation process.
	 * This number is used for the Progress Bar and is twice the number of all EObjects 
	 * that will be created (once for the creation, once for setting its references). 
	 * 
	 * @return the total amount of work in units as an integer
	 */
	protected static int computeAmountOfWork() {
		int result = 0;
		for(int i=1; i<=configuration.getDepth(); i++) {
			result += (int) Math.pow(configuration.getWidth(), i);
		}
		return result*2;
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
	protected static EObject setContainment(EObject parentEObject, EClass childClass, EReference reference) {
		EObject newEObject = EcoreUtil.create(childClass);
		ModelGeneratorUtil.setEObjectAttributes(newEObject,	exceptionLog, configuration.getIgnoreAndLog());
		if(reference.isMany()) {
			return ModelGeneratorUtil.addPerCommand(parentEObject, reference, newEObject,
				exceptionLog, configuration.getIgnoreAndLog());
		}
		else {
			return ModelGeneratorUtil.setPerCommand(parentEObject, reference, newEObject,
				exceptionLog, configuration.getIgnoreAndLog());
		}
	}

	protected static Set<RuntimeException> getExceptionLog() {
		return exceptionLog;
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
	protected static EObject validateRoot(EObject rootEObject) {
		if(rootEObject == null)
			throw new IllegalArgumentException("Root mustn't be null!");
		if(rootEObject instanceof EClass) {
			EClass parentClass = (EClass) rootEObject;
			if(parentClass.isInterface() || parentClass.isAbstract())
				throw new IllegalArgumentException("Root mustn't be abstract or an interface!");
			rootEObject = EcoreUtil.create(parentClass);
			ModelGeneratorUtil.setEObjectAttributes(rootEObject, exceptionLog, configuration.getIgnoreAndLog());
		}
		return rootEObject;
	}

	/**
	 * Returns all EClasses that shall be excluded from the generation process,
	 * using the <code>eClassesToIgnore</code>-collection from the configuration.
	 * Every subclass of the specified EClasses is ignored as well.
	 * 
	 * @return all EClasses that shall be ignored as a set
	 */
	protected static Set<EClass> getEClassesToIgnore() {
		Set<EClass> result = new LinkedHashSet<EClass>();
		for(EClass eClass : configuration.getEClassesToIgnore()) {
			result.add(eClass);
			result.addAll(ModelGeneratorUtil.getAllSubEClasses(eClass));
		}
		return result;
	}



	/**
	 * Returns all EClasses that can possibly created as children for <code>parentEClass</code>.
	 * The result is shuffled before it is returned, so different seeds cause different result.
	 * Only EClasses that are also contained in the configuration's <code>modelPackage</code>
	 * and not in the <code>eClassesToIgnore</code>-collection are retained.
	 * 
	 * @param parentEClass
	 * @return all possible child-EClasses as a list
	 * @see ModelGeneratorUtil#getAllEContainments(EClass)
	 * @see ModelGeneratorUtil#getAllEClasses(EPackage)
	 * @see getEClassesToIgnore
	 */
	protected static List<EClass> getElementsToCreate(EClass parentEClass) {
		if(ModelGeneratorHelper.eClassToElementsToCreate.containsKey(parentEClass)) {
			return ModelGeneratorHelper.eClassToElementsToCreate.get(parentEClass);
		} else {
			List<EClass> result = new LinkedList<EClass>(ModelGeneratorUtil.getAllEContainments(parentEClass));
			List<EClass> modelElementEClasses = ModelGeneratorUtil.getAllEClasses(configuration.getModelPackage());
			result.retainAll(modelElementEClasses);
			result.removeAll(eClassesToIgnore);
			Collections.shuffle(result, ModelGeneratorHelper.random);
			ModelGeneratorHelper.eClassToElementsToCreate.put(parentEClass, result);
			return result;
		}
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
	protected static List<EReference> getValidContainmentReferences(EClass childClass, EObject parentEObject) {
		List<EReference> result = new LinkedList<EReference>();
		for(EReference reference : ModelGeneratorUtil.getAllPossibleContainingReferences(childClass, parentEObject.eClass())) {
			if(reference.isChangeable() && (reference.isMany() || !parentEObject.eIsSet(reference)))
				result.add(reference);
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
	protected static int getStartingIndex(EClass eClass) {
		if(eClassToLastUsedIndex.containsKey(eClass)) {
			return eClassToLastUsedIndex.get(eClass);
		} else {
			return 0;
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
	protected static EClass getNextClassToCreate(List<EClass> elementsToCreate, int index) {
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

	public static void setReference(EObject eObject, EClass referenceClass, EReference reference,
		Map<EClass, List<EObject>> allEObjects) {
		ModelGeneratorUtil.setReference(eObject, referenceClass, reference, random, exceptionLog, configuration.getIgnoreAndLog(), allEObjects);
	}

	public static void updateIndex(EClass eClass, int index) {
		eClassToLastUsedIndex.put(eClass, index);
	}
	
	
}
