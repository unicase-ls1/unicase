/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
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

				assertEquals(true, getProject().containsInstance(section));
				assertEquals("Name", section.getName());
				assertEquals("Description", section.getDescription());
				assertEquals(0, section.getModelElements().size());

				clearOperations();
			}
		}.run(false);

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
				section.setName("newName");
				section.setDescription("newDescription");
				section.getModelElements().add(useCase);

				assertEquals(true, getProject().containsInstance(useCase));
				assertEquals(getProject(), ModelUtil.getProject(useCase));
				assertEquals(useCase, section.getModelElements().iterator().next());
				assertEquals("newName", section.getName());
				assertEquals("newDescription", section.getDescription());

				ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);

				try {
					handle.end("sectionCreation", "description", sectionId);
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run(false);

		assertEquals(true, getProject().containsInstance(useCase));
		assertEquals(getProject(), ModelUtil.getProject(useCase));
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
	 * @throws IOException
	 */
	@Test
	public void abortSmallComposite() throws InvalidHandleException, IOException {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.setName("Name");
				section.setDescription("Description");

				assertEquals(true, getProject().containsInstance(section));
				assertEquals("Name", section.getName());
				assertEquals("Description", section.getDescription());
				assertEquals(0, section.getModelElements().size());

				clearOperations();
			}
		}.run(false);

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
				section.setName("newName");
				section.setDescription("newDescription");
				section.getModelElements().add(useCase);

				assertEquals(true, getProject().containsInstance(useCase));
				assertEquals(getProject(), ModelUtil.getProject(useCase));
				assertEquals(useCase, section.getModelElements().iterator().next());
				assertEquals("newName", section.getName());
				assertEquals("newDescription", section.getDescription());

				try {
					handle.abort();
				} catch (InvalidHandleException e) {
					fail();
				}
			}
		}.run(false);

		assertEquals(true, getProject().containsInstance(section));
		assertEquals("Name", section.getName());
		assertEquals("Description", section.getDescription());
		assertEquals(0, section.getModelElements().size());
		assertEquals(false, getProject().containsInstance(useCase));

		assertEquals(0, getProjectSpace().getOperations().size());

		Project loadedProject = ModelUtil.loadEObjectFromResource(MetamodelFactory.eINSTANCE.getMetamodelPackage()
			.getProject(), getProject().eResource().getURI(), false);

		assertTrue(ModelUtil.areEqual(loadedProject, getProject()));
		assertEquals(false, getProject().containsInstance(useCase));
		assertEquals(true, getProject().containsInstance(section));
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
				} catch (InvalidHandleException e) {
					throw new IllegalStateException(e);
				}

				assertEquals(workPackage, actionItem.getContainingWorkpackage());

			}
		}.run(false);
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
		}.run(false);
	}
}
