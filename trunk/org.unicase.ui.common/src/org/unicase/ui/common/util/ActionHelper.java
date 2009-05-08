/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import java.util.Date;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.commands.AltKeyDoubleClickAction;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {

	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	private static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";
	private static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE = "featureToMark";
	
	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.workspace.edit.dashboardInput";
	private static final String DASHBOARD_COMMAND = "org.unicase.workspace.edit.showDashboard";

	private ActionHelper() {

	}

	/**
	 * This extracts active model element. From MEEditor or from Navigator
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
		if (partId.equals(MEEDITOR_ID)) {
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
	 * MUST BE WRAPPED IN A RECORDING COMMAND! This method creates a new model element using:
	 * 
	 * @param factory the factory
	 * @param clazz the element class
	 * @return the new element
	 */
	@Deprecated
	public static EObject createModelElement(EFactory factory, EClass clazz) {
		EObject obj = factory.create(clazz);
		ModelElement me = (ModelElement) obj;
		final StringBuffer creator = new StringBuffer();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Usersession usersession = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
					.getUsersession();
				if (usersession != null) {
					creator.append(usersession.getACUser().getName());
				}
			}
		});
		me.setCreator(creator.toString());
		me.setCreationDate(new Date());
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
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "The element was deleted", "The model element you are trying to open was deleted!");
			return;
		}

		boolean openWithMeDiagram = false;
		if (me instanceof MEDiagram) {
			openWithMeDiagram = true;
		}
		final boolean isDiagram = openWithMeDiagram;
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getActiveProjectSpace();
				String readView;
				if (isDiagram) {
					readView = "org.unicase.ui.MEDiagramEditor";
				} else {
					readView = "org.unicase.ui.meeditor.MEEditor";
				}
				WorkspaceUtil.logReadEvent(activeProjectSpace, me.getModelElementId(), sourceView, readView);
			}
		});

		if (openWithMeDiagram) {
			openMEDiagram((MEDiagram) me, false);
		} else {
			openMEwithMEEditor(me);
		}

	}
	
	
	/**
	 * Opens the dashboard for the currently selected projectspace.
	 */
	public static void openDashboard(){
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		openDashboard(projectSpace);
	}
	
	/**
	 * Opens the dashboard for the given project.
	 * @param projectSpace the project space.
	 */
	public static void openDashboard(ProjectSpace projectSpace){
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
		}
	}

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

		// TODO: at some point add validation markings in diagrams
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getActiveProjectSpace();
				String readView = "org.unicase.ui.meeditor.MEEditor";
				WorkspaceUtil.logReadEvent(activeProjectSpace, me.getModelElementId(), sourceView, readView);
			}
		});

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
	 * . This opens the MEDiagram.
	 * 
	 * @param diagram MEDiagram to open
	 * @param withMEEditor If the diagram is open in the meeditor
	 */
	public static void openMEDiagram(MEDiagram diagram, boolean withMEEditor) {
		if (withMEEditor) {
			openMEwithMEEditor(diagram);
			return;
		}

		String id = null;
		if (diagram.getType().equals(DiagramType.CLASS_DIAGRAM)) {
			id = "org.unicase.model.classDiagram.part.ModelDiagramEditorID";
		} else if (diagram.getType().equals(DiagramType.USECASE_DIAGRAM)) {
			id = "org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorID";
		} else if (diagram.getType().equals(DiagramType.COMPONENT_DIAGRAM)) {
			id = "org.unicase.ui.componentDiagram.part.ModelDiagramEditorID";
		} else if (diagram.getType().equals(DiagramType.STATE_DIAGRAM)) {
			id = "org.unicase.ui.stateDiagram.part.ModelDiagramEditorID";
		} else if (diagram.getType().equals(DiagramType.ACTIVITY_DIAGRAM)) {
			id = "org.unicase.ui.activityDiagram.part.ModelDiagramEditorID";
		}		

		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri, diagram.getName());
	
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.views.PropertySheet");
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e
				.getMessage(), e.getStatus());
		}		
	}

	/**
	 * . Extract the selected ModelElement in navigator or other StructuredViewer This will be called from Handler
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
	 * . Extract the selected Object in navigator or other StructuredViewer. This method uses the general
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
	 * . Extract the selected EObject in navigator or other StructuredViewer. This method uses the general
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
	 * . Extract the selected ModelElement in navigator or other StructuredViewer. This method uses the general
	 * ISelectionService of Workbench to extract the selection. Beware that the part providing the selection should have
	 * registered its SelectionProvider.
	 * 
	 * @return the selected Object or null if selection is not an IStructuredSelection
	 */
	public static ModelElement getSelectedModelElement() {
		Object obj = getSelection();
		if (obj instanceof ModelElement) {
			return (ModelElement) obj;
		} else if(obj instanceof DelegatingWrapperItemProvider) {
			if( ((DelegatingWrapperItemProvider)obj).getValue() instanceof ModelElement){
				return (ModelElement) ((DelegatingWrapperItemProvider)obj).getValue();
			}else{
				return null;
			}
			
		}else{
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

}
