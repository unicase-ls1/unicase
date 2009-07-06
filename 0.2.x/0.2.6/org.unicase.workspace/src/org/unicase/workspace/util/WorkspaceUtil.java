/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.workspace.util;

import java.util.Date;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.workspace.Activator;
import org.unicase.workspace.ProjectSpace;

/**
 * Workspace utility class.
 * @author koegel
 *
 */
public final class WorkspaceUtil {
	
	/**
	 * Private constructor.
	 */
	private WorkspaceUtil() {
		//nothing to do
	}
	
	/**
	 * Log an exception to the error log.
	 * @param message the message
	 * @param e the exception
	 */
	public static void logException(String message, Exception e) {
		Activator activator = Activator.getDefault();
		Status status = new Status(IStatus.ERROR,
			      activator.getBundle().getSymbolicName(),
			      IStatus.ERROR, message, e);
		activator.getLog().log(status);
	}
	
	/**
	 * Log a checkout event to the current projectSpace.
	 * @param projectSpace the project space
	 * @param baseVersion the base version that was checked out
	 */
	public static void logCheckout(ProjectSpace projectSpace, PrimaryVersionSpec baseVersion) {
		CheckoutEvent checkoutEvent = EventsFactory.eINSTANCE.createCheckoutEvent();
		checkoutEvent.setBaseVersion((PrimaryVersionSpec) EcoreUtil.copy(baseVersion));
		checkoutEvent.setTimestamp(new Date());
		projectSpace.addEvent(checkoutEvent);
	}
}
