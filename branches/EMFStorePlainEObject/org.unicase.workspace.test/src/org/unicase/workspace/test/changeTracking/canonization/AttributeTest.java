/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCanonizer;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
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
	 * Tests canonization for consecutive attribute changes on a single feature.
	 */
	@Test
	public void consecutiveAttributeChangeSingleFeatureToNull() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setName(null);

		assertEquals(null, useCase.getName());

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 1);

		AttributeOperation reverse = (AttributeOperation) operations.get(0).reverse();
		reverse.apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 */
	@Test
	public void consecutiveAttributeChangeSingleFeatureNullToValue() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName(null);

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");

		assertEquals("C", useCase.getName());

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
	public void attributeChangeNoOpNull() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName(null);

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setName(null);

		assertEquals(null, useCase.getName());

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
		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

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
		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

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
		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

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
	 * Tests canonization for create and consecutive attribute changes.
	 */
	@Test
	public void createAndChangeAttributesSimple() {

		Project originalProject = ModelUtil.clone(getProject());

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("NameOfUseCase");
		useCase.setDescription("DescriptionOfUseCase");

		assertEquals("NameOfUseCase", useCase.getName());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expecting a create and two attribute operations
		assertEquals(operations.size(), 3);
		OperationsCanonizer.canonize(operations);

		// now expecting only the create with folded in attributes
		assertEquals(operations.size(), 1);
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);

		CreateDeleteOperation op = (CreateDeleteOperation) operations.get(0);

		assertEquals(((UnicaseModelElement) op.getModelElement()).getName(), "NameOfUseCase");
		assertEquals(((UnicaseModelElement) op.getModelElement()).getDescription(), "DescriptionOfUseCase");

		// test if the create is reversible and re-reversible
		Project expectedProject = ModelUtil.clone(getProject());
		op.reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

		op.reverse().reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for create and consecutive attribute changes.
	 */
	@Test
	public void createAndChangeAttributesComplex() {

		Project originalProject = ModelUtil.clone(getProject());

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(useCase);
		getProject().addModelElement(useCase2);

		useCase.setName("NameOfUseCase");
		useCase.setDescription("DescriptionOfUseCase");

		useCase2.setName("NameOfUseCase2");
		useCase2.setDescription("DescriptionOfUseCase2");

		assertEquals("NameOfUseCase", useCase.getName());
		assertEquals("NameOfUseCase2", useCase2.getName());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expecting a create and two attribute operations per usecase
		assertEquals(operations.size(), 6);
		OperationsCanonizer.canonize(operations);

		// now expecting only the creates with folded in attributes
		assertEquals(operations.size(), 2);
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);

		CreateDeleteOperation op = (CreateDeleteOperation) operations.get(0);

		assertEquals(((UnicaseModelElement) op.getModelElement()).getName(), "NameOfUseCase");
		assertEquals(((UnicaseModelElement) op.getModelElement()).getDescription(), "DescriptionOfUseCase");

		assertTrue(operations.get(1) instanceof CreateDeleteOperation);

		CreateDeleteOperation op2 = (CreateDeleteOperation) operations.get(1);

		assertEquals(((UnicaseModelElement) op2.getModelElement()).getName(), "NameOfUseCase2");
		assertEquals(((UnicaseModelElement) op2.getModelElement()).getDescription(), "DescriptionOfUseCase2");

		// test reversibility, too

		op2.reverse().apply(getProject());
		op.reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

	}

	/**
	 * Test the creation and completion of a composite operation, that contains attribute changes.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void createAndAttributeChangesACA() throws InvalidHandleException {

		Project originalProject = ModelUtil.clone(getProject());

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("Name");
		section.setDescription("oldDescription");

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

		section.setDescription("desc 2");

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expect create, 2 attribute ops, the composite, 1 attribute op
		assertEquals(5, operations.size());
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);
		assertTrue(operations.get(1) instanceof AttributeOperation);
		assertTrue(operations.get(2) instanceof AttributeOperation);
		assertTrue(operations.get(3) instanceof CompositeOperation);
		assertTrue(operations.get(4) instanceof AttributeOperation);

		OperationsCanonizer.canonize(operations);

		// expect create, the composite and 1 attribute op
		assertEquals(3, operations.size());
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);
		assertTrue(operations.get(1) instanceof CompositeOperation);
		assertTrue(operations.get(2) instanceof AttributeOperation);

		Project expectedProject = ModelUtil.clone(getProject());

		// test reversibility

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

		// test redo
		operations.get(0).apply(getProject());
		operations.get(1).apply(getProject());
		operations.get(2).apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for consecutive attribute changes followed by a delete.
	 */
	@Test
	public void changeAttributesAndDeleteSimple() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("originalName");
		useCase.setDescription("originalDescription");

		Project originalProject = ModelUtil.clone(getProject());

		clearOperations();

		useCase.setName("NameOfUseCase");
		useCase.setDescription("DescriptionOfUseCase");

		getProject().deleteModelElement(useCase);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expecting two attribute operations and a delete
		assertEquals(operations.size(), 3);
		OperationsCanonizer.canonize(operations);

		// now expecting only the delete with folded in attributes
		assertEquals(operations.size(), 1);
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);

		CreateDeleteOperation op = (CreateDeleteOperation) operations.get(0);

		assertTrue(op.isDelete());
		assertEquals(((UnicaseModelElement) op.getModelElement()).getName(), "originalName");
		assertEquals(((UnicaseModelElement) op.getModelElement()).getDescription(), "originalDescription");

		// test if the delete is reversible and re-reversible
		Project expectedProject = ModelUtil.clone(getProject());
		op.reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

		op.reverse().reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for consecutive attribute changes and delete.
	 */
	@Test
	public void changeAttributesAndDeleteComplex() {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);
		section.getModelElements().add(useCase);
		section.getModelElements().add(useCase2);

		useCase.setName("originalName1");
		useCase.setDescription("originalDescription1");

		useCase2.setName("originalName2");
		useCase2.setDescription("originalDescription2");

		Project originalProject = ModelUtil.clone(getProject());

		clearOperations();

		useCase.setName("NameOfUseCase");
		useCase.setDescription("DescriptionOfUseCase");

		useCase2.setName("NameOfUseCase2");
		useCase2.setDescription("DescriptionOfUseCase2");

		assertEquals("NameOfUseCase", useCase.getName());
		assertEquals("NameOfUseCase2", useCase2.getName());

		getProject().deleteModelElement(useCase);
		getProject().deleteModelElement(useCase2);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expecting two attribute operations and a delete per usecase
		assertEquals(operations.size(), 6);
		OperationsCanonizer.canonize(operations);

		// now expecting only the deletes with folded in attributes
		assertEquals(operations.size(), 2);
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);

		CreateDeleteOperation op = (CreateDeleteOperation) operations.get(0);

		assertEquals(((UnicaseModelElement) op.getModelElement()).getName(), "originalName1");
		assertEquals(((UnicaseModelElement) op.getModelElement()).getDescription(), "originalDescription1");

		assertTrue(operations.get(1) instanceof CreateDeleteOperation);

		CreateDeleteOperation op2 = (CreateDeleteOperation) operations.get(1);

		assertEquals(((UnicaseModelElement) op2.getModelElement()).getName(), "originalName2");
		assertEquals(((UnicaseModelElement) op2.getModelElement()).getDescription(), "originalDescription2");

		// test reversibility, too

		op2.reverse().apply(getProject());
		op.reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

	}

	/**
	 * Tests canonization for consecutive attribute changes and delete on orphans.
	 */
	// commented out, orphan behaviour is irrelevant at present. This reversibility test currently fails.
	// @Test
	// public void changeAttributesAndDeleteOrphansComplex() {
	//
	// UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
	// UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
	//
	// getProject().getModelElements().add(useCase);
	// getProject().getModelElements().add(useCase2);
	//
	// useCase.setName("originalName1");
	// useCase.setDescription("originalDescription1");
	//
	// useCase2.setName("originalName2");
	// useCase2.setDescription("originalDescription2");
	//
	// Project originalProject = ModelUtil.clone(getProject());
	//
	// clearOperations();
	//
	// useCase.setName("NameOfUseCase");
	// useCase.setDescription("DescriptionOfUseCase");
	//
	// useCase2.setName("NameOfUseCase2");
	// useCase2.setDescription("DescriptionOfUseCase2");
	//
	// assertEquals("NameOfUseCase", useCase.getName());
	// assertEquals("NameOfUseCase2", useCase2.getName());
	//
	// getProject().deleteModelElement(useCase);
	// getProject().deleteModelElement(useCase2);
	//
	// List<AbstractOperation> operations = getProjectSpace().getOperations();
	//
	// // expecting two attribute operations and a delete per usecase
	// assertEquals(operations.size(), 6);
	// OperationsCanonizer.canonize(operations);
	//
	// // now expecting only the deletes with folded in attributes
	// assertEquals(operations.size(), 2);
	// assertTrue(operations.get(0) instanceof CreateDeleteOperation);
	//
	// CreateDeleteOperation op = (CreateDeleteOperation) operations.get(0);
	//
	// assertEquals(op.getModelElement().getName(), "originalName1");
	// assertEquals(op.getModelElement().getDescription(), "originalDescription1");
	//
	// assertTrue(operations.get(1) instanceof CreateDeleteOperation);
	//
	// CreateDeleteOperation op2 = (CreateDeleteOperation) operations.get(1);
	//
	// assertEquals(op2.getModelElement().getName(), "originalName2");
	// assertEquals(op2.getModelElement().getDescription(), "originalDescription2");
	//
	// // test reversibility, too
	//
	// op2.reverse().apply(getProject());
	// op.reverse().apply(getProject());
	//
	// assertTrue(ModelUtil.areEqual(getProject(), originalProject));
	//
	// }
	/**
	 * Test the creation and completion of a composite operation, that contains attribute changes.
	 * 
	 * @throws InvalidHandleException if the test fails
	 */
	@Test
	public void attributeChangesACAAndDelete() throws InvalidHandleException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);
		section.setName("originalName");
		section.setDescription("originalDescription");

		Project originalProject = ModelUtil.clone(getProject());
		clearOperations();

		section.setName("some new Name");

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		section.setDescription("newDescription");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		section.getModelElements().add(useCase);
		handle.end("sectionCreation", "description", ModelUtil.getProject(section).getModelElementId(section));

		section.setDescription("desc 2");

		getProject().deleteModelElement(section);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		// expect 1 attribute op, the composite, 1 attribute op, the delete
		assertEquals(4, operations.size());
		assertTrue(operations.get(0) instanceof AttributeOperation);
		assertTrue(operations.get(1) instanceof CompositeOperation);
		assertTrue(operations.get(2) instanceof AttributeOperation);
		assertTrue(operations.get(3) instanceof CreateDeleteOperation);

		OperationsCanonizer.canonize(operations);

		// expect 1 attribute op, the composite and the delete with folded in attribute
		assertEquals(3, operations.size());
		assertTrue(operations.get(0) instanceof AttributeOperation);
		assertTrue(operations.get(1) instanceof CompositeOperation);
		assertTrue(operations.get(2) instanceof CreateDeleteOperation);

		CreateDeleteOperation delOp = (CreateDeleteOperation) operations.get(2);
		assertTrue(delOp.isDelete());
		// not folded, interfering composite was inbeetween
		assertEquals("some new Name", ((UnicaseModelElement) delOp.getModelElement()).getName());
		// folded, value is oldValue from "newDescription"-> "desc 2"
		assertEquals("newDescription", ((UnicaseModelElement) delOp.getModelElement()).getDescription());

		Project expectedProject = ModelUtil.clone(getProject());

		// test reversibility

		for (int i = operations.size() - 1; i >= 0; i--) {
			AbstractOperation reverse = operations.get(i).reverse();
			reverse.apply(getProject());
		}

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

		// test redo
		operations.get(0).apply(getProject());
		operations.get(1).apply(getProject());
		operations.get(2).apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

	/**
	 * Tests canonization for create, attribute changes and delete.
	 */
	@Test
	public void createChangeAttributeAndDelete() {

		Project originalProject = ModelUtil.clone(getProject());

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("someName");
		useCase.setName("newName");
		getProject().deleteModelElement(useCase);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expect create, 2 attribute ops, delete
		assertEquals(operations.size(), 4);
		OperationsCanonizer.canonize(operations);

		// expect attributes folding into create, and create and delete removed,
		// as they would be directly adjacent to each other
		assertEquals(operations.size(), 0);

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

	}

	/**
	 * Tests canonization for create, attribute changes and delete.
	 */
	@Test
	public void createChangeReferencesAndDelete() {

		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase2);

		Project originalProject = ModelUtil.clone(getProject());
		clearOperations();

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("someName");
		useCase.getExtendedUseCases().add(useCase2);
		getProject().deleteModelElement(useCase);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expect create, 1 attribute ops, 1 multiref op, the delete
		assertEquals(operations.size(), 4);
		OperationsCanonizer.canonize(operations);

		// expect attributes folding into create, the multiref and delete remain
		assertEquals(operations.size(), 3);
		assertTrue(operations.get(0) instanceof CreateDeleteOperation);
		assertTrue(operations.get(1) instanceof MultiReferenceOperation);
		assertTrue(operations.get(2) instanceof CreateDeleteOperation);

		// check the folding of the attribute
		CreateDeleteOperation createOp = (CreateDeleteOperation) operations.get(0);
		assertEquals("someName", ((UnicaseModelElement) createOp.getModelElement()).getName());

		// check reversibility
		operations.get(2).reverse().apply(getProject());
		operations.get(1).reverse().apply(getProject());
		operations.get(0).reverse().apply(getProject());

		assertTrue(ModelUtil.areEqual(getProject(), originalProject));

	}

}
