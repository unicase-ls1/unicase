/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * 
 * @see org.unicase.model.urml.feature.FeatureFactory
 * @model kind="package"
 * @generated
 */
public interface FeaturePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "feature";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/feature";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.feature";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FeaturePackage eINSTANCE = org.unicase.model.urml.feature.impl.FeaturePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.feature.impl.AbstractFeatureImpl
	 * <em>Abstract Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.feature.impl.AbstractFeatureImpl
	 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getAbstractFeature()
	 * @generated
	 */
	int ABSTRACT_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__GOALS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Detailing Functional Requirements</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraining Non Functional Requirements</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Detailing Use Cases</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__DETAILING_USE_CASES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Feature</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__PARENT_FEATURE = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Features</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__SUB_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Excluding Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__EXCLUDING_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Excluded Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__EXCLUDED_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__REQUIRING_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Required Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__REQUIRED_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Optional Parent Variation Point</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Abstract Feature</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.feature.impl.FeatureImpl <em>Feature</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.feature.impl.FeatureImpl
	 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = ABSTRACT_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__DESCRIPTION = ABSTRACT_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__ANNOTATIONS = ABSTRACT_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__ATTACHMENTS = ABSTRACT_FEATURE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__INCOMING_DOCUMENT_REFERENCES = ABSTRACT_FEATURE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__LEAF_SECTION = ABSTRACT_FEATURE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__STATE = ABSTRACT_FEATURE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__APPLIED_STEREOTYPE_INSTANCES = ABSTRACT_FEATURE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__COMMENTS = ABSTRACT_FEATURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATION_DATE = ABSTRACT_FEATURE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATOR = ABSTRACT_FEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__GOALS = ABSTRACT_FEATURE__GOALS;

	/**
	 * The feature id for the '<em><b>Detailing Functional Requirements</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS = ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Constraining Non Functional Requirements</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS = ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Detailing Use Cases</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__DETAILING_USE_CASES = ABSTRACT_FEATURE__DETAILING_USE_CASES;

	/**
	 * The feature id for the '<em><b>Parent Feature</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__PARENT_FEATURE = ABSTRACT_FEATURE__PARENT_FEATURE;

	/**
	 * The feature id for the '<em><b>Sub Features</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__SUB_FEATURES = ABSTRACT_FEATURE__SUB_FEATURES;

	/**
	 * The feature id for the '<em><b>Excluding Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXCLUDING_FEATURES = ABSTRACT_FEATURE__EXCLUDING_FEATURES;

	/**
	 * The feature id for the '<em><b>Excluded Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXCLUDED_FEATURES = ABSTRACT_FEATURE__EXCLUDED_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRING_FEATURES = ABSTRACT_FEATURE__REQUIRING_FEATURES;

	/**
	 * The feature id for the '<em><b>Required Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_FEATURES = ABSTRACT_FEATURE__REQUIRED_FEATURES;

	/**
	 * The feature id for the '<em><b>Optional Parent Variation Point</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__OPTIONAL_PARENT_VARIATION_POINT = ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__VARIATION_POINT_INSTANCES = ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES;

	/**
	 * The feature id for the '<em><b>Products</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__PRODUCTS = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.feature.impl.VariationPointImpl
	 * <em>Variation Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.feature.impl.VariationPointImpl
	 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NAME = ABSTRACT_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__DESCRIPTION = ABSTRACT_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__ANNOTATIONS = ABSTRACT_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__ATTACHMENTS = ABSTRACT_FEATURE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__INCOMING_DOCUMENT_REFERENCES = ABSTRACT_FEATURE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__LEAF_SECTION = ABSTRACT_FEATURE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__STATE = ABSTRACT_FEATURE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__APPLIED_STEREOTYPE_INSTANCES = ABSTRACT_FEATURE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__COMMENTS = ABSTRACT_FEATURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CREATION_DATE = ABSTRACT_FEATURE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CREATOR = ABSTRACT_FEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__GOALS = ABSTRACT_FEATURE__GOALS;

	/**
	 * The feature id for the '<em><b>Detailing Functional Requirements</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__DETAILING_FUNCTIONAL_REQUIREMENTS = ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Constraining Non Functional Requirements</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS = ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Detailing Use Cases</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__DETAILING_USE_CASES = ABSTRACT_FEATURE__DETAILING_USE_CASES;

	/**
	 * The feature id for the '<em><b>Parent Feature</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__PARENT_FEATURE = ABSTRACT_FEATURE__PARENT_FEATURE;

	/**
	 * The feature id for the '<em><b>Sub Features</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__SUB_FEATURES = ABSTRACT_FEATURE__SUB_FEATURES;

	/**
	 * The feature id for the '<em><b>Excluding Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__EXCLUDING_FEATURES = ABSTRACT_FEATURE__EXCLUDING_FEATURES;

	/**
	 * The feature id for the '<em><b>Excluded Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__EXCLUDED_FEATURES = ABSTRACT_FEATURE__EXCLUDED_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__REQUIRING_FEATURES = ABSTRACT_FEATURE__REQUIRING_FEATURES;

	/**
	 * The feature id for the '<em><b>Required Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__REQUIRED_FEATURES = ABSTRACT_FEATURE__REQUIRED_FEATURES;

	/**
	 * The feature id for the '<em><b>Optional Parent Variation Point</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__OPTIONAL_PARENT_VARIATION_POINT = ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARIATION_POINT_INSTANCES = ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES;

	/**
	 * The feature id for the '<em><b>Optional Sub Features</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__OPTIONAL_SUB_FEATURES = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__MULTIPLICITY = ABSTRACT_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__INSTANCES = ABSTRACT_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.feature.impl.VariationPointInstanceImpl
	 * <em>Variation Point Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.feature.impl.VariationPointInstanceImpl
	 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getVariationPointInstance()
	 * @generated
	 */
	int VARIATION_POINT_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__VARIATION_POINT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Products</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__PRODUCTS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selected Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__SELECTED_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variation Point Instance</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.feature.impl.ProductImpl <em>Product</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.feature.impl.ProductImpl
	 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VARIATION_POINT_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Product</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.feature.AbstractFeature
	 * <em>Abstract Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Feature</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature
	 * @generated
	 */
	EClass getAbstractFeature();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.feature.AbstractFeature#getGoals
	 * <em>Goals</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Goals</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getGoals()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_Goals();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getDetailingFunctionalRequirements
	 * <em>Detailing Functional Requirements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Detailing Functional Requirements</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getDetailingFunctionalRequirements()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_DetailingFunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements
	 * <em>Constraining Non Functional Requirements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Constraining Non Functional Requirements</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ConstrainingNonFunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getDetailingUseCases <em>Detailing Use Cases</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Detailing Use Cases</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getDetailingUseCases()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_DetailingUseCases();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Feature</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getParentFeature()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ParentFeature();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getSubFeatures <em>Sub Features</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Features</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getSubFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_SubFeatures();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getExcludingFeatures <em>Excluding Features</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Excluding Features</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getExcludingFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ExcludingFeatures();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getExcludedFeatures <em>Excluded Features</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Excluded Features</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getExcludedFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ExcludedFeatures();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getRequiringFeatures <em>Requiring Features</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Requiring Features</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getRequiringFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_RequiringFeatures();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getRequiredFeatures <em>Required Features</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Required Features</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getRequiredFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_RequiredFeatures();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getOptionalParentVariationPoint
	 * <em>Optional Parent Variation Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Optional Parent Variation Point</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getOptionalParentVariationPoint()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_OptionalParentVariationPoint();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getVariationPointInstances
	 * <em>Variation Point Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Point Instances</em>'.
	 * @see org.unicase.model.urml.feature.AbstractFeature#getVariationPointInstances()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_VariationPointInstances();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.feature.Feature <em>Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.unicase.model.urml.feature.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.feature.Feature#getProducts
	 * <em>Products</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Products</em>'.
	 * @see org.unicase.model.urml.feature.Feature#getProducts()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Products();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.feature.VariationPoint <em>Variation Point</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see org.unicase.model.urml.feature.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.urml.feature.VariationPoint#getOptionalSubFeatures <em>Optional Sub Features</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Optional Sub Features</em>'.
	 * @see org.unicase.model.urml.feature.VariationPoint#getOptionalSubFeatures()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_OptionalSubFeatures();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.urml.feature.VariationPoint#getMultiplicity
	 * <em>Multiplicity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.unicase.model.urml.feature.VariationPoint#getMultiplicity()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EAttribute getVariationPoint_Multiplicity();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.VariationPoint#getInstances <em>Instances</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see org.unicase.model.urml.feature.VariationPoint#getInstances()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Instances();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.feature.VariationPointInstance
	 * <em>Variation Point Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Point Instance</em>'.
	 * @see org.unicase.model.urml.feature.VariationPointInstance
	 * @generated
	 */
	EClass getVariationPointInstance();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Variation Point</em>'.
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_VariationPoint();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.VariationPointInstance#getProducts <em>Products</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Products</em>'.
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getProducts()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_Products();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.VariationPointInstance#getSelectedFeatures <em>Selected Features</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Selected Features</em>'.
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getSelectedFeatures()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_SelectedFeatures();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.feature.Product <em>Product</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Product</em>'.
	 * @see org.unicase.model.urml.feature.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.feature.Product#getVariationPointInstances <em>Variation Point Instances</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Point Instances</em>'.
	 * @see org.unicase.model.urml.feature.Product#getVariationPointInstances()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_VariationPointInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.feature.Product#getFeatures
	 * <em>Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.unicase.model.urml.feature.Product#getFeatures()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_Features();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FeatureFactory getFeatureFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.feature.impl.AbstractFeatureImpl
		 * <em>Abstract Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.feature.impl.AbstractFeatureImpl
		 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getAbstractFeature()
		 * @generated
		 */
		EClass ABSTRACT_FEATURE = eINSTANCE.getAbstractFeature();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__GOALS = eINSTANCE.getAbstractFeature_Goals();

		/**
		 * The meta object literal for the '<em><b>Detailing Functional Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS = eINSTANCE
			.getAbstractFeature_DetailingFunctionalRequirements();

		/**
		 * The meta object literal for the '<em><b>Constraining Non Functional Requirements</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS = eINSTANCE
			.getAbstractFeature_ConstrainingNonFunctionalRequirements();

		/**
		 * The meta object literal for the '<em><b>Detailing Use Cases</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__DETAILING_USE_CASES = eINSTANCE.getAbstractFeature_DetailingUseCases();

		/**
		 * The meta object literal for the '<em><b>Parent Feature</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__PARENT_FEATURE = eINSTANCE.getAbstractFeature_ParentFeature();

		/**
		 * The meta object literal for the '<em><b>Sub Features</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__SUB_FEATURES = eINSTANCE.getAbstractFeature_SubFeatures();

		/**
		 * The meta object literal for the '<em><b>Excluding Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__EXCLUDING_FEATURES = eINSTANCE.getAbstractFeature_ExcludingFeatures();

		/**
		 * The meta object literal for the '<em><b>Excluded Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__EXCLUDED_FEATURES = eINSTANCE.getAbstractFeature_ExcludedFeatures();

		/**
		 * The meta object literal for the '<em><b>Requiring Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__REQUIRING_FEATURES = eINSTANCE.getAbstractFeature_RequiringFeatures();

		/**
		 * The meta object literal for the '<em><b>Required Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__REQUIRED_FEATURES = eINSTANCE.getAbstractFeature_RequiredFeatures();

		/**
		 * The meta object literal for the '<em><b>Optional Parent Variation Point</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT = eINSTANCE
			.getAbstractFeature_OptionalParentVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Variation Point Instances</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES = eINSTANCE.getAbstractFeature_VariationPointInstances();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.feature.impl.FeatureImpl <em>Feature</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.feature.impl.FeatureImpl
		 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Products</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE__PRODUCTS = eINSTANCE.getFeature_Products();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.feature.impl.VariationPointImpl
		 * <em>Variation Point</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.feature.impl.VariationPointImpl
		 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Optional Sub Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT__OPTIONAL_SUB_FEATURES = eINSTANCE.getVariationPoint_OptionalSubFeatures();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VARIATION_POINT__MULTIPLICITY = eINSTANCE.getVariationPoint_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT__INSTANCES = eINSTANCE.getVariationPoint_Instances();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.feature.impl.VariationPointInstanceImpl
		 * <em>Variation Point Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.feature.impl.VariationPointInstanceImpl
		 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getVariationPointInstance()
		 * @generated
		 */
		EClass VARIATION_POINT_INSTANCE = eINSTANCE.getVariationPointInstance();

		/**
		 * The meta object literal for the '<em><b>Variation Point</b></em>' reference feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_INSTANCE__VARIATION_POINT = eINSTANCE.getVariationPointInstance_VariationPoint();

		/**
		 * The meta object literal for the '<em><b>Products</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_INSTANCE__PRODUCTS = eINSTANCE.getVariationPointInstance_Products();

		/**
		 * The meta object literal for the '<em><b>Selected Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_INSTANCE__SELECTED_FEATURES = eINSTANCE.getVariationPointInstance_SelectedFeatures();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.feature.impl.ProductImpl <em>Product</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.urml.feature.impl.ProductImpl
		 * @see org.unicase.model.urml.feature.impl.FeaturePackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '<em><b>Variation Point Instances</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PRODUCT__VARIATION_POINT_INSTANCES = eINSTANCE.getProduct_VariationPointInstances();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PRODUCT__FEATURES = eINSTANCE.getProduct_Features();

	}

} // FeaturePackage
