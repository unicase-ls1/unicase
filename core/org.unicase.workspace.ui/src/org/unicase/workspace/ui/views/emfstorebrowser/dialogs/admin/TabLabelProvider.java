package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

public class TabLabelProvider extends AdapterFactoryLabelProvider {

	public TabLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
}
