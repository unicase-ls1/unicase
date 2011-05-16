/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;

/**
 * This interface must be implemented by each adapter 
 * plug-in. The implementation can then be used to
 * extend the org.unicase.changetracking.vcsadapters
 * extension point provided by this plug-in. This
 * will effectively register the adapter.
 * 
 * The provider's two main jobs are to act as a factory
 * for the correspondent adapter and to decide if this
 * adapter is able to adapt different objects.
 * 
 * For example, the providesForProject method checks
 * if the adapter is able to provider VCS adaption for
 * a specific project in the workspace.
 * 
 * @author gex
 *
 */
public interface VCSAdapterProvider {
	
	/**
	 * Returns whether this class provides an adapter
	 * matching the given stream.
	 * 
	 * This means the adapter must be able to create
	 * streams like the one provided
	 * 
	 * @param stream the stream for which to provide an adapter
	 * @return whether an adapter can be provided
	 */
	boolean providesForStream(RepositoryStream stream);
	
	/**
	 * Returns whether this class provides an adapter
	 * matching the given revision.
	 * 
	 * This means the adapter must be able to create
	 * and check out revision like the one provided.
	 * 
	 * @param revision the revision for which to provide an adapter
	 * @return whether an adapter can be provided
	 */
	boolean providesForRevision(RepositoryRevision revision);
	
	/**
	 * Returns whether this class provides an adapter
	 * matching the given change package.
	 * 
	 * This means the adapter must be able to create
	 * and apply the type of packages which is provided.
	 * 
	 * @param pkg the change package for which to provide an adapter
	 * @return whether an adapter can be provided
	 */
	boolean providesForChangePackage(ChangePackage pkg);
	
	/**
	 * Returns whether this class provides an adapter
	 * matching the given project.
	 * 
	 * This means that the adapter must be able to
	 * collect and apply changes from and to the project,
	 * respectively.
	 * 
	 * @param project the project for which to provide an adapter
	 * @return whether an adapter can be provided
	 */
	boolean providesForProject(IProject project);
	
	/**
	 * Factory method creating a new instance of the
	 * corresponding adapter.
	 * @return newly created adapter
	 */
	VCSAdapter create();
	
}
