/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.topology;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests operations in 1:1 topologies.
 * 
 * @author chodnick
 */
public class Topology1to1Test extends TopologyTest {

	/**
	 * Change an containment attribute from null to some reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToValueNotContainedAlreadyOperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		assertEquals(issue.getSolution(), null);

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);

		clearOperations();

		issue.setSolution(solution);
		assertSame(solution, issue.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op = operations.get(0);
		assertEquals(true, op instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp = (SingleReferenceOperation) op;

		assertEquals(null, refOp.getOldValue());
		assertEquals(solution.getModelElementId(), refOp.getNewValue());
		assertEquals("solution", refOp.getFeatureName());
		assertEquals(issue.getModelElementId(), refOp.getModelElementId());
	}

	/**
	 * Change an containment attribute from null to some reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToValueNotContainedAlreadyOperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		assertEquals(issue.getSolution(), null);

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);

		clearOperations();

		solution.setIssue(issue);
		assertSame(solution, issue.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op = operations.get(0);
		assertEquals(true, op instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp = (SingleReferenceOperation) op;

		assertEquals(null, refOp.getOldValue());
		assertEquals(issue.getModelElementId(), refOp.getNewValue());
		assertEquals("issue", refOp.getFeatureName());
		assertEquals(solution.getModelElementId(), refOp.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueNotContainedAlreadyOperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solutionOld = RationaleFactory.eINSTANCE.createSolution();
		Solution solutionNew = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solutionOld);
		getProject().addModelElement(solutionNew);

		issue.setSolution(solutionOld);
		assertEquals(issue.getSolution(), solutionOld);

		clearOperations();

		issue.setSolution(solutionNew);
		assertSame(solutionNew, issue.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op = operations.get(0);
		assertEquals(true, op instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp = (SingleReferenceOperation) op;

		assertEquals(solutionOld.getModelElementId(), refOp.getOldValue());
		assertEquals(solutionNew.getModelElementId(), refOp.getNewValue());
		assertEquals("solution", refOp.getFeatureName());
		assertEquals(issue.getModelElementId(), refOp.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueNotContainedAlreadyOperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solutionOld = RationaleFactory.eINSTANCE.createSolution();
		Solution solutionNew = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solutionOld);
		getProject().addModelElement(solutionNew);

		issue.setSolution(solutionOld);
		assertEquals(issue.getSolution(), solutionOld);

		clearOperations();

		solutionNew.setIssue(issue);
		assertSame(solutionNew, issue.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		// please note: the perspective (operation called on containee) implies the following EMF notifications:

		// OldSolution: SET issue from issue to null
		// Issue: SET solution from oldSolution to newSolution
		// NewSolution: SET issue from null to issue
		// 
		// Since we are operating on newSolution we expect an operation :
		// solutionNew: got new Issue
		//
		// we need to preserve the fact, that "oldSolution" was the former solution of "issue"
		// following the "last bidirectional message wins" rule, the first message has to
		// go away, since it is the bidirectional of the second message

		assertEquals(2, operations.size());

		AbstractOperation op1 = operations.get(0);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;

		assertEquals(issue.getModelElementId(), refOp1.getModelElementId());
		assertEquals(solutionOld.getModelElementId(), refOp1.getOldValue());
		assertEquals(solutionNew.getModelElementId(), refOp1.getNewValue());
		assertEquals("solution", refOp1.getFeatureName());

		AbstractOperation op2 = operations.get(1);
		assertEquals(true, op2 instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		assertEquals(solutionNew.getModelElementId(), refOp2.getModelElementId());
		assertEquals(issue.getModelElementId(), refOp2.getNewValue());
		assertNull(refOp2.getOldValue());
		assertEquals("issue", refOp2.getFeatureName());

	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueContainedAlready1OperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		issue1.setSolution(solution1);
		issue2.setSolution(solution2);
		assertEquals(issue1.getSolution(), solution1);
		assertEquals(issue2.getSolution(), solution2);

		clearOperations();

		issue1.setSolution(solution2);
		assertSame(solution2, issue1.getSolution());
		assertNull(issue2.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(2, operations.size());
		AbstractOperation op1 = operations.get(0);
		AbstractOperation op2 = operations.get(1);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);

		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 2 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we need to track the parent of solution 2!

		// first solution 2 is getting its new parent
		assertEquals(issue2.getModelElementId(), refOp1.getOldValue());
		assertEquals(issue1.getModelElementId(), refOp1.getNewValue());
		assertEquals("issue", refOp1.getFeatureName());
		assertEquals(solution2.getModelElementId(), refOp1.getModelElementId());

		// second the issue 1 is getting its new child
		assertEquals(solution1.getModelElementId(), refOp2.getOldValue());
		assertEquals(solution2.getModelElementId(), refOp2.getNewValue());
		assertEquals("solution", refOp2.getFeatureName());
		assertEquals(issue1.getModelElementId(), refOp2.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueContainedAlready1OperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		issue1.setSolution(solution1);
		issue2.setSolution(solution2);
		assertEquals(issue1.getSolution(), solution1);
		assertEquals(issue2.getSolution(), solution2);

		clearOperations();

		solution2.setIssue(issue1);
		assertSame(solution2, issue1.getSolution());
		assertNull(issue2.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(2, operations.size());
		AbstractOperation op1 = operations.get(0);
		AbstractOperation op2 = operations.get(1);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);

		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 2 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we need to track the parent of solution 2!

		// first issue 1 is getting its new child
		assertEquals(solution1.getModelElementId(), refOp1.getOldValue());
		assertEquals(solution2.getModelElementId(), refOp1.getNewValue());
		assertEquals("solution", refOp1.getFeatureName());
		assertEquals(issue1.getModelElementId(), refOp1.getModelElementId());

		// second the solution2 is getting its issue reset, here the old parent is preserved
		assertEquals(issue2.getModelElementId(), refOp2.getOldValue());
		assertEquals(issue1.getModelElementId(), refOp2.getNewValue());
		assertEquals("issue", refOp2.getFeatureName());
		assertEquals(solution2.getModelElementId(), refOp2.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToOtherValueContainedAlready1OperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution);

		issue1.setSolution(solution);
		assertEquals(issue1.getSolution(), solution);

		clearOperations();
		solution.setIssue(issue2);
		assertNull(issue1.getSolution());
		assertSame(issue2.getSolution(), solution);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op1 = operations.get(0);
		assertTrue(op1 instanceof SingleReferenceOperation);

		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;

		assertEquals(solution.getModelElementId(), refOp1.getModelElementId());
		assertEquals("issue", refOp1.getFeatureName());
		assertEquals(issue1.getModelElementId(), refOp1.getOldValue());
		assertEquals(issue2.getModelElementId(), refOp1.getNewValue());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToOtherValueContainedAlready1OperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution);

		issue1.setSolution(solution);
		assertEquals(issue1.getSolution(), solution);

		clearOperations();
		issue2.setSolution(solution);
		assertNull(issue1.getSolution());
		assertSame(issue2.getSolution(), solution);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(2, operations.size());

		AbstractOperation op1 = operations.get(0);
		assertTrue(op1 instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;

		AbstractOperation op2 = operations.get(1);
		assertTrue(op2 instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		assertEquals(solution.getModelElementId(), refOp1.getModelElementId());
		assertEquals("issue", refOp1.getFeatureName());
		assertEquals(issue1.getModelElementId(), refOp1.getOldValue());
		assertEquals(issue2.getModelElementId(), refOp1.getNewValue());

		assertEquals(issue2.getModelElementId(), refOp2.getModelElementId());
		assertEquals("solution", refOp2.getFeatureName());
		assertNull(refOp2.getOldValue());
		assertEquals(solution.getModelElementId(), refOp2.getNewValue());

	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueContainedAlreadyNOperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(leafSection);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		leafSection.getModelElements().add(solution2);
		issue.setSolution(solution1);

		assertEquals(issue.getSolution(), solution1);
		assertTrue(leafSection.getModelElements().contains(solution2));

		clearOperations();

		issue.setSolution(solution2);
		assertSame(solution2, issue.getSolution());
		assertTrue(leafSection.getModelElements().isEmpty());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		AbstractOperation op0 = operations.get(0);
		AbstractOperation op1 = operations.get(1);
		AbstractOperation op2 = operations.get(2);

		assertEquals(true, op0 instanceof MultiReferenceOperation);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);

		MultiReferenceOperation refOp0 = (MultiReferenceOperation) op0;
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 3 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we also need track the index of issue 2 inside its former parent!

		// leaf section annouces loss of solution2 at index 0
		assertEquals("modelElements", refOp0.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp0.getModelElementId());
		assertFalse(refOp0.isAdd());
		assertEquals(1, refOp0.getReferencedModelElements().size());
		assertEquals(refOp0.getReferencedModelElements().get(0), solution2.getModelElementId());

		// solution 2 is losing its old leaf section parent
		assertEquals(leafSection.getModelElementId(), refOp1.getOldValue());
		assertNull(refOp1.getNewValue());
		assertEquals("leafSection", refOp1.getFeatureName());
		assertEquals(solution2.getModelElementId(), refOp1.getModelElementId());

		// the issue 1 is getting its new child
		assertEquals(solution1.getModelElementId(), refOp2.getOldValue());
		assertEquals(solution2.getModelElementId(), refOp2.getNewValue());
		assertEquals("solution", refOp2.getFeatureName());
		assertEquals(issue.getModelElementId(), refOp2.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueContainedAlreadyNOperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(leafSection);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		leafSection.getModelElements().add(solution2);
		issue.setSolution(solution1);

		assertEquals(issue.getSolution(), solution1);
		assertTrue(leafSection.getModelElements().contains(solution2));

		clearOperations();

		solution2.setIssue(issue);
		assertSame(solution2, issue.getSolution());
		assertTrue(leafSection.getModelElements().isEmpty());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(4, operations.size());
		AbstractOperation op0 = operations.get(0);
		AbstractOperation op1 = operations.get(1);
		AbstractOperation op2 = operations.get(2);
		AbstractOperation op3 = operations.get(3);

		assertEquals(true, op0 instanceof MultiReferenceOperation);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);
		assertEquals(true, op3 instanceof SingleReferenceOperation);

		MultiReferenceOperation refOp0 = (MultiReferenceOperation) op0;
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;
		SingleReferenceOperation refOp3 = (SingleReferenceOperation) op3;

		// please note: 4 ops are necessary from this perspective
		// 0. index inside old parent of solution 2 must be tracked (index inside leafsection.modelElements)
		// 1. old solution of issue must be tracked
		// 2. old parent of solution 2 must be tracked (the leafsection)
		// 3. solution2 must announce its new issue

		// leaf section annouces loss of solution2 at index 0
		assertEquals("modelElements", refOp0.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp0.getModelElementId());
		assertFalse(refOp0.isAdd());
		assertEquals(1, refOp0.getReferencedModelElements().size());
		assertEquals(refOp0.getReferencedModelElements().get(0), solution2.getModelElementId());

		assertEquals(issue.getModelElementId(), refOp1.getModelElementId());
		assertEquals("solution", refOp1.getFeatureName());
		assertEquals(solution1.getModelElementId(), refOp1.getOldValue());
		assertEquals(solution2.getModelElementId(), refOp1.getNewValue());

		assertEquals(solution2.getModelElementId(), refOp2.getModelElementId());
		assertEquals("leafSection", refOp2.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp2.getOldValue());
		assertNull(refOp2.getNewValue());

		assertEquals(solution2.getModelElementId(), refOp3.getModelElementId());
		assertEquals("issue", refOp3.getFeatureName());
		assertNull(refOp3.getOldValue());
		assertEquals(issue.getModelElementId(), refOp3.getNewValue());

	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToValueContainedAlreadyNOperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(leafSection);
		getProject().addModelElement(solution);

		leafSection.getModelElements().add(solution);
		assertTrue(leafSection.getModelElements().contains(solution));

		clearOperations();

		issue.setSolution(solution);
		assertSame(solution, issue.getSolution());
		assertTrue(leafSection.getModelElements().isEmpty());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		AbstractOperation op0 = operations.get(0);
		AbstractOperation op1 = operations.get(1);
		AbstractOperation op2 = operations.get(2);

		assertEquals(true, op0 instanceof MultiReferenceOperation);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);

		MultiReferenceOperation refOp0 = (MultiReferenceOperation) op0;
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 3 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we also need track the index of issue 2 inside its former parent!

		// leaf section announces loss of solution2 at index 0
		assertEquals("modelElements", refOp0.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp0.getModelElementId());
		assertFalse(refOp0.isAdd());
		assertEquals(1, refOp0.getReferencedModelElements().size());
		assertEquals(refOp0.getReferencedModelElements().get(0), solution.getModelElementId());

		// first solution is losing its old leaf section parent
		assertEquals(solution.getModelElementId(), refOp1.getModelElementId());
		assertEquals("leafSection", refOp1.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp1.getOldValue());
		assertNull(refOp1.getNewValue());

		// second the solution is getting its new issue
		assertEquals(issue.getModelElementId(), refOp2.getModelElementId());
		assertEquals("solution", refOp2.getFeatureName());
		assertNull(refOp2.getOldValue());
		assertEquals(solution.getModelElementId(), refOp2.getNewValue());

	}

	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToValueContainedAlreadyNOperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(leafSection);
		getProject().addModelElement(solution);

		leafSection.getModelElements().add(solution);
		assertTrue(leafSection.getModelElements().contains(solution));

		clearOperations();

		solution.setIssue(issue);
		assertSame(solution, issue.getSolution());
		assertTrue(leafSection.getModelElements().isEmpty());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}
		assertEquals(3, operations.size());

		AbstractOperation op0 = operations.get(0);
		AbstractOperation op1 = operations.get(1);
		AbstractOperation op2 = operations.get(2);

		assertEquals(true, op0 instanceof MultiReferenceOperation);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);

		MultiReferenceOperation refOp0 = (MultiReferenceOperation) op0;
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 3 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we also need track the index of issue 2 inside its former parent!

		// please note: 3 ops are necessary from this perspective
		// 1. old solution of issue must be tracked
		// 2. old parent of solution 2 must be tracked (the leafsection)
		// 3. solution2 must announce its new issue

		// leaf section announces loss of solution at index 0
		assertEquals("modelElements", refOp0.getFeatureName());
		assertEquals(leafSection.getModelElementId(), refOp0.getModelElementId());
		assertFalse(refOp0.isAdd());
		assertEquals(1, refOp0.getReferencedModelElements().size());
		assertEquals(refOp0.getReferencedModelElements().get(0), solution.getModelElementId());

		assertEquals(solution.getModelElementId(), refOp1.getModelElementId());
		assertEquals("leafSection", refOp1.getFeatureName());
		assertNull(refOp1.getNewValue());
		assertEquals(leafSection.getModelElementId(), refOp1.getOldValue());

		assertEquals(solution.getModelElementId(), refOp2.getModelElementId());
		assertEquals("issue", refOp2.getFeatureName());
		assertNull(refOp2.getOldValue());
		assertEquals(issue.getModelElementId(), refOp2.getNewValue());

	}

	/**
	 * Change an containment attribute from some reference to null, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToNullOperateOnParent() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		assertEquals(issue.getSolution(), null);

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);
		issue.setSolution(solution);

		clearOperations();

		assertSame(solution, issue.getSolution());
		issue.setSolution(null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op = operations.get(0);
		assertEquals(true, op instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp = (SingleReferenceOperation) op;

		assertEquals(null, refOp.getNewValue());
		assertEquals(solution.getModelElementId(), refOp.getOldValue());
		assertEquals("solution", refOp.getFeatureName());
		assertEquals(issue.getModelElementId(), refOp.getModelElementId());
	}

	/**
	 * Change an containment attribute from some reference to null, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToNullOperateOnChild() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		assertEquals(issue.getSolution(), null);

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);
		issue.setSolution(solution);

		clearOperations();

		assertSame(solution, issue.getSolution());
		solution.setIssue(null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation op = operations.get(0);
		assertEquals(true, op instanceof SingleReferenceOperation);
		SingleReferenceOperation refOp = (SingleReferenceOperation) op;

		assertEquals(null, refOp.getNewValue());
		assertEquals(issue.getModelElementId(), refOp.getOldValue());
		assertEquals("issue", refOp.getFeatureName());
		assertEquals(solution.getModelElementId(), refOp.getModelElementId());
	}

}
