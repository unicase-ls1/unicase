/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.dialog;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.unicase.ui.navigator.TreeContentProvider;
import org.unicase.ui.navigator.TreeLabelProvider;

/**
 * A model element selection dialog, that allows to select each element that is contained by a project. The parent class
 * provides all that is needed, but it is abstract.
 * 
 * @author Adrian Staudt
 */
public class JDTModelElementSelectDialog extends ElementTreeSelectionDialog {

	/**
	 * Constructor.
	 * 
	 * @param shell The parent shell.
	 * @param project The context, that defines which objects can be selected.
	 */
	public JDTModelElementSelectDialog(Shell shell, Project project) {
		super(shell, new TreeLabelProvider(), new TreeContentProvider());
		setTitle("Tree Selection");
		setMessage("Select the elements from the tree:");
		setInput(project);
	}

}
