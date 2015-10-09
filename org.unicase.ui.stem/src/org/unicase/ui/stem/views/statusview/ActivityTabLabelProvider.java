/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.task.ActivityType;
import org.unicase.ui.stem.Activator;

/**
 * Label Provider for the activity view.
 * 
 * @author helming
 */
public class ActivityTabLabelProvider extends AdapterFactoryLabelProvider implements IColorProvider {

	private Image backlogImage;

	/**
	 * default constructor.
	 * 
	 * @param adapterFactory
	 */
	public ActivityTabLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		backlogImage = Activator.getImageDescriptor("icons/backlog.png").createImage();
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
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof ActivityType) {
			return backlogImage;
		}
		return super.getImage(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ActivityType) {
			return ((ActivityType) object).getLiteral();
		}
		return super.getText(object);
	}

}
