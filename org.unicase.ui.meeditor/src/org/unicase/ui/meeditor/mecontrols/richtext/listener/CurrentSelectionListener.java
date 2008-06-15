/*******************************************************************************
 * Copyright (c) 2007 Tom Seidel, Spirit Link GmbH
 * All rights reserved.
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.listener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.AllActionConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.EventConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class CurrentSelectionListener implements Listener {

	private HtmlComposer composer;
	private Text textField;

	public CurrentSelectionListener(HtmlComposer composer, Text textField) {
		this.composer = composer;
		this.textField = textField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		if (event.type == EventConstants.CURRENT_TEXT_SELECTION) {
			this.textField.setText(event.text);

		} else if (event.type == EventConstants.ALL
				&& event.text.equals(AllActionConstants.RESET_ALL)) {
			this.textField.setText(""); //$NON-NLS-1$
		}

	}

}
