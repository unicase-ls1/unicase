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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * @author liya
 *
 */
public class VersionIteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String PAGE_DESCRIPTION = "Configure your VersionIterator.";
	private boolean canFlipToNextPage;
	
	private Text stepText;
	private Button defaultButton;
	private Group group;
	private Text startText;
	private Text endText;
	private Button forwardButton;
	private Button backwardButton;
	private Button returnCopyButton;
	/**
	 * @param pageName Name of the page
	 */
	protected VersionIteratorPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;
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
		 
		 new Label (composite, SWT.NONE).setText("Step Length:");	
		stepText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		stepText.setLayoutData(gd);
		stepText.addListener(SWT.KeyUp, this);
		
		 
		 defaultButton = new Button(composite, SWT.CHECK);
		 defaultButton.setText("Default");
		 gd = new GridData(GridData.FILL_HORIZONTAL);
		 gd.horizontalSpan = ncol;
		 defaultButton.setLayoutData(gd);
		 defaultButton.setSelection(false);
		 defaultButton.addListener(SWT.Selection, this);
		 
		 group = new Group(composite, SWT.BORDER);
		group.setLayout(new GridLayout(2,false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		group.setLayoutData(gd);
		
		new Label (group, SWT.NONE).setText("Start:");	
		startText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		startText.setLayoutData(gd);
		startText.addListener(SWT.KeyUp, this);
		
		new Label (group, SWT.NONE).setText("End:");	
		endText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		endText.setLayoutData(gd);
		endText.addListener(SWT.KeyUp, this);
		
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;	
		forwardButton = new Button(group, SWT.RADIO);
		forwardButton.setText("Forward");
		forwardButton.setLayoutData(gd);
		forwardButton.setSelection(false); 
		forwardButton.addListener(SWT.Selection, this);
		
		backwardButton = new Button(group, SWT.RADIO);
		backwardButton.setText("Backward");		 
		backwardButton.setLayoutData(new GridData(GridData.END));
		backwardButton.setSelection(false);
		backwardButton.addListener(SWT.Selection, this);
		
		returnCopyButton = new Button(group, SWT.CHECK);
		returnCopyButton.setText("Return the copy of ProjectAnalysisData");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		returnCopyButton.setLayoutData(gd);
		returnCopyButton.setSelection(false);
		returnCopyButton.addListener(SWT.Selection, this);
		
		setControl(composite);
		setPageComplete(true);
		
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
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		ExporterPage page = ((ProjectAnalyzerWizard)getWizard()).getExporterPage();
		return page;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == defaultButton){
			canFlipToNextPage = true;
			group.setEnabled(!defaultButton.getSelection());
			for(Control control : group.getChildren()){
				control.setEnabled(!defaultButton.getSelection());
			}
		}
		getWizard().getContainer().updateButtons();
	}

}
