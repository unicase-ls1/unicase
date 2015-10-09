/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Inline Super Class Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getInlineSuperClassOperation()
 * @model annotation="http://unicase.org/operations description='A super class is inlined into its sub classes.' label='Inline Super Class'"
 * @generated
 */
public interface InlineSuperClassOperation extends org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' containment reference.
	 * @see #setSuperClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getInlineSuperClassOperation_SuperClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.eclipse.emf.emfstore.internal.common.model.ModelElementId getSuperClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass <em>Super Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' containment reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getSuperClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getSuperClass(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The super class must have sub classes.'"
	 * @generated
	 */
	boolean validateSuperClassSubClasses(org.eclipse.emf.emfstore.internal.common.model.Project project);

} // InlineSuperClassOperation
