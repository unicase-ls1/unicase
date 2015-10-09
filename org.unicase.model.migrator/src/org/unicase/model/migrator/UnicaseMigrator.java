package org.unicase.model.migrator;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfstore.internal.migration.EMFStoreMigrationException;
import org.eclipse.emf.emfstore.internal.migration.EMFStoreMigrator;

@SuppressWarnings("restriction")
public class UnicaseMigrator implements EMFStoreMigrator {

	public UnicaseMigrator() {
	}

	public boolean canHandle(List<URI> uris) {
		return false;
	}

	public boolean needsMigration(List<URI> uris) {
		return false;
	}

	public void migrate(List<URI> resources, IProgressMonitor monitor)
			throws EMFStoreMigrationException {

	}

}
