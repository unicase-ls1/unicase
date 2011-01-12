/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.changetracking.ui.Activator;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.filter.UserFilter;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * The attachee selection dialog allows to select a work item to attach a source change to.
 * 
 * It allows to filter the shown work items by project and by user to whom they are associated.
 * It also allows to create a new action item on the fly.
 * 
 * @author jfinis
 *
 */
public class AttacheeSelectionDialog extends AdvancedMESelectionDialog{
	
		
	/**
	 * The list of allowed EClasses to be created by the dialog.
	 * Only classes that are in this set AND are a subclass of WorkItem
	 * are shown as "create new ..." entries in the dialog.
	 */
	@SuppressWarnings("serial")
	private static Set<String> allowedElementsToCreate = new HashSet<String>(){{
		add("ActionItem");
		add("Issue");
		add("BugReport"); 
	}};
	
	public Collection<String> getAllowedClassesForCreation() {
		return allowedElementsToCreate;
	}
	
		/**
	 * Default constructor.
	 */
	public AttacheeSelectionDialog() {
		super(TaskPackage.eINSTANCE.getWorkItem());
	}

		@Override
		public ViewerFilter getUserFilter(User user) {
			return new UserFilter(user);
		}

	
}
