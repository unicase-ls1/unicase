/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.semantic;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Extract To Superclass Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSuperClassName
 * <em>Super Class Name</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSubClasses
 * <em>Sub Classes</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getFeatures <em>
 * Features</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getTargetPackage
 * <em>Target Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage#getExtractToSuperclassOperation()
 * @model
 * @generated
 */
public interface ExtractToSuperclassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Super Class Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class Name</em>' attribute.
	 * @see #setSuperClassName(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage#getExtractToSuperclassOperation_SuperClassName()
	 * @model
	 * @generated
	 */
	String getSuperClassName();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSuperClassName
	 * <em>Super Class Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Super Class Name</em>' attribute.
	 * @see #getSuperClassName()
	 * @generated
	 */
	void setSuperClassName(String value);

	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Classes</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage#getExtractToSuperclassOperation_SubClasses()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage#getExtractToSuperclassOperation_Features()
	 * @model
	 * @generated
	 */
	EList<ModelElementId> getFeatures();

	/**
	 * Returns the value of the '<em><b>Target Package</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Package</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Package</em>' reference.
	 * @see #setTargetPackage(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage#getExtractToSuperclassOperation_TargetPackage()
	 * @model
	 * @generated
	 */
	ModelElementId getTargetPackage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getTargetPackage
	 * <em>Target Package</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target Package</em>' reference.
	 * @see #getTargetPackage()
	 * @generated
	 */
	void setTargetPackage(ModelElementId value);

} // ExtractToSuperclassOperation
