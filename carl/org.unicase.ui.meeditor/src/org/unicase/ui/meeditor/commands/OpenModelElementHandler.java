/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * @author Hodaie This handler handles openModelEelement command. This handler is to be executed indirectly using
 *         IHandlerService.executeCommand() method. The Command itself does not have any UI representation.
 */
public class OpenModelElementHandler extends AbstractHandler {

	private static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE = "featureToMark";
	private static final String MECONTEXT_EVALUATIONCONTEXT_VARIABLE = "meContext";

	/**
	 * . ({@inheritDoc}) We added this package and command to meeditor plug-in, we needed to open a model element from
	 * model.edit plug-in and to avoid circular references we had to execute this command indirectly using
	 * IHandlerServise.excuteCommand
	 */

	@SuppressWarnings("unchecked")
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// We get the required model element Through activeModelelemet
		// variable.
		// This variable is already set, in the method which calls to execute
		// this command.
		Object o = HandlerUtil.getVariableChecked(event, ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE);

		EObject me = (EObject) o;

		ModelElementContext context = (ModelElementContext) HandlerUtil.getVariableChecked(event,
			MECONTEXT_EVALUATIONCONTEXT_VARIABLE);

		List<EStructuralFeature> problemFeatures;

		try {
			problemFeatures = (List<EStructuralFeature>) HandlerUtil.getVariableChecked(event,
				FEATURE_TO_MARK_EVALUATIONCONTEXT_VARIABLE);
		} catch (ExecutionException executionException) {
			problemFeatures = null;
		}

		if (o != null) {
			MEEditorInput input;
			if (problemFeatures == null) {
				input = new MEEditorInput(me, context);
			} else {
				input = new MEEditorInput(me, context, problemFeatures);
			}
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input,
					"org.unicase.ui.meeditor", true);
			} catch (PartInitException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
