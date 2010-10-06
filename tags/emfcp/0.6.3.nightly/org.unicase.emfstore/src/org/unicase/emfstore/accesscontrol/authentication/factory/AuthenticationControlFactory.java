/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication.factory;

import org.unicase.emfstore.accesscontrol.authentication.AbstractAuthenticationControl;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * Factory interface for creating authenticationcontroller.
 * 
 * @author wesendon
 */
public interface AuthenticationControlFactory {

	/**
	 * Creates an authentication controller.
	 * 
	 * @return controller
	 * @throws FatalEmfStoreException in case of failure
	 */
	AbstractAuthenticationControl createAuthenticationControl() throws FatalEmfStoreException;

}
