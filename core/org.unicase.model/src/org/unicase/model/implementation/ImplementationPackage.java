/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

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
 * @see org.unicase.model.implementation.ImplementationFactory
 * @model kind="package"
 * @generated
 */
public interface ImplementationPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "implementation";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/implementation";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.implementation";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ImplementationPackage eINSTANCE = org.unicase.model.implementation.impl.ImplementationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IPackageImpl <em>IPackage</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IPackageImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIPackage()
	 * @generated
	 */
	int IPACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__NAMESPACE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Package</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__PARENT_PACKAGE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Packages</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__SUB_PACKAGES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__CLASSES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enumerations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE__ENUMERATIONS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>IPackage</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPACKAGE_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IClassImpl <em>IClass</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IClassImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIClass()
	 * @generated
	 */
	int ICLASS = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Parent Package</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__PARENT_PACKAGE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__ABSTRACT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__SUPER_CLASSES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Classes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__SUB_CLASSES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__ATTRIBUTES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outgoing References</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__OUTGOING_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Incoming References</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__INCOMING_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Analysis Classes</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS__ANALYSIS_CLASSES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>IClass</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICLASS_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IFeatureImpl <em>IFeature</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IFeatureImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIFeature()
	 * @generated
	 */
	int IFEATURE = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Minimum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__MINIMUM_MULTIPLICITY = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__MAXIMUM_MULTIPLICITY = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE__TRANSIENT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IFeature</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IFEATURE_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IAttributeImpl <em>IAttribute</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IAttributeImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIAttribute()
	 * @generated
	 */
	int IATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__IDENTIFIER = IFEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__CREATOR = IFEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__CREATION_DATE = IFEATURE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__NAME = IFEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__DESCRIPTION = IFEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__ANNOTATIONS = IFEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__ATTACHMENTS = IFEATURE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__INCOMING_DOCUMENT_REFERENCES = IFEATURE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__LEAF_SECTION = IFEATURE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__STATE = IFEATURE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__APPLIED_STEREOTYPE_INSTANCES = IFEATURE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__COMMENTS = IFEATURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Minimum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__MINIMUM_MULTIPLICITY = IFEATURE__MINIMUM_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Maximum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__MAXIMUM_MULTIPLICITY = IFEATURE__MAXIMUM_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__TRANSIENT = IFEATURE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Parent Class</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__PARENT_CLASS = IFEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__ID = IFEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__TYPE = IFEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE__ENUMERATION = IFEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>IAttribute</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE_FEATURE_COUNT = IFEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IReferenceImpl <em>IReference</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IReferenceImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIReference()
	 * @generated
	 */
	int IREFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__IDENTIFIER = IFEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__CREATOR = IFEATURE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__CREATION_DATE = IFEATURE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__NAME = IFEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__DESCRIPTION = IFEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__ANNOTATIONS = IFEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__ATTACHMENTS = IFEATURE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__INCOMING_DOCUMENT_REFERENCES = IFEATURE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__LEAF_SECTION = IFEATURE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__STATE = IFEATURE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__APPLIED_STEREOTYPE_INSTANCES = IFEATURE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__COMMENTS = IFEATURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Minimum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__MINIMUM_MULTIPLICITY = IFEATURE__MINIMUM_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Maximum Multiplicity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__MAXIMUM_MULTIPLICITY = IFEATURE__MAXIMUM_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__TRANSIENT = IFEATURE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Parent Class</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__PARENT_CLASS = IFEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__TYPE = IFEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__CONTAINMENT = IFEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite Reference</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE__OPPOSITE_REFERENCE = IFEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>IReference</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IREFERENCE_FEATURE_COUNT = IFEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.IEnumerationImpl <em>IEnumeration</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.IEnumerationImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIEnumeration()
	 * @generated
	 */
	int IENUMERATION = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Parent Package</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__PARENT_PACKAGE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__LITERALS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION__ATTRIBUTES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IEnumeration</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IENUMERATION_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.impl.ILiteralImpl <em>ILiteral</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.impl.ILiteralImpl
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getILiteral()
	 * @generated
	 */
	int ILITERAL = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Parent Enumeration</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__PARENT_ENUMERATION = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL__LITERAL = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ILiteral</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ILITERAL_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.implementation.IPrimitiveType <em>IPrimitive Type</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.implementation.IPrimitiveType
	 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIPrimitiveType()
	 * @generated
	 */
	int IPRIMITIVE_TYPE = 7;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IPackage <em>IPackage</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IPackage</em>'.
	 * @see org.unicase.model.implementation.IPackage
	 * @generated
	 */
	EClass getIPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IPackage#getNamespace
	 * <em>Namespace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.unicase.model.implementation.IPackage#getNamespace()
	 * @see #getIPackage()
	 * @generated
	 */
	EAttribute getIPackage_Namespace();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.IPackage#getParentPackage <em>Parent Package</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Package</em>'.
	 * @see org.unicase.model.implementation.IPackage#getParentPackage()
	 * @see #getIPackage()
	 * @generated
	 */
	EReference getIPackage_ParentPackage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IPackage#getSubPackages <em>Sub Packages</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Packages</em>'.
	 * @see org.unicase.model.implementation.IPackage#getSubPackages()
	 * @see #getIPackage()
	 * @generated
	 */
	EReference getIPackage_SubPackages();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IPackage#getClasses <em>Classes</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see org.unicase.model.implementation.IPackage#getClasses()
	 * @see #getIPackage()
	 * @generated
	 */
	EReference getIPackage_Classes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IPackage#getEnumerations <em>Enumerations</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Enumerations</em>'.
	 * @see org.unicase.model.implementation.IPackage#getEnumerations()
	 * @see #getIPackage()
	 * @generated
	 */
	EReference getIPackage_Enumerations();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IClass <em>IClass</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IClass</em>'.
	 * @see org.unicase.model.implementation.IClass
	 * @generated
	 */
	EClass getIClass();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.IClass#getParentPackage <em>Parent Package</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Package</em>'.
	 * @see org.unicase.model.implementation.IClass#getParentPackage()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_ParentPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IClass#isAbstract
	 * <em>Abstract</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.unicase.model.implementation.IClass#isAbstract()
	 * @see #getIClass()
	 * @generated
	 */
	EAttribute getIClass_Abstract();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.implementation.IClass#getSuperClasses
	 * <em>Super Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Super Classes</em>'.
	 * @see org.unicase.model.implementation.IClass#getSuperClasses()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_SuperClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.implementation.IClass#getSubClasses
	 * <em>Sub Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Sub Classes</em>'.
	 * @see org.unicase.model.implementation.IClass#getSubClasses()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_SubClasses();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IClass#getAttributes <em>Attributes</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.unicase.model.implementation.IClass#getAttributes()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IClass#getOutgoingReferences <em>Outgoing References</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Outgoing References</em>'.
	 * @see org.unicase.model.implementation.IClass#getOutgoingReferences()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_OutgoingReferences();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.implementation.IClass#getIncomingReferences <em>Incoming References</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Incoming References</em>'.
	 * @see org.unicase.model.implementation.IClass#getIncomingReferences()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_IncomingReferences();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.implementation.IClass#getAnalysisClasses <em>Analysis Classes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Analysis Classes</em>'.
	 * @see org.unicase.model.implementation.IClass#getAnalysisClasses()
	 * @see #getIClass()
	 * @generated
	 */
	EReference getIClass_AnalysisClasses();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IFeature <em>IFeature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IFeature</em>'.
	 * @see org.unicase.model.implementation.IFeature
	 * @generated
	 */
	EClass getIFeature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.implementation.IFeature#getMinimumMultiplicity <em>Minimum Multiplicity</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Minimum Multiplicity</em>'.
	 * @see org.unicase.model.implementation.IFeature#getMinimumMultiplicity()
	 * @see #getIFeature()
	 * @generated
	 */
	EAttribute getIFeature_MinimumMultiplicity();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.implementation.IFeature#getMaximumMultiplicity <em>Maximum Multiplicity</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Maximum Multiplicity</em>'.
	 * @see org.unicase.model.implementation.IFeature#getMaximumMultiplicity()
	 * @see #getIFeature()
	 * @generated
	 */
	EAttribute getIFeature_MaximumMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IFeature#isTransient
	 * <em>Transient</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see org.unicase.model.implementation.IFeature#isTransient()
	 * @see #getIFeature()
	 * @generated
	 */
	EAttribute getIFeature_Transient();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IAttribute <em>IAttribute</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IAttribute</em>'.
	 * @see org.unicase.model.implementation.IAttribute
	 * @generated
	 */
	EClass getIAttribute();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.IAttribute#getParentClass <em>Parent Class</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Class</em>'.
	 * @see org.unicase.model.implementation.IAttribute#getParentClass()
	 * @see #getIAttribute()
	 * @generated
	 */
	EReference getIAttribute_ParentClass();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IAttribute#isId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.model.implementation.IAttribute#isId()
	 * @see #getIAttribute()
	 * @generated
	 */
	EAttribute getIAttribute_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IAttribute#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.model.implementation.IAttribute#getType()
	 * @see #getIAttribute()
	 * @generated
	 */
	EAttribute getIAttribute_Type();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.implementation.IAttribute#getEnumeration
	 * <em>Enumeration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Enumeration</em>'.
	 * @see org.unicase.model.implementation.IAttribute#getEnumeration()
	 * @see #getIAttribute()
	 * @generated
	 */
	EReference getIAttribute_Enumeration();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IReference <em>IReference</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IReference</em>'.
	 * @see org.unicase.model.implementation.IReference
	 * @generated
	 */
	EClass getIReference();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.IReference#getParentClass <em>Parent Class</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Class</em>'.
	 * @see org.unicase.model.implementation.IReference#getParentClass()
	 * @see #getIReference()
	 * @generated
	 */
	EReference getIReference_ParentClass();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.implementation.IReference#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.unicase.model.implementation.IReference#getType()
	 * @see #getIReference()
	 * @generated
	 */
	EReference getIReference_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.IReference#isContainment
	 * <em>Containment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Containment</em>'.
	 * @see org.unicase.model.implementation.IReference#isContainment()
	 * @see #getIReference()
	 * @generated
	 */
	EAttribute getIReference_Containment();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.implementation.IReference#getOppositeReference <em>Opposite Reference</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Opposite Reference</em>'.
	 * @see org.unicase.model.implementation.IReference#getOppositeReference()
	 * @see #getIReference()
	 * @generated
	 */
	EReference getIReference_OppositeReference();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.IEnumeration <em>IEnumeration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IEnumeration</em>'.
	 * @see org.unicase.model.implementation.IEnumeration
	 * @generated
	 */
	EClass getIEnumeration();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.IEnumeration#getParentPackage <em>Parent Package</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Package</em>'.
	 * @see org.unicase.model.implementation.IEnumeration#getParentPackage()
	 * @see #getIEnumeration()
	 * @generated
	 */
	EReference getIEnumeration_ParentPackage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.implementation.IEnumeration#getLiterals <em>Literals</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.unicase.model.implementation.IEnumeration#getLiterals()
	 * @see #getIEnumeration()
	 * @generated
	 */
	EReference getIEnumeration_Literals();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.implementation.IEnumeration#getAttributes <em>Attributes</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.unicase.model.implementation.IEnumeration#getAttributes()
	 * @see #getIEnumeration()
	 * @generated
	 */
	EReference getIEnumeration_Attributes();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.implementation.ILiteral <em>ILiteral</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ILiteral</em>'.
	 * @see org.unicase.model.implementation.ILiteral
	 * @generated
	 */
	EClass getILiteral();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.implementation.ILiteral#getParentEnumeration <em>Parent Enumeration</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Enumeration</em>'.
	 * @see org.unicase.model.implementation.ILiteral#getParentEnumeration()
	 * @see #getILiteral()
	 * @generated
	 */
	EReference getILiteral_ParentEnumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.implementation.ILiteral#getLiteral
	 * <em>Literal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.unicase.model.implementation.ILiteral#getLiteral()
	 * @see #getILiteral()
	 * @generated
	 */
	EAttribute getILiteral_Literal();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.implementation.IPrimitiveType
	 * <em>IPrimitive Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>IPrimitive Type</em>'.
	 * @see org.unicase.model.implementation.IPrimitiveType
	 * @generated
	 */
	EEnum getIPrimitiveType();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImplementationFactory getImplementationFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IPackageImpl <em>IPackage</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IPackageImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIPackage()
		 * @generated
		 */
		EClass IPACKAGE = eINSTANCE.getIPackage();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IPACKAGE__NAMESPACE = eINSTANCE.getIPackage_Namespace();

		/**
		 * The meta object literal for the '<em><b>Parent Package</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IPACKAGE__PARENT_PACKAGE = eINSTANCE.getIPackage_ParentPackage();

		/**
		 * The meta object literal for the '<em><b>Sub Packages</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IPACKAGE__SUB_PACKAGES = eINSTANCE.getIPackage_SubPackages();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IPACKAGE__CLASSES = eINSTANCE.getIPackage_Classes();

		/**
		 * The meta object literal for the '<em><b>Enumerations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IPACKAGE__ENUMERATIONS = eINSTANCE.getIPackage_Enumerations();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IClassImpl <em>IClass</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IClassImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIClass()
		 * @generated
		 */
		EClass ICLASS = eINSTANCE.getIClass();

		/**
		 * The meta object literal for the '<em><b>Parent Package</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__PARENT_PACKAGE = eINSTANCE.getIClass_ParentPackage();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ICLASS__ABSTRACT = eINSTANCE.getIClass_Abstract();

		/**
		 * The meta object literal for the '<em><b>Super Classes</b></em>' reference list feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__SUPER_CLASSES = eINSTANCE.getIClass_SuperClasses();

		/**
		 * The meta object literal for the '<em><b>Sub Classes</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__SUB_CLASSES = eINSTANCE.getIClass_SubClasses();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__ATTRIBUTES = eINSTANCE.getIClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Outgoing References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__OUTGOING_REFERENCES = eINSTANCE.getIClass_OutgoingReferences();

		/**
		 * The meta object literal for the '<em><b>Incoming References</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__INCOMING_REFERENCES = eINSTANCE.getIClass_IncomingReferences();

		/**
		 * The meta object literal for the '<em><b>Analysis Classes</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ICLASS__ANALYSIS_CLASSES = eINSTANCE.getIClass_AnalysisClasses();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IFeatureImpl <em>IFeature</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IFeatureImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIFeature()
		 * @generated
		 */
		EClass IFEATURE = eINSTANCE.getIFeature();

		/**
		 * The meta object literal for the '<em><b>Minimum Multiplicity</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IFEATURE__MINIMUM_MULTIPLICITY = eINSTANCE.getIFeature_MinimumMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Maximum Multiplicity</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IFEATURE__MAXIMUM_MULTIPLICITY = eINSTANCE.getIFeature_MaximumMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IFEATURE__TRANSIENT = eINSTANCE.getIFeature_Transient();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IAttributeImpl
		 * <em>IAttribute</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IAttributeImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIAttribute()
		 * @generated
		 */
		EClass IATTRIBUTE = eINSTANCE.getIAttribute();

		/**
		 * The meta object literal for the '<em><b>Parent Class</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IATTRIBUTE__PARENT_CLASS = eINSTANCE.getIAttribute_ParentClass();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IATTRIBUTE__ID = eINSTANCE.getIAttribute_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IATTRIBUTE__TYPE = eINSTANCE.getIAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IATTRIBUTE__ENUMERATION = eINSTANCE.getIAttribute_Enumeration();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IReferenceImpl
		 * <em>IReference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IReferenceImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIReference()
		 * @generated
		 */
		EClass IREFERENCE = eINSTANCE.getIReference();

		/**
		 * The meta object literal for the '<em><b>Parent Class</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IREFERENCE__PARENT_CLASS = eINSTANCE.getIReference_ParentClass();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IREFERENCE__TYPE = eINSTANCE.getIReference_Type();

		/**
		 * The meta object literal for the '<em><b>Containment</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IREFERENCE__CONTAINMENT = eINSTANCE.getIReference_Containment();

		/**
		 * The meta object literal for the '<em><b>Opposite Reference</b></em>' reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IREFERENCE__OPPOSITE_REFERENCE = eINSTANCE.getIReference_OppositeReference();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.IEnumerationImpl
		 * <em>IEnumeration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.IEnumerationImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIEnumeration()
		 * @generated
		 */
		EClass IENUMERATION = eINSTANCE.getIEnumeration();

		/**
		 * The meta object literal for the '<em><b>Parent Package</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IENUMERATION__PARENT_PACKAGE = eINSTANCE.getIEnumeration_ParentPackage();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IENUMERATION__LITERALS = eINSTANCE.getIEnumeration_Literals();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IENUMERATION__ATTRIBUTES = eINSTANCE.getIEnumeration_Attributes();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.impl.ILiteralImpl <em>ILiteral</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.impl.ILiteralImpl
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getILiteral()
		 * @generated
		 */
		EClass ILITERAL = eINSTANCE.getILiteral();

		/**
		 * The meta object literal for the '<em><b>Parent Enumeration</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ILITERAL__PARENT_ENUMERATION = eINSTANCE.getILiteral_ParentEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ILITERAL__LITERAL = eINSTANCE.getILiteral_Literal();

		/**
		 * The meta object literal for the '{@link org.unicase.model.implementation.IPrimitiveType
		 * <em>IPrimitive Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.implementation.IPrimitiveType
		 * @see org.unicase.model.implementation.impl.ImplementationPackageImpl#getIPrimitiveType()
		 * @generated
		 */
		EEnum IPRIMITIVE_TYPE = eINSTANCE.getIPrimitiveType();

	}

} // ImplementationPackage
