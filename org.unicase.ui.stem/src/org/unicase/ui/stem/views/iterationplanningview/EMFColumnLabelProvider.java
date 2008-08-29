/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

/**
 * . LabelProvider for annotated model element column in IterationPlaningView
 * 
 * @author Helming
 * 
 */
public class EMFColumnLabelProvider extends ColumnLabelProvider {

	private DecoratingLabelProvider decoratingLabelProvider;

	/**.
	 *  Constructor
	 */
	public EMFColumnLabelProvider() {
		super();
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(
				new AdapterFactoryLabelProvider(
						new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
							decoratorManager.getLabelDecorator());

	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		Image image = decoratingLabelProvider.getImage(element);
		decoratingLabelProvider.getLabelDecorator().decorateImage(image,
				element);
		return image;
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Color getBackground(Object element) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			if (me.getState().equals(MEState.OPEN)) {
				return display.getSystemColor(SWT.COLOR_YELLOW);
			}
			if (me.getState().equals(MEState.CLOSED)) {
				return display.getSystemColor(SWT.COLOR_GREEN);
			}

		}
		return super.getBackground(element);
	}
	
	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return decoratingLabelProvider.getText(element);
	}

}
