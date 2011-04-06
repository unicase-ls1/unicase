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
package org.eclipse.emf.emfstore.server.model.url;

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
 * @see org.eclipse.emf.emfstore.server.model.url.UrlFactory
 * @model kind="package"
 * @generated
 */
public interface UrlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "url";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/url";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.url";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	UrlPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ServerUrlImpl <em>Server Url</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.ServerUrlImpl
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getServerUrl()
	 * @generated
	 */
	int SERVER_URL = 0;

	/**
	 * The feature id for the '<em><b>Host Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_URL__HOST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_URL__PORT = 1;

	/**
	 * The number of structural features of the '<em>Server Url</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_URL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl <em>Project Url Fragment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getProjectUrlFragment()
	 * @generated
	 */
	int PROJECT_URL_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_URL_FRAGMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_URL_FRAGMENT__PROJECT_ID = 1;

	/**
	 * The number of structural features of the '<em>Project Url Fragment</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_URL_FRAGMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlFragmentImpl <em>Model Element Url Fragment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlFragmentImpl
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getModelElementUrlFragment()
	 * @generated
	 */
	int MODEL_ELEMENT_URL_FRAGMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL_FRAGMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID = 1;

	/**
	 * The number of structural features of the '<em>Model Element Url Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL_FRAGMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl <em>Model Element Url</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl
	 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getModelElementUrl()
	 * @generated
	 */
	int MODEL_ELEMENT_URL = 3;

	/**
	 * The feature id for the '<em><b>Server Url</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL__SERVER_URL = 0;

	/**
	 * The feature id for the '<em><b>Project Url Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Model Element Url Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT = 2;

	/**
	 * The number of structural features of the '<em>Model Element Url</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_URL_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.url.ServerUrl <em>Server Url</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Url</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ServerUrl
	 * @generated
	 */
	EClass getServerUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.url.ServerUrl#getHostName <em>Host Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ServerUrl#getHostName()
	 * @see #getServerUrl()
	 * @generated
	 */
	EAttribute getServerUrl_HostName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.url.ServerUrl#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ServerUrl#getPort()
	 * @see #getServerUrl()
	 * @generated
	 */
	EAttribute getServerUrl_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment <em>Project Url Fragment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Url Fragment</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment
	 * @generated
	 */
	EClass getProjectUrlFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment#getName()
	 * @see #getProjectUrlFragment()
	 * @generated
	 */
	EAttribute getProjectUrlFragment_Name();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment#getProjectId <em>Project Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment#getProjectId()
	 * @see #getProjectUrlFragment()
	 * @generated
	 */
	EReference getProjectUrlFragment_ProjectId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment <em>Model Element Url Fragment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Url Fragment</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment
	 * @generated
	 */
	EClass getModelElementUrlFragment();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment#getName()
	 * @see #getModelElementUrlFragment()
	 * @generated
	 */
	EAttribute getModelElementUrlFragment_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment#getModelElementId <em>Model Element Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment#getModelElementId()
	 * @see #getModelElementUrlFragment()
	 * @generated
	 */
	EReference getModelElementUrlFragment_ModelElementId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrl <em>Model Element Url</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Url</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrl
	 * @generated
	 */
	EClass getModelElementUrl();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getServerUrl <em>Server Url</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Server Url</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getServerUrl()
	 * @see #getModelElementUrl()
	 * @generated
	 */
	EReference getModelElementUrl_ServerUrl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getProjectUrlFragment <em>Project Url Fragment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Url Fragment</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getProjectUrlFragment()
	 * @see #getModelElementUrl()
	 * @generated
	 */
	EReference getModelElementUrl_ProjectUrlFragment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getModelElementUrlFragment <em>Model Element Url Fragment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element Url Fragment</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.url.ModelElementUrl#getModelElementUrlFragment()
	 * @see #getModelElementUrl()
	 * @generated
	 */
	EReference getModelElementUrl_ModelElementUrlFragment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UrlFactory getUrlFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ServerUrlImpl <em>Server Url</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.ServerUrlImpl
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getServerUrl()
		 * @generated
		 */
		EClass SERVER_URL = eINSTANCE.getServerUrl();

		/**
		 * The meta object literal for the '<em><b>Host Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_URL__HOST_NAME = eINSTANCE.getServerUrl_HostName();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_URL__PORT = eINSTANCE.getServerUrl_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl <em>Project Url Fragment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.ProjectUrlFragmentImpl
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getProjectUrlFragment()
		 * @generated
		 */
		EClass PROJECT_URL_FRAGMENT = eINSTANCE.getProjectUrlFragment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_URL_FRAGMENT__NAME = eINSTANCE.getProjectUrlFragment_Name();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_URL_FRAGMENT__PROJECT_ID = eINSTANCE.getProjectUrlFragment_ProjectId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlFragmentImpl <em>Model Element Url Fragment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlFragmentImpl
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getModelElementUrlFragment()
		 * @generated
		 */
		EClass MODEL_ELEMENT_URL_FRAGMENT = eINSTANCE.getModelElementUrlFragment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_URL_FRAGMENT__NAME = eINSTANCE.getModelElementUrlFragment_Name();

		/**
		 * The meta object literal for the '<em><b>Model Element Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID = eINSTANCE.getModelElementUrlFragment_ModelElementId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl <em>Model Element Url</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl
		 * @see org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl#getModelElementUrl()
		 * @generated
		 */
		EClass MODEL_ELEMENT_URL = eINSTANCE.getModelElementUrl();

		/**
		 * The meta object literal for the '<em><b>Server Url</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_URL__SERVER_URL = eINSTANCE.getModelElementUrl_ServerUrl();

		/**
		 * The meta object literal for the '<em><b>Project Url Fragment</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT = eINSTANCE.getModelElementUrl_ProjectUrlFragment();

		/**
		 * The meta object literal for the '<em><b>Model Element Url Fragment</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT = eINSTANCE.getModelElementUrl_ModelElementUrlFragment();

	}

} // UrlPackage
