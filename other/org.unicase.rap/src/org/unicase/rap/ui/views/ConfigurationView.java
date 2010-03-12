package org.unicase.rap.ui.views;

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
	
	@Override
	public String getId() {
		return ID;
	}

	// TODO: Maybe remove this method
	@Override
	public void init() {
	
	}
	
	@Override
	public void createTabs(Composite parent) {
		for (String tabName : tabs.keySet()) {
			ConfigurationTabView view = tabs.get(tabName);
			view.setTabName(tabName);
			view.setParentFolder(getTabFolder());
		}
	}

	// TODO: Maybe remove this method
	@Override
	public void setFocus() {

	}
}
