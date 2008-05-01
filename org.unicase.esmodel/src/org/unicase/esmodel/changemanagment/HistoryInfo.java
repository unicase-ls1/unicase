/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.changemanagment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.changemanagment.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getHistoryInfo()
 * @model
 * @generated
 */
public interface HistoryInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Primery Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primery Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primery Spec</em>' reference.
	 * @see #setPrimerySpec(PrimaryVersionSpec)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getHistoryInfo_PrimerySpec()
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec getPrimerySpec();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primery Spec</em>' reference.
	 * @see #getPrimerySpec()
	 * @generated
	 */
	void setPrimerySpec(PrimaryVersionSpec value);

} // HistoryInfo
