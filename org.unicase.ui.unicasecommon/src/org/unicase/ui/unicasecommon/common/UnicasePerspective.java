/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * . This class is the perspective factory for the unicase Client. I think
 * currently we don't need to implement this class, because all its
 * functionality is also available declarative in Plug-in.xml
 */
public class UnicasePerspective implements IPerspectiveFactory {

	public static final String UNICASE_PERSPECTIVE_ID = "org.unicase.ui.unicasecommon.common.UnicasePerspective";

	/**
	 * . Constructor
	 */
	public UnicasePerspective() {
		super();
	}

	/**
	 * . {@inheritDoc}
	 */
	public void createInitialLayout(IPageLayout layout) {

		IFolderLayout topLeft = layout.createFolder("topLeft", // NON-NLS-1
				IPageLayout.LEFT, 0.25f, layout.getEditorArea());
		topLeft.addView("org.eclipse.emf.ecp.ui.ModelExplorerView"); // NON-NLS-1
		IFolderLayout bottom = layout.createFolder("bottomRight", // NON-NLS-1
				IPageLayout.BOTTOM, 0.7f, layout.getEditorArea());
		bottom.addView("org.eclipse.emf.ecp.ui.ModelRepositoriesView");
		bottom.addView("org.unicase.ui.taskview");
		bottom.addView("org.unicase.ui.treeview.views.StatusView");
		bottom.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
	}

}
