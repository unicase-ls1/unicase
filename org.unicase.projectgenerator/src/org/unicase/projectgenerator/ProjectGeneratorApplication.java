/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.projectgenerator;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Convenient class to test project generator.
 * 
 * @author Hodaie
 */
public class ProjectGeneratorApplication implements IApplication {

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		boolean intoWorkspace = false;

		TestProjectParmeters param = new TestProjectParmeters(7, 123456789, 4, 3, 5, 20);
		TestProjectGenerator generator = new TestProjectGenerator(param);

		if (intoWorkspace) {
			Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			generator.generateProjectIntoWorkspace(workspace);
			return null;
		}
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace projectSpace = WorkspaceHelper.createEmptyProjectSpace("random project");
		projectSpace.setProjectDescription("random project with parameter: " + param.toString());

		Project project = generator.generateProject();
		projectSpace.setProject(project);
		String path;
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			path = "C:\\Dokumente und Einstellungen\\Hodaie\\Desktop\\testProj.ucp";
		} else {
			path = "/Network/Servers/macbruegge7.informatik.tu-muenchen.de/Volumes/raid/Users/hodaie/Desktop/testProj.ucp";
		}
		workspace.exportProject(projectSpace, path);
		System.out.println(project.getAllModelElements().size());
		System.out.println();

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public void stop() {

	}

	// END SUPRESS CATCH EXCEPTION

}
