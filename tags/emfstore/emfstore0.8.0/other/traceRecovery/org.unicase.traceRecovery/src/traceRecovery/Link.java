/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package traceRecovery;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link traceRecovery.Link#getType <em>Type</em>}</li>
 *   <li>{@link traceRecovery.Link#getStrength <em>Strength</em>}</li>
 *   <li>{@link traceRecovery.Link#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link traceRecovery.Link#getSource <em>Source</em>}</li>
 *   <li>{@link traceRecovery.Link#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see traceRecovery.TraceRecoveryPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see traceRecovery.TraceRecoveryPackage#getLink_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link traceRecovery.Link#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strength</em>' attribute.
	 * @see #setStrength(double)
	 * @see traceRecovery.TraceRecoveryPackage#getLink_Strength()
	 * @model
	 * @generated
	 */
	double getStrength();

	/**
	 * Sets the value of the '{@link traceRecovery.Link#getStrength <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strength</em>' attribute.
	 * @see #getStrength()
	 * @generated
	 */
	void setStrength(double value);

	/**
	 * Returns the value of the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see #setConfidence(double)
	 * @see traceRecovery.TraceRecoveryPackage#getLink_Confidence()
	 * @model
	 * @generated
	 */
	double getConfidence();

	/**
	 * Sets the value of the '{@link traceRecovery.Link#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(double value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(UnicaseModelElement)
	 * @see traceRecovery.TraceRecoveryPackage#getLink_Source()
	 * @model
	 * @generated
	 */
	UnicaseModelElement getSource();

	/**
	 * Sets the value of the '{@link traceRecovery.Link#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(UnicaseModelElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(UnicaseModelElement)
	 * @see traceRecovery.TraceRecoveryPackage#getLink_Target()
	 * @model
	 * @generated
	 */
	UnicaseModelElement getTarget();

	/**
	 * Sets the value of the '{@link traceRecovery.Link#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(UnicaseModelElement value);

} // Link
