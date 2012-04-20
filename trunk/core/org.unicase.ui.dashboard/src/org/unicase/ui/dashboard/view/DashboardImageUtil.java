/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.dashboard.Activator;

/**
 * A utility class to handle images in the dashboard.
 * 
 * @author Shterev
 */
public final class DashboardImageUtil {

	private DashboardImageUtil() {
		// a utility class constructor.
	}

	/**
	 * Fetches an image from the given path and automatically caches it in the ImageRegistry.
	 * 
	 * @param path the path
	 * @return the image
	 */
	public static Image getImage(String path) {
		final String key = "dashboard_" + path;
		ImageDescriptor regImage = JFaceResources.getImageRegistry().getDescriptor(key);
		if (regImage == null) {
			regImage = Activator.getImageDescriptor("icons/" + path);
			JFaceResources.getImageRegistry().put(key, regImage);
		}
		return regImage.createImage();
	}

	/**
	 * Fetches an image from the given path, adds a transparency to it and automatically caches it in the ImageRegistry.
	 * 
	 * @param path the path
	 * @param lightFactor the light factor
	 * @return the light image
	 */
	public static Image getLightImage(String path, int lightFactor) {
		final String key = "dashboard_light_" + path;
		ImageDescriptor regImage = JFaceResources.getImageRegistry().getDescriptor(key);
		if (regImage == null) {
			Image image = Activator.getImageDescriptor("icons/" + path).createImage();
			ImageData imageData = image.getImageData();
			for (int i = 0; i < imageData.alphaData.length; i++) {
				int orig = imageData.alphaData[i] & 0xFF;
				if (orig - lightFactor < 0) {
					imageData.alphaData[i] = (byte) 0;
				} else {
					imageData.alphaData[i] = (byte) (imageData.alphaData[i] - lightFactor);
				}
			}
			Image lightImage = new Image(Display.getCurrent(), imageData);
			JFaceResources.getImageRegistry().put(key, lightImage);
			return lightImage;
		}
		return regImage.createImage();
	}

}
