/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import java.util.Calendar;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Helper class to log events.
 * 
 * @author helming
 */
public abstract class EventUtil {
	private EventUtil() {
		super();
	}

	/**
	 * Create Focus event.
	 * 
	 * @param viewId The ID of the focused view.
	 */
	public static void logFocusEvent(String viewId) {
		final PluginFocusEvent pluginFocusEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		pluginFocusEvent.setPluginId(viewId);
		pluginFocusEvent.setStartDate(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					activeProjectSpace.addEvent(pluginFocusEvent);
				}
			});

		}
	}

	/**
	 * @param viewID The ID of the current view.
	 * @param presentationID The ID of the new presentation.
	 */
	public static void logPresentationChangeEvent(String viewID, String presentationID) {
		final PresentationSwitchEvent presentationSwitchEvent = EventsFactory.eINSTANCE.createPresentationSwitchEvent();
		presentationSwitchEvent.setNewPresentation(presentationID);
		presentationSwitchEvent.setReadView(viewID);
		presentationSwitchEvent.setTimestamp(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					activeProjectSpace.addEvent(presentationSwitchEvent);
				}
			});

		}

	}

	/**
	 * @param me The annotated model element
	 * @param annotation the new annoation
	 */
	public static void logAnnotationEvent(ModelElement me, Annotation annotation) {
		final AnnotationEvent annotationEvent = EventsFactory.eINSTANCE.createAnnotationEvent();
		annotationEvent.setAnnotatedElement(me.getModelElementId());
		annotationEvent.setAnnotation(annotation.getModelElementId());
		annotationEvent.setTimestamp(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					activeProjectSpace.addEvent(annotationEvent);
				}
			});

		}

	}
}
