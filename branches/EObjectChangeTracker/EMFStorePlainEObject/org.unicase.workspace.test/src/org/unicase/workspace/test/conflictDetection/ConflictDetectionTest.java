/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import java.util.Date;

import org.junit.Before;
import org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.IndexSensitiveConflictDetectionStrategy;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;

/**
 * Abstract super class for operation tests, contains setup.
 * 
 * @author chodnick
 */
public abstract class ConflictDetectionTest {

	private Project project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @param projectSpace the projectSpace to set
	 */
	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	private ProjectSpace projectSpace;

	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProjectSpaces() {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		projectSpace.setIdentifier("testProjectSpace1");
		projectSpace.setLastUpdated(new Date());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		projectSpace.setProjectDescription("ps description");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		projectSpace.setProjectName("ps name");

		project = MetamodelFactory.eINSTANCE.createProject();

		projectSpace.setProject(project);

		projectSpace.makeTransient();
		projectSpace.init();

		setProjectSpace(projectSpace);
		setProject(project);

	}

	/**
	 * Clones a project pace including the project.
	 * 
	 * @param ps the projectspace to clone
	 * @return the new projectspace
	 */
	public ProjectSpace cloneProjectSpace(ProjectSpace ps) {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		projectSpace.setIdentifier("testProjectSpace1");
		projectSpace.setLastUpdated(new Date());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		projectSpace.setProjectDescription("ps description");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		projectSpace.setProjectName("ps name");

		Project p = ModelUtil.clone(ps.getProject());
		projectSpace.setProject(p);

		projectSpace.makeTransient();
		projectSpace.init();

		return projectSpace;
	}

	/**
	 * Returns a conflict detection strategy to use.
	 * 
	 * @return a conflict detection strategy
	 */

	public ConflictDetectionStrategy getConflictDetectionStrategy() {
		return new IndexSensitiveConflictDetectionStrategy();
		// return new FineGrainedConflictDetectionStrategy();
	}
}
