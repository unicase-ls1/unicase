/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Lableprovider for validation view.
 * 
 * @author wesendon
 */
public class ValidationLabelProvider extends ColumnLabelProvider {

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	private ComposedAdapterFactory composedAdapterFactory;

	/**
	 * Default constructor.
	 */
	public ValidationLabelProvider() {
		super();
		composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
		// jc: done
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof IConstraintStatus) {
			EObject target = ((IConstraintStatus) object).getTarget();
			if (target instanceof EObject) {
				return adapterFactoryLabelProvider.getImage(target);
			}
		}
		return super.getImage(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof IConstraintStatus) {
			EObject target = ((IConstraintStatus) object).getTarget();
			if (target instanceof EObject) {
				return adapterFactoryLabelProvider.getText(target);
			}
		}
		return super.getText(object);
	}

	@Override
	public void dispose() {
		adapterFactoryLabelProvider.dispose();
		composedAdapterFactory.dispose();
		super.dispose();
	}

}
