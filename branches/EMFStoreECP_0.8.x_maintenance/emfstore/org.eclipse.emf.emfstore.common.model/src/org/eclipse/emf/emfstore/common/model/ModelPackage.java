/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.common.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/common/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.common.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.ProjectImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Cut Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CUT_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.UniqueIdentifierImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getUniqueIdentifier()
	 * @generated
	 */
	int UNIQUE_IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER__ID = 0;

	/**
	 * The number of structural features of the '<em>Unique Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getIdentifiableElement()
	 * @generated
	 */
	int IDENTIFIABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.ModelElementIdImpl <em>Element Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelElementIdImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getModelElementId()
	 * @generated
	 */
	int MODEL_ELEMENT_ID = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID__ID = UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Element Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID_FEATURE_COUNT = UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.ModelVersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelVersionImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getModelVersion()
	 * @generated
	 */
	int MODEL_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Release Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VERSION__RELEASE_NUMBER = 0;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VERSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.NonDomainElement <em>Non Domain Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.NonDomainElement
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getNonDomainElement()
	 * @generated
	 */
	int NON_DOMAIN_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Non Domain Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_DOMAIN_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.AssociationClassElement <em>Association Class Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.AssociationClassElement
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getAssociationClassElement()
	 * @generated
	 */
	int ASSOCIATION_CLASS_ELEMENT = 6;

	/**
	 * The number of structural features of the '<em>Association Class Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.impl.EMFStorePropertyImpl <em>EMF Store Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.impl.EMFStorePropertyImpl
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getEMFStoreProperty()
	 * @generated
	 */
	int EMF_STORE_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_PROPERTY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_PROPERTY__TYPE = 2;

	/**
	 * The number of structural features of the '<em>EMF Store Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.common.model.EMFStorePropertyType <em>EMF Store Property Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.model.EMFStorePropertyType
	 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getEMFStorePropertyType()
	 * @generated
	 */
	int EMF_STORE_PROPERTY_TYPE = 8;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.common.model.Project#getModelElements <em>Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elements</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.Project#getModelElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ModelElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.common.model.Project#getCutElements <em>Cut Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cut Elements</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.Project#getCutElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_CutElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.UniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Identifier</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.UniqueIdentifier
	 * @generated
	 */
	EClass getUniqueIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.common.model.UniqueIdentifier#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.UniqueIdentifier#getId()
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	EAttribute getUniqueIdentifier_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Element</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.IdentifiableElement
	 * @generated
	 */
	EClass getIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.common.model.IdentifiableElement#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.IdentifiableElement#getIdentifier()
	 * @see #getIdentifiableElement()
	 * @generated
	 */
	EAttribute getIdentifiableElement_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.ModelElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Id</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.ModelElementId
	 * @generated
	 */
	EClass getModelElementId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.ModelVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.ModelVersion
	 * @generated
	 */
	EClass getModelVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.common.model.ModelVersion#getReleaseNumber <em>Release Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Number</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.ModelVersion#getReleaseNumber()
	 * @see #getModelVersion()
	 * @generated
	 */
	EAttribute getModelVersion_ReleaseNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.NonDomainElement <em>Non Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Domain Element</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.NonDomainElement
	 * @generated
	 */
	EClass getNonDomainElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.AssociationClassElement <em>Association Class Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Element</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.AssociationClassElement
	 * @generated
	 */
	EClass getAssociationClassElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty <em>EMF Store Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Store Property</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStoreProperty
	 * @generated
	 */
	EClass getEMFStoreProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getKey()
	 * @see #getEMFStoreProperty()
	 * @generated
	 */
	EAttribute getEMFStoreProperty_Key();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getValue()
	 * @see #getEMFStoreProperty()
	 * @generated
	 */
	EReference getEMFStoreProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStoreProperty#getType()
	 * @see #getEMFStoreProperty()
	 * @generated
	 */
	EAttribute getEMFStoreProperty_Type();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.emfstore.common.model.EMFStorePropertyType <em>EMF Store Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMF Store Property Type</em>'.
	 * @see org.eclipse.emf.emfstore.common.model.EMFStorePropertyType
	 * @generated
	 */
	EEnum getEMFStorePropertyType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.ProjectImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__MODEL_ELEMENTS = eINSTANCE.getProject_ModelElements();

		/**
		 * The meta object literal for the '<em><b>Cut Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CUT_ELEMENTS = eINSTANCE.getProject_CutElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.UniqueIdentifierImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getUniqueIdentifier()
		 * @generated
		 */
		EClass UNIQUE_IDENTIFIER = eINSTANCE.getUniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIQUE_IDENTIFIER__ID = eINSTANCE.getUniqueIdentifier_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getIdentifiableElement()
		 * @generated
		 */
		EClass IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE_ELEMENT__IDENTIFIER = eINSTANCE.getIdentifiableElement_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.ModelElementIdImpl <em>Element Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelElementIdImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getModelElementId()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ID = eINSTANCE.getModelElementId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.ModelVersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelVersionImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getModelVersion()
		 * @generated
		 */
		EClass MODEL_VERSION = eINSTANCE.getModelVersion();

		/**
		 * The meta object literal for the '<em><b>Release Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_VERSION__RELEASE_NUMBER = eINSTANCE.getModelVersion_ReleaseNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.NonDomainElement <em>Non Domain Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.NonDomainElement
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getNonDomainElement()
		 * @generated
		 */
		EClass NON_DOMAIN_ELEMENT = eINSTANCE.getNonDomainElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.AssociationClassElement <em>Association Class Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.AssociationClassElement
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getAssociationClassElement()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_ELEMENT = eINSTANCE.getAssociationClassElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.impl.EMFStorePropertyImpl <em>EMF Store Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.impl.EMFStorePropertyImpl
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getEMFStoreProperty()
		 * @generated
		 */
		EClass EMF_STORE_PROPERTY = eINSTANCE.getEMFStoreProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_STORE_PROPERTY__KEY = eINSTANCE.getEMFStoreProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMF_STORE_PROPERTY__VALUE = eINSTANCE.getEMFStoreProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_STORE_PROPERTY__TYPE = eINSTANCE.getEMFStoreProperty_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.common.model.EMFStorePropertyType <em>EMF Store Property Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.model.EMFStorePropertyType
		 * @see org.eclipse.emf.emfstore.common.model.impl.ModelPackageImpl#getEMFStorePropertyType()
		 * @generated
		 */
		EEnum EMF_STORE_PROPERTY_TYPE = eINSTANCE.getEMFStorePropertyType();

	}

} // ModelPackage
