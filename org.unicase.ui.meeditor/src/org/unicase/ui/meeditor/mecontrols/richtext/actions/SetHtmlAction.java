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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.meeditor.mecontrols.richtext.dialogs.SetHtmlDialog;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;

/**
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class SetHtmlAction extends Action {

	private HtmlComposer composer = null;

	public SetHtmlAction(HtmlComposer composer) {
		super("", IAction.AS_PUSH_BUTTON); //$NON-NLS-1$
		setToolTipText("Set HTML"); //$NON-NLS-1$
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
		this.composer = composer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		SetHtmlDialog dialog = new SetHtmlDialog(this.composer.getShell());
		if (dialog.open() == IDialogConstants.OK_ID) {
			System.out.println(JavaScriptCommands.SET_HTML(dialog.getHtml()));
			this.composer
					.execute(JavaScriptCommands.SET_HTML(dialog.getHtml()));
		}
	}

}
