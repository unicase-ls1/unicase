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
import org.unicase.metamodel.ModelElement;

/**
 * Lableprovider for validation view.
 * 
 * @author wesendon
 */
public class ValidationLableProvider extends ColumnLabelProvider {

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**
	 * Default constructor.
	 */
	public ValidationLableProvider() {
		super();
		this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof IConstraintStatus) {
			EObject target = ((IConstraintStatus) object).getTarget();
			if (target instanceof ModelElement) {
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
			if (target instanceof ModelElement) {
				return adapterFactoryLabelProvider.getText(target);
			}
		}
		return super.getText(object);
	}

}
