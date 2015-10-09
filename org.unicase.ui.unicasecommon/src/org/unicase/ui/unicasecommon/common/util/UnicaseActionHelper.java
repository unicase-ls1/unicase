/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.spi.core.InternalProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.emfstore.client.ESLocalProject;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;

/**
 * @author Hodaie This class contains some utility method for commands and
 *         handlers.
 */
public final class UnicaseActionHelper {

	private UnicaseActionHelper() {
		// nothing to do here
	}

	/**
	 * Extract the selected ModelElement in navigator or other StructuredViewer.
	 * This method uses the general ISelectionService of Workbench to extract
	 * the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an
	 *         IStructuredSelection
	 */
	public static UnicaseModelElement getSelectedModelElement() {
		Object obj = getSelection();
		if (obj instanceof UnicaseModelElement) {
			return (UnicaseModelElement) obj;
		} else if (obj instanceof DelegatingWrapperItemProvider) {
			if (((DelegatingWrapperItemProvider) obj).getValue() instanceof UnicaseModelElement) {
				return (UnicaseModelElement) ((DelegatingWrapperItemProvider) obj)
						.getValue();
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
		ISelectionService selectionService = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService();

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
	 * This extracts active model element. From MEEditor or from any view which
	 * is a selection provider. Deprecated use {@see UnicasActionHelper} in
	 * unicasecommon
	 * 
	 * @param event
	 *            the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static UnicaseModelElement getModelElement(ExecutionEvent event) {

		final String meeditorId = "org.eclipse.emf.ecp.editor";
		UnicaseModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(meeditorId)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);

			if (obj instanceof UnicaseModelElement) {
				me = (UnicaseModelElement) obj;
			}

		} else {
			// extract model element from current selection in navigator
			final ISelection selection = HandlerUtil
					.getActiveMenuSelection(event);
			final IStructuredSelection ssel = (IStructuredSelection) selection;
			EObject eObject = (EObject) ssel.getFirstElement();
			if (!(eObject instanceof UnicaseModelElement)) {
				return null;
			}

			me = (UnicaseModelElement) eObject;
		}

		return me;
	}

	public static EObject getEObject(ExecutionEvent event) {
		final String meeditorId = "org.eclipse.emf.ecp.editor";

		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(meeditorId)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);

			if (obj instanceof EObject) {
				return (EObject) obj;
			}

		}
		final ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection ssel = (IStructuredSelection) selection;
		return (EObject) ssel.getFirstElement();
	}

	/**
	 * This method opens the MEDiagram.
	 * 
	 * @param diagram
	 *            MEDiagram to open
	 * @param withMEEditor
	 *            If the diagram is open in the meeditor
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
		}

		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri, diagram.getName());

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input, id, true);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage()
					.showView("org.eclipse.ui.views.PropertySheet");
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error",
					e.getMessage(), e.getStatus());
		}
	}

	/**
	 * Opens a model element in the ECP model editor.
	 * <p>
	 * The second parameter is a string which should represent a unique id for
	 * the code that opens the model element (for example, the class name of the
	 * view opening the model element). It should stay the same for all calls of
	 * this method from the same code. It is only used for tracking purposes,
	 * i.e. to allow tracking which code opened which model element.
	 * </p>
	 * 
	 * @param me
	 *            the model element to open.
	 * @param identifier
	 *            a unique identifier for the code opening the model element
	 *            (see description above)
	 */
	public static void openModelElement(EObject me, String identifier) {
		final InternalProject project = (InternalProject) ECPUtil
				.getECPProjectManager().getProject(me);
		ECPHandlerHelper.openModelElement(me, project);
	}

	/**
	 * Gives a context for the given ME.
	 * 
	 * @param me
	 *            the model lement
	 * @return the context
	 */
	public static ESLocalProject getContext(EObject modelElement) {
		return (ESLocalProject) ECPUtil.getECPProjectManager().getProject(
				modelElement);
	}

	/**
	 * Constant for the modelelement to be opened.
	 */
	public static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String TOGGLE_ADD_COMMENT_VARIABLE = "toggleAddComment";
	private static final String MEEDITOR_OPENDISCUSSION_COMMAND_ID = "org.eclipse.emf.ecp.editor.openModelElementDiscussion";

	/**
	 * Opens the discussion page for the meeditor.
	 * 
	 * @param me
	 *            the modelElement
	 * @param toggleReply
	 *            if a reply widget should be automatically shown.
	 */
	public static void openDiscussion(EObject me, boolean toggleReply) {
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, me);
		if (toggleReply) {
			context.addVariable(TOGGLE_ADD_COMMENT_VARIABLE, "toggle");
		}

		try {
			handlerService.executeCommand(MEEDITOR_OPENDISCUSSION_COMMAND_ID,
					null);
		} catch (ExecutionException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotDefinedException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotEnabledException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotHandledException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		}

	}

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.ui.dashboardInput";
	private static final String DASHBOARD_COMMAND = "org.unicase.ui.dashboard.showDashboard";

	/**
	 * Opens the dashboard for the given project.
	 * 
	 * @param projectSpace
	 *            the project space.
	 */
	public static void openDashboard(ProjectSpace projectSpace) {
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(DASHBOARD_CONTEXT_VARIABLE, projectSpace);

		try {
			handlerService.executeCommand(DASHBOARD_COMMAND, null);
		} catch (ExecutionException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotDefinedException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotEnabledException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		} catch (NotHandledException e) {
			ModelUtil.logWarning(e.getMessage(), e);

		}

		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * Get the project space from the event.
	 * 
	 * @param event
	 *            the event
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
}
