/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

import java.util.Calendar;

import org.unicase.emfstore.esmodel.versioning.events.DNDEvent;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

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

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(pluginFocusEvent);
				}
			}.run();

		}
	}

	/**
	 * @param viewID The ID of the current view.
	 * @param presentationID The ID of the new presentation.
	 */
	public static void logPresentationSwitchEvent(String viewID, String presentationID) {
		final PresentationSwitchEvent presentationSwitchEvent = EventsFactory.eINSTANCE.createPresentationSwitchEvent();
		presentationSwitchEvent.setNewPresentation(presentationID);
		presentationSwitchEvent.setReadView(viewID);
		presentationSwitchEvent.setTimestamp(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(presentationSwitchEvent);
				}
			}.run();

		}

	}

	/**
	 * Logs an drop event on the status view.
	 * 
	 * @param open the openen modelelement, the target
	 * @param dragged the dragged modelelemtn, the source
	 * @param source the source view.
	 * @param tab the tab
	 */
	public static void logStatusViewDropEvent(ModelElement open, ModelElement dragged, String source, String tab) {
		final DNDEvent dndEvent = EventsFactory.eINSTANCE.createDNDEvent();
		dndEvent.setDropTargetElement(open.getModelElementId());
		dndEvent.setDragSourceElement(dragged.getModelElementId());
		dndEvent.setTimestamp(Calendar.getInstance().getTime());
		dndEvent.setTargetView("org.unicase.StatusView." + tab);
		dndEvent.setSourceView(source);
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(dndEvent);
				}
			}.run();

		}
	}

}
