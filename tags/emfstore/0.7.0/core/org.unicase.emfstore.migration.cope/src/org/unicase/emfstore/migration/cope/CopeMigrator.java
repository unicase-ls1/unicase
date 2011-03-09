/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.migration.cope;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.unicase.emfstore.migration.EMFStoreMigrationException;
import org.unicase.emfstore.migration.EMFStoreMigrator;

import edu.tum.cs.cope.migration.execution.MigrationException;
import edu.tum.cs.cope.migration.execution.Migrator;
import edu.tum.cs.cope.migration.execution.MigratorRegistry;
import edu.tum.cs.cope.migration.execution.ReleaseUtil;

/**
 * EMFStoreMigrator implementation based on COPE.
 * @author koegel
 *
 */
public class CopeMigrator implements EMFStoreMigrator {


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.migration.EMFStoreMigrator#migrate(java.util.List, int)
	 */
	public void migrate(List<URI> resources, int sourceModelReleaseNumber, IProgressMonitor monitor) throws EMFStoreMigrationException {
		if (resources.size() < 1) {
			return;
		}
		String namespaceURI = ReleaseUtil.getNamespaceURI(resources.get(0));
		Migrator migrator = MigratorRegistry.getInstance().getMigrator(namespaceURI);
		if (migrator == null) {
			throw new EMFStoreMigrationException("Cannot migrate given URIs, no COPE migrations registered.");
		}

		// MK: build in progress monitor for migration here
		try {
			migrator.migrateAndSave(resources, sourceModelReleaseNumber, Integer.MAX_VALUE, monitor);
		} catch (MigrationException e) {
			throw new EMFStoreMigrationException("Cope Migration failed!", e);
		}
	}
}
