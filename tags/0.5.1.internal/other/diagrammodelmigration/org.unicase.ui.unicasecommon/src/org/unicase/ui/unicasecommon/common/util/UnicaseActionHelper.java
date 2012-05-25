/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.util;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.model.diagram.WorkItemDiagram;
import org.unicase.ui.common.util.ActionHelper;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class UnicaseActionHelper {

	private UnicaseActionHelper() {
		// nothing to do here
	}

	/**
	 * Extract the selected ModelElement in navigator or other StructuredViewer. This method uses the general
	 * ISelectionService of Workbench to extract the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an IStructuredSelection
	 */
	public static UnicaseModelElement getSelectedModelElement() {
		Object obj = getSelection();
		if (obj instanceof UnicaseModelElement) {
			return (UnicaseModelElement) obj;
		} else if (obj instanceof DelegatingWrapperItemProvider) {
			if (((DelegatingWrapperItemProvider) obj).getValue() instanceof UnicaseModelElement) {
				return (UnicaseModelElement) ((DelegatingWrapperItemProvider) obj).getValue();
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	/**
	 * @return the selected object
	 */
	public static Object getSelection() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection sel = selectionService.getSelection();
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		return o;
	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider. Deprecated use
	 * {@see UnicasActionHelper} in unicasecommon
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 * @deprecated
	 */
	@Deprecated
	public static UnicaseModelElement getModelElement(ExecutionEvent event) {

		// TODO: redundant, see ActionHelper
		final String meeditorId = "org.unicase.ui.meeditor";
		UnicaseModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(meeditorId)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);

			if (obj instanceof UnicaseModelElement) {
				me = (UnicaseModelElement) obj;
			}

		} else {
			// extract model element from current selection in navigator

			EObject eObject = ActionHelper.getSelection(event);
			if (!(eObject instanceof UnicaseModelElement)) {
				return null;
			}

			me = (UnicaseModelElement) eObject;
		}

		return me;
	}

	/**
	 * This method opens the MEDiagram.
	 * 
	 * @param diagram MEDiagram to open
	 * @param withMEEditor If the diagram is open in the meeditor
	 * @deprecated
	 */
	@Deprecated
	public static void openMEDiagram(MEDiagram diagram, boolean withMEEditor) {

		String id = null;
		if (diagram instanceof ClassDiagram) {
			id = "org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorID";
		} else if (diagram instanceof UseCaseDiagram) {
			id = "org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorID";
		} else if (diagram instanceof ComponentDiagram) {
			id = "org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorID";
		} else if (diagram instanceof StateDiagram) {
			id = "org.unicase.ui.diagram.stateDiagram.part.ModelDiagramEditorID";
		} else if (diagram instanceof ActivityDiagram) {
			id = "org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorID";
		} else if (diagram instanceof WorkItemDiagram) {
			id = "org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorID";
		}

		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri, diagram.getName());

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
				"org.eclipse.ui.views.PropertySheet");
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e
				.getMessage(), e.getStatus());
		}
	}
}
