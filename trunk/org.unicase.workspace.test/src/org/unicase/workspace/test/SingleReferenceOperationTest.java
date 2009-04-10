/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCannonizer;
import org.unicase.model.ModelElementId;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.OperationParser;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the SingleReferenceOperation.
 * @author koegel
 *
 */
public class SingleReferenceOperationTest extends OperationTest {

	/**
	 * Change a single reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		clearNotifications();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);
		useCase.setInitiatingActor(actor);
		
		assertEquals(actor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(2, getNotifications().size());
		assertEquals(2, getNotificationsMap().size());
		
		Notification notification = getNotifications().get(0);
		List<AbstractOperation> operations = OperationParser.parseOperations(notification, getNotificationsMap().get(notification));
		Notification notification2 = getNotifications().get(1);
		operations.addAll(OperationParser.parseOperations(notification2, getNotificationsMap().get(notification2)));
		
		OperationsCannonizer.cannonize(operations);
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(null, singleReferenceOperation.getOldValue());
		assertEquals(actor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(actor.getModelElementId(), otherInvolvedModelElements.iterator().next());
	}
	
	/**
	 * Change an single reference twice and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeSingleReferenceTwice() throws UnsupportedOperationException, UnsupportedNotificationException {
		clearNotifications();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		useCase.setInitiatingActor(oldActor);
		assertEquals(oldActor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(2, getNotifications().size());
		assertEquals(2, getNotificationsMap().size());
		
		useCase.setInitiatingActor(newActor);
		assertEquals(newActor, useCase.getInitiatingActor());
		initiatedUseCases = newActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(5, getNotifications().size());
		assertEquals(5, getNotificationsMap().size());
		
		List<AbstractOperation> operations = new ArrayList<AbstractOperation>();
		for (Notification notification: getNotifications()) {
			operations.addAll(OperationParser.parseOperations(notification, getNotificationsMap().get(notification)));
		}
		
		OperationsCannonizer.cannonize(operations);
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(null, singleReferenceOperation.getOldValue());
		assertEquals(newActor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(newActor.getModelElementId(), otherInvolvedModelElements.iterator().next());
	}
	
	/**
	 * Change an single reference and reverse it.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void reverseSingleReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		clearNotifications();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);
		Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(oldActor);
		Actor newActor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(newActor);
		useCase.setInitiatingActor(oldActor);
		assertEquals(oldActor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = oldActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(2, getNotifications().size());
		assertEquals(2, getNotificationsMap().size());
		clearNotifications();
		
		useCase.setInitiatingActor(newActor);
		assertEquals(newActor, useCase.getInitiatingActor());
		initiatedUseCases = newActor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(3, getNotifications().size());
		assertEquals(3, getNotificationsMap().size());
		
		List<AbstractOperation> operations = new ArrayList<AbstractOperation>();
		for (Notification notification: getNotifications()) {
			operations.addAll(OperationParser.parseOperations(notification, getNotificationsMap().get(notification)));
		}
		
		OperationsCannonizer.cannonize(operations);
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof SingleReferenceOperation);
		SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
		
		assertEquals(oldActor.getModelElementId(), singleReferenceOperation.getOldValue());
		assertEquals(newActor.getModelElementId(), singleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", singleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), singleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", singleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, singleReferenceOperation.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = singleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(oldActor.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(newActor.getModelElementId()));
		
		
		
		AbstractOperation reverse = singleReferenceOperation.reverse();
		assertEquals(true, reverse instanceof SingleReferenceOperation);
		SingleReferenceOperation reversedSingleReferenceOperation = (SingleReferenceOperation) reverse;
		
		reversedSingleReferenceOperation.apply(getProject());
		
		assertEquals(oldActor, useCase.getInitiatingActor());
		
		assertEquals(newActor.getModelElementId(), reversedSingleReferenceOperation.getOldValue());
		assertEquals(oldActor.getModelElementId(), reversedSingleReferenceOperation.getNewValue());
		assertEquals("initiatingActor", reversedSingleReferenceOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), reversedSingleReferenceOperation.getModelElementId());
		assertEquals("initiatedUseCases", reversedSingleReferenceOperation.getOppositeFeatureName());
		assertEquals(true, reversedSingleReferenceOperation.isBidirectional());
		otherInvolvedModelElements = reversedSingleReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(2, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(oldActor.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(newActor.getModelElementId()));
	}
}
