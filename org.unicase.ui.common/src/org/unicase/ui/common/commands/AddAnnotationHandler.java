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
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.util.RationaleAdapterFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

public class AddAnnotationHandler extends AbstractHandler {

	private static final String MEEDITOR_OPENMODELELEMENT_COMMAND_ID = "org.unicase.ui.meeditor.openModelElement";
	private static final String MEEDITOR_EVALUATIONSERVICE_VARIABLE = "activeModelelement";
	private static final String ADD_ACTIONITEM_COMMAND_ID = "org.unicase.ui.common.commands.annotateActionItem";
	private static final String ADD_ISSUE_COMMAND_ID = "org.unicase.ui.common.commands.annotateIssue";
	private static final String ADD_COMMENT_COMMAND_ID = "org.unicase.ui.common.commands.annotateComment";

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
		// 2. extract command and create the appropriate annotation object
		Annotation annotation = createAnnotation(me.getProject());

		attachAnnotation(me, annotation);
		// 3. open annotation object for further editing
		openAnnotation(annotation);

		return null;
	}

	private Annotation createAnnotation(final Project project) {
		final Annotation result;
		if (event.getCommand().getId().equals(ADD_ACTIONITEM_COMMAND_ID)) {
			result = (Annotation) TaskFactory.eINSTANCE.createActionItem();
			result.setName("New Action Item");
			result.setDescription("");

		} else if (event.getCommand().getId().equals(ADD_ISSUE_COMMAND_ID)) {
			result = (Annotation) RationaleFactory.eINSTANCE.createIssue();
			result.setName("New Issue");
			result.setDescription("");
		} else if (event.getCommand().getId().equals(ADD_COMMENT_COMMAND_ID)) {
			result = (Annotation) RationaleFactory.eINSTANCE.createComment();
			result.setName("New Comment");
			result.setDescription("");
		} else {
			result = null;
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				project.addModelElement(result);
			}
		});

		return result;
	}

	private void attachAnnotation(final ModelElement me,
			final Annotation annotation) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				me.getAnnotations().add(annotation);
			}
		});

	}

	private void openAnnotation(Annotation annotation) {
		// this method opens the ai using and the editor
		// in org.unicase.ui.meeditor plug-in.
		// We had to do this indirectly using a command in
		// meeditor plug-in, because we could not reference this
		// this plug-in in model.edit plug-in (circular reference)

		IHandlerService handlerService = (IHandlerService) HandlerUtil
				.getActivePart(this.event).getSite().getService(
						IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(MEEDITOR_EVALUATIONSERVICE_VARIABLE, annotation);

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
