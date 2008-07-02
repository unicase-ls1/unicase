package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.unicase.workspace.WorkspaceManager;

public class ListLabelProvider extends TransactionalAdapterFactoryLabelProvider
		implements ILabelProvider {

	public ListLabelProvider() {

		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(),
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

}
