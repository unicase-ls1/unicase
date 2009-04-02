/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import java.util.HashMap;
import java.util.Set;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidInputException;
import org.unicase.model.ModelElement;

/**
 * Super class of all EmfstoreInterfaces. Provides general methods for accesscontrol and delegation to the
 * subinterfaces.
 * 
 * @author wesendon
 */
public abstract class AbstractEmfstoreInterface {

	private AuthorizationControl authorizationControl;
	private HashMap<Class<? extends AbstractSubEmfstoreInterface>, AbstractSubEmfstoreInterface> subInterfaces;
	private boolean accessControlDisabled;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace the serverspace
	 * @param authorizationControl accesscontrol
	 * @throws FatalEmfStoreException if initialization fails
	 */
	public AbstractEmfstoreInterface(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		if (serverSpace == null || authorizationControl == null) {
			throw new FatalEmfStoreException();
		}
		this.authorizationControl = authorizationControl;
		accessControlDisabled = false;
		initSubInterfaces(serverSpace);
	}

	private void initSubInterfaces(ServerSpace serverSpace) {
		subInterfaces = new HashMap<Class<? extends AbstractSubEmfstoreInterface>, AbstractSubEmfstoreInterface>();

		initAdditionalSubInterfaces();
	}

	/**
	 * Returns list of subinterfaces.
	 * 
	 * @return list of subinterfaces
	 */
	public HashMap<Class<? extends AbstractSubEmfstoreInterface>, AbstractSubEmfstoreInterface> getSubInterfaces() {
		return subInterfaces;
	}

	/**
	 * Returns the requested subinterface if available.
	 * 
	 * @param <T> subinterface type
	 * @param clazz subinterface class type
	 * @return subinterface
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSubInterface(Class<T> clazz) {
		return (T) subInterfaces.get(clazz);
	}

	/**
	 * Override this method in order to add additional subinterfaces.
	 */
	public void initAdditionalSubInterfaces() {
	}

	/**
	 * Checks read access.
	 * 
	 * @see AuthorizationControl#checkReadAccess(SessionId, ProjectId, Set)
	 * @param sessionId sessionid
	 * @param projectId project id
	 * @param modelElements modelelemnts
	 * @throws AccessControlException access exception
	 */
	public synchronized void checkReadAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements)
		throws AccessControlException {
		if (accessControlDisabled) {
			return;
		}
		authorizationControl.checkReadAccess(sessionId, projectId, modelElements);
	}

	/**
	 * Checks write access.
	 * 
	 * @see AuthorizationControl#checkWriteAccess(SessionId, ProjectId, Set)
	 * @param sessionId sessionid
	 * @param projectId project id
	 * @param modelElements modelelemnts
	 * @throws AccessControlException access exception
	 */
	public synchronized void checkWriteAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements)
		throws AccessControlException {
		if (accessControlDisabled) {
			return;
		}
		authorizationControl.checkWriteAccess(sessionId, projectId, modelElements);
	}

	/**
	 * Checks project admin access.
	 * 
	 * @see AuthorizationControl#checkProjectAdminAccess(SessionId, ProjectId)
	 * @param sessionId sessionid
	 * @param projectId project id
	 * @throws AccessControlException access exception
	 */
	public synchronized void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId)
		throws AccessControlException {
		if (accessControlDisabled) {
			return;
		}
		authorizationControl.checkProjectAdminAccess(sessionId, projectId);
	}

	/**
	 * Checks server admin access.
	 * 
	 * @see AuthorizationControl#checkServerAdminAccess(SessionId)
	 * @param sessionId sessionid
	 * @throws AccessControlException access exception
	 */
	public synchronized void checkServerAdminAccess(SessionId sessionId) throws AccessControlException {
	}

	/**
	 * Applys a sanity check {@link #sanityCheckObject(Object)} to all given objects.
	 * 
	 * @param objects objects to check
	 * @throws InvalidInputException is thrown if the check fails
	 */
	public void sanityCheckObjects(Object[] objects) throws InvalidInputException {
		for (Object object : objects) {
			sanityCheckObject(object);
		}
	}

	/**
	 * Checks whether a given object is null. Further sanity checks could be added. <strong>Note:</strong> Maybe we
	 * should use specialized sanity checks for EObjects or other types.
	 * 
	 * @param object object to check
	 * @throws InvalidInputException is thrown if the check fails
	 */
	public void sanityCheckObject(Object object) throws InvalidInputException {
		if (object == null) {
			throw new InvalidInputException();
		}
	}

	/**
	 * Runs an internal command, in order to avoid accesscontrol.
	 * 
	 * @param command internal command
	 */
	public synchronized void runCommand(InternalCommand<? extends AbstractEmfstoreInterface> command) {
		accessControlDisabled = true;
		command.setInterface(this);
		command.doExecute();
		accessControlDisabled = false;
	}

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
	}
}
