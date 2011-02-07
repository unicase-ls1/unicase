/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.modelchanger;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;

/**
 * Helper class that takes work from <code>ModelChanger</code>.
 * With the help of this class, <code>ModelChanger</code> only 
 * has to be aware of the current root EObject. All methods
 * should be accessed in a static way and <code>init()</code>
 * has to be called every time before starting a changing process.
 * 
 * @see ModelChanger
 * @see #init(long, boolean)
 */
final class ModelChangerHelper {
	
	/**
	 * Random-object to compute random values for deleting EObjects
	 * and setting their attributes and references.
	 */	
	private static Random random;
	
	/**
	 * The amount of work in units as an integer, used by the 
	 * <code>ModelChanger</code>'s monitor to show the correct
	 * progress in the progress bar.
	 * 
	 * @see #getAmountOfWork()
	 */
	private static int amountOfWork;
	
	/**
	 * Specifies whether exceptions should be caught and logged during the changing
	 * process. Initialized during {@link #init(long, boolean)}.
	 */
	private static boolean ignoreAndLog;
	
	/**
	 * A set of RuntimeExceptions that occurred during the last changing process.
	 */
	private static Set<RuntimeException> exceptionLog;
	
	/**
	 * Private Constructor.
	 */
	private ModelChangerHelper() {
		// all methods should be accessed in a static way
	}

	/**
	 * Initializes the helper to prepare it for the next changing process.
	 * All private fields get new values, old ones are discarded.
	 * This also initializes <code>AttributeHandler</code>.
	 * 
	 * @param seed the seed value used to generate random values
	 * @param ignoreExceptions should exceptions be ignored and logged?
	 * @see AttributeHandler#setRandom(Random)
	 */
	protected static void init(long seed, boolean ignoreExceptions) {
		random = new Random(seed);
		amountOfWork = 0;
		ignoreAndLog = ignoreExceptions;
		exceptionLog = new LinkedHashSet<RuntimeException>();
		AttributeHandler.setRandom(random);
	}

	/**
	 * Retrieves all children, direct and indirect, and returns them
	 * as a set. The <code>amountOfWork</code> for the progress monitor
	 * is also computed in this method. Every EObject is counted three times:
	 * Once for the deletion process, once for changing its attributes
	 * and once for changing its references.
	 * 
	 * @param root the root EObject of the hierarchy
	 * @return all direct and indirect contents of <code>root</code>
	 */
	protected static Set<EObject> getAllChildren(EObject root) {
		TreeIterator<EObject> allContents = root.eAllContents();
		Set<EObject> result = new LinkedHashSet<EObject>();
		while(allContents.hasNext()) {
			result .add(allContents.next());
			amountOfWork += 3;
		}
		return result;
	}
	
	/**
	 * Returns the amount of work, that was computed before when
	 * obtaining all children with {@link #getAllChildren}.
	 * 
	 * @return the amount of work in units as an integer
	 * @see #amountOfWork
	 * @see #getAllChildren
	 */
	protected static int getAmountOfWork() {
		return amountOfWork;
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
	protected static void setReference(EObject eObject, EClass referenceClass, EReference reference,
		Map<EClass, List<EObject>> allEObjects) {
		ModelGeneratorUtil.setReference(eObject, referenceClass, reference, random,
			exceptionLog, ignoreAndLog, allEObjects);
	}

	/**
	 * Clears an EObject's feature, that is removes all objects from a many-valued
	 * feature. If the target is single-valued, nothing is done.
	 * 
	 * @param eObject the EObject to clear the feature for
	 * @param feature the EStructuralFeature that shall be cleared
	 */
	protected static void clear(EObject eObject, EStructuralFeature feature) {
		if(feature.isMany() && eObject.eIsSet(feature)) {
			ModelGeneratorUtil.removePerCommand(eObject, feature, (Collection<?>) eObject.eGet(feature),
				exceptionLog, ignoreAndLog);
		}
		
	}

	/**
	 * Sets attributes of an EObject using {@link ModelGeneratorUtil#setEObjectAttributes()}.
	 * 
	 * @param eObject the EObject to set attributes for
	 * @see ModelGeneratorUtil#setEObjectAttributes(EObject, Set, boolean)
	 */
	protected static void setEObjectAttributes(EObject eObject) {
		ModelGeneratorUtil.setEObjectAttributes(eObject, exceptionLog, ignoreAndLog);
	}

	/**
	 * @return a random value, that specifies whether an EObject shall
	 * be deleted or not
	 */
	protected static boolean randomDelete() {
		return random.nextDouble() < 0.1;
	}
	
	/**
	 * Returns the Exception-Log of the <code>ModelChanger</code>.
	 * The log is cleared after every {@link #init}-call, i.e. before every changing process.
	 * The log will be empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in <code>init</code>.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last changing process
	 */
	protected static Set<RuntimeException> getExceptionLog() {
		return exceptionLog;
	}

}
