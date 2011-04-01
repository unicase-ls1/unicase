/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.validation.providers;

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
