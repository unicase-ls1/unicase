/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.junit.Before;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.workspace.changeTracking.OperationParser;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the Attribute Operation.
 * @author koegel
 *
 */
public class AttributeOperationTest {

	private List<Notification> notifications;
	private Project project;
	private Map<Notification, ModelElement> notificationsMap;
	
	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProject() {
		project = ModelFactory.eINSTANCE.createProject();
		notifications = new ArrayList<Notification>();
		notificationsMap = new HashMap<Notification, ModelElement>();
		ProjectChangeObserver observer = new ProjectChangeObserver(){
		
			public void modelElementRemoved(Project project, ModelElement modelElement) {
				//do nothing
			}
		
			public void modelElementDeleteStarted(ModelElement modelElement) {
				//do nothing			
			}
		
			public void modelElementDeleteCompleted(ModelElement modelElement) {
				//do nothing
			}
		
			public void modelElementAdded(Project project, ModelElement modelElement) {
				//do nothing	
			}

			public void notify(Notification notification, Project project,
					ModelElement modelElement) {
				notifications.add(notification);
				notificationsMap.put(notification, modelElement);
			}

		};
		project.addProjectChangeObserver(observer);
	}
	
	/**
	 * Change an attribute and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttribute() throws UnsupportedOperationException, UnsupportedNotificationException {
		notifications.clear();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		project.addModelElement(useCase);
		useCase.setName("newName");
		assertEquals("newName", useCase.getName());
		assertEquals(1, notifications.size());
		assertEquals(1, notificationsMap.size());
		
		Notification notification = notifications.get(0);
		List<AbstractOperation> operations = OperationParser.parseOperations(notification, notificationsMap.get(notification));
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof AttributeOperation);
		AttributeOperation attributeOperation = (AttributeOperation) operation;
		
		assertEquals(null, attributeOperation.getOldValue());
		assertEquals("newName", attributeOperation.getNewValue());
		assertEquals("name", attributeOperation.getFeatureName());
		assertEquals(useCase.getModelElementId(), attributeOperation.getModelElementId());
		
		
	}
}
