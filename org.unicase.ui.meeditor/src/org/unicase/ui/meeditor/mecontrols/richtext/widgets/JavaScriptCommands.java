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

import org.eclipse.swt.graphics.RGB;
import org.unicase.ui.meeditor.mecontrols.richtext.util.ColorConverter;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public final class JavaScriptCommands {

	public static final String BOLD = "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\','Bold\',false);"; //$NON-NLS-1$

	public static final String ITALIC = "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\','Italic\',false);"; //$NON-NLS-1$

	public static final String VISUAL_AID = "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\','mceToggleVisualAid\',false);"; //$NON-NLS-1$

	public static final String UNDERLINE = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Underline',false);"; //$NON-NLS-1$

	public static final String JUSTIFYLEFT = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','JustifyLeft',false);"; //$NON-NLS-1$

	public static final String GET_HTML = "javascript:window.status=\'0:START\';window.status=\'command:getHTML\';window.status=\'value:\' + tinyMCE.getContent();window.status=\'0:eof\';"; //$NON-NLS-1$

	public static final String STRIKETHROUGH = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Strikethrough',false);"; //$NON-NLS-1$

	public static final String JUSTIFYCENTER = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','JustifyCenter',false);"; //$NON-NLS-1$

	public static final String JUSTIFYRIGHT = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','JustifyRight',false);"; //$NON-NLS-1$

	public static final String JUSTIFYFULL = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','JustifyFull',false);"; //$NON-NLS-1$

	public static final String BULLIST = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','InsertUnorderedList',false);"; //$NON-NLS-1$

	public static final String NUMLIST = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','InsertOrderedList',false);"; //$NON-NLS-1$

	public static final String OUTDENT = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Outdent',false);"; //$NON-NLS-1$

	public static final String INDENT = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Indent',false);"; //$NON-NLS-1$

	public static final String SUP = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','superscript',false);"; //$NON-NLS-1$

	public static final String SUB = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','subscript',false);"; //$NON-NLS-1$

	public static String FONTSIZE(final String value) {
		return "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\',\'FontSize\',false,\'" + value + "\');"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String FONT(final String value) {
		return "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\',\'FontName\',false,\'" + value + "\');"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String FORMAT(final String value) {
		return "javascript:tinyMCE.execInstanceCommand(\'mce_editor_0\',\'FormatBlock\',false,\'" + value + "\');"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String INSERT_IMAGE(final String source, final String alt,
			final String border, final String hspace, final String vspace,
			final String width, final String height, final String align) {
		StringBuffer returnValue = new StringBuffer("javascript:") //$NON-NLS-1$
				.append("TinyMCE_AdvancedTheme._insertImage(") //$NON-NLS-1$
				.append("\'").append(source).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(alt).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(border).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(hspace).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(vspace).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(width).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(height).append("\',") //$NON-NLS-1$ //$NON-NLS-2$
				.append("\'").append(align).append("\');"); //$NON-NLS-1$ //$NON-NLS-2$
		return returnValue.toString();
	}

	public static String INSERT_ANCHOR(final String name) {
		return "javascript:_bridge_insertAnchor(\'" + name + "\');"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String INSERT_LINK(final String href, final String title,
			final String target, final String clazz) {
		StringBuffer returnValue = new StringBuffer("javascript:") //$NON-NLS-1$
				.append("TinyMCE_AdvancedTheme._insertLink(") //$NON-NLS-1$
				.append("\'").append(href).append("\',") //$NON-NLS-1$ //$NON-NLS-2$ 
				.append("\'").append(target).append("\',") //$NON-NLS-1$ //$NON-NLS-2$ 
				.append("\'").append(title).append("\',") //$NON-NLS-1$ //$NON-NLS-2$ 
				.append("\'").append("").append("\',") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
				.append("\'").append(clazz).append("\');"); //$NON-NLS-1$ //$NON-NLS-2$
		return returnValue.toString();
	}

	public static String SET_HTML(final String html) {
		StringBuffer returnValue = new StringBuffer("javascript:") //$NON-NLS-1$
				.append("tinyMCE.setContent(\'") //$NON-NLS-1$
				.append(html.replaceAll("\\'", "\\\\'").replaceAll("\\s", " ")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				.append("\');"); //$NON-NLS-1$
		return returnValue.toString();
	}

	public static final String UNLINK = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','unlink',false);"; //$NON-NLS-1$

	public static final String CLEANUP = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceCleanup',false);"; //$NON-NLS-1$

	public static final String HR = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','inserthorizontalrule',false);"; //$NON-NLS-1$

	public static final String REMOVE_FORMAT = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','removeformat',false);"; //$NON-NLS-1$

	public static final String UNDO = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Undo',false);"; //$NON-NLS-1$;

	public static final String REDO = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','Redo',false);"; //$NON-NLS-1$;

	public static final String INSERT_LAYER = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceInsertLayer',true);"; //$NON-NLS-1$;

	public static final String LAYER_MOVE_FORWAD = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceMoveForward',true);"; //$NON-NLS-1$;

	public static final String LAYER_MOVE_BACKWARD = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceMoveBackward',true);"; //$NON-NLS-1$;

	public static final String LAYER_ABSOLUTE = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceMakeAbsolute',true);"; //$NON-NLS-1$;

	public static final String INSERT_NBSP = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceNonBreaking',false);"; //$NON-NLS-1$;

	public static final String INSERT_ROW_BEFORE = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableInsertRowBefore',false);"; //$NON-NLS-1$

	public static final String INSERT_ROW_AFTER = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableInsertRowAfter',false);"; //$NON-NLS-1$

	public static final String DELETE_ROW = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableDeleteRow',false);"; //$NON-NLS-1$

	public static final String INSERT_COLUMN_BEFORE = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableInsertColBefore',false);"; //$NON-NLS-1$

	public static final String INSERT_COLUMN_AFTER = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableInsertColAfter',false);"; //$NON-NLS-1$

	public static final String DELETE_COLUMN = "javascript:tinyMCE.execInstanceCommand('mce_editor_0','mceTableDeleteCol',false);"; //$NON-NLS-1$

	public static String FORECOLOR(RGB rgb) {
		StringBuffer returnValue = new StringBuffer("javascript:") //$NON-NLS-1$
				.append(
						"tinyMCE.execInstanceCommand('mce_editor_0','ForeColor',false,\'#") //$NON-NLS-1$
				.append(ColorConverter.convertRgbToHex(rgb)).append("\');"); //$NON-NLS-1$
		return returnValue.toString();

	}

	public static String BACKCOLOR(RGB rgb) {
		StringBuffer returnValue = new StringBuffer("javascript:") //$NON-NLS-1$
				.append(
						"tinyMCE.execInstanceCommand('mce_editor_0','BackColor',false,\'#") //$NON-NLS-1$
				.append(ColorConverter.convertRgbToHex(rgb)).append("\');"); //$NON-NLS-1$
		return returnValue.toString();

	}

	public static String INSERT_EDIT_TABLE(String cellpadding,
			String cellspacing, String align, String clazz, String style,
			String id) {
		StringBuffer returnValue = new StringBuffer(
				"javascript:_bridgeInsertEditTable(\'") //$NON-NLS-1$
				.append(cellpadding)
				.append("\',\'").append(cellspacing).append("\',\'0\',\'").append(align) //$NON-NLS-1$ //$NON-NLS-2$
				.append("\',\'").append(clazz).append("\',\'").append(style).append("\',\'").append(id).append("\');"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		return returnValue.toString();
	}

}
