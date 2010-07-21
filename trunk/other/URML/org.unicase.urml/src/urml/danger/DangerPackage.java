/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

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
 * @see urml.danger.DangerFactory
 * @model kind="package"
 * @generated
 */
public interface DangerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "danger";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/danger";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.danger";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DangerPackage eINSTANCE = urml.danger.impl.DangerPackageImpl.init();

	/**
	 * The meta object id for the '{@link urml.danger.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see urml.danger.impl.AssetImpl
	 * @see urml.danger.impl.DangerPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSET__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSET__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSET__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Triggered Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TRIGGERED_DANGERS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Harming Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__HARMING_DANGERS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link urml.danger.impl.DangerImpl <em>Danger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see urml.danger.impl.DangerImpl
	 * @see urml.danger.impl.DangerPackageImpl#getDanger()
	 * @generated
	 */
	int DANGER = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Triggering Assets</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__TRIGGERING_ASSETS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Harmed Assets</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__HARMED_ASSETS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Harmed Classes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__HARMED_CLASSES = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DANGER__MITIGATIONS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Danger</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link urml.danger.impl.MitigationImpl <em>Mitigation</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see urml.danger.impl.MitigationImpl
	 * @see urml.danger.impl.DangerPackageImpl#getMitigation()
	 * @generated
	 */
	int MITIGATION = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__IDENTIFIER = UrmlPackage.URML_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__MITIGATED_DANGERS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mitigation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link urml.danger.impl.ProceduralMitigationImpl <em>Procedural Mitigation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see urml.danger.impl.ProceduralMitigationImpl
	 * @see urml.danger.impl.DangerPackageImpl#getProceduralMitigation()
	 * @generated
	 */
	int PROCEDURAL_MITIGATION = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__IDENTIFIER = MITIGATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__CREATOR = MITIGATION__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__CREATION_DATE = MITIGATION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__NAME = MITIGATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__DESCRIPTION = MITIGATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__ANNOTATIONS = MITIGATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__ATTACHMENTS = MITIGATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__INCOMING_DOCUMENT_REFERENCES = MITIGATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__LEAF_SECTION = MITIGATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__STATE = MITIGATION__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__APPLIED_STEREOTYPE_INSTANCES = MITIGATION__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__COMMENTS = MITIGATION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__MITIGATED_DANGERS = MITIGATION__MITIGATED_DANGERS;

	/**
	 * The feature id for the '<em><b>Mitigation Procedure</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE = MITIGATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Procedural Mitigation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURAL_MITIGATION_FEATURE_COUNT = MITIGATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link urml.danger.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see urml.danger.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Asset#getTriggeredDangers <em>Triggered Dangers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Triggered Dangers</em>'.
	 * @see urml.danger.Asset#getTriggeredDangers()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_TriggeredDangers();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Asset#getHarmingDangers <em>Harming Dangers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Harming Dangers</em>'.
	 * @see urml.danger.Asset#getHarmingDangers()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_HarmingDangers();

	/**
	 * Returns the meta object for class '{@link urml.danger.Danger <em>Danger</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Danger</em>'.
	 * @see urml.danger.Danger
	 * @generated
	 */
	EClass getDanger();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Danger#getTriggeringAssets <em>Triggering Assets</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Triggering Assets</em>'.
	 * @see urml.danger.Danger#getTriggeringAssets()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_TriggeringAssets();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Danger#getHarmedAssets <em>Harmed Assets</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Harmed Assets</em>'.
	 * @see urml.danger.Danger#getHarmedAssets()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_HarmedAssets();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Danger#getHarmedClasses <em>Harmed Classes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Harmed Classes</em>'.
	 * @see urml.danger.Danger#getHarmedClasses()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_HarmedClasses();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Danger#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mitigations</em>'.
	 * @see urml.danger.Danger#getMitigations()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_Mitigations();

	/**
	 * Returns the meta object for class '{@link urml.danger.Mitigation <em>Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mitigation</em>'.
	 * @see urml.danger.Mitigation
	 * @generated
	 */
	EClass getMitigation();

	/**
	 * Returns the meta object for the reference list '{@link urml.danger.Mitigation#getMitigatedDangers <em>Mitigated Dangers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mitigated Dangers</em>'.
	 * @see urml.danger.Mitigation#getMitigatedDangers()
	 * @see #getMitigation()
	 * @generated
	 */
	EReference getMitigation_MitigatedDangers();

	/**
	 * Returns the meta object for class '{@link urml.danger.ProceduralMitigation <em>Procedural Mitigation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Procedural Mitigation</em>'.
	 * @see urml.danger.ProceduralMitigation
	 * @generated
	 */
	EClass getProceduralMitigation();

	/**
	 * Returns the meta object for the attribute '{@link urml.danger.ProceduralMitigation#getMitigationProcedure <em>Mitigation Procedure</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mitigation Procedure</em>'.
	 * @see urml.danger.ProceduralMitigation#getMitigationProcedure()
	 * @see #getProceduralMitigation()
	 * @generated
	 */
	EAttribute getProceduralMitigation_MitigationProcedure();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DangerFactory getDangerFactory();

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
		 * The meta object literal for the '{@link urml.danger.impl.AssetImpl <em>Asset</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.danger.impl.AssetImpl
		 * @see urml.danger.impl.DangerPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '<em><b>Triggered Dangers</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ASSET__TRIGGERED_DANGERS = eINSTANCE.getAsset_TriggeredDangers();

		/**
		 * The meta object literal for the '<em><b>Harming Dangers</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__HARMING_DANGERS = eINSTANCE.getAsset_HarmingDangers();

		/**
		 * The meta object literal for the '{@link urml.danger.impl.DangerImpl <em>Danger</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.danger.impl.DangerImpl
		 * @see urml.danger.impl.DangerPackageImpl#getDanger()
		 * @generated
		 */
		EClass DANGER = eINSTANCE.getDanger();

		/**
		 * The meta object literal for the '<em><b>Triggering Assets</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DANGER__TRIGGERING_ASSETS = eINSTANCE.getDanger_TriggeringAssets();

		/**
		 * The meta object literal for the '<em><b>Harmed Assets</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DANGER__HARMED_ASSETS = eINSTANCE.getDanger_HarmedAssets();

		/**
		 * The meta object literal for the '<em><b>Harmed Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DANGER__HARMED_CLASSES = eINSTANCE.getDanger_HarmedClasses();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DANGER__MITIGATIONS = eINSTANCE.getDanger_Mitigations();

		/**
		 * The meta object literal for the '{@link urml.danger.impl.MitigationImpl <em>Mitigation</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see urml.danger.impl.MitigationImpl
		 * @see urml.danger.impl.DangerPackageImpl#getMitigation()
		 * @generated
		 */
		EClass MITIGATION = eINSTANCE.getMitigation();

		/**
		 * The meta object literal for the '<em><b>Mitigated Dangers</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MITIGATION__MITIGATED_DANGERS = eINSTANCE.getMitigation_MitigatedDangers();

		/**
		 * The meta object literal for the '{@link urml.danger.impl.ProceduralMitigationImpl <em>Procedural Mitigation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see urml.danger.impl.ProceduralMitigationImpl
		 * @see urml.danger.impl.DangerPackageImpl#getProceduralMitigation()
		 * @generated
		 */
		EClass PROCEDURAL_MITIGATION = eINSTANCE.getProceduralMitigation();

		/**
		 * The meta object literal for the '<em><b>Mitigation Procedure</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE = eINSTANCE
			.getProceduralMitigation_MitigationProcedure();

	}

} // DangerPackage
