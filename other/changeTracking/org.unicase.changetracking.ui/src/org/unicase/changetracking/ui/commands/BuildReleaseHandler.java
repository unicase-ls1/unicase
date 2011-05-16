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
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

public class BuildReleaseHandler extends AbstractHandler {
	
	public BuildReleaseHandler() {
		//setBaseEnabled(false);
	
	}
	
	@Override
	public void setEnabled(Object evaluationContext) {
		//FIXME: Make this called when the build state changes
//		if(evaluationContext instanceof EvaluationContext){
//			EObject e = (EObject) ((EvaluationContext) evaluationContext).getVariable("meToOpen");
//			if(e instanceof ChangeTrackingRelease && !((ChangeTrackingRelease)e).isBuilt()){
//				setBaseEnabled(true);
//				return;
//			}
//		}
		setBaseEnabled(true);
	}

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		//Retrieve selected release
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if(!(me instanceof ChangeTrackingRelease)){
			UIUtil.errorMessage("The selected model element is no change tracking release");
			return null;
		}
		
		ChangeTrackingRelease r = (ChangeTrackingRelease) me;
		
		VCSAdapter vcs = new VCSAdapterFactory().createFromRelease(r);
		
		CheckReleaseCommand command = vcs.checkRelease(new UIDecisionProvider(), r);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if(result.getResultType() != ResultType.SUCCESS){
			return null;
		}
	
		//Create a report
		ReleaseCheckReport report = command.getReport();
	
		try{
			WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(), new BuildReleaseWizard(r,report,vcs));
		    dlg.open();
		} catch (Throwable t){
			ModelUtil.logException(t);
			throw new ExecutionException("",t);
		}
		
		
		return null;
	}

	

}
