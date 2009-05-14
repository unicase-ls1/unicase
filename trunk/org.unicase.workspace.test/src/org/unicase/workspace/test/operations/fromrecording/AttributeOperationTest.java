/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.fromrecording;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

import java.util.List;

/**
 * Tests the Attribute Operation.
 * @author chodnick
 *
 */
public class AttributeOperationTest extends OperationTest{

	/**
	 * Change an attribute and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttribute() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);

		clearOperations();
		
		useCase.setName("newName");
		assertEquals("newName", useCase.getName());
		
		List<AbstractOperation> operations = generateOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		
		assertEquals(null, attributeOperation.getOldValue());
		assertEquals("newName", attributeOperation.getNewValue());
		assertEquals("name", attributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), attributeOperation.getModelElementId());
	}
	
	/**
	 * Change an attribute twice and check the generated operations after cannonization.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttributeTwice() throws UnsupportedOperationException, UnsupportedNotificationException {
//		fail("not implemented yet, multiple chain conversion required, canonizer test");
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		
		clearOperations();
		
		useCase.setName("newName");
		useCase.setName("otherName");
		assertEquals("otherName", useCase.getName());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		
		assertEquals(null, attributeOperation.getOldValue());
		assertEquals("otherName", attributeOperation.getNewValue());
		assertEquals("name", attributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), attributeOperation.getModelElementId());
	}
	
	/**
	 * Change an attribute and reverse the operation and check the result.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttributeAndReverse() throws UnsupportedOperationException, UnsupportedNotificationException {
		
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		useCase.setName("oldName");
		
		clearOperations();
		
		useCase.setName("newName");
		assertEquals("newName", useCase.getName());
		
		List<AbstractOperation> operations = generateOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		
		assertEquals("oldName", attributeOperation.getOldValue());
		assertEquals("newName", attributeOperation.getNewValue());
		assertEquals("name", attributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), attributeOperation.getModelElementId());
		
		AbstractOperation reverse = operation.reverse();
		reverse.apply(getProject());
		assertEquals(true, reverse instanceof AttributeOperation);
		AttributeOperation reversedAttributeOperation = (AttributeOperation) reverse;
		assertEquals("newName", reversedAttributeOperation.getOldValue());
		assertEquals("oldName", reversedAttributeOperation.getNewValue());
		assertEquals("name", reversedAttributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), reversedAttributeOperation.getModelElementId());
		
		assertEquals("oldName", useCase.getName());
	}
}
