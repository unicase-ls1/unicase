/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * An observer which waits for commit notifications and authorizes the commit procedure.
 * 
 * @author shterev
 */
public interface CommitObserver {

	/**
	 * A callback method to initiate the commit dialog and allow the user to confirm the changes.
	 * 
	 * @param changePackage the change package
	 * @return true if the changes have been confirmed, false - otherwise.
	 */
	boolean inspectChanges(ChangePackage changePackage);
}
