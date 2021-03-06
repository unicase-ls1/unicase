/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.exception;

/**
 * This exception will be thrown if the given URI cannot be parsed to an EMFStoreJDT-URI.
 * 
 * @author Adrian Staudt
 */
@SuppressWarnings("serial")
public class EMFStoreURIMalformedException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param schema schema protocol
	 * @param specificPath uri path
	 */
	public EMFStoreURIMalformedException(String schema, String specificPath) {
		super("Schema: " + schema + ", specific path: " + specificPath);
	}

}
