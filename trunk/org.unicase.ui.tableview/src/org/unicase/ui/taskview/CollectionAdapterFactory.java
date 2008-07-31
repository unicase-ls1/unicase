package org.unicase.ui.taskview;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class CollectionAdapterFactory extends AdapterFactoryImpl {

	private CollectionItemProvider collectionItemProvider;

	@Override
	public boolean isFactoryForType(Object type) {
		return (type instanceof CollectionItemProvider);
	}

	@Override
	public Object adapt(Object target, Object type) {
		if (target instanceof Collection) {
			if (collectionItemProvider == null) {
				collectionItemProvider = new CollectionItemProvider(this);
			}
			return collectionItemProvider;
		} else {
			return super.adapt(target, type);
		}
	}

}
