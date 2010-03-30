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
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author liya
 */
public class TimeIteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String PAGE_DESCRIPTION = "Configure your TimeIterator.";
	private static final String[] UNITS = { "Year", "Month", "Day", "Hour", "Minute", "Second" };
	private static final int[] CALENDAR_FIELDS = { 1, 2, 5, 10, 12, 13 }; // for the date units

	private boolean canFlipToNextPage;

	private Text stepText;
	private Combo stepUnit;
	private Button defaultButton;
	private Group group;
	private Button forwardButton;
	private Button returnCopyButton;
	private Label stepUnitLabel;
	private CDateTime startDate;
	private CDateTime endDate;
	private final TransactionalEditingDomain editingDomain;
	private AnalyzerConfiguration conf;
	private TimeIterator timeIterator;

	/**
	 * @param pageName Name of the page
	 */
	protected TimeIteratorPage(String pageName) {
		super(pageName);

		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;

		editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
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
		stepText.setText("1");
		stepText.setLayoutData(gd);
		stepText.addListener(SWT.KeyUp, this);

		stepUnitLabel = new Label(composite, SWT.NONE);
		stepUnitLabel.setText("Step Unit:");
		stepUnit = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		stepUnit.setLayoutData(new GridData(GridData.END));
		stepUnit.setItems(UNITS);
		stepUnit.addListener(SWT.Selection, this);

		defaultButton = new Button(composite, SWT.CHECK);
		defaultButton.setText("Analyze all versions");
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
		group.setLayout(new GridLayout(4, false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		group.setLayoutData(gd);

		new Label(group, SWT.NONE).setText("Start:");
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		startDate = new CDateTime(group, CDT.BORDER);
		startDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		startDate.setPattern("dd.MM.yyyy HH:mm");

		new Label(group, SWT.NONE).setText("End:");
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		endDate = new CDateTime(group, CDT.BORDER);
		endDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		endDate.setPattern("dd.MM.yyyy HH:mm");

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

		// stepLengthUnit
		if (conf.getIterator() instanceof TimeIterator) {
			stepUnit.select(indexOf(((TimeIterator) conf.getIterator()).getStepLengthUnit()));
		}

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

		ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard) getWizard();
		conf = wizard.getAnalyzerConfig();
		// startDate for TimeIterator
		// if (conf.getIterator() instanceof TimeIterator) {
		// Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.MINUTE, -2);
		// Date start = ((TimeIterator) conf.getIterator()).getStartDate();
		// if (start == null || start.compareTo(cal.getTime()) < 0) {
		// List<HistoryInfo> historyList;
		// try {
		// historyList = conf.getIterator().getConnectionManager().getHistoryInfo(
		// wizard.getSelectedProject().getUsersession().getSessionId(), wizard.getSelectedProjectID(),
		// VersioningFactory.eINSTANCE.createHistoryQuery());
		// HistoryInfo initialHistory = historyList.get(historyList.size());
		// startDate.setSelection(initialHistory.getLogMessage().getDate());
		// } catch (EmfStoreException e) {
		// WorkspaceUtil.logException("Can not get the date of the project creation", e);
		// }
		//
		// } else {
		// startDate.setSelection(((TimeIterator) conf.getIterator()).getStartDate());
		// }
		// }

		// endDate for TimeIterator
		// if (conf.getIterator() instanceof TimeIterator) {
		// if (((TimeIterator) conf.getIterator()).getEndDate() == null) {
		// List<HistoryInfo> historyList;
		// try {
		// historyList = conf.getIterator().getConnectionManager().getHistoryInfo(
		// wizard.getSelectedProject().getUsersession().getSessionId(), wizard.getSelectedProjectID(),
		// VersioningFactory.eINSTANCE.createHistoryQuery());
		// HistoryInfo initialHistory = historyList.get(0);
		// endDate.setSelection(initialHistory.getLogMessage().getDate());
		// } catch (EmfStoreException e) {
		// WorkspaceUtil.logException("Can not get the date of the project creation", e);
		// }
		// } else {
		// endDate.setSelection(((TimeIterator) conf.getIterator()).getEndDate());
		// }
		// }
		startDate.setSelection(((TimeIterator) conf.getIterator()).getStartDate());
		endDate.setSelection(((TimeIterator) conf.getIterator()).getEndDate());

		// forward
		IObservableValue modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(),
			IteratorPackage.eINSTANCE.getVersionIterator_Forward());
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(forwardButton), modelObservable, null, null);

		// return Project Copy
		modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getIterator(), IteratorPackage.eINSTANCE
			.getVersionIterator_ReturnProjectDataCopy());
		dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(returnCopyButton), modelObservable, null, null);
	}

	private int indexOf(int stepLengthUnit) {
		for (int i = 0; i < CALENDAR_FIELDS.length; i++) {
			if (stepLengthUnit == CALENDAR_FIELDS[i]) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * @param canFlipToNextPage true if can flip to next page
	 */
	public void setCanFlipToNextPage(boolean canFlipToNextPage) {
		this.canFlipToNextPage = canFlipToNextPage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return canFlipToNextPage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		final ExporterPage page = ((ProjectAnalyzerWizard) getWizard()).getExporterPage();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard) getWizard();

				timeIterator = (TimeIterator) conf.getIterator();
				timeIterator.setProjectId(wizard.getSelectedProjectID());
				timeIterator.setStepLengthUnit(CALENDAR_FIELDS[stepUnit.getSelectionIndex()]);

				if (!defaultButton.getSelection()) {
					timeIterator.setStartDate(startDate.getSelection());
					timeIterator.setEndDate(endDate.getSelection());

					DateVersionSpec startVer = (DateVersionSpec) timeIterator.getVersionSpecQuery().getStartVersion();
					startVer.setDate(startDate.getSelection());
					DateVersionSpec endVer = (DateVersionSpec) timeIterator.getVersionSpecQuery().getEndVersion();
					endVer.setDate(endDate.getSelection());
				}
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if (event.widget == defaultButton) {
			canFlipToNextPage = true;
			group.setEnabled(!defaultButton.getSelection());
			for (Control control : group.getChildren()) {
				control.setEnabled(!defaultButton.getSelection());

			}
		}
		group.setEnabled(!defaultButton.getSelection());
		setCanFlipToNextPage(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		if (ProjectAnalyzerWizardHelper.isTextNonEmpty(stepText) && defaultButton.getSelection()) {
			getNextPage();
			return true;
		} else if (ProjectAnalyzerWizardHelper.isTextNonEmpty(stepText) && forwardButton.getSelection()) {
			getNextPage();
			return true;
		}
		return super.isPageComplete();
	}

}
