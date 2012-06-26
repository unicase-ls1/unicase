/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enumeration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.classes.Enumeration#getLiterals <em>Literals</em>}</li>
 * <li>{@link org.unicase.model.classes.Enumeration#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.classes.ClassesPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Literal}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Literal#getEnumeration <em>Enumeration</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getEnumeration_Literals()
	 * @see org.unicase.model.classes.Literal#getEnumeration
	 * @model opposite="enumeration" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Attribute}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.Attribute#getImplementationEnumeration <em>Implementation Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.unicase.model.classes.ClassesPackage#getEnumeration_Attributes()
	 * @see org.unicase.model.classes.Attribute#getImplementationEnumeration
	 * @model opposite="implementationEnumeration"
	 * @generated
	 */
	EList<Attribute> getAttributes();

} // Enumeration
