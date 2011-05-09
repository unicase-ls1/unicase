/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

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
		VCSAdapter vcs = new VCSAdapterFactory().createFromChangePackage(changePackage);
		
		ChangeTrackingCommand cmd = vcs.applyChangePackage(changePackage);
		UIUtil.runCommand(cmd);
		
	
	}

	

}
