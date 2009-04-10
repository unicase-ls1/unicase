/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.junit.Before;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.util.ProjectChangeObserver;

/**
 * Abstract super class for operation tests, contains setup.
 * 
 * @author koegel
 *
 */
public abstract class OperationTest {

	private List<Notification> notifications;
	private Project project;
	private Map<Notification, ModelElement> notificationsMap;

	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProject() {
		setProject(ModelFactory.eINSTANCE.createProject());
		setNotifications(new ArrayList<Notification>());
		setNotificationsMap(new HashMap<Notification, ModelElement>());
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
				getNotifications().add(notification);
				getNotificationsMap().put(notification, modelElement);
			}
	
		};
		getProject().addProjectChangeObserver(observer);
	}

	/**
	 * Clear the recorded notifications.
	 */
	protected void clearNotifications() {
		getNotifications().clear();
		getNotificationsMap().clear();
	}

	/**
	 * @param notifications the notifications to set
	 */
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	/**
	 * @return the notifications
	 */
	public List<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param notificationsMap the notificationsMap to set
	 */
	public void setNotificationsMap(Map<Notification, ModelElement> notificationsMap) {
		this.notificationsMap = notificationsMap;
	}

	/**
	 * @return the notificationsMap
	 */
	public Map<Notification, ModelElement> getNotificationsMap() {
		return notificationsMap;
	}

}
