/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Import all user from LDDAP to the project.
 * 
 * @author helming
 */
public class ImportUserHandler extends AbstractHandler {
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = UnicaseActionHelper.getProjectSpace(event);
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				try {
					OrgUnitHelper.importACUsers(projectSpace);
				} catch (AccessControlException e) {
					String message = "No admin rights for user import!";
					WorkspaceUtil.logWarning(message, e);
					DialogHandler.showExceptionDialog(message, e);
				}
			}
		}.run();

		return null;
	}

}