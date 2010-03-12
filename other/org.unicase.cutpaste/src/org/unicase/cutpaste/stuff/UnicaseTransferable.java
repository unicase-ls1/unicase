/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.stuff;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.CompositeOperationHandle;

/**
 * The custom Wrapperclass for the Cut/Paste Action.
 * 
 * @author weiglt
 */
public class UnicaseTransferable implements Transferable {

	private ModelElement me;
	private CompositeOperationHandle cOH;
	private DataFlavor[] providedFlavors;

	/**
	 * Creates a UnicaseTransferable object for clipboard use. Provides (ModelElement), (String) and (Image)
	 * representation of a Modelelement.
	 * 
	 * @param me The ModelElement to be copied to the clipboard.
	 * @param cOH The CompositeOperationHandle on which a CompositeOperation was started.
	 */
	public UnicaseTransferable(ModelElement me, CompositeOperationHandle cOH) {
		this.me = me;
		this.cOH = cOH;

		providedFlavors = new DataFlavor[] { new DataFlavor(org.unicase.metamodel.ModelElement.class, "ModelElement"),
			new DataFlavor(org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"),
			DataFlavor.stringFlavor, DataFlavor.imageFlavor };

	}

	/**
	 * . ({@inheritDoc})
	 */
	public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
		if (dataFlavor.equals(providedFlavors[0])) {
			return me;
		} else if (dataFlavor.equals(providedFlavors[1])) {
			return cOH;
		} else if (dataFlavor.equals(providedFlavors[2])) {
			return me.toString();
		} else if (dataFlavor.equals(providedFlavors[3])) {
			return toImage(me);
		}

		return null;
	}

	/**
	 * . ({@inheritDoc})
	 */
	public DataFlavor[] getTransferDataFlavors() {
		return providedFlavors;
	}

	/**
	 * . ({@inheritDoc})
	 */
	public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
		for (DataFlavor providedFlavor : providedFlavors) {
			if (dataFlavor.equals(providedFlavor)) {
				return true;
			}
		}
		return false;
	}

	private Image toImage(ModelElement me) {
		// this could be an icon extractor method for me, or a diagram rendering method, etc.
		// for now it returns <see current code>

		final Dimension rQVGA = new Dimension(320, 240);
		Dimension thumbnail = rQVGA;
		BufferedImage screenshot = null;
		BufferedImage resizedScreenshot = null;
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Robot robot = new Robot();
			screenshot = robot.createScreenCapture(new Rectangle(toolkit.getScreenSize()));
			resizedScreenshot = new BufferedImage(thumbnail.width, thumbnail.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resizedScreenshot.createGraphics();
			g.drawImage(screenshot, 0, 0, thumbnail.width, thumbnail.height, null);
			g.dispose();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		BufferedImage result = resizedScreenshot;

		return result;
	}
}