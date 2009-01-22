/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.task.ActivityType;
import org.unicase.ui.stem.Activator;
import org.unicase.ui.stem.views.statusview.NotAssigned;

/**
 * . LabelProvider for annotated model element column in IterationPlaningView
 * 
 * @author Helming
 */
public class EMFColumnLabelProvider extends IterationPlanningLabelProvider {

	private DecoratingLabelProvider decoratingLabelProvider;
	private Image backlogImage;

	/**
	 * . Constructor
	 */
	public EMFColumnLabelProvider() {
		super();
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), decoratorManager
			.getLabelDecorator());

		backlogImage = Activator.getImageDescriptor("icons/backlog.png").createImage();

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof Backlog || element instanceof NotAssigned) {
			return backlogImage;
		}
		if (element instanceof ActivityType) {
			return backlogImage;
		}
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
		backlogImage.dispose();
		super.dispose();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof NotAssigned) {
			return "Not Assigned";
		}
		if (element instanceof Backlog) {
			return "Backlog";
		}
		if (element instanceof ActivityType) {
			return ((ActivityType) element).getLiteral();
		}
		return decoratingLabelProvider.getText(element);
	}

}
