/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @author liya
 *
 */
public class IteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String PAGE_DESCRIPTION = " your Iterator used for analyzing the project.";
	private boolean canFlipToNextPage;
	private Button versionIteratorButton;
	private Button timeIteratorButton;
	
	/**
	 * @param pageName Name of the page
	 */
	protected IteratorPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == versionIteratorButton || event.widget == timeIteratorButton){
			canFlipToNextPage = true;
		}
		
		getWizard().getContainer().updateButtons();

	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		if(versionIteratorButton.getSelection()){
			VersionIteratorPage page = ((ProjectAnalyzerWizard)getWizard()).getVersionIteratorPage();
			return page;
		}else if(timeIteratorButton.getSelection()){
			TimeIteratorPage page = ((ProjectAnalyzerWizard)getWizard()).getTimeIteratorPage();
			return page;
		}else{
			return super.getNextPage();
		}
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return canFlipToNextPage;
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
		
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		
		versionIteratorButton = new Button(composite, SWT.RADIO);
		 versionIteratorButton.setText("Version Iterator");
		 versionIteratorButton.setLayoutData(gd);
		 versionIteratorButton.setSelection(false);
		 versionIteratorButton.addListener(SWT.Selection, this);
		 
		 timeIteratorButton = new Button(composite, SWT.RADIO);
		 timeIteratorButton.setText("Time Iterator");		 
		 timeIteratorButton.setLayoutData(gd);
		 timeIteratorButton.setSelection(false);
		 timeIteratorButton.addListener(SWT.Selection, this);
		 
		 setControl(composite);
		 setPageComplete(true);

	}

}
