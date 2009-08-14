/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.task.WorkPackage;
import org.unicase.pmdashboard.burndown.views.BurndownView;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This Handler gets the selected element and shows a burndown chart for it, if its a WorkPackage.
 * @author andy
 *
 */
public class ShowBurndownChartHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Object obj = ActionHelper.getModelElement(event);

		try {
			BurndownView view  = (BurndownView) page.showView(BurndownView.ID);

			if (obj instanceof WorkPackage) {
				view.setInput((WorkPackage) obj);
			}
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}

		return null;

	}

}
