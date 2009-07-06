/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.osgi.framework.Version;
import org.unicase.model.Project;

/**
 * @author schroech
 *
 */
public class ModelCleanupUpdateStep extends UpdateStepImpl {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepImpl#updateProjectState(org.unicase.model.Project)
	 */
	@Override
	public int updateProjectState(Project state) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public Version getSourceVersion() {
		return new Version("0.1.");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public Version getTargetVersion() {
		return new Version("0.1.0");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle() {
		return "Model cleanup version 0.1.0";
	}

}
