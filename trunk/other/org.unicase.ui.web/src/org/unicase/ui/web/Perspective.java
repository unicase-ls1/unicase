package org.unicase.ui.web;

import org.eclipse.core.resources.IFolder;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 * 
 * @author Fatih Ulusoy
 */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
//		IFolderLayout folder = layout.createFolder("view", IPageLayout.LEFT, 0.5f, editorArea);
//		
//		folder.addView(TabbedView.ID); //.addStandaloneView(TabbedView.ID, false, IPageLayout.RIGHT,  0.10f, editorArea);
//		folder.addView(ExampleView.ID);
		// layout.addStandaloneView(TabbedView.ID, false, IPageLayout.LEFT, 1.0f, editorArea);
		
		layout.addStandaloneView(View.ID, false, IPageLayout.LEFT, 0.50f, editorArea);
		layout.addStandaloneView(TabbedView.ID, false, IPageLayout.RIGHT, 1.0f, View.ID);
		
	}
	
}

