/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.configuration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationPackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.VersionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Version Mapping</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.VersionMappingImpl#getTeamProviderRevision <em>Team Provider
 * Revision</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.teamprovider.configuration.impl.VersionMappingImpl#getEMFStoreRevision <em>EMF Store Revision
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class VersionMappingImpl extends EObjectImpl implements VersionMapping {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VersionMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.VERSION_MAPPING;
	}

} // VersionMappingImpl
