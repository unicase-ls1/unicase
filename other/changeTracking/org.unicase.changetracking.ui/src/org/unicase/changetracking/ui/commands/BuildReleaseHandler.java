/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.ResultType;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.UIDecisionProvider;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.releases.BuildReleaseWizard;
import org.unicase.changetracking.vcs.VCSAdapter;
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
public class BuildReleaseHandler extends AbstractHandler {

	@Override
	public void setEnabled(Object evaluationContext) {
		// FIXME: Make this called when the build state changes
		// if(evaluationContext instanceof EvaluationContext){
		// EObject e = (EObject) ((EvaluationContext)
		// evaluationContext).getVariable("meToOpen");
		// if(e instanceof ChangeTrackingRelease &&
		// !((ChangeTrackingRelease)e).isBuilt()){
		// setBaseEnabled(true);
		// return;
		// }
		// }
		setBaseEnabled(true);
	}

	/**
	 * Checks the release and then opens the build release wizard.
	 * 
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Retrieve selected release
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if (!(me instanceof Release)) {
			UIUtil.errorMessage("The selected model element is no change tracking release");
			return null;
		}

		// Retrieve correspondent adapter
		Release r = (Release) me;
		VCSAdapter vcs = new VCSAdapterFactory().createFromRelease(r);

		// Check the release
		CheckReleaseCommand command = vcs.checkRelease(new UIDecisionProvider(), r);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if (result.getResultType() != ResultType.SUCCESS) {
			return null;
		}
		ReleaseCheckReport report = command.getReport();

		// Open the build release wizard
		WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new BuildReleaseWizard(r, report, vcs));
		dlg.open();

		return null;
	}

}
