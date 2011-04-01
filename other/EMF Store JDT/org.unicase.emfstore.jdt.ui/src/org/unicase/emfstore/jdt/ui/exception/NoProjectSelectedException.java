/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.ui.exception;

/**
 * This exception is intended to be used with the SelectionDialog. If no project has been selected (a selection could
 * also point to a server entry) this exception will be thrown.
 * 
 * @author Adrian Staudt
 */
@SuppressWarnings("serial")
public class NoProjectSelectedException extends Exception {

}
