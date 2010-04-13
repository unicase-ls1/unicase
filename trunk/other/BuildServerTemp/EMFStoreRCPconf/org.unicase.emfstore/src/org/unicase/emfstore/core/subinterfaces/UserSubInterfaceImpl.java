/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * This subinterfaces implements all user related functionality for the {@link org.unicase.emfstore.core.EmfStoreImpl}
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
