/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Test creating an deleting elements.
 * 
 * @author koegel
 */
public class CreateDeleteOperationTest extends WorkspaceTest {

	/**
	 * Test element creation tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void createElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;

		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);

		assertEquals(useCaseId, createDeleteOperation.getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(false, createDeleteOperation.isDelete());
	}

	/**
	 * check element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void deleteElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				clearOperations();
			}
		}.run(false);

		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().deleteModelElement(useCase);
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;

		assertEquals(useCaseId, createDeleteOperation.getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(true, createDeleteOperation.isDelete());
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 * @throws IOException
	 */
	@Test
	// BEGIN COMPLEX CODE
	public void complexDeleteElementTest() throws UnsupportedOperationException, UnsupportedNotificationException,
		IOException {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		final Actor newActor = RequirementFactory.eINSTANCE.createActor();
		final Actor otherActor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(useCase);
				section.getModelElements().add(oldActor);
				getProject().addModelElement(newActor);
				getProject().addModelElement(otherActor);
				useCase.setInitiatingActor(oldActor);
				useCase.getParticipatingActors().add(newActor);
				useCase.getParticipatingActors().add(otherActor);
				assertEquals(true, getProject().containsInstance(useCase));
				assertEquals(getProject(), ModelUtil.getProject(useCase));
				clearOperations();
			}
		}.run(false);

		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().deleteModelElement(useCase);
			}
		}.run(false);

		assertEquals(false, getProject().containsInstance(useCase));
		// assertEquals(null, useCase.eContainer());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());

		assertEquals(useCaseId, createDeleteOperation.getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();

		assertEquals(7, subOperations.size());
		AbstractOperation subOperation0 = subOperations.get(0);
		AbstractOperation subOperation1 = subOperations.get(1);
		AbstractOperation subOperation2 = subOperations.get(2);
		AbstractOperation subOperation3 = subOperations.get(3);
		AbstractOperation subOperation4 = subOperations.get(4);
		AbstractOperation subOperation5 = subOperations.get(5);
		AbstractOperation subOperation6 = subOperations.get(6);

		assertEquals(true, subOperation0 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation1 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation2 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation3 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation4 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation5 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation6 instanceof MultiReferenceOperation);

		MultiReferenceOperation mrSubOperation0 = (MultiReferenceOperation) subOperation0;
		SingleReferenceOperation mrSubOperation1 = (SingleReferenceOperation) subOperation1;
		MultiReferenceOperation mrSubOperation2 = (MultiReferenceOperation) subOperation2;
		MultiReferenceOperation mrSubOperation3 = (MultiReferenceOperation) subOperation3;
		MultiReferenceOperation mrSubOperation4 = (MultiReferenceOperation) subOperation4;
		SingleReferenceOperation mrSubOperation5 = (SingleReferenceOperation) subOperation5;
		MultiReferenceOperation mrSubOperation6 = (MultiReferenceOperation) subOperation6;

		assertEquals("initiatedUseCases", mrSubOperation0.getFeatureName());
		assertEquals(0, mrSubOperation0.getIndex());

		ModelElementId oldActorId = ModelUtil.getProject(oldActor).getModelElementId(oldActor);
		ModelElementId otherActorId = ModelUtil.getProject(otherActor).getModelElementId(otherActor);
		ModelElementId newActorId = ModelUtil.getProject(newActor).getModelElementId(newActor);
		ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);

		assertEquals(oldActorId, mrSubOperation0.getModelElementId());
		assertEquals("initiatingActor", mrSubOperation0.getOppositeFeatureName());
		assertEquals(false, mrSubOperation0.isAdd());
		assertEquals(true, mrSubOperation0.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements0 = mrSubOperation0.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		EList<ModelElementId> referencedModelElements0 = mrSubOperation0.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCaseId, referencedModelElements0.get(0));

		assertEquals(oldActorId, mrSubOperation1.getOldValue());
		assertEquals(null, mrSubOperation1.getNewValue());
		assertEquals("initiatingActor", mrSubOperation1.getFeatureName());
		assertEquals(useCaseId, mrSubOperation1.getModelElementId());
		assertEquals("initiatedUseCases", mrSubOperation1.getOppositeFeatureName());
		assertEquals(true, mrSubOperation1.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = mrSubOperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActorId, otherInvolvedModelElements.iterator().next());

		assertEquals(newActorId, mrSubOperation2.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation2.getFeatureName());
		assertEquals(false, mrSubOperation2.isAdd());
		assertEquals(1, mrSubOperation2.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation2.getReferencedModelElements().get(0));

		assertEquals(otherActorId, mrSubOperation3.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation3.getFeatureName());
		assertEquals(false, mrSubOperation3.isAdd());
		assertEquals(1, mrSubOperation3.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation3.getReferencedModelElements().get(0));

		assertEquals("participatingActors", mrSubOperation4.getFeatureName());
		assertEquals(-1, mrSubOperation4.getIndex());
		assertEquals(useCaseId, mrSubOperation4.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation4.getOppositeFeatureName());
		assertEquals(false, mrSubOperation4.isAdd());
		assertEquals(true, mrSubOperation4.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2 = mrSubOperation4.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements2.size());
		EList<ModelElementId> referencedModelElements = mrSubOperation4.getReferencedModelElements();
		assertEquals(2, referencedModelElements.size());
		assertEquals(newActorId, referencedModelElements.get(0));
		assertEquals(otherActorId, referencedModelElements.get(1));

		assertEquals(useCaseId, mrSubOperation5.getModelElementId());
		assertEquals("leafSection", mrSubOperation5.getFeatureName());
		assertEquals(sectionId, mrSubOperation5.getOldValue());
		assertEquals(null, mrSubOperation5.getNewValue());

		assertEquals("modelElements", mrSubOperation6.getFeatureName());
		assertEquals(0, mrSubOperation6.getIndex());
		assertEquals(sectionId, mrSubOperation6.getModelElementId());
		assertEquals("leafSection", mrSubOperation6.getOppositeFeatureName());
		assertEquals(false, mrSubOperation6.isAdd());
		assertEquals(true, mrSubOperation6.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements3 = mrSubOperation6.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		EList<ModelElementId> referencedModelElements3 = mrSubOperation6.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCaseId, referencedModelElements3.get(0));

		// ((ProjectSpaceImpl) getProjectSpace()).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(WorkspacePackage.eINSTANCE
			.getProjectSpace(), getProjectSpace().eResource().getURI(), false);
		Project loadedProject = loadedProjectSpace.getProject();

		assertEquals(false, loadedProject.containsInstance(useCase));
		operations = loadedProjectSpace.getOperations();

		assertEquals(1, operations.size());
		operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());

		assertEquals(useCaseId, createDeleteOperation.getModelElementId());
		subOperations = createDeleteOperation.getSubOperations();

		assertEquals(7, subOperations.size());
		subOperation0 = subOperations.get(0);
		subOperation1 = subOperations.get(1);
		subOperation2 = subOperations.get(2);
		subOperation3 = subOperations.get(3);
		subOperation4 = subOperations.get(4);
		subOperation5 = subOperations.get(5);
		subOperation6 = subOperations.get(6);

		assertEquals(true, subOperation0 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation1 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation2 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation3 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation4 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation5 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation6 instanceof MultiReferenceOperation);

		mrSubOperation0 = (MultiReferenceOperation) subOperation0;
		mrSubOperation1 = (SingleReferenceOperation) subOperation1;
		mrSubOperation2 = (MultiReferenceOperation) subOperation2;
		mrSubOperation3 = (MultiReferenceOperation) subOperation3;
		mrSubOperation4 = (MultiReferenceOperation) subOperation4;
		mrSubOperation5 = (SingleReferenceOperation) subOperation5;
		mrSubOperation6 = (MultiReferenceOperation) subOperation6;

		assertEquals("initiatedUseCases", mrSubOperation0.getFeatureName());
		assertEquals(0, mrSubOperation0.getIndex());

		assertEquals(oldActorId, mrSubOperation0.getModelElementId());
		assertEquals("initiatingActor", mrSubOperation0.getOppositeFeatureName());
		assertEquals(false, mrSubOperation0.isAdd());
		assertEquals(true, mrSubOperation0.isBidirectional());
		otherInvolvedModelElements0 = mrSubOperation0.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		referencedModelElements0 = mrSubOperation0.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCaseId, referencedModelElements0.get(0));

		assertEquals(oldActorId, mrSubOperation1.getOldValue());
		assertEquals(null, mrSubOperation1.getNewValue());
		assertEquals("initiatingActor", mrSubOperation1.getFeatureName());
		assertEquals(useCaseId, mrSubOperation1.getModelElementId());
		assertEquals("initiatedUseCases", mrSubOperation1.getOppositeFeatureName());
		assertEquals(true, mrSubOperation1.isBidirectional());
		otherInvolvedModelElements = mrSubOperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActorId, otherInvolvedModelElements.iterator().next());

		assertEquals(newActorId, mrSubOperation2.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation2.getFeatureName());
		assertEquals(false, mrSubOperation2.isAdd());
		assertEquals(1, mrSubOperation2.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation2.getReferencedModelElements().get(0));

		assertEquals(otherActorId, mrSubOperation3.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation3.getFeatureName());
		assertEquals(false, mrSubOperation3.isAdd());
		assertEquals(1, mrSubOperation3.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation3.getReferencedModelElements().get(0));

		assertEquals("participatingActors", mrSubOperation4.getFeatureName());
		assertEquals(-1, mrSubOperation4.getIndex());
		assertEquals(useCaseId, mrSubOperation4.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation4.getOppositeFeatureName());
		assertEquals(false, mrSubOperation4.isAdd());
		assertEquals(true, mrSubOperation4.isBidirectional());
		otherInvolvedModelElements2 = mrSubOperation4.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements2.size());
		referencedModelElements = mrSubOperation4.getReferencedModelElements();
		assertEquals(2, referencedModelElements.size());
		assertEquals(newActorId, referencedModelElements.get(0));
		assertEquals(otherActorId, referencedModelElements.get(1));

		assertEquals(useCaseId, mrSubOperation5.getModelElementId());
		assertEquals("leafSection", mrSubOperation5.getFeatureName());
		assertEquals(sectionId, mrSubOperation5.getOldValue());
		assertEquals(null, mrSubOperation5.getNewValue());

		assertEquals("modelElements", mrSubOperation6.getFeatureName());
		assertEquals(0, mrSubOperation6.getIndex());
		assertEquals(sectionId, mrSubOperation6.getModelElementId());
		assertEquals("leafSection", mrSubOperation6.getOppositeFeatureName());
		assertEquals(false, mrSubOperation6.isAdd());
		assertEquals(true, mrSubOperation6.isBidirectional());
		otherInvolvedModelElements3 = mrSubOperation6.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		referencedModelElements3 = mrSubOperation6.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCaseId, referencedModelElements3.get(0));
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 * @throws IOException
	 */
	@Test
	public void complexDeleteElementReverseTest() throws UnsupportedOperationException,
		UnsupportedNotificationException, IOException {
		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		final Actor newActor = RequirementFactory.eINSTANCE.createActor();
		final Actor otherActor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(useCase);
				section.getModelElements().add(oldActor);
				getProject().addModelElement(newActor);
				getProject().addModelElement(otherActor);
				useCase.setInitiatingActor(oldActor);
				useCase.getParticipatingActors().add(newActor);
				useCase.getParticipatingActors().add(otherActor);
				assertEquals(true, getProject().containsInstance(useCase));
				assertEquals(true, getProject().containsInstance(oldActor));
				assertEquals(true, getProject().containsInstance(newActor));
				assertEquals(true, getProject().containsInstance(otherActor));
				assertEquals(1, oldActor.getInitiatedUseCases().size());
				assertEquals(1, newActor.getParticipatedUseCases().size());
				assertEquals(1, otherActor.getParticipatedUseCases().size());
				assertEquals(useCase, oldActor.getInitiatedUseCases().get(0));
				assertEquals(useCase, newActor.getParticipatedUseCases().get(0));
				assertEquals(useCase, otherActor.getParticipatedUseCases().get(0));

				clearOperations();
			}
		}.run(false);

		ModelElementId useCaseId = getProject().getModelElementId(useCase);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().deleteModelElement(useCase);
			}
		}.run(false);

		assertEquals(false, getProject().containsInstance(useCase));
		assertEquals(0, oldActor.getInitiatedUseCases().size());
		assertEquals(0, newActor.getParticipatedUseCases().size());
		assertEquals(0, otherActor.getParticipatedUseCases().size());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);

		final AbstractOperation reverse = operation.reverse();

		assertEquals(true, reverse instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) reverse;
		assertEquals(false, createDeleteOperation.isDelete());

		assertEquals(useCaseId, createDeleteOperation.getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();

		assertEquals(7, subOperations.size());
		AbstractOperation subOperation0 = subOperations.get(6);
		AbstractOperation subOperation1 = subOperations.get(5);
		AbstractOperation subOperation2 = subOperations.get(4);
		AbstractOperation subOperation3 = subOperations.get(3);
		AbstractOperation subOperation4 = subOperations.get(2);
		AbstractOperation subOperation5 = subOperations.get(1);
		AbstractOperation subOperation6 = subOperations.get(0);

		assertEquals(true, subOperation0 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation1 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation2 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation3 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation4 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation5 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation6 instanceof MultiReferenceOperation);

		MultiReferenceOperation mrSubOperation0 = (MultiReferenceOperation) subOperation0;
		SingleReferenceOperation mrSubOperation1 = (SingleReferenceOperation) subOperation1;
		MultiReferenceOperation mrSubOperation2 = (MultiReferenceOperation) subOperation2;
		MultiReferenceOperation mrSubOperation3 = (MultiReferenceOperation) subOperation3;
		MultiReferenceOperation mrSubOperation4 = (MultiReferenceOperation) subOperation4;
		SingleReferenceOperation mrSubOperation5 = (SingleReferenceOperation) subOperation5;
		MultiReferenceOperation mrSubOperation6 = (MultiReferenceOperation) subOperation6;

		ModelElementId oldActorId = ModelUtil.getProject(oldActor).getModelElementId(oldActor);
		ModelElementId newActorId = ModelUtil.getProject(newActor).getModelElementId(newActor);
		ModelElementId otherActorId = ModelUtil.getProject(otherActor).getModelElementId(otherActor);
		ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);

		assertEquals("initiatedUseCases", mrSubOperation0.getFeatureName());
		assertEquals(0, mrSubOperation0.getIndex());
		assertEquals(oldActorId, mrSubOperation0.getModelElementId());
		assertEquals("initiatingActor", mrSubOperation0.getOppositeFeatureName());
		assertEquals(true, mrSubOperation0.isAdd());
		assertEquals(true, mrSubOperation0.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements0 = mrSubOperation0.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		EList<ModelElementId> referencedModelElements0 = mrSubOperation0.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCaseId, referencedModelElements0.get(0));

		assertEquals(oldActorId, mrSubOperation1.getNewValue());
		assertEquals(null, mrSubOperation1.getOldValue());
		assertEquals("initiatingActor", mrSubOperation1.getFeatureName());
		assertEquals(useCaseId, mrSubOperation1.getModelElementId());
		assertEquals("initiatedUseCases", mrSubOperation1.getOppositeFeatureName());
		assertEquals(true, mrSubOperation1.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = mrSubOperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActorId, otherInvolvedModelElements.iterator().next());

		assertEquals(newActorId, mrSubOperation2.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation2.getFeatureName());
		assertEquals(true, mrSubOperation2.isAdd());
		assertEquals(1, mrSubOperation2.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation2.getReferencedModelElements().get(0));

		assertEquals(otherActorId, mrSubOperation3.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation3.getFeatureName());
		assertEquals(true, mrSubOperation3.isAdd());
		assertEquals(1, mrSubOperation3.getReferencedModelElements().size());
		assertEquals(useCaseId, mrSubOperation3.getReferencedModelElements().get(0));

		assertEquals("participatingActors", mrSubOperation4.getFeatureName());
		assertEquals(-1, mrSubOperation4.getIndex());
		assertEquals(useCaseId, mrSubOperation4.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation4.getOppositeFeatureName());
		assertEquals(true, mrSubOperation4.isAdd());
		assertEquals(true, mrSubOperation4.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2 = mrSubOperation4.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements2.size());
		EList<ModelElementId> referencedModelElements = mrSubOperation4.getReferencedModelElements();
		assertEquals(2, referencedModelElements.size());
		assertEquals(newActorId, referencedModelElements.get(0));
		assertEquals(otherActorId, referencedModelElements.get(1));

		assertEquals(useCaseId, mrSubOperation5.getModelElementId());
		assertEquals("leafSection", mrSubOperation5.getFeatureName());
		assertEquals(sectionId, mrSubOperation5.getNewValue());
		assertEquals(null, mrSubOperation5.getOldValue());

		assertEquals("modelElements", mrSubOperation6.getFeatureName());
		assertEquals(0, mrSubOperation6.getIndex());
		assertEquals(sectionId, mrSubOperation6.getModelElementId());
		assertEquals("leafSection", mrSubOperation6.getOppositeFeatureName());
		assertEquals(true, mrSubOperation6.isAdd());
		assertEquals(true, mrSubOperation6.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements3 = mrSubOperation6.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		EList<ModelElementId> referencedModelElements3 = mrSubOperation6.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCaseId, referencedModelElements3.get(0));

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				reverse.apply(getProject());
			}
		}.run(false);

		assertEquals(true, getProject().contains(useCaseId));
		assertEquals(true, getProject().containsInstance(oldActor));
		assertEquals(true, getProject().containsInstance(newActor));
		assertEquals(true, getProject().containsInstance(otherActor));
		assertEquals(1, oldActor.getInitiatedUseCases().size());
		assertEquals(1, newActor.getParticipatedUseCases().size());
		assertEquals(1, otherActor.getParticipatedUseCases().size());
		EObject useCaseClone = getProject().getModelElement(useCaseId);
		assertEquals(useCaseClone, oldActor.getInitiatedUseCases().get(0));
		assertEquals(useCaseClone, newActor.getParticipatedUseCases().get(0));
		assertEquals(useCaseClone, otherActor.getParticipatedUseCases().get(0));

		Project loadedProject = ModelUtil.loadEObjectFromResource(MetamodelFactory.eINSTANCE.getMetamodelPackage()
			.getProject(), getProject().eResource().getURI(), false);

		assertTrue(ModelUtil.areEqual(loadedProject, getProject()));
		assertEquals(true, loadedProject.contains(useCaseId));
		assertEquals(true, loadedProject.contains(oldActorId));
		assertEquals(true, loadedProject.contains(newActorId));
		assertEquals(true, loadedProject.contains(otherActorId));
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 * @throws IOException
	 */
	@Test
	public void complexCreateTest() throws UnsupportedOperationException, UnsupportedNotificationException, IOException {
		for (int i = 0; i < 10; i++) {
			final CompositeSection createCompositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
			createCompositeSection.setName("Helmut" + i);
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					getProject().addModelElement(createCompositeSection);
					LeafSection createLeafSection = DocumentFactory.eINSTANCE.createLeafSection();
					createCompositeSection.getSubsections().add(createLeafSection);

					for (int j = 0; j < 10; j++) {
						ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
						createActionItem.setName("Max tu dies" + j);
						createLeafSection.getModelElements().add(createActionItem);
					}
				}
			}.run(false);
		}
		assertEquals(230, getProjectSpace().getOperations().size());

		((ProjectSpaceImpl) getProjectSpace()).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(WorkspacePackage.eINSTANCE
			.getProjectSpace(), getProjectSpace().eResource().getURI(), false);

		assertTrue(ModelUtil.areEqual(getProjectSpace(), loadedProjectSpace));
	}

	/**
	 * Delete a parent with a child contained in a single reference.
	 * 
	 * @throws IOException
	 */
	@Test
	public void deleteWithSingleReferenceChildTest() throws IOException {
		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				issue.setSolution(solution);
				getProject().addModelElement(issue);

				assertEquals(true, getProject().containsInstance(issue));
				assertEquals(true, getProject().containsInstance(solution));
				assertEquals(solution, issue.getSolution());
				assertEquals(issue, solution.getIssue());

				clearOperations();
			}
		}.run(false);

		ModelElementId solutionId = ModelUtil.getProject(solution).getModelElementId(solution);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().deleteModelElement(solution);
			}
		}.run(false);

		assertEquals(true, getProject().containsInstance(issue));
		assertEquals(false, getProject().containsInstance(solution));
		assertEquals(null, issue.getSolution());
		assertEquals(null, solution.getIssue());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());

		assertEquals(solutionId, createDeleteOperation.getModelElementId());

		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();
		assertEquals(2, subOperations.size());

		((ProjectSpaceImpl) getProjectSpace()).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(WorkspacePackage.eINSTANCE
			.getProjectSpace(), getProjectSpace().eResource().getURI(), false);

		// perform asserts with loaded project space
		assertTrue(ModelUtil.areEqual(getProjectSpace(), loadedProjectSpace));
		operations = loadedProjectSpace.getOperations();
		assertEquals(1, operations.size());
		operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());
	}

	/**
	 * Test creation of element with cross references.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test(expected = IllegalStateException.class)
	public void createWithCrossReferencesTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase2);
		useCase.getIncludedUseCases().add(useCase2);

		clearOperations();

		getProject().addModelElement(useCase);

	}

	/**
	 * Test creating an element in a non project containment.
	 * 
	 * @throws IOException
	 */
	@Test
	public void createInNonProjectContainmentTest() throws IOException {
		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);

				assertEquals(true, getProject().containsInstance(section));

				clearOperations();

				section.getModelElements().add(useCase);
			}
		}.run(false);

		assertEquals(true, getProject().containsInstance(useCase));
		assertEquals(true, getProject().containsInstance(section));
		assertEquals(1, section.getModelElements().size());
		assertEquals(section, useCase.getLeafSection());
		assertEquals(useCase, section.getModelElements().iterator().next());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(2, operations.size());

		AbstractOperation operation1 = operations.get(0);
		AbstractOperation operation2 = operations.get(1);
		assertEquals(true, operation1 instanceof CreateDeleteOperation);
		assertEquals(true, operation2 instanceof MultiReferenceOperation);
		CreateDeleteOperation createOperation = (CreateDeleteOperation) operation1;
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation2;
		assertEquals(false, createOperation.isDelete());

		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);
		ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);

		assertEquals(useCaseId, createOperation.getModelElementId());
		assertEquals(sectionId, multiReferenceOperation.getModelElementId());

		((ProjectSpaceImpl) getProjectSpace()).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(WorkspacePackage.eINSTANCE
			.getProjectSpace(), getProjectSpace().eResource().getURI(), false);

		// perform asserts with loaded project space
		assertTrue(ModelUtil.areEqual(getProjectSpace(), loadedProjectSpace));
		operations = loadedProjectSpace.getOperations();
		assertEquals(2, operations.size());

		operation1 = operations.get(0);
		operation2 = operations.get(1);
		assertEquals(true, operation1 instanceof CreateDeleteOperation);
		assertEquals(true, operation2 instanceof MultiReferenceOperation);
		createOperation = (CreateDeleteOperation) operation1;
		multiReferenceOperation = (MultiReferenceOperation) operation2;
		assertEquals(false, createOperation.isDelete());

	}

	@Test
	public void createEAttributes() throws IOException {
		final EClass clazz = EcoreFactory.eINSTANCE.createEClass();
		EStructuralFeature attribute = EcoreFactory.eINSTANCE.createEAttribute();
		EStructuralFeature attribute2 = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("attribute1");
		attribute2.setName("attribute2");
		clazz.getEStructuralFeatures().add(attribute);
		clazz.getEStructuralFeatures().add(attribute2);

		assertEquals(2, clazz.eContents().size());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(clazz);
			}
		}.run(false);

		((ProjectSpaceImpl) getProjectSpace()).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(WorkspacePackage.eINSTANCE
			.getProjectSpace(), getProjectSpace().eResource().getURI(), false);

		// perform asserts with loaded project space
		assertTrue(ModelUtil.areEqual(getProjectSpace(), loadedProjectSpace));
	}

	@Test
	public void testECoreUtilCopyWithMeetings() {
		CompositeMeetingSection compMeetingSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		IssueMeetingSection issueMeeting = MeetingFactory.eINSTANCE.createIssueMeetingSection();
		WorkItemMeetingSection workItemMeetingSecion = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();
		compMeetingSection.getSubsections().add(issueMeeting);
		compMeetingSection.getSubsections().add(workItemMeetingSecion);

		final Meeting meeting = MeetingFactory.eINSTANCE.createMeeting();
		meeting.getSections().add(compMeetingSection);
		meeting.setIdentifiedIssuesSection(issueMeeting);
		meeting.setIdentifiedWorkItemsSection(workItemMeetingSecion);

		Meeting copiedMeeting = (Meeting) EcoreUtil.copy(meeting);
		assertFalse(copiedMeeting.getIdentifiedIssuesSection() == meeting.getIdentifiedIssuesSection());
		assertFalse(copiedMeeting.getIdentifiedWorkItemsSection() == meeting.getIdentifiedWorkItemsSection());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(meeting);
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(1, operations.size());

		AbstractOperation operation1 = operations.get(0);
		assertTrue(operation1 instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation1;
		assertFalse(createDeleteOperation.isDelete());

		Meeting meetingSection = (Meeting) createDeleteOperation.getModelElement();
		assertFalse(meeting.getIdentifiedIssuesSection() == meetingSection.getIdentifiedIssuesSection());

	}

	@Test
	public void testCopyProject() {
		final CompositeMeetingSection compMeetingSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		IssueMeetingSection issueMeeting = MeetingFactory.eINSTANCE.createIssueMeetingSection();
		WorkItemMeetingSection workItemMeetingSecion = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();
		compMeetingSection.getSubsections().add(issueMeeting);
		compMeetingSection.getSubsections().add(workItemMeetingSecion);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(compMeetingSection);
			}
		}.run(false);

		Project p = ((ProjectImpl) getProject()).copy();
		assertNotNull(p);
	}

	/**
	 * Test creating an element in a non project containment.
	 */
	// commenting out, too exotic to happen
	/*
	 * @Test public void createTreeAndAddNonRootToProject() { WorkPackage root =
	 * TaskFactory.eINSTANCE.createWorkPackage(); WorkPackage child = TaskFactory.eINSTANCE.createWorkPackage();
	 * WorkPackage existing = TaskFactory.eINSTANCE.createWorkPackage(); root.getContainedWorkItems().add(child);
	 * getProject().getModelElements().add(existing); child.getContainedWorkItems().add(existing);
	 * getProject().getModelElements().add(root); assertTrue(getProject().contains(child));
	 * assertTrue(getProject().contains(root)); assertTrue(getProject().contains(existing)); assertSame(root,
	 * child.getContainingWorkpackage()); assertSame(child, existing.getContainingWorkpackage());
	 * assertEquals(getProject().getAllModelElements().size(), 3); }
	 */
}
