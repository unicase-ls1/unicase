/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
/**
 * This label provider shows the status of a modelelement represented as an image.
 * @author helming
 *
 */
public class StatusLabelProvider extends ColumnLabelProvider implements
		IColorProvider {

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			String status = MEState.CLOSED;
			try {
				status = me.getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}

			String path = "icons/closed.jpg";
			if (status.equals(MEState.OPEN)) {
				path = "icons/open.jpg";
			}
			if (status.equals(MEState.BLOCKED)) {
				path = "icons/blocked.jpg";
			} 
			URL url = FileLocator.find(Platform
					.getBundle("org.unicase.ui.stem"), new Path(path), null);
			ImageDescriptor imageDescriptor = ImageDescriptor
					.createFromURL(url);
			return imageDescriptor.createImage();

		}
		return null;
	}
	
	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "";
	}

}
