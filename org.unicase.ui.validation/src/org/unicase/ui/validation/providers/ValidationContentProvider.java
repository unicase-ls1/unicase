/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.providers;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;

/**
 * Contentprovider for validation view.
 * 
 * @author wesendonk
 */
public class ValidationContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Default constructor.
	 */
	public ValidationContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		List<IConstraintStatus> constraints = (List<IConstraintStatus>) inputElement;
		return constraints.toArray(new Object[constraints.size()]);
	}

}
