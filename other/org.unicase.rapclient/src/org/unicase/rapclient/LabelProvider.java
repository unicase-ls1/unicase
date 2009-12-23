package org.unicase.rapclient;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class LabelProvider extends BaseLabelProvider implements ILabelProvider {

	private AdapterFactoryLabelProvider factoryLabelProvider;
	
	public LabelProvider() {
		factoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	public Image getImage(Object element) {
		return factoryLabelProvider.getImage(element);
	}

	public String getText(Object element) {
		return factoryLabelProvider.getText(element);
	}
}
