/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This is a label provider for ColumnViewer columns which show a checkbox. The label providers makes an on-the-fly
 * snap-shot of a checkbox and returns this image to show a correct checkbox image on every platform. See also:
 * {@link http://tom-eclipse-dev.blogspot.com/2007/01/tableviewers-and-nativelooking.html}
 * 
 * @author Zardosht Hodaie
 */
public abstract class AbstractCheckboxColumnLabelProvider extends ColumnLabelProvider {
	/**
	 * Key to retrieve a checked checkbox image.
	 */
	public static final String CHECKED = "CHECKED";
	/**
	 * Key to retrieve an unchecked checkbox image.
	 */
	public static final String UNCHECK = "UNCHECKED";

	/**
	 * Constructor.
	 */
	public AbstractCheckboxColumnLabelProvider() {
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED) == null) {
			JFaceResources.getImageRegistry().put(UNCHECK, makeShot(false));
			JFaceResources.getImageRegistry().put(CHECKED, makeShot(true));
		}
	}

	private Image makeShot(boolean type) {
		// Hopefully no platform uses exactly this color
		// because we'll make it transparent in the image.
		Display display = Display.getDefault();
		Color greenScreen = new Color(display, 222, 223, 224);

		Shell tmpShell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		tmpShell.setVisible(false);

		// otherwise we have a default gray color
		tmpShell.setBackground(greenScreen);

		Button button = new Button(tmpShell, SWT.CHECK);
		button.setBackground(greenScreen);
		button.setSelection(type);

		// otherwise an image is located in a corner
		Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// otherwise an image is stretched by width
		bsize.x = Math.min(bsize.x, 16);
		bsize.y = Math.min(bsize.y, 16);
		button.setSize(bsize);

		tmpShell.setSize(17, 17);
		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginHeight = 0;
		gridLayout.marginTop = 1;
		gridLayout.marginRight = 2;
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;

		tmpShell.setLayout(gridLayout);

		GridData gridData = new GridData(SWT.RIGHT, SWT.TOP, false, false);
		button.setLayoutData(gridData);

		button.setLocation(17 - bsize.x, 0);

		tmpShell.open();
		GC gc = new GC(tmpShell);
		Image image = new Image(display, 16, 16);
		gc.copyArea(image, 1, 1);
		gc.dispose();
		tmpShell.close();
		tmpShell.dispose();

		ImageData imageData = image.getImageData();
		imageData.transparentPixel = imageData.palette.getPixel(greenScreen.getRGB());
		image.dispose();

		Image ret = new Image(display, imageData);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		return "";
	}

	/**
	 * {@inheritDoc} Sub-classes must override this method, and return a checked or an unchecked checkbox image using
	 * JFaceResources.getImage(IMAGE_KEY);.
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public abstract Image getImage(Object element);

}
