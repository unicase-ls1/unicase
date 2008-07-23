/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.change.FeatureChange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureChange <em>Feature Change</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getFeatureOperation()
 * @model
 * @generated
 */
public interface FeatureOperation extends AtomicOperation {
	/**
	 * Returns the value of the '<em><b>Feature Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Change</em>' reference.
	 * @see #setFeatureChange(FeatureChange)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getFeatureOperation_FeatureChange()
	 * @model
	 * @generated
	 */
	FeatureChange getFeatureChange();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureChange <em>Feature Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Change</em>' reference.
	 * @see #getFeatureChange()
	 * @generated
	 */
	void setFeatureChange(FeatureChange value);

} // FeatureOperation
