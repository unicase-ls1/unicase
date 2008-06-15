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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.unicase.ui.meeditor.mecontrols.richtext.dialogs.ImageDialog;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.EventConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class InsertEditImageAction extends Action implements Listener {

	private HtmlComposer composer = null;
	private String source = null;
	private String alt = null;
	private String border = null;
	private String hsapce = null;
	private String vspace = null;
	private String width = null;
	private String height = null;
	private String align = null;

	public InsertEditImageAction(HtmlComposer composer) {
		super("", IAction.AS_CHECK_BOX);
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.unicase.ui.meeditor",
				"tiny_mce/jscripts/tiny_mce/themes/advanced/images/image.gif"));
		this.composer = composer;
		this.composer.addListener(EventConstants.IMAGE, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ImageDialog dialog = new ImageDialog(this.composer.getShell(),
				this.source, this.alt, this.border, this.hsapce, this.vspace,
				this.width, this.height, this.align);
		if (dialog.open() == IDialogConstants.OK_ID) {
			this.composer.execute(JavaScriptCommands.INSERT_IMAGE(dialog
					.getSource(), dialog.getAlt(), dialog.getBorder(), dialog
					.getHspace(), dialog.getVspace(), dialog.getWidth(), dialog
					.getHeight(), dialog.getAlign()));
		}
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
		if (event.type != EventConstants.ALL) {
			setChecked(true);
			this.source = evtProps.getProperty("src"); //$NON-NLS-1$
			this.width = evtProps.getProperty("width"); //$NON-NLS-1$
			this.height = evtProps.getProperty("height"); //$NON-NLS-1$
			this.border = evtProps.getProperty("border"); //$NON-NLS-1$
			this.alt = evtProps.getProperty("alt"); //$NON-NLS-1$
			this.align = evtProps.getProperty("align"); //$NON-NLS-1$
			this.hsapce = evtProps.getProperty("hspace"); //$NON-NLS-1$
			this.vspace = evtProps.getProperty("vspace"); //$NON-NLS-1$
		} else {
			setChecked(false);
			this.source = null;
			this.alt = null;
			this.border = null;
			this.hsapce = null;
			this.vspace = null;
			this.width = null;
			this.height = null;
			this.align = null;
		}
	}

}
