/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class UnicaseLogAdapter {

	public void log(String message, Exception exception, int statusInt) {
		Status status = new Status(statusInt, Activator.getDefault().getBundle().getSymbolicName(), statusInt, message, exception);
		 Activator.getDefault().getLog().log(status);
	}

	public void logException(String message, Exception e) {
		log(message, e, IStatus.ERROR);
	}

	public void logWarning(String message, Exception e) {
		log(message, e, IStatus.WARNING);
	}
	
}
