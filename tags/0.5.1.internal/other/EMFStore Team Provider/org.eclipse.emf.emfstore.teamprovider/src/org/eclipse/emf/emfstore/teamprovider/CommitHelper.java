/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreTeamProviderConfigurationException;

/**
 * Helper class to find out (for the EMF Store).
 * 
 * @author Adrian Staudt
 */
public final class CommitHelper {

	private CommitHelper() {
	}

	/**
	 * Tells if one of the projects is managed by an EMF Store.
	 * 
	 * @param releatedProjects A set of eclipse workspace projects.
	 * @return True if one the projects is managed by an EMF Store, false otherwise.
	 */
	public static boolean isEMFStoreJDTInvolved(Set<IProject> releatedProjects) {
		boolean isEMFStoreJDTInvolved = false;

		for (IProject relatedProject : releatedProjects) {
			try {
				ConfigurationManager.getConfiguration(relatedProject);
				isEMFStoreJDTInvolved = true;
				break;

			} catch (NoEMFStoreTeamProviderConfigurationException e) {
				// ignore. Anyway this project is not involved.
			}
		}

		return isEMFStoreJDTInvolved;
	}

}
