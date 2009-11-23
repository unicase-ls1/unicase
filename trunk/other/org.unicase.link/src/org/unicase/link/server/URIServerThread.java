/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Thread which is responsible for processing the client unicase client request
 * and displaying the according model element by setting off a request to 
 * the eclipse UI thread.
 * 
 * @author emueller, jfinis
 *
 */
public class URIServerThread extends Thread {
	
	private static final String EXTERNAL_URL = "EXTERNAL_URL"; 
	
	private Socket clientSocket;
	
	/**
	 * Writer that will be used to send messages to the client. 
	 */
	private PrintWriter writer;
	
	/**
	 * Reader to read the client's requests.
	 */
	private BufferedReader reader;
		
	/**
	 * Initializes a new instance of a server thread.
	 * 
	 * @param socket Socket, that will be used to read the client's request.
	 */
	public URIServerThread(Socket socket) {
		super("URIServerThread " + socket.getPort());
		clientSocket = socket;
	}
	
	/**
	 * Starts the URI Server thread.
	 */
	public void run() {
		try {
			String inputLine, outputLine;
			
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			reader = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			
			// indicate the client, that we are ready to process the request
			outputLine = "sendAction";
			writer.println(outputLine);
			
			// read the client's request
			inputLine = reader.readLine();
			ModelElementUrl url = UrlFactoryImpl.eINSTANCE
				.createModelElementUrl(inputLine);
			
			try {
				Set<ProjectSpace> set = WorkspaceManager.getInstance()
					.getCurrentWorkspace().resolve(url.getProjectUrlFragment());
				
				if (!set.isEmpty()) {
					
					// fetch latest project
					ProjectSpace currProjectSpace = null;
					currProjectSpace = set.iterator().next();
					
					for (ProjectSpace space : set) {
						Date lastUpdated = space.getLastUpdated();
						Date currProjectDate = currProjectSpace.getLastUpdated();
						
						if (lastUpdated.after(currProjectDate)) {
							currProjectSpace = space;
						}
					}
					
					EList<ModelElement> models = 
						currProjectSpace.getProject().getAllModelElements();
					
					for (final ModelElement e : models) {
						if (e.getIdentifier().equals(
								url.getModelElementUrlFragment().getModelElementId().getId())) {
							// when the according element is found, open it 
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									ActionHelper.openModelElement(e, EXTERNAL_URL);
								}});
						}
					}
				} else {					
					// inform client, that the project is not available
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							MessageDialog.openError(Display.getDefault().getActiveShell(),
									"Project not found.",
									"The project you have requested is not available.\n"
									+ "Maybe you did not yet check it out?");
						}
					});
				}
								
			} catch (ProjectUrlResolutionException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		} catch (IOException exc) {
			WorkspaceUtil.logException(exc.getMessage(), exc);
		} finally {
			writer.close();
			try {
				reader.close();
				clientSocket.close();
			} catch (IOException exc2) {
				WorkspaceUtil.logException(exc2.getMessage(), exc2);
			}
		}
	}
}
