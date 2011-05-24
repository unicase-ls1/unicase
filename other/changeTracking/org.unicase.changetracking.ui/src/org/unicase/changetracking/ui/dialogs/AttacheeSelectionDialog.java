/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.unicasecommon.common.filter.UserFilter;

/**
 * The attachee selection dialog allows to select a work item to attach a source
 * change to.
 * 
 * It allows to filter the shown work items by project and by user to whom they
 * are associated. It also allows to create a new action item on the fly.
 * 
 * @author jfinis
 * 
 */
public class AttacheeSelectionDialog extends AdvancedMESelectionDialog {

	/**
	 * The list of allowed EClasses to be created by the dialog. Only classes
	 * that are in this set AND are a subclass of WorkItem are shown as
	 * "create new ..." entries in the dialog.
	 */
	@SuppressWarnings("serial")
	private static Set<String> allowedElementsToCreate = new HashSet<String>() {
		{
			add("ActionItem");
			add("Issue");
			add("BugReport");
		}
	};

	/**
	 * Retrieves the set of class names which can be created by the dialog. For
	 * these classes, a <Create new CLASS NAME> entry will be in the list of
	 * model elements and if selected, a model element of this class can be
	 * created.
	 * 
	 * @return list of model elements which can be created by the dialog
	 */
	public Collection<String> getAllowedClassesForCreation() {
		return allowedElementsToCreate;
	}

	/**
	 * Default constructor.
	 */
	public AttacheeSelectionDialog() {
		super(TaskPackage.eINSTANCE.getWorkItem(),false);
	}

	/**
	 * Constructor with custom title and message.
	 * 
	 * @param title dialog title
	 * @param message dialog message
	 */
	public AttacheeSelectionDialog(String title, String message) {
		super(TaskPackage.eINSTANCE.getWorkItem(), title, message,false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ViewerFilter getUserFilter(User user) {
		return new UserFilter(user);
	}



}
