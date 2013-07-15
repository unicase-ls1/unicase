/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package review;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see review.ReviewFactory
 * @model kind="package"
 * @generated
 */
public interface ReviewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "review";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/review";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.review";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReviewPackage eINSTANCE = review.impl.ReviewPackageImpl.init();

	/**
	 * The meta object id for the '{@link review.impl.MetricsImpl <em>Metrics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see review.impl.MetricsImpl
	 * @see review.impl.ReviewPackageImpl#getMetrics()
	 * @generated
	 */
	int METRICS = 0;

	/**
	 * The feature id for the '<em><b>Correct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__CORRECT = 0;

	/**
	 * The feature id for the '<em><b>Easy To Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__EASY_TO_UNDERSTAND = 1;

	/**
	 * The feature id for the '<em><b>Unambiguous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__UNAMBIGUOUS = 2;

	/**
	 * The feature id for the '<em><b>Measured Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__MEASURED_REQUIREMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__ID = 4;

	/**
	 * The number of structural features of the '<em>Metrics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link review.impl.ReviewImpl <em>Review</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see review.impl.ReviewImpl
	 * @see review.impl.ReviewPackageImpl#getReview()
	 * @generated
	 */
	int REVIEW = 1;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW__MEASUREMENT = 0;

	/**
	 * The number of structural features of the '<em>Review</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVIEW_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link review.Metrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metrics</em>'.
	 * @see review.Metrics
	 * @generated
	 */
	EClass getMetrics();

	/**
	 * Returns the meta object for the attribute '{@link review.Metrics#isCorrect <em>Correct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correct</em>'.
	 * @see review.Metrics#isCorrect()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_Correct();

	/**
	 * Returns the meta object for the attribute '{@link review.Metrics#isEasyToUnderstand <em>Easy To Understand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Easy To Understand</em>'.
	 * @see review.Metrics#isEasyToUnderstand()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_EasyToUnderstand();

	/**
	 * Returns the meta object for the attribute '{@link review.Metrics#isUnambiguous <em>Unambiguous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unambiguous</em>'.
	 * @see review.Metrics#isUnambiguous()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_Unambiguous();

	/**
	 * Returns the meta object for the reference '{@link review.Metrics#getMeasuredRequirement <em>Measured Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measured Requirement</em>'.
	 * @see review.Metrics#getMeasuredRequirement()
	 * @see #getMetrics()
	 * @generated
	 */
	EReference getMetrics_MeasuredRequirement();

	/**
	 * Returns the meta object for the attribute '{@link review.Metrics#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see review.Metrics#getId()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_Id();

	/**
	 * Returns the meta object for class '{@link review.Review <em>Review</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Review</em>'.
	 * @see review.Review
	 * @generated
	 */
	EClass getReview();

	/**
	 * Returns the meta object for the containment reference list '{@link review.Review#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurement</em>'.
	 * @see review.Review#getMeasurement()
	 * @see #getReview()
	 * @generated
	 */
	EReference getReview_Measurement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReviewFactory getReviewFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link review.impl.MetricsImpl <em>Metrics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see review.impl.MetricsImpl
		 * @see review.impl.ReviewPackageImpl#getMetrics()
		 * @generated
		 */
		EClass METRICS = eINSTANCE.getMetrics();

		/**
		 * The meta object literal for the '<em><b>Correct</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__CORRECT = eINSTANCE.getMetrics_Correct();

		/**
		 * The meta object literal for the '<em><b>Easy To Understand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__EASY_TO_UNDERSTAND = eINSTANCE.getMetrics_EasyToUnderstand();

		/**
		 * The meta object literal for the '<em><b>Unambiguous</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__UNAMBIGUOUS = eINSTANCE.getMetrics_Unambiguous();

		/**
		 * The meta object literal for the '<em><b>Measured Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRICS__MEASURED_REQUIREMENT = eINSTANCE.getMetrics_MeasuredRequirement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__ID = eINSTANCE.getMetrics_Id();

		/**
		 * The meta object literal for the '{@link review.impl.ReviewImpl <em>Review</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see review.impl.ReviewImpl
		 * @see review.impl.ReviewPackageImpl#getReview()
		 * @generated
		 */
		EClass REVIEW = eINSTANCE.getReview();

		/**
		 * The meta object literal for the '<em><b>Measurement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVIEW__MEASUREMENT = eINSTANCE.getReview_Measurement();

	}

} //ReviewPackage
