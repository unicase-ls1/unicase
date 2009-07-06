/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.fromrecording;

import org.junit.Before;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCannonizer;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;
import org.unicase.workspace.changeTracking.notification.recording.OperationGenerator;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.impl.ProjectSpaceImpl;

import java.util.Date;
import java.util.List;

/**
 * Abstract super class for operation tests, contains setup.
 * 
 * @author koegel
 *
 */
public abstract class OperationTest {

	private Project project;
	private ProjectSpace projectSpace;

	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProjectSpace() {
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		projectSpace.setIdentifier("testProjectSpace");
		projectSpace.setLastUpdated(new Date());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		projectSpace.setProjectDescription("ps description");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		projectSpace.setProjectName("ps name");
		
		setProject(ModelFactory.eINSTANCE.createProject());
		
		projectSpace.setProject(getProject());
		
		projectSpace.makeTransient();
		projectSpace.init();
		
		setProjectSpace(projectSpace);
		
	}

	/**
	 * @param project the project to set
	 */
	private void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param projectSpace the projectSpace to set
	 */
	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpaceImpl getProjectSpace() {
		return (ProjectSpaceImpl)projectSpace;
	}

	/**
	 * Clear all operations from project space.
	 */
	protected void clearOperations() {
		getProjectSpace().getOperations().clear();
		
	}
	/**
	 * get notifications from project space and convert to operations.
	 * @throws UnsupportedNotificationException in case the recorded notifications are problematic
	 * 
	 * @return operations as recorded by project space
	 */
	protected List<AbstractOperation> generateOperations() throws UnsupportedNotificationException {
		
		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<AbstractOperation> ops = OperationGenerator.generateFromRecording(recording);
		OperationsCannonizer.cannonize(ops);
		return ops;
		
	}

}
