/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.unicase.workspace.WorkspaceManager;

/**
 * Transactional and composed Label provider with all registered label providers.
 * 
 * @author helming
 */
public class TreeLabelProvider extends TransactionalAdapterFactoryLabelProvider implements ILabelProvider {

	/**
	 * Default constructor.
	 */
	public TreeLabelProvider() {

		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(), new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

}