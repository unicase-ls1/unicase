/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.esmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;

/**
 * Helper class for emf store model related tasks.
 * 
 * @author koegel
 */
public final class EsModelUtil {

	/**
	 * Private constructor.
	 */
	private EsModelUtil() {
		// do nothing
	}

	/**
	 * Clone a primary version specifier.
	 * 
	 * @param spec the specifier
	 * @return a clone
	 */
	public static PrimaryVersionSpec clone(PrimaryVersionSpec spec) {
		return (PrimaryVersionSpec) EcoreUtil.copy(spec);
	}

	/**
	 * Clone a project identifier.
	 * 
	 * @param projectId the project id
	 * @return a clone
	 */
	public static ProjectId clone(ProjectId projectId) {
		EObject copy = EcoreUtil.copy(projectId);
		return (ProjectId) copy;
	}
}
