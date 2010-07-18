/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

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
 * @see urml.feature.FeatureFactory
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
	FeaturePackage eINSTANCE = urml.feature.impl.FeaturePackageImpl.init();

	/**
	 * The meta object id for the '{@link urml.feature.impl.AbstractFeatureImpl <em>Abstract Feature</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.AbstractFeatureImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getAbstractFeature()
	 * @generated
	 */
	int ABSTRACT_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

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
	 * The feature id for the '<em><b>Requiering Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__REQUIERING_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Requiered Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__REQUIERED_FEATURES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE__VARIATION_POINTS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 10;

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
	 * The meta object id for the '{@link urml.feature.impl.FeatureImpl <em>Feature</em>}' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.FeatureImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__IDENTIFIER = ABSTRACT_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATOR = ABSTRACT_FEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATION_DATE = ABSTRACT_FEATURE__CREATION_DATE;

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
	 * The feature id for the '<em><b>Requiering Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIERING_FEATURES = ABSTRACT_FEATURE__REQUIERING_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiered Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIERED_FEATURES = ABSTRACT_FEATURE__REQUIERED_FEATURES;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__VARIATION_POINTS = ABSTRACT_FEATURE__VARIATION_POINTS;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__VARIATION_POINT_INSTANCES = ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES;

	/**
	 * The number of structural features of the '<em>Feature</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link urml.feature.impl.VariationPointImpl <em>Variation Point</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.VariationPointImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__IDENTIFIER = ABSTRACT_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CREATOR = ABSTRACT_FEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CREATION_DATE = ABSTRACT_FEATURE__CREATION_DATE;

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
	 * The feature id for the '<em><b>Requiering Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__REQUIERING_FEATURES = ABSTRACT_FEATURE__REQUIERING_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiered Features</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__REQUIERED_FEATURES = ABSTRACT_FEATURE__REQUIERED_FEATURES;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARIATION_POINTS = ABSTRACT_FEATURE__VARIATION_POINTS;

	/**
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARIATION_POINT_INSTANCES = ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__FEATURES = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__INSTANCES = ABSTRACT_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__RULES = ABSTRACT_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link urml.feature.impl.VariationPointInstanceImpl
	 * <em>Variation Point Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.VariationPointInstanceImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getVariationPointInstance()
	 * @generated
	 */
	int VARIATION_POINT_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

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
	 * The feature id for the '<em><b>Variation Point</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__VARIATION_POINT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_INSTANCE__PRODUCT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link urml.feature.impl.ProductImpl <em>Product</em>}' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.ProductImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

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
	 * The feature id for the '<em><b>Variation Point Instances</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VARIATION_POINT_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Product</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link urml.feature.impl.VariationPointRuleImpl <em>Variation Point Rule</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.VariationPointRuleImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getVariationPointRule()
	 * @generated
	 */
	int VARIATION_POINT_RULE = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE__VARIATION_POINT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variation Point Rule</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_RULE_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link urml.feature.impl.OneOutManyRuleImpl <em>One Out Many Rule</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.OneOutManyRuleImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getOneOutManyRule()
	 * @generated
	 */
	int ONE_OUT_MANY_RULE = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__IDENTIFIER = VARIATION_POINT_RULE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__CREATOR = VARIATION_POINT_RULE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__CREATION_DATE = VARIATION_POINT_RULE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__NAME = VARIATION_POINT_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__DESCRIPTION = VARIATION_POINT_RULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__ANNOTATIONS = VARIATION_POINT_RULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__ATTACHMENTS = VARIATION_POINT_RULE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__INCOMING_DOCUMENT_REFERENCES = VARIATION_POINT_RULE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__LEAF_SECTION = VARIATION_POINT_RULE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__STATE = VARIATION_POINT_RULE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__APPLIED_STEREOTYPE_INSTANCES = VARIATION_POINT_RULE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__COMMENTS = VARIATION_POINT_RULE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE__VARIATION_POINT = VARIATION_POINT_RULE__VARIATION_POINT;

	/**
	 * The number of structural features of the '<em>One Out Many Rule</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_OUT_MANY_RULE_FEATURE_COUNT = VARIATION_POINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link urml.feature.impl.ManyOutManyRuleImpl <em>Many Out Many Rule</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.feature.impl.ManyOutManyRuleImpl
	 * @see urml.feature.impl.FeaturePackageImpl#getManyOutManyRule()
	 * @generated
	 */
	int MANY_OUT_MANY_RULE = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__IDENTIFIER = VARIATION_POINT_RULE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__CREATOR = VARIATION_POINT_RULE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__CREATION_DATE = VARIATION_POINT_RULE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__NAME = VARIATION_POINT_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__DESCRIPTION = VARIATION_POINT_RULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__ANNOTATIONS = VARIATION_POINT_RULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__ATTACHMENTS = VARIATION_POINT_RULE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__INCOMING_DOCUMENT_REFERENCES = VARIATION_POINT_RULE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__LEAF_SECTION = VARIATION_POINT_RULE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__STATE = VARIATION_POINT_RULE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__APPLIED_STEREOTYPE_INSTANCES = VARIATION_POINT_RULE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__COMMENTS = VARIATION_POINT_RULE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__VARIATION_POINT = VARIATION_POINT_RULE__VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE__CONSTRAINT = VARIATION_POINT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Many Out Many Rule</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANY_OUT_MANY_RULE_FEATURE_COUNT = VARIATION_POINT_RULE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link urml.feature.AbstractFeature <em>Abstract Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Feature</em>'.
	 * @see urml.feature.AbstractFeature
	 * @generated
	 */
	EClass getAbstractFeature();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Goals</em>'.
	 * @see urml.feature.AbstractFeature#getGoals()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_Goals();

	/**
	 * Returns the meta object for the reference list '
	 * {@link urml.feature.AbstractFeature#getDetailingFunctionalRequirements
	 * <em>Detailing Functional Requirements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Detailing Functional Requirements</em>'.
	 * @see urml.feature.AbstractFeature#getDetailingFunctionalRequirements()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_DetailingFunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '
	 * {@link urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements
	 * <em>Constraining Non Functional Requirements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Constraining Non Functional Requirements</em>'.
	 * @see urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ConstrainingNonFunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getDetailingUseCases
	 * <em>Detailing Use Cases</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Detailing Use Cases</em>'.
	 * @see urml.feature.AbstractFeature#getDetailingUseCases()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_DetailingUseCases();

	/**
	 * Returns the meta object for the container reference '{@link urml.feature.AbstractFeature#getParentFeature
	 * <em>Parent Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Feature</em>'.
	 * @see urml.feature.AbstractFeature#getParentFeature()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ParentFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link urml.feature.AbstractFeature#getSubFeatures
	 * <em>Sub Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Features</em>'.
	 * @see urml.feature.AbstractFeature#getSubFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_SubFeatures();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getExcludingFeatures
	 * <em>Excluding Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Excluding Features</em>'.
	 * @see urml.feature.AbstractFeature#getExcludingFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ExcludingFeatures();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getExcludedFeatures
	 * <em>Excluded Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Excluded Features</em>'.
	 * @see urml.feature.AbstractFeature#getExcludedFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_ExcludedFeatures();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getRequieringFeatures
	 * <em>Requiering Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Requiering Features</em>'.
	 * @see urml.feature.AbstractFeature#getRequieringFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_RequieringFeatures();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getRequieredFeatures
	 * <em>Requiered Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Requiered Features</em>'.
	 * @see urml.feature.AbstractFeature#getRequieredFeatures()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_RequieredFeatures();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getVariationPoints
	 * <em>Variation Points</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Points</em>'.
	 * @see urml.feature.AbstractFeature#getVariationPoints()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_VariationPoints();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.AbstractFeature#getVariationPointInstances
	 * <em>Variation Point Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Point Instances</em>'.
	 * @see urml.feature.AbstractFeature#getVariationPointInstances()
	 * @see #getAbstractFeature()
	 * @generated
	 */
	EReference getAbstractFeature_VariationPointInstances();

	/**
	 * Returns the meta object for class '{@link urml.feature.Feature <em>Feature</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see urml.feature.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for class '{@link urml.feature.VariationPoint <em>Variation Point</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see urml.feature.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.VariationPoint#getFeatures <em>Features</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see urml.feature.VariationPoint#getFeatures()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Features();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.VariationPoint#getInstances
	 * <em>Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see urml.feature.VariationPoint#getInstances()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link urml.feature.VariationPoint#getRules
	 * <em>Rules</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see urml.feature.VariationPoint#getRules()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Rules();

	/**
	 * Returns the meta object for class '{@link urml.feature.VariationPointInstance <em>Variation Point Instance</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Point Instance</em>'.
	 * @see urml.feature.VariationPointInstance
	 * @generated
	 */
	EClass getVariationPointInstance();

	/**
	 * Returns the meta object for the reference '{@link urml.feature.VariationPointInstance#getVariationPoint
	 * <em>Variation Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Variation Point</em>'.
	 * @see urml.feature.VariationPointInstance#getVariationPoint()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_VariationPoint();

	/**
	 * Returns the meta object for the reference '{@link urml.feature.VariationPointInstance#getProduct
	 * <em>Product</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Product</em>'.
	 * @see urml.feature.VariationPointInstance#getProduct()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_Product();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.VariationPointInstance#getSelectedFeatures
	 * <em>Selected Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Selected Features</em>'.
	 * @see urml.feature.VariationPointInstance#getSelectedFeatures()
	 * @see #getVariationPointInstance()
	 * @generated
	 */
	EReference getVariationPointInstance_SelectedFeatures();

	/**
	 * Returns the meta object for class '{@link urml.feature.Product <em>Product</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Product</em>'.
	 * @see urml.feature.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for the reference list '{@link urml.feature.Product#getVariationPointInstances
	 * <em>Variation Point Instances</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Point Instances</em>'.
	 * @see urml.feature.Product#getVariationPointInstances()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_VariationPointInstances();

	/**
	 * Returns the meta object for class '{@link urml.feature.VariationPointRule <em>Variation Point Rule</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Point Rule</em>'.
	 * @see urml.feature.VariationPointRule
	 * @generated
	 */
	EClass getVariationPointRule();

	/**
	 * Returns the meta object for the container reference '{@link urml.feature.VariationPointRule#getVariationPoint
	 * <em>Variation Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Variation Point</em>'.
	 * @see urml.feature.VariationPointRule#getVariationPoint()
	 * @see #getVariationPointRule()
	 * @generated
	 */
	EReference getVariationPointRule_VariationPoint();

	/**
	 * Returns the meta object for class '{@link urml.feature.OneOutManyRule <em>One Out Many Rule</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>One Out Many Rule</em>'.
	 * @see urml.feature.OneOutManyRule
	 * @generated
	 */
	EClass getOneOutManyRule();

	/**
	 * Returns the meta object for class '{@link urml.feature.ManyOutManyRule <em>Many Out Many Rule</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Many Out Many Rule</em>'.
	 * @see urml.feature.ManyOutManyRule
	 * @generated
	 */
	EClass getManyOutManyRule();

	/**
	 * Returns the meta object for the attribute '{@link urml.feature.ManyOutManyRule#getConstraint <em>Constraint</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see urml.feature.ManyOutManyRule#getConstraint()
	 * @see #getManyOutManyRule()
	 * @generated
	 */
	EAttribute getManyOutManyRule_Constraint();

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
		 * The meta object literal for the '{@link urml.feature.impl.AbstractFeatureImpl <em>Abstract Feature</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.AbstractFeatureImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getAbstractFeature()
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
		 * The meta object literal for the '<em><b>Requiering Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__REQUIERING_FEATURES = eINSTANCE.getAbstractFeature_RequieringFeatures();

		/**
		 * The meta object literal for the '<em><b>Requiered Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__REQUIERED_FEATURES = eINSTANCE.getAbstractFeature_RequieredFeatures();

		/**
		 * The meta object literal for the '<em><b>Variation Points</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__VARIATION_POINTS = eINSTANCE.getAbstractFeature_VariationPoints();

		/**
		 * The meta object literal for the '<em><b>Variation Point Instances</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES = eINSTANCE.getAbstractFeature_VariationPointInstances();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.FeatureImpl <em>Feature</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.FeatureImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.VariationPointImpl <em>Variation Point</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.VariationPointImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT__FEATURES = eINSTANCE.getVariationPoint_Features();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT__INSTANCES = eINSTANCE.getVariationPoint_Instances();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT__RULES = eINSTANCE.getVariationPoint_Rules();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.VariationPointInstanceImpl
		 * <em>Variation Point Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.VariationPointInstanceImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getVariationPointInstance()
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
		 * The meta object literal for the '<em><b>Product</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_INSTANCE__PRODUCT = eINSTANCE.getVariationPointInstance_Product();

		/**
		 * The meta object literal for the '<em><b>Selected Features</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_INSTANCE__SELECTED_FEATURES = eINSTANCE.getVariationPointInstance_SelectedFeatures();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.ProductImpl <em>Product</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.ProductImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getProduct()
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
		 * The meta object literal for the '{@link urml.feature.impl.VariationPointRuleImpl
		 * <em>Variation Point Rule</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.VariationPointRuleImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getVariationPointRule()
		 * @generated
		 */
		EClass VARIATION_POINT_RULE = eINSTANCE.getVariationPointRule();

		/**
		 * The meta object literal for the '<em><b>Variation Point</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_POINT_RULE__VARIATION_POINT = eINSTANCE.getVariationPointRule_VariationPoint();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.OneOutManyRuleImpl <em>One Out Many Rule</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.OneOutManyRuleImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getOneOutManyRule()
		 * @generated
		 */
		EClass ONE_OUT_MANY_RULE = eINSTANCE.getOneOutManyRule();

		/**
		 * The meta object literal for the '{@link urml.feature.impl.ManyOutManyRuleImpl <em>Many Out Many Rule</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.feature.impl.ManyOutManyRuleImpl
		 * @see urml.feature.impl.FeaturePackageImpl#getManyOutManyRule()
		 * @generated
		 */
		EClass MANY_OUT_MANY_RULE = eINSTANCE.getManyOutManyRule();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANY_OUT_MANY_RULE__CONSTRAINT = eINSTANCE.getManyOutManyRule_Constraint();

	}

} // FeaturePackage
