/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

/**
 * @author liya
 */
public class IteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String PAGE_DESCRIPTION = " your Iterator used for analyzing the project.";
	private boolean canFlipToNextPage;
	private Button versionIteratorButton;
	private Button timeIteratorButton;

	private AnalyzerConfiguration conf;
	private final TransactionalEditingDomain editingDomain;

	/**
	 * @param pageName Name of the page
	 */
	protected IteratorPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;
		editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if (event.widget == versionIteratorButton || event.widget == timeIteratorButton) {
			canFlipToNextPage = true;
		}

		getWizard().getContainer().updateButtons();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		if (versionIteratorButton.getSelection()) {
			final VersionIteratorPage page = ((ProjectAnalyzerWizard) getWizard()).getVersionIteratorPage();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
					if (conf.getIterator() == null || conf.getIterator() instanceof TimeIterator) {
						PrimaryVersionSpec startVer = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
						PrimaryVersionSpec endVer = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
						VersionSpecQuery versionQuery = IteratorFactory.eINSTANCE.createVersionSpecQuery();
						versionQuery.setStartVersion(startVer);
						versionQuery.setEndVersion(endVer);
						VersionIterator versionIterator = IteratorFactory.eINSTANCE.createVersionIterator();
						versionIterator.setVersionSpecQuery(versionQuery);
						conf.setIterator(versionIterator);
					}
					page.initDefaulGroup();
					page.initGroup();
				}
			});
			return page;

		} else if (timeIteratorButton.getSelection()) {
			final TimeIteratorPage page = ((ProjectAnalyzerWizard) getWizard()).getTimeIteratorPage();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
					if (conf.getIterator() == null || !(conf.getIterator() instanceof TimeIterator)) {
						DateVersionSpec startVer = VersioningFactory.eINSTANCE.createDateVersionSpec();
						DateVersionSpec endVer = VersioningFactory.eINSTANCE.createDateVersionSpec();
						VersionSpecQuery versionQuery = IteratorFactory.eINSTANCE.createVersionSpecQuery();
						versionQuery.setStartVersion(startVer);
						versionQuery.setEndVersion(endVer);
						TimeIterator timeIterator = IteratorFactory.eINSTANCE.createTimeIterator();
						timeIterator.setVersionSpecQuery(versionQuery);
						conf.setIterator(timeIterator);
					}
					page.initDefaulGroup();
					page.initGroup();
				}
			});
			return page;
		} else {
			return super.getNextPage();
		}
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
	 * @param canFlipToNextPage true if can flip to next page
	 */
	public void setCanFlipToNextPage(boolean canFlipToNextPage) {
		this.canFlipToNextPage = canFlipToNextPage;
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

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;

		versionIteratorButton = new Button(composite, SWT.RADIO);
		versionIteratorButton.setText("Version Iterator");
		versionIteratorButton.setLayoutData(gd);
		versionIteratorButton.addListener(SWT.Selection, this);

		timeIteratorButton = new Button(composite, SWT.RADIO);
		timeIteratorButton.setText("Time Iterator");
		timeIteratorButton.setLayoutData(gd);
		timeIteratorButton.addListener(SWT.Selection, this);

		setCanFlipToNextPage(isPageComplete());
		setControl(composite);
		// setPageComplete(true);

	}

	/**
	 * Initialize this page's editing domain.
	 */
	public void init() {
		conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
		if (conf.getIterator() != null) {
			if (conf.getIterator() instanceof TimeIterator) {
				timeIteratorButton.setSelection(true);
			} else {
				versionIteratorButton.setSelection(true);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		if (timeIteratorButton.getSelection() || versionIteratorButton.getSelection()) {
			return true;
		}
		return super.isPageComplete();

	}

}
