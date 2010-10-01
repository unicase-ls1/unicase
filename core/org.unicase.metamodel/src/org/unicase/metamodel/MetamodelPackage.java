/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

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
 * @see org.unicase.metamodel.MetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = org.unicase.metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.metamodel.impl.IdentifiableElementImpl
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getIdentifiableElement()
	 * @generated
	 */
	int IDENTIFIABLE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.impl.ProjectImpl <em>Project</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.metamodel.impl.ProjectImpl
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Cut Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CUT_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.metamodel.impl.UniqueIdentifierImpl
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getUniqueIdentifier()
	 * @generated
	 */
	int UNIQUE_IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER__ID = 0;

	/**
	 * The number of structural features of the '<em>Unique Identifier</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.impl.ModelElementIdImpl <em>Model Element Id</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.metamodel.impl.ModelElementIdImpl
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getModelElementId()
	 * @generated
	 */
	int MODEL_ELEMENT_ID = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID__ID = UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Model Element Id</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID_FEATURE_COUNT = UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.impl.ModelVersionImpl <em>Model Version</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.metamodel.impl.ModelVersionImpl
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getModelVersion()
	 * @generated
	 */
	int MODEL_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Release Number</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VERSION__RELEASE_NUMBER = 0;

	/**
	 * The number of structural features of the '<em>Model Version</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VERSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.metamodel.NonDomainElement <em>Non Domain Element</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.metamodel.NonDomainElement
	 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getNonDomainElement()
	 * @generated
	 */
	int NON_DOMAIN_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Non Domain Element</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_DOMAIN_ELEMENT_FEATURE_COUNT = 0;

	String MODEL_URL_PREFIX = "http://unicase.org/model/";

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.Project <em>Project</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.unicase.metamodel.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.metamodel.Project#getModelElements <em>Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elements</em>'.
	 * @see org.unicase.metamodel.Project#getModelElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ModelElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.metamodel.Project#getCutElements <em>Cut Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cut Elements</em>'.
	 * @see org.unicase.metamodel.Project#getCutElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_CutElements();

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.UniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Identifier</em>'.
	 * @see org.unicase.metamodel.UniqueIdentifier
	 * @generated
	 */
	EClass getUniqueIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.metamodel.UniqueIdentifier#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.metamodel.UniqueIdentifier#getId()
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	EAttribute getUniqueIdentifier_Id();

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Element</em>'.
	 * @see org.unicase.metamodel.IdentifiableElement
	 * @generated
	 */
	EClass getIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.metamodel.IdentifiableElement#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.metamodel.IdentifiableElement#getIdentifier()
	 * @see #getIdentifiableElement()
	 * @generated
	 */
	EAttribute getIdentifiableElement_Identifier();

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.ModelElementId <em>Model Element Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Element Id</em>'.
	 * @see org.unicase.metamodel.ModelElementId
	 * @generated
	 */
	EClass getModelElementId();

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.ModelVersion <em>Model Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Version</em>'.
	 * @see org.unicase.metamodel.ModelVersion
	 * @generated
	 */
	EClass getModelVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.metamodel.ModelVersion#getReleaseNumber <em>Release Number</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Number</em>'.
	 * @see org.unicase.metamodel.ModelVersion#getReleaseNumber()
	 * @see #getModelVersion()
	 * @generated
	 */
	EAttribute getModelVersion_ReleaseNumber();

	/**
	 * Returns the meta object for class '{@link org.unicase.metamodel.NonDomainElement <em>Non Domain Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Domain Element</em>'.
	 * @see org.unicase.metamodel.NonDomainElement
	 * @generated
	 */
	EClass getNonDomainElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelFactory getMetamodelFactory();

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
		 * The meta object literal for the '{@link org.unicase.metamodel.impl.ProjectImpl <em>Project</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.metamodel.impl.ProjectImpl
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Model Elements</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT__MODEL_ELEMENTS = eINSTANCE.getProject_ModelElements();

		/**
		 * The meta object literal for the '<em><b>Cut Elements</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT__CUT_ELEMENTS = eINSTANCE.getProject_CutElements();

		/**
		 * The meta object literal for the '{@link org.unicase.metamodel.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.metamodel.impl.UniqueIdentifierImpl
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getUniqueIdentifier()
		 * @generated
		 */
		EClass UNIQUE_IDENTIFIER = eINSTANCE.getUniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute UNIQUE_IDENTIFIER__ID = eINSTANCE.getUniqueIdentifier_Id();

		/**
		 * The meta object literal for the '{@link org.unicase.metamodel.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.metamodel.impl.IdentifiableElementImpl
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getIdentifiableElement()
		 * @generated
		 */
		EClass IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE_ELEMENT__IDENTIFIER = eINSTANCE.getIdentifiableElement_Identifier();

		/**
		 * The meta object literal for the '{@link org.unicase.metamodel.impl.ModelElementIdImpl <em>Model Element Id</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.metamodel.impl.ModelElementIdImpl
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getModelElementId()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ID = eINSTANCE.getModelElementId();

		/**
		 * The meta object literal for the '{@link org.unicase.metamodel.impl.ModelVersionImpl <em>Model Version</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.metamodel.impl.ModelVersionImpl
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getModelVersion()
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
		 * The meta object literal for the '{@link org.unicase.metamodel.NonDomainElement <em>Non Domain Element</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.metamodel.NonDomainElement
		 * @see org.unicase.metamodel.impl.MetamodelPackageImpl#getNonDomainElement()
		 * @generated
		 */
		EClass NON_DOMAIN_ELEMENT = eINSTANCE.getNonDomainElement();

	}

} // MetamodelPackage
