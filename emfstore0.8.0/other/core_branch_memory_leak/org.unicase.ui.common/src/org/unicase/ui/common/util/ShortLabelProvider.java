/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * Label provider to shorten the getText Method.
 * 
 * @author helming
 */
public class ShortLabelProvider extends AdapterFactoryLabelProvider implements ILabelProvider {

	/**
	 * Default constructor.
	 */
	public ShortLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.IItemLabelProvider#getText(java.lang.Object)
	 * @override
	 */
	@Override
	public String getText(Object object) {
		int limit = 30;
		String name = super.getText(object);
		if (name == null) {
			name = "";
		}
		if (name.length() > limit + 5) {
			name = name.substring(0, limit).concat("[...]");
		}
		return name;
	}

}
