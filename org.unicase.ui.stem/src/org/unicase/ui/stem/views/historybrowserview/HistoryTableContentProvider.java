package org.unicase.ui.stem.views.historybrowserview;

import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.Version;

public class HistoryTableContentProvider extends AdapterFactoryContentProvider {

	public HistoryTableContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	@Override
	public Object[] getElements(Object object) {
		List<Version> versions = (List<Version>) object;

		return versions.toArray(new Object[versions.size()]);
		
	}
	

}
