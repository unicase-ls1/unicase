package org.unicase.rap.ui.views;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.rap.LoginDialog;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.GeneralSettingsConfigEntity;
import org.unicase.rap.ui.tabs.AbstractTab;

import config.ConfigEntity;

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
	 * {@inheritDoc}
	 */
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createTabs(Composite parent) {
		
		if(!authenticate())
			return;
		
		init();
		
		for (String tabName : getTabs().keySet()) {
			AbstractTab view = getTabs().get(tabName);
			view.setTabName(tabName);
			view.setParentFolder(getTabFolder());
		}
	}
	
	/**
	 * Authenticates login to configuration view.
	 * 
	 * @return
	 */
    private boolean authenticate() {
    	
    	boolean isLoggedIn = false;
    	boolean isOKClicked = false;
		Display display = PlatformUI.createDisplay();
		LoginDialog loginDialog = new LoginDialog(display.getActiveShell(), "Admin Login");
		
		while (!isOKClicked) {
            isOKClicked = loginDialog.open() == IDialogConstants.OK_ID ? true : false;
            
			if (isOKClicked) {
				// validate user
				GeneralSettingsConfigEntity configEntity = new GeneralSettingsConfigEntity();
				ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity,
					new GeneralSettingsConfigEntity().eClass());
				if(entity == null) {
					configEntity.setAdminUsername(GeneralSettingsConfigEntity.DEFAULT_ADMIN_USERNAME);
					configEntity.setAdminPassword(GeneralSettingsConfigEntity.DEFAULT_ADMIN_PASSWORD);
					ConfigEntityStore.saveEntity(configEntity);
					
					MessageDialog.openError(display.getActiveShell(), "Error",
						"Configuration file was deleted or removed. \n " 
						+ "New one was created with default admin user-name and password." +
						"\n Please, use default values in next login try.");
					isOKClicked = false;
				} else {
					String userName = (String) entity.getProperties().get(
						GeneralSettingsConfigEntity.Keys.ADMIN_USER_NAME_KEY);
					String password = (String) entity.getProperties().get(
						GeneralSettingsConfigEntity.Keys.ADMIN_PASSWORD_KEY);

					if ((userName == null || userName.equals("")) 
						&& (password == null || password.equals(""))) {
						isLoggedIn = true;
						isOKClicked = true;
					} else if (loginDialog.getUsername().equals(userName) 
						&& loginDialog.getPassword().equals(password)) {
						isLoggedIn = true;
						isOKClicked = true;
					} else {
						MessageDialog.openError(display.getActiveShell(), "Error",
							"Authentication failed \n Invalid username and password");
						isOKClicked = false;
					}
				}
			} else {
				MessageDialog.openError(display.getActiveShell(), "Error",
					"Authentication failed \n Please enter valid username and password");
			}
		}
		return isLoggedIn;
	}
    
}
