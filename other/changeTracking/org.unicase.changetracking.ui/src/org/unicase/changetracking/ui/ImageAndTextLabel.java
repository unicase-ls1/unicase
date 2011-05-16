/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ImageAndTextLabel extends Composite {

	private Label imageLabel;
	private Label textLabel;
	private ILabelProvider labelProvider;

	public ImageAndTextLabel(Composite parent, int style) {
		this(parent, style, null);
	}
	
	public ImageAndTextLabel(Composite parent, int style, ILabelProvider labelProvider){
		super(parent, style);
		GridLayoutFactory.swtDefaults().margins(0,0).spacing(5,0).numColumns(2).applyTo(this);
		imageLabel = new Label(this,SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(imageLabel);
		textLabel = new Label(this,SWT.NONE);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(textLabel);
		this.labelProvider = labelProvider;
	}
	
	public void setLabelProvider(ILabelProvider labelProvider){
		this.labelProvider = labelProvider;
	}
	
	public void setInput(Object input){
		if(labelProvider == null){
			throw new RuntimeException("No label provider set. Cannot set input.");
		}
		imageLabel.setImage(labelProvider.getImage(input));
		textLabel.setText(labelProvider.getText(input));
	}
	
	public void setContent(Image image, String text){
		imageLabel.setImage(image);
		textLabel.setText(text);
	}
	
	@Override
	public void setToolTipText(String string) {
		super.setToolTipText(string);
		imageLabel.setToolTipText(string);
		textLabel.setToolTipText(string);
	}

}
