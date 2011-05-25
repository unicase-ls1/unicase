/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Handler for the "apply change package" command.
 * 
 * @author jfinis
 * 
 */
public class ApplyChangePackageHandler extends ChangeTrackingCommandHandler {

	/**
	 * Applies the currently selected change package.
	 * 
	 * {@inheritDoc}
	 */
	public void doExecute(ExecutionEvent event) {
		// Retrieve selected element and apply it
		UnicaseModelElement elem = UnicaseActionHelper.getModelElement(event);
		applyChangePackage((ChangePackage) elem);
	}

	/**
	 * Performs the application by getting the appropriate adapter and making it
	 * perform the command.
	 * 
	 * @param changePackage change package to be applied
	 */
	public void applyChangePackage(ChangePackage changePackage) {
		IVCSAdapter vcs = new VCSAdapterFactory().createFromChangePackage(changePackage);
		ChangeTrackingCommand cmd = vcs.applyChangePackage(changePackage);
		UIUtil.runCommand(cmd);
	}

}
