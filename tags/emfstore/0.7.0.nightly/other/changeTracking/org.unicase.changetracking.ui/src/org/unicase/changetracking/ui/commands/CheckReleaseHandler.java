/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseChecker;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.releases.CheckReleaseDialog;
import org.unicase.changetracking.ui.releases.LocalRepoFindHandler;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseEventUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class CheckReleaseHandler extends AbstractHandler {

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
		
		//Find the corresponding local repository
		Repository localRepo = new LocalRepoFindHandler(r).find();
		
		//Ask the user to refresh his repo
		boolean upToDate = true;
		if(localRepo != null){
			upToDate = UIUtil.askForRefreshing();
		}
		
		//Create a report
		ReleaseCheckReport report = ReleaseChecker.check(localRepo, r, upToDate);
		
		CheckReleaseDialog dialog = new CheckReleaseDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), r, report);
		dialog.open();
		return null;
	}



	

}
