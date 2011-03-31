/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.connection;

// BEGIN IGNORE UNNECCESSARY IMPORT
// import caused by comment
import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.EmfStoreInterface;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;

/**
 * The ConnectionHandler makes the network transport layer transparent for the server. It requires {@link EmfStore} and
 * {@link AuthenticationControl} to delegate the messaeges.
 * 
 * @param <T> server interface type E.g {@link org.eclipse.emf.emfstore.server.EmfStore} or
 *            {@link org.eclipse.emf.emfstore.server.AdminEmfStore}
 * @author Wesendonk
 * @author koegel
 */
public interface ConnectionHandler<T extends EmfStoreInterface> {

	/**
	 * This method initializes the ConnectionHandler.
	 * 
	 * @param emfStore an implementation of a server interface.
	 * @param accessControl an implementation of the {@link AuthenticationControl}
	 * @throws FatalEmfStoreException is thrown if the server can't initialize
	 * @throws EmfStoreException exception within the server
	 */
	void init(T emfStore, AuthenticationControl accessControl) throws FatalEmfStoreException, EmfStoreException;

	/**
	 * Stop the handler.
	 * 
	 * @param force true if handler should be stopped forcefully
	 * @generated NOT
	 */
	void stop(boolean force);

	/**
	 * Return the handler name.
	 * 
	 * @return the name of the handler
	 * @generated NOT
	 */
	String getName();
}
