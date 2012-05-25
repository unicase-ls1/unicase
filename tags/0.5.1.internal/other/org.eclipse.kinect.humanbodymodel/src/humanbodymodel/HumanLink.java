/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Human Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link humanbodymodel.HumanLink#getSource <em>Source</em>}</li>
 *   <li>{@link humanbodymodel.HumanLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see humanbodymodel.HumanbodymodelPackage#getHumanLink()
 * @model
 * @generated
 */
public interface HumanLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PositionedElement)
	 * @see humanbodymodel.HumanbodymodelPackage#getHumanLink_Source()
	 * @model
	 * @generated
	 */
	PositionedElement getSource();

	/**
	 * Sets the value of the '{@link humanbodymodel.HumanLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PositionedElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(PositionedElement)
	 * @see humanbodymodel.HumanbodymodelPackage#getHumanLink_Target()
	 * @model
	 * @generated
	 */
	PositionedElement getTarget();

	/**
	 * Sets the value of the '{@link humanbodymodel.HumanLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PositionedElement value);

} // HumanLink
