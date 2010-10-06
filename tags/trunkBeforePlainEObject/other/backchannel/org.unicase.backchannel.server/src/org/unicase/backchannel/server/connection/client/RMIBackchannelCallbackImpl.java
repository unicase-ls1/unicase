/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.server.connection.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.backchannel.server.BackchannelConfiguration;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Implementation of {@link RMIBackchannelCallback}.
 * 
 * @author wesendon
 */
public class RMIBackchannelCallbackImpl extends UnicastRemoteObject implements
		RMIBackchannelCallback {

	private static final long serialVersionUID = 6877646068571055517L;

	private transient EMFStoreEventListener listener;

	/**
	 * Default constructor.
	 * 
	 * @param listener client side listener which will be notified
	 * @throws RemoteException in case of failure
	 */
	public RMIBackchannelCallbackImpl(EMFStoreEventListener listener)
			throws RemoteException {
		super(BackchannelConfiguration
				.getNumberProperty(
						BackchannelConfiguration.BACKCHANNEL_RMI_PORT,
						BackchannelConfiguration.BACKCHANNEL_RMI_PORT_DEFAULT)+2);
		this.listener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean handleEvent(String event) throws RemoteException,
			EmfStoreException {
		return listener.handleEvent((ServerEvent) SerializationUtil
				.stringToEObject(event));
	}

}
