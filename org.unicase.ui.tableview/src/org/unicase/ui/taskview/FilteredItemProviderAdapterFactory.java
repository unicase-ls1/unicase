package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.Adapter;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

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
