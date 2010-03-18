package org.unicase.rap.ui.views;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Composite;

/**
 * View that contains all configuration options.
 * If UNICASE RAP plugins need to contribute configuration options, they
 * should add the UI facilities to configure these options via an additional tab
 * in the <code>ConfigurationView</code> (via <code>addConfigurationTab</code>).
 * 
 * @author emueller
 *
 */
public class ConfigurationView extends AbstractTabView {
	
	public static final String ID = "org.unicase.rap.ui.views.ConfigurationView";
	
	/**
	 *  Contains all tabs, that should be shown in the configuration view 
	 */
	protected HashMap<String, ConfigurationTabView> tabs = 
		new HashMap<String, ConfigurationTabView>();
	
	@Override
	public String getId() {
		return ID;
	}

	// TODO: Maybe remove this method
	public void init() {
		
		tabs = new HashMap<String, ConfigurationTabView>();
		
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.rap.ui.config.tab");
	
		ConfigurationTabView cfgTab;
		
		for (IConfigurationElement e : configIn) {
			
			String tabName = e.getAttribute("name");
			
			try {
				cfgTab = (ConfigurationTabView) e.createExecutableExtension("class");
				addConfigurationTab(tabName, cfgTab);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void createTabs(Composite parent) {
		
		init();
		
		for (String tabName : tabs.keySet()) {
			ConfigurationTabView view = tabs.get(tabName);
			view.setTabName(tabName);
			view.setParentFolder(getTabFolder());
		}
	}

	@Override
	public void setFocus() {

	}
	
	/**
	 * Add an additional tab to the configuration view.
	 * @param tabName The name of the tab that will be used when displaying the tab.
	 * @param configTab The tab itself
	 */
	public void addConfigurationTab(String tabName, 
			ConfigurationTabView configTab) {
		tabs.put(tabName, configTab);
	}
}
