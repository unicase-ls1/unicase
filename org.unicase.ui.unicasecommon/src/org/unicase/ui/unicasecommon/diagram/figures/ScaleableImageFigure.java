/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.figures;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @author denglerm This is class extends the eclipse ImageFigure to allow resize.
 */
public class ScaleableImageFigure extends ImageFigure {

	/**
	 * Constructor.
	 * 
	 * @param bundle The package of the figure file
	 * @param path the path of the figure file within the package
	 */
	public ScaleableImageFigure(String bundle, String path) {
		Image img = ImageDescriptor.createFromURL(FileLocator.find(Platform.getBundle(bundle), new Path(path), null))
			.createImage();
		this.setImage(img);
		this.setAlignment(PositionConstants.NORTH_WEST);
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.draw2d.ImageFigure#getImage()
	 */
	@Override
	public Image getImage() {
		Image img = super.getImage();
		Image scaled = new Image(img.getDevice(), img.getImageData().scaledTo(this.getBounds().width,
			this.getBounds().height));
		return scaled;
	}
}
