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
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The Paste Handler. Loads a UnicaseTransferable from the system clipboard, handles the paste action and ends the begun
 * CompositeOperation.
 * 
 * @author weiglt
 */
public final class PasteHandler extends AbstractHandler {

	private Clipboard clipboard;
	private CompositeOperationHandle handle;
	private ModelElement meSource;
	private Object target; // Target can be a Project or a ME
	private String prevLocation, prevLocationType;

	/**
	 * Executes the paste command.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		target = ActionHelper.getModelElement(event);
		if (target == null) {
			target = ActionHelper.getProjectSpace(event);
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				paste(target);
			}
		}.run();

		return null;
	}

	/**
	 * The paste operation.
	 */
	private void paste(final Object target) {

		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transferable = clipboard.getContents(null);

		try { // get data from clipboard
			meSource = (ModelElement) transferable.getTransferData(new DataFlavor(
				org.unicase.metamodel.ModelElement.class, "ModelElement"));
			handle = (CompositeOperationHandle) transferable.getTransferData(new DataFlavor(
				org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"));
		} catch (UnsupportedFlavorException e1) {
			// flavor could not be provided (clipboard empty/corrupted?). actually the
			// propertytester should prevent this and thus this exception should never be thrown.
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Remember old ME data before changing
		UnicaseModelElement umeSourceContainer = (UnicaseModelElement) ((UnicaseModelElement) meSource)
			.getContainerModelElement();
		if (umeSourceContainer instanceof UnicaseModelElement) {
			prevLocation = umeSourceContainer.getName();
			prevLocationType = umeSourceContainer.eClass().getName();
		} else if (umeSourceContainer == null) { // then parent is project
			prevLocation = WorkspaceManager.getProjectSpace(meSource.getProject()).getProjectName();
			prevLocationType = meSource.getProject().eClass().getName();
		}

		if (target instanceof ModelElement) {
			ModelElement meTarget = (ModelElement) target;
			pasteIntoME(meTarget);

		} else if (target instanceof ProjectSpace) {
			ProjectSpace psTarget = (ProjectSpace) target;
			pasteIntoProject(psTarget);
		}
	}

	/**
	 * Paste into another ModelElement.
	 */
	private void pasteIntoME(ModelElement meTarget) {

		genericPaste(meTarget, meSource);

		try {
			handle.end("Cut and pasted ModelElement", "Moved " + meSource.eClass().getName() + " \""
				+ ((UnicaseModelElement) meSource).getName() + "\" from " + prevLocationType + " \"" + prevLocation
				+ "\" to " + meTarget.eClass().getName() + " \"" + ((UnicaseModelElement) meTarget).getName() + "\"",
				((UnicaseModelElement) meSource).getModelElementId());
			refreshCutAndPasteDecorator();
			clearClipboard();
		} catch (InvalidHandleException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Paste into project root.
	 */
	private void pasteIntoProject(ProjectSpace psTarget) {

		psTarget.getProject().getModelElements().add(meSource);

		try {
			handle.end("Cut and pasted ModelElement", "Moved " + meSource.eClass().getName() + " \""
				+ ((UnicaseModelElement) meSource).getName() + "\" from " + prevLocationType + " \"" + prevLocation
				+ "\" to " + psTarget.getProject().eClass().getName() + " \"" + psTarget.getProjectName() + "\"",
				((UnicaseModelElement) meSource).getModelElementId());
			refreshCutAndPasteDecorator();
			clearClipboard();
		} catch (InvalidHandleException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void genericPaste(final ModelElement meTarget, final ModelElement source) {

		EReference theRef = getTargetRef(meTarget, meSource);
		if (theRef == null) {
			return;
		}

		if (theRef.getEOpposite() != null) {
			// if it is a bidirectional reference, instead of adding source to target, set target to the opposite
			// reference.
			EReference oppositeRef = theRef.getEOpposite();

			Object object = meSource.eGet(oppositeRef);
			if (oppositeRef.isMany()) {
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(meTarget);
			} else {
				meSource.eSet(oppositeRef, meTarget);
			}

		} else {
			if (theRef.isMany()) {

				Object object = meTarget.eGet(theRef);
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(meSource);
			} else {
				meTarget.eSet(theRef, meSource);
			}

		}

	}

	private EReference getTargetRef(EObject targetContainer, ModelElement dropee) {

		List<EReference> refs = targetContainer.eClass().getEAllContainments();
		for (EReference ref : refs) {
			if (ref.isContainer()) {
				continue;
			}
			// checking for source reference type is based only on first element
			// of drag source. We suppose that elements with different types are
			// not allowed to be drag and dropped.
			if (ref.getEReferenceType().equals(dropee.eClass())
				|| ref.getEReferenceType().isSuperTypeOf(dropee.eClass())) {
				return ref;
			}
		}
		return null;
	}

	private void refreshCutAndPasteDecorator() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getDecoratorManager().update("org.unicase.cutpaste.decorator1");
			}
		});
	}

	private void clearClipboard() {
		clipboard.setContents(new StringSelection(""), null);
	}
}