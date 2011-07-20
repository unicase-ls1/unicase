/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.widgets;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A widget which displays an image AND a text (plain Labels are only able to
 * display one of both).
 * 
 * The widget is able to use a JFace label provider to extract the image and
 * text from an input object.
 * 
 * @author jfinis
 * 
 */
public class ImageAndTextLabel extends Composite {

	private Label imageLabel;
	private Label textLabel;
	private ILabelProvider labelProvider;

	/**
	 * Default constructor.
	 * 
	 * @param parent parent widget
	 * @param style style constants
	 */
	public ImageAndTextLabel(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * Constructor with initial label provider.
	 * 
	 * @param parent parent widget
	 * @param style style constants
	 * @param labelProvider initial label provider
	 */
	public ImageAndTextLabel(Composite parent, int style, ILabelProvider labelProvider) {
		super(parent, style);
		GridLayoutFactory.swtDefaults().margins(0, 0).spacing(5, 0).numColumns(2).applyTo(this);
		imageLabel = new Label(this, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(imageLabel);
		textLabel = new Label(this, SWT.NONE);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(textLabel);
		this.labelProvider = labelProvider;
	}

	/**
	 * Sets the label provider for this widget.
	 * 
	 * @param labelProvider label provider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	/**
	 * Sets the input object. Calls the getImage and getText methods of the
	 * label provider to obtain the icon and text for the input. If no label
	 * provider is set, a NoLabelProviderException is thrown.
	 * 
	 * @param input input object to be displayed
	 * @throws NoLabelProviderException if no label provider is set
	 */
	public void setInput(Object input) throws NoLabelProviderException {
		if (labelProvider == null) {
			throw new NoLabelProviderException();
		}
		imageLabel.setImage(labelProvider.getImage(input));
		textLabel.setText(labelProvider.getText(input));
	}

	/**
	 * Sets the content image and text directly without the use of a label
	 * provider.
	 * 
	 * @param image image to be displayed
	 * @param text text to be displayed
	 */
	public void setContent(Image image, String text) {
		imageLabel.setImage(image);
		textLabel.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setToolTipText(String string) {
		super.setToolTipText(string);
		imageLabel.setToolTipText(string);
		textLabel.setToolTipText(string);
	}

	/**
	 * Exception which is thrown if setInput is called without a label provider
	 * set.
	 * 
	 * @author jfinis
	 * 
	 */
	public static class NoLabelProviderException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Default constructor.
		 */
		public NoLabelProviderException() {
			super("No label provider set for this widget. Cannot use setInput.");
		}
	}
}
