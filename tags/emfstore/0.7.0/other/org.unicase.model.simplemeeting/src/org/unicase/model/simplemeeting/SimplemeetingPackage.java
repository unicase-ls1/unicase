/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

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
 * @see org.unicase.model.simplemeeting.SimplemeetingFactory
 * @model kind="package"
 * @generated
 */
public interface SimplemeetingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simplemeeting";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/simplemeeting";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.simplemeeting";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimplemeetingPackage eINSTANCE = org.unicase.model.simplemeeting.impl.SimplemeetingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl <em>Simple Meeting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.simplemeeting.impl.SimpleMeetingImpl
	 * @see org.unicase.model.simplemeeting.impl.SimplemeetingPackageImpl#getSimpleMeeting()
	 * @generated
	 */
	int SIMPLE_MEETING = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__LOCATION = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Starttime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__STARTTIME = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Endtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__ENDTIME = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Facilitator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__FACILITATOR = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Minutetaker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__MINUTETAKER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Timekeeper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__TIMEKEEPER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__PARTICIPANTS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Status Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__STATUS_ITEMS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Discussion Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__DISCUSSION_ITEMS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Identified Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING__IDENTIFIED_ITEMS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Simple Meeting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_MEETING_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 10;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.simplemeeting.SimpleMeeting <em>Simple Meeting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Meeting</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting
	 * @generated
	 */
	EClass getSimpleMeeting();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.simplemeeting.SimpleMeeting#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getLocation()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EAttribute getSimpleMeeting_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.simplemeeting.SimpleMeeting#getStarttime <em>Starttime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Starttime</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getStarttime()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EAttribute getSimpleMeeting_Starttime();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.simplemeeting.SimpleMeeting#getEndtime <em>Endtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endtime</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getEndtime()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EAttribute getSimpleMeeting_Endtime();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.simplemeeting.SimpleMeeting#getFacilitator <em>Facilitator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Facilitator</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getFacilitator()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_Facilitator();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.simplemeeting.SimpleMeeting#getMinutetaker <em>Minutetaker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Minutetaker</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getMinutetaker()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_Minutetaker();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.simplemeeting.SimpleMeeting#getTimekeeper <em>Timekeeper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Timekeeper</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getTimekeeper()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_Timekeeper();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.simplemeeting.SimpleMeeting#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getParticipants()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_Participants();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.simplemeeting.SimpleMeeting#getStatusItems <em>Status Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Status Items</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getStatusItems()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_StatusItems();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.simplemeeting.SimpleMeeting#getDiscussionItems <em>Discussion Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Discussion Items</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getDiscussionItems()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_DiscussionItems();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.simplemeeting.SimpleMeeting#getIdentifiedItems <em>Identified Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identified Items</em>'.
	 * @see org.unicase.model.simplemeeting.SimpleMeeting#getIdentifiedItems()
	 * @see #getSimpleMeeting()
	 * @generated
	 */
	EReference getSimpleMeeting_IdentifiedItems();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimplemeetingFactory getSimplemeetingFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.simplemeeting.impl.SimpleMeetingImpl <em>Simple Meeting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.simplemeeting.impl.SimpleMeetingImpl
		 * @see org.unicase.model.simplemeeting.impl.SimplemeetingPackageImpl#getSimpleMeeting()
		 * @generated
		 */
		EClass SIMPLE_MEETING = eINSTANCE.getSimpleMeeting();
		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_MEETING__LOCATION = eINSTANCE.getSimpleMeeting_Location();
		/**
		 * The meta object literal for the '<em><b>Starttime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_MEETING__STARTTIME = eINSTANCE.getSimpleMeeting_Starttime();
		/**
		 * The meta object literal for the '<em><b>Endtime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_MEETING__ENDTIME = eINSTANCE.getSimpleMeeting_Endtime();
		/**
		 * The meta object literal for the '<em><b>Facilitator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__FACILITATOR = eINSTANCE.getSimpleMeeting_Facilitator();
		/**
		 * The meta object literal for the '<em><b>Minutetaker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__MINUTETAKER = eINSTANCE.getSimpleMeeting_Minutetaker();
		/**
		 * The meta object literal for the '<em><b>Timekeeper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__TIMEKEEPER = eINSTANCE.getSimpleMeeting_Timekeeper();
		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__PARTICIPANTS = eINSTANCE.getSimpleMeeting_Participants();
		/**
		 * The meta object literal for the '<em><b>Status Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__STATUS_ITEMS = eINSTANCE.getSimpleMeeting_StatusItems();
		/**
		 * The meta object literal for the '<em><b>Discussion Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__DISCUSSION_ITEMS = eINSTANCE.getSimpleMeeting_DiscussionItems();
		/**
		 * The meta object literal for the '<em><b>Identified Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_MEETING__IDENTIFIED_ITEMS = eINSTANCE.getSimpleMeeting_IdentifiedItems();

	}

} //SimplemeetingPackage
