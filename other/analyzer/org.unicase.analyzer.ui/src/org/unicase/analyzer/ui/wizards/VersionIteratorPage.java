/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.ui.commands.AnalysisCommand;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;

/**
 * @author liya
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
	private Button returnCopyButton;

	private final TransactionalEditingDomain editingDomain;
	private AnalyzerConfiguration conf;
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.analysis.EditingDomain";

	/**
	 * @param pageName Name of the page
	 */
	protected VersionIteratorPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;

		editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 * @param parent Parent
	 */
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("Step Length:");
		stepText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		stepText.setLayoutData(gd);
		stepText.addListener(SWT.KeyUp, this);
		stepText.setText("1");

		defaultButton = new Button(composite, SWT.CHECK);
		defaultButton.setText("Analyze all versions");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		defaultButton.setLayoutData(gd);
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
		group.setLayout(new GridLayout(2, false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;

		group.setLayoutData(gd);

		new Label(group, SWT.NONE).setText("Start:");
		startText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		startText.setLayoutData(gd);
		startText.addListener(SWT.KeyUp, this);

		new Label(group, SWT.NONE).setText("End:");
		endText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		endText.setLayoutData(gd);
		endText.addListener(SWT.KeyUp, this);

		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		forwardButton = new Button(group, SWT.CHECK);
		forwardButton.setText("Run in the Forward Direction");
		forwardButton.setLayoutData(gd);
		forwardButton.setSelection(true);
		forwardButton.addListener(SWT.Selection, this);

		returnCopyButton = new Button(group, SWT.CHECK);
		returnCopyButton.setText("Return a deep copy of ProjectAnalysisData");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		returnCopyButton.setLayoutData(gd);
		returnCopyButton.setSelection(false);
		returnCopyButton.addListener(SWT.Selection, this);

		setCanFlipToNextPage(isPageComplete());
		setControl(composite);
		// setPageComplete(true);

	}

	/**
	 * Initializes the page, i.e. this method is not called at the time this class gets instantiated but later, when the
	 * page is going to get displayed. Mainly create the databinding here.
	 */
	public void initDefaulGroup() {

		conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
		// stepLength
		IObservableValue modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(),
			IteratorPackage.eINSTANCE.getVersionIterator_StepLength());
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(stepText, SWT.FocusOut), modelObservable, null, null);

		// default
		modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(), IteratorPackage.eINSTANCE
			.getVersionIterator_Default());
		dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(defaultButton), modelObservable, null, null);

	}

	/**
	 * Initialize the group of this wizard page.
	 */
	public void initGroup() {

		conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
		// start PrimaryVersionSpec
		IObservableValue modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator()
			.getVersionSpecQuery().getStartVersion(), VersioningPackage.eINSTANCE.getPrimaryVersionSpec_Identifier());
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(startText, SWT.FocusOut), modelObservable, null, null);

		// end PrimaryVersionSpec
		modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator().getVersionSpecQuery()
			.getEndVersion(), VersioningPackage.eINSTANCE.getPrimaryVersionSpec_Identifier());
		dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(endText, SWT.FocusOut), modelObservable, null, null);

		// forward
		modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(), IteratorPackage.eINSTANCE
			.getVersionIterator_Forward());
		dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(forwardButton), modelObservable, null, null);

		// return Project Copy
		modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(), IteratorPackage.eINSTANCE
			.getVersionIterator_ReturnProjectDataCopy());
		dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(returnCopyButton), modelObservable, null, null);
	}

	/**
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 * @return true if page is completed
	 */
	@Override
	public boolean isPageComplete() {
		if (ProjectAnalyzerWizardHelper.isTextNonEmpty(stepText) && defaultButton.getSelection()) {
			getNextPage();
			return true;
		} else if (ProjectAnalyzerWizardHelper.isTextNonEmpty(stepText)
			&& ProjectAnalyzerWizardHelper.isTextNonEmpty(startText)
			&& ProjectAnalyzerWizardHelper.isTextNonEmpty(endText) && (forwardButton.getSelection())) {
			getNextPage();
			return true;
		}
		return super.isPageComplete();
	}

	/**
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 * @return true if can flip to the next page
	 */
	@Override
	public boolean canFlipToNextPage() {
		return canFlipToNextPage;
	}

	/**
	 * @param canFlipToNextPage true if can flip to next page
	 */
	public void setCanFlipToNextPage(boolean canFlipToNextPage) {
		this.canFlipToNextPage = canFlipToNextPage;
	}

	/**
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 * @return IWizardPage
	 */
	@Override
	public IWizardPage getNextPage() {
		final ExporterPage page = ((ProjectAnalyzerWizard) getWizard()).getExporterPage();
		new AnalysisCommand(editingDomain) {

			@Override
			protected void doRun() {
				ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard) getWizard();
				conf.getIterator().setProjectId(wizard.getSelectedProjectID());
				if (conf.getExporter() == null) {
					CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
					conf.setExporter(exporter);
				}
				page.init();

			}
		}.run();
		return page;
	}

	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 * @param event Event
	 */
	public void handleEvent(Event event) {
		if (event.widget == defaultButton) {
			canFlipToNextPage = true;
			group.setEnabled(!defaultButton.getSelection());
			for (Control control : group.getChildren()) {
				control.setEnabled(!defaultButton.getSelection());
			}
		}
		setCanFlipToNextPage(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

}