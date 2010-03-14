package org.unicase.rap.ui.views;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IValidator;

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
	
	private List<IValidator> validators;
	
	public ConfigurationTabView() {
		validators = new ArrayList<IValidator>();
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
				
				if (!validate()) {
					return; 
				}
				
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
	
	private boolean validate() {
		
		StringBuffer buffer = new StringBuffer();
		
		for (IValidator validator : validators) {
			boolean result = validator.validate();
			
			if (!result) {
				buffer.append(validator.getValidationErrorMessage() + "\n");
			}
		}
		
		if (buffer.length() > 0) {
			MessageDialog.openWarning(
					Display.getDefault().getActiveShell(), 
					"Validation error occured", 
					buffer.toString());
			
			return false;
		}
		
		return true;
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
	
	public void addValidator(IValidator validator) {
		validators.add(validator);
	}
	
	public void removeValidationListener(IValidator validator) {
		validators.remove(validator);
	}
	
	/**
	 * Returs the config entity that needs to be saved
	 * @return The config entity to be saved
	 */
	public abstract AbstractConfigEntity getConfigEntity();
}
