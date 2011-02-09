/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseChecker;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.changetracking.ui.AdvancedMessageDialog;
import org.unicase.changetracking.ui.CreateRepoLocationAction;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.AdvancedMessageDialog.NoRemoteRepoChoices;
import org.unicase.changetracking.ui.createChangePackage.CreateChangePackageWizard;
import org.unicase.changetracking.ui.dialogs.AdvancedMESelectionDialog;
import org.unicase.changetracking.ui.dialogs.ModelElementPlacementDialog;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.ChangetrackingFactory;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseEventUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class CreateStreamFromCurrentBranchHandler extends ResourceCommandHandler {
	

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
		

		Shell shell = PlatformUI.getWorkbench().
			getActiveWorkbenchWindow().getShell();
	
		String branchName = null;
		try {
			branchName = repo.getBranch();
		} catch (IOException e) {
			UIUtil.errorMessage("An IO Exception occurred while reading the repository branch.");
			ModelUtil.logException(e);
			return null;
		}
		
		Stream stream = ChangetrackingFactory.eINSTANCE.createStream();
		
		ModelElementPlacementDialog placementDialog = new ModelElementPlacementDialog(shell, stream, true);
		
		if(placementDialog.open() != Window.OK){
			return null;
		}
		
		Project project = ModelUtil.getProject(placementDialog.getSelection());
		
		//Find a git remote repo in the project
		GitRepository remoteRepo = GitRepoFindUtil.findRemoteInProject(repo, project);
		
		//No repo found? Ask the user what to do...
		if(remoteRepo != null){
			NoRemoteRepoChoices choice = AdvancedMessageDialog.openNoRemoteRepoFoundDialog(shell);
			switch(choice){
			case CANCEL:
				return null;
			case CREATE:
				remoteRepo = new CreateRepoLocationAction().createRepoLocation(repo, project);
				//User hit cancel while creating the repo location?
				if(remoteRepo == null){
					return null;
				}
				break;
			case DO_NOT_CREATE:
				break;
			}
		}
		
		//*** Create and add the stream and the branch.
		//1. place the stream
		placementDialog.doPlacement();
		//2. create, link and place the branch (in the same folder)
		GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
		branch.setName(branchName);
		branch.setBranchName(branchName);
		branch.setLocation(remoteRepo);
		stream.setRepositoryStream(branch);
		GitUtil.putInto(branch, placementDialog.getSelection());
		
		return null;
		
	}

	

}
