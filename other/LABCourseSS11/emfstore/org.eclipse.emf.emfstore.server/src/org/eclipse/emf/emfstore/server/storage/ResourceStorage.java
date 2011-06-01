/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.storage;

import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;

/**
 * Represents a Storage based on a Resource.
 * 
 * @author koegel
 */
public interface ResourceStorage {

	/**
	 * Initialize the ResourceStorage.
	 * 
	 * @param properties initalization properties
	 * @return the Resource URI
	 * @throws FatalEmfStoreException if init fails
	 */
	URI init(Properties properties) throws FatalEmfStoreException;

}
