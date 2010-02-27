package org.unicase.ui.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rwt.RWT;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.unicase.ui.web.views.AbstractView;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 * 
 * @author Fatih Ulusoy
 */
public class Perspective implements IPerspectiveFactory {
	
	// caches views with their corresponding URL 
	private HashMap<String, AbstractView> views;
	
	public Perspective() {
		views = new HashMap<String, AbstractView>();
		initViews();
	}
	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		// TODO: how to put something into editor area
		layout.setEditorAreaVisible(true);
		
		HttpServletRequest request = RWT.getRequest();
		String viewName = request.getParameter("view");
		
		AbstractView view = views.get(viewName);

		if (view != null) {
			view.setHttpRequest(request);
			
			layout.addView("org.unicase.ui.web.projectview.ProjectView", IPageLayout.TOP,
				IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
			
//			layout.addStandaloneView(view.getId(), false, 
//					IPageLayout.LEFT, 0.50f, editorArea);
		}
		

//		IFolderLayout folder = layout.createFolder("view", IPageLayout.LEFT, 0.5f, editorArea);
//		
//		folder.addView(TabbedView.ID); //.addStandaloneView(TabbedView.ID, false, IPageLayout.RIGHT,  0.10f, editorArea);
//		folder.addView(ExampleView.ID);
		// layout.addStandaloneView(TabbedView.ID, false, IPageLayout.LEFT, 1.0f, editorArea);
		
//		ProjectConfigurationView v = new ProjectConfigurationView();
//		TabbedView tv = new TabbedView();
//		layout.addStandaloneView(v.ID, false, IPageLayout.LEFT, 0.50f, editorArea);
//		layout.addStandaloneView(tv.ID, false, IPageLayout.LEFT, 0.50f, v.ID);
//		layout.addStandaloneView(tv.ID, false, IPageLayout.RIGHT, 1.0f, ProjectConfigurationView.ID);
	
	}
	
	private void initViews() {
		
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.web.view");
	
		for (IConfigurationElement e : configIn) {

			String url = e.getAttribute("url");
			
			AbstractView newView;
			try {
				newView = (AbstractView) e.createExecutableExtension("class");
				views.put(url, newView);
			} catch (CoreException e1) {				
				e1.printStackTrace();
			}
		}
	}
}

