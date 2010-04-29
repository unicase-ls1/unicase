/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;

/**
 * . This is the base class for column label providers in for flat tab. This ColumnLabelProvider implements
 * IColorProvider to set background color of open/closed openers accordingly (sub classes must override setBackground())
 * 
 * @author Hodaie
 */
public class FlatTabColumnLabelProvider extends ColumnLabelProvider implements IColorProvider {

	/**
	 * . The adapterFactoryLabelProvider used to retrieve text and images
	 */
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**
	 * . Constructor
	 */
	public FlatTabColumnLabelProvider() {
		super();
		this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return getAdapterFactoryLabelProvider().getText(element);
	}

	/**
	 * . this returns the adapterFactoryLabelProvider used to retrieve text and images
	 * 
	 * @return The adapterFactoryLabelProvider used to retrieve text and images
	 */
	public AdapterFactoryLabelProvider getAdapterFactoryLabelProvider() {
		return adapterFactoryLabelProvider;
	}

}
