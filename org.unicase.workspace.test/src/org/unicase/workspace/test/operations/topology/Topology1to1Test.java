/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.topology;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

import java.util.List;

/**
 * Tests operations in 1:1 topologies.
 * @author chodnick
 *
 */
public class Topology1to1Test extends TopologyTest{

	/**
	 * Change an containment attribute from null to some reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentNullToValueNotContainedAlready() throws UnsupportedOperationException, UnsupportedNotificationException {

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
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueNotContainedAlready() throws UnsupportedOperationException, UnsupportedNotificationException {

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
	public void containmentValueToOtherValueContainedAlready1() throws UnsupportedOperationException, UnsupportedNotificationException {

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
		
		assertEquals(2, operations.size());
		AbstractOperation op1 = operations.get(0);
		AbstractOperation op2 = operations.get(1);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);
		
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 2 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we need to track the parent of issue 2!
		
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
	public void containmentNullToValueContainedAlready1() throws UnsupportedOperationException, UnsupportedNotificationException {

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution1);
		
		issue1.setSolution(solution1);
		assertEquals(issue1.getSolution(), solution1);
		
		clearOperations();
		
		issue2.setSolution(solution1);
		assertSame(solution1, issue2.getSolution());
		assertNull(issue1.getSolution());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		fail("not sure about the behaviour");
		assertEquals(1, operations.size());
		AbstractOperation op1 = operations.get(0);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		
		SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;

		// solution is getting its new parent
		assertEquals(issue1.getModelElementId(), refOp1.getOldValue());
		assertEquals(issue2.getModelElementId(), refOp1.getNewValue());
		assertEquals("issue", refOp1.getFeatureName());
		assertEquals(solution1.getModelElementId(), refOp1.getModelElementId());
		
	}		
	
	/**
	 * Change an containment attribute from some reference to some other reference, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToOtherValueContainedAlreadyN() throws UnsupportedOperationException, UnsupportedNotificationException {

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
		fail("not sure what the expected behaviour is");
		assertEquals(2, operations.size());
		AbstractOperation op1 = operations.get(0);
		AbstractOperation op2 = operations.get(1);
		assertEquals(true, op1 instanceof SingleReferenceOperation);
		assertEquals(true, op2 instanceof SingleReferenceOperation);
		
		//SingleReferenceOperation refOp1 = (SingleReferenceOperation) op1;
		SingleReferenceOperation refOp2 = (SingleReferenceOperation) op2;

		// please note: 2 ops are necessary, this is because the oldvalues are necessary for
		// the ops to be reversible! we need to track the parent of issue 2!
		
		// first solution 2 is getting its new parent
		
/*		assertEquals(issue2.getModelElementId(), refOp1.getOldValue());
		assertEquals(issue1.getModelElementId(), refOp1.getNewValue());
		assertEquals("issue", refOp1.getFeatureName());
		assertEquals(solution2.getModelElementId(), refOp1.getModelElementId());
	*/	
		// second the issue 1 is getting its new child
		assertEquals(solution1.getModelElementId(), refOp2.getOldValue());
		assertEquals(solution2.getModelElementId(), refOp2.getNewValue());
		assertEquals("solution", refOp2.getFeatureName());
		assertEquals(issue.getModelElementId(), refOp2.getModelElementId());
	}		

	/**
	 * Change an containment attribute from some reference to null, and check resulting op.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void containmentValueToNull() throws UnsupportedOperationException, UnsupportedNotificationException {

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
	
}
