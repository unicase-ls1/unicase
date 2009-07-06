/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import org.eclipse.emf.common.notify.Adapter;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

/**
 * An adapter Factory that uses an item provider implementation that allows filtering. If a special subclass of
 * FilteredItemProvider shall be used, invoke {@link #setFilteredItemProvider(FilteredItemProvider)}. Otherwise, no
 * filtering is done.
 * 
 * @author Florian Schneider
 * @see {@link FilteredItemProvider}
 */
public class FilteredItemProviderAdapterFactory extends ModelItemProviderAdapterFactory {

	private EClassFilterItemProvider filteredItemProvider;

	/**
	 * default constructor.
	 */
	public FilteredItemProviderAdapterFactory() {
		super();
		this.supportedTypes.add(EClassFilterItemProvider.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Adapter createIdentifiableElementAdapter() {
		if (filteredItemProvider == null) {
			filteredItemProvider = new EClassFilterItemProvider(parentAdapterFactory);
		}
		return filteredItemProvider;
	}

	/**
	 * sets a fileterd itemprovider.
	 * 
	 * @param newProvider The filtered provider
	 */
	public void setFilteredItemProvider(EClassFilterItemProvider newProvider) {
		if (filteredItemProvider != null) {
			supportedTypes.remove(filteredItemProvider.getClass());
		}
		this.filteredItemProvider = newProvider;
		supportedTypes.add(filteredItemProvider.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (((Class<?>) type).isInstance(filteredItemProvider)) {
			return filteredItemProvider;
		} else {
			return super.adapt(object, type);
		}
	}

}
