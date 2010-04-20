/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.tabs;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionListener;

import org.unicase.rap.config.IValidator;
import org.unicase.rap.config.ConfigEntityStore;

import config.ConfigEntity;

/**
 * Represents a single configuration tab page.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public abstract class ConfigurationTab extends AbstractTab {
	
	/**
	 * Button for saving the configuration settings.
	 */
	private Button saveButton;
	
	/**
	 * Validators that will be called when the saved button is clicked.
	 */
	private List<IValidator> validators;
	
	private List<SelectionListener> saveButtonCallbackListeners;
	
	/**
	 * Default Constructor.
	 */
	public ConfigurationTab() {
		validators = new ArrayList<IValidator>();
		saveButtonCallbackListeners = new ArrayList<SelectionListener>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createTab(Composite parent) {
		
		createConfigurationTab(parent);
		
		saveButton = new Button(parent, SWT.NONE);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		saveButton.setLayoutData(gridData);
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {

				if (!validate()) {
					return; 
				}
				saveConfigEntity();
				
				for (SelectionListener listener : saveButtonCallbackListeners) {
					listener.widgetSelected(e);
				}
				MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Settings saved", "The settings were successfully saved.");
				
				System.out.println("a");
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("b");
			}
		});
	}

	/**
	 * 
	 * @return Config entity whose data is received from UI.
	 */
	public abstract ConfigEntity getConfigEntity();

	/**
	 * Loads config entity from configuration file.
	 */
	public abstract void loadSettings();
	
	/**
	 * Creates configuration tab.
	 * 
	 * @param parent The parent composite.
	 */
	public abstract void createConfigurationTab(Composite parent);

	/**
	 * Saves configuration entity.
	 */
	public void saveConfigEntity() {
		ConfigEntity cfgEntity = getConfigEntity();
		if (cfgEntity != null) {
			ConfigEntityStore.saveEntity(cfgEntity);
		}
	}
	
	/**
	 * Adds save button listener.
	 * 
	 * @param listener The listener that 
	 */
	public void addSaveButtonListener(SelectionListener listener) {
		saveButtonCallbackListeners.add(listener);
	}
	
	/**
	 * Removes save button listener.
	 * 
	 * @param listener The listener that
	 */
	public void removeSaveButtonListener(SelectionListener listener) {
		saveButtonCallbackListeners.remove(listener);
	}
	
	/**
	 * Add a validator that will be called when the save button has been clicked.
	 * 
	 * @param validator The validator to be called.
	 */
	public void addValidator(IValidator validator) {
		validators.add(validator);
	}
	
	/**
	 * Removes a validator that would be called when the save button has been clicked.
	 * 
	 * @param validator The validator to be removed.
	 */
	public void removeValidationListener(IValidator validator) {
		validators.remove(validator);
	}
	
	/**
	 * Calls each validator in turn and displays a dialog with the validaton result, if
	 * at least one validator returned a negative result, meaning that validation has failed.
	 *  
	 * @return True, if validation has succeeded, else false.
	 */
	private boolean validate() {
		
		StringBuffer buffer = new StringBuffer();
		
		for (IValidator validator : validators) {
			boolean result = validator.validate();
			
			if (!result) {
				buffer.append(validator.getValidationErrorMessage() + "\n");
			}
		}
		
		if (buffer.length() > 0) {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), 
								"Validation error occured", buffer.toString());
			return false;
		}
		
		return true;
	}

}

