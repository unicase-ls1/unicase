/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Package</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.classes.Package#getContainedPackageElements <em>Contained Package Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.classes.ClassesPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Contained Package Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.classes.PackageElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.classes.PackageElement#getParentPackage <em>Parent Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Package Elements</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Package Elements</em>' containment reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getPackage_ContainedPackageElements()
	 * @see org.unicase.model.classes.PackageElement#getParentPackage
	 * @model opposite="parentPackage" containment="true"
	 * @generated
	 */
	EList<PackageElement> getContainedPackageElements();

} // Package
