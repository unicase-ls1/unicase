/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.util;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {
		
	private ActionHelper() {

	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider.
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static EObject getModelElement(ExecutionEvent event) {

		EObject me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		String partId = HandlerUtil.getActivePartId(event);
		// TODO: ChainSaw change hard-coded string here
		if (partId != null && partId.equals("org.eclipse.emf.ecp.editor")) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);
			me = (EObject) obj;
		} else {
			// extract model element from current selection in navigator

			EObject eObject = getSelection(event);
			if (eObject == null) {
				return null;
			}

			me = eObject;
		}

		return me;
	}

	/**
	 * Extract the selected ModelElement from a viewer which is selection provider. This will be called from Handler
	 * classes, which pass the ExecutionEvent.
	 * 
	 * @param event ExecutionEvent to extract the selection from.
	 * @return the selected EObject or null.
	 */
	public static EObject getSelection(ExecutionEvent event) {
		EObject result = null;
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object obj = ssel.getFirstElement();
		if (obj instanceof EObject) {
			result = (EObject) obj;
		}

		return result;
	}

	/**
	 * Extract the selected Object in navigator or other StructuredViewer. This method uses the general
	 * ISelectionService of Workbench to extract the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an IStructuredSelection
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
	 * Extract the selected EObject in navigator or other StructuredViewer. This method uses the general
	 * ISelectionService of Workbench to extract the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an IStructuredSelection
	 */
	public static EObject getSelectedEObject() {
		Object obj = getSelection();
		if (obj instanceof EObject) {
			return (EObject) obj;
		} else {
			return null;
		}
	}

	/**
	 * Extract the selected ModelElement in navigator or other StructuredViewer. This method uses the general
	 * ISelectionService of Workbench to extract the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an IStructuredSelection
	 */
	public static EObject getSelectedModelelement() {
		Object obj = getSelection();
		if (obj instanceof EObject) {
			return (EObject) obj;
		} else if (obj instanceof DelegatingWrapperItemProvider) {
			if (((DelegatingWrapperItemProvider) obj).getValue() instanceof EObject) {
				return (EObject) ((DelegatingWrapperItemProvider) obj).getValue();
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	/**
	 * Extracts element from event.
	 * 
	 * @param event the event
	 * @param clazz class type of the object to extract 
	 * @param <T> the type of the object to extract
	 * @return the object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getEventElementByClass(ExecutionEvent event, Class<T> clazz) {

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel == null) {
			sel = HandlerUtil.getActiveMenuSelection(event);
		}
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection structuredSelection = (IStructuredSelection) sel;
		if (structuredSelection.isEmpty()) {
			return null;
		}

		Object selectedElement = structuredSelection.getFirstElement();
		if (!(clazz.isInstance(selectedElement))) {
			return null;
		}
		return (T) selectedElement;
	}

}
