/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.changemanagment;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.change.ChangeDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.changemanagment.ChangePackage#getFowardDelta <em>Foward Delta</em>}</li>
 *   <li>{@link org.unicase.esmodel.changemanagment.ChangePackage#getBackwardDelta <em>Backward Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getChangePackage()
 * @model
 * @generated
 */
public interface ChangePackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Foward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foward Delta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foward Delta</em>' containment reference.
	 * @see #setFowardDelta(ChangeDescription)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getChangePackage_FowardDelta()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ChangeDescription getFowardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.ChangePackage#getFowardDelta <em>Foward Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foward Delta</em>' containment reference.
	 * @see #getFowardDelta()
	 * @generated
	 */
	void setFowardDelta(ChangeDescription value);

	/**
	 * Returns the value of the '<em><b>Backward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backward Delta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward Delta</em>' containment reference.
	 * @see #setBackwardDelta(ChangeDescription)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getChangePackage_BackwardDelta()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ChangeDescription getBackwardDelta();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.ChangePackage#getBackwardDelta <em>Backward Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backward Delta</em>' containment reference.
	 * @see #getBackwardDelta()
	 * @generated
	 */
	void setBackwardDelta(ChangeDescription value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ChangePackage reverse();

} // ChangePackage
