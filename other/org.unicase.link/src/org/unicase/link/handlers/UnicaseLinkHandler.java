/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handlers;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.jface.dialogs.MessageDialog;


import org.unicase.ui.common.util.ActionHelper;
import org.unicase.link.util.LinkDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This handler handles "create unicase link" button click events. 
 * It generates an UNICASE url link to the model element
 * currently shown in the MEEditor
 *  
 * @author svetlana
 */
public class UnicaseLinkHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public UnicaseLinkHandler() {
	}
	
	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 * TODO: insert javadoc for param and return
	 * @param event -insert doc-
	 * @return -insert doc-
	 * @throws ExecutionException -insert doc-
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		ModelElement me = ActionHelper.getModelElement(event);

		//remove spaces from the model element name
		String meName;
		if (me instanceof UnicaseModelElement){
			meName =  ((UnicaseModelElement)me).getName().replaceAll(" ", "");			
		} else {
			//If this is not a unicase model, we use the identifier (whatever this is) as name
			meName = me.getIdentifier();
		}
		
		//ModelElement clone = (ModelElement) EcoreUtil.copy(me);
		
		String meId = me.getModelElementId().getId();
		
		final ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
				
		//remove spaces from the project name
		String projectName = ps.getProjectName().replaceAll(" ", "");
		String projectId = ps.getProjectId().getId();	
		
		String serverUrl  = ps.getUsersession().getServerInfo().getUrl();
		int serverPort = ps.getUsersession().getServerInfo().getPort();
		
		//String info = "Link was copied to the clipboard! ";
		String link = "unicase://" + serverUrl + ":" + serverPort + "/" + projectName + "%" 
			+ projectId + "/" + meName + "%" + meId;

		//place the link on the system clipboard
		StringSelection stringSelection = new StringSelection(link);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		Display display = Display.getCurrent();
		LinkDialog dlg = new LinkDialog(display.getActiveShell(), 
				"The link has been copied to the clipboard.", link);
		dlg.open();
		return null;
	}
}
