/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.IFigure;

/**
 * The generic representation of a label : a figure which we can set and get some text.
 */
public interface ILabel extends IFigure {

	/**
	 * . Set the new text to the label
	 * 
	 * @param s the new text
	 */
	void setText(String s);

	/**
	 * . Get the text of the label
	 * 
	 * @return the text of the label
	 */
	String getText();

}
