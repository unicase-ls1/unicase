/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.action;

/**
 * Exception that can be thrown by client implementations when the leap progress has been cancelled. This is for
 * convenience and hence optional. Throwing this exception makes it possible to handle leap actions in a try-catch-block
 * instead of checking if the progress has been cancelled every time.
 * 
 * @author mharut
 */
public class LeapActionCancelledException extends Exception {

	/**
	 * Generated serial version ID.
	 */
	private static final long serialVersionUID = 3353533438185779820L;

}