/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status;

import org.unicase.workspace.ProjectSpace;
import org.unicase.model.UnicaseModelElement;

/**
 * Utility class.
 * 
 * @author Fatih Ulusoy
 */
public final class Utility {
	
	/**
	 * Cuts the names of the elements to the default value.
	 * 
	 * @see URLHelper#LIMIT
	 */
	public static final int DEFAULT = 0;

	/**
	 * Do not cut the names of the elements until the MAXLIMIT is reached.
	 */
	public static final int UNLTD = -1;

	/**
	 * The default limit of the name's length.
	 */
	public static final int LIMIT = 30;

	/**
	 * The maximal limit of the name's length.
	 */
	public static final int MAXLIMIT = 1000;
	
	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param style the string limit or @see {@link #DEFAULT} {@link #UNLTD}
	 * @return a HTML link as string
	 */
	public static String getLinkTextForModelElement(UnicaseModelElement modelElement, int style) {
		if (modelElement == null) {
			return "";
		}
		String name = modelElement.getName();
		if (name != null) {
			name = name.replaceAll("\"", "\\'");
		} else {
			name = "Unnamed Element";
		}

		int limit = style;
		if (style == UNLTD) {
			limit = MAXLIMIT;
		} else if (style == DEFAULT || style < -1) {
			limit = LIMIT;
		}
		if (name.length() > limit + 3) {
			name = name.substring(0, limit) + "...";
		}

		return name;
	}
	
	/**
	 * 
	 * @param ps Project space.
	 * @param me Unicase model element
	 * @return The URL of model element.
	 */
	public static String getLinkForModelElement(ProjectSpace ps, UnicaseModelElement me) {
		String meName = ((UnicaseModelElement) me).getName().replaceAll(" ", "");
		// Get model element id
		String meId = me.getModelElementId().getId();

		// remove spaces from the project name
		String projectName = ps.getProjectName().replaceAll(" ", "");
		String projectId = ps.getProjectId().getId();

		String serverUrl = ps.getUsersession().getServerInfo().getUrl();
		int serverPort = ps.getUsersession().getServerInfo().getPort();

		// Assemble the link
		String link = "unicase://" + serverUrl + ":" + serverPort + "/"
				+ projectName + "%" + projectId + "/" + meName + "%"
				+ meId;
		return link;
	}

}

