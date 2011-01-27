/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * Composed Label provider with all registered label providers.
 * 
 * @author helming
 */
public class TreeLabelProvider extends AdapterFactoryLabelProvider implements ILabelProvider {

	/**
	 * Default constructor.
	 */
	public TreeLabelProvider() {

		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// super(editingDomain, new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

}