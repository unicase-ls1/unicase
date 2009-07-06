/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Model Change Package</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.change.ModelChangePackage#getSourceVersion <em>Source Version</em>}</li>
 *   <li>{@link org.unicase.model.change.ModelChangePackage#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.change.ChangePackage#getModelChangePackage()
 * @model
 * @generated
 */
public interface ModelChangePackage extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Source Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Version</em>' attribute.
	 * @see #setSourceVersion(int)
	 * @see org.unicase.model.change.ChangePackage#getModelChangePackage_SourceVersion()
	 * @model
	 * @generated
	 */
	int getSourceVersion();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.ModelChangePackage#getSourceVersion <em>Source Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Source Version</em>' attribute.
	 * @see #getSourceVersion()
	 * @generated
	 */
	void setSourceVersion(int value);

	/**
	 * Returns the value of the '<em><b>Target Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Version</em>' attribute.
	 * @see #setTargetVersion(int)
	 * @see org.unicase.model.change.ChangePackage#getModelChangePackage_TargetVersion()
	 * @model
	 * @generated
	 */
	int getTargetVersion();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.ModelChangePackage#getTargetVersion <em>Target Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Target Version</em>' attribute.
	 * @see #getTargetVersion()
	 * @generated
	 */
	void setTargetVersion(int value);

} // ModelChangePackage
