/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;

/**
 * Helper class that takes work from <code>ModelGenerator</code>.
 * With the help of this class, <code>ModelGenerator</code> only
 * has to be aware of its current configuration. All methods
 * should be accessed in a static way and <code>init()</code>
 * has to be called every time before starting a generation process. 
 * 
 * @see ModelGenerator
 * @see #init(ModelGeneratorConfiguration)
 */
final class ModelGeneratorHelper {
	
	/**
	 * The configuration containing settings for the generation process.
	 * 
	 * @see ModelGeneratorConfiguration
	 */
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
	 * Random-object to compute random values for creating EObjects
	 * and setting their attributes and references.
	 */
	private static Random random;

	/**
	 * Private constructor.
	 */
	private ModelGeneratorHelper() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Initializes the helper for the next generation process.
	 * All private fields get new values, old ones are discarded.
	 * This also initializes <code>AttributeHandler</code>.
	 * 
	 * @param config the new configuration to use
	 * @see AttributeHandler#setRandom(Random)
	 */
	protected static void init(ModelGeneratorConfiguration config) {
		configuration = config;
		random = new Random(config.getSeed());
		exceptionLog = new LinkedHashSet<RuntimeException>();
		eClassesToIgnore = getEClassesToIgnore();
		eClassToElementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		eClassToLastUsedIndex = new LinkedHashMap<EClass, Integer>();
		AttributeHandler.setRandom(random);
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
	 * it as a child of <code>parentEObject</code> using AddCommand/SetCommand.
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

	/**
	 * Validates <code>rootEObject</code> so the root is a valid EObject instance.
	 * If <code>rootEObject</code> is valid already, it is just returned. Otherwise, 
	 * if <code>rootEObject</code> is an EClass (not abstract, no interface), it is 
	 * instantiated and its attributes are set. If none of the above is true, null is returned.
	 * 
	 * @param rootEObject the EObject to validate
	 * @return <code>null</code> if <code>rootEObject</code> is <code>null</code> or an
	 * abstract EClass or interface,<br>
	 * <code>rootEObject</code> if the root is already valid,<br>
	 * a new instance of <code>rootEObject</code> if it is an EClass
	 */
	protected static EObject validateRoot(EObject rootEObject) {
		if(rootEObject == null) {
			throw new IllegalArgumentException("Root mustn't be null!");
		}
		if(rootEObject instanceof EClass) {
			EClass parentClass = (EClass) rootEObject;
			if(parentClass.isInterface() || parentClass.isAbstract()) {
				throw new IllegalArgumentException("Root mustn't be abstract or an interface!");
			}
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
	 * @param parentEClass the EClass to compute the possible child EClasses for 
	 * @return all possible child-EClasses as a list
	 * @see ModelGeneratorUtil#getAllEContainments(EClass)
	 * @see ModelGeneratorUtil#getAllEClasses(EPackage)
	 * @see #getEClassesToIgnore()
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
	 * Stores the last used index of <code>eClass</code> in the 
	 * corresponding map for later use.
	 * 
	 * @param eClass the EClass to store the index for
	 * @param index the latest used index for that EClass
	 * @see #getStartingIndex(EClass)
	 */
	public static void updateIndex(EClass eClass, int index) {
		eClassToLastUsedIndex.put(eClass, index);
	}
	
	/**
	 * Returns an index that hasn't been used before, if existent.
	 * This prevents that an EClass always contains the same EClasses as children,
	 * where <code>eClass</code> is the parentEObject's EClass.
	 * 
	 * @param eClass the EClass to get the index for 
	 * @return the last used index or 0 if this EClass hasn't been instantiated before
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
		if(elementsToCreate.isEmpty()) {
			return null;
		}
		index %= elementsToCreate.size();
		EClass result = elementsToCreate.get(index);
		while(result.isInterface()|| result.isAbstract()) {
			elementsToCreate.remove(result);
			if(elementsToCreate.isEmpty()) {
				return null;
			}
			index %= elementsToCreate.size();
			result = elementsToCreate.get(index);
		}
		return result;
	}

	/**
	 * Sets a reference using {@link ModelGeneratorUtil#setReference}.
	 * 
	 * @param eObject the EObject to set the reference for
	 * @param referenceClass the EClass of EObjects that shall be referenced
	 * @param reference the EReference that shall be set
	 * @param allEObjects all possible EObjects that can be referenced
	 * @see ModelGeneratorUtil#setReference(EObject, EClass, EReference, Random, Set, boolean, Map)
	 */
	public static void setReference(EObject eObject, EClass referenceClass, EReference reference,
		Map<EClass, List<EObject>> allEObjects) {
		ModelGeneratorUtil.setReference(eObject, referenceClass, reference, random,
			exceptionLog, configuration.getIgnoreAndLog(), allEObjects);
	}
	
	/**
	 * Returns the Exception-Log of the <code>ModelGenerator</code>.
	 * The log is cleared after every {@link #init(ModelGeneratorConfiguration)}-call,
	 * i.e. before every generation process.
	 * The log will be empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in the last configuration used.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last generation process
	 */
	protected static Set<RuntimeException> getExceptionLog() {
		return exceptionLog;
	}
	
}
