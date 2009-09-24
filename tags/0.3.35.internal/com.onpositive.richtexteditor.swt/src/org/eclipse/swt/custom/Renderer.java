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
package org.eclipse.swt.custom;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.TextLayout;

/**
 * 
 * @author kor
 *
 */
public class Renderer extends StyledTextRenderer {

	Renderer(Device device, StyledText styledText) {
		super(device, styledText);
	}

	TextLayout getTextLayout(int lineIndex) {
		return super.getTextLayout(lineIndex, styledText.getOrientation(),
				((ExtendedStyledText) styledText).getWrapWidth(lineIndex),
				styledText.lineSpacing);
	}

}
