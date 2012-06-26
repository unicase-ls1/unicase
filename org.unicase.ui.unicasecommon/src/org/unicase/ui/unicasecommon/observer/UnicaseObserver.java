/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.observer;


/**
 * UNICASE specific observer.
 * 
 * @author narayan
 */
// FIXME: Remove this?
public class UnicaseObserver {// extends ECPObserver implements StatusViewDropEventObserver {
	/**
	 * . ({@inheritDoc})
	 */
	// public void onStatusViewDropEvent(EObject open, EObject dragged, String source, String tab) {
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
	// new EMFStoreCommand() {
	// @Override
	// protected void doRun() {
	// activeProjectSpace.addEvent(dndEvent);
	// }
	// }.run();
	//
	// }
	// }

}
