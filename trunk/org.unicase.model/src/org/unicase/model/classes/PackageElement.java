/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Package Element</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.classes.PackageElement#getParentPackage <em>
 * Parent Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.classes.ClassesPackage#getPackageElement()
 * @model abstract="true"
 * @generated
 */
public interface PackageElement extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Parent Package</b></em>' container
	 * reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Package#getContainedPackageElements
	 * <em>Contained Package Elements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Package</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Package</em>' container reference.
	 * @see #setParentPackage(org.unicase.model.classes.Package)
	 * @see org.unicase.model.classes.ClassesPackage#getPackageElement_ParentPackage()
	 * @see org.unicase.model.classes.Package#getContainedPackageElements
	 * @model opposite="containedPackageElements" transient="false"
	 *        derived="true"
	 * @generated
	 */
	org.unicase.model.classes.Package getParentPackage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.classes.PackageElement#getParentPackage
	 * <em>Parent Package</em>}' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent Package</em>' container
	 *            reference.
	 * @see #getParentPackage()
	 * @generated
	 */
	void setParentPackage(org.unicase.model.classes.Package value);

} // PackageElement
