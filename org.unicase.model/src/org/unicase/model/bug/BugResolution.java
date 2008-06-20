/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resolution</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.bug.BugResolution#getResoultionType <em>Resoultion Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.bug.BugPackage#getBugResolution()
 * @model
 * @generated
 */
public interface BugResolution extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Resoultion Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.bug.ResolutionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resoultion Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resoultion Type</em>' attribute.
	 * @see org.unicase.model.bug.ResolutionType
	 * @see #setResoultionType(ResolutionType)
	 * @see org.unicase.model.bug.BugPackage#getBugResolution_ResoultionType()
	 * @model
	 * @generated
	 */
	ResolutionType getResoultionType();

	/**
	 * Sets the value of the '{@link org.unicase.model.bug.BugResolution#getResoultionType <em>Resoultion Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Resoultion Type</em>' attribute.
	 * @see org.unicase.model.bug.ResolutionType
	 * @see #getResoultionType()
	 * @generated
	 */
	void setResoultionType(ResolutionType value);

} // BugResolution
