/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.cutpaste.stuff.UnicaseTransferable;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The Cut Handler. Creates a UnicaseTransferable, copies it to the system clipboard and begins a CompositeOperation.
 * Usually followed by the paste command or another cut command which aborts the old command.
 * 
 * @author weiglt
 */
public final class CutHandler extends AbstractHandler {

	private Clipboard clipboard;
	private Transferable transferable;
	private CompositeOperationHandle handle;
	private ModelElement meClipboard;

	/**
	 * Executes the cut command.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ModelElement meSource = ActionHelper.getModelElement(event);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				cut(meSource);
			}
		}.run();

		return null;
	}

	private void cut(ModelElement meSource) {

		final Project project = meSource.getProject();
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		try {
			System.out.println("Try to load from clipboard:");
			transferable = clipboard.getContents(null);
			meClipboard = (ModelElement) transferable.getTransferData(new DataFlavor(
				org.unicase.metamodel.ModelElement.class, "ModelElement"));
			handle = (CompositeOperationHandle) transferable.getTransferData(new DataFlavor(
				org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"));

			try {
				System.out.println("Try to abort old CompositeOperation.");
				if (handle.isValid()) {
					handle.end("Aborted Cut Operation.", "Aborted Cut Operation.", ((UnicaseModelElement) meClipboard)
						.getModelElementId()); // Why is this end and not abort?
				}
				clipboard.setContents(new StringSelection(""), null);
				System.out.println("Done");
			} catch (InvalidHandleException e) {
				e.printStackTrace();
				System.out.println("ERROR cut");
			}

		} catch (UnsupportedFlavorException e) {
			System.out.println("Clipboard was empty.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Init new CompositeOperation.");
			handle = projectSpace.beginCompositeOperation();
			transferable = new UnicaseTransferable(meSource, handle);
			clipboard.setContents(transferable, null);
			// --> //INSERT REFRESH NAVIGATOR VIEW HERE
		}
	}

}
