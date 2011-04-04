/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.handler;

import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.DeleteModelElementCommand;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.ecp.navigator.Activator;

/**
 * . This is the Handler to delete a ModelElement
 * 
 * @author Helming
 */
public class DeleteModelelementHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Set<EObject> eObjects = UiUtil.getSelectedEObjects(event);
		if (!eObjects.isEmpty()) {
			deleteModelElement(eObjects);
		}
		return null;
	}

	private void deleteModelElement(final Set<EObject> eObjects) {
		try {
			new DeleteModelElementCommand(eObjects, ECPWorkspaceManager.getInstance().getWorkSpace()
				.getProject(eObjects.iterator().next())).run();
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}
	}

}
