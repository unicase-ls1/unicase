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
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCanonizer;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;

/**
 * Tests canonization of composite operations.
 * 
 * @author chodnick
 */
public class CompositeTest extends CanonizationTest {

	/**
	 * Tests canonization of empty composite operations.
	 * 
	 * @throws InvalidHandleException if an error occurrs
	 */
	@Test
	public void emptyComposite() throws InvalidHandleException {

		// create an empty composite, should be canonized out
		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();
		handle.end("sectionCreation", "description", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(operations.size(), 1);
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 0);

	}

	/**
	 * Tests canonization for consecutive attribute changes, resulting in a noop.
	 * 
	 * @throws InvalidHandleException if error occurs
	 */
	@Test
	public void noOpComposite() throws InvalidHandleException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("C");
		useCase.setName("oldName");

		assertEquals("oldName", useCase.getName());

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		handle.end("blubb", "blibb", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		// should not have left any operations, we were just resetting the name to its original value
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 0);

	}

	/**
	 * Tests canonization for consecutive attribute changes, resulting in a noop.
	 * 
	 * @throws InvalidHandleException if error occurs
	 */
	@Test
	public void multiFeatureNoOpComposite() throws InvalidHandleException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");
		useCase.setDescription("oldDescription");

		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();

		useCase.setName("A");
		useCase.setDescription("X");
		useCase.setName("B");
		useCase.setDescription("Y");
		useCase.setName("C");

		useCase.setDescription("oldDescription");
		useCase.setName("oldName");

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		handle.end("blubb", "blibb", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		// should not have left any operations, we were just resetting the name to its original value
		OperationsCanonizer.canonize(operations);
		assertEquals(operations.size(), 0);

	}

	/**
	 * Tests canonization for composite ops, where main operation might be canonized away.
	 * 
	 * @throws InvalidHandleException if error occurs
	 */
	@Test
	public void mainDeleteCompositeImplicitRestore() throws InvalidHandleException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("newName");

		handle.end("blubb", "blibb", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		CompositeOperation comp = (CompositeOperation) operations.get(0);
		comp.setMainOperation(comp.getSubOperations().get(1)); // setName to from "A" to "B"
		OperationsCanonizer.canonize(operations);
		// the main one was a candidate for removal, but since it is the main one, it may not be touched
		// in this case it will not even be modified
		assertTrue(comp.getSubOperations().contains(comp.getMainOperation()));
	}

	/**
	 * Tests canonization for composite ops, where main operation might be canonized away.
	 * 
	 * @throws InvalidHandleException if error occurs
	 */
	@Test
	public void mainDeleteCompositeImplicitMainOpModification() throws InvalidHandleException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("newName");

		handle.end("blubb", "blibb", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		CompositeOperation comp = (CompositeOperation) operations.get(0);
		comp.setMainOperation(comp.getSubOperations().get(0)); // setName to from "oldName" to "A"
		OperationsCanonizer.canonize(operations);
		// the main one was a candidate for removal, but since it is the main one, it may not be removed
		// it might have been altered though (newValue, oldValue etc., might have changed in the canonization
		// process)
		assertTrue(comp.getSubOperations().contains(comp.getMainOperation()));
	}

	/**
	 * Tests canonization for composite ops, where main operation might be canonized away.
	 * 
	 * @throws InvalidHandleException if error occurs
	 */
	@Test
	public void mainDeleteNoOpComposite() throws InvalidHandleException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");

		clearOperations();

		CompositeOperationHandle handle = getProjectSpace().beginCompositeOperation();

		useCase.setName("A");
		useCase.setName("B");
		useCase.setName("oldName");

		handle.end("blubb", "blibb", null);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		CompositeOperation comp = (CompositeOperation) operations.get(0);
		comp.setMainOperation(comp.getSubOperations().get(1)); // setName to from "A" to "B"
		OperationsCanonizer.canonize(operations);
		// since this composite is a noop, everything should have been removed
		assertEquals(comp.getSubOperations().size(), 0);
	}

}
