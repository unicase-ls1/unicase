/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.observers;

import java.util.List;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Represents a controller that can merge conflicting changes resulting in a list of changes that is not conflicting any
 * more.
 * 
 * @author koegel
 */
public interface ConflictResolver {

	/**
	 * Resolves all conflicts between the given change packages "theirs" and the given local operations.
	 * 
	 * @param project the project at the time were all local changes are already applied and their operations are NOT,
	 *            in other words the base version plus local operations
	 * @param theirChangePackages an ordered list of change packages that are incoming in the update, in other words all
	 *            change packages from base to target
	 * @param myChangePackage the change package of operations that are to be applied locally
	 * @param baseVersion baseVersion of projectspace and sourceversion of changes from server
	 * @param targetVersion the version to which is updated
	 * @return true if the merge can proceed, false if it has to be cancelled
	 */
	boolean resolveConflicts(Project project, List<ChangePackage> theirChangePackages, ChangePackage myChangePackage,
		PrimaryVersionSpec baseVersion, PrimaryVersionSpec targetVersion);

	/**
	 * Get all operations that have been rejected in their changepackages.
	 * 
	 * @return a list of operations
	 */
	List<AbstractOperation> getRejectedTheirs();

	/**
	 * Get all operations of my local operations that have been accepted.
	 * 
	 * @return a list of operations
	 */
	List<AbstractOperation> getAcceptedMine();
}
