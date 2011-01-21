package org.unicase.modelchanger;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;

/**
 * Class for changing Ecore models automatically, static methods only.
 * Changing a model includes:<br>
 * - deleting random EObjects and all their children<br>
 * - replace attributes by new random values<br>
 * - replace references (no containment references) by new random values
 *
 * @see #generateChanges(EObject)
 * @see #generateChanges(EObject, long, boolean)
 */
public class ModelChanger {
	
	/**
	 * Random-object to compute random values for deleting EObjects
	 * and setting their attributes and references.
	 */
	private static Random random;
	
	/**
	 * All EObjects including the root and all its direct and indirect contents,
	 * after deleting random EObjects.
	 */
	private static Map<EClass, List<EObject>> allObjectsByEClass;
	
	/**
	 * A set of RuntimeExceptions that occurred during the last changing process.
	 */
	private static Set<RuntimeException> exceptionLog;
	
	/**
	 * Private constructor.
	 */
	private ModelChanger() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Generates changes for the specified root and all its direct and indirect contents 
	 * using default values for <code>seed</code> and <code>ignoreAndLog</code>. 
	 * Changing includes deleting EObjects and their children and replacing all set
	 * attributes and references (no containment-references) with new values.
	 * 
	 * @param rootObject the root EObject
	 * @see #generateChanges(EObject, long, boolean)
	 * @see #generateChanges()
	 */
	public static void generateChanges(EObject rootObject) {
		generateChanges(rootObject, System.currentTimeMillis(), false);
	}
	
	/**
	 * Generates changes for the specified root and all its direct and indirect contents
	 * using <code>seed</code> to determine random values and <code>ignoreAndLog</code>
	 * to decide whether occurring RuntimeExceptions shall be thrown or logged only.
	 * Changing includes deleting EObjects and their children and replacing all set
	 * attributes and references (no containment-references) with new values. 
	 * 
	 * @param root the root EObject
	 * @param seed value to determine randomness
	 * @param ignoreAndLog should exceptions be ignored and added to the log?
	 * @see #generateChanges()
	 */
	public static void generateChanges(EObject root, long seed, boolean ignoreAndLog) {
		random = new Random(seed);
		AttributeHandler.setRandom(random);
		Set<EObject> allChildren = new LinkedHashSet<EObject>();
		EObject rootObject = root;
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		while(allContents.hasNext()) {
			allChildren.add(allContents.next());
		}
		deleteRandomEObjects(allChildren);
		allObjectsByEClass = ModelGeneratorUtil.getAllClassesAndObjects(rootObject);
		generateChanges(ignoreAndLog);
	}
	
	/**
	 * Randomly deletes EObjects and their children from a set of EObjects.
	 * <code>allChildren</code> shouldn't contain the rootObject, so the
	 * root (and therefore ALL existing EObjects) doesn't get deleted.
	 * 
	 * @param allChildren set of EObjects from which EObjects are selected to be deleted
	 * @see #deleteAllChildren(Set)
	 */
	private static void deleteRandomEObjects(Set<EObject> allChildren) {
		Set<EObject> deletedChildren = new LinkedHashSet<EObject>();
		for(EObject eObject : allChildren) {
			if(deletedChildren.contains(eObject))
				continue;
			if(random.nextDouble() < 0.1) {
				Set<EObject> contentCopy = new LinkedHashSet<EObject>(eObject.eContents());
				deletedChildren.addAll(deleteAllChildren(contentCopy));
				EcoreUtil.delete(eObject);
			}
		}
	}

	/**
	 * Deletes a list of EObjects and all their direct and indirect contents
	 * recursively.
	 * 
	 * @param children all children that should be deleted
	 * @return all deleted EObjects and all their direct and indirect contents
	 * @see #deleteRandomEObjects(Set)
	 */
	private static Set<EObject> deleteAllChildren(Set<EObject> children) {
		Set<EObject> allDeletedChildren = new LinkedHashSet<EObject>();
		for(EObject child : children) {
			Set<EObject> contentCopy = new LinkedHashSet<EObject>(child.eContents());
			allDeletedChildren.addAll(deleteAllChildren(contentCopy));
			EcoreUtil.delete(child);
			allDeletedChildren.add(child);
		}
		return allDeletedChildren;
	}

	/**
	 * Performs changes upon every EObject (the root and all its direct and indirect contents).
	 * Changing includes replacing attribute and reference values.
	 * Deleting EObjects is performed before this operation.
	 * 
	 * @param ignoreAndLog should exceptions be ignored and added to the log?
	 * @see #generateChanges(EObject)
	 * @see #generateChanges(EObject, long, boolean)
	 */
	private static void generateChanges(boolean ignoreAndLog) {
		for(EClass eClass : allObjectsByEClass.keySet()) {
			for(EObject eObject : allObjectsByEClass.get(eClass)) {
				changeEObjectAttributes(eObject, ignoreAndLog);
				changeEObjectReferences(eObject, ignoreAndLog);
			}
		}
	}
	
	/**
	 * Sets all of <code>eObject</code>'s attributes to new values, discarding old ones.
	 * Therefore all values from many-valued attributes are removed using a RemoveCommand.
	 * Single-valued attributes are simply replaced.
	 * 
	 * @param eObject the EObject to change attributes for
	 * @param ignoreAndLog should exceptions be ignored and added to the log?
	 * @see ModelGeneratorUtil#removePerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Collection, Set, boolean)
	 * @see ModelGeneratorUtil#setEObjectAttributes(EObject, AttributeHandler, Set, boolean)
	 */
	private static void changeEObjectAttributes(EObject eObject, boolean ignoreAndLog) {
		for(EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			if(attribute.isMany() && eObject.eIsSet(attribute)) {
				ModelGeneratorUtil.removePerCommand(eObject, attribute, (Collection<?>) eObject.eGet(attribute),
					exceptionLog, ignoreAndLog);
			}
		}
		ModelGeneratorUtil.setEObjectAttributes(eObject, exceptionLog, ignoreAndLog);
	}

	/**
	 * Sets all of <code>eObject</code>'s references to new values, discarding old ones.
	 * Therefore all values from many-valued references are removed using a RemoveCommand.
	 * Single-valued references are simply replaced.
	 * 
	 * @param eObject the EObject to change references for
	 * @param ignoreAndLog should exceptions be ignored and added to the log?
	 * @see ModelGeneratorUtil#removePerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Collection, Set, boolean)
	 * @see ModelGeneratorUtil#setReference(EObject, EClass, EReference, Random, Set, boolean, Map)
	 */
	private static void changeEObjectReferences(EObject eObject, boolean ignoreAndLog) {
		for(EReference reference : ModelGeneratorUtil.getValidReferences(eObject)) {
			if(reference.isMany() && eObject.eIsSet(reference)) {
				ModelGeneratorUtil.removePerCommand(eObject, reference, (Collection<?>) eObject.eGet(reference),
					exceptionLog, ignoreAndLog);
			}
			for(EClass nextReferenceClass : ModelGeneratorUtil.getReferenceClasses(reference, allObjectsByEClass.keySet())) {
				if(allObjectsByEClass.containsKey(nextReferenceClass)) {
					ModelGeneratorUtil.setReference(eObject, nextReferenceClass, reference, random,
						exceptionLog, ignoreAndLog, allObjectsByEClass);
				}
			}
		}
	}
	
	/**
	 * Returns the Exception-Log for the last {@link #generateChanges()}-call.
	 * The log is empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code>.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last changing process
	 */
	public static Set<RuntimeException> getLog() {
		return exceptionLog;
	}
}
