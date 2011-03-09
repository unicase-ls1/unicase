/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCanonizer;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests the Attribute Operation.
 * 
 * @author koegel
 */
public class AttributeOperationTest extends WorkspaceTest {

	/**
	 * Change an attribute and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttribute() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);

				clearOperations();

				useCase.setName("newName");
				assertEquals("newName", useCase.getName());
			}
		}.run();

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;

		assertEquals("new UseCase", attributeOperation.getOldValue());
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
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);

				clearOperations();

				useCase.setName("newName");
			}
		}.run();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				useCase.setName("otherName");
				assertEquals("otherName", useCase.getName());
			}
		}.run();

		final List<AbstractOperation> operations = getProjectSpace().getOperations();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				OperationsCanonizer.canonize(operations);
			}
		}.run();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;

		assertEquals("new UseCase", attributeOperation.getOldValue());
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

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				useCase.setName("oldName");

				clearOperations();

				useCase.setName("newName");
				assertEquals("newName", useCase.getName());
			}
		}.run();

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		final AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;

		assertEquals("oldName", attributeOperation.getOldValue());
		assertEquals("newName", attributeOperation.getNewValue());
		assertEquals("name", attributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), attributeOperation.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				AbstractOperation reverse = operation.reverse();
				reverse.apply(getProject());
				assertEquals(true, reverse instanceof AttributeOperation);
				AttributeOperation reversedAttributeOperation = (AttributeOperation) reverse;
				assertEquals("newName", reversedAttributeOperation.getOldValue());
				assertEquals("oldName", reversedAttributeOperation.getNewValue());
				assertEquals("name", reversedAttributeOperation.getFeatureName());
				assertEquals(useCase.getModelElementId(), reversedAttributeOperation.getModelElementId());
			}
		}.run();

		assertEquals("oldName", useCase.getName());
	}

	/**
	 * Test if attributeOperation.reverse().reverse() is a noop.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttributeDoubleReversal() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				useCase.setName("oldName");

				clearOperations();

				useCase.setName("newName");
				assertEquals("newName", useCase.getName());
			}
		}.run();

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);

		assertEquals(true, operation instanceof AttributeOperation);
		final AttributeOperation attributeOperation = (AttributeOperation) operation;

		AttributeOperation cmpOperation = (AttributeOperation) attributeOperation.reverse().reverse();

		assertEquals(attributeOperation.getFeatureName(), cmpOperation.getFeatureName());
		assertEquals(attributeOperation.getDescription(), cmpOperation.getDescription());
		assertEquals(attributeOperation.getModelElementId(), cmpOperation.getModelElementId());
		assertEquals(attributeOperation.getName(), cmpOperation.getName());
		assertEquals(attributeOperation.getNewValue(), cmpOperation.getNewValue());
		assertEquals(attributeOperation.getOldValue(), cmpOperation.getOldValue());

		Project expectedProject = ModelUtil.clone(getProject());

		final AbstractOperation r = attributeOperation.reverse();
		final AbstractOperation rr = r.reverse();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				r.apply(getProject());
				rr.apply(getProject());
			}
		}.run();

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				attributeOperation.reverse().apply(getProject());
				attributeOperation.reverse().reverse().apply(getProject());
			}
		}.run();

		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));

	}

}