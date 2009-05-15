/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.workspace.test;

import java.util.Properties;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Helper class for test fixtures.
 * 
 * @author hodaie
 *
 */
public final class SetupHelper {
	
	
	private static TransactionalEditingDomain domain;
	private static Workspace workSpace;

	private SetupHelper(){
	}
	
	/**
	 * Starts the server.
	 */
	public static void startSever(){
		try {
			ServerConfiguration.setTesting(true);
			Properties properties = ServerConfiguration.getProperties();
			properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.TRUE);
			EmfStoreController.runAsNewThread();
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stops the server.
	 */
	public static void stopServer(){
		
	}
	
	/**
	 * Setups server space.
	 */
	public static void setupSeverSpace(){
		
	}
	
	
	/**
	 * Setups workspace.
	 */
	public static void setupWorkSpace(){
		
		
		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		
		
	}
	
	
	/**
	 * Setups a new project space.
	 */
	public static void setupProjectSpace(){
		
		
		
		
	}
	
	/**
	 * Cleans server up.
	 */
	public static void cleanupServer(){
		
	}
	
	/**
	 * Cleans workspace up.
	 */
	public static void cleanupWorkspace(){
		
	}

	

	/**
	 * 
	 * @return workspace
	 */
	public static Workspace getWorkSpace() {
		return workSpace;
	}
	
	

	/**
	 * 
	 * @return  editing domain
	 */
	public static TransactionalEditingDomain getDomain() {
		return domain;
	}

}
