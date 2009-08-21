/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

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
public class EvaluatePage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Evaluate";
	private static final String PAGE_DESCRIPTION = "Evaluate your understanding";
	private Button veryWell;
	private Button well;
	private Button ok;
	private Button bad;
	private Button veryBad;
	private int result;

	protected EvaluatePage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(veryWell.getSelection()){
			result = 5;
			((EvaluationWizard) getWizard()).setCanFinish(true);
		}else if(well.getSelection()){
			result = 4;
			((EvaluationWizard) getWizard()).setCanFinish(true);
		}else if(ok.getSelection()){
			result = 3;
			((EvaluationWizard) getWizard()).setCanFinish(true);
		}else if(bad.getSelection()){
			result = 2;
			((EvaluationWizard) getWizard()).setCanFinish(true);
		}else if(veryBad.getSelection()){
			result = 0;
			((EvaluationWizard) getWizard()).setCanFinish(true);
		}
		QuestionnaireManager.getInstance().setEvaluationResult(result);
		getWizard().getContainer().updateButtons();
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
		
		veryWell = new Button(composite, SWT.RADIO);
		veryWell.setText("very Well");
		veryWell.setLayoutData(gd);
		veryWell.addListener(SWT.Selection, this);
		 
		well = new Button(composite, SWT.RADIO);
		well.setText("Well");
		well.setLayoutData(gd);
		well.addListener(SWT.Selection, this);
		
		ok = new Button(composite, SWT.RADIO);
		ok.setText("OK");
		ok.setLayoutData(gd);
		ok.addListener(SWT.Selection, this);
		
		bad = new Button(composite, SWT.RADIO);
		bad.setText("Bad");
		bad.setLayoutData(gd);
		bad.addListener(SWT.Selection, this);
		
		veryBad = new Button(composite, SWT.RADIO);
		veryBad.setText("very Bad");
		veryBad.setLayoutData(gd);
		veryBad.addListener(SWT.Selection, this);
		 
		setControl(composite);

	}

}
