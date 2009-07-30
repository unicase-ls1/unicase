/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import org.unicase.emfstore.esmodel.versioning.VersionSpec;

/**
 * @author liya
 */
public class VersionSpecQuery {

	private VersionSpec start;
	private VersionSpec end;

	/**
	 * @param start {@link VersionSpec}
	 * @param end {@link VersionSpec}
	 */
	public VersionSpecQuery(VersionSpec start, VersionSpec end) {

		this.start = start;
		this.end = end;

	}

	/**
	 * @return the start
	 */
	public VersionSpec getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(VersionSpec start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public VersionSpec getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(VersionSpec end) {
		this.end = end;
	}

}
