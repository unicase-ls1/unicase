/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.dialog;

import org.eclipse.emf.ecp.navigator.TreeContentProvider;
import org.eclipse.emf.ecp.navigator.TreeLabelProvider;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

/**
 * A model element selection dialog, that allows to select each element that is contained by a project. The parent class
 * provides all that is needed, but it is abstract.
 * 
 * @author Adrian Staudt
 */
public class TeamProviderModelElementSelectDialog extends ElementTreeSelectionDialog {

	/**
	 * Constructor.
	 * 
	 * @param shell The parent shell.
	 * @param project The context, that defines which objects can be selected.
	 */
	public TeamProviderModelElementSelectDialog(Shell shell, Project project) {
		super(shell, new TreeLabelProvider(), new TreeContentProvider());
		setTitle("Tree Selection");
		setMessage("Select the elements from the tree:");
		setInput(project);
	}

}
