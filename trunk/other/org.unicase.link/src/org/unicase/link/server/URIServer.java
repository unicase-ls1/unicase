package org.unicase.link.server;

import java.io.IOException;
import java.net.ServerSocket;
import org.eclipse.ui.IStartup;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A small TCP server that is running locally on each client's machine, and 
 * is responsible for listening and handling unicase-protocol-requests.
 * 
 * For each request it'll spawn an thread which processes the request and
 * then opens according model element.
 * 
 * @author emueller
 */
public class URIServer extends Thread implements IStartup {
	
	// TODO: make this configurable via a preference page
	private static final int PORT = 2008;
	
	/**
	 * Determines whether the server should listen for client requests
	 */
	private boolean isListening = true;
	
	private static URIServer instance = new URIServer();
	
	public static URIServer getInstance() {
		if (instance == null) {
			instance = new URIServer();
		} 
		
		return instance;
	} 
	
	private URIServer() { }
	
	/**
	 * Determines whether the server is listening for client unicase-protocol 
	 * requests.
	 * 
	 * @return True, if the server is listening, else false.
	 */
	public boolean getListeningStatus() {
		return isListening;
	}
	
	/**
	 * 
	 * 
	 * @param shouldListen True, if the server should listen for client 
	 * 		  unicase protocol requests, else false.
	 */
	public void setListeningStatus(boolean shouldListen) {
		
	}

	public void run() {
		ServerSocket serverSocket = null;
				
		try {
			serverSocket = new ServerSocket(PORT);
			
			while (isListening) {
				new URIServerThread(serverSocket.accept()).start();
			}
		} catch (IOException exc) {
			WorkspaceUtil.logException(exc.getMessage(), exc);
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException exc2) {
				WorkspaceUtil.logException(exc2.getMessage(), exc2);
			}
		}
	}

	public void earlyStartup() {
		// start the server immediately after the workbench has been started 
		//instance.start();		
	}
}
