/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.ProjectSpace;

/**
 * This class offer helper methods for notifications.
 * 
 * @author helming
 */
public final class NotificationHelper {

	private NotificationHelper() {

	}

	/**
	 * Returns the latest date of a list of operations.
	 * 
	 * @param list a list of AbstractOperations
	 * @return the latest date.
	 */
	public static Date getLastDate(List<AbstractOperation> list) {
		Date date = new Date();
		for (AbstractOperation operation : list) {
			if (date == null) {
				date = operation.getClientDate();
			} else {
				Date newDate = operation.getClientDate();
				if (newDate.after(date)) {
					date = newDate;
				}

			}
		}
		return date;
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace) {

		ModelElement modelElement = projectSpace.getProject().getModelElement(meId);
		if (modelElement != null) {
			return getHTMLLinkForModelElement(modelElement, projectSpace);
		}

		throw new IllegalArgumentException("ModelElement does not exist.");
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElement modelElement, ProjectSpace projectSpace) {
		StringBuilder ret = new StringBuilder("unicase://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		ret.append(projectSpace.getProjectId());
		ret.append("/");
		ret.append(modelElement.getName());
		ret.append("%");
		ret.append(modelElement.getIdentifier());
		ret.append("/");
		return ret.toString();
	}
}
