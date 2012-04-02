/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.ResultType;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.UIDecisionProvider;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.wizards.BuildReleaseWizard;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.Release;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Handler for the "build release" command.
 * 
 * @author jfinis
 * 
 */
public class BuildReleaseHandler extends ChangeTrackingCommandHandler {

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(true);
	}

	/**
	 * Checks the release and then opens the build release wizard.
	 * 
	 * {@inheritDoc}
	 */
	public void doExecute(ExecutionEvent event) {

		// Retrieve selected release
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if (!(me instanceof Release)) {
			abort("The selected model element is no change tracking release");
		}

		// Retrieve correspondent adapter
		Release r = (Release) me;
		IVCSAdapter vcs = new VCSAdapterFactory().createFromRelease(r);

		// Check the release
		CheckReleaseCommand command = vcs.checkRelease(new UIDecisionProvider(), r);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if (result.getResultType() != ResultType.SUCCESS) {
			return;
		}
		ReleaseCheckReport report = command.getReport();

		// Open the build release wizard
		WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new BuildReleaseWizard(r, report, vcs));
		dlg.open();

	}

}
