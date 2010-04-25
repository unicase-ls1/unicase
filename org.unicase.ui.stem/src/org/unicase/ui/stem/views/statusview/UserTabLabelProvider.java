/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.stem.Activator;

/**
 * This is the LabelProvider for users tab. This class just takes care of background colors. Assignables that are closed
 * are shown in green. If all Assignables of an OrgUnit are closed, it will be also shown green.
 * 
 * @author Hodaie
 */

public class UserTabLabelProvider extends AdapterFactoryLabelProvider implements IColorProvider {

	private Image backlogImage;

	/**
	 * Constructor.
	 */
	public UserTabLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		backlogImage = Activator.getImageDescriptor("icons/backlog.png").createImage();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof NotAssigned) {
			return backlogImage;
		}
		return super.getImage(object);
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
	public String getText(Object object) {
		if (object instanceof NotAssigned) {
			return "Not Assigned";
		}
		return super.getText(object);
	}

}
