package org.unicase.rap.ui.start;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addShowViewShortcut("org.unicase.ui.navigator.viewer");
		layout.addShowViewShortcut("org.unicase.ui.repository.views.RepositoryView");
		layout.addShowViewShortcut("org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView");
		
		IFolderLayout topLeft = layout.createFolder("topLeft",
				IPageLayout.LEFT, 0.25f, layout.getEditorArea());

		topLeft.addView("org.unicase.ui.navigator.viewer");

		IFolderLayout bottom = layout.createFolder("bottomRight",
				IPageLayout.BOTTOM, 0.7f, layout.getEditorArea());

		bottom.addView("org.unicase.ui.repository.views.RepositoryView");
		//bottom.addView("org.unicase.ui.taskview");
		bottom.addView("org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView");
	}
	
	
}
