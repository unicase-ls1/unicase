/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * The Paste Handler. Loads a UnicaseTransferable from the system clipboard, handles the paste action and ends the begun
 * CompositeOperation.
 * 
 * @author weiglt
 */
public final class PasteHandler extends AbstractHandler {

	private ModelElement meSource, meTarget;
	private CompositeOperationHandle cOH;
	private Clipboard clipboard;
	private Transferable transferable;
	private String prevLocation, prevLocationType;

	/**
	 * Executes the Button Command for "Paste" Gadget.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		meTarget = ActionHelper.getModelElement(event);

		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferable = clipboard.getContents(null);

		paste(meTarget);

		return null;
	}

	private void paste(final ModelElement meTarget) {

		try {
			meSource = (ModelElement) transferable.getTransferData(new DataFlavor(
				org.unicase.metamodel.ModelElement.class, "ModelElement"));
			cOH = (CompositeOperationHandle) transferable.getTransferData(new DataFlavor(
				org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		}
		final EReference theRef = getTargetRef(meTarget, meSource);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				prevLocation = ((UnicaseModelElement) ((UnicaseModelElement) meSource).getContainerModelElement())
					.getName();
				prevLocationType = (((UnicaseModelElement) meSource).getContainerModelElement()).eClass().getName();
				meSource.eSet(theRef.getEOpposite(), meTarget);
				// ((LeafSection) meTarget).getModelElements().add((UnicaseModelElement) meSource); Alternative Lösung
				// für LeafSections
			}
		}.run();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					cOH.end("Cutted and pasted ModelElement", "Moved " + meSource.eClass().getName() + " \""
						+ ((UnicaseModelElement) meSource).getName() + "\" from " + prevLocationType + " \""
						+ prevLocation + "\" to " + meTarget.eClass().getName() + " \""
						+ ((UnicaseModelElement) meTarget).getName() + "\"", meSource.getModelElementId());
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Composite Operation failed!", e);
				}
			}
		}.run();
	}

	private EReference getTargetRef(EObject targetContainer, ModelElement me) {

		List<EReference> refs = targetContainer.eClass().getEAllContainments();
		for (EReference ref : refs) {
			if (ref.isContainer()) {
				continue;
			}
			if (ref.getEReferenceType().equals(me.eClass()) || ref.getEReferenceType().isSuperTypeOf(me.eClass())) {
				return ref;
			}
		}
		return null;

	}
}