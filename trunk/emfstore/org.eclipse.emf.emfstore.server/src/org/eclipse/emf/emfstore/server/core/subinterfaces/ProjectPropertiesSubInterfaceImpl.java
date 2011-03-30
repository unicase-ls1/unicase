/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.eclipse.emf.emfstore.server.core.subinterfaces;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.AbstractSubEmfstoreInterface;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;

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
	 * Adds a property to the specified {@link ACUser}.
	 * 
	 * @param changedProperty the property that has been changed
	 * @param recUser the specified {@link ACUser}
	 * @param projectId the specified {@link ProjectId}
	 * @throws EmfStoreException if any error occurs setting the properties
	 */
	public void setProperty(OrgUnitProperty changedProperty, ACUser recUser, ProjectId projectId)
		throws EmfStoreException {
		EList<ACUser> users = getServerSpace().getUsers();
		ACUser user = null;
		for (ACUser serverUser : users) {
			if (serverUser.getIdentifier().equals(recUser.getIdentifier())) {
				user = serverUser;
				break;
			}
		}
		if (user == null) {
			throw new EmfStoreException("The user does not exist on the server. Cannot set the property.");
		}
		for (OrgUnitProperty property : user.getProperties()) {
			if (property.getName().equals(changedProperty.getName()) && isProjectEqual(property, changedProperty)) {
				property.setValue(changedProperty.getValue());
				save();
				return;
			}
		}
		user.getProperties().add(changedProperty);
		save();
	}

	private boolean isProjectEqual(OrgUnitProperty property, OrgUnitProperty changedProperty) {
		if ((property.getProject() == null) && (changedProperty.getProject() == null)) {
			return true;
		}
		if (property.getProject() == null) {
			return false;
		}
		if (changedProperty.getProject() == null) {
			return false;
		}
		return (property.getProject().equals(changedProperty.getProject()));
	}

	private void save() throws EmfStoreException {
		try {
			getServerSpace().save();
		} catch (IOException e) {
			throw new EmfStoreException("Cannot set the property on the server.");
		}
	}
}
