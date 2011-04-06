/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;


public class CommonUtil {
	
	private static Set<EClass> modelElementEClasses;

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| eReferenceType.isSuperTypeOf(newMEInstance.eClass())) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
	
	/**
	 * Gives all eClasses which can be contained in a given eClass.
	 * 
	 * @param eClass the EClass
	 * @return all Classes which can be contained
	 */
	public static Set<EClass> getAllEContainments(EClass eClass) {
		List<EReference> containments = eClass.getEAllContainments();
		Set<EClass> eClazz = new HashSet<EClass>();
		for (EReference ref : containments) {
			EClass eReferenceType = ref.getEReferenceType();
			eClazz.addAll(getAllSubEClasses(eReferenceType));
		}
		return eClazz;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		if (EcorePackage.eINSTANCE.getEObject().equals(eClass)) {
			return allEClasses;
		}
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {
			boolean isSuperTypeOf = eClass.isSuperTypeOf(subClass)
				|| eClass.equals(EcorePackage.eINSTANCE.getEObject());
			if (isSuperTypeOf && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package registry that are model element subclasses.
	 * 
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return new HashSet<EClass>(modelElementEClasses);
		}
		Set<EClass> result = new HashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new HashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				Activator.getDefault().logException("Failed to load model package " + entry.getKey(), exception);
				// END SUPRESS CATCH EXCEPTION
			}

		}
		modelElementEClasses = result;
		return result;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package that are model element subclasses.
	 * 
	 * @param ePackage the package to get the classes from
	 * @return a set of EClasses
	 */
	private static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		Set<EClass> result = new HashSet<EClass>();
		for (EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass subEClass = (EClass) classifier;
				result.add(subEClass);
			}
		}
		return result;
	}
		
	/**
	 * Get the EContainer that contains the given model element and whose EContainer is null.
	 * 
	 * @param parent the Class of the parent
	 * @param child the model element whose container should get returned
	 * @return the container
	 */
	public static <T extends EObject>  T getParent(Class<T> parent, EObject child) {
		Set<EObject> seenModelElements = new HashSet<EObject>();
		seenModelElements.add(child);
		return getParent(parent, child, seenModelElements);
	}

	@SuppressWarnings("unchecked")
	private static <T extends EObject> T getParent(Class<T> parent, EObject child, Set<EObject> seenModelElements) {
		if (child == null) {
			return null;
		}

		if (seenModelElements.contains(child.eContainer())) {
			throw new IllegalStateException("ModelElement is in a containment cycle");
		}

		if (parent.isInstance(child)) {
			return (T) child;
		} else {
			seenModelElements.add(child);
			return getParent(parent, child.eContainer(), seenModelElements);
		}
	}


	/**
	 * Check an Eobject and its containment tree whether it is selfcontained. A containment tree is self contained if it
	 * does not have references to eobjects outside the tree.
	 * 
	 * @param object the eObject
	 * @return true if it is selfcontained
	 */
	public static boolean isSelfContained(EObject object) {
		return isSelfContained(object, false);
	}

	/**
	 * Check an EObject and its containment tree whether it is self-contained. A containment tree is self contained if
	 * it does not have references to EObjects outside the tree.
	 * 
	 * @param object the eObject
	 * @param ignoreContainer true if references of object to its container should be ignored in the check.
	 * @return true if it is self0contained
	 */
	public static boolean isSelfContained(EObject object, boolean ignoreContainer) {
		Set<EObject> allChildEObjects = getNonTransientContents(object);
		Set<EObject> allEObjects = new HashSet<EObject>(allChildEObjects);
		allEObjects.add(object);

		Set<EObject> nonTransientCrossReferences = getNonTransientCrossReferences(object);
		if (ignoreContainer && object.eContainer() != null) {
			nonTransientCrossReferences.remove(object.eContainer());
		}
		if (!allEObjects.containsAll(nonTransientCrossReferences)) {
			return false;
		}

		// TOOD: EM, handle ignored data types here
		// check if only cross references to known elements exist
		// for (EObject content : allChildEObjects) {
		// if (!allEObjects.containsAll(getNonTransientCrossReferences(content))) {
		// return false;
		// }
		// }
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private static Set<EObject> getNonTransientContents(EObject object) {
		Set<EObject> result = new HashSet<EObject>();
		if (object == null) {
			return result;
		}
		for (EReference containmentReference : object.eClass().getEAllContainments()) {
			if (!containmentReference.isTransient()) {
				Object contentObject = object.eGet(containmentReference, true);
				if (containmentReference.isMany()) {
					EList<? extends EObject> contentList = (EList<? extends EObject>) contentObject;
					for (EObject content : contentList) {
						result.add(content);
						result.addAll(getNonTransientContents(content));
					}
				} else {
					EObject content = (EObject) contentObject;
					if (content == null) {
						continue;
					}
					result.add(content);
					result.addAll(getNonTransientContents(content));
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static Set<EObject> getNonTransientCrossReferences(EObject object) {
		Set<EObject> result = new HashSet<EObject>();
		if (object == null) {
			return result;
		}
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (!reference.isTransient() && !reference.isContainment()) {
				Object referenceObject = object.eGet(reference, true);
				if (reference.isMany()) {
					EList<? extends EObject> referencesList = (EList<? extends EObject>) referenceObject;
					result.addAll(referencesList);
					for (EObject ref : referencesList) {
						if (CommonUtil.isSingletonEObject(ref)) {
							continue;
						}

						result.add(ref);
					}

				} else {
					EObject crossReference = (EObject) referenceObject;
					if (crossReference == null || CommonUtil.isSingletonEObject(crossReference)) {
						continue;
					}
					result.add(crossReference);
				}
			}
		}
		return result;
	}
	
	/**
	 * Determines whether an EObject is a singleton object. All EObjects being children of ECorePackage are considered
	 * as singletons.
	 */
	public static boolean isSingletonEObject(EObject eObject) {
		if (eObject.eContainer() != null && eObject.eContainer().equals(EcorePackage.eINSTANCE)) {
			return true;
		}

		return false;
	}

	// Validates if the EObjects can be imported
	private static Set<EObject> validation(Resource resource, List<String> errorStrings) {
		Set<EObject> childrenSet = new HashSet<EObject>();
		Set<EObject> rootNodes = new HashSet<EObject>();

		TreeIterator<EObject> contents = resource.getAllContents();

		// 1. Run: Put all children in set
		while (contents.hasNext()) {
			EObject content = contents.next();
			childrenSet.addAll(content.eContents());
		}

		contents = resource.getAllContents();

		// 2. Run: Check if RootNodes are children -> set.contains(RootNode) -- no: RootNode in rootNode-Set -- yes:
		// Drop RootNode, will be imported as a child
		while (contents.hasNext()) {
			EObject content = contents.next();

			if (!childrenSet.contains(content)) {
				rootNodes.add(content);
			}
		}

		// 3. Check if RootNodes are SelfContained -- yes: import -- no: error
		Set<EObject> notSelfContained = new HashSet<EObject>();
		for (EObject rootNode : rootNodes) {
			if (!CommonUtil.isSelfContained(rootNode)) {
				errorStrings.add(rootNode + " is not self contained\n");
				notSelfContained.add(rootNode);
			}
		}
		rootNodes.removeAll(notSelfContained);

		return rootNodes;
	}
	

	/**
	 * Loads a Set of EObject from a given resource. Content which couldn't be loaded creates a error string which will
	 * be added to the errorStrings list. After the return from the method to the caller the return value contains the
	 * loaded EObjects.
	 * 
	 * @param resource contains the items which should be loaded.
	 * @param errorStrings contains all messages about items which couldn't be loaded by the method.
	 * @return Set with the loaded an valid EObjects
	 */
	public static Set<EObject> loadFromResource(Resource resource, List<String> errorStrings) {
		Set<EObject> result = new HashSet<EObject>();

		result = validation(resource, errorStrings);

		return result;
	}
}
