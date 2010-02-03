/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.perspectives;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/**
 * @author schroech
 *
 */
public class MultitouchPerspective implements IPerspectiveFactory {

	private IPageLayout factory;

	/**
	 * Default constructor.
	 */
	public MultitouchPerspective() {
		super();
	}

	/*** {@inheritDoc}
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
		addActionSets();
		addViewShortcuts();
	}

	private void addViews() {
		// Creates the overall folder layout. 
		// Note that each new Folder uses a percentage of the remaining EditorArea.
		
		IFolderLayout right =
			factory.createFolder(
				"right",
				IPageLayout.RIGHT,
				0.75f,
				factory.getEditorArea());
		
		right.addView(IPageLayout.ID_RES_NAV);
//		right.addPlaceholder("org.unicase.model.multiTouchClassDiagram.part.ModelDiagramEditorID");
	}

	private void addActionSets() {
		factory.addActionSet("org.eclipse.debug.ui.launchActionSet"); 
		factory.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		factory.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
	}

	private void addViewShortcuts() {
		factory.addShowViewShortcut(IPageLayout.ID_RES_NAV);
	}

}
