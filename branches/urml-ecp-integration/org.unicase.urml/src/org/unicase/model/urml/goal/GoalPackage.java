/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.urml.goal.GoalFactory
 * @model kind="package"
 * @generated
 */
public interface GoalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "goal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/goal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.goal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	GoalPackage eINSTANCE = org.unicase.model.urml.goal.impl.GoalPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.goal.impl.GoalImpl <em>Goal</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.goal.impl.GoalImpl
	 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SOFT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__TYPE = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL__STAKEHOLDERS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized Features</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__REALIZED_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Detailing Use Cases</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL__DETAILING_USE_CASES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUB_GOALS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent Goal</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PARENT_GOAL = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Influencing Goals</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__INFLUENCING_GOALS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Influenced Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__INFLUENCED_GOALS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.goal.impl.GoalReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.goal.impl.GoalReferenceImpl
	 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalReference()
	 * @generated
	 */
	int GOAL_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__SOURCE = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__TARGET = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE__WEIGHT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GOAL_REFERENCE_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.goal.GoalType <em>Type</em>}' enum.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.goal.GoalType
	 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalType()
	 * @generated
	 */
	int GOAL_TYPE = 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.goal.GoalReferenceType <em>Reference Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.goal.GoalReferenceType
	 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalReferenceType()
	 * @generated
	 */
	int GOAL_REFERENCE_TYPE = 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.goal.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see org.unicase.model.urml.goal.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.urml.goal.Goal#isSoft <em>Soft</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Soft</em>'.
	 * @see org.unicase.model.urml.goal.Goal#isSoft()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_Soft();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.urml.goal.Goal#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getType()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.goal.Goal#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stakeholders</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getStakeholders()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Stakeholders();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.goal.Goal#getRealizedFeatures <em>Realized Features</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized Features</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getRealizedFeatures()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_RealizedFeatures();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.urml.goal.Goal#getDetailingUseCases <em>Detailing Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Detailing Use Cases</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getDetailingUseCases()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_DetailingUseCases();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.goal.Goal#getSubGoals <em>Sub Goals</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Goals</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getSubGoals()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_SubGoals();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.urml.goal.Goal#getParentGoal <em>Parent Goal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Goal</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getParentGoal()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_ParentGoal();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.goal.Goal#getInfluencingGoals <em>Influencing Goals</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Influencing Goals</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getInfluencingGoals()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_InfluencingGoals();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.goal.Goal#getInfluencedGoals <em>Influenced Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Influenced Goals</em>'.
	 * @see org.unicase.model.urml.goal.Goal#getInfluencedGoals()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_InfluencedGoals();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.goal.GoalReference <em>Reference</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.unicase.model.urml.goal.GoalReference
	 * @generated
	 */
	EClass getGoalReference();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.urml.goal.GoalReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.unicase.model.urml.goal.GoalReference#getSource()
	 * @see #getGoalReference()
	 * @generated
	 */
	EReference getGoalReference_Source();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.urml.goal.GoalReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.unicase.model.urml.goal.GoalReference#getTarget()
	 * @see #getGoalReference()
	 * @generated
	 */
	EReference getGoalReference_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.urml.goal.GoalReference#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.unicase.model.urml.goal.GoalReference#getWeight()
	 * @see #getGoalReference()
	 * @generated
	 */
	EAttribute getGoalReference_Weight();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.urml.goal.GoalType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.unicase.model.urml.goal.GoalType
	 * @generated
	 */
	EEnum getGoalType();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.urml.goal.GoalReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reference Type</em>'.
	 * @see org.unicase.model.urml.goal.GoalReferenceType
	 * @generated
	 */
	EEnum getGoalReferenceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GoalFactory getGoalFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.goal.impl.GoalImpl <em>Goal</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.goal.impl.GoalImpl
		 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>Soft</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__SOFT = eINSTANCE.getGoal_Soft();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__TYPE = eINSTANCE.getGoal_Type();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__STAKEHOLDERS = eINSTANCE.getGoal_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Realized Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GOAL__REALIZED_FEATURES = eINSTANCE
				.getGoal_RealizedFeatures();

		/**
		 * The meta object literal for the '<em><b>Detailing Use Cases</b></em>' reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__DETAILING_USE_CASES = eINSTANCE
				.getGoal_DetailingUseCases();

		/**
		 * The meta object literal for the '<em><b>Sub Goals</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GOAL__SUB_GOALS = eINSTANCE.getGoal_SubGoals();

		/**
		 * The meta object literal for the '<em><b>Parent Goal</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GOAL__PARENT_GOAL = eINSTANCE.getGoal_ParentGoal();

		/**
		 * The meta object literal for the '<em><b>Influencing Goals</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GOAL__INFLUENCING_GOALS = eINSTANCE
				.getGoal_InfluencingGoals();

		/**
		 * The meta object literal for the '<em><b>Influenced Goals</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GOAL__INFLUENCED_GOALS = eINSTANCE.getGoal_InfluencedGoals();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.goal.impl.GoalReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.goal.impl.GoalReferenceImpl
		 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalReference()
		 * @generated
		 */
		EClass GOAL_REFERENCE = eINSTANCE.getGoalReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_REFERENCE__SOURCE = eINSTANCE.getGoalReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference GOAL_REFERENCE__TARGET = eINSTANCE.getGoalReference_Target();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_REFERENCE__WEIGHT = eINSTANCE.getGoalReference_Weight();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.goal.GoalType <em>Type</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.goal.GoalType
		 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalType()
		 * @generated
		 */
		EEnum GOAL_TYPE = eINSTANCE.getGoalType();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.goal.GoalReferenceType <em>Reference Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.goal.GoalReferenceType
		 * @see org.unicase.model.urml.goal.impl.GoalPackageImpl#getGoalReferenceType()
		 * @generated
		 */
		EEnum GOAL_REFERENCE_TYPE = eINSTANCE.getGoalReferenceType();

	}

} // GoalPackage
