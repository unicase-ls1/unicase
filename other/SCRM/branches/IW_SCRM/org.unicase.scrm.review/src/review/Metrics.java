/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package review;

import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metrics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link review.Metrics#isCorrect <em>Correct</em>}</li>
 *   <li>{@link review.Metrics#isEasyToUnderstand <em>Easy To Understand</em>}</li>
 *   <li>{@link review.Metrics#isUnambiguous <em>Unambiguous</em>}</li>
 *   <li>{@link review.Metrics#getMeasuredRequirement <em>Measured Requirement</em>}</li>
 *   <li>{@link review.Metrics#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see review.ReviewPackage#getMetrics()
 * @model
 * @generated
 */
public interface Metrics extends EObject {
	/**
	 * Returns the value of the '<em><b>Correct</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correct</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correct</em>' attribute.
	 * @see #setCorrect(boolean)
	 * @see review.ReviewPackage#getMetrics_Correct()
	 * @model default="true"
	 * @generated
	 */
	boolean isCorrect();

	/**
	 * Sets the value of the '{@link review.Metrics#isCorrect <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correct</em>' attribute.
	 * @see #isCorrect()
	 * @generated
	 */
	void setCorrect(boolean value);

	/**
	 * Returns the value of the '<em><b>Easy To Understand</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Easy To Understand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Easy To Understand</em>' attribute.
	 * @see #setEasyToUnderstand(boolean)
	 * @see review.ReviewPackage#getMetrics_EasyToUnderstand()
	 * @model default="true"
	 * @generated
	 */
	boolean isEasyToUnderstand();

	/**
	 * Sets the value of the '{@link review.Metrics#isEasyToUnderstand <em>Easy To Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Easy To Understand</em>' attribute.
	 * @see #isEasyToUnderstand()
	 * @generated
	 */
	void setEasyToUnderstand(boolean value);

	/**
	 * Returns the value of the '<em><b>Unambiguous</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unambiguous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unambiguous</em>' attribute.
	 * @see #setUnambiguous(boolean)
	 * @see review.ReviewPackage#getMetrics_Unambiguous()
	 * @model default="true"
	 * @generated
	 */
	boolean isUnambiguous();

	/**
	 * Sets the value of the '{@link review.Metrics#isUnambiguous <em>Unambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unambiguous</em>' attribute.
	 * @see #isUnambiguous()
	 * @generated
	 */
	void setUnambiguous(boolean value);

	/**
	 * Returns the value of the '<em><b>Measured Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measured Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measured Requirement</em>' reference.
	 * @see #setMeasuredRequirement(SCRMModelElement)
	 * @see review.ReviewPackage#getMetrics_MeasuredRequirement()
	 * @model
	 * @generated
	 */
	SCRMModelElement getMeasuredRequirement();

	/**
	 * Sets the value of the '{@link review.Metrics#getMeasuredRequirement <em>Measured Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Requirement</em>' reference.
	 * @see #getMeasuredRequirement()
	 * @generated
	 */
	void setMeasuredRequirement(SCRMModelElement value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see review.ReviewPackage#getMetrics_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link review.Metrics#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Metrics
