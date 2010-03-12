package org.unicase.rap;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rwt.RWT;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.unicase.rap.ui.tabs.GeneralSettingsTab;
import org.unicase.rap.ui.views.AbstractView;
import org.unicase.rap.ui.views.ConfigurationTabView;
import org.unicase.rap.ui.views.ConfigurationView;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 * 
 * @author Fatih Ulusoy
 */
public class ViewDispatcher implements IPerspectiveFactory {
	
	// caches views with their corresponding URL 
	private HashMap<String, AbstractView> views;
	
	
	private ConfigurationView configView;
	
	public ViewDispatcher() {
		views = new HashMap<String, AbstractView>();
		initViews();
		initConfigurationsTabs();
	}
	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		// TODO: how to put something into editor area
		layout.setEditorAreaVisible(false);
		
		HttpServletRequest request = RWT.getRequest();
		String viewName = request.getParameter("view");
		
		AbstractView view = views.get(viewName);

		if (view != null) {
			
			view.setHttpRequest(request);
			// TODO: use show view
			
			//layout.addView("org.unicase.ui.web.projectview.ProjectView", IPageLayout.TOP,
				//IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
			
			configView.addConfigurationTab("General settings", new GeneralSettingsTab());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			layout.addView(view.getId(), IPageLayout.TOP,
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
		
		// TODO: add configuration view here
		configView = new ConfigurationView();
		views.put("config", configView);
		
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.rap.ui.view");
	
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
	
	private void initConfigurationsTabs() {
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.rap.ui.config.tab");
	
		ConfigurationTabView cfgTab;
		
		
		for (IConfigurationElement e : configIn) {
			
			String tabName = e.getAttribute("name");
			
			try {
				cfgTab = (ConfigurationTabView) e.createExecutableExtension("class");
				configView.addConfigurationTab(tabName, cfgTab);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

