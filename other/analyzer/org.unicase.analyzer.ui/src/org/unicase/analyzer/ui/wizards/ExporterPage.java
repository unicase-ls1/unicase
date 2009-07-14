/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import java.io.IOException;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.exporters.impl.CSVExporter;

/**
 * @author liya
 *
 */
public class ExporterPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Exporter";
	private static final String PAGE_DESCRIPTION = "Choose your exporter for the analysis result.";
	private Text exportPath;
	private Button exporterButton;

	/**
	 * @param pageName Name of the page
	 */
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
	    
	    AnalyzerConfiguration conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
	    
	    exporterButton = new Button(composite, SWT.RADIO);
	    exporterButton.setText("CVS Exporter");
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		exporterButton.setLayoutData(gd);
		exporterButton.setSelection(true);
		exporterButton.addListener(SWT.Selection, this);
		
		new Label (composite, SWT.NONE).setText("Exporter Path:");	
		exportPath = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		exportPath.setLayoutData(gd);
		if(conf.getExporterName() != null){
			exportPath.setText(conf.getExporterName());
		}
		exportPath.addListener(SWT.KeyUp, this);
		
		exporterButton = new Button(composite, SWT.PUSH);
	    exporterButton.setText("Save Configuration");
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		exporterButton.setLayoutData(gd);
		exporterButton.setSelection(false);
		exporterButton.addListener(SWT.Selection, this);
		
		((ProjectAnalyzerWizard)getWizard()).setCanFinish(isPageComplete());
		setControl(composite);
		setPageComplete(true);

	}
	private static boolean isTextNonEmpty(Text t)
	{
		String s = t.getText();
		if ((s!=null) && (s.trim().length() >0)) {
			return true;
		}
		return false;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == exporterButton){
			((ProjectAnalyzerWizard)getWizard()).setCanFinish(true);
		}
		setPageComplete(isPageComplete());

		getWizard().getContainer().updateButtons();
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		if(isTextNonEmpty(exportPath)){
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard)getWizard();
					try {
						CSVExporter exporter = new CSVExporter(exportPath.getText());
						wizard.setExporter(exporter);
						wizard.getAnalyzerConfig().setExporterName(exportPath.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			return true;
		}else{
		return false;
		}
	}
}
