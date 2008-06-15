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
package org.unicase.ui.meeditor.mecontrols.richtext.actions;

import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.AllActionConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.ComposerStatus;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.EventConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.PropertyConstants;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class InsertColumnAfterAction extends Action implements Listener {
	private HtmlComposer composer = null;

	public InsertColumnAfterAction(HtmlComposer composer) {
		super("", IAction.AS_PUSH_BUTTON);
		setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("org.unicase.ui.meeditor",
						"tiny_mce/jscripts/tiny_mce/plugins/table/images/table_insert_col_after.gif"));
		this.composer = composer;
		this.composer.addListener(EventConstants.INSERT_COLUMN_AFTER, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		this.composer.execute(JavaScriptCommands.INSERT_COLUMN_AFTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		Properties props = (Properties) event.data;
		if (ComposerStatus.NORMAL.equals(props
				.getProperty(PropertyConstants.STATUS))) {
			setEnabled(true);
		} else if (ComposerStatus.DISABLED.equals(props
				.getProperty(PropertyConstants.STATUS))) {
			setEnabled(false);
		} else if (event.type == EventConstants.ALL
				&& AllActionConstants.RESET_ALL.equals(props
						.getProperty(PropertyConstants.COMMAND))) {
			setEnabled(false);
		}
	}

}
