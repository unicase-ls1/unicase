/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.ui.wizards;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 *
 */
public class LoadPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Load Configuration";
	private static final String PAGE_DESCRIPTION = "Load a configuration for your analyze.";
	private Text configurationPath;

	/**
	 * @param pageName Name of the page
	 */
	protected  LoadPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub

	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
	    gl.numColumns = ncol;
	    composite.setLayout(gl);

	    new Label (composite, SWT.NONE).setText("Exporter Path:");	
		configurationPath = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		configurationPath.setLayoutData(gd);
		
		
		configurationPath.addListener(SWT.KeyUp, this);
		
		Button selectFileLocation = new Button(composite, SWT.PUSH);
		selectFileLocation.setText("Browse");
		selectFileLocation.addSelectionListener(new FileLocationSelectionListener());
		
		setControl(composite);
		setPageComplete(true);
	}
	
	
	
	/**
	 * Listener for the file location selection.
	 */
	class FileLocationSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			DirectoryDialog fd = new DirectoryDialog(((Button) e.widget).getParent().getShell());
			fd.setText("select the folder where you want to save the analyzed results ");
			final String path = Configuration.getPluginDataBaseDirectory();
			fd.setFilterPath(path);
			String selected = fd.open();

			if (selected != null) {
				configurationPath.setText(selected);
			}
		}
	}



	/**
	 * @return the configurationPath
	 */
	public Text getConfigurationPath() {
		return configurationPath;
	}

	/**
	 * @param configurationPath the configurationPath to set
	 */
	public void setConfigurationPath(Text configurationPath) {
		this.configurationPath = configurationPath;
	}

}
