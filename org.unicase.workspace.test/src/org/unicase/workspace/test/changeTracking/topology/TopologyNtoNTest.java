/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.topology;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests operations in n:n topologies.
 * 
 * @author chodnick
 */
public class TopologyNtoNTest extends TopologyTest {

	/**
	 * Add to an empty annotation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void addToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);

		clearOperations();

		useCase.getAnnotations().add(mileStone);

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
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(1);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(mileStone.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);

	}

	/**
	 * Add many to an empty annotation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void addManyToEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone1 = TaskFactory.eINSTANCE.createMilestone();
		Milestone mileStone2 = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone1);
		getProject().addModelElement(mileStone2);

		Milestone[] stones = { mileStone1, mileStone2 };

		clearOperations();

		useCase.getAnnotations().addAll(Arrays.asList(stones));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		for (int i = 0; i < 2; i++) {
			assertTrue(subOperations.get(i) instanceof MultiReferenceOperation);
			MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(i);
			assertTrue(op.isAdd());
			assertEquals(1, op.getReferencedModelElements().size());
			assertEquals("annotatedModelElements", op.getFeatureName());
			assertEquals(op.getModelElementId(), stones[i].getModelElementId());
			assertEquals(op.getIndex(), 0);
		}

		assertTrue(subOperations.get(2) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(2);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(mileStone1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(mileStone2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
	}

	/**
	 * Add to a non-empty annotation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void addToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();
		Milestone otherMileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);
		getProject().addModelElement(otherMileStone);

		useCase.getAnnotations().add(otherMileStone);
		clearOperations();

		useCase.getAnnotations().add(mileStone);

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
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(1);
		assertTrue(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(mileStone.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);

	}

	/**
	 * Add many to an nonempty annotation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void addManyToNonEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone1 = TaskFactory.eINSTANCE.createMilestone();
		Milestone mileStone2 = TaskFactory.eINSTANCE.createMilestone();
		Milestone otherMileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone1);
		getProject().addModelElement(mileStone2);
		getProject().addModelElement(otherMileStone);

		Milestone[] stones = { mileStone1, mileStone2 };

		useCase.getAnnotations().add(otherMileStone);

		clearOperations();

		useCase.getAnnotations().addAll(Arrays.asList(stones));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		for (int i = 0; i < 2; i++) {
			assertTrue(subOperations.get(i) instanceof MultiReferenceOperation);
			MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(i);
			assertTrue(op.isAdd());
			assertEquals(1, op.getReferencedModelElements().size());
			assertEquals("annotatedModelElements", op.getFeatureName());
			assertEquals(op.getModelElementId(), stones[i].getModelElementId());
			assertEquals(op.getIndex(), 0);
		}

		assertTrue(subOperations.get(2) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(2);
		assertTrue(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(mileStone1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(mileStone2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 1);

	}

	/**
	 * Remove an element to empty annotations.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void removeAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);
		useCase.getAnnotations().add(mileStone);

		clearOperations();

		useCase.getAnnotations().remove(mileStone);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof CompositeOperation);

		operations = ((CompositeOperation) operations.get(0)).getSubOperations();

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) operations.get(1);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(mileStone.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);

	}

	/**
	 * Remove an element and leave non-empty annotations.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void removePart() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();
		Milestone otherMileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);
		getProject().addModelElement(otherMileStone);

		useCase.getAnnotations().add(mileStone);
		useCase.getAnnotations().add(otherMileStone);

		clearOperations();

		useCase.getAnnotations().remove(mileStone);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof CompositeOperation);

		operations = ((CompositeOperation) operations.get(0)).getSubOperations();

		assertTrue(operations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) operations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) operations.get(1);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(mileStone.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);

	}

	/**
	 * Remove some element and leave empty annotations.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void removeManyAndEmpty() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();
		Milestone otherMileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);
		getProject().addModelElement(otherMileStone);

		useCase.getAnnotations().add(mileStone);
		useCase.getAnnotations().add(otherMileStone);

		Milestone[] stones = { mileStone, otherMileStone };
		clearOperations();

		useCase.getAnnotations().removeAll(Arrays.asList(stones));

		// if you use clear instead of explicit removal, op.getIndex() will be -1
		// useCase.getAnnotations().clear();

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		assertTrue(subOperations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(1);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), otherMileStone.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(2) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(2);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(mileStone.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(otherMileStone.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);
	}

	/**
	 * Remove some element and leave non-empty annotations.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void removeManyPart() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone1 = TaskFactory.eINSTANCE.createMilestone();
		Milestone mileStone2 = TaskFactory.eINSTANCE.createMilestone();
		Milestone mileStone3 = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone1);
		getProject().addModelElement(mileStone2);
		getProject().addModelElement(mileStone3);

		useCase.getAnnotations().add(mileStone1);
		useCase.getAnnotations().add(mileStone2);
		useCase.getAnnotations().add(mileStone3);

		Milestone[] stones = { mileStone1, mileStone2 };
		clearOperations();

		useCase.getAnnotations().removeAll(Arrays.asList(stones));

		// if you use clear instead of explicit removal, op.getIndex() will be -1
		// useCase.getAnnotations().clear();

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertTrue(operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;

		List<AbstractOperation> subOperations = compositeOperation.getSubOperations();

		assertTrue(subOperations.get(0) instanceof MultiReferenceOperation);
		MultiReferenceOperation op = (MultiReferenceOperation) subOperations.get(0);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone1.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(1) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(1);
		assertFalse(op.isAdd());
		assertEquals(1, op.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals("annotatedModelElements", op.getFeatureName());
		assertEquals(op.getModelElementId(), mileStone2.getModelElementId());
		assertEquals(op.getIndex(), 0);

		assertTrue(subOperations.get(2) instanceof MultiReferenceOperation);
		op = (MultiReferenceOperation) subOperations.get(2);
		assertFalse(op.isAdd());
		assertEquals(2, op.getReferencedModelElements().size());
		assertEquals(mileStone1.getModelElementId(), op.getReferencedModelElements().get(0));
		assertEquals(mileStone2.getModelElementId(), op.getReferencedModelElements().get(1));
		assertEquals("annotations", op.getFeatureName());
		assertEquals(op.getModelElementId(), useCase.getModelElementId());
		assertEquals(op.getIndex(), 0);

	}

}
