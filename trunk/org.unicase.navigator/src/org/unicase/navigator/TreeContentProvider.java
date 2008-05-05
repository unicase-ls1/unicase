package org.unicase.navigator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.workspace.util.WorkspaceAdapterFactory;

public class TreeContentProvider extends AdapterFactoryContentProvider {

	public TreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

}
