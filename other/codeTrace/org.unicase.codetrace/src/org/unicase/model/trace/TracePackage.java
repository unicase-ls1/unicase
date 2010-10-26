/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.metamodel.MetamodelPackage;
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
 * @see org.unicase.model.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/codetrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = org.unicase.model.trace.impl.TracePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.trace.impl.CodeLocationImpl <em>Code Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.trace.impl.CodeLocationImpl
	 * @see org.unicase.model.trace.impl.TracePackageImpl#getCodeLocation()
	 * @generated
	 */
	int CODE_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__IDENTIFIER = ModelPackage.ATTACHMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__CREATOR = ModelPackage.ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__CREATION_DATE = ModelPackage.ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__NAME = ModelPackage.ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__DESCRIPTION = ModelPackage.ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__ANNOTATIONS = ModelPackage.ATTACHMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__ATTACHMENTS = ModelPackage.ATTACHMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__LEAF_SECTION = ModelPackage.ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__STATE = ModelPackage.ATTACHMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__COMMENTS = ModelPackage.ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__REFERRING_MODEL_ELEMENTS = ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Line Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__LINE_CONTENT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__PROJECT_NAME = ModelPackage.ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path In Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__PATH_IN_PROJECT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lines Before</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__LINES_BEFORE = ModelPackage.ATTACHMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Lines After</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__LINES_AFTER = ModelPackage.ATTACHMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Code Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION_FEATURE_COUNT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.trace.impl.LineHashImpl <em>Line Hash</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.trace.impl.LineHashImpl
	 * @see org.unicase.model.trace.impl.TracePackageImpl#getLineHash()
	 * @generated
	 */
	int LINE_HASH = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_HASH__IDENTIFIER = MetamodelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_HASH__CREATOR = MetamodelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_HASH__CREATION_DATE = MetamodelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_HASH__HASH = MetamodelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Line Hash</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_HASH_FEATURE_COUNT = MetamodelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.trace.CodeLocation <em>Code Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Location</em>'.
	 * @see org.unicase.model.trace.CodeLocation
	 * @generated
	 */
	EClass getCodeLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.trace.CodeLocation#getLineContent <em>Line Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Content</em>'.
	 * @see org.unicase.model.trace.CodeLocation#getLineContent()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_LineContent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.trace.CodeLocation#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.unicase.model.trace.CodeLocation#getProjectName()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.trace.CodeLocation#getPathInProject <em>Path In Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path In Project</em>'.
	 * @see org.unicase.model.trace.CodeLocation#getPathInProject()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_PathInProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.trace.CodeLocation#getLinesBefore <em>Lines Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines Before</em>'.
	 * @see org.unicase.model.trace.CodeLocation#getLinesBefore()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EReference getCodeLocation_LinesBefore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.trace.CodeLocation#getLinesAfter <em>Lines After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines After</em>'.
	 * @see org.unicase.model.trace.CodeLocation#getLinesAfter()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EReference getCodeLocation_LinesAfter();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.trace.LineHash <em>Line Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Hash</em>'.
	 * @see org.unicase.model.trace.LineHash
	 * @generated
	 */
	EClass getLineHash();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.trace.LineHash#getHash <em>Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hash</em>'.
	 * @see org.unicase.model.trace.LineHash#getHash()
	 * @see #getLineHash()
	 * @generated
	 */
	EAttribute getLineHash_Hash();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.trace.impl.CodeLocationImpl <em>Code Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.trace.impl.CodeLocationImpl
		 * @see org.unicase.model.trace.impl.TracePackageImpl#getCodeLocation()
		 * @generated
		 */
		EClass CODE_LOCATION = eINSTANCE.getCodeLocation();

		/**
		 * The meta object literal for the '<em><b>Line Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__LINE_CONTENT = eINSTANCE
				.getCodeLocation_LineContent();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__PROJECT_NAME = eINSTANCE
				.getCodeLocation_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Path In Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__PATH_IN_PROJECT = eINSTANCE
				.getCodeLocation_PathInProject();

		/**
		 * The meta object literal for the '<em><b>Lines Before</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_LOCATION__LINES_BEFORE = eINSTANCE
				.getCodeLocation_LinesBefore();

		/**
		 * The meta object literal for the '<em><b>Lines After</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_LOCATION__LINES_AFTER = eINSTANCE
				.getCodeLocation_LinesAfter();

		/**
		 * The meta object literal for the '{@link org.unicase.model.trace.impl.LineHashImpl <em>Line Hash</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.trace.impl.LineHashImpl
		 * @see org.unicase.model.trace.impl.TracePackageImpl#getLineHash()
		 * @generated
		 */
		EClass LINE_HASH = eINSTANCE.getLineHash();

		/**
		 * The meta object literal for the '<em><b>Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_HASH__HASH = eINSTANCE.getLineHash_Hash();

	}

} //TracePackage
