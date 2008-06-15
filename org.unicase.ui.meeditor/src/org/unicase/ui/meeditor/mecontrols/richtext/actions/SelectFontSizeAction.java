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
package org.unicase.ui.meeditor.mecontrols.richtext.actions;

import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
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
public class SelectFontSizeAction extends Action implements Listener {

	private HtmlComposer composer = null;
	private Combo target;

	public SelectFontSizeAction(HtmlComposer composer, Combo target) {
		super("", IAction.AS_PUSH_BUTTON);
		this.composer = composer;
		this.composer.addListener(EventConstants.FONTSIZE, this);
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		this.composer.execute(JavaScriptCommands
				.FONTSIZE(this.target.getText()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		Properties evtProps = (Properties) event.data;
		if (event.type != EventConstants.ALL
				&& !ComposerStatus.UNDEFINED.equals(evtProps
						.getProperty(PropertyConstants.VALUE))) {
			for (int i = 0, n = this.target.getItems().length; i < n; i++) {
				if (this.target.getItem(i).equals(
						evtProps.getProperty(PropertyConstants.VALUE))) {
					this.target.select(i);
					break;
				}
			}
		} else {
			this.target.select(0);
		}
	}

}
