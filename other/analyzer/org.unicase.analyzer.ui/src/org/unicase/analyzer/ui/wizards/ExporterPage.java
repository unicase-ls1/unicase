/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * @author liya
 *
 */
public class ExporterPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Exporter";
	private static final String PAGE_DESCRIPTION = "Choose your exporter for the analysis result.";
	private Text exportPath;
	private Button exporterButton;

	protected ExporterPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
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
	    
	    exporterButton = new Button(composite, SWT.RADIO);
	    exporterButton.setText("CVS Exporter");
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		exporterButton.setLayoutData(gd);
		exporterButton.setSelection(false);
		exporterButton.addListener(SWT.Selection, this);
		
		new Label (composite, SWT.NONE).setText("Step Length:");	
		exportPath = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		exportPath.setLayoutData(gd);
		exportPath.addListener(SWT.KeyUp, this);
		
		setControl(composite);
		setPageComplete(true);

	}

	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

}
