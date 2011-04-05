/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Version Spec</b></em>'. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getVersionSpec()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VersionSpec extends EObject {

	VersionSpec HEAD_VERSION = VersioningFactory.eINSTANCE.createHeadVersionSpec();

	String HEAD = "HEAD";

	String BASE = "BASE";

} // VersionSpec
