/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.unicase.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.UnicaseModelElementImpl <em>Unicase Model Element</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.impl.UnicaseModelElementImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getUnicaseModelElement()
	 * @generated
	 */
	int UNICASE_MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__ANNOTATIONS = 2;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__ATTACHMENTS = 3;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__STATE = 5;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES = 6;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__COMMENTS = 7;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__CREATION_DATE = 8;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT__CREATOR = 9;

	/**
	 * The number of structural features of the '<em>Unicase Model Element</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICASE_MODEL_ELEMENT_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.AnnotationImpl <em>Annotation</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.impl.AnnotationImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__DESCRIPTION = UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATIONS = UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ATTACHMENTS = UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__INCOMING_DOCUMENT_REFERENCES = UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__STATE = UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__APPLIED_STEREOTYPE_INSTANCES = UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__COMMENTS = UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CREATION_DATE = UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CREATOR = UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATED_MODEL_ELEMENTS = UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.AttachmentImpl <em>Attachment</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.impl.AttachmentImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getAttachment()
	 * @generated
	 */
	int ATTACHMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__NAME = UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__DESCRIPTION = UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__ANNOTATIONS = UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__ATTACHMENTS = UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__INCOMING_DOCUMENT_REFERENCES = UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__STATE = UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES = UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__COMMENTS = UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__CREATION_DATE = UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__CREATOR = UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__REFERRING_MODEL_ELEMENTS = UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attachment</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_FEATURE_COUNT = UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.impl.ProjectImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 3;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL_ELEMENTS = org.eclipse.emf.emfstore.internal.common.model.ModelPackage.PROJECT__MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Cut Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CUT_ELEMENTS = org.eclipse.emf.emfstore.internal.common.model.ModelPackage.PROJECT__CUT_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = org.eclipse.emf.emfstore.internal.common.model.ModelPackage.PROJECT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.UnicaseModelElement <em>Unicase Model Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unicase Model Element</em>'.
	 * @see org.unicase.model.UnicaseModelElement
	 * @generated
	 */
	EClass getUnicaseModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UnicaseModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getName()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EAttribute getUnicaseModelElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UnicaseModelElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getDescription()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EAttribute getUnicaseModelElement_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.UnicaseModelElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotations</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getAnnotations()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EReference getUnicaseModelElement_Annotations();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.UnicaseModelElement#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attachments</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getAttachments()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EReference getUnicaseModelElement_Attachments();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.UnicaseModelElement#getIncomingDocumentReferences <em>Incoming Document References</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Document References</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getIncomingDocumentReferences()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EReference getUnicaseModelElement_IncomingDocumentReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UnicaseModelElement#getState <em>State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getState()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EAttribute getUnicaseModelElement_State();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.UnicaseModelElement#getAppliedStereotypeInstances <em>Applied Stereotype Instances</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applied Stereotype Instances</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getAppliedStereotypeInstances()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EReference getUnicaseModelElement_AppliedStereotypeInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.UnicaseModelElement#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comments</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getComments()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EReference getUnicaseModelElement_Comments();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UnicaseModelElement#getCreator <em>Creator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creator</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getCreator()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EAttribute getUnicaseModelElement_Creator();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UnicaseModelElement#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see org.unicase.model.UnicaseModelElement#getCreationDate()
	 * @see #getUnicaseModelElement()
	 * @generated
	 */
	EAttribute getUnicaseModelElement_CreationDate();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.unicase.model.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.Annotation#getAnnotatedModelElements <em>Annotated Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotated Model Elements</em>'.
	 * @see org.unicase.model.Annotation#getAnnotatedModelElements()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_AnnotatedModelElements();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment</em>'.
	 * @see org.unicase.model.Attachment
	 * @generated
	 */
	EClass getAttachment();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.Attachment#getReferringModelElements <em>Referring Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referring Model Elements</em>'.
	 * @see org.unicase.model.Attachment#getReferringModelElements()
	 * @see #getAttachment()
	 * @generated
	 */
	EReference getAttachment_ReferringModelElements();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.unicase.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.impl.UnicaseModelElementImpl <em>Unicase Model Element</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.impl.UnicaseModelElementImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getUnicaseModelElement()
		 * @generated
		 */
		EClass UNICASE_MODEL_ELEMENT = eINSTANCE.getUnicaseModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute UNICASE_MODEL_ELEMENT__NAME = eINSTANCE
				.getUnicaseModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute UNICASE_MODEL_ELEMENT__DESCRIPTION = eINSTANCE
				.getUnicaseModelElement_Description();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNICASE_MODEL_ELEMENT__ANNOTATIONS = eINSTANCE
				.getUnicaseModelElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNICASE_MODEL_ELEMENT__ATTACHMENTS = eINSTANCE
				.getUnicaseModelElement_Attachments();

		/**
		 * The meta object literal for the '<em><b>Incoming Document References</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES = eINSTANCE
				.getUnicaseModelElement_IncomingDocumentReferences();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute UNICASE_MODEL_ELEMENT__STATE = eINSTANCE
				.getUnicaseModelElement_State();

		/**
		 * The meta object literal for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES = eINSTANCE
				.getUnicaseModelElement_AppliedStereotypeInstances();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UNICASE_MODEL_ELEMENT__COMMENTS = eINSTANCE
				.getUnicaseModelElement_Comments();

		/**
		 * The meta object literal for the '<em><b>Creator</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute UNICASE_MODEL_ELEMENT__CREATOR = eINSTANCE
				.getUnicaseModelElement_Creator();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNICASE_MODEL_ELEMENT__CREATION_DATE = eINSTANCE
				.getUnicaseModelElement_CreationDate();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.impl.AnnotationImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Annotated Model Elements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION__ANNOTATED_MODEL_ELEMENTS = eINSTANCE
				.getAnnotation_AnnotatedModelElements();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.AttachmentImpl <em>Attachment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.impl.AttachmentImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getAttachment()
		 * @generated
		 */
		EClass ATTACHMENT = eINSTANCE.getAttachment();

		/**
		 * The meta object literal for the '<em><b>Referring Model Elements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ATTACHMENT__REFERRING_MODEL_ELEMENTS = eINSTANCE
				.getAttachment_ReferringModelElements();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.impl.ProjectImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

	}

} // ModelPackage
