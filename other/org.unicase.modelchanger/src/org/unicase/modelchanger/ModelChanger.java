package org.unicase.modelchanger;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;

/**
 * Class for changing Ecore models automatically, static methods only.
 * Changing a model includes:<br>
 * - deleting random EObjects and all their children<br>
 * - replace attributes by new random values<br>
 * - replace references (no containment references) by new random values
 *
 *@see #generateChanges(ModelGeneratorConfiguration)
 */
public class ModelChanger {

	/**
	 * The configuration containing settings for the changing process. 
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
	 */
	private static AttributeHandler attributeHandler;
	
	/**
	 * All EObjects including the root and all its direct and indirect contents,
	 * after deleting random EObjects.
	 */
	private static Map<EClass, List<EObject>> allObjectsByEClass;
	
	/**
	 * A set of RuntimeExceptions that occurred during the last changing process.
	 */
	private static Set<RuntimeException> exceptions;
	
	/**
	 * Private constructor.
	 */
	private ModelChanger() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Changes EObjects using the settings specified in <code>configuration</code>.
	 * Changing includes deleting EObjects and their children and replacing all set
	 * attributes and references (no containment-references) with new values. 
	 * 
	 * @param configuration the ModelGeneratorConfiguration to use for changing EObjects
	 * @see ModelGeneratorConfiguration
	 * @see #generateChanges()
	 */
	public static void generateChanges(ModelGeneratorConfiguration configuration) {
		config = configuration;
		random = new Random(config.getSeed());
		attributeHandler = new AttributeHandler(random);
		Set<EObject> allChildren = new LinkedHashSet<EObject>();
		EObject rootObject = config.getRootEObject();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		while(allContents.hasNext()) {
			allChildren.add(allContents.next());
		}
		deleteRandomEObjects(allChildren);
		generateChanges();
	}
	
	/**
	 * Randomly deletes EObjects and their children from a set of EObjects.
	 * <code>allChildren</code> shouldn't contain the rootObject, so the
	 * root (and therefore ALL existing EObjects) doesn't get deleted.
	 * 
	 * @param allChildren set of EObjects from which EObjects are selected to be deleted
	 * @see #deleteAllChildren(EList)
	 */
	private static void deleteRandomEObjects(Set<EObject> allChildren) {
		Set<EObject> deletedChildren = new LinkedHashSet<EObject>();
		for(EObject eObject : allChildren) {
			if(deletedChildren.contains(eObject))
				continue;
			if(random.nextDouble() < 0.1) {
				deletedChildren.addAll(deleteAllChildren(eObject.eContents()));
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
	private static Set<EObject> deleteAllChildren(EList<EObject> children) {
		Set<EObject> allDeletedChildren = new LinkedHashSet<EObject>();
		for(EObject child : children) {
			allDeletedChildren.addAll(deleteAllChildren(child.eContents()));
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
	 * @see #generateChanges(ModelGeneratorConfiguration)
	 */
	private static void generateChanges() {
		allObjectsByEClass = ModelGeneratorUtil.getAllClassesAndObjects(config.getRootEObject());
		
		for(EClass eClass : allObjectsByEClass.keySet()) {
			for(EObject eObject : allObjectsByEClass.get(eClass)) {
				changeEObjectAttributes(eObject);
				changeEObjectReferences(eObject);
			}
		}
	}
	
	/**
	 * Sets all of <code>eObject</code>'s attributes to new values, discarding old ones.
	 * Therefore all values from many-valued attributes are removed using a RemoveCommand.
	 * Single-valued attributes are simply replaced.
	 * 
	 * @param eObject the EObject to change attributes for
	 * @see ModelGeneratorUtil#removePerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Collection, Set, boolean)
	 * @see ModelGeneratorUtil#setEObjectAttributes(EObject, AttributeHandler, Set, boolean)
	 */
	private static void changeEObjectAttributes(EObject eObject) {
		for(EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			if(attribute.isMany() && eObject.eIsSet(attribute)) {
				ModelGeneratorUtil.removePerCommand(eObject, attribute, (Collection<?>) eObject.eGet(attribute),
					exceptions, config.getIgnoreAndLog());
			}
		}
		ModelGeneratorUtil.setEObjectAttributes(eObject, attributeHandler,
			exceptions, config.getIgnoreAndLog());
	}

	/**
	 * Sets all of <code>eObject</code>'s references to new values, discarding old ones.
	 * Therefore all values from many-valued references are removed using a RemoveCommand.
	 * Single-valued references are simply replaced.
	 * 
	 * @param eObject the EObject to change references for
	 * @see ModelGeneratorUtil#removePerCommand(EObject, org.eclipse.emf.ecore.EStructuralFeature, Collection, Set, boolean)
	 * @see ModelGeneratorUtil#setReference(EObject, EClass, EReference, Random, Set, boolean, Map)
	 */
	private static void changeEObjectReferences(EObject eObject) {
		for(EReference reference : ModelGeneratorUtil.getValidReferences(eObject)) {
			if(reference.isMany() && eObject.eIsSet(reference)) {
				ModelGeneratorUtil.removePerCommand(eObject, reference, (Collection<?>) eObject.eGet(reference),
					exceptions, config.getIgnoreAndLog());
			}
			for(EClass nextReferenceClass : ModelGeneratorUtil.getReferenceClasses(reference, allObjectsByEClass.keySet())) {
				if(allObjectsByEClass.containsKey(nextReferenceClass)) {
					ModelGeneratorUtil.setReference(eObject, nextReferenceClass, reference, random,
						exceptions, config.getIgnoreAndLog(), allObjectsByEClass);
				}
			}
		}
	}
	
	/**
	 * Returns the Exception-Log for the last {@link #generateChanges()}
	 * The log is empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in the last configuration used.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last changing process
	 */
	public static Set<RuntimeException> getLog() {
		return exceptions;
	}
}
