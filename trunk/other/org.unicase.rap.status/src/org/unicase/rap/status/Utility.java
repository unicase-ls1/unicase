package org.unicase.rap.status;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;

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
	 * @param projectSpace the project space
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
