/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import org.eclipse.emf.emfstore.client.provider.ESClientVersionProvider;

/**
 * @author narayan
 *
 */
public class UnicaseClientVersionProvider implements ESClientVersionProvider {
	private final String clientName = "UNICASE";
	private final String clientVersion = "0.5.21";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.provider.ESClientVersionProvider#getVersion()
	 */
	public String getVersion() {
		return clientVersion;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.provider.ESClientVersionProvider#getName()
	 */
	public String getName() {
		return clientName;
	}

}
