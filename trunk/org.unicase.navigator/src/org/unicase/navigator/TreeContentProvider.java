package org.unicase.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class TreeContentProvider extends AdapterFactoryContentProvider {

	public TreeContentProvider() {
		super(new ModelItemProviderAdapterFactory());
	}


	

}
