/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Display;
import org.unicase.link.util.ui.LinkDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class handles "create unicase link" button click events. It generates a UNICASE url for the selected model
 * element, copies it to clipboard and shows a popup.
 * 
 * @author svetlana, jfinis, kami
 */
public class UnicaseLinkHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public UnicaseLinkHandler() {
	}

	/**
	 * Execute the UnicaseLinkCommand which displays the UNICASE URL of the selected model element in a popup window and
	 * copies it to clipboard. The method first assembles the link, then copies it to clipboard and opens the popup.
	 * 
	 * @param event the event to handled
	 * @return nothing (null)
	 */
	public Object execute(ExecutionEvent event) {

		ModelElement me = ActionHelper.getModelElement(event);

		// remove spaces from the model element name
		String meName;
		if (me instanceof UnicaseModelElement) {
			meName = ((UnicaseModelElement) me).getName().replaceAll(" ", "");
		} else {
			// If this is not a unicase model, we use the identifier (whatever this is) as name
			meName = me.getIdentifier();
		}

		// Get model element id
		String meId = me.getModelElementId().getId();

		final ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();

		// remove spaces from the project name
		String projectName = ps.getProjectName().replaceAll(" ", "");
		String projectId = ps.getProjectId().getId();

		String serverUrl = ps.getUsersession().getServerInfo().getUrl();
		int serverPort = ps.getUsersession().getServerInfo().getPort();

		// Assemble the link
		String link = "unicase://" + serverUrl + ":" + serverPort + "/" + projectName + "%" + projectId + "/" + meName
			+ "%" + meId;

		// place the link on the system clipboard
		StringSelection stringSelection = new StringSelection(link);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		Display display = Display.getCurrent();
		LinkDialog dlg = new LinkDialog(display.getActiveShell(), "The link has been copied to the clipboard.", link);
		dlg.open();
		return null;
	}

}
