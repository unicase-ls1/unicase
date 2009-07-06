/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the MultiReferenceOperation.
 * 
 * @author koegel
 */
public class CreateDeleteOperationTest extends OperationTest {

	/**
	 * Test element creation tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void createElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;

		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
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

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);

		clearOperations();

		getProject().deleteModelElement(useCase);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;

		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(true, createDeleteOperation.isDelete());
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void complexDeleteElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		section.getModelElements().add(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		Actor otherActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(otherActor);
		useCase.setInitiatingActor(oldActor);
		useCase.getParticipatingActors().add(newActor);
		useCase.getParticipatingActors().add(otherActor);
		assertEquals(true, getProject().contains(useCase));
		assertEquals(getProject(), useCase.getProject());

		clearOperations();

		getProject().deleteModelElement(useCase);

		assertEquals(false, getProject().contains(useCase));
		assertEquals(null, useCase.eContainer());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();

		assertEquals(4, subOperations.size());
		AbstractOperation subOperation0 = subOperations.get(0);
		AbstractOperation subOperation1 = subOperations.get(1);
		AbstractOperation subOperation2 = subOperations.get(2);
		AbstractOperation subOperation3 = subOperations.get(3);

		assertEquals(true, subOperation0 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation1 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation2 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation3 instanceof MultiReferenceOperation);

		MultiReferenceOperation mrSubOperation0 = (MultiReferenceOperation) subOperation0;
		SingleReferenceOperation mrSubOperation1 = (SingleReferenceOperation) subOperation1;
		MultiReferenceOperation mrSubOperation2 = (MultiReferenceOperation) subOperation2;
		MultiReferenceOperation mrSubOperation3 = (MultiReferenceOperation) subOperation3;

		assertEquals("initiatedUseCases", mrSubOperation0.getFeatureName());
		assertEquals(0, mrSubOperation0.getIndex());
		assertEquals(oldActor.getModelElementId(), mrSubOperation0.getModelElementId());
		assertEquals("initiatingActor", mrSubOperation0.getOppositeFeatureName());
		assertEquals(false, mrSubOperation0.isAdd());
		assertEquals(true, mrSubOperation0.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements0 = mrSubOperation0.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		EList<ModelElementId> referencedModelElements0 = mrSubOperation0.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements0.get(0));

		assertEquals(oldActor.getModelElementId(), mrSubOperation1.getOldValue());
		assertEquals(null, mrSubOperation1.getNewValue());
		assertEquals("initiatingActor", mrSubOperation1.getFeatureName());
		assertEquals(useCase.getModelElementId(), mrSubOperation1.getModelElementId());
		assertEquals("initiatedUseCases", mrSubOperation1.getOppositeFeatureName());
		assertEquals(true, mrSubOperation1.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = mrSubOperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActor.getModelElementId(), otherInvolvedModelElements.iterator().next());

		assertEquals("participatingActors", mrSubOperation2.getFeatureName());
		assertEquals(-1, mrSubOperation2.getIndex());
		assertEquals(useCase.getModelElementId(), mrSubOperation2.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation2.getOppositeFeatureName());
		assertEquals(false, mrSubOperation2.isAdd());
		assertEquals(true, mrSubOperation2.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2 = mrSubOperation2.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements2.size());
		EList<ModelElementId> referencedModelElements = mrSubOperation2.getReferencedModelElements();
		assertEquals(2, referencedModelElements.size());
		assertEquals(newActor.getModelElementId(), referencedModelElements.get(0));
		assertEquals(otherActor.getModelElementId(), referencedModelElements.get(1));

		assertEquals("modelElements", mrSubOperation3.getFeatureName());
		assertEquals(0, mrSubOperation3.getIndex());
		assertEquals(section.getModelElementId(), mrSubOperation3.getModelElementId());
		assertEquals("leafSection", mrSubOperation3.getOppositeFeatureName());
		assertEquals(false, mrSubOperation3.isAdd());
		assertEquals(true, mrSubOperation3.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements3 = mrSubOperation3.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		EList<ModelElementId> referencedModelElements3 = mrSubOperation3.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements3.get(0));
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void complexDeleteElementReverseTest() throws UnsupportedOperationException,
		UnsupportedNotificationException {
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		section.getModelElements().add(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		Actor otherActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(otherActor);
		useCase.setInitiatingActor(oldActor);
		useCase.getParticipatingActors().add(newActor);
		useCase.getParticipatingActors().add(otherActor);

		assertEquals(true, getProject().contains(useCase));
		assertEquals(true, getProject().contains(oldActor));
		assertEquals(true, getProject().contains(newActor));
		assertEquals(true, getProject().contains(otherActor));
		assertEquals(1, oldActor.getInitiatedUseCases().size());
		assertEquals(1, newActor.getParticipatedUseCases().size());
		assertEquals(1, otherActor.getParticipatedUseCases().size());
		assertEquals(useCase, oldActor.getInitiatedUseCases().get(0));
		assertEquals(useCase, newActor.getParticipatedUseCases().get(0));
		assertEquals(useCase, otherActor.getParticipatedUseCases().get(0));

		clearOperations();

		getProject().deleteModelElement(useCase);

		assertEquals(false, getProject().contains(useCase));
		assertEquals(0, oldActor.getInitiatedUseCases().size());
		assertEquals(0, newActor.getParticipatedUseCases().size());
		assertEquals(0, otherActor.getParticipatedUseCases().size());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);

		AbstractOperation reverse = operation.reverse();

		assertEquals(true, reverse instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) reverse;
		assertEquals(false, createDeleteOperation.isDelete());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();

		assertEquals(4, subOperations.size());

		AbstractOperation subOperation0 = subOperations.get(3);
		AbstractOperation subOperation1 = subOperations.get(2);
		AbstractOperation subOperation2 = subOperations.get(1);
		AbstractOperation subOperation3 = subOperations.get(0);

		assertEquals(true, subOperation0 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation1 instanceof SingleReferenceOperation);
		assertEquals(true, subOperation2 instanceof MultiReferenceOperation);
		assertEquals(true, subOperation3 instanceof MultiReferenceOperation);

		MultiReferenceOperation mrSubOperation0 = (MultiReferenceOperation) subOperation0;
		SingleReferenceOperation mrSubOperation1 = (SingleReferenceOperation) subOperation1;
		MultiReferenceOperation mrSubOperation2 = (MultiReferenceOperation) subOperation2;
		MultiReferenceOperation mrSubOperation3 = (MultiReferenceOperation) subOperation3;

		assertEquals("initiatedUseCases", mrSubOperation0.getFeatureName());
		assertEquals(0, mrSubOperation0.getIndex());
		assertEquals(oldActor.getModelElementId(), mrSubOperation0.getModelElementId());
		assertEquals("initiatingActor", mrSubOperation0.getOppositeFeatureName());
		assertEquals(true, mrSubOperation0.isAdd());
		assertEquals(true, mrSubOperation0.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements0 = mrSubOperation0.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		EList<ModelElementId> referencedModelElements0 = mrSubOperation0.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements0.get(0));

		assertEquals(oldActor.getModelElementId(), mrSubOperation1.getNewValue());
		assertEquals(null, mrSubOperation1.getOldValue());
		assertEquals("initiatingActor", mrSubOperation1.getFeatureName());
		assertEquals(useCase.getModelElementId(), mrSubOperation1.getModelElementId());
		assertEquals("initiatedUseCases", mrSubOperation1.getOppositeFeatureName());
		assertEquals(true, mrSubOperation1.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = mrSubOperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActor.getModelElementId(), otherInvolvedModelElements.iterator().next());

		assertEquals("participatingActors", mrSubOperation2.getFeatureName());
		assertEquals(-1, mrSubOperation2.getIndex());
		assertEquals(useCase.getModelElementId(), mrSubOperation2.getModelElementId());
		assertEquals("participatedUseCases", mrSubOperation2.getOppositeFeatureName());
		assertEquals(true, mrSubOperation2.isAdd());
		assertEquals(true, mrSubOperation2.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2 = mrSubOperation2.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements2.size());
		EList<ModelElementId> referencedModelElements = mrSubOperation2.getReferencedModelElements();
		assertEquals(2, referencedModelElements.size());
		assertEquals(newActor.getModelElementId(), referencedModelElements.get(0));
		assertEquals(otherActor.getModelElementId(), referencedModelElements.get(1));

		assertEquals("modelElements", mrSubOperation3.getFeatureName());
		assertEquals(0, mrSubOperation3.getIndex());
		assertEquals(section.getModelElementId(), mrSubOperation3.getModelElementId());
		assertEquals("leafSection", mrSubOperation3.getOppositeFeatureName());
		assertEquals(true, mrSubOperation3.isAdd());
		assertEquals(true, mrSubOperation3.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements3 = mrSubOperation3.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		EList<ModelElementId> referencedModelElements3 = mrSubOperation3.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements3.get(0));

		reverse.apply(getProject());

		assertEquals(true, getProject().contains(useCase));
		assertEquals(true, getProject().contains(oldActor));
		assertEquals(true, getProject().contains(newActor));
		assertEquals(true, getProject().contains(otherActor));
		assertEquals(1, oldActor.getInitiatedUseCases().size());
		assertEquals(1, newActor.getParticipatedUseCases().size());
		assertEquals(1, otherActor.getParticipatedUseCases().size());
		ModelElement useCaseClone = getProject().getModelElement(useCase.getModelElementId());
		assertEquals(useCaseClone, oldActor.getInitiatedUseCases().get(0));
		assertEquals(useCaseClone, newActor.getParticipatedUseCases().get(0));
		assertEquals(useCaseClone, otherActor.getParticipatedUseCases().get(0));
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void complexCreateTest() throws UnsupportedOperationException, UnsupportedNotificationException {
		for (int i = 0; i < 10; i++) {
			CompositeSection createCompositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
			createCompositeSection.setName("Helmut" + i);
			getProject().addModelElement(createCompositeSection);
			LeafSection createLeafSection = DocumentFactory.eINSTANCE.createLeafSection();
			createCompositeSection.getSubsections().add(createLeafSection);

			for (int j = 0; j < 100; j++) {
				ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
				createActionItem.setName("Max tu dies" + j);
				createLeafSection.getModelElements().add(createActionItem);
			}
		}
		assertEquals(2030, getProjectSpace().getOperations().size());
	}

	/**
	 * Delete a parent with a child contained in a single reference.
	 */
	@Test
	public void deleteWithSingleReferenceChildTest() {
		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();
		issue.setSolution(solution);
		getProject().addModelElement(issue);

		assertEquals(true, getProject().contains(issue));
		assertEquals(true, getProject().contains(solution));
		assertEquals(solution, issue.getSolution());
		assertEquals(issue, solution.getIssue());

		clearOperations();

		getProject().deleteModelElement(solution);

		assertEquals(true, getProject().contains(issue));
		assertEquals(false, getProject().contains(solution));
		assertEquals(null, issue.getSolution());
		assertEquals(null, solution.getIssue());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());
		assertEquals(solution.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(solution.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();
		assertEquals(1, subOperations.size());

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
	 */
	@Test
	public void createInNonProjectContainmentTest() {
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);

		assertEquals(true, getProject().contains(section));

		clearOperations();

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);

		assertEquals(true, getProject().contains(useCase));
		assertEquals(true, getProject().contains(section));
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
		assertEquals(useCase.getModelElementId(), createOperation.getModelElementId());
		assertEquals(section.getModelElementId(), multiReferenceOperation.getModelElementId());
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
