/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;

/**
 * Factory class which uses the adapter registry to create adapters matching for
 * different objects.
 * 
 * For example, the createFromProject method looks for an adapter matching the
 * version control system under which the project is versioned.
 * 
 * If no matching adapter can found, each method throws a misuse exception.
 * 
 * @author jfinis
 * 
 */
public class VCSAdapterFactory {

	private List<VCSAdapterProvider> getProviders() {
		return VCSAdapterRegistry.INSTANCE.getProviders();
	}

	private MisuseException createProviderMissingException(String s) {
		return new MisuseException("No version control adapter matching this " + s + " could be found. You need to install the appropriate adapter first.");
	}

	/**
	 * Creates an adapter matching the version control system under which the
	 * project is versioned.
	 * 
	 * @param p the project
	 * @return the matching adapter
	 * @throws MisuseException if no matching adapter was found
	 */
	public VCSAdapter createFromProject(IProject p) throws MisuseException {
		for (VCSAdapterProvider v : getProviders()) {
			if (v.providesForProject(p)) {
				return v.create();
			}
		}
		throw createProviderMissingException("project");
	}

	/**
	 * Creates an adapter matching a change package. This means that the adapter
	 * is able to apply this change package.
	 * 
	 * @param cp a change package
	 * @return the matching adapter
	 * @throws MisuseException if no matching adapter was found
	 */
	public VCSAdapter createFromChangePackage(ChangePackage cp) throws MisuseException {
		for (VCSAdapterProvider v : getProviders()) {
			if (v.providesForChangePackage(cp)) {
				return v.create();
			}
		}
		throw createProviderMissingException("change package");
	}

	/**
	 * Creates an adapter matching a release. This means the repository stream
	 * belonging to the stream of the release is supported by the version
	 * control adapter. The adapter is therefore able to build the release.
	 * 
	 * 
	 * @param r a release
	 * @return the matching adapter
	 * @throws MisuseException if no matching adapter was found or if the
	 *             release doesn't have a stream or repository stream assigned
	 */
	public VCSAdapter createFromRelease(ChangeTrackingRelease r) throws MisuseException {
		Stream s = r.getStream();
		if (s == null) {
			throw new MisuseException("The release has no stream attached.");
		}
		RepositoryStream rs = s.getRepositoryStream();
		if (rs == null) {
			throw new MisuseException("The stream of the release has no repository stream attached");
		}
		for (VCSAdapterProvider v : getProviders()) {
			if (v.providesForStream(rs)) {
				return v.create();
			}
		}
		throw createProviderMissingException("release");
	}
}
