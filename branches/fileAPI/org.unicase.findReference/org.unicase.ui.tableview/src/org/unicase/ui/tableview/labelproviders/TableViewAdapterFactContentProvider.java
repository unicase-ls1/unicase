/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.ModelElement;

/**
 * This is the {@link AdapterFactoryContentProvider}.
 * 
 * @author Abdelhamid Barzali
 */
public class TableViewAdapterFactContentProvider extends AdapterFactoryContentProvider {
	/**
	 * the Constructor.
	 */
	public TableViewAdapterFactContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param object Object.
	 * @return Object[] of {@link ModelElement}s.
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object object) {

		return (ModelElement[]) object;

	}

}
