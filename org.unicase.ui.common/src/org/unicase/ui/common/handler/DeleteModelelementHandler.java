/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.internal.keys.model.ModelElement;
import org.unicase.ui.common.commands.DeleteModelElementCommand;
import org.unicase.ui.common.util.ActionHelper;

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
		EObject me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}


		deleteModelElement(me);

		return null;
	}

	private void deleteModelElement(final EObject me) {
		new DeleteModelElementCommand(me).run();
	}

}
