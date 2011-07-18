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
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseChecker;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.createChangePackage.CreateChangePackageWizard;
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

public class CreateChangePackageHandler extends ResourceCommandHandler {
	

	
	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		IResource[] resources = getSelectedResources(event);
		if(resources.length == 0){
			UIUtil.errorMessage("No project selected.");
			return null;
		}	   

		//Save dirty editors
		if(!PlatformUI.getWorkbench().saveAllEditors(true)){
			return null;
		}
		
		//Get the git repo the resource belongs to
		Repository repo = GitRepoFindUtil.findRepository(resources[0].getLocation().toFile());
		if(repo == null){
			UIUtil.errorMessage("The selected resource is not under git version control.");
			return null;
		}
		
		if(!repo.getRepositoryState().canCommit()){
			UIUtil.errorMessage("The repository is in a state which disallows committing");
			return null;
		}
		
		try{
			WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(), new CreateChangePackageWizard(repo));
		    dlg.open();
		} catch (Throwable t){
			ModelUtil.logException(t);
			return null;
		}
		return null;
	}

	

}
