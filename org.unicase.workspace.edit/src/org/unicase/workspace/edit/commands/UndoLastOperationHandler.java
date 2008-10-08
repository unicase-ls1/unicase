/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**.
 * UndoLastOperationHandler
 * @author Hodaie
 *
 */
public class UndoLastOperationHandler extends ProjectActionHandler {

	/**.
	 * {@inheritDoc}
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		getProjectSpace(event).undoLastOperation();
		return null;
	}

}
