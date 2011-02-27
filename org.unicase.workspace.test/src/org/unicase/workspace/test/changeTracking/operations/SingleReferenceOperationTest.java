/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests the SingleReferenceOperation.
 * 
 * @author koegel
 */
public class SingleReferenceOperationTest extends WorkspaceTest {

	/**
	 * Change a single reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				getProject().addModelElement(actor);

				clearOperations();

				useCase.setInitiatingActor(actor);

				assertEquals(actor, useCase.getInitiatingActor());
				EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
				assertEquals(1, initiatedUseCases.size());
				assertEquals(useCase, initiatedUseCases.get(0));
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CompositeOperation);

		EList<AbstractOperation> subOperations = ((CompositeOperation) operation).getSubOperations();

		assertEquals(2, subOperations.size());

		operation = subOperations.get(0);
		assertEquals(true, operation instanceof MultiReferenceOperationImpl);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;
		assertEquals("initiatedUseCases", multiReferenceOperation.getFeatureName());
		assertEquals("initiatingActor", multiReferenceOperation.getOppositeFeatureName());
		assertEquals(useCase.getModelElementId(), multiReferenceOperation.getReferencedModelElements().get(0));
		assertEquals(actor.getModelElementId(), multiReferenceOperation.getModelElementId());
		assertTrue(multiReferenceOperation.isBidirectional());
		assertTrue(multiReferenceOperation.isAdd());
		assertEquals(1, multiReferenceOperation.getOtherInvolvedModelElements().size());

		operation = subOperations.get(1);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;

		assertEquals(null, singleReferenceOperation.getOldValue());
		assertEquals(actor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(actor.getModelElementId(), otherInvolvedModelElements.iterator().next());
	}

	/**
	 * Change an single reference twice and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	// commented out, single reference operations are not canonized at present
	// @Test
	// public void changeSingleReferenceTwice() throws UnsupportedOperationException, UnsupportedNotificationException {
	// UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
	// getProject().addModelElement(useCase);
	// Actor oldActor = RequirementFactory.eINSTANCE.createActor();
	// getProject().addModelElement(oldActor);
	// Actor newActor = RequirementFactory.eINSTANCE.createActor();
	// getProject().addModelElement(newActor);
	//		
	// clearOperations();
	//		
	// useCase.setInitiatingActor(oldActor);
	// assertEquals(oldActor, useCase.getInitiatingActor());
	// EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
	// assertEquals(1, initiatedUseCases.size());
	// assertEquals(useCase, initiatedUseCases.get(0));
	//		
	// useCase.setInitiatingActor(newActor);
	// assertEquals(newActor, useCase.getInitiatingActor());
	// initiatedUseCases = newActor.getInitiatedUseCases();
	// assertEquals(1, initiatedUseCases.size());
	// assertEquals(useCase, initiatedUseCases.get(0));
	//		
	// List<AbstractOperation> operations = getProjectSpace().getOperations();
	//		
	// assertEquals(1, operations.size());
	// AbstractOperation operation = operations.get(0);
	// assertEquals(true, operation instanceof SingleReferenceOperation);
	// SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
	//		
	// assertEquals(null, singleReferenceOperation.getOldValue());
	// assertEquals(newActor.getModelElementId(), singleReferenceOperation.getNewValue());
	// assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
	// assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
	// assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
	// assertEquals(true, singleReferenceOperation.isBidirectional());
	// Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
	// assertEquals(1, otherInvolvedModelElements.size());
	// assertEquals(newActor.getModelElementId(), otherInvolvedModelElements.iterator().next());
	// }
	/**
	 * Change an single reference and reverse it.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void reverseSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		final Actor newActor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				getProject().addModelElement(oldActor);
				getProject().addModelElement(newActor);
				useCase.setInitiatingActor(oldActor);
				assertEquals(oldActor, useCase.getInitiatingActor());
				EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
				assertEquals(1, initiatedUseCases.size());
				assertEquals(useCase, initiatedUseCases.get(0));

				clearOperations();

				useCase.setInitiatingActor(newActor);
				assertEquals(newActor, useCase.getInitiatingActor());
				initiatedUseCases = newActor.getInitiatedUseCases();
				assertEquals(1, initiatedUseCases.size());
				assertEquals(useCase, initiatedUseCases.get(0));
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());

		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		// note: skipping multireferenceop at index 0 in test, as it is not interesting in this context
		AbstractOperation operation = operations.get(2);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;

		assertEquals(oldActor.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(newActor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(oldActor.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(newActor.getModelElementId()));

		AbstractOperation reverse = singleReferenceOperation.reverse();
		assertEquals(true, reverse instanceof SingleReferenceOperation);
		final SingleReferenceOperation reversedSingleReferenceOperation = (SingleReferenceOperation) reverse;

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				reversedSingleReferenceOperation.apply(getProject());
			}
		}.run(false);

		assertEquals(oldActor, useCase.getInitiatingActor());

		assertEquals(newActor.getModelElementId(), reversedSingleReferenceOperation.getOldValue());
		assertEquals(oldActor.getModelElementId(), reversedSingleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", reversedSingleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), reversedSingleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", reversedSingleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, reversedSingleReferenceOperation.isBidirectional());
		otherInvolvedModelElements = reversedSingleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(oldActor.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(newActor.getModelElementId()));
	}

	/**
	 * Tests reversibility of 1:n single reference feature.
	 */
	@Test
	public void containmentSingleReferenceReversibilityTest() {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection oldSection = DocumentFactory.eINSTANCE.createLeafSection();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				getProject().addModelElement(actor);
				getProject().addModelElement(section);
				getProject().addModelElement(oldSection);
				useCase.setLeafSection(oldSection);
				actor.setLeafSection(oldSection);

				Project expectedProject = ModelUtil.clone(getProject());
				assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

				clearOperations();
				useCase.setLeafSection(section);
				List<AbstractOperation> operations = getProjectSpace().getOperations();
				// composite operation containing a multiref operation and a singleref operation expected
				assertEquals(operations.size(), 1);
				AbstractOperation reverse = operations.get(0).reverse();
				reverse.apply(getProject());

				assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
			}
		}.run(false);

	}

	/**
	 * Move a containee to another container.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void moveContainmentReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		final Issue oldIssue = RationaleFactory.eINSTANCE.createIssue();
		final Issue newIssue = RationaleFactory.eINSTANCE.createIssue();
		final Proposal proposal = RationaleFactory.eINSTANCE.createProposal();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(oldIssue);
				getProject().addModelElement(newIssue);
				getProject().addModelElement(proposal);
				proposal.setIssue(oldIssue);
				clearOperations();

				assertEquals(0, newIssue.getProposals().size());
				assertEquals(1, oldIssue.getProposals().size());
				assertEquals(proposal, oldIssue.getProposals().get(0));
				assertEquals(oldIssue, proposal.getIssue());

				proposal.setIssue(newIssue);

				assertEquals(0, oldIssue.getProposals().size());
				assertEquals(1, newIssue.getProposals().size());
				assertEquals(proposal, newIssue.getProposals().get(0));
				assertEquals(newIssue, proposal.getIssue());
			}
		}.run(false);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());

		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		AbstractOperation op0 = operations.get(0);
		assertTrue(op0 instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) op0;
		assertEquals(multiReferenceOperation.getModelElementId(), oldIssue.getModelElementId());
		assertFalse(multiReferenceOperation.isAdd());
		assertEquals(multiReferenceOperation.getReferencedModelElements().get(0), proposal.getModelElementId());
		assertEquals(multiReferenceOperation.getReferencedModelElements().size(), 1);
		assertEquals(multiReferenceOperation.getIndex(), 0);

		AbstractOperation op1 = operations.get(1);
		assertTrue(op1 instanceof MultiReferenceOperation);
		multiReferenceOperation = (MultiReferenceOperation) op1;
		assertEquals(multiReferenceOperation.getModelElementId(), newIssue.getModelElementId());
		assertTrue(multiReferenceOperation.isAdd());
		assertEquals(multiReferenceOperation.getReferencedModelElements().get(0), proposal.getModelElementId());
		assertEquals(multiReferenceOperation.getReferencedModelElements().size(), 1);
		assertEquals(multiReferenceOperation.getIndex(), 0);

		AbstractOperation operation = operations.get(2);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;

		assertEquals(oldIssue.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(newIssue.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals(RationalePackage.eINSTANCE.getProposal_Issue().getName(), singleReferenceOperation
			.getFeatureName());
		assertEquals(proposal.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals(RationalePackage.eINSTANCE.getIssue_Proposals().getName(), singleReferenceOperation
			.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(newIssue.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(oldIssue.getModelElementId()));
	}

	/**
	 * Test containment removing.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 */
	@Test
	public void removeContainment() throws UnsupportedOperationException {
		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Proposal proposal = RationaleFactory.eINSTANCE.createProposal();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				proposal.setName("proposal");
				getProject().addModelElement(issue);
				getProject().addModelElement(proposal);
				proposal.setIssue(issue);

				clearOperations();

				assertEquals(1, issue.getProposals().size());
				assertEquals(proposal, issue.getProposals().get(0));
				assertEquals(issue, proposal.getIssue());
				assertEquals(true, getProject().contains(issue));
				assertEquals(true, getProject().contains(proposal));
				assertEquals(getProject(), issue.getProject());
				assertEquals(getProject(), proposal.getProject());
				assertEquals(issue, proposal.eContainer());
			}
		}.run(false);

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				proposal.setIssue(null);
			}
		}.run(false);

		assertEquals(true, getProject().contains(issue));
		assertEquals(false, getProject().contains(proposal));
		assertEquals(getProject(), issue.getProject());
		assertEquals(null, proposal.getProject());
		assertEquals(0, issue.getProposals().size());
		assertEquals(null, proposal.getIssue());
		assertEquals(null, proposal.eContainer());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());

		assertEquals(true, operations.get(0) instanceof CreateDeleteOperation);
		CreateDeleteOperation deleteOperation = (CreateDeleteOperation) operations.get(0);
		assertEquals(true, deleteOperation.isDelete());
		assertEquals(true, deleteOperation.getModelElement() instanceof Proposal);
		assertEquals("proposal", ((Proposal) deleteOperation.getModelElement()).getName());
		assertEquals(proposal.getModelElementId(), deleteOperation.getModelElementId());

		List<ReferenceOperation> subOperations = ((CreateDeleteOperation) operations.get(0)).getSubOperations();
		assertEquals(2, subOperations.size());

		AbstractOperation op0 = subOperations.get(0);
		assertTrue(op0 instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) op0;
		assertEquals(multiReferenceOperation.getModelElementId(), issue.getModelElementId());
		assertFalse(multiReferenceOperation.isAdd());
		assertEquals(multiReferenceOperation.getReferencedModelElements().get(0), proposal.getModelElementId());
		assertEquals(multiReferenceOperation.getReferencedModelElements().size(), 1);
		assertEquals(multiReferenceOperation.getIndex(), 0);

		AbstractOperation operation = subOperations.get(1);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;

		assertEquals(issue.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(null, singleReferenceOperation.getNewValue());
		assertEquals(RationalePackage.eINSTANCE.getProposal_Issue().getName(), singleReferenceOperation
			.getFeatureName());
		assertEquals(proposal.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals(RationalePackage.eINSTANCE.getIssue_Proposals().getName(), singleReferenceOperation
			.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(issue.getModelElementId()));
	}
}