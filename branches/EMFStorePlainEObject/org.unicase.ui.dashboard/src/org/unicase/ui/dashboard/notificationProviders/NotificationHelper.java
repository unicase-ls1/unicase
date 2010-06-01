/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
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
	 * @param list
	 *            a list of AbstractOperations
	 * @return the latest date.
	 */
	public static Date getLastDate(List<AbstractOperation> list) {
		Date date = null;
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
		if (date == null) {
			date = new Date();
		}
		return date;
	}

	/**
	 * This method create a HTML link pointing to a model element for the
	 * message of Notifications.
	 * 
	 * @param meId
	 *            The id of the model element
	 * @param projectSpace
	 *            the project space
	 * @param active
	 *            if there should be an actual link, or just the name
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId,
			ProjectSpace projectSpace, boolean active) {

		EObject modelElement = projectSpace.getProject().getModelElement(
				meId);
		if (modelElement != null && modelElement instanceof UnicaseModelElement) {
			UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
			if (active) {
				return getHTMLLinkForModelElement(unicaseModelElement,
						projectSpace);
			}
			return unicaseModelElement.getName();
		}
		return "(deleted element)";
	}

	/**
	 * This method create a HTML link pointing to a model element for the
	 * message of Notifications.
	 * 
	 * @param meId
	 *            The id of the model element
	 * @param projectSpace
	 *            the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId,
			ProjectSpace projectSpace) {
		return getHTMLLinkForModelElement(meId, projectSpace, true);
	}

	/**
	 * This method create a HTML link pointing to a model element for the
	 * message of Notifications.
	 * 
	 * @param modelElement
	 *            The model element
	 * @param projectSpace
	 *            the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(
			UnicaseModelElement modelElement, ProjectSpace projectSpace) {
		String label = "null";
		if (modelElement != null && modelElement.getName() != null) {
			label = modelElement.getName().replaceAll("\"", "\\'");
		}
		return getHTMLLinkForModelElement(modelElement, projectSpace, label);
	}

	/**
	 * This method create a HTML link pointing to a model element for the
	 * message of Notifications.
	 * 
	 * @param modelElement
	 *            The model element
	 * @param projectSpace
	 *            the project space
	 * @param label
	 *            the link's label
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(
			UnicaseModelElement modelElement, ProjectSpace projectSpace,
			String label) {
		if (modelElement == null) {
			return "";
		}
		if (label.length() > 53) {
			label = label.substring(0, 50) + " ...";
		}
		StringBuilder ret = new StringBuilder("<a href=\"unicase://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		ret.append(projectSpace.getProjectId().getId());
		ret.append("/");
		String name = "null";
		if (modelElement.getName() != null) {
			name = modelElement.getName().replaceAll("\"", "\\'");
		}
		ret.append(name);
		ret.append("%");
		// TODO : EMFPlainEObjectTransition
		ret.append(ModelUtil.getProject(modelElement).getModelElementId(modelElement));
//		ret.append(modelElement.getIdentifier());
		ret.append("\">");
		ret.append(label);
		ret.append("</a>");
		return ret.toString();
	}

}
