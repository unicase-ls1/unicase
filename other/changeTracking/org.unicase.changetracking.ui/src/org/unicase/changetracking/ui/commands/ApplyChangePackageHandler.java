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
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.git.commands.GitApplyChangePackageCommand;
import org.unicase.changetracking.git.exceptions.NoMatchingLocalRepositoryInWorkspace;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseChecker;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseEventUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class ApplyChangePackageHandler extends AbstractHandler {
	

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		UnicaseModelElement elem = UnicaseActionHelper.getModelElement(event);
		if(!(elem instanceof GitBranchChangePackage)){
			throw new ExecutionException("The model element for an apply change package action was no GitBranchChangePackage!");
		}
		applyChangePackage((GitBranchChangePackage) elem);
		return null;
	}
	
	public void applyChangePackage(GitBranchChangePackage changePackage){
		try {
			
			new GitApplyChangePackageCommand().applyChangePackage(changePackage);
			UIUtil.openInformation("Success!",
					"The change package was successfully applied onto your workspace.");
		} catch (NoMatchingLocalRepositoryInWorkspace e1) {
			UIUtil.errorMessage("No matching local repository was found in workspace. Make sure you have cloned the remote repository of this change package.");
		} catch (RuntimeException e){
			ModelUtil.logException(e);
		}
	}

	

}
