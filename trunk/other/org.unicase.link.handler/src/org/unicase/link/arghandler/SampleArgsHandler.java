/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.arghandler;

import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * TODO: Javadoc.
 * @author -insert author-
 *
 */
public class SampleArgsHandler implements IArgsHandler {

	/**
	 * The constructor.
	 */
	public SampleArgsHandler() {
	}

	/**
	 * TODO: javadoc.
	 * @param args -insert doc-
	 */
	@Override
	public void handleArguments(String args) {
		//StrBuilder stringBuilder= new StrBuilder();
		//stringBuilder.appendWithSeparators(args," + ");
		MessageDialog.openInformation(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), "Incomming Args",
				"Incomming: " + args);
	}

}
