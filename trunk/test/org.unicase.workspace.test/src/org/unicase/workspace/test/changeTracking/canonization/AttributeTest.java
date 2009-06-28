/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.canonization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCanonizer;
import org.unicase.model.Project;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;

/**
 * Tests canonization of attribute operations.
 * 
 * @author chodnick
 */
public class AttributeTest extends CanonizationTest {

	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 */
	@Test
	public void consecutiveAttributeChangeSingleFeature() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setName("newName");

		assertEquals("newName", useCase.getName());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 1);

		AttributeOperation reverse = (AttributeOperation) operations.get(0).reverse();
		reverse.apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for consecutive attribute changes, resulting in a noop.
	 */
	@Test
	public void attributeChangeNoOp() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setName("oldName");

		assertEquals("oldName", useCase.getName());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// should not have created any operations, we were just resetting the name to its original value
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 0);

	}

	/**
	 * Tests canonization for consecutive attribute changes, resulting in a noop.
	 */
	@Test
	public void attributeChangeMultiFeatureNoOp() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");
		useCase.setDescription("oldDescription");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setDescription("X");
		useCase.setName("B");
		useCase.setDescription("Y");
		useCase.setName("C");

		useCase.setDescription("oldDescription");
		useCase.setName("oldName");

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// should not have created any operations, we were just resetting everything to its original value
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 0);

	}

	/**
	 * Tests canonization for consecutive attribute changes on multiple features.
	 */
	@Test
	public void consecutiveAttributeChangeMultiFeature() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setDescription("oldDescription");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setDescription("newDescription");
		useCase.setName("newName");

		assertEquals("newName", useCase.getName());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 2);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for mixed attribute changes on a single feature.
	 */
	@Test
	public void mixedAttributeChangeSingleFeature() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		getProject().addModelElement(section);

		useCase.setName("oldName");
		section.setName("some section");
		actor.setName("homer");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		actor.setName("maggie");
		useCase.setName("B");
		useCase.setInitiatingActor(actor);
		useCase.setName("C");
		section.setName("home");
		useCase.setName("newName");

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for mixed attribute changes on a single feature.
	 */
	@Test
	public void mixedAttributeChangeMultiFeature() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection oldSection = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		getProject().addModelElement(section);
		getProject().addModelElement(oldSection);

		useCase.setLeafSection(oldSection);
		actor.setLeafSection(oldSection);

		useCase.setName("oldName");
		oldSection.setName("oldSection");
		section.setName("some section");
		actor.setName("homer");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		actor.setName("maggie");
		useCase.setName("B");
		useCase.setDescription("some desc");
		useCase.setInitiatingActor(actor);
		useCase.setName("C");
		section.setName("home");
		useCase.setDescription("some other desc");
		useCase.setName("newName");
		useCase.setDescription("final desc");

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Test the creation and completion of a composite operation, that contains attribute changes.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void compositeAttributeChangesACA() throws InvalidHandleException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("oldDescription");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		section.setDescription("desc 1");

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		handle.end("sectionCreation", "description", section.getModelElementId());

		section.setDescription("desc 2");

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Test the creation and completion of a composite operation, that contains attribute changes.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void compositeAttributeChangesAC() throws InvalidHandleException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("oldDescription");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		section.setDescription("desc 1");

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		handle.end("sectionCreation", "description", section.getModelElementId());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Test the creation and completion of a composite operation, that contains attribute changes.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void compositeAttributeChangesCA() throws InvalidHandleException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("oldDescription");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		handle.end("sectionCreation", "description", section.getModelElementId());

		section.setDescription("desc 2");

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

}
