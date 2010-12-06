/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

import org.eclipse.emf.ecore.EObject;

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
		// TODO: ChainSaw logging / event
		// final PluginFocusEvent pluginFocusEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		// pluginFocusEvent.setPluginId(viewId);
		// pluginFocusEvent.setStartDate(Calendar.getInstance().getTime());
		// final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
		// .getActiveProjectSpace();
		// if (activeProjectSpace != null) {
		//
		// new UnicaseCommand() {
		// @Override
		// protected void doRun() {
		// activeProjectSpace.addEvent(pluginFocusEvent);
		// }
		// }.run();
		//
		// }
	}

	/**
	 * @param viewID The ID of the current view.
	 * @param presentationID The ID of the new presentation.
	 */
	public static void logPresentationSwitchEvent(String viewID, String presentationID) {
		// TODO: ChainSaw logging / event
		// final PresentationSwitchEvent presentationSwitchEvent =
		// EventsFactory.eINSTANCE.createPresentationSwitchEvent();
		// presentationSwitchEvent.setNewPresentation(presentationID);
		// presentationSwitchEvent.setReadView(viewID);
		// presentationSwitchEvent.setTimestamp(Calendar.getInstance().getTime());
		// final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
		// .getActiveProjectSpace();
		// if (activeProjectSpace != null) {
		//
		// new UnicaseCommand() {
		// @Override
		// protected void doRun() {
		// activeProjectSpace.addEvent(presentationSwitchEvent);
		// }
		// }.run();
		//
		// }

	}

	/**
	 * Logs an drop event on the status view.
	 * 
	 * @param open the openen modelelement, the target
	 * @param dragged the dragged modelelemtn, the source
	 * @param source the source view.
	 * @param tab the tab
	 */
	public static void logStatusViewDropEvent(EObject open, EObject dragged, String source, String tab) {
		// TODO: ChainSaw logging / event
		// final DNDEvent dndEvent = EventsFactory.eINSTANCE.createDNDEvent();
		// dndEvent.setDropTargetElement(ModelUtil.getProject(open).getModelElementId(open));
		// dndEvent.setDragSourceElement(ModelUtil.getProject(dragged).getModelElementId(dragged));
		// dndEvent.setTimestamp(Calendar.getInstance().getTime());
		// dndEvent.setTargetView("org.unicase.StatusView." + tab);
		// dndEvent.setSourceView(source);
		// final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
		// .getActiveProjectSpace();
		// if (activeProjectSpace != null) {
		//
		// new UnicaseCommand() {
		// @Override
		// protected void doRun() {
		// activeProjectSpace.addEvent(dndEvent);
		// }
		// }.run();
		//
		// }
	}

}