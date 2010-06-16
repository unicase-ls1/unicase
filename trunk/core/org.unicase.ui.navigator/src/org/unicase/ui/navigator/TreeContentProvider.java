/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Transactional and composed content provider with all registered label providers.
 * 
 * @author helming
 */
public class TreeContentProvider extends TransactionalAdapterFactoryContentProvider {

	private RootObjectContentProvider contentProvider;

	/**
	 * Directly Transfer to project. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof ProjectSpace && contentProvider != null) {
			return contentProvider.getChildren((ProjectSpace) object).toArray();
		}
		return super.getChildren(object);
	}

	/**
	 * default constructor.
	 */
	public TreeContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(), new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.navigator.replaceRootObjectContentProvider");
		if (confs.length > 1) {
			WorkspaceUtil.logWarning("Duplicate RootObjectContent Provider registered", new IllegalStateException());
		}
		if (confs.length == 1) {
			try {
				contentProvider = (RootObjectContentProvider) confs[0].createExecutableExtension("class");

			} catch (CoreException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		}

	}

}