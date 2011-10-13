/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.requirementexport;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This class defines the operations required to export a functional or non-functional requirement from one project to
 * another.
 * 
 * @see #copyFunctionalRequirement(FunctionalRequirement, Project)
 * @see #copyFunctionalRequirement(FunctionalRequirement, LeafSection)
 * @see #copyNonFunctionalRequirement(FunctionalRequirement, Project)
 * @see #copyNonFunctionalRequirement(FunctionalRequirement, LeafSection)
 * @author mharut
 */
public class RequirementExportOperation {

	/**
	 * Map from original elements to their copies.
	 * 
	 * @see #copyAll(Collection)
	 */
	private final Map<UnicaseModelElement, UnicaseModelElement> objectToCopy = new HashMap<UnicaseModelElement, UnicaseModelElement>();

	/**
	 * Map from elements to the objects that reference them.
	 * 
	 * @see #determineCrossReferences(Project)
	 */
	private final Map<EObject, Set<EObject>> objectToReferencingObjects = new HashMap<EObject, Set<EObject>>();

	/**
	 * Copies a functional requirement to a project. Copying includes copying the requirement itself, all its
	 * refinements as well as all relevant references. These copies will be added to the target project and the
	 * references will be updated to remain equal to the original element's references.
	 * 
	 * @param req the {@link FunctionalRequirement} to copy
	 * @param targetProject the {@link Project} to copy to
	 * @see #determineElementsToCopy(FunctionalRequirement)
	 * @see #copyAll(Collection)
	 */
	public void copyFunctionalRequirement(FunctionalRequirement req, final Project targetProject) {
		Collection<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

		copyAll(elementsToCopy);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// add all copies first
				for (UnicaseModelElement copy : objectToCopy.values()) {
					targetProject.addModelElement(copy);
				}
				// update references after adding the elements
				updateReferences();
			}

		}.run(true);

	}

	/**
	 * Copies a functional requirement to a leaf section. Copying includes copying the requirement itself, all its
	 * refinements as well as all relevant references. These copies will be added to the target section, and the
	 * references will be updated to remain equal to the original element's references.
	 * 
	 * @param req the {@link FunctionalRequirement} to copy
	 * @param targetSection the {@link LeafSection} to copy to
	 * @see #determineElementsToCopy(FunctionalRequirement)
	 * @see #copyAll(Collection)
	 */
	public void copyFunctionalRequirement(FunctionalRequirement req, final LeafSection targetSection) {
		Collection<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

		copyAll(elementsToCopy);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// add all copies first
				for (UnicaseModelElement copy : objectToCopy.values()) {
					targetSection.getModelElements().add(copy);
				}
				// update references after adding the elements
				updateReferences();
			}

		}.run(true);
	}

	/**
	 * Copies a non-functional requirement to a project. Copying includes copying the requirement itself as well as all
	 * relevant references. These copies will be added to the target project and the references will be updated to
	 * remain equal to the original element's references.
	 * 
	 * @param req the {@link NonFunctionalRequirement} to copy
	 * @param targetProject the {@link Project} to copy to
	 * @see #determineElementsToCopy(NonFunctionalRequirement)
	 * @see #copyAll(Collection)
	 */
	public void copyNonFunctionalRequirement(NonFunctionalRequirement req, final Project targetProject) {
		Collection<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

		copyAll(elementsToCopy);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// add all copies first
				for (UnicaseModelElement copy : objectToCopy.values()) {
					targetProject.addModelElement(copy);
				}
				// update references after adding the elements
				updateReferences();
			}

		}.run(true);

	}

	/**
	 * Copies a non-functional requirement to a leaf section. Copying includes copying the requirement itself as well as
	 * all relevant references. These copies will be added to the target section and the references will be updated to
	 * remain equal to the original element's references.
	 * 
	 * @param req the {@link NonFunctionalRequirement} to copy
	 * @param targetSection the {@link LeafSection} to copy to
	 * @see #determineElementsToCopy(NonFunctionalRequirement)
	 * @see #copyAll(Collection)
	 */
	public void copyNonFunctionalRequirement(NonFunctionalRequirement req, final LeafSection targetSection) {
		Collection<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

		copyAll(elementsToCopy);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// add all copies first
				for (UnicaseModelElement copy : objectToCopy.values()) {
					targetSection.getModelElements().add(copy);
				}
				// update references after adding the elements
				updateReferences();
			}

		}.run(true);

	}

	/**
	 * Determines all elements that have to be included in the copy-process for a functional requirement. These elements
	 * include:
	 * <ul>
	 * <li>the {@link FunctionalRequirement requirement} itself</li>
	 * <li>all its {@link FunctionalRequirement#getRefiningRequirements() refinements}</li>
	 * <li>all their {@link FunctionalRequirement#getAnnotations() annotations}</li>
	 * <li>all their {@link FunctionalRequirement#getAppliedStereotypeInstances() applied stereotype instances}</li>
	 * <li>all their {@link FunctionalRequirement#getAttachments() attachments}</li>
	 * <li>all their {@link FunctionalRequirement#getComments() comments}</li>
	 * <li>all their {@link FunctionalRequirement#getIncomingDocumentReferences() incoming document references}</li>
	 * <li>all their {@link FunctionalRequirement#getScenarios() scenarios}</li>
	 * <li>all their {@link FunctionalRequirement#getUseCases() use cases}</li>
	 * <li>and each {@link FunctionalRequirement#getStakeholder() stakeholder}</li>
	 * </ul>
	 * 
	 * @param req the {@link FunctionalRequirement} to determine the elements for
	 * @return all elements that have to be copied
	 */
	private Set<UnicaseModelElement> determineElementsToCopy(FunctionalRequirement req) {
		determineCrossReferences(ModelUtil.getProject(req));

		// allRequirements := all the requirements that need to be checked
		List<FunctionalRequirement> allRequirements = new LinkedList<FunctionalRequirement>();
		Set<UnicaseModelElement> tempResult = new HashSet<UnicaseModelElement>();
		allRequirements.add(req);

		while (!allRequirements.isEmpty()) {
			// update requirements that need to be checked: remove current and add refinements
			req = allRequirements.remove(0);
			allRequirements.addAll(req.getRefiningRequirements());

			// update result: add the requirement and all its relevant references
			tempResult.add(req);
			tempResult.addAll(req.getAnnotations());
			tempResult.addAll(req.getAppliedStereotypeInstances());
			tempResult.addAll(req.getAttachments());
			tempResult.addAll(req.getComments());
			tempResult.addAll(req.getIncomingDocumentReferences());
			tempResult.addAll(req.getScenarios());
			tempResult.addAll(req.getUseCases());
			tempResult.add(req.getStakeholder());
		}
		Set<UnicaseModelElement> result = findAllReferencingObjects(tempResult);

		return result;
	}

	/**
	 * Determines all elements that have to be included in the copy-process for a non-functional requirement. These
	 * elements include:
	 * <ul>
	 * <li>the {@link NonFunctionalRequirement requirement} itself</li>
	 * <li>all its {@link NonFunctionalRequirement#getAnnotations() annotations}</li>
	 * <li>all its {@link NonFunctionalRequirement#getAppliedStereotypeInstances() applied stereotype instances}</li>
	 * <li>all its {@link NonFunctionalRequirement#getAttachments() attachments}</li>
	 * <li>all its {@link NonFunctionalRequirement#getComments() comments}</li>
	 * <li>all its {@link NonFunctionalRequirement#getIncomingDocumentReferences() incoming document references}</li>
	 * <li>all its {@link NonFunctionalRequirement#getAssessments() assessments}</li>
	 * <li>all its {@link NonFunctionalRequirement#getRestrictedScenarios() restricted scenarios}</li>
	 * <li>all its {@link NonFunctionalRequirement#getRestrictedUseCases() restricted use cases}</li>
	 * <li>all its {@link NonFunctionalRequirement#getSystemFunctions() system functions}</li>
	 * <li>and all its {@link NonFunctionalRequirement#getUserTasks() user tasks}</li>
	 * </ul>
	 * 
	 * @param req the {@link NonFunctionalRequirement} to determine the elements for
	 * @return all elements that have to be copied
	 */
	private Set<UnicaseModelElement> determineElementsToCopy(NonFunctionalRequirement req) {
		determineCrossReferences(ModelUtil.getProject(req));

		Set<UnicaseModelElement> tempResult = new HashSet<UnicaseModelElement>();

		tempResult.add(req);
		tempResult.addAll(req.getAnnotations());
		tempResult.addAll(req.getAppliedStereotypeInstances());
		tempResult.addAll(req.getAttachments());
		tempResult.addAll(req.getComments());
		tempResult.addAll(req.getIncomingDocumentReferences());
		tempResult.addAll(req.getAssessments());
		tempResult.addAll(req.getRestrictedScenarios());
		tempResult.addAll(req.getRestrictedUseCases());
		tempResult.addAll(req.getSystemFunctions());
		tempResult.addAll(req.getUserTasks());

		Set<UnicaseModelElement> result = findAllReferencingObjects(tempResult);

		return result;
	}

	/**
	 * Determines all cross references in a project, i.e. which element has is referenced from other elements.
	 * 
	 * @param project the project to determine the references for
	 * @see #objectToReferencingObjects
	 */
	@SuppressWarnings("unchecked")
	private void determineCrossReferences(Project project) {
		/*
		 * algorithm: for every model element, find all referenced objects. To every of these referenced objects, add
		 * the model element as a referencing object.
		 */
		for (EObject eObject : project.getAllModelElements()) {
			for (EReference eReference : eObject.eClass().getEAllReferences()) {
				if (eReference.isMany()) {
					List<EObject> referencedObjects = (List<EObject>) eObject.eGet(eReference);
					for (EObject referencedObject : referencedObjects) {
						Collection<EObject> referencingObjects = objectToReferencingObjects.get(referencedObject);
						if (referencingObjects == null) {
							Set<EObject> result = new HashSet<EObject>();
							result.add(eObject);
							objectToReferencingObjects.put(referencedObject, result);
						} else if (!referencingObjects.contains(eObject)) {
							referencingObjects.add(eObject);
						}
					}
				} else {
					EObject referencedObject = (EObject) eObject.eGet(eReference);
					Collection<EObject> referencingObjects = objectToReferencingObjects.get(referencedObject);
					if (referencingObjects == null) {
						Set<EObject> result = new HashSet<EObject>();
						result.add(eObject);
						objectToReferencingObjects.put(referencedObject, result);
					} else if (!referencingObjects.contains(eObject)) {
						referencingObjects.add(eObject);
					}
				}
			}
		}
	}

	/**
	 * Finds all objects that have references to objects contained in <code>modelElements</code>. The result will
	 * contain all these objects as well as all original model elements.
	 * 
	 * @param modelElements the model elements to find the referencing objects for
	 * @return a set of all objects referencing any of the <code>modelElements</code> as well as the model elements
	 *         themselves.
	 */
	private Set<UnicaseModelElement> findAllReferencingObjects(Set<UnicaseModelElement> modelElements) {
		Set<UnicaseModelElement> result = new HashSet<UnicaseModelElement>();
		for (UnicaseModelElement modelElement : modelElements) {
			// prohibit null elements
			if (modelElement == null) {
				continue;
			}
			result.add(modelElement);
			Collection<EObject> referencingObjects = objectToReferencingObjects.get(modelElement);
			if (referencingObjects != null) {
				for (EObject referencingObject : referencingObjects) {
					// only allow unicase model elements so they can be added to leaf sections
					if (referencingObject != null && referencingObject instanceof UnicaseModelElement) {
						result.add((UnicaseModelElement) referencingObject);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Copies all elements specified by using {@link EcoreUtil#copy(EObject)} and fills the {@link #objectToCopy} map in
	 * the process.
	 * 
	 * @param elementsToCopy the elements to copy
	 */
	private void copyAll(Collection<UnicaseModelElement> elementsToCopy) {
		for (UnicaseModelElement modelElement : elementsToCopy) {
			// copy each element only once
			if (objectToCopy.containsKey(modelElement)) {
				continue;
			}

			// remember which copy belongs to which element
			UnicaseModelElement copy = EcoreUtil.copy(modelElement);
			objectToCopy.put(modelElement, copy);
		}
	}

	/**
	 * Updates references for all copies of the {@link #objectToCopy} map so they equal the references from the original
	 * elements.
	 */
	@SuppressWarnings("unchecked")
	private void updateReferences() {
		// for every original element...
		for (UnicaseModelElement modelElement : objectToCopy.keySet()) {

			EObject copy = objectToCopy.get(modelElement);
			// for every of the original element's references...
			for (EReference eReference : modelElement.eClass().getEAllReferences()) {
				// ignore container references
				if (eReference.isContainer()) {
					continue;
				}

				if (eReference.isMany()) {

					List<EObject> referencedObjects = (List<EObject>) modelElement.eGet(eReference, true);
					List<EObject> result = new LinkedList<EObject>();
					for (EObject referencedObject : referencedObjects) {
						// only add objects that were copied
						EObject referencedCopy = objectToCopy.get(referencedObject);
						if (referencedCopy != null) {
							result.add(referencedCopy);
						}
					}

					// update references on the copied element
					copy.eSet(eReference, result);

				} else {
					EObject referencedObject = (EObject) modelElement.eGet(eReference, true);
					// referencedCopy may be null
					EObject referencedCopy = objectToCopy.get(referencedObject);

					// update references on the copied element
					copy.eSet(eReference, referencedCopy);
				}
			}
		}

	}

}
