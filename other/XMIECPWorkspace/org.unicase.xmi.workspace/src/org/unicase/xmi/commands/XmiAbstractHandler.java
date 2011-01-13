package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;

/**
 * Class needed to generalize dialogs
 * @author Markus, Matti
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
	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getProjectLocation() {
		return projectLocation;
	}


	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	
	// END GETTERS AND SETTERS
}
