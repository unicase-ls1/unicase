/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

// dengler: document
/**
 * * This class extends the Eclipse WrappingLabel to position text in the center.
 * 
 * @author denglerm
 */
public class Label extends WrappingLabel {

	private void init() {
		setAlignment(PositionConstants.CENTER);
		setTextWrap(true);
		setTextJustification(PositionConstants.CENTER);
	}

	/**
	 * Default constructor.
	 */
	public Label() {
		super();
		init();
	}

	/**
	 * Constructor.
	 * 
	 * @param s the text of the label
	 */
	public Label(String s) {
		super(s);
		init();
	}

	/**
	 * Constructor.
	 * 
	 * @param i the image of the label
	 */
	public Label(Image i) {
		super(i);
		init();
	}

	/**
	 * Constructor.
	 * 
	 * @param s the text of the label
	 * @param i the image of the label
	 */
	public Label(String s, Image i) {
		super(s, i);
		init();
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
