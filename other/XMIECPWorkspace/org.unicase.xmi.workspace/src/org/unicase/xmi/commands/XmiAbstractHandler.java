/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.workspace.XmiUtil;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

/**
 * Class needed to generalize dialogs.
 * @author kraftm, maierma
 *
 */
public abstract class XmiAbstractHandler extends AbstractHandler {
	
	/**
	 * Name of the new project.
	 */
	private String projectName;

	/**
	 * Description of the new project.
	 */
	private String projectDescription;
	
	/**
	 * File location of the new project.
	 */
	private String projectLocation;
	
	// BEGIN GETTERS AND SETTERS
	/**
	 * Returns a valid project name.
	 * @return project name
	 */
	public String getProjectName() {
		if(XmiUtil.validate(projectName)) {
			return projectName;
		}
		else {
			if(XmiUtil.validate(projectLocation)) {
				return projectLocation;
			}
			else {
				// prevents empty filenames
				return XmiUtil.DEFAULT_LOCATION + File.separator + System.currentTimeMillis() + ".ucw";
			}
		}
	}

	/**
	 * Set the name of the project.
	 * @param projectName Name of the project.
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Validates the project description and returns its description.
	 * @return Description of the project
	 */
	public String getProjectDescription() {
		if(projectDescription == null) {
			return XmiUtil.DEFAULT_PROJECT_DESCRIPTION;
		}
		return projectDescription;
	}

	/**
	 * Sets the description of the project.
	 * @param projectDescription Project's description
	 */
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * Returns the DEFAULT_LOCATION if projectLocation is invalid.
	 * @return The location of the project.
	 */
	public String getProjectLocation() {
		if(XmiUtil.validate(projectLocation)) {
			return projectLocation;
		}
		return XmiUtil.DEFAULT_LOCATION;
	}

	/**
	 * Set the location of the underlying resource.
	 * @param projectLocation Full system independent path to the resource.
	 */
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	
	// END GETTERS AND SETTERS
	
	
	/**
	 * Building the command that will be executed when importing or adding a new project.
	 * @param workspace The workspace where the projects will be added to.
	 * @return Command to execute the action.
	 */
	protected XmiCommand buildCommand(ECPWorkspace workspace) {
		final ECPWorkspace ws = workspace;
		
		// run the command on the editing domain of the workspace
		return new XmiCommand((TransactionalEditingDomain) ws.getEditingDomain()) {

			@Override
			protected void doRun() {
				if(ws instanceof XMIECPWorkspace && ws != null) {
					// create a blank project
					XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
					
					// set the information of the project
					project.setProjectName(getProjectName());
					project.setXmiFilePath(getProjectLocation());
					project.setProjectDescription(getProjectDescription());
					
					// load the project's content
					project.loadContents();
					
					// add a new XMIFileProject to the workspace
					((XMIECPWorkspace) ws).addProject(project);
				}
				else {
					new XMIWorkspaceException("Unable to add the project to the workspace. The workspace is unknown.");
				}
			} // END doRun()
			
		}; // END return
	} // END buildCommand(...)
	
} // END XmiAbstractHandler
