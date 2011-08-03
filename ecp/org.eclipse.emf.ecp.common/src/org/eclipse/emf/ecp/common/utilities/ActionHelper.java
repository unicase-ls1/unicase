/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.utilities;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.common.Activator;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.observer.ModelElementOpenObserver;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * @author Hodaie This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {
	// TODO: move constants
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
	private static final String FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE = "featureToMark";

	private ActionHelper() {

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
			"org.eclipse.emf.ecp.common.modelelementopener");
		ModelElementOpener bestCandidate = null;
		int bestValue = -1;
		String name = "";
		for (IConfigurationElement element : modelelementopener) {
			modelelementopener = null;
			try {
				ModelElementOpener modelelementOpener = (ModelElementOpener) element.createExecutableExtension("class");
				int value = modelelementOpener.canOpen(me);
				if (value > bestValue) {
					bestCandidate = modelelementOpener;
					bestValue = value;
					name = element.getAttribute("name");
				}
			} catch (CoreException e) {
				// TODO: ChainSaw logging done
				e.printStackTrace();
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
		ECPWorkspaceManager.getObserverBus().notify(ModelElementOpenObserver.class).onOpen(me, sourceView, name);
		// BEGIN SUPRESS CATCH EXCEPTION
		try {
			bestCandidate.openModelElement(me);
		} catch (AssertionFailedException e) {
			throw new AssertionFailedException(e.getMessage());
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
		ECPModelelementContext context) {
		if (me == null) {
			return;
		}
		if (problemFeature == null) {
			openModelElement(me, sourceView);
		}

		ECPWorkspaceManager.getObserverBus().notify(ModelElementOpenObserver.class)
			.onOpen(me, sourceView, "org.eclipse.emf.ecp.editor.MEEditor");
		openAndMarkMEWithMEEditor(me, problemFeature, context);
	}

	private static void openAndMarkMEWithMEEditor(EObject me, EStructuralFeature problemFeature,
		ECPModelelementContext context2) {
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

}
