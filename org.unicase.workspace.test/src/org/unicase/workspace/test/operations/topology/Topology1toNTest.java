/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.topology;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

import java.util.Arrays;
import java.util.List;

/**
 * Tests operations in 1:n topologies.
 * @author chodnick
 *
 */
public class Topology1toNTest extends TopologyTest{


	
	/**
	 * add an uncontained child to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(section);

		clearOperations();

		section.getModelElements().add(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}	
	
	
	/**
	 * add several uncontained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildrenToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section);

		Actor[] actors = {actor1, actor2};
		
		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}	
		
	/**
	 * add several uncontained children to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildrenToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);

		Actor[] actors = {actor1, actor2};
		section.getModelElements().add(oldActor);
		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
		
	}		
	
	
	/**
	 * add an uncontained child to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);

		section.getModelElements().add(oldActor);
		
		clearOperations();

		section.getModelElements().add(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
	}		
	
	/**
	 * add an contained child to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddSameFeatureContainedChildToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section1);
		getProject().addModelElement(section2);

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		
		clearOperations();
		
		section1.getModelElements().add(actor2);
		assertFalse(section2.getModelElements().contains(actor2));
		assertTrue(section1.getModelElements().contains(actor2));

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		// first op is: LeafSection change on actor2 (preserving old parent)
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		assertEquals(op1.getOldValue(), section2.getModelElementId());
		assertEquals(op1.getNewValue(), section1.getModelElementId());
		assertEquals("leafSection", op1.getFeatureName());
		
		// second op is: Section2 welcomes its new child 
		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op2 = (MultiReferenceOperation) operations.get(1);
		assertTrue(op2.isAdd());
		assertEquals(1, op2.getReferencedModelElements().size());
		assertEquals(actor2.getModelElementId(), op2.getReferencedModelElements().get(0));
		assertEquals("modelElements", op2.getFeatureName());
		assertEquals(op2.getModelElementId(), section1.getModelElementId());
		assertEquals(op2.getIndex(), 1);
		
	}		
	
	
	/**
	 * add an contained child to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContainedNChildToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		WorkPackage pack =  TaskFactory.eINSTANCE.createWorkPackage();
		BugReport br = BugFactory.eINSTANCE.createBugReport();
		
		getProject().addModelElement(section);
		getProject().addModelElement(pack);
		getProject().addModelElement(br);
		br.setLeafSection(section);
		
		assertTrue(section.getModelElements().contains(br));
		
		clearOperations();

		pack.getContainedWorkItems().add(br);
		assertFalse(section.getModelElements().contains(br));
		assertTrue(pack.getContainedWorkItems().contains(br));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		// first op is: LeafSection change on bug report (preserving old parent)
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		assertEquals(op1.getOldValue(), section.getModelElementId());
		assertNull(op1.getNewValue());
		assertEquals("leafSection", op1.getFeatureName());
		
		// second op is: Workpackage welcomes its new child 
		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op2 = (MultiReferenceOperation) operations.get(1);
		assertTrue(op2.isAdd());
		assertEquals(1, op2.getReferencedModelElements().size());
		assertEquals(br.getModelElementId(), op2.getReferencedModelElements().get(0));
		assertEquals("containedWorkItems", op2.getFeatureName());
		assertEquals(op2.getModelElementId(), pack.getModelElementId());
		assertEquals(op2.getIndex(), 0);
		
	}			
	
	/**
	 * add an contained child to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContained1ChildToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(section);
		getProject().addModelElement(solution);
		issue.setSolution(solution);
		
		clearOperations();

		section.getModelElements().add(solution);
		assertTrue(section.getModelElements().contains(solution));
		assertNull(issue.getSolution());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);

		// first op is: solution loses its old parent 
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		assertEquals(solution.getModelElementId(), op1.getModelElementId());
		assertEquals("issue", op1.getFeatureName());
		assertEquals(op1.getOldValue(), issue.getModelElementId());
		assertNull(op1.getNewValue());
		
		// second op is: section welcomes its new child 
		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op2 = (MultiReferenceOperation) operations.get(1);
		assertTrue(op2.isAdd());
		assertEquals(op2.getModelElementId(), section.getModelElementId());
		assertEquals(1, op2.getReferencedModelElements().size());
		assertEquals(solution.getModelElementId(), op2.getReferencedModelElements().get(0));
		assertEquals("modelElements", op2.getFeatureName());
		assertEquals(op2.getIndex(), 0);
		
	}				
	
	/**
	 * remove last child from a containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentRemoveChildAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(section);

		section.getModelElements().add(actor);
		
		clearOperations();

		section.getModelElements().remove(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
	}		
	
	/**
	 * remove all children from a containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentRemoveChildrenAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section);

		Actor[] actors = {actor1, actor2};
		section.getModelElements().addAll(Arrays.asList(actors));
		
		clearOperations();

		section.getModelElements().removeAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
	}		
	
	/**
	 * remove non-last child from a containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentRemoveChildPart() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);

		section.getModelElements().add(oldActor);
		section.getModelElements().add(actor);
		
		clearOperations();

		section.getModelElements().remove(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
	}	
	
	/**
	 * add a child to an empty non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentAddChildToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(useCase);

		clearOperations();

		useCase.getParticipatingActors().add(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}
	
	/**
	 * add some children to an empty non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentAddChildrenToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = {actor1, actor2};
		
		clearOperations();

		useCase.getParticipatingActors().addAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}	
	
	/**
	 * add a child to a non-empty non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentAddChildToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(useCase);

		useCase.getParticipatingActors().add(oldActor);

		clearOperations();

		useCase.getParticipatingActors().add(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
		
	}	
	
	/**
	 * add some children to a non-empty non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentAddChildrenToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(oldActor);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = {actor1, actor2};
		useCase.getParticipatingActors().add(oldActor);
		clearOperations();

		useCase.getParticipatingActors().addAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
		
	}		
	
	/**
	 * remove last child from non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentRemoveChildAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(useCase);
		useCase.getParticipatingActors().add(actor);

		clearOperations();

		useCase.getParticipatingActors().remove(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}		
	
	/**
	 * remove non-last child from non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void nonContainmentRemoveChildPart() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(useCase);

		useCase.getParticipatingActors().add(oldActor);
		useCase.getParticipatingActors().add(actor);
		
		clearOperations();

		useCase.getParticipatingActors().remove(actor);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
		
	}		
	
	/**
	 * remove all children from non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	
	@Test
	public void nonContainmentRemoveChildrenAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = {actor1, actor2};
		
		useCase.getParticipatingActors().addAll(Arrays.asList(actors));

		clearOperations();

		useCase.getParticipatingActors().removeAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
		
		
	}		
	
	/**
	 * remove some children from non-containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	
	@Test
	public void nonContainmentRemoveChildrenPart() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(oldActor);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = {actor1, actor2};
		
		useCase.getParticipatingActors().add(oldActor);
		useCase.getParticipatingActors().addAll(Arrays.asList(actors));
		
		clearOperations();

		useCase.getParticipatingActors().removeAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("participatingActors", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
		
	}			


	/**
	 * remove some children from a containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentRemoveChildrenPart() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(oldActor);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section);

		Actor[] actors = {actor1, actor2};
		section.getModelElements().add(oldActor);
		section.getModelElements().addAll(Arrays.asList(actors));
		
		clearOperations();

		section.getModelElements().removeAll(Arrays.asList(actors));
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 1);
		
	}		
	
}
