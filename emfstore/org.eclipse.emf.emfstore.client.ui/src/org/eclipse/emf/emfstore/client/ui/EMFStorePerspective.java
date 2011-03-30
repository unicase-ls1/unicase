/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * . This class is the perspective factory for the unicase Client. I think currently we don't need to implement this
 * class, because all its functionality is also available declarative in Plug-in.xml
 */
public class EMFStorePerspective implements IPerspectiveFactory {

	private IPageLayout factory;

	/**
	 * . Constructor
	 */
	public EMFStorePerspective() {
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

		IFolderLayout bottom = factory.createFolder("bottomRight", // NON-NLS-1
			IPageLayout.BOTTOM, 0.7f, factory.getEditorArea());

		bottom.addView("org.unicase.ui.repository.views.RepositoryView");
	}

}
