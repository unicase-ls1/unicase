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
package org.unicase.ui.meeditor.mecontrols.richtext.widgets;

import java.util.Properties;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
class GetHtmlHandler implements Listener {

	String html = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		Properties evtProps = (Properties) event.data;
		if (evtProps.getProperty(PropertyConstants.COMMAND).equals(
				AllActionConstants.GET_HTML)) {
			this.html = evtProps.getProperty(PropertyConstants.VALUE) == null ? "" : evtProps.getProperty(PropertyConstants.VALUE); //$NON-NLS-1$

		}

	}

	public String getHtml() {
		getDisplay().syncExec(new Runnable() {
			public void run() {
				while (GetHtmlHandler.this.html == null) {
					// wait
				}
			}
		});
		return this.html;
	}

	private Display getDisplay() {
		if (Display.getCurrent() != null) {
			return Display.getCurrent();
		}
		return Display.getDefault();
	}

}
