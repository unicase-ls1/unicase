/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events.server.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.server.model.versioning.events.impl.EventImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ServerEventImpl extends EventImpl implements ServerEvent {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerPackage.Literals.SERVER_EVENT;
	}

} // ServerEventImpl
