/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.requirementexport;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.unicase.workspace.WorkspaceManager;

/**
 * Dialog to select a target for a {@link RequirementExportOperation}.
 * 
 * @author mharut
 */
public class ExportRequirementDialog extends ElementTreeSelectionDialog {

	/**
	 * This constructor will initialize the dialog entirely, so that it only has to be {@link #open() opened}.
	 * 
	 * @param parent the parent {@link Shell} for the dialog
	 */
	public ExportRequirementDialog(Shell parent) {
		super(parent, new RequirementDialogLabelProvider(), new RequirementDialogTreeContentProvider());
		setInput(WorkspaceManager.getInstance().getCurrentWorkspace());
		setTitle("Requirement Export");
		setMessage("Please select the target of the export process.");
	}

}
