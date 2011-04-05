/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.migration;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Controller for migrating models in EMFStore. Manages all registered migrators.
 * 
 * @author koegel
 */
public final class EMFStoreMigratorUtil {

	private static final String MIGRATOR_CLASS = "migratorClass";
	private static EMFStoreMigrator migrator;

	
	private EMFStoreMigratorUtil() {
		//private constructor of utility class
	}
	
	/**
	 * Check if any migrators are registered.
	 * @return true, if migrators are available.
	 */
	public static boolean isMigratorAvailable() { 
		if (migrator!=null) {
			return true;
		}
		try {
			migrator = loadMigrator();
		} catch (EMFStoreMigrationException e) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieve a migrator. Will default to the first loadable migrator if multiple migrators are available.
	 * @return the migrator
	 * @throws EMFStoreMigrationException if no migrators are available or can be loaded.
	 */
	public static EMFStoreMigrator getEMFStoreMigrator() throws EMFStoreMigrationException {

		if (migrator!=null) {
			return migrator;
		}
		return loadMigrator();
	}

	private static EMFStoreMigrator loadMigrator() throws EMFStoreMigrationException {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.emfstore.migrator");
		if (rawExtensions.length > 1) {
			ModelUtil
				.logWarning("Multiple EMFStore Migrators are registered. EMFStore will default to first loadable migrator.");
		}
		for (IConfigurationElement extension : rawExtensions) {
			try {
				Object executableExtension = extension.createExecutableExtension(MIGRATOR_CLASS);
				if (executableExtension instanceof EMFStoreMigrator) {
					migrator = (EMFStoreMigrator) executableExtension;
					return migrator;
				}

			} catch (CoreException e) {
				String message = "Error while instantiating EMFStore Migrator: "
					+ extension.getAttribute(MIGRATOR_CLASS);
				ModelUtil.logWarning(message, e);
			}
		}
		throw new EMFStoreMigrationException("No EMFStore migrator registered.");
	}

}
