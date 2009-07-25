/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.core.subinterfaces;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * The {@link ProjectPropertiesSubInterfaceImpl} class is responsible for handling modifications of project properties.
 * 
 * @author pfeifferc
 */
public class ProjectPropertiesSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * @param parentInterface the parent interface
	 * @throws FatalEmfStoreException if any fatal error occurs
	 */
	public ProjectPropertiesSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * Adds a property to the specified {@link ACUser}. client-side been changed
	 * 
	 * @param changedProperty the property that has been changed
	 * @param recUser the specified {@link ACUser}
	 * @param projectId the specified {@link ProjectId}
	 */
	public void setProperties(OrgUnitProperty changedProperty, ACUser recUser, ProjectId projectId) {
		EList<ACUser> users = getServerSpace().getUsers();
		ACUser user = users.get(users.lastIndexOf(recUser));
		for (OrgUnitProperty property : user.getProperties()) {
			if (property.getName().equals(changedProperty)) {
				property.setValue(changedProperty.getValue());
				return;
			}
			user.getProperties().add(changedProperty);
		}
	}
}
