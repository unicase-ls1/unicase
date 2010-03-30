package org.unicase.rap.ui.views;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Composite;
import org.unicase.rap.ui.tabs.AbstractTab;

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
	
	@Override
	public String getId() {
		return ID;
	}

	// TODO: Maybe remove this method
	public void init() {
		
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.rap.ui.config.tab");
	
		AbstractTab cfgTab;
		
		for (IConfigurationElement e : configIn) {
			
			String tabName = e.getAttribute("name");
			
			try {
				cfgTab = (AbstractTab) e.createExecutableExtension("class");
				addTab(tabName, cfgTab);
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
			AbstractTab view = tabs.get(tabName);
			view.setTabName(tabName);
			view.setParentFolder(getTabFolder());
		}
	}
}
