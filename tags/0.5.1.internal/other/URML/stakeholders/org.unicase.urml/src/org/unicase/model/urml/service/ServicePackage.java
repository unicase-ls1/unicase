/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.service;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.urml.danger.DangerPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.urml.service.ServiceFactory
 * @model kind="package"
 * @generated
 */
public interface ServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "service";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/service";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.service";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ServicePackage eINSTANCE = org.unicase.model.urml.service.impl.ServicePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.service.impl.ServiceImpl <em>Service</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.service.impl.ServiceImpl
	 * @see org.unicase.model.urml.service.impl.ServicePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = DangerPackage.ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = DangerPackage.ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__ANNOTATIONS = DangerPackage.ASSET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__ATTACHMENTS = DangerPackage.ASSET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INCOMING_DOCUMENT_REFERENCES = DangerPackage.ASSET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LEAF_SECTION = DangerPackage.ASSET__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__STATE = DangerPackage.ASSET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__APPLIED_STEREOTYPE_INSTANCES = DangerPackage.ASSET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__COMMENTS = DangerPackage.ASSET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CREATION_DATE = DangerPackage.ASSET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CREATOR = DangerPackage.ASSET__CREATOR;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ASSOCIATIONS = DangerPackage.ASSET__ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__REVIEWED = DangerPackage.ASSET__REVIEWED;

	/**
	 * The feature id for the '<em><b>Triggered Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TRIGGERED_DANGERS = DangerPackage.ASSET__TRIGGERED_DANGERS;

	/**
	 * The feature id for the '<em><b>Harming Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__HARMING_DANGERS = DangerPackage.ASSET__HARMING_DANGERS;

	/**
	 * The feature id for the '<em><b>Satisfied Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SATISFIED_REQUIREMENTS = DangerPackage.ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Service</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PARENT_SERVICE = DangerPackage.ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Services</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SUB_SERVICES = DangerPackage.ASSET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = DangerPackage.ASSET_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.service.Service <em>Service</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.unicase.model.urml.service.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Satisfied Requirements</em>'.
	 * @see org.unicase.model.urml.service.Service#getSatisfiedRequirements()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_SatisfiedRequirements();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.urml.service.Service#getParentService <em>Parent Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Service</em>'.
	 * @see org.unicase.model.urml.service.Service#getParentService()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ParentService();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.service.Service#getSubServices <em>Sub Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Services</em>'.
	 * @see org.unicase.model.urml.service.Service#getSubServices()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_SubServices();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServiceFactory getServiceFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.urml.service.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.service.impl.ServiceImpl
		 * @see org.unicase.model.urml.service.impl.ServicePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Satisfied Requirements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVICE__SATISFIED_REQUIREMENTS = eINSTANCE
				.getService_SatisfiedRequirements();

		/**
		 * The meta object literal for the '<em><b>Parent Service</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVICE__PARENT_SERVICE = eINSTANCE
				.getService_ParentService();

		/**
		 * The meta object literal for the '<em><b>Sub Services</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVICE__SUB_SERVICES = eINSTANCE.getService_SubServices();

	}

} // ServicePackage
