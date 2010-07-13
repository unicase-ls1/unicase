/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests the comnposite operation recording.
 * 
 * @author koegel
 */
public class CompositeOperationTest extends WorkspaceTest {

	/**
	 * Test the creation and completion of a composite operation.
	 */
	@Test
	public void createSmallComposite() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.setName("Name");
				section.setDescription("Description");

				assertEquals(true, getProject().contains(section));
				assertEquals("Name", section.getName());
				assertEquals("Description", section.getDescription());
				assertEquals(0, section.getModelElements().size());

				clearOperations();
			}
		}.run();

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
				section.setName("newName");
				section.setDescription("newDescription");
				section.getModelElements().add(useCase);

				assertEquals(true, getProject().contains(useCase));
				assertEquals(getProject(), useCase.getProject());
				assertEquals(useCase, section.getModelElements().iterator().next());
				assertEquals("newName", section.getName());
				assertEquals("newDescription", section.getDescription());

				try {
					handle.end("sectionCreation", "description", section.getModelElementId());
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run();

		assertEquals(true, getProject().contains(useCase));
		assertEquals(getProject(), useCase.getProject());
		assertEquals(useCase, section.getModelElements().iterator().next());
		assertEquals("newName", section.getName());
		assertEquals("newDescription", section.getDescription());

		assertEquals(1, getProjectSpace().getOperations().size());
		AbstractOperation operation = getProjectSpace().getOperations().iterator().next();
		assertEquals(true, operation instanceof CompositeOperation);
		CompositeOperation compositeOperation = (CompositeOperation) operation;
		assertEquals(4, compositeOperation.getSubOperations().size());

	}

	/**
	 * Test the creation and abort of a composite operation.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void abortSmallComposite() throws InvalidHandleException {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.setName("Name");
				section.setDescription("Description");

				assertEquals(true, getProject().contains(section));
				assertEquals("Name", section.getName());
				assertEquals("Description", section.getDescription());
				assertEquals(0, section.getModelElements().size());

				clearOperations();
			}
		}.run();

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
				section.setName("newName");
				section.setDescription("newDescription");
				section.getModelElements().add(useCase);

				assertEquals(true, getProject().contains(useCase));
				assertEquals(getProject(), useCase.getProject());
				assertEquals(useCase, section.getModelElements().iterator().next());
				assertEquals("newName", section.getName());
				assertEquals("newDescription", section.getDescription());

				try {
					handle.abort();
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run();

		assertEquals(true, getProject().contains(section));
		assertEquals("Name", section.getName());
		assertEquals("Description", section.getDescription());
		assertEquals(0, section.getModelElements().size());
		assertEquals(false, getProject().contains(useCase));

		assertEquals(0, getProjectSpace().getOperations().size());

	}

	/**
	 * Test the creation and abort of a composite operation after some elements have been added. Check if the abort
	 * reverses the last operation.
	 */
	@Test
	public void beginAndAbortEmptyCompositeAfterSimpleOperation() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				clearOperations();
				cleanProjectSpace();
				final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
				final WorkPackage workPackage = TaskFactory.eINSTANCE.createWorkPackage();
				final ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
				getProject().addModelElement(section);
				getProject().addModelElement(workPackage);
				getProject().addModelElement(actionItem);
				actionItem.setContainingWorkpackage(workPackage);
				CompositeOperationHandle compositeOperationHandle = getProjectSpace().beginCompositeOperation();
				try {
					compositeOperationHandle.abort();
					if (actionItem.getContainingWorkpackage() != workPackage) {
						fail();
					}
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run();
	}

	/**
	 * Test the creation and abort of a composite operation.
	 */
	@Test
	public void beginAndAbortEmptyComposite() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				clearOperations();
				cleanProjectSpace();
				CompositeOperationHandle compositeOperationHandle = getProjectSpace().beginCompositeOperation();
				try {
					compositeOperationHandle.abort();
					compositeOperationHandle = getProjectSpace().beginCompositeOperation();
					compositeOperationHandle.abort();
					compositeOperationHandle = getProjectSpace().beginCompositeOperation();
					compositeOperationHandle.abort();
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run();
	}
}
