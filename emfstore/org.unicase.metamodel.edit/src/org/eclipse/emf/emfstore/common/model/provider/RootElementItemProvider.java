/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.common.model.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * An item provider for all root elements of the unified model.
 * 
 * @author shterevg
 */
public class RootElementItemProvider extends ItemProviderAdapter {

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory the AdapterFactory
	 */
	public RootElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object overlayImage(Object object, Object image) {
		return image;
	}

}
