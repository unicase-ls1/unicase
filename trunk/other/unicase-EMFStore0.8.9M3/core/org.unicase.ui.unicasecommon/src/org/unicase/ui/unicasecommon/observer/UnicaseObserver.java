/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.observer;

import java.util.Calendar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.emfstorebridge.ECPObserver;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;

/**
 * UNICASE specific observer.
 * 
 * @author narayan
 */
public class UnicaseObserver extends ECPObserver implements StatusViewDropEventObserver {

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

			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(dndEvent);
				}
			}.run();

		}
	}

}
