/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

/**
 * The state of a change package, during a release check.
 * 
 * @author gex
 *
 */
public enum ChangePackageState {
	
	/**
	 * The package is not included in the source code.
	 * I.e. it is not merged in yet.
	 */
	UNMERGED,
	
	/**
	 * The package is contained in the source code.
	 */
	MERGED, 
	
	/**
	 * The package is erroneous.
	 * E.g. the patch for a patch change package or the
	 * branch for a branch change package is missing.
	 */
	ERROR;

}
