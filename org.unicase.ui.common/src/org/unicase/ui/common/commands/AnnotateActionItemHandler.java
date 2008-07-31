/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

/**
 * 
 * @author Hodaie This handlers handles annotateActionItem command. This command
 *         creates a new template action item, attaches it to the selected model
 *         element, and opens it.
 * 
 * 
 */

public class AnnotateActionItemHandler extends AbstractHandler {


	
	private static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";
	private static final String MEEDITOR_EVALUATIONSERVICE_VARIABLE = "activeModelelement";

	private ExecutionEvent event;

	/**
	 * . {@inheritDoc} This method does whatever
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		this.event = event;

		// 1. extract the model element, to which the action item will be
		// attached
		// see #getModelElement()
		ModelElement me = ActionHelper.getModelElement(event);
		// 2. create a sample action item
		ActionItem ai = createActionItem(me.getProject());
		// 3. attach it to model element
		attachActionItem(me, ai);
		// 4. open it for further editing
		openActionItem(ai);

		return null;
	}

	private ActionItem createActionItem(final Project project) {
		final ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
		ai.setName("NewActionItem");
		ai.setDescription("");
		ai.setDone(false);
		ai.setEstimate(5);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				project.addModelElement(ai);
			}
		});

		return ai;
	}

	private void attachActionItem(final ModelElement me, final ActionItem ai) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				me.getAnnotations().add(ai);
			}
		});

	}

	private void openActionItem(ActionItem ai) {
		// this method opens the ai using and the editor
		// in org.unicase.ui.meeditor plug-in.
		// We had to do this indirectly using a command in
		// meeditor plug-in, because we could not reference this
		// this plug-in in model.edit plug-in (circular reference)

		IHandlerService handlerService = (IHandlerService) HandlerUtil
				.getActivePart(this.event).getSite().getService(
						IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(MEEDITOR_EVALUATIONSERVICE_VARIABLE, ai);

		try {
			handlerService.executeCommand(MEEDITOR_OPENMODELELEMENT_COMMAND_ID,
					null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotEnabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotHandledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * . ({@inheritDoc} )
	 */
	@Override
	public boolean isEnabled() {
		// ZH Auto-generated method stub
		return true;
	}

	/**
	 * . ({@inheritDoc} )
	 */
	@Override
	public boolean isHandled() {
		// ZH Auto-generated method stub
		return true;
	}

}
