/*******************************************************************************
 * Copyright (c) 2007 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.util;

import java.awt.Color;

import org.eclipse.swt.graphics.RGB;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public final class ColorConverter {
    
    public static String convertRgbToHex(RGB rgb) {
        return new StringBuffer(toHex(rgb.red)).append(toHex(rgb.green)).append(toHex(rgb.blue)).toString();
    }
    
    private static String toHex(int color) {
        return new String(new char[] {"0123456789ABCDEF".charAt((color - color % 16)/16), //$NON-NLS-1$
         "0123456789ABCDEF".charAt(color%16)},0,2); //$NON-NLS-1$
    }
    
    public static RGB convertHexToRgb(String hex) {
        Color color = Color.decode(hex.charAt(0) == '#' ? hex : "#" + hex); //$NON-NLS-1$
        return new RGB(color.getRed(),color.getGreen(),color.getBlue());
    }

}
