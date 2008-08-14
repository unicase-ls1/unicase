/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.Adapter;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

/**
 * An adapter Factory that uses an item provider implementation that allows
 * filtering. If a special subclass of FilteredItemProvider shall be used,
 * invoke {@link #setFilteredItemProvider(FilteredItemProvider)}. Otherwise, no
 * filtering is done.
 * 
 * @author Florian Schneider
 * @see {@link FilteredItemProvider}
 */
public class FilteredItemProviderAdapterFactory extends
		ModelItemProviderAdapterFactory {

	FilteredItemProvider filteredItemProvider;

	public FilteredItemProviderAdapterFactory() {
		super();
		this.supportedTypes.add(FilteredItemProvider.class);
	}

	@Override
	public Adapter createIdentifiableElementAdapter() {
		if (filteredItemProvider == null) {
			filteredItemProvider = new FilteredItemProvider(
					parentAdapterFactory);
		}
		return filteredItemProvider;
	}

	public void setFilteredItemProvider(FilteredItemProvider newProvider) {
		if (filteredItemProvider != null) {
			supportedTypes.remove(filteredItemProvider.getClass());
		}
		this.filteredItemProvider = newProvider;
		supportedTypes.add(filteredItemProvider.getClass());
	}

	@Override
	public Object adapt(Object object, Object type) {
		if (((Class<?>) type).isInstance(filteredItemProvider)) {
			return filteredItemProvider;
		} else {
			return super.adapt(object, type);
		}
	}

}
