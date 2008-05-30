/*******************************************************************************
 * Copyright (c) 2006 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.widgets;

/**
 * 
 * @author Tom Seidel - tom.seidel@spiritlink.de
 */
public interface EventConstants {
    
        
    /**
     * Pattern: [Command]:[Value]
     */
    public static final int ALL = 0;
    /**
     * Pattern: [selected]:[anchorName]
     */
    public static final int ANCHOR = 1;
    public static final int LINK = 2;
    public static final int UNLINK = 3;
    public static final int VISUAL_AID = 4;
    public static final int UNDO = 5;
    public static final int REDO = 6;
    public static final int OUTDENT = 7;
    public static final int JUSTIFYLEFT = 8;
    public static final int JUSTIFYRIGHT = 9;
    public static final int JUSTIFYCENTER = 10;
    public static final int JUSTIFYFULL = 11;
    public static final int BOLD = 12;
    public static final int ITALIC = 13;
    public static final int STRIKETHROUGH = 14;
    public static final int SUP = 15;
    public static final int SUB = 16;
    public static final int UNDERLINE = 17;
    public static final int BULLIST = 18;
    public static final int NUMLIST = 19;
    public static final int HR = 20;
    /**
     * Pattern [selected]:[URL]|[width]|[height]|[border]|[alt]|[align]|[vspace]|[hspace]
     */
    public static final int IMAGE = 21;
    public static final int FORMATBLOCK = 22;
    public static final int FONT = 23;
    public static final int FONTSIZE = 24;
    public static final int FORECOLOR = 25;
    public static final int BACKCOLOR = 26;
    public static final int LAYER_MOVE_FORWARD = 27;
    public static final int LAYER_MOVE_BACKWARD = 28;
    public static final int LAYER_ABSOLUTE = 29;
    public static final int CURRENT_TEXT_SELECTION = 31;
    public static final int TD = 33;
    public static final int TABLE = 32;
    public static final int INSERT_ROW_BEFORE = 34;
    public static final int INSERT_ROW_AFTER = 35;
    public static final int DELETE_ROW = 36;
    public static final int INSERT_COLUMN_BEFORE = 37;
    public static final int INSERT_COLUMN_AFTER = 38;
    public static final int DELETE_COLUMN = 39;

}
