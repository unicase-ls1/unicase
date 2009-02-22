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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;

/**.
 * This is a generic handler to add different types of Annotations to a ModelElement
 * @author Hodaie
 *
 */
public class AddAnnotationHandler extends AbstractHandler {


	private static final String ADD_ACTIONITEM_COMMAND_ID = "org.unicase.ui.common.commands.annotateActionItem";
	private static final String ADD_ISSUE_COMMAND_ID = "org.unicase.ui.common.commands.annotateIssue";
	private static final String ADD_COMMENT_COMMAND_ID = "org.unicase.ui.common.commands.annotateComment";

	private ExecutionEvent event;

	/**
	 * . {@inheritDoc} 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		this.event = event;

		// 1. extract the model element, to which the Annotation will be
		// attached
		// see ActionHelper.getModelElement()
		ModelElement me = ActionHelper.getModelElement(event);
		// 2. extract command and create the appropriate annotation object
		Annotation annotation = createAnnotation(me.getProject());

		attachAnnotation(me, annotation);
		// 3. open annotation object for further editing
		openAnnotation(annotation);

		return null;
	}

	/**.
	 * This creates the appropriate Annotation based on selected menu command
	 * and adds it to Project
	 * @param project
	 * @return
	 */
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

	
	/**.
	 * This attaches the Annotation to ModelElement
	 * @param me
	 * @param annotation
	 */
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

	/**.
	 * This opens Annotation for further editing
	 * @param annotation
	 */
	private void openAnnotation(Annotation annotation) {
		
		ActionHelper.openModelElement(annotation);
		
	}

	

}
