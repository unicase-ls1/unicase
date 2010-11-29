/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Helper Class for the UNICASE Client.
 * 
 * @author helming
 */
public final class UnicaseActionHelper {

	private UnicaseActionHelper() {
	};

	/**
	 * Opens a model element in ECP with a Context.
	 * 
	 * @param me modelelement to open.
	 * @param sourceView the source view
	 */
	public static void openModelElement(EObject me, String sourceView) {
		ActionHelper.openModelElement(me, sourceView, getContext(me));

	}

	/**
	 * Gives a context for the given ME.
	 * 
	 * @param me the model lement
	 * @return the context
	 */
	public static ModelElementContext getContext(EObject me) {
		return new EMFStoreModelelementContext(me);
	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider.
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 */
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
	 * Constant for the modelelement to be opened.
	 */
	public static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String TOGGLE_ADD_COMMENT_VARIABLE = "toggleAddComment";
	private static final String MEEDITOR_OPENDISCUSSION_COMMAND_ID = "org.unicase.ui.meeditor.openModelElementDiscussion";

	/**
	 * Opens the discussion page for the meeditor.
	 * 
	 * @param me the modelElement
	 * @param toggleReply if a reply widget should be automatically shown.
	 */
	public static void openDiscussion(EObject me, boolean toggleReply) {
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

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.ui.dashboardInput";
	private static final String DASHBOARD_COMMAND = "org.unicase.ui.dashboard.showDashboard";

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
			// DialogHandler.showExceptionDialog(e);
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

}
