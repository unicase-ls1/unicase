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
import org.unicase.model.ModelElement;
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
 * 
 * @author chodnick
 */
public class Topology1toNTest extends TopologyTest {

	/**
	 * add an uncontained child to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void containmentAddUncontainedChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section);

		Actor[] actors = { actor1, actor2 };

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
	public void containmentAddUncontainedChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);

		Actor[] actors = { actor1, actor2 };
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
	 * add several uncontained children to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildrenFakeManyToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);

		Actor[] actors = { actor1 };
		section.getModelElements().add(oldActor);
		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 1);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddSameFeatureContainedChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		Actor actor4 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		getProject().addModelElement(actor4);
		getProject().addModelElement(section);
		getProject().addModelElement(oldSection);
		getProject().addModelElement(oldSection2);

		Actor[] actors = { actor1, actor2, actor3, actor4 };
		oldSection.getModelElements().addAll(Arrays.asList(actors));
		oldSection2.getModelElements().add(actor4); // relocate to other section
		assertTrue(oldSection.getModelElements().contains(actor1));
		assertTrue(oldSection.getModelElements().contains(actor2));
		assertTrue(oldSection.getModelElements().contains(actor3));
		assertTrue(oldSection2.getModelElements().contains(actor4));
		assertTrue(section.getModelElements().isEmpty());

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 4 messages preserving the info on former parents for the actors
		// and one additional one, indicating the new parent for all of them
		assertEquals(5, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);

		assertEquals(op1.getModelElementId(), actor1.getModelElementId());
		assertEquals(op2.getModelElementId(), actor2.getModelElementId());
		assertEquals(op3.getModelElementId(), actor3.getModelElementId());
		assertEquals(op4.getModelElementId(), actor4.getModelElementId());

		assertEquals(op1.getFeatureName(), "leafSection");
		assertEquals(op2.getFeatureName(), "leafSection");
		assertEquals(op3.getFeatureName(), "leafSection");
		assertEquals(op4.getFeatureName(), "leafSection");

		assertEquals(op1.getOldValue(), oldSection.getModelElementId());
		assertEquals(op2.getOldValue(), oldSection.getModelElementId());
		assertEquals(op3.getOldValue(), oldSection.getModelElementId());
		assertEquals(op4.getOldValue(), oldSection2.getModelElementId());

		assertEquals(op1.getNewValue(), section.getModelElementId());
		assertEquals(op2.getNewValue(), section.getModelElementId());
		assertEquals(op3.getNewValue(), section.getModelElementId());
		assertEquals(op4.getNewValue(), section.getModelElementId());

		assertTrue(operations.get(4) instanceof MultiReferenceOperation);
		MultiReferenceOperation op5 = (MultiReferenceOperation) operations.get(4);

		assertEquals(op5.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op5.getFeatureName());
		assertTrue(op5.isAdd());
		assertEquals(4, op5.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op5.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op5.getReferencedModelElements().get(1));
		assertEquals(actor3.getModelElementId(), op5.getReferencedModelElements().get(2));
		assertEquals(actor4.getModelElementId(), op5.getReferencedModelElements().get(3));
		assertEquals(op5.getIndex(), 0);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddSameFeatureContainedChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		Actor actor4 = RequirementFactory.eINSTANCE.createActor();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		getProject().addModelElement(actor4);
		getProject().addModelElement(oldActor);
		getProject().addModelElement(section);
		getProject().addModelElement(oldSection);
		getProject().addModelElement(oldSection2);

		Actor[] actors = { actor1, actor2, actor3, actor4 };
		section.getModelElements().add(oldActor);
		oldSection.getModelElements().addAll(Arrays.asList(actors));
		oldSection2.getModelElements().add(actor4); // relocate to other section
		assertTrue(oldSection.getModelElements().contains(actor1));
		assertTrue(oldSection.getModelElements().contains(actor2));
		assertTrue(oldSection.getModelElements().contains(actor3));
		assertTrue(section.getModelElements().contains(oldActor));
		assertTrue(oldSection2.getModelElements().contains(actor4));

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 4 messages preserving the info on former parents for the actors
		// and one additional one, indicating the new parent for all of them
		assertEquals(5, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);

		assertEquals(op1.getModelElementId(), actor1.getModelElementId());
		assertEquals(op2.getModelElementId(), actor2.getModelElementId());
		assertEquals(op3.getModelElementId(), actor3.getModelElementId());
		assertEquals(op4.getModelElementId(), actor4.getModelElementId());

		assertEquals(op1.getFeatureName(), "leafSection");
		assertEquals(op2.getFeatureName(), "leafSection");
		assertEquals(op3.getFeatureName(), "leafSection");
		assertEquals(op4.getFeatureName(), "leafSection");

		assertEquals(op1.getOldValue(), oldSection.getModelElementId());
		assertEquals(op2.getOldValue(), oldSection.getModelElementId());
		assertEquals(op3.getOldValue(), oldSection.getModelElementId());
		assertEquals(op4.getOldValue(), oldSection2.getModelElementId());

		assertEquals(op1.getNewValue(), section.getModelElementId());
		assertEquals(op2.getNewValue(), section.getModelElementId());
		assertEquals(op3.getNewValue(), section.getModelElementId());
		assertEquals(op4.getNewValue(), section.getModelElementId());

		assertTrue(operations.get(4) instanceof MultiReferenceOperation);
		MultiReferenceOperation op5 = (MultiReferenceOperation) operations.get(4);

		assertEquals(op5.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op5.getFeatureName());
		assertTrue(op5.isAdd());
		assertEquals(4, op5.getReferencedModelElements().size());
		assertEquals(actor1.getModelElementId(), op5.getReferencedModelElements().get(0));
		assertEquals(actor2.getModelElementId(), op5.getReferencedModelElements().get(1));
		assertEquals(actor3.getModelElementId(), op5.getReferencedModelElements().get(2));
		assertEquals(actor4.getModelElementId(), op5.getReferencedModelElements().get(3));
		assertEquals(op5.getIndex(), 1);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContainedNChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		WorkPackage oldPack = TaskFactory.eINSTANCE.createWorkPackage();
		WorkPackage oldPack2 = TaskFactory.eINSTANCE.createWorkPackage();

		BugReport br1 = BugFactory.eINSTANCE.createBugReport();
		BugReport br2 = BugFactory.eINSTANCE.createBugReport();
		BugReport br3 = BugFactory.eINSTANCE.createBugReport();
		BugReport br4 = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(br1);
		getProject().addModelElement(br2);
		getProject().addModelElement(br3);
		getProject().addModelElement(br4);
		getProject().addModelElement(section);
		getProject().addModelElement(oldPack);
		getProject().addModelElement(oldPack2);

		BugReport[] actors = { br1, br2, br3, br4 };
		oldPack.getContainedWorkItems().addAll(Arrays.asList(actors));
		oldPack2.getContainedWorkItems().add(br4); // relocate to other section
		assertTrue(oldPack.getContainedWorkItems().contains(br1));
		assertTrue(oldPack.getContainedWorkItems().contains(br2));
		assertTrue(oldPack.getContainedWorkItems().contains(br3));
		assertTrue(oldPack2.getContainedWorkItems().contains(br4));
		assertTrue(section.getModelElements().isEmpty());

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 4 messages preserving the info on former parents for the actors
		// and one additional one, indicating the new parent for all of them
		assertEquals(5, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);

		assertEquals(op1.getModelElementId(), br1.getModelElementId());
		assertEquals(op2.getModelElementId(), br2.getModelElementId());
		assertEquals(op3.getModelElementId(), br3.getModelElementId());
		assertEquals(op4.getModelElementId(), br4.getModelElementId());

		assertEquals(op1.getFeatureName(), "containingWorkpackage");
		assertEquals(op2.getFeatureName(), "containingWorkpackage");
		assertEquals(op3.getFeatureName(), "containingWorkpackage");
		assertEquals(op4.getFeatureName(), "containingWorkpackage");

		assertEquals(op1.getOldValue(), oldPack.getModelElementId());
		assertEquals(op2.getOldValue(), oldPack.getModelElementId());
		assertEquals(op3.getOldValue(), oldPack.getModelElementId());
		assertEquals(op4.getOldValue(), oldPack2.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);
		assertEquals(op3.getNewValue(), null);
		assertEquals(op4.getNewValue(), null);

		assertTrue(operations.get(4) instanceof MultiReferenceOperation);
		MultiReferenceOperation op5 = (MultiReferenceOperation) operations.get(4);

		assertEquals(op5.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op5.getFeatureName());
		assertTrue(op5.isAdd());
		assertEquals(4, op5.getReferencedModelElements().size());
		assertEquals(br1.getModelElementId(), op5.getReferencedModelElements().get(0));
		assertEquals(br2.getModelElementId(), op5.getReferencedModelElements().get(1));
		assertEquals(br3.getModelElementId(), op5.getReferencedModelElements().get(2));
		assertEquals(br4.getModelElementId(), op5.getReferencedModelElements().get(3));
		assertEquals(op5.getIndex(), 0);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContained1ChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(section);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		Solution[] solutions = { solution1, solution2 };
		issue1.setSolution(solution1);
		issue2.setSolution(solution2);

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(solutions));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 2 messages preserving the info on former parents for the solutions
		// and one additional one, indicating the new parent for both of them
		assertEquals(3, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);

		assertEquals(op1.getModelElementId(), solution1.getModelElementId());
		assertEquals(op2.getModelElementId(), solution2.getModelElementId());

		assertEquals(op1.getFeatureName(), "issue");
		assertEquals(op2.getFeatureName(), "issue");

		assertEquals(op1.getOldValue(), issue1.getModelElementId());
		assertEquals(op2.getOldValue(), issue2.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);

		assertTrue(operations.get(2) instanceof MultiReferenceOperation);
		MultiReferenceOperation op3 = (MultiReferenceOperation) operations.get(2);

		assertEquals(op3.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op3.getFeatureName());
		assertTrue(op3.isAdd());
		assertEquals(2, op3.getReferencedModelElements().size());
		assertEquals(solution1.getModelElementId(), op3.getReferencedModelElements().get(0));
		assertEquals(solution2.getModelElementId(), op3.getReferencedModelElements().get(1));
		assertEquals(op3.getIndex(), 0);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddMixedChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection2 = DocumentFactory.eINSTANCE.createLeafSection();
		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();
		Solution newSolution = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution2 = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution3 = RationaleFactory.eINSTANCE.createSolution();
		WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		BugReport br = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(section);
		getProject().addModelElement(oldSection1);
		getProject().addModelElement(oldSection2);
		getProject().addModelElement(newSolution);
		getProject().addModelElement(sectionSolution1);
		getProject().addModelElement(sectionSolution2);
		getProject().addModelElement(sectionSolution3);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);
		getProject().addModelElement(pack);
		getProject().addModelElement(br);

		ModelElement[] addedElements = { solution1, solution2, newSolution, sectionSolution1, sectionSolution2,
			sectionSolution3, br };
		issue1.setSolution(solution1);
		issue2.setSolution(solution2);
		pack.getContainedWorkItems().add(br);
		oldSection1.getModelElements().add(sectionSolution1);
		oldSection1.getModelElements().add(sectionSolution2);
		oldSection2.getModelElements().add(sectionSolution3);

		assertTrue(oldSection1.getModelElements().contains(sectionSolution1));
		assertTrue(oldSection1.getModelElements().contains(sectionSolution2));
		assertTrue(oldSection2.getModelElements().contains(sectionSolution3));
		assertTrue(pack.getContainedWorkItems().contains(br));

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(addedElements));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 6 messages preserving the info on former parents for the solutions
		// and one additional one, indicating the new parent for both of them
		assertEquals(7, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);
		assertTrue(operations.get(4) instanceof SingleReferenceOperation);
		assertTrue(operations.get(5) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);
		SingleReferenceOperation op5 = (SingleReferenceOperation) operations.get(4);
		SingleReferenceOperation op6 = (SingleReferenceOperation) operations.get(5);

		assertEquals(op1.getModelElementId(), solution1.getModelElementId());
		assertEquals(op2.getModelElementId(), solution2.getModelElementId());
		assertEquals(op3.getModelElementId(), sectionSolution1.getModelElementId());
		assertEquals(op4.getModelElementId(), sectionSolution2.getModelElementId());
		assertEquals(op5.getModelElementId(), sectionSolution3.getModelElementId());
		assertEquals(op6.getModelElementId(), br.getModelElementId());

		assertEquals(op1.getFeatureName(), "issue");
		assertEquals(op2.getFeatureName(), "issue");
		assertEquals(op3.getFeatureName(), "leafSection");
		assertEquals(op4.getFeatureName(), "leafSection");
		assertEquals(op5.getFeatureName(), "leafSection");
		assertEquals(op6.getFeatureName(), "containingWorkpackage");

		assertEquals(op1.getOldValue(), issue1.getModelElementId());
		assertEquals(op2.getOldValue(), issue2.getModelElementId());
		assertEquals(op3.getOldValue(), oldSection1.getModelElementId());
		assertEquals(op4.getOldValue(), oldSection1.getModelElementId());
		assertEquals(op5.getOldValue(), oldSection2.getModelElementId());
		assertEquals(op6.getOldValue(), pack.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);
		assertEquals(op3.getNewValue(), section.getModelElementId());
		assertEquals(op4.getNewValue(), section.getModelElementId());
		assertEquals(op5.getNewValue(), section.getModelElementId());
		assertEquals(op6.getNewValue(), null);

		assertTrue(operations.get(6) instanceof MultiReferenceOperation);
		MultiReferenceOperation op7 = (MultiReferenceOperation) operations.get(6);

		assertEquals(op7.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op7.getFeatureName());
		assertTrue(op7.isAdd());
		assertEquals(7, op7.getReferencedModelElements().size());
		assertEquals(solution1.getModelElementId(), op7.getReferencedModelElements().get(0));
		assertEquals(solution2.getModelElementId(), op7.getReferencedModelElements().get(1));
		assertEquals(newSolution.getModelElementId(), op7.getReferencedModelElements().get(2));
		assertEquals(sectionSolution1.getModelElementId(), op7.getReferencedModelElements().get(3));
		assertEquals(sectionSolution2.getModelElementId(), op7.getReferencedModelElements().get(4));
		assertEquals(sectionSolution3.getModelElementId(), op7.getReferencedModelElements().get(5));
		assertEquals(br.getModelElementId(), op7.getReferencedModelElements().get(6));
		assertEquals(op7.getIndex(), 0);

	}

	/**
	 * add several already contained children to an empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddMixedChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		section.getModelElements().add(RationaleFactory.eINSTANCE.createIssue()); // prefill section
		LeafSection oldSection1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection2 = DocumentFactory.eINSTANCE.createLeafSection();
		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();
		Solution newSolution = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution2 = RationaleFactory.eINSTANCE.createSolution();
		Solution sectionSolution3 = RationaleFactory.eINSTANCE.createSolution();
		WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		BugReport br = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(section);
		getProject().addModelElement(oldSection1);
		getProject().addModelElement(oldSection2);
		getProject().addModelElement(newSolution);
		getProject().addModelElement(sectionSolution1);
		getProject().addModelElement(sectionSolution2);
		getProject().addModelElement(sectionSolution3);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);
		getProject().addModelElement(pack);
		getProject().addModelElement(br);

		ModelElement[] addedElements = { solution1, solution2, newSolution, sectionSolution1, sectionSolution2,
			sectionSolution3, br };
		issue1.setSolution(solution1);
		issue2.setSolution(solution2);
		pack.getContainedWorkItems().add(br);
		oldSection1.getModelElements().add(sectionSolution1);
		oldSection1.getModelElements().add(sectionSolution2);
		oldSection2.getModelElements().add(sectionSolution3);

		assertTrue(oldSection1.getModelElements().contains(sectionSolution1));
		assertTrue(oldSection1.getModelElements().contains(sectionSolution2));
		assertTrue(oldSection2.getModelElements().contains(sectionSolution3));
		assertTrue(pack.getContainedWorkItems().contains(br));

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(addedElements));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 6 messages preserving the info on former parents for the solutions
		// and one additional one, indicating the new parent for both of them
		assertEquals(7, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);
		assertTrue(operations.get(4) instanceof SingleReferenceOperation);
		assertTrue(operations.get(5) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);
		SingleReferenceOperation op5 = (SingleReferenceOperation) operations.get(4);
		SingleReferenceOperation op6 = (SingleReferenceOperation) operations.get(5);

		assertEquals(op1.getModelElementId(), solution1.getModelElementId());
		assertEquals(op2.getModelElementId(), solution2.getModelElementId());
		assertEquals(op3.getModelElementId(), sectionSolution1.getModelElementId());
		assertEquals(op4.getModelElementId(), sectionSolution2.getModelElementId());
		assertEquals(op5.getModelElementId(), sectionSolution3.getModelElementId());
		assertEquals(op6.getModelElementId(), br.getModelElementId());

		assertEquals(op1.getFeatureName(), "issue");
		assertEquals(op2.getFeatureName(), "issue");
		assertEquals(op3.getFeatureName(), "leafSection");
		assertEquals(op4.getFeatureName(), "leafSection");
		assertEquals(op5.getFeatureName(), "leafSection");
		assertEquals(op6.getFeatureName(), "containingWorkpackage");

		assertEquals(op1.getOldValue(), issue1.getModelElementId());
		assertEquals(op2.getOldValue(), issue2.getModelElementId());
		assertEquals(op3.getOldValue(), oldSection1.getModelElementId());
		assertEquals(op4.getOldValue(), oldSection1.getModelElementId());
		assertEquals(op5.getOldValue(), oldSection2.getModelElementId());
		assertEquals(op6.getOldValue(), pack.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);
		assertEquals(op3.getNewValue(), section.getModelElementId());
		assertEquals(op4.getNewValue(), section.getModelElementId());
		assertEquals(op5.getNewValue(), section.getModelElementId());
		assertEquals(op6.getNewValue(), null);

		assertTrue(operations.get(6) instanceof MultiReferenceOperation);
		MultiReferenceOperation op7 = (MultiReferenceOperation) operations.get(6);

		assertEquals(op7.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op7.getFeatureName());
		assertTrue(op7.isAdd());
		assertEquals(7, op7.getReferencedModelElements().size());
		assertEquals(solution1.getModelElementId(), op7.getReferencedModelElements().get(0));
		assertEquals(solution2.getModelElementId(), op7.getReferencedModelElements().get(1));
		assertEquals(newSolution.getModelElementId(), op7.getReferencedModelElements().get(2));
		assertEquals(sectionSolution1.getModelElementId(), op7.getReferencedModelElements().get(3));
		assertEquals(sectionSolution2.getModelElementId(), op7.getReferencedModelElements().get(4));
		assertEquals(sectionSolution3.getModelElementId(), op7.getReferencedModelElements().get(5));
		assertEquals(br.getModelElementId(), op7.getReferencedModelElements().get(6));
		assertEquals(op7.getIndex(), 1);

	}

	/**
	 * add several already contained children to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContained1ChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		section.getModelElements().add(RationaleFactory.eINSTANCE.createSolution()); // prefill section
		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(section);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		Solution[] solutions = { solution1, solution2 };
		issue1.setSolution(solution1);
		issue2.setSolution(solution2);

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(solutions));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 2 messages preserving the info on former parents for the solutions
		// and one additional one, indicating the new parent for both of them
		assertEquals(3, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);

		assertEquals(op1.getModelElementId(), solution1.getModelElementId());
		assertEquals(op2.getModelElementId(), solution2.getModelElementId());

		assertEquals(op1.getFeatureName(), "issue");
		assertEquals(op2.getFeatureName(), "issue");

		assertEquals(op1.getOldValue(), issue1.getModelElementId());
		assertEquals(op2.getOldValue(), issue2.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);

		assertTrue(operations.get(2) instanceof MultiReferenceOperation);
		MultiReferenceOperation op3 = (MultiReferenceOperation) operations.get(2);

		assertEquals(op3.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op3.getFeatureName());
		assertTrue(op3.isAdd());
		assertEquals(2, op3.getReferencedModelElements().size());
		assertEquals(solution1.getModelElementId(), op3.getReferencedModelElements().get(0));
		assertEquals(solution2.getModelElementId(), op3.getReferencedModelElements().get(1));
		assertEquals(op3.getIndex(), 1);

	}

	/**
	 * add several already contained children to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddDifferentFeatureContainedNChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		section.getModelElements().add(BugFactory.eINSTANCE.createBugReport());

		WorkPackage oldPack = TaskFactory.eINSTANCE.createWorkPackage();
		WorkPackage oldPack2 = TaskFactory.eINSTANCE.createWorkPackage();

		BugReport br1 = BugFactory.eINSTANCE.createBugReport();
		BugReport br2 = BugFactory.eINSTANCE.createBugReport();
		BugReport br3 = BugFactory.eINSTANCE.createBugReport();
		BugReport br4 = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(br1);
		getProject().addModelElement(br2);
		getProject().addModelElement(br3);
		getProject().addModelElement(br4);
		getProject().addModelElement(section);
		getProject().addModelElement(oldPack);
		getProject().addModelElement(oldPack2);

		BugReport[] actors = { br1, br2, br3, br4 };
		oldPack.getContainedWorkItems().addAll(Arrays.asList(actors));
		oldPack2.getContainedWorkItems().add(br4); // relocate to other section
		assertTrue(oldPack.getContainedWorkItems().contains(br1));
		assertTrue(oldPack.getContainedWorkItems().contains(br2));
		assertTrue(oldPack.getContainedWorkItems().contains(br3));
		assertTrue(oldPack2.getContainedWorkItems().contains(br4));
		assertFalse(section.getModelElements().isEmpty()); // one item is there initially

		clearOperations();

		section.getModelElements().addAll(Arrays.asList(actors));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// now expectation is: we get 4 messages preserving the info on former parents for the actors
		// and one additional one, indicating the new parent for all of them
		assertEquals(5, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		assertTrue(operations.get(3) instanceof SingleReferenceOperation);

		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(2);
		SingleReferenceOperation op4 = (SingleReferenceOperation) operations.get(3);

		assertEquals(op1.getModelElementId(), br1.getModelElementId());
		assertEquals(op2.getModelElementId(), br2.getModelElementId());
		assertEquals(op3.getModelElementId(), br3.getModelElementId());
		assertEquals(op4.getModelElementId(), br4.getModelElementId());

		assertEquals(op1.getFeatureName(), "containingWorkpackage");
		assertEquals(op2.getFeatureName(), "containingWorkpackage");
		assertEquals(op3.getFeatureName(), "containingWorkpackage");
		assertEquals(op4.getFeatureName(), "containingWorkpackage");

		assertEquals(op1.getOldValue(), oldPack.getModelElementId());
		assertEquals(op2.getOldValue(), oldPack.getModelElementId());
		assertEquals(op3.getOldValue(), oldPack.getModelElementId());
		assertEquals(op4.getOldValue(), oldPack2.getModelElementId());

		assertEquals(op1.getNewValue(), null);
		assertEquals(op2.getNewValue(), null);
		assertEquals(op3.getNewValue(), null);
		assertEquals(op4.getNewValue(), null);

		assertTrue(operations.get(4) instanceof MultiReferenceOperation);
		MultiReferenceOperation op5 = (MultiReferenceOperation) operations.get(4);

		assertEquals(op5.getModelElementId(), section.getModelElementId());
		assertEquals("modelElements", op5.getFeatureName());
		assertTrue(op5.isAdd());
		assertEquals(4, op5.getReferencedModelElements().size());
		assertEquals(br1.getModelElementId(), op5.getReferencedModelElements().get(0));
		assertEquals(br2.getModelElementId(), op5.getReferencedModelElements().get(1));
		assertEquals(br3.getModelElementId(), op5.getReferencedModelElements().get(2));
		assertEquals(br4.getModelElementId(), op5.getReferencedModelElements().get(3));
		assertEquals(op5.getIndex(), 1);

	}

	/**
	 * add an uncontained child to a non-empty containment feature.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentAddUncontainedChildToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void containmentAddSameFeatureContainedChildToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void containmentAddDifferentFeatureContainedNChildToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
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
	public void containmentAddDifferentFeatureContained1ChildToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void containmentRemoveChildrenAndEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(section);

		Actor[] actors = { actor1, actor2 };
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
	public void nonContainmentAddChildrenToEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = { actor1, actor2 };

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
	public void nonContainmentAddChildToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void nonContainmentAddChildrenToNonEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(oldActor);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = { actor1, actor2 };
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
	public void nonContainmentRemoveChildAndEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

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
	public void nonContainmentRemoveChildrenAndEmpty() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = { actor1, actor2 };

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
	public void nonContainmentRemoveChildrenPart() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(oldActor);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(useCase);

		Actor[] actors = { actor1, actor2 };

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

		Actor[] actors = { actor1, actor2 };
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
