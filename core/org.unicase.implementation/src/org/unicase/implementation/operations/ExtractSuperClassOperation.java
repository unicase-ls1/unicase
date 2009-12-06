/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Extract Super Class Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses <em>Sub Classes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage <em>Target Package</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses <em>Super Super Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore documentation='Extract attributes and associations from a number of classes into a common super class.'"
 * @generated
 */
public interface ExtractSuperClassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Classes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_SubClasses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelElementId> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getAttributes();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_Associations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getAssociations();

	/**
	 * Returns the value of the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class Name</em>' attribute.
	 * @see #setSuperClassName(String)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_SuperClassName()
	 * @model required="true"
	 * @generated
	 */
	String getSuperClassName();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class Name</em>' attribute.
	 * @see #getSuperClassName()
	 * @generated
	 */
	void setSuperClassName(String value);

	/**
	 * Returns the value of the '<em><b>Target Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Package</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Package</em>' containment reference.
	 * @see #setTargetPackage(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_TargetPackage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getTargetPackage();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage <em>Target Package</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Package</em>' containment reference.
	 * @see #getTargetPackage()
	 * @generated
	 */
	void setTargetPackage(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Super Super Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Super Classes</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Super Classes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_SuperSuperClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getSuperSuperClasses();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getSubClasses());'"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getSubClasses(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getAttributes());'"
	 * @generated
	 */
	EList<Attribute> getAttributes(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Attribute> getPossibleAttributes(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getAssociations());'"
	 * @generated
	 */
	EList<Association> getAssociations(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleAssociations(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getTargetPackage());'"
	 * @generated
	 */
	org.unicase.model.classes.Package getTargetPackage(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getSuperSuperClasses());'"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getSuperSuperClasses(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getPossibleSuperSuperClasses(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore documentation='A class or enumeration with that name already exists.'"
	 * @generated
	 */
	boolean validateSuperClassName(Project project);

} // ExtractSuperClassOperation
