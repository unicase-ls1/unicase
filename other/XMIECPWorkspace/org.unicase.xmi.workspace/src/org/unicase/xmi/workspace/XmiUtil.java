package org.unicase.xmi.workspace;

import org.eclipse.core.runtime.Platform;

/**
 * This class offers useful constants and methods needed from several classes.
 * @author maierma, kraftm
 */
public class XmiUtil {
	
	/**
	 * Constant to set the project description if it was left empty or not set.
	 */
	public static final String DEFAULT_PROJECT_DESCRIPTION = "Project on a file resource basis.";
	
	/**
	 * The default location for a project.
	 */
	public static final String DEFAULT_LOCATION = Platform.getLocation().toOSString();

	/**
	 * Set the common workspacepath for all XMI related classes as the default location for a project
	 */
	public static final String WORKSPACE_PATH = DEFAULT_LOCATION;
	
	/**
	 * Returns whether a string is null or equals en empty string.
	 * @param str The string to test
	 * @return True when string is not null and is not empty, else false
	 */
	public static boolean validate(String str) {
		return !(str == null || str.equals(""));
	}
	
	/**
	 * Contains the possible status of a project
	 */
	public enum PROJECT_STATUS {
		LOADED, FAILED, NOTLOADED
	}
}
