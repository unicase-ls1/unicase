/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.team.core.RepositoryProvider;
import org.unicase.emfstore.jdt.exception.NoSuitableTeamSynchronizerException;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Registry hat organizes all TeamSynchronizer.
 * 
 * @author Adrian Staudt
 */
public final class TeamSynchronizerRegistry {

	private TeamSynchronizerRegistry() {
	}

	/**
	 * All available TeamSynchronizer are stored in this list.
	 */
	private static List<ITeamSynchronizer> teamSynchronizerList = new ArrayList<ITeamSynchronizer>();

	/**
	 * This static class explores all registered extension points that implements the TeamSynchronizer interface. Each
	 * TeamSynchronizer will be instantiated and kept for further request.
	 */
	static {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.emfstore.jdt.TeamSynchronizer"); //$NON-NLS-1$
		for (IConfigurationElement extension : rawExtensions) {
			try {
				Object executableExtension = extension.createExecutableExtension("class"); //$NON-NLS-1$
				if (executableExtension instanceof ITeamSynchronizer) {
					teamSynchronizerList.add((ITeamSynchronizer) executableExtension);
				}

			} catch (CoreException e) {
				ModelUtil.logException(e);
			}
		}
	}

	/**
	 * Returns the suitable TeamSychronizer for an eclipse workspace project. This is needed if a file within a project
	 * has to be synchronized against the EMF Store JDT configuration.
	 * 
	 * @param project An eclipse workspace project.
	 * @return A suitable TeamSychronizer.
	 * @throws NoSuitableTeamSynchronizerException Will be thrown if no suitable TeamSychronizer is can be found in the
	 *             registry.
	 */
	public static ITeamSynchronizer getTeamSynchronizer(IProject project) throws NoSuitableTeamSynchronizerException {
		RepositoryProvider provider = RepositoryProvider.getProvider(project);
		if (provider == null) {
			throw new NoSuitableTeamSynchronizerException();
		}

		for (ITeamSynchronizer teamSynchronizer : teamSynchronizerList) {
			if (provider.getID().equals(teamSynchronizer.getSupportedNatureID())) {
				return teamSynchronizer;
			}
		}
		throw new NoSuitableTeamSynchronizerException();
	}
}
