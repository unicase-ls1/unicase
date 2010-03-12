/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.cutpaste.stuff.UnicaseTransferable;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The Cut Handler. Creates a UnicaseTransferable, copies it to the system clipboard and begins a CompositeOperation.
 * Usually followed by the paste command.
 * 
 * @author weiglt
 */
public final class CutHandler extends AbstractHandler {
	/**
	 * Executes the Button Command for "Cut" Gadget.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ModelElement meSource = ActionHelper.getModelElement(event);
		final Project project = meSource.getProject();
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				CompositeOperationHandle cOH = projectSpace.beginCompositeOperation();

				cutModelElement(meSource, cOH);
				// modify-decorator here
			}
		}.run();

		return null;
	}

	private void cutModelElement(final ModelElement meSource, final CompositeOperationHandle cOH) {

		Transferable transferable = new UnicaseTransferable(meSource, cOH);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(transferable, null);

	}
}
