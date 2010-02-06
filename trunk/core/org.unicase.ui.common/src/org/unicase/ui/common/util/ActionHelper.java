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
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.common.commands.AltKeyDoubleClickAction;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {

	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	private static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";
	private static final String MEEDITOR_OPENDISCUSSION_COMMAND_ID = "org.unicase.ui.meeditor.openModelElementDiscussion";
	private static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE = "featureToMark";
	private static final String TOGGLE_ADD_COMMENT_VARIABLE = "toggleAddComment";

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.ui.dashboardInput";
	private static final String DASHBOARD_COMMAND = "org.unicase.ui.dashboard.showDashboard";

	private ActionHelper() {

	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider.
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static ModelElement getModelElement(ExecutionEvent event) {

		ModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(MEEDITOR_ID)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(ModelElement.class);

			if (obj instanceof ModelElement) {
				me = (ModelElement) obj;
			}

		} else {
			// extract model element from current selection in navigator

			EObject eObject = getSelection(event);
			if (!(eObject instanceof ModelElement)) {
				return null;
			}

			me = (ModelElement) eObject;
		}

		return me;
	}



	/**
	 * This opens the model element.
	 * 
	 * @param me ModelElement to open
	 * @param sourceView the view that requested the open model element
	 */
	public static void openModelElement(final ModelElement me, final String sourceView) {
		if (me == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "The element was deleted",
			"The model element you are trying to open was deleted!");
			return;
		}
		IConfigurationElement[] modelelementopener = Platform.getExtensionRegistry().getConfigurationElementsFor(
		"org.unicase.ui.common.modelelementopener");
		ModelElementOpener bestCandidate=null;
		int bestValue=0;
		String name = "";
		for(IConfigurationElement element:modelelementopener ){
			try {
				ModelElementOpener modelelementOpener = (ModelElementOpener) element.createExecutableExtension("class");
				int value=modelelementOpener.canOpen(me);
				if(value>bestValue){
					bestCandidate=modelelementOpener;
					bestValue=value;
					name=element.getAttribute("name");
				}
			} catch (CoreException e) {
				WorkspaceUtil.logException(e.getMessage(), e);	
			}
		}
		if(bestCandidate==null){
			logEvent(me, sourceView, "org.unicase.ui.meeditor.MEEditor");
			openMEwithMEEditor(me);
			return;
		}
		logEvent(me, sourceView, name);
		bestCandidate.openModelElement(me);
		
	}

	private static void logEvent(final ModelElement me, final String sourceView, final String readView) {
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				
				WorkspaceUtil.logReadEvent(projectSpace, me.getModelElementId(), sourceView, readView);
			}
		}.run();

		
	}

	/**
	 * Opens the dashboard for the currently selected projectspace.
	 */
	public static void openDashboard() {
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		openDashboard(projectSpace);
	}

	/**
	 * Opens the dashboard for the given project.
	 * 
	 * @param projectSpace the project space.
	 */
	public static void openDashboard(ProjectSpace projectSpace) {
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(DASHBOARD_CONTEXT_VARIABLE, projectSpace);

		try {
			handlerService.executeCommand(DASHBOARD_COMMAND, null);

		} catch (ExecutionException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotDefinedException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotEnabledException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotHandledException e) {
			DialogHandler.showExceptionDialog(e);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			DialogHandler.showExceptionDialog(e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * @param me model element
	 */
	private static void openMEwithMEEditor(ModelElement me) {
		// this method opens a model element indirectly using IEvaluationContext
		// variable
		// the variable is here set to ME which must be opened,
		// and this ME is then read in MEEditor form this variable
		// after setting the Variable, the open command in MEEditor is invoked
		// using
		// HandlerService
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, me);

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
	 * This opens the model element and marks the feature as having a problem (error, warning, etc.).
	 * 
	 * @param me ModelElement to open
	 * @param problemFeature the feature to be marked as having a problem
	 * @param sourceView the view that requested the open model element
	 */
	public static void openModelElement(final ModelElement me, EStructuralFeature problemFeature,
		final String sourceView) {
		if (me == null) {
			return;
		}
		if (problemFeature == null) {
			openModelElement(me, sourceView);
		}

		logEvent(me, sourceView,"org.unicase.ui.meeditor.MEEditor");
		openAndMarkMEWithMEEditor(me, problemFeature);
	}

	private static void openAndMarkMEWithMEEditor(ModelElement me, EStructuralFeature problemFeature) {
		// this method works as the one above but in addition marks a feature as having a problem

		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, me);
		context.addVariable(FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE, problemFeature);

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
	 */
	public static ModelElement getSelectedModelElement() {
		Object obj = getSelection();
		if (obj instanceof ModelElement) {
			return (ModelElement) obj;
		} else if (obj instanceof DelegatingWrapperItemProvider) {
			if (((DelegatingWrapperItemProvider) obj).getValue() instanceof ModelElement) {
				return (ModelElement) ((DelegatingWrapperItemProvider) obj).getValue();
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	/**
	 * @param viewer ColumnViewer .
	 * @param classname String sorceView .
	 * @return AltKeyDoubleClickAction .
	 */
	public static AltKeyDoubleClickAction createKeyHookDCAction(ColumnViewer viewer, String classname) {
		return new AltKeyDoubleClickAction(viewer, classname);
	}

	/**
	 * Get the project space from the event.
	 * 
	 * @param event the event
	 * @return the project space
	 */
	public static ProjectSpace getProjectSpace(ExecutionEvent event) {

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
		if (!(selectedElement instanceof ProjectSpace)) {
			return null;
		}
		return (ProjectSpace) selectedElement;
	}

	/**
	 * Opens the discussion page for the meeditor.
	 * 
	 * @param me the modelElement
	 * @param toggleReply if a reply widget should be automatically shown.
	 */
	public static void openDiscussion(ModelElement me, boolean toggleReply) {
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, me);
		if (toggleReply) {
			context.addVariable(TOGGLE_ADD_COMMENT_VARIABLE, "toggle");
		}

		try {
			handlerService.executeCommand(MEEDITOR_OPENDISCUSSION_COMMAND_ID, null);

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
	 * Open a model element in the meeditor.
	 * 
	 * @param me the element to open
	 * @param sourceView the view that send the open request (use a unique id here).
	 */
	public static void openMEwithMEEditor(ModelElement me, String sourceView) {
		logEvent(me, sourceView, "org.unicase.ui.meeditor.MEEditor");
		openMEwithMEEditor(me);
		
	}

}
