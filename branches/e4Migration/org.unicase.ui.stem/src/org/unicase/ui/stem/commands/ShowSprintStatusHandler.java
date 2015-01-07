/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.internal.client.ui.dialogs.EMFStoreMessageDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.stem.views.sprintstatus.SprintStatusView;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * This is the handler to open the sprint status view.
 * 
 * @author Shterev
 */
public class ShowSprintStatusHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);

		try {
			SprintStatusView sprintStatusView = (SprintStatusView) page
					.showView(SprintStatusView.ID);
			sprintStatusView.setInput(me);

		} catch (PartInitException e) {
			EMFStoreMessageDialog.showExceptionDialog(e);
		}

		return null;
	}
}
