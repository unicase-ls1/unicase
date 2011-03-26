/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.SessionId;

/**
 * Internal command, in order to avoid accesscontrol.
 * 
 * @param <T> the emfstore interface
 */
public abstract class InternalCommand<T extends AbstractEmfstoreInterface> {
	private T theInterface;

	/**
	 * Sets the interface which runs the command.
	 * 
	 * @param theInterface the emfstore interface
	 */
	@SuppressWarnings("unchecked")
	public void setInterface(AbstractEmfstoreInterface theInterface) {
		this.theInterface = (T) theInterface;
	}

	/**
	 * @return the theInterface
	 */
	public T getInterface() {
		return theInterface;
	}

	/**
	 * Runs the internal command.
	 */
	public abstract void doExecute();

	/**
	 * Generates a fake session id in order to use the emfstore interfaces.
	 * 
	 * @return SessionId
	 */
	protected SessionId fakeSessionId() {
		SessionId sessionId = ModelFactory.eINSTANCE.createSessionId();
		sessionId.setId("-FAKE-");
		return sessionId;
	}
}