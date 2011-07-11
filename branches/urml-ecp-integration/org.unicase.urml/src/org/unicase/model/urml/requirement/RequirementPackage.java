/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.requirement;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.unicase.model.urml.requirement.RequirementFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requirement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/requirement";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.requirement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	RequirementPackage eINSTANCE = org.unicase.model.urml.requirement.impl.RequirementPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.requirement.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.requirement.impl.RequirementImpl
	 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = DangerPackage.MITIGATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = DangerPackage.MITIGATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ANNOTATIONS = DangerPackage.MITIGATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ATTACHMENTS = DangerPackage.MITIGATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = DangerPackage.MITIGATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__LEAF_SECTION = DangerPackage.MITIGATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__STATE = DangerPackage.MITIGATION__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__APPLIED_STEREOTYPE_INSTANCES = DangerPackage.MITIGATION__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__COMMENTS = DangerPackage.MITIGATION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CREATION_DATE = DangerPackage.MITIGATION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CREATOR = DangerPackage.MITIGATION__CREATOR;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MITIGATED_DANGERS = DangerPackage.MITIGATION__MITIGATED_DANGERS;

	/**
	 * The feature id for the '<em><b>Implementing Services</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__IMPLEMENTING_SERVICES = DangerPackage.MITIGATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TERMINAL = DangerPackage.MITIGATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = DangerPackage.MITIGATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl
	 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getFunctionalRequirement()
	 * @generated
	 */
	int FUNCTIONAL_REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__ANNOTATIONS = REQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__ATTACHMENTS = REQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = REQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__LEAF_SECTION = REQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__STATE = REQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__APPLIED_STEREOTYPE_INSTANCES = REQUIREMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__COMMENTS = REQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__CREATION_DATE = REQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__CREATOR = REQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__MITIGATED_DANGERS = REQUIREMENT__MITIGATED_DANGERS;

	/**
	 * The feature id for the '<em><b>Implementing Services</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__IMPLEMENTING_SERVICES = REQUIREMENT__IMPLEMENTING_SERVICES;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__TERMINAL = REQUIREMENT__TERMINAL;

	/**
	 * The feature id for the '<em><b>Detailed Features</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Functional Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Functional Requirement</b></em>' container reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Functional Requirement</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl
	 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getNonFunctionalRequirement()
	 * @generated
	 */
	int NON_FUNCTIONAL_REQUIREMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ANNOTATIONS = REQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ATTACHMENTS = REQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = REQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__LEAF_SECTION = REQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__STATE = REQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__APPLIED_STEREOTYPE_INSTANCES = REQUIREMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__COMMENTS = REQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__CREATION_DATE = REQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__CREATOR = REQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__MITIGATED_DANGERS = REQUIREMENT__MITIGATED_DANGERS;

	/**
	 * The feature id for the '<em><b>Implementing Services</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__IMPLEMENTING_SERVICES = REQUIREMENT__IMPLEMENTING_SERVICES;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__TERMINAL = REQUIREMENT__TERMINAL;

	/**
	 * The feature id for the '<em><b>Constrained Features</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Non Functional Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Non Functional Requirement</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Non Functional Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.requirement.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.unicase.model.urml.requirement.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implementing Services</em>'.
	 * @see org.unicase.model.urml.requirement.Requirement#getImplementingServices()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_ImplementingServices();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.urml.requirement.Requirement#isTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see org.unicase.model.urml.requirement.Requirement#isTerminal()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Terminal();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.requirement.FunctionalRequirement <em>Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Requirement</em>'.
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement
	 * @generated
	 */
	EClass getFunctionalRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Detailed Features</em>'.
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getDetailedFeatures()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_DetailedFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.requirement.FunctionalRequirement#getSubFunctionalRequirements <em>Sub Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Functional Requirements</em>'.
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getSubFunctionalRequirements()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_SubFunctionalRequirements();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement <em>Parent Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Functional Requirement</em>'.
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_ParentFunctionalRequirement();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.requirement.NonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Functional Requirement</em>'.
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement
	 * @generated
	 */
	EClass getNonFunctionalRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained Features</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constrained Features</em>'.
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getConstrainedFeatures()
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 */
	EReference getNonFunctionalRequirement_ConstrainedFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getSubNonFunctionalRequirements <em>Sub Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Non Functional Requirements</em>'.
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getSubNonFunctionalRequirements()
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 */
	EReference getNonFunctionalRequirement_SubNonFunctionalRequirements();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement <em>Parent Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Non Functional Requirement</em>'.
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement()
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 */
	EReference getNonFunctionalRequirement_ParentNonFunctionalRequirement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementFactory getRequirementFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.urml.requirement.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.requirement.impl.RequirementImpl
		 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Implementing Services</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__IMPLEMENTING_SERVICES = eINSTANCE
				.getRequirement_ImplementingServices();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__TERMINAL = eINSTANCE.getRequirement_Terminal();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl
		 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getFunctionalRequirement()
		 * @generated
		 */
		EClass FUNCTIONAL_REQUIREMENT = eINSTANCE.getFunctionalRequirement();

		/**
		 * The meta object literal for the '<em><b>Detailed Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES = eINSTANCE
				.getFunctionalRequirement_DetailedFeatures();

		/**
		 * The meta object literal for the '<em><b>Sub Functional Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getFunctionalRequirement_SubFunctionalRequirements();

		/**
		 * The meta object literal for the '<em><b>Parent Functional Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT = eINSTANCE
				.getFunctionalRequirement_ParentFunctionalRequirement();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl
		 * @see org.unicase.model.urml.requirement.impl.RequirementPackageImpl#getNonFunctionalRequirement()
		 * @generated
		 */
		EClass NON_FUNCTIONAL_REQUIREMENT = eINSTANCE
				.getNonFunctionalRequirement();

		/**
		 * The meta object literal for the '<em><b>Constrained Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES = eINSTANCE
				.getNonFunctionalRequirement_ConstrainedFeatures();

		/**
		 * The meta object literal for the '<em><b>Sub Non Functional Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getNonFunctionalRequirement_SubNonFunctionalRequirements();

		/**
		 * The meta object literal for the '<em><b>Parent Non Functional Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT = eINSTANCE
				.getNonFunctionalRequirement_ParentNonFunctionalRequirement();

	}

} // RequirementPackage
