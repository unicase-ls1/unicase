/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.widgets.ReleaseOverviewWidget;
import org.unicase.model.changetracking.Release;

/**
 * Dialog used when the release is to be checked without being built.
 * 
 * Displays the release check report.
 * 
 * @author jfinis
 * 
 */
public class CheckReleaseDialog extends TitleAreaDialog implements IDialogHead {

	private static final Image PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/check_release.png").createImage();

	private Release release;
	private ReleaseCheckReport report;

	/**
	 * Default constructor.
	 * 
	 * @param parentShell parent shell
	 * @param release release which was checked
	 * @param report result of the checking
	 */
	public CheckReleaseDialog(Shell parentShell, Release release, ReleaseCheckReport report) {
		super(parentShell);
		this.release = release;
		this.report = report;

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Release Checking Report");
		setShellStyle(getShellStyle() | SWT.CLOSE | SWT.TITLE | SWT.BORDER

		| SWT.APPLICATION_MODAL | SWT.RESIZE);
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		if (id == Window.CANCEL) {
			return null;
		}
		return super.createButton(parent, id, label, defaultButton);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleImage(PAGE_IMAGE);
		setTitle("Release Checking Report");

		ReleaseOverviewWidget releaseWidget = new ReleaseOverviewWidget(parent, SWT.NONE, release, report);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(releaseWidget);

		configureDialogHead(report);

		return releaseWidget;
	}

	private void configureDialogHead(ReleaseCheckReport report) {

		if (report.hasErrors()) {
			setMessage("There are errors in the release. Check the 'problems' tab for details.", IMessageProvider.ERROR);
		} else if (report.hasWarnings()) {
			setMessage("There are warnings in the release. Check the 'problems' tab for details.", IMessageProvider.WARNING);
		} else {
			setMessage("No errors were found in this release.", IMessageProvider.INFORMATION);
		}

	}
}
