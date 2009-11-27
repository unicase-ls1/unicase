/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;

import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IFeature;
import org.unicase.model.implementation.IPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extract Super Class Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses <em>Sub Classes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage <em>Target Package</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses <em>Super Super Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation()
 * @model
 * @generated
 */
public interface ExtractSuperClassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Sub Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Classes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_SubClasses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelElementId> getSubClasses();

	/**
	 * Returns the value of the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class Name</em>' attribute.
	 * @see #getSuperClassName()
	 * @generated
	 */
	void setSuperClassName(String value);

	/**
	 * Returns the value of the '<em><b>Target Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Package</em>' containment reference isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * If the meaning of the '<em>Super Super Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Super Classes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractSuperClassOperation_SuperSuperClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getSuperSuperClasses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getSubClasses());'"
	 * @generated
	 */
	EList<IClass> getSubClasses(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getTargetPackage());'"
	 * @generated
	 */
	IPackage getTargetPackage(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getSuperSuperClasses());'"
	 * @generated
	 */
	EList<IClass> getSuperSuperClasses(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<IClass> getPossibleSuperSuperClasses(Project project);

} // ExtractSuperClassOperation
