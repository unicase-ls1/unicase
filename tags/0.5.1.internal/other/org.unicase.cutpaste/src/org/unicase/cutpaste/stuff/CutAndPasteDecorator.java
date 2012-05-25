/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.stuff;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.unicase.model.UnicaseModelElement;

/**
 * Decorates a cut object with a custom icon and font color.
 * 
 * @author weiglt
 */
public class CutAndPasteDecorator implements ILightweightLabelDecorator {

	private ArrayList<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

	/**
	 * . ({@inheritDoc})
	 */
	public void decorate(Object element, IDecoration decoration) {

		Clipboard clipboard;
		Transferable transferable;
		UnicaseModelElement me, meClipboard;

		if (element instanceof UnicaseModelElement) {
			me = (UnicaseModelElement) element;
		} else {
			return;
		}

		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferable = clipboard.getContents(null);
		try {
			meClipboard = (UnicaseModelElement) transferable.getTransferData(new DataFlavor(
				org.unicase.metamodel.ModelElement.class, "ModelElement"));
		} catch (UnsupportedFlavorException e) {
			return;
		} catch (IOException e) {
			return;
		}

		if (me.equals(meClipboard)) {

			URL url = FileLocator.find(Platform.getBundle("org.unicase.cutpaste"), new Path("icons/cut.png"), null);
			ImageDescriptor sourceImageDescriptor = ImageDescriptor.createFromURL(url);
			Image sourceImage = sourceImageDescriptor.createImage();

			Image tempImage = new Image(null, new Rectangle(0, 0, 16, 16));
			GC gc = new GC(tempImage);
			// gc.setBackground(new Color(null, 255, 255, 255));
			// gc.fillRectangle(new Rectangle(0, 0, 16, 16));
			gc.drawImage(sourceImage, 0, 0);
			gc.dispose();

			ImageDescriptor descriptor = ImageDescriptor.createFromImage(tempImage);
			decoration.addOverlay(descriptor);

			decoration.setForegroundColor(new Color(null, 150, 150, 150));
			decoration.addPrefix("cut: ");
		}
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void dispose() {
		listeners.removeAll(listeners);
	}

	/**
	 * . ({@inheritDoc})
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

}
