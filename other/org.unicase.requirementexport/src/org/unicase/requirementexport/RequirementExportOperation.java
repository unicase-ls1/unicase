/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.requirementexport;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.Project;
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
	 * @see #copyAll(List)
	 */
	private final Map<UnicaseModelElement, UnicaseModelElement> objectToCopy = new LinkedHashMap<UnicaseModelElement, UnicaseModelElement>();

	/**
	 * Copies a functional requirement to a project. Copying includes copying the requirement itself, all its
	 * refinements as well as all relevant references. These copies will be added to the target project and the
	 * references will be updated to remain equal to the original element's references.
	 * 
	 * @param req the {@link FunctionalRequirement} to copy
	 * @param targetProject the {@link Project} to copy to
	 * @see #determineElementsToCopy(FunctionalRequirement)
	 * @see #copyAll(List)
	 */
	public void copyFunctionalRequirement(FunctionalRequirement req, final Project targetProject) {
		List<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

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
	 * @see #copyAll(List)
	 */
	public void copyFunctionalRequirement(FunctionalRequirement req, final LeafSection targetSection) {
		List<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

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
	 * @see #copyAll(List)
	 */
	public void copyNonFunctionalRequirement(NonFunctionalRequirement req, final Project targetProject) {
		List<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

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
	 * @see #copyAll(List)
	 */
	public void copyNonFunctionalRequirement(NonFunctionalRequirement req, final LeafSection targetSection) {
		List<UnicaseModelElement> elementsToCopy = determineElementsToCopy(req);

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
	private List<UnicaseModelElement> determineElementsToCopy(FunctionalRequirement req) {
		// allRequirements := all the requirements that need to be checked
		List<FunctionalRequirement> allRequirements = new LinkedList<FunctionalRequirement>();
		List<UnicaseModelElement> result = new LinkedList<UnicaseModelElement>();
		allRequirements.add(req);

		while (!allRequirements.isEmpty()) {
			// update requirements that need to be checked: remove current and add refinements
			req = allRequirements.remove(0);
			allRequirements.addAll(req.getRefiningRequirements());

			// update result: add the requirement and all its relevant references
			result.add(req);
			result.addAll(req.getAnnotations());
			result.addAll(req.getAppliedStereotypeInstances());
			result.addAll(req.getAttachments());
			result.addAll(req.getComments());
			result.addAll(req.getIncomingDocumentReferences());
			result.addAll(req.getScenarios());
			result.addAll(req.getUseCases());
			result.add(req.getStakeholder());
		}

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
	private List<UnicaseModelElement> determineElementsToCopy(NonFunctionalRequirement req) {
		List<UnicaseModelElement> result = new LinkedList<UnicaseModelElement>();

		result.add(req);
		result.addAll(req.getAnnotations());
		result.addAll(req.getAppliedStereotypeInstances());
		result.addAll(req.getAttachments());
		result.addAll(req.getComments());
		result.addAll(req.getIncomingDocumentReferences());
		result.addAll(req.getAssessments());
		result.addAll(req.getRestrictedScenarios());
		result.addAll(req.getRestrictedUseCases());
		result.addAll(req.getSystemFunctions());
		result.addAll(req.getUserTasks());

		return result;
	}

	/**
	 * Copies all elements specified by using {@link EcoreUtil#copy(EObject)} and fills the {@link #objectToCopy} map in
	 * the process.
	 * 
	 * @param elementsToCopy the elements to copy
	 */
	private void copyAll(List<UnicaseModelElement> elementsToCopy) {
		for (UnicaseModelElement modelElement : elementsToCopy) {
			// copy each element only once
			if (modelElement == null || objectToCopy.containsKey(modelElement)) {
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
