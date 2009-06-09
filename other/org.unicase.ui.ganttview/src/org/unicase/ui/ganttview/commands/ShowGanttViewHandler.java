/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.ganttview.models.GanttModelFactory;
import org.unicase.ui.ganttview.views.GanttView;

public class ShowGanttViewHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ModelElement me = ActionHelper.getModelElement(event);

		try {
			GanttView ganttView = (GanttView) page.showView(GanttView.ID);//, me.getName(),
				//IWorkbenchPage.VIEW_ACTIVATE);
//			ganttView.setInput(GanttModelFactory.createGanttModelTest());
//			TODO: 
			ganttView.setInput(GanttModelFactory.createGanttModelFromSelectedWorkItems(me));
			WorkPackage p = null;

		} catch (PartInitException e) {
			//DialogHandler.showExceptionDialog(e);
		}

		return null;

	}

}
