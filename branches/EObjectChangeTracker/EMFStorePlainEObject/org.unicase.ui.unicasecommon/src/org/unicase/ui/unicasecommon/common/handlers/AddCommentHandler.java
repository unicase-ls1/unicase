/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This is handler to add a comment to a ModelElement.
 * 
 * @author Shterev
 */
public class AddCommentHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject me = ActionHelper.getModelElement(event);
		ActionHelper.openDiscussion(me, true);

		return null;
	}
}
