/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.topology;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertNull(op.getOldValue());
		assertEquals(op.getNewValue(), section.getModelElementId());

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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertNull(op.getNewValue());
		assertEquals(op.getOldValue(), section.getModelElementId());

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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("initiatingActor", op.getFeatureName());
		assertNull(op.getOldValue());
		assertEquals(op.getNewValue(), actor.getModelElementId());

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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
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
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
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

		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		assertEquals(br.getModelElementId(), op1.getModelElementId());
		assertEquals("leafSection", op1.getFeatureName());
		assertEquals(op1.getNewValue(), null);
		assertEquals(op1.getOldValue(), section.getModelElementId());

		assertTrue(operations.get(1) instanceof SingleReferenceOperation);
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		assertEquals(br.getModelElementId(), op2.getModelElementId());
		assertEquals("containingWorkpackage", op2.getFeatureName());
		assertEquals(op2.getOldValue(), null);
		assertEquals(op2.getNewValue(), pack.getModelElementId());

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
		assertEquals(2, operations.size());

		assertTrue(operations.get(0) instanceof SingleReferenceOperation);

		// first op is: solution loses its old parent
		SingleReferenceOperation op1 = (SingleReferenceOperation) operations.get(0);
		assertEquals(solution.getModelElementId(), op1.getModelElementId());
		assertEquals("issue", op1.getFeatureName());
		assertEquals(op1.getOldValue(), issue.getModelElementId());
		assertNull(op1.getNewValue());

		// second op is: solution annouces its new parent
		SingleReferenceOperation op2 = (SingleReferenceOperation) operations.get(1);
		assertEquals(solution.getModelElementId(), op2.getModelElementId());
		assertEquals("leafSection", op2.getFeatureName());
		assertEquals(op2.getNewValue(), section.getModelElementId());
		assertNull(op2.getOldValue());

	}

}
