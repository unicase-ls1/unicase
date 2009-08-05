/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getFeatureOperation()
 * @model abstract="true"
 * @generated
 */
public interface FeatureOperation extends AbstractOperation {
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getFeatureOperation_FeatureName()
	 * @model default=""
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureName
	 * <em>Feature Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

} // FeatureOperation
