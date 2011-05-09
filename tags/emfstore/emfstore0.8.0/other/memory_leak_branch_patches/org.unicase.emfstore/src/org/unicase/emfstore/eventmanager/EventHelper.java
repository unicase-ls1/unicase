/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.eventmanager;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerFactory;

/**
 * Helper for creating events.
 * 
 * @author wesendon
 */
public final class EventHelper {

	private EventHelper() {
	}

	/**
	 * Creates a project updated event.
	 * 
	 * @param projectId project id.
	 * @param newVersion new version
	 * @return event
	 */
	public static ServerEvent createUpdatedProjectEvent(ProjectId projectId, PrimaryVersionSpec newVersion) {
		ProjectUpdatedEvent projectUpdatedEvent = ServerFactory.eINSTANCE.createProjectUpdatedEvent();
		projectUpdatedEvent.setProjectId((ProjectId) EcoreUtil.copy(projectId));
		projectUpdatedEvent.setNewVersion((PrimaryVersionSpec) EcoreUtil.copy(newVersion));
		projectUpdatedEvent.setTimestamp(new Date());
		return projectUpdatedEvent;
	}

}
