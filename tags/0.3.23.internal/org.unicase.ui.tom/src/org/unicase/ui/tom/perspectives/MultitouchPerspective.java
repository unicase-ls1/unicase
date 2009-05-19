package org.unicase.ui.tom.perspectives;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


public class MultitouchPerspective implements IPerspectiveFactory {

	private IPageLayout factory;

	public MultitouchPerspective() {
		super();
	}

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
