/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.eventmanager;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ProjectUpdatedEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerFactory;

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
