/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;

/**
 * Tests the comnposite operation recording.
 * 
 * @author koegel
 */
public class CompositeOperationTest extends OperationTest {

	/**
	 * Test the creation and completion of a composite operation.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void createSmallComposite() throws InvalidHandleException {
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("Description");

		assertEquals(true, getProject().contains(section));
		assertEquals("Name", section.getName());
		assertEquals("Description", section.getDescription());
		assertEquals(0, section.getModelElements().size());

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setName("newName");
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);

		assertEquals(true, getProject().contains(useCase));
		assertEquals(getProject(), ModelUtil.getProject(useCase));
		assertEquals(useCase, section.getModelElements().iterator().next());
		assertEquals("newName", section.getName());
		assertEquals("newDescription", section.getDescription());

		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

		assertEquals(true, getProject().contains(useCase));
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
	 */
	@Test
	public void abortSmallComposite() throws InvalidHandleException {
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("Description");

		assertEquals(true, getProject().contains(section));
		assertEquals("Name", section.getName());
		assertEquals("Description", section.getDescription());
		assertEquals(0, section.getModelElements().size());

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setName("newName");
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);

		assertEquals(true, getProject().contains(useCase));
		assertEquals(getProject(), ModelUtil.getProject(useCase));
		assertEquals(useCase, section.getModelElements().iterator().next());
		assertEquals("newName", section.getName());
		assertEquals("newDescription", section.getDescription());

		handle.abort();

		assertEquals(true, getProject().contains(section));
		assertEquals("Name", section.getName());
		assertEquals("Description", section.getDescription());
		assertEquals(0, section.getModelElements().size());
		assertEquals(false, getProject().contains(useCase));

		assertEquals(0, getProjectSpace().getOperations().size());

	}
}
