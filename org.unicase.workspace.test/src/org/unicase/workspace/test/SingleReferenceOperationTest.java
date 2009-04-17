/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the SingleReferenceOperation.
 * @author koegel
 *
 */
public class SingleReferenceOperationTest extends OperationTest {

	/**
	 * Change a single reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);

		clearOperations();
		
		useCase.setInitiatingActor(actor);
		
		assertEquals(actor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
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
	@Test
	public void changeSingleReferenceTwice() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		
		clearOperations();
		
		useCase.setInitiatingActor(oldActor);
		assertEquals(oldActor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		
		useCase.setInitiatingActor(newActor);
		assertEquals(newActor, useCase.getInitiatingActor());
		initiatedUseCases = newActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(null, singleReferenceOperation.getOldValue());
		assertEquals(newActor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(newActor.getModelElementId(), otherInvolvedModelElements.iterator().next());
	}
	
	/**
	 * Change an single reference and reverse it.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void reverseSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
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
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
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
		SingleReferenceOperation reversedSingleReferenceOperation = (SingleReferenceOperation) reverse;
		
		reversedSingleReferenceOperation.apply(getProject());
		
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
	 * Move a containee to another container.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void moveContainmentReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		Issue oldIssue = RationaleFactory.eINSTANCE.createIssue();
		getProject().addModelElement(oldIssue);
		Issue newIssue = RationaleFactory.eINSTANCE.createIssue();
		getProject().addModelElement(newIssue);
		Proposal proposal = RationaleFactory.eINSTANCE.createProposal();
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
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(oldIssue.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(newIssue.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals(RationalePackage.eINSTANCE.getProposal_Issue().getName(), singleReferenceOperation.getFeatureName());
		assertEquals(proposal.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals(RationalePackage.eINSTANCE.getIssue_Proposals().getName(), singleReferenceOperation.getOppositeFeatureName());
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
		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		getProject().addModelElement(issue);
		Proposal proposal = RationaleFactory.eINSTANCE.createProposal();
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
		
		proposal.setIssue(null);
		
		assertEquals(true, getProject().contains(issue));
		assertEquals(true, getProject().contains(proposal));
		assertEquals(getProject(), issue.getProject());
		assertEquals(getProject(), proposal.getProject());
		assertEquals(0, issue.getProposals().size());
		assertEquals(null, proposal.getIssue());
		assertEquals(getProject(), proposal.eContainer());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(issue.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(null, singleReferenceOperation.getNewValue());
		assertEquals(RationalePackage.eINSTANCE.getProposal_Issue().getName(), singleReferenceOperation.getFeatureName());
		assertEquals(proposal.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals(RationalePackage.eINSTANCE.getIssue_Proposals().getName(), singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(issue.getModelElementId()));
	}
}
