/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;

/**
 * Adapter class for the {@link IJobChangeListener}.
 * 
 * @author pfeifferc
 */
public class IJobChangeListenerAdapter implements IJobChangeListener {
	/**
	 * {@inheritDoc}
	 */
	public void aboutToRun(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void awake(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void done(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void running(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void scheduled(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void sleeping(IJobChangeEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
}
