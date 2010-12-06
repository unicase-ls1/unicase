/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigatormeeditorbridge;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.util.DialogHandler;

/**
 * Openeer for the meeditor.
 * 
 * @author helming
 */
public class ModelElementOpener implements org.unicase.ui.common.ModelElementOpener {
	/**
	 *Default constructor.
	 */
	public ModelElementOpener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	public int canOpen(EObject modelElement) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public void openModelElement(EObject modelElement) {
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ActionHelper.ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, modelElement);
		context.addVariable(ActionHelper.MECONTEXT_EVALUATIONCONTEXT_VARIABLE, new NavigatorModelelementContex(modelElement));

		try {
			handlerService.executeCommand(ActionHelper.MEEDITOR_OPENMODELELEMENT_COMMAND_ID, null);

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
