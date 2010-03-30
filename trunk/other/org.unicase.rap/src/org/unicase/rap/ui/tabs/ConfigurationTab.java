package org.unicase.rap.ui.tabs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IValidator;

import config.ConfigEntity;

/**
 * Represents a single configuration tab page.
 * 
 * @author emueller
 *
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
	
	public ConfigurationTab() {
		validators = new ArrayList<IValidator>();
	}

	
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

				MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Settings saved", "The settings were successfully saved.");

				// TODO: retrieve bug container via..
				//					ProjectUrlFragment projUrlFrag = UrlFactory.eINSTANCE.createProjectUrlFragment();
				//					projUrlFrag.setName(projectName);
				//					WorkspaceManager.getInstance().getCurrentWorkspace().resolve(projUrlFrag);
				//					ProjectSpace p = null;
				//					p.getProject().contains(modelElementId)
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	public abstract ConfigEntity getConfigEntity();

	public abstract void loadSettings();
	
	public abstract void createConfigurationTab(Composite parent);

	public void saveConfigEntity() {
		ConfigEntity cfgEntity = getConfigEntity();
		if (cfgEntity != null) {
			ConfigEntityStore.getInstance().saveEntity(cfgEntity);
		}
	}
	
	/**
	 * Add a validator that will be called when the save button has been clicked
	 * 
	 * @param validator The validator to be called.
	 */
	public void addValidator(IValidator validator) {
		validators.add(validator);
	}
	
	/**
	 * Removes a validator, that would be called when the save button has been clicked.
	 * 
	 * @param validator The validator to be removed.
	 */
	public void removeValidationListener(IValidator validator) {
		validators.remove(validator);
	}
	
	/**
	 * Calls each validator in turn and displays a dialog with the validaton result, if
	 * at least one validator returned a negative result, meaning that validation has failed. 
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
			MessageDialog.openWarning(
					Display.getDefault().getActiveShell(), 
					"Validation error occured", 
					buffer.toString());
			
			return false;
		}
		
		return true;
	}

}
