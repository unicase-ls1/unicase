package org.unicase.rapclient;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "catshelter.perspective";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
//		layout.setEditorAreaVisible(false);
//		layout.addStandaloneView(NavigationView.ID,  false, 
//				IPageLayout.LEFT, 0.25f, editorArea);
//		
		
		IFolderLayout folder = layout.createFolder("messages", IPageLayout.TOP, 1.0f, editorArea);
//		folder.addPlaceholder(NavigationView.ID + ":*");
		folder.addView(NavigationView.ID);
		folder.addView(BugReportView.ID);
		
//		layout.getViewLayout(NavigationView.ID).setCloseable(false);
	}
}
