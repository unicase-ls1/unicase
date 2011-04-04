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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Utility class.
 * 
 * @author shterev
 * @author hodaie
 * @author denglerm
 */
public final class UiUtil {

	private UiUtil() {
		// do nothing
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
		if (partId != null && partId.equals(MEEDITOR_ID)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);
			me = (EObject) obj;
		} else {
			// extract model element from current selection in navigator

			EObject eObject = UiUtil.getSelection(event);
			if (eObject == null) {
				return null;
			}

			me = eObject;
		}

		return me;
	}

	/**
	 * . This shows a standard dialog with some given initial contents to select model elements.
	 * 
	 * @param shell shell
	 * @param initialContent initilaContents
	 * @param title title
	 * @param multiSelection if multiSelection is allowed
	 * @return The selected objects
	 */
	// ZH Why does this return Objects?:
	public static Object[] showMESelectionDialog(Shell shell, Collection<?> initialContent, String title,
		boolean multiSelection) {

		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(),
			new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		dlg.setElements(initialContent.toArray(new Object[initialContent.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(multiSelection);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		return result;
	}

	private static AdapterFactoryLabelProvider labelProvider;

	/**
	 * Get the name of a model element.
	 * 
	 * @param modelElement the model element
	 * @return the name for the model element
	 */
	public static String getNameForModelElement(EObject modelElement) {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}
		return labelProvider.getText(modelElement);
	}

	/**
	 * The ID of the meeditor.
	 */
	public static final String MEEDITOR_ID = "org.eclipse.emf.ecp.editor";
	/**
	 * Constant for the open model element command.
	 */
	public static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.eclipse.emf.ecp.editor.openModelElement";

	/**
	 * Constant for the modelelement context.
	 */
	public static final String MECONTEXT_EVALUATIONCONTEXT_VARIABLE = "meContext";
	
	/**
	 * Constant for the modelelement to be opened.
	 */
	public static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	
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
	 * Extract the selected ModelElements from a viewer which is selection provider. This will be called from Handler
	 * classes, which pass the ExecutionEvent.
	 * 
	 * @param event ExecutionEvent to extract the selection from.
	 * @return the selected EObjects set (may be an empty set).
	 */
	public static Set<EObject> getSelectedEObjects(ExecutionEvent event) {
		Set<EObject> result = Collections.emptySet();
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return result;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return result;
		}
		result = new HashSet<EObject>();
		for (Object object : ssel.toArray()) {
			if (object instanceof EObject) {
				result.add((EObject) object);
			}
		}
		return result;
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
