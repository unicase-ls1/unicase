/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Inline Super Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.implementation.operations.OperationsPackage#getInlineSuperClassOperation()
 * @model annotation=
 *        "http://unicase.org/operations description='A super class is inlined into its sub classes.' label='Inline Super Class'"
 * @generated
 */
public interface InlineSuperClassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class</em>' containment reference.
	 * @see #setSuperClass(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getInlineSuperClassOperation_SuperClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getSuperClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass
	 * <em>Super Class</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Super Class</em>' containment reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(ModelElementId value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getSuperClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getSuperClass(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The super class must have sub classes.'"
	 * @generated
	 */
	boolean validateSuperClassSubClasses(Project project);

} // InlineSuperClassOperation
