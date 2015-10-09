/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.emfstore.client.ESUsersession;
import org.eclipse.emf.emfstore.client.observer.ESPostCreationObserver;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Change listener, that sets the creation date and, if available, the creator
 * attribute on UNICASE model elements.
 * 
 * @author emueller
 */
@SuppressWarnings("restriction")
public class UnicasePostModelElementCreationListener implements
		ESPostCreationObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.PostCreationObserver#onCreation(org.eclipse.emf.ecore.EObject)
	 */
	public void onCreation(EObject modelElement) {
		if (modelElement instanceof UnicaseModelElement) {
			UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;

			// if model element already has a creation date, leave it as is
			if (unicaseModelElement.getCreationDate() != null) {
				return;
			}

			unicaseModelElement.setCreationDate(new Date());
			ESUsersession userSession = null;
			EObject rootContainer = getRootContainer(modelElement);
			if (!(rootContainer instanceof Project)) {
				return;
			}
			ECPProject ecpProject = ECPUtil.getECPProjectManager().getProject(
					((ProjectSpace) rootContainer.eContainer())
							.getProjectName());
			try {
				userSession = OrgUnitHelper.getUserSession(ecpProject);
			} catch (UnkownProjectException e) {
				ModelUtil.logWarning(e.getMessage(), e);
			}
			if (userSession != null) {
				unicaseModelElement.setCreator(userSession.getUsername());
			}
		}
	}

	private EObject getRootContainer(EObject modelElement) {
		EObject eContainer = modelElement.eContainer();
		if (eContainer instanceof Project) {
			return eContainer;
		} else {
			return getRootContainer(eContainer);
		}
	}
}
