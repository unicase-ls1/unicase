/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.emf.resource;

import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * A ResourceSet implementation to be able to load resources directly from an EMF Store.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreResourceSet extends ResourceSetImpl {

	@Override
	public Registry getResourceFactoryRegistry() {
		return new EMFStoreResourceFactoryRegistry();
	}
}
