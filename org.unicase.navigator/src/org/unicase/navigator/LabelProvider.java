package org.unicase.navigator;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.workspace.util.WorkspaceAdapterFactory;


public class LabelProvider extends AdapterFactoryLabelProvider implements
		ILabelProvider {

	public LabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	

}
