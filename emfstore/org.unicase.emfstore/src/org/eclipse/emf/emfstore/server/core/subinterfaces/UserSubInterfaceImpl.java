/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.core.subinterfaces;

import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.AbstractSubEmfstoreInterface;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;

/**
 * This subinterfaces implements all user related functionality for the {@link org.eclipse.emf.emfstore.server.core.EmfStoreImpl}
 * interface.
 * 
 * @author wesendon
 */
public class UserSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parent interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public UserSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		synchronized (getMonitor()) {
			ACUser requestingUser = getAuthorizationControl().resolveUser(sessionId);
			if (id == null) {
				return requestingUser;
			}
			ACUser user = getAuthorizationControl().resolveUser(id);
			if (requestingUser.getId().equals(user.getId())) {
				return user;
			}
			getAuthorizationControl().checkServerAdminAccess(sessionId);
			return user;
		}
	}
}
