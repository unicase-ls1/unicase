/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.releasechecking;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;

/**
 * Data structure for storing information during the release checking process.
 * 
 * @author jfinis
 * 
 */
public class CheckEntry {

	private Ref ref;
	private RevCommit commit;

	/**
	 * Returns the ref.
	 * 
	 * @return ref
	 */
	public Ref getRef() {
		return ref;
	}

	/**
	 * Sets the ref.
	 * 
	 * @param ref ref
	 */
	public void setRef(Ref ref) {
		this.ref = ref;
	}

	/**
	 * Returns the commit.
	 * 
	 * @return commit
	 */
	public RevCommit getCommit() {
		return commit;
	}

	/**
	 * Sets the commit.
	 * 
	 * @param commit commit
	 */
	public void setCommit(RevCommit commit) {
		this.commit = commit;
	}

}
