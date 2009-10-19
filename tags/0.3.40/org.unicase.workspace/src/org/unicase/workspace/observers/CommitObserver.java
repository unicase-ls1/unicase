/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.workspace.ProjectSpace;

/**
 * An observer which waits for commit notifications and authorizes the commit procedure.
 * 
 * @author shterev
 */
public interface CommitObserver {

	/**
	 * Called before the commit proceeds. A callback method to initiate the commit dialog and allow the user to confirm
	 * the changes.
	 * 
	 * @param projectSpace the project space the commit occurs on
	 * @param changePackage the change package
	 * @return true if the changes have been confirmed, false - otherwise.
	 */
	boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage);

	/**
	 * Called after the commit is completed.
	 * 
	 * @param projectSpace the {@link ProjectSpace}
	 * @param newRevision the new revision that was created by the commit
	 */
	void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision);
}
