package org.unicase.xmi.commands;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.unicase.xmi.workspace.XmiUtil;

/**
 * Class needed to generalize dialogs
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
	public String getProjectName() {
		if(XmiUtil.validate(projectName)) {
			return projectName;
		}
		else {
			if(XmiUtil.validate(projectLocation)) return projectLocation;
			else return XmiUtil.DEFAULT_LOCATION + File.separator + System.currentTimeMillis() + ".ucw";
		}
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		if(projectDescription == null) return XmiUtil.DEFAULT_PROJECT_DESCRIPTION;
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	/**
	 * Returns the DEFAULT_LOCATION if projectLocation is invalid.
	 * @return The location of the project.
	 */
	public String getProjectLocation() {
		if(XmiUtil.validate(projectLocation)) return projectLocation;
		return XmiUtil.DEFAULT_LOCATION;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	
	// END GETTERS AND SETTERS
}
