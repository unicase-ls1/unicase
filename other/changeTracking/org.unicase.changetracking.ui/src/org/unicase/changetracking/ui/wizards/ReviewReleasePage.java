/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.wizards;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.dialogs.IDialogHead;
import org.unicase.changetracking.ui.widgets.ReleaseOverviewWidget;
import org.unicase.model.changetracking.Release;

/**
 * Review release page of the build release wizard.
 * 
 * This page mainly shows the results of the release checking and is therefore
 * very similar to the CheckReleaseDialog.
 * 
 * To avoid code duplication, the actual code for displaying the release
 * checking result was factored out to the RelaseOverviewWidget. This page uses
 * the widget to achieve its behaviour.
 * 
 * @author jfinis
 */
public class ReviewReleasePage extends WizardPage implements IDialogHead {

	private Release release;
	private ReleaseCheckReport report;

	/**
	 * Default constructor.
	 * 
	 * @param pageName page name
	 * @param title page title
	 * @param titleImage title image
	 * @param release release which was checked
	 * @param report resulting report of the check
	 */
	protected ReviewReleasePage(String pageName, String title, ImageDescriptor titleImage, Release release, ReleaseCheckReport report) {
		super(pageName, title, titleImage);
		this.release = release;
		this.report = report;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		ReleaseOverviewWidget composite = new ReleaseOverviewWidget(parent, SWT.NONE, release, report);
		setControl(composite);
		configureDialogHead(report);
	}

	private void configureDialogHead(ReleaseCheckReport report) {

		if (report.hasErrors()) {
			setMessage("You cannot build the release because errors where found.\nCheck the 'problems' tab for details.", IMessageProvider.ERROR);
		} else if (report.hasWarnings()) {
			setMessage("It is discouraged to build the release with warnings.\nCheck the 'problems' tab for details.", IMessageProvider.WARNING);
		} else {
			setMessage("The release is ready to be built.\nNo errors or warnings were found.", IMessageProvider.INFORMATION);
		}

	}

	@Override
	public boolean canFlipToNextPage() {
		return !report.hasErrors();
	}
}
