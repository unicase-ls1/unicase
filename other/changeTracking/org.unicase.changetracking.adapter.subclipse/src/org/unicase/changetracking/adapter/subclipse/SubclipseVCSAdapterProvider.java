/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.adapter.subclipse;

import org.eclipse.core.resources.IProject;
import org.eclipse.team.core.RepositoryProvider;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.changetracking.vcs.IVCSAdapterProvider;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.patch.PatchChangePackage;

/**
 * The adapter provider for the subclipse adapter. Currenlty most method return
 * false, as many use cases are not yet provided by this adapter.
 * 
 * @author jfinis
 * 
 */
public class SubclipseVCSAdapterProvider implements IVCSAdapterProvider {

	/**
	 * Team provider id of the Subclipse provider. This indicates whether a
	 * project is under subclipse version control.
	 */
	public static final String SUBCLIPSE_REPO_PROVIDER_ID = "org.tigris.subversion.subclipse.core.svnnature";

	/**
	 * Not implemented for this provider.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForStream(RepositoryStream stream) {
		return false; /* Not implemented for this provider */
	}

	/**
	 * Not implemented for this provider.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForRevision(RepositoryRevision revision) {
		return false; /* Not implemented for this provider */
	}

	/**
	 * Provides for patch change packages.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForChangePackage(ChangePackage pkg) {
		return pkg instanceof PatchChangePackage;
	}

	/**
	 * Provides for projects for which subclipse is used as repo provider.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForProjects(IProject... projects) {
		for (IProject project : projects) {
			RepositoryProvider provider = RepositoryProvider.getProvider(project);
			if (provider == null) {
				return false;
			}
			if (!SUBCLIPSE_REPO_PROVIDER_ID.equals(provider.getID())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public IVCSAdapter create() {
		return new SubclipseVCSAdapter();
	}

}
