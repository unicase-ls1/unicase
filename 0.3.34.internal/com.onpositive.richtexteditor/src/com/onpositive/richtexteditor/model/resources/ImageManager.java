/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.model.resources;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Observer;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * @author kor
 * Image managing class
 */
public class ImageManager {

	static File tempDirFile = null;

	static {
		String tempDir = System.getProperty("java.io.tmpdir");
		if (tempDir == null) {
			tempDirFile = new File(".");
		}
	}

	private HashMap<String, Image> imageMap = new HashMap<String, Image>();
	private Display display;

	/**
	 * Basic constructor
	 * @param display display to allocate images at
	 */
	public ImageManager(Display display) {
		this.display=display;
	}

	/**
	 * Asynchronous image loading method
	 * @param string image resource string
	 * @param observer Observer instance
	 */
	public void sheduleLoad(final String string, final Observer observer) {
		Thread loader = new Thread() {
			public void run() {
				try {
					Image image = imageMap.get(string);
					if (image != null) {
						observer.update(null, image);
						return;
					}
					InputStream openStream = new URL(string).openStream();
					Image loadedImage = new Image(display,
							openStream);
					imageMap.put(string, loadedImage);
					observer.update(null, loadedImage);
				} catch (Exception e) {

				}

			}
		};
		loader.start();
	}

	/**
	 * Get image by it's string
	 * @param string image resource string
	 * @param observer Observer instance
	 * @return Image object for loaded image
	 */
	public synchronized Image getImage(String string, Observer observer) {
		Image image = imageMap.get(string);
		if (image != null) {
			return image;
		}
		sheduleLoad(string, observer);
		return null;
	}

	/**
	 * Disposes all loaded images
	 */
	public void dispose() {
		for (Image i : imageMap.values()) {
			i.dispose();
		}
	}

	/**
	 * Checks, have we loaded specified image file or not
	 * @param filename Image File Name
	 * @return not null, if we have loaded an image file, null otherwise
	 */
	public Image checkImage(String filename) {
		Image image = imageMap.get(filename);
		return image;
	}

	/**
	 * Registers image
	 * @param filename image file name
	 * @param image image object to register
	 */
	public void registerImage(String filename, Image image) {
		imageMap.put(filename,image);
	}
}
