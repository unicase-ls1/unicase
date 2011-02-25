package org.unicase.emfstore.startup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;

public class StartupExtensionManager {

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
