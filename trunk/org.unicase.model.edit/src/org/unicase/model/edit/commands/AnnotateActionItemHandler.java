package org.unicase.model.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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

	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	private static final String NAVIGATOR_ID = "org.unicase.ui.navigator.viewer";
	private static final String MEEDITOR_EVALUATIONSERVICE_VARIABLE = "activeModelelement";
	private static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";

	private ExecutionEvent event;

	/**
	 * . {@inheritDoc} This method does whatever
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		this.event = event;

		// 1. extract the model element, to which the action item will be
		// attached
		// see #getModelElement()
		ModelElement me = getModelElement(event);
		// 2. create a sample action item
		ActionItem ai = createActionItem(me.getProject());
		// 3. attach it to model element
		attachActionItem(me, ai);
		// 4. open it for further editing
		openActionItem(ai);

		return null;
	}

	private ModelElement getModelElement(ExecutionEvent event) {

		ModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		// I think a better way was to have two different handlers for
		// for this two locations.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId.equals(MEEDITOR_ID)) {
			Object o = HandlerUtil.getVariable(event,
					MEEDITOR_EVALUATIONSERVICE_VARIABLE);
			me = (ModelElement) o;

		} else if (partId.equals(NAVIGATOR_ID)) {
			ISelection sel = HandlerUtil.getCurrentSelection(event);
			if (!(sel instanceof IStructuredSelection)) {
				return null;
			}

			IStructuredSelection ssel = (IStructuredSelection) sel;
			if (ssel.isEmpty()) {
				return null;
			}

			Object o = ssel.getFirstElement();
			if (!(o instanceof ModelElement)) {
				return null;
			}

			me = (ModelElement) o;
		}

		return me;
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
		// ZH: this method open the ai using and the editor
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
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * . ({@inheritDoc} )
	 */
	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

}
