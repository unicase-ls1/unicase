/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.migration;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;


/**
 * Migrates models in the given URIs to the most recent version.
 * @author koegel
 *
 */
public interface EMFStoreMigrator {

	/**
	 * Migrate the models in the given URIs from the given source version to the most recent version.
	 * @param resources the URIs of the contents to migrate
	 * @param sourceModelReleaseNumber the source version number
	 * @param monitor a progress monitor
	 * 
	 * @throws EMFStoreMigrationException if the migration fails.
	 */
	void migrate(List<URI> resources, int sourceModelReleaseNumber, IProgressMonitor monitor) throws EMFStoreMigrationException;
}
