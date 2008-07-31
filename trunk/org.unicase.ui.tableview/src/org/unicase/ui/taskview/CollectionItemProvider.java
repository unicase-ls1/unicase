package org.unicase.ui.taskview;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class CollectionItemProvider extends ItemProviderAdapter implements
		IStructuredItemContentProvider {

	public CollectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection<?> getElements(Object object) {
		if (object instanceof Collection) {
			return (Collection<?>) object;
		} else {
			return null;
		}
	}
}
