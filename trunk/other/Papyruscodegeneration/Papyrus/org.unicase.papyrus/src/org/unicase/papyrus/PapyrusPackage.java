/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.UMLPackage;

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
 * @see org.unicase.papyrus.PapyrusFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "papyrus";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/papyrus";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.papyrus";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PapyrusPackage eINSTANCE = org.unicase.papyrus.impl.PapyrusPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.impl.UMLModelImpl <em>UML Model</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.papyrus.impl.UMLModelImpl
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLModel()
	 * @generated
	 */
	int UML_MODEL = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__EANNOTATIONS = UMLPackage.MODEL__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_ELEMENT = UMLPackage.MODEL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNER = UMLPackage.MODEL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_COMMENT = UMLPackage.MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAME = UMLPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__VISIBILITY = UMLPackage.MODEL__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__QUALIFIED_NAME = UMLPackage.MODEL__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__CLIENT_DEPENDENCY = UMLPackage.MODEL__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAMESPACE = UMLPackage.MODEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAME_EXPRESSION = UMLPackage.MODEL__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__ELEMENT_IMPORT = UMLPackage.MODEL__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGE_IMPORT = UMLPackage.MODEL__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_RULE = UMLPackage.MODEL__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__MEMBER = UMLPackage.MODEL__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__IMPORTED_MEMBER = UMLPackage.MODEL__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_MEMBER = UMLPackage.MODEL__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNING_TEMPLATE_PARAMETER = UMLPackage.MODEL__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__TEMPLATE_PARAMETER = UMLPackage.MODEL__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__TEMPLATE_BINDING = UMLPackage.MODEL__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_TEMPLATE_SIGNATURE = UMLPackage.MODEL__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_TYPE = UMLPackage.MODEL__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Package Merge</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGE_MERGE = UMLPackage.MODEL__PACKAGE_MERGE;

	/**
	 * The feature id for the '<em><b>Packaged Element</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGED_ELEMENT = UMLPackage.MODEL__PACKAGED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NESTED_PACKAGE = UMLPackage.MODEL__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NESTING_PACKAGE = UMLPackage.MODEL__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PROFILE_APPLICATION = UMLPackage.MODEL__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__VIEWPOINT = UMLPackage.MODEL__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Gmf Diagram</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__GMF_DIAGRAM = UMLPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__DIAGRAM_TYPE = UMLPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_FEATURE_COUNT = UMLPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.impl.SysMLModelImpl <em>Sys ML Model</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.papyrus.impl.SysMLModelImpl
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLModel()
	 * @generated
	 */
	int SYS_ML_MODEL = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__EANNOTATIONS = UMLPackage.MODEL__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_ELEMENT = UMLPackage.MODEL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNER = UMLPackage.MODEL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_COMMENT = UMLPackage.MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__NAME = UMLPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__VISIBILITY = UMLPackage.MODEL__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__QUALIFIED_NAME = UMLPackage.MODEL__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__CLIENT_DEPENDENCY = UMLPackage.MODEL__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__NAMESPACE = UMLPackage.MODEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__NAME_EXPRESSION = UMLPackage.MODEL__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__ELEMENT_IMPORT = UMLPackage.MODEL__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__PACKAGE_IMPORT = UMLPackage.MODEL__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_RULE = UMLPackage.MODEL__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__MEMBER = UMLPackage.MODEL__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__IMPORTED_MEMBER = UMLPackage.MODEL__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_MEMBER = UMLPackage.MODEL__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNING_TEMPLATE_PARAMETER = UMLPackage.MODEL__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__TEMPLATE_PARAMETER = UMLPackage.MODEL__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__TEMPLATE_BINDING = UMLPackage.MODEL__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_TEMPLATE_SIGNATURE = UMLPackage.MODEL__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__OWNED_TYPE = UMLPackage.MODEL__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Package Merge</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__PACKAGE_MERGE = UMLPackage.MODEL__PACKAGE_MERGE;

	/**
	 * The feature id for the '<em><b>Packaged Element</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__PACKAGED_ELEMENT = UMLPackage.MODEL__PACKAGED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__NESTED_PACKAGE = UMLPackage.MODEL__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__NESTING_PACKAGE = UMLPackage.MODEL__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__PROFILE_APPLICATION = UMLPackage.MODEL__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__VIEWPOINT = UMLPackage.MODEL__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Gmf Diagram</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__GMF_DIAGRAM = UMLPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL__DIAGRAM_TYPE = UMLPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sys ML Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_MODEL_FEATURE_COUNT = UMLPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.impl.SysMLClassImpl <em>Sys ML Class</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.papyrus.impl.SysMLClassImpl
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLClass()
	 * @generated
	 */
	int SYS_ML_CLASS = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__EANNOTATIONS = UMLPackage.CLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_ELEMENT = UMLPackage.CLASS__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNER = UMLPackage.CLASS__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_COMMENT = UMLPackage.CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__NAME = UMLPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__VISIBILITY = UMLPackage.CLASS__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__QUALIFIED_NAME = UMLPackage.CLASS__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__CLIENT_DEPENDENCY = UMLPackage.CLASS__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__NAMESPACE = UMLPackage.CLASS__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__NAME_EXPRESSION = UMLPackage.CLASS__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__ELEMENT_IMPORT = UMLPackage.CLASS__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__PACKAGE_IMPORT = UMLPackage.CLASS__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_RULE = UMLPackage.CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__MEMBER = UMLPackage.CLASS__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__IMPORTED_MEMBER = UMLPackage.CLASS__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_MEMBER = UMLPackage.CLASS__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__IS_LEAF = UMLPackage.CLASS__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__REDEFINED_ELEMENT = UMLPackage.CLASS__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__REDEFINITION_CONTEXT = UMLPackage.CLASS__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNING_TEMPLATE_PARAMETER = UMLPackage.CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__TEMPLATE_PARAMETER = UMLPackage.CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__PACKAGE = UMLPackage.CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__TEMPLATE_BINDING = UMLPackage.CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_TEMPLATE_SIGNATURE = UMLPackage.CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__IS_ABSTRACT = UMLPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__GENERALIZATION = UMLPackage.CLASS__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__POWERTYPE_EXTENT = UMLPackage.CLASS__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__FEATURE = UMLPackage.CLASS__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__INHERITED_MEMBER = UMLPackage.CLASS__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__REDEFINED_CLASSIFIER = UMLPackage.CLASS__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__GENERAL = UMLPackage.CLASS__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__SUBSTITUTION = UMLPackage.CLASS__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__ATTRIBUTE = UMLPackage.CLASS__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__REPRESENTATION = UMLPackage.CLASS__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__COLLABORATION_USE = UMLPackage.CLASS__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_USE_CASE = UMLPackage.CLASS__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__USE_CASE = UMLPackage.CLASS__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_ATTRIBUTE = UMLPackage.CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__PART = UMLPackage.CLASS__PART;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__ROLE = UMLPackage.CLASS__ROLE;

	/**
	 * The feature id for the '<em><b>Owned Connector</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_CONNECTOR = UMLPackage.CLASS__OWNED_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Owned Port</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_PORT = UMLPackage.CLASS__OWNED_PORT;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_BEHAVIOR = UMLPackage.CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Classifier Behavior</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__CLASSIFIER_BEHAVIOR = UMLPackage.CLASS__CLASSIFIER_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Interface Realization</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__INTERFACE_REALIZATION = UMLPackage.CLASS__INTERFACE_REALIZATION;

	/**
	 * The feature id for the '<em><b>Owned Trigger</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_TRIGGER = UMLPackage.CLASS__OWNED_TRIGGER;

	/**
	 * The feature id for the '<em><b>Nested Classifier</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__NESTED_CLASSIFIER = UMLPackage.CLASS__NESTED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_OPERATION = UMLPackage.CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__SUPER_CLASS = UMLPackage.CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__IS_ACTIVE = UMLPackage.CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Owned Reception</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__OWNED_RECEPTION = UMLPackage.CLASS__OWNED_RECEPTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__EXTENSION = UMLPackage.CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Gmf Diagram</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS__GMF_DIAGRAM = UMLPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sys ML Class</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYS_ML_CLASS_FEATURE_COUNT = UMLPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLDiagramType()
	 * @generated
	 */
	int UML_DIAGRAM_TYPE = 3;

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.SysMLDiagramType <em>Sys ML Diagram Type</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.papyrus.SysMLDiagramType
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLDiagramType()
	 * @generated
	 */
	int SYS_ML_DIAGRAM_TYPE = 4;

	/**
	 * Returns the meta object for class '{@link org.unicase.papyrus.UMLModel <em>UML Model</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UML Model</em>'.
	 * @see org.unicase.papyrus.UMLModel
	 * @generated
	 */
	EClass getUMLModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.papyrus.UMLModel#getGmfDiagram
	 * <em>Gmf Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gmf Diagram</em>'.
	 * @see org.unicase.papyrus.UMLModel#getGmfDiagram()
	 * @see #getUMLModel()
	 * @generated
	 */
	EReference getUMLModel_GmfDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.papyrus.UMLModel#getDiagramType
	 * <em>Diagram Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see org.unicase.papyrus.UMLModel#getDiagramType()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_DiagramType();

	/**
	 * Returns the meta object for class '{@link org.unicase.papyrus.SysMLModel <em>Sys ML Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sys ML Model</em>'.
	 * @see org.unicase.papyrus.SysMLModel
	 * @generated
	 */
	EClass getSysMLModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.papyrus.SysMLModel#getGmfDiagram
	 * <em>Gmf Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gmf Diagram</em>'.
	 * @see org.unicase.papyrus.SysMLModel#getGmfDiagram()
	 * @see #getSysMLModel()
	 * @generated
	 */
	EReference getSysMLModel_GmfDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.papyrus.SysMLModel#getDiagramType
	 * <em>Diagram Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see org.unicase.papyrus.SysMLModel#getDiagramType()
	 * @see #getSysMLModel()
	 * @generated
	 */
	EAttribute getSysMLModel_DiagramType();

	/**
	 * Returns the meta object for class '{@link org.unicase.papyrus.SysMLClass <em>Sys ML Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sys ML Class</em>'.
	 * @see org.unicase.papyrus.SysMLClass
	 * @generated
	 */
	EClass getSysMLClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.papyrus.SysMLClass#getGmfDiagram
	 * <em>Gmf Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gmf Diagram</em>'.
	 * @see org.unicase.papyrus.SysMLClass#getGmfDiagram()
	 * @see #getSysMLClass()
	 * @generated
	 */
	EReference getSysMLClass_GmfDiagram();

	/**
	 * Returns the meta object for enum '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>UML Diagram Type</em>'.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @generated
	 */
	EEnum getUMLDiagramType();

	/**
	 * Returns the meta object for enum '{@link org.unicase.papyrus.SysMLDiagramType <em>Sys ML Diagram Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Sys ML Diagram Type</em>'.
	 * @see org.unicase.papyrus.SysMLDiagramType
	 * @generated
	 */
	EEnum getSysMLDiagramType();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusFactory getPapyrusFactory();

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
		 * The meta object literal for the '{@link org.unicase.papyrus.impl.UMLModelImpl <em>UML Model</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.papyrus.impl.UMLModelImpl
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLModel()
		 * @generated
		 */
		EClass UML_MODEL = eINSTANCE.getUMLModel();

		/**
		 * The meta object literal for the '<em><b>Gmf Diagram</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UML_MODEL__GMF_DIAGRAM = eINSTANCE.getUMLModel_GmfDiagram();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_MODEL__DIAGRAM_TYPE = eINSTANCE.getUMLModel_DiagramType();

		/**
		 * The meta object literal for the '{@link org.unicase.papyrus.impl.SysMLModelImpl <em>Sys ML Model</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.papyrus.impl.SysMLModelImpl
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLModel()
		 * @generated
		 */
		EClass SYS_ML_MODEL = eINSTANCE.getSysMLModel();

		/**
		 * The meta object literal for the '<em><b>Gmf Diagram</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYS_ML_MODEL__GMF_DIAGRAM = eINSTANCE.getSysMLModel_GmfDiagram();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYS_ML_MODEL__DIAGRAM_TYPE = eINSTANCE.getSysMLModel_DiagramType();

		/**
		 * The meta object literal for the '{@link org.unicase.papyrus.impl.SysMLClassImpl <em>Sys ML Class</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.papyrus.impl.SysMLClassImpl
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLClass()
		 * @generated
		 */
		EClass SYS_ML_CLASS = eINSTANCE.getSysMLClass();

		/**
		 * The meta object literal for the '<em><b>Gmf Diagram</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYS_ML_CLASS__GMF_DIAGRAM = eINSTANCE.getSysMLClass_GmfDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.papyrus.UMLDiagramType
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLDiagramType()
		 * @generated
		 */
		EEnum UML_DIAGRAM_TYPE = eINSTANCE.getUMLDiagramType();

		/**
		 * The meta object literal for the '{@link org.unicase.papyrus.SysMLDiagramType <em>Sys ML Diagram Type</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.papyrus.SysMLDiagramType
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getSysMLDiagramType()
		 * @generated
		 */
		EEnum SYS_ML_DIAGRAM_TYPE = eINSTANCE.getSysMLDiagramType();

	}

} // PapyrusPackage
