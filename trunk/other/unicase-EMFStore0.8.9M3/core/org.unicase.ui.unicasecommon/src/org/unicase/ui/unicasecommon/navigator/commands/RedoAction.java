/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.jface.action.Action;

/**
 * @author Hodaie This is the temporary implementation for redo action in navigator. Currently we have a problem with
 *         undo/redo and EditingDomain; in that, navigator can undo/redo changes not occurred through it. The unod/redo
 *         in navigator should actually consider only its own context. To set enablement of global undo/redo menu items
 *         in Workbench edit menu, this class implements CommandStackListener
 */
public class RedoAction extends Action implements CommandStackListener {

	private CommandStack commandStack;

	/**
	 * . Constructor
	 */
	public RedoAction() {
		this.commandStack = Configuration.getEditingDomain().getCommandStack();
		commandStack.addCommandStackListener(this);

	}

	/**
	 * . {@inheritDoc}
	 */
	public void commandStackChanged(EventObject event) {
		setEnabled(commandStack.canRedo());
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void run() {
		Configuration.getEditingDomain().getCommandStack().redo();

	}

}
