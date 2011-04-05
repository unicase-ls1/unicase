/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.util;

import java.util.Calendar;

import org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.Annotation;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Helper class to log events.
 * 
 * @author helming
 */
public final class UnicaseEventUtil {

	private UnicaseEventUtil() {
		// nothing to do
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

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(annotationEvent);
				}
			}.run();

		}

	}

}
