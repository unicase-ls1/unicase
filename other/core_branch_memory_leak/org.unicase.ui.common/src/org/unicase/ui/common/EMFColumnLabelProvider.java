/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;

/**
 * . LabelProvider for annotated model element column
 * 
 * @author Helming
 */
public class EMFColumnLabelProvider extends ColumnLabelProvider implements IColorProvider {

	private DecoratingLabelProvider decoratingLabelProvider;

	/**
	 * . Constructor
	 */
	public EMFColumnLabelProvider() {
		super();
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		// hkq: done
		decoratingLabelProvider = new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), decoratorManager
			.getLabelDecorator());
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {

		Image image = decoratingLabelProvider.getImage(element);
		decoratingLabelProvider.getLabelDecorator().decorateImage(image, element);
		return image;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		/*
		 * Since we know that decoratingLabelProvider, labelprovider and adapterfactory was instantiated in constructor
		 * there are no other references to adapterfactory therefore we can dispose adapterfactory here.
		 */
		ILabelProvider labelProvider = decoratingLabelProvider.getLabelProvider();
		if (labelProvider instanceof AdapterFactoryLabelProvider) {
			if (((AdapterFactoryLabelProvider) labelProvider).getAdapterFactory() instanceof IDisposable) {
				((IDisposable) ((AdapterFactoryLabelProvider) labelProvider).getAdapterFactory()).dispose();
			}
		}
		labelProvider.dispose();
		decoratingLabelProvider.dispose();
		super.dispose();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return decoratingLabelProvider.getText(element);
	}

}
