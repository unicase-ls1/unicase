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

/**
 * Tests operations in n:1 topologies.
 * 
 * @author chodnick
 */
public class TopologyNto1Test extends TopologyTest {

	/**
	 * Set a container from null to some value.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setContainerFromNullToValue() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);

		clearOperations();

		useCase.setLeafSection(section);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		assertTrue(subOperations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals("modelElements", op.getFeatureName());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(op.getModelElementId(), section.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof SingleReferenceOperation);
		SingleReferenceOperation sop = (SingleReferenceOperation) subOperations.get(1);
		assertEquals(useCase.getModelElementId(), sop.getModelElementId());
		assertEquals("leafSection", sop.getFeatureName());
		assertNull(sop.getOldValue());
		assertEquals(sop.getNewValue(), section.getModelElementId());

	}

	/**
	 * Set a container from some value to null.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setContainerFromValueToNull() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);
		useCase.setLeafSection(section);
		assertTrue(section.getModelElements().contains(useCase));

		clearOperations();

		useCase.setLeafSection(null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op0 = (MultiReferenceOperation) operations.get(0);
		assertEquals(section.getModelElementId(), op0.getModelElementId());
		assertEquals("modelElements", op0.getFeatureName());
		assertEquals(op0.getReferencedModelElements().get(0), useCase.getModelElementId());

		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(1);
		assertEquals(useCase.getModelElementId(), op1.getModelElementId());
		assertEquals("leafSection", op1.getFeatureName());
		assertNull(op1.getNewValue());
		assertEquals(op1.getOldValue(), section.getModelElementId());

	}

	/**
	 * Set a non-containing parent from null to some value.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setNoncontainingParentFromNullToValue() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(actor);
		getProject().addModelElement(useCase);
		assertNull(useCase.getInitiatingActor());

		clearOperations();
		useCase.setInitiatingActor(actor);
		assertSame(useCase.getInitiatingActor(), actor);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		assertTrue(subOperations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(0);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals("initiatedUseCases", op.getFeatureName());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(op.getModelElementId(), actor.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof SingleReferenceOperation);
		SingleReferenceOperation sop = (SingleReferenceOperation) subOperations.get(1);
		assertEquals(useCase.getModelElementId(), sop.getModelElementId());
		assertEquals("initiatingActor", sop.getFeatureName());
		assertNull(sop.getOldValue());
		assertEquals(sop.getNewValue(), actor.getModelElementId());

	}

	/**
	 * Set a non-containing parent from some value to null.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setNoncontainingParentFromValueToNull() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(actor);
		getProject().addModelElement(useCase);
		useCase.setInitiatingActor(actor);
		assertSame(useCase.getInitiatingActor(), actor);

		clearOperations();
		useCase.setInitiatingActor(null);
		assertNull(useCase.getInitiatingActor());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op0 = (MultiReferenceOperation) operations.get(0);
		assertEquals(actor.getModelElementId(), op0.getModelElementId());
		assertEquals("initiatedUseCases", op0.getFeatureName());
		assertEquals(op0.getReferencedModelElements().get(0), useCase.getModelElementId());

		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(1);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("initiatingActor", op.getFeatureName());
		assertNull(op.getNewValue());
		assertEquals(op.getOldValue(), actor.getModelElementId());

	}

	/**
	 * Set a non-containing parent from some value to some.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setNoncontainingParentFromValueToOtherValue() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor otherActor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(actor);
		getProject().addModelElement(otherActor);
		getProject().addModelElement(useCase);
		useCase.setInitiatingActor(actor);
		assertSame(useCase.getInitiatingActor(), actor);

		clearOperations();
		useCase.setInitiatingActor(otherActor);
		assertSame(otherActor, useCase.getInitiatingActor());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());

		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op0 = (MultiReferenceOperation) operations.get(0);
		assertEquals(actor.getModelElementId(), op0.getModelElementId());
		assertEquals("initiatedUseCases", op0.getFeatureName());
		assertEquals(op0.getReferencedModelElements().get(0), useCase.getModelElementId());
		assertFalse(op0.isAdd());

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op1 = (MultiReferenceOperation) operations.get(1);
		assertEquals(otherActor.getModelElementId(), op1.getModelElementId());
		assertEquals("initiatedUseCases", op1.getFeatureName());
		assertEquals(op1.getReferencedModelElements().get(0), useCase.getModelElementId());
		assertTrue(op1.isAdd());

		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(2);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("initiatingActor", op.getFeatureName());
		assertEquals(op.getNewValue(), otherActor.getModelElementId());
		assertEquals(op.getOldValue(), actor.getModelElementId());
	}

	/**
	 * Set a container from some value to some other value on same feature though.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */

