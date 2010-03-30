package org.unicase.rap;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rwt.RWT;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.unicase.rap.ui.views.AbstractView;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 * 
 * @author Fatih Ulusoy
 * @author emueller
 */
public class ViewDispatcher implements IPerspectiveFactory {
	
	/**
	 * Caches views with their corresponding URL 
	 */
	private HashMap<String, AbstractView> views;
			
	public ViewDispatcher() {
		views = new HashMap<String, AbstractView>();
		initViews();
	}
	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		// determine which view has been requested
		HttpServletRequest request = RWT.getRequest();
		String viewName = request.getParameter("view");
		AbstractView view = views.get(viewName);

		if (view != null) {
			layout.addStandaloneView(view.getId(), false, IPageLayout.TOP,
					IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
		}	
	}
	
	/**
	 * Initializes all views that contribute to the extension point <code>org.unicase.rap.ui.view</code>
	 */
	private void initViews() {
		
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.rap.ui.view");
	
		for (IConfigurationElement e : configIn) {

			// The URL attribute specifies how this view is meeant to be called.
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

