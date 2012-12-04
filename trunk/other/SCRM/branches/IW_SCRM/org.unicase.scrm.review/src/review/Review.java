/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package review;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Review</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link review.Review#getMeasurement <em>Measurement</em>}</li>
 * </ul>
 * </p>
 *
 * @see review.ReviewPackage#getReview()
 * @model
 * @generated
 */
public interface Review extends EObject {
	/**
	 * Returns the value of the '<em><b>Measurement</b></em>' containment reference list.
	 * The list contents are of type {@link review.Metrics}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement</em>' containment reference list.
	 * @see review.ReviewPackage#getReview_Measurement()
	 * @model containment="true"
	 * @generated
	 */
	EList<Metrics> getMeasurement();

} // Review
