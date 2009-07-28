/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;


import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

/**
 * @author liya
 *
 */
public class TimeIteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String PAGE_DESCRIPTION = "Configure your TimeIterator.";
	private static final String[] UNITS = {"Year", "Month", "Day", "Hour", "Minute", "Second"};
	private static final int[] CALENDAR_FIELDS = {1, 2, 5, 10, 12, 13}; 
	
	private boolean canFlipToNextPage;
	
	private Text stepText;
	private Combo stepUnit;
	private Button defaultButton;
	private Group group;
	private Button forwardButton;
	private Button backwardButton;
	private Button returnCopyButton;
	private Label stepUnitLabel;
	private CDateTime startDate;
	private CDateTime endDate;


	/**
	 * @param pageName Name of the page
	 */
	protected TimeIteratorPage(String pageName) {
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
		
		AnalyzerConfiguration conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
		 
		 new Label (composite, SWT.NONE).setText("Step Length:");	
		stepText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		stepText.setLayoutData(gd);
		if(conf.getIterator() != null && conf.getIterator() instanceof TimeIterator){
			stepText.setText(Integer.toString(conf.getIterator().getStepLength()));
		}
		stepText.addListener(SWT.KeyUp, this);
		
		stepUnitLabel = new Label (composite, SWT.NONE);
		stepUnitLabel.setText("Step Unit:");
		stepUnit = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		stepUnit.setLayoutData(new GridData(GridData.END));
		stepUnit.setItems(UNITS);
		if(conf.getIterator() != null && conf.getIterator() instanceof TimeIterator){			
			stepUnit.select(indexOf(((TimeIterator) conf.getIterator()).getStepLengthUnit()));
		}
		stepUnit.addListener(SWT.Selection, this);
		
		 
		 defaultButton = new Button(composite, SWT.CHECK);
		 defaultButton.setText("Default");
		 gd = new GridData(GridData.FILL_HORIZONTAL);
		 gd.horizontalSpan = ncol;
		 defaultButton.setLayoutData(gd);
		 defaultButton.setSelection(false);
		 defaultButton.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					canFlipToNextPage = true;
					getWizard().getContainer().updateButtons();
				}

				public void widgetSelected(SelectionEvent e) {
					canFlipToNextPage = true;
					getWizard().getContainer().updateButtons();

				}

			});
		 defaultButton.addListener(SWT.Selection, this);
		 
		 group = new Group(composite, SWT.BORDER);
		group.setLayout(new GridLayout(4,false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		group.setLayoutData(gd);
		
		new Label (group, SWT.NONE).setText("Start:");		
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;	
		startDate = new CDateTime(group, CDT.BORDER);
		startDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		startDate.setPattern("dd.MM.yyyy HH:mm");
		
		new Label (group, SWT.NONE).setText("End:");		
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;	
		endDate = new CDateTime(group, CDT.BORDER);
		endDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		endDate.setPattern("dd.MM.yyyy HH:mm");
		
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
	
	
	private int indexOf(int stepLengthUnit) {
		for(int i=0; i<CALENDAR_FIELDS.length; i++){
			if(stepLengthUnit == CALENDAR_FIELDS[i]) {
				return i;
			}
		}
		return 0;
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
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
		.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard)getWizard();
				TimeIterator timeIterator = IteratorFactory.eINSTANCE.createTimeIterator();
				
				timeIterator.setProjectId(wizard.getSelectedProjectID());
				timeIterator.setStepLength(Integer.valueOf(stepText.getText()));
				timeIterator.setStepLengthUnit(CALENDAR_FIELDS[stepUnit.getSelectionIndex()]);
				timeIterator.setDefault(defaultButton.getSelection());
				
				if(!defaultButton.getSelection()){
					timeIterator.setStartDate(startDate.getSelection());
					timeIterator.setEndDate(endDate.getSelection());					
					
					VersionSpecQuery query = IteratorFactory.eINSTANCE.createVersionSpecQuery();
					DateVersionSpec startVer = VersioningFactory.eINSTANCE.createDateVersionSpec();
					startVer.setDate(startDate.getSelection());
					DateVersionSpec endVer = VersioningFactory.eINSTANCE.createDateVersionSpec();
					endVer.setDate(endDate.getSelection());
					query.setStartVersion(startVer);
					query.setEndVersion(endVer);
					timeIterator.setVersionSpecQuery(query);
					timeIterator.setForward(forwardButton.getSelection());
					timeIterator.setReturnProjectDataCopy(returnCopyButton.getSelection());
				}
				wizard.setVersionIterator(timeIterator);
				wizard.getAnalyzerConfig().setIterator(timeIterator);
				
			}
		});
		
		ExporterPage page = ((ProjectAnalyzerWizard)getWizard()).getExporterPage();
		return page;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == defaultButton){
			canFlipToNextPage =true;
			group.setEnabled(!defaultButton.getSelection());
			for(Control control : group.getChildren()){
				control.setEnabled(!defaultButton.getSelection());
							
			}
		}
		
		getWizard().getContainer().updateButtons();
	}

}
