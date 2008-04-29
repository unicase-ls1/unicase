/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.Version#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.esmodel.Version#getPrimarySpec <em>Primary Spec</em>}</li>
 *   <li>{@link org.unicase.esmodel.Version#getTagSpecs <em>Tag Specs</em>}</li>
 *   <li>{@link org.unicase.esmodel.Version#getNextVersion <em>Next Version</em>}</li>
 *   <li>{@link org.unicase.esmodel.Version#getPreviousVersion <em>Previous Version</em>}</li>
 *   <li>{@link org.unicase.esmodel.Version#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.EsmodelPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Project State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project State</em>' reference.
	 * @see #setProjectState(Project)
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_ProjectState()
	 * @model
	 * @generated
	 */
	Project getProjectState();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.Version#getProjectState <em>Project State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project State</em>' reference.
	 * @see #getProjectState()
	 * @generated
	 */
	void setProjectState(Project value);

	/**
	 * Returns the value of the '<em><b>Primary Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Spec</em>' reference.
	 * @see #setPrimarySpec(PrimaryVersionSpec)
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_PrimarySpec()
	 * @model required="true"
	 * @generated
	 */
	PrimaryVersionSpec getPrimarySpec();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.Version#getPrimarySpec <em>Primary Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Spec</em>' reference.
	 * @see #getPrimarySpec()
	 * @generated
	 */
	void setPrimarySpec(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Tag Specs</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.esmodel.TagVersionSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Specs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Specs</em>' reference list.
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_TagSpecs()
	 * @model
	 * @generated
	 */
	EList<TagVersionSpec> getTagSpecs();

	/**
	 * Returns the value of the '<em><b>Next Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Version</em>' reference.
	 * @see #setNextVersion(Version)
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_NextVersion()
	 * @model
	 * @generated
	 */
	Version getNextVersion();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.Version#getNextVersion <em>Next Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Version</em>' reference.
	 * @see #getNextVersion()
	 * @generated
	 */
	void setNextVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Previous Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Version</em>' reference.
	 * @see #setPreviousVersion(Version)
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_PreviousVersion()
	 * @model
	 * @generated
	 */
	Version getPreviousVersion();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.Version#getPreviousVersion <em>Previous Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Version</em>' reference.
	 * @see #getPreviousVersion()
	 * @generated
	 */
	void setPreviousVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Changes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' reference.
	 * @see #setChanges(ChangePackage)
	 * @see org.unicase.esmodel.EsmodelPackage#getVersion_Changes()
	 * @model required="true"
	 * @generated
	 */
	ChangePackage getChanges();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.Version#getChanges <em>Changes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changes</em>' reference.
	 * @see #getChanges()
	 * @generated
	 */
	void setChanges(ChangePackage value);

} // Version
