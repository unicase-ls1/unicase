package org.unicase.rap.ui.views;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.omg.CORBA.OMGVMCID;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;

/**
 * This class represents a tab in the configuration view.
 */
public abstract class ConfigurationTabView {

	// TODO: temporary save path
	private static final String SAVE_PATH = System.getProperty("user.home");
	
	private String tabName;
	private CTabFolder parentFolder;
	
	private CTabItem tabItem;
	private Composite composite;
	
	private Button saveButton;
	
	public ConfigurationTabView() {
		
	}

	private void init() {
		composite = new Composite(parentFolder, SWT.BORDER);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		GridData d = new GridData();
	    d.grabExcessHorizontalSpace = true;
	    d.grabExcessVerticalSpace = true;
		composite.setLayoutData(d);
				
		tabItem = new CTabItem(parentFolder, SWT.NONE);
		tabItem.setText(tabName);
	    tabItem.setControl(composite);
	    		
	    Composite c = new Composite(composite, SWT.BORDER);
	    createTab(c);
	    
	    saveButton = new Button(composite, SWT.NONE);
	    d = new GridData();
	    d.grabExcessHorizontalSpace = true;
	    d.grabExcessVerticalSpace = true;
	    saveButton.setLayoutData(d);
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				saveConfigEntity();
				MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Settings saved", "The settings were successfully saved.");

				// TODO: retrieve bug container via..
//				ProjectUrlFragment projUrlFrag = UrlFactory.eINSTANCE.createProjectUrlFragment();
//				projUrlFrag.setName(projectName);
//				WorkspaceManager.getInstance().getCurrentWorkspace().resolve(projUrlFrag);
//				ProjectSpace p = null;
//				p.getProject().contains(modelElementId)
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

	}

	/**
	 * 
	 * @param parent
	 */
	protected abstract void createTab(Composite parent);

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setParentFolder(CTabFolder parentFolder) {
		this.parentFolder = parentFolder;
		// TODO:!!!
		init();
	}

	public CTabFolder getParentFolder() {
		return parentFolder;
	}

	public void saveConfigEntity() {
		AbstractConfigEntity cfgEntity = getConfigEntity();
		if (cfgEntity != null) {
			String filename = new File(SAVE_PATH).getAbsolutePath() 
				+ File.separatorChar + "org.unicase.rap.config." +
				cfgEntity.getId();
			ConfigEntityStore.getInstance().saveEntity(cfgEntity, filename);
		}
	}
	
	/**
	 * Returs the config entity that needs to be saved
	 * @return The config entity to be saved
	 */
	public abstract AbstractConfigEntity getConfigEntity();
}
