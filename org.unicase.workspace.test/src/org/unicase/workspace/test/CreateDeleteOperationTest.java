/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the MultiReferenceOperation.
 * @author koegel
 *
 */
public class CreateDeleteOperationTest extends OperationTest {
	
	/**
	 * Test element creation tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void createElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(false, createDeleteOperation.isDelete());
	}
	
	/**
	 * check element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void deleteElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		
		clearOperations();
		
		getProject().deleteModelElement(useCase);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(true, createDeleteOperation.isDelete());
	}
	
	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void complexDeleteElementTest() throws UnsupportedOperationException, UnsupportedNotificationException {
		//continue here
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		
		clearOperations();
		
		useCase.setInitiatingActor(oldActor);
		assertEquals(oldActor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		
		useCase.setInitiatingActor(newActor);
		
		clearOperations();
		
		getProject().deleteModelElement(useCase);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(true, createDeleteOperation.isDelete());
	}
}
