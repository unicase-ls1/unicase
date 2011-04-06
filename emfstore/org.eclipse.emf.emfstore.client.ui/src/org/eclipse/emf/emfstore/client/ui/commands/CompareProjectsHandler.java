/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.dialogs.CompareProjectsDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * . This handler shows compare projects dialog
 * 
 * @author Hodaie
 */
public class CompareProjectsHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// show compare dialog
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		ProjectSpace projSpace = (ProjectSpace) ((StructuredSelection) sel)
				.getFirstElement();

		CompareProjectsDialog compareDialog = new CompareProjectsDialog(
				HandlerUtil.getActiveShell(event), projSpace);
		compareDialog.create();
		compareDialog.open();
		return null;
	}

}
