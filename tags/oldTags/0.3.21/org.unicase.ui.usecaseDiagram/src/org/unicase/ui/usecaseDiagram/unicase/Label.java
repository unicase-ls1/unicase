/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

/**
 * . This is the Label class of eclipse draw2d with the generic representation of the label (ILabel)
 */
public class Label extends WrappingLabel implements ILabel {

	/**
	 * . The default contructor
	 */
	public Label() {
		super();
		setAlignment(PositionConstants.CENTER);
	}

	/**
	 * . Constructor
	 * 
	 * @param s the text of the label
	 */
	public Label(String s) {
		super(s);
		setAlignment(PositionConstants.CENTER);
	}

	/**
	 * . Constructor
	 * 
	 * @param i the image of the label
	 */
	public Label(Image i) {
		super(i);
		setAlignment(PositionConstants.CENTER);
	}

	/**
	 * . Constructor
	 * 
	 * @param s the text of the label
	 * @param i the image of the label
	 */
	public Label(String s, Image i) {
		super(s, i);
		setAlignment(PositionConstants.CENTER);
	}

	/**
	 * @see org.eclipse.draw2d.Figure#getToolTip()
	 * @return the IFigure {@link IFigure}
	 */
	@Override
	public IFigure getToolTip() {
		if (isTextTruncated()) {
			return new org.eclipse.draw2d.Label(this.getText());
		}
		return super.getToolTip();
	}

}
