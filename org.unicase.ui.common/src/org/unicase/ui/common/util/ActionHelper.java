/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.ui.common.Activator;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.common.NotificationManager;
import org.unicase.ui.util.DialogHandler;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {
	// TODO: move constants
	/**
	 * The ID of the meeditor.
	 */
	public static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	/**
	 * Constant for the open model element command.
	 */
	public static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";

	/**
	 * Constant for the modelelement context.
	 */
	public static final String MECONTEXT_EVALUATIONCONTEXT_VARIABLE = "meContext";

	/**
	 * Constant for the modelelement to be opened.
	 */
	public static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE = "featureToMark";

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
		if (partId != null && partId.equals(MEEDITOR_ID)) {
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
	 * Note: this method is deprecated. use openModelElement(EObject, String) insetad. you do not have to pass a context
	 * anymore.
	 * 
	 * @param me ModelElement to open
	 * @param sourceView the view that requested the open model element
	 * @param context the context of the model element
	 * @deprecated
	 */
	@Deprecated
	public static void openModelElement(final EObject me, final String sourceView, ModelElementContext context) {
		openModelElement(me, sourceView);
	}

	/**
	 * This opens the model element.
	 * 
	 * @param me ModelElement to open
	 * @param sourceView the view that requested the open model element
	 */
	public static void openModelElement(final EObject me, final String sourceView) {
		if (me == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "The element was deleted",
				"The model element you are trying to open was deleted!");
			return;
		}
		IConfigurationElement[] modelelementopener = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.modelelementopener");
		ModelElementOpener bestCandidate = null;
		int bestValue = -1;
		String name = "";
		for (IConfigurationElement element : modelelementopener) {
			try {
				ModelElementOpener modelelementOpener = (ModelElementOpener) element.createExecutableExtension("class");
				int value = modelelementOpener.canOpen(me);
				if (value > bestValue) {
					bestCandidate = modelelementOpener;
					bestValue = value;
					name = element.getAttribute("name");
				}
			} catch (CoreException e) {
				// TODO: ChainSaw logging
				// WorkspaceUtil.logException(e.getMessage(), e);
			}
		}
		NotificationManager.getInstance().onOpen(me, sourceView, name);
		// BEGIN SUPRESS CATCH EXCEPTION
		try {
			bestCandidate.openModelElement(me);
		} catch (RuntimeException e) {
			Activator.getDefault().logException(e);
		}
		// END SUPRESS CATCH EXCEPTION

	}

	/**
	 * This opens the model element and marks the feature as having a problem (error, warning, etc.).
	 * 
	 * @param me ModelElement to open
	 * @param problemFeature the feature to be marked as having a problem
	 * @param sourceView the view that requested the open model element
	 * @param context the context of the model element
	 */
	public static void openModelElement(final EObject me, EStructuralFeature problemFeature, final String sourceView,
		ModelElementContext context) {
		if (me == null) {
			return;
		}
		if (problemFeature == null) {
			openModelElement(me, sourceView, context);
		}

		NotificationManager.getInstance().onOpen(me, sourceView, "org.unicase.ui.meeditor.MEEditor");
		openAndMarkMEWithMEEditor(me, problemFeature, context);
	}

	private static void openAndMarkMEWithMEEditor(EObject me, EStructuralFeature problemFeature,
		ModelElementContext context2) {
		// this method works as the one above but in addition marks a feature as having a problem

		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, me);
		context.addVariable(FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE, problemFeature);
		context.addVariable(MECONTEXT_EVALUATIONCONTEXT_VARIABLE, context2);

		try {
			handlerService.executeCommand(MEEDITOR_OPENMODELELEMENT_COMMAND_ID, null);

		} catch (ExecutionException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotDefinedException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotEnabledException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotHandledException e) {
			DialogHandler.showExceptionDialog(e);
		}
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
	 * @deprecated use unicase action helper or getSelectedModelelement instead
	 */
	@Deprecated
	public static EObject getSelectedModelElement() {
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
}
