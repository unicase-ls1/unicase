/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.emfstorebridge;

import java.util.Calendar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.observer.FocusEventObserver;
import org.eclipse.emf.ecp.common.observer.ModelElementOpenObserver;
import org.eclipse.emf.ecp.common.observer.PresentationSwitchObserver;
import org.eclipse.emf.ecp.common.observer.StatusViewDropEventObserver;
import org.eclipse.emf.ecp.common.observer.TraceObserver;
import org.eclipse.emf.ecp.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.model.PostECPWorkspaceInitiator;
import org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.PresentationSwitchEvent;

/**
 * @author emueller
 * @author wesendon
 */
// TODO: ChainSaw
public class ECPObserver implements PostECPWorkspaceInitiator, TraceObserver, ModelElementOpenObserver,
	FocusEventObserver, PresentationSwitchObserver, StatusViewDropEventObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.PostECPWorkspaceInitiator#workspaceInitComplete(org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace)
	 */
	public void workspaceInitComplete(ECPWorkspace currentWorkspace) {
		ECPWorkspaceManager.getObserverBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.common.observer.ModelElementOpenObserver#onOpen(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public void onOpen(EObject opened, String sourceView, String openView) {
		final String source = sourceView;
		final String readView = openView;
		final EObject me = opened;
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project p = ModelUtil.getProject(me);
				WorkspaceUtil
					.logReadEvent(projectSpace, (p == null ? null : p.getModelElementId(me)), source, readView);
			}
		}.run();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.common.observer.TraceObserver#onTrace(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String)
	 */
	public void onTrace(EObject source, EObject target, String feature, String view) {
		if (source instanceof EObject && target instanceof EObject) {
			final EObject targetModelElement = target;
			final EObject sourceModelElement = source;
			final String featureName = feature;

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
					Project p1 = ModelUtil.getProject(sourceModelElement);
					Project p2 = ModelUtil.getProject(targetModelElement);
					WorkspaceUtil.logTraceEvent(activeProjectSpace, p1 == null ? null : p1
						.getModelElementId(sourceModelElement), p2 == null ? null : p2
						.getModelElementId(targetModelElement), featureName);
				}
			}.run();
		}

	}

	public void onFocusEvent(String viewId) {
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

	public void onPresentationSwitchEvent(String viewID, String presentationID) {
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

	public void onStatusViewDropEvent(EObject open, EObject dragged, String source, String tab) {
		final DNDEvent dndEvent = EventsFactory.eINSTANCE.createDNDEvent();
		dndEvent.setDropTargetElement(ModelUtil.getProject(open).getModelElementId(open));
		dndEvent.setDragSourceElement(ModelUtil.getProject(dragged).getModelElementId(dragged));
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
