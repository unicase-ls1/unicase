/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IFeature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IFeature#getMinimumMultiplicity <em>Minimum Multiplicity</em>}</li>
 * <li>{@link org.unicase.model.implementation.IFeature#getMaximumMultiplicity <em>Maximum Multiplicity</em>}</li>
 * <li>{@link org.unicase.model.implementation.IFeature#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIFeature()
 * @model abstract="true"
 * @generated
 */
public interface IFeature extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Minimum Multiplicity</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Multiplicity</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Minimum Multiplicity</em>' attribute.
	 * @see #setMinimumMultiplicity(int)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIFeature_MinimumMultiplicity()
	 * @model
	 * @generated
	 */
	int getMinimumMultiplicity();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IFeature#getMinimumMultiplicity
	 * <em>Minimum Multiplicity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Minimum Multiplicity</em>' attribute.
	 * @see #getMinimumMultiplicity()
	 * @generated
	 */
	void setMinimumMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Maximum Multiplicity</b></em>' attribute. The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Multiplicity</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Maximum Multiplicity</em>' attribute.
	 * @see #setMaximumMultiplicity(int)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIFeature_MaximumMultiplicity()
	 * @model default="1"
	 * @generated
	 */
	int getMaximumMultiplicity();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IFeature#getMaximumMultiplicity
	 * <em>Maximum Multiplicity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Maximum Multiplicity</em>' attribute.
	 * @see #getMaximumMultiplicity()
	 * @generated
	 */
	void setMaximumMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIFeature_Transient()
	 * @model
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IFeature#isTransient <em>Transient</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

} // IFeature