	@Test
	public void setContainerFromValueToOtherValueSameFeature() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(useCase);
		useCase.setLeafSection(section1);

		assertTrue(section1.getModelElements().contains(useCase));

		clearOperations();

		useCase.setLeafSection(section2);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());

		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(3, operations.size());

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op0 = (MultiReferenceOperation) operations.get(0);
		assertEquals(section1.getModelElementId(), op0.getModelElementId());
		assertEquals("modelElements", op0.getFeatureName());
		assertEquals(op0.getReferencedModelElements().get(0), useCase.getModelElementId());
		assertFalse(op0.isAdd());

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op1 = (MultiReferenceOperation) operations.get(1);
		assertEquals(section2.getModelElementId(), op1.getModelElementId());
		assertEquals("modelElements", op1.getFeatureName());
		assertEquals(op1.getReferencedModelElements().get(0), useCase.getModelElementId());
		assertTrue(op1.isAdd());

		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(2);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertEquals(op.getNewValue(), section2.getModelElementId());
		assertEquals(op.getOldValue(), section1.getModelElementId());

	}

	/**
	 * Set a container from some value to some other value on different features though.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */

	@Test
	public void setContainerFromValueToOtherValueDifferentFeatureN() throws UnsupportedOperationException,
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

		br.setContainingWorkpackage(pack);
		assertFalse(section.getModelElements().contains(br));
		assertTrue(pack.getContainedWorkItems().contains(br));

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(4, operations.size());

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op0 = (MultiReferenceOperation) operations.get(0);
		assertEquals(section.getModelElementId(), op0.getModelElementId());
		assertEquals("modelElements", op0.getFeatureName());
		assertEquals(op0.getReferencedModelElements().get(0), br.getModelElementId());

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op1 = (MultiReferenceOperation) operations.get(1);
		assertEquals(pack.getModelElementId(), op1.getModelElementId());
		assertEquals("containedWorkItems", op1.getFeatureName());
		assertEquals(op1.getReferencedModelElements().get(0), br.getModelElementId());

		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(2);
		assertEquals(br.getModelElementId(), op2.getModelElementId());
		assertEquals("leafSection", op2.getFeatureName());
		assertEquals(op2.getNewValue(), null);
		assertEquals(op2.getOldValue(), section.getModelElementId());

		assertTrue(operations.get(3) instanceof SingleReferenceOperation);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(3);
		assertEquals(br.getModelElementId(), op3.getModelElementId());
		assertEquals("containingWorkpackage", op3.getFeatureName());
		assertEquals(op3.getOldValue(), null);
		assertEquals(op3.getNewValue(), pack.getModelElementId());

	}

	/**
	 * Set a container from some value to some other value on different features though.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */

	@Test
	public void setContainerFromValueToOtherValueDifferentFeature1() throws UnsupportedOperationException,
		UnsupportedNotificationException {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(section);
		getProject().addModelElement(solution);
		issue.setSolution(solution);

		clearOperations();

		solution.setLeafSection(section);

		assertTrue(section.getModelElements().contains(solution));
		assertNull(issue.getSolution());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expecting a composite operation here
		assertEquals(1, operations.size());
		if (operations.get(0) instanceof CompositeOperation) {
			operations = ((CompositeOperation) operations.get(0)).getSubOperations();
		} else {
			fail("composite operation expected");
		}

		assertEquals(4, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op0 = (SingleReferenceOperation) operations.get(0);
		assertEquals(issue.getModelElementId(), op0.getModelElementId());
		assertEquals("solution", op0.getFeatureName());
		assertEquals(op0.getOldValue(), solution.getModelElementId());
		assertNull(op0.getNewValue());

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		MultiReferenceOperation op1 = (MultiReferenceOperation) operations.get(1);
		assertEquals(section.getModelElementId(), op1.getModelElementId());
		assertEquals("modelElements", op1.getFeatureName());
		assertEquals(op1.getReferencedModelElements().get(0), solution.getModelElementId());

		assertTrue(operations.get(2) instanceof SingleReferenceOperation);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(2);
		assertEquals(solution.getModelElementId(), op2.getModelElementId());
		assertEquals("issue", op2.getFeatureName());
		assertEquals(op2.getOldValue(), issue.getModelElementId());
		assertNull(op2.getNewValue());

		assertTrue(operations.get(3) instanceof SingleReferenceOperation);
		SingleReferenceOperation op3 = (SingleReferenceOperation) operations.get(3);
		assertEquals(solution.getModelElementId(), op3.getModelElementId());
		assertEquals("leafSection", op3.getFeatureName());
		assertEquals(op3.getNewValue(), section.getModelElementId());
		assertNull(op3.getOldValue());

	}

}
