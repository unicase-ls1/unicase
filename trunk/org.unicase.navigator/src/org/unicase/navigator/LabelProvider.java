package org.unicase.navigator;


import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;


public class LabelProvider extends AdapterFactoryLabelProvider implements
		ILabelProvider {

	public LabelProvider() {
		super(new ModelItemProviderAdapterFactory());
	}

}
