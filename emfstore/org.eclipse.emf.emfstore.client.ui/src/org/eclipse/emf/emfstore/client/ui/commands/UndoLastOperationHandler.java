/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
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
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;

/**
 * UndoLastOperationHandler.
 * 
 * @author Hodaie
 */
public class UndoLastOperationHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = UiUtil.getEventElementByClass(event, ProjectSpace.class);
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				projectSpace.undoLastOperation();
			}
		}.run();
		return null;
	}
}
