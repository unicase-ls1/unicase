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
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;

/**
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class InsertLayerAction extends Action {

	private HtmlComposer composer = null;

	public InsertLayerAction(HtmlComposer composer) {
		super("", IAction.AS_PUSH_BUTTON); //$NON-NLS-1$
		setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("org.unicase.ui.meeditor", //$NON-NLS-1$
						"tiny_mce/jscripts/tiny_mce/plugins/layer/images/insert_layer.gif")); //$NON-NLS-1$
		this.composer = composer;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		this.composer.execute(JavaScriptCommands.INSERT_LAYER);

	}

}
