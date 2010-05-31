/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.connection.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * RMI callback object. This class will be sent to the server and be used from
 * the server to send back events.
 * 
 * @author wesendon * 
 */
public interface RMIBackchannelCallback extends Remote {

	/**
	 * Recieves events from the server.
	 * 
	 * @param event event from server
	 * @return true if listener wants to stay connected 
	 * @throws RemoteException in case of connection error
	 * @throws EmfStoreException in case of other failure
	 */
	boolean handleEvent(String event) throws RemoteException,
			EmfStoreException;

}
