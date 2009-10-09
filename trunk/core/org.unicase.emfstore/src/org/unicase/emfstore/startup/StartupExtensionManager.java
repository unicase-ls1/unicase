/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.startup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;

/**
 * This class calls the startup listeners, registered at the extension point.
 * 
 * @author wesendon
 */
public class StartupExtensionManager {

	/**
	 * Calls the startup listeners.
	 * 
	 * @param projects list of projects
	 */
	public void runOnProjects(EList<ProjectHistory> projects) {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.emfstore.startuplistener");

		// get all providers from the extension points
		for (IConfigurationElement e : config) {
			try {
				Object o = e.createExecutableExtension("class");
				if (o instanceof StartupListener) {
					((StartupListener) o).startedUp(projects);
				}
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
	}
}
