/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * . This class is the perspective factory for the unicase Client. I think currently we don't need to implement this
 * class, because all its functionality is also available declarative in Plug-in.xml
 */
public class UnicasePerspective implements IPerspectiveFactory {

	private IPageLayout factory;

	/**
	 * . Constructor
	 */
	public UnicasePerspective() {
		super();
	}

	/**
	 * . {@inheritDoc}
	 */
	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
	}

	private void addViews() {
		// Creates the overall folder layout.
		// Note that each new Folder uses a percentage of the remaining
		// EditorArea.
		IFolderLayout topLeft = factory.createFolder("topLeft", // NON-NLS-1
			IPageLayout.LEFT, 0.25f, factory.getEditorArea());

		topLeft.addView("org.unicase.ui.navigator.viewer"); // NON-NLS-1

		IFolderLayout bottomLeft = factory.createFolder("bottomLeft", // NON-NLS-1
			IPageLayout.BOTTOM, 0.25f, "topLeft");
		bottomLeft.addView("org.unicase.ui.repository.views.RepositoryView");

		IFolderLayout bottomRight = factory.createFolder("bottomRight", // NON-NLS-1
			IPageLayout.BOTTOM, 0.25f, factory.getEditorArea());

		bottomRight.addView("org.unicase.ui.taskview");
		bottomRight.addView("org.unicase.ui.treeview.views.StatusView");

		bottomRight.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);

		IFolderLayout dashboard = factory.createFolder("dashboard", // NON-NLS-1
			IPageLayout.BOTTOM, 1.0f, factory.getEditorArea());
		dashboard.addView("org.unicase.ui.dashboard");

	}

}
