/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.url.UrlPackage;

/*
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class UrlFactoryImpl extends EFactoryImpl implements UrlFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UrlFactory init() {
		try {
			UrlFactory theUrlFactory = (UrlFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/emfstore/esmodel/url");
			if (theUrlFactory != null) {
				return theUrlFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UrlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UrlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UrlPackage.SERVER_URL:
			return createServerUrl();
		case UrlPackage.PROJECT_URL_FRAGMENT:
			return createProjectUrlFragment();
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT:
			return createModelElementUrlFragment();
		case UrlPackage.MODEL_ELEMENT_URL:
			return createModelElementUrl();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServerUrl createServerUrl() {
		ServerUrlImpl serverUrl = new ServerUrlImpl();
		return serverUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectUrlFragment createProjectUrlFragment() {
		ProjectUrlFragmentImpl projectUrlFragment = new ProjectUrlFragmentImpl();
		return projectUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementUrlFragment createModelElementUrlFragment() {
		ModelElementUrlFragmentImpl modelElementUrlFragment = new ModelElementUrlFragmentImpl();
		return modelElementUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementUrl createModelElementUrl() {
		ModelElementUrlImpl modelElementUrl = new ModelElementUrlImpl();
		return modelElementUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UrlPackage getUrlPackage() {
		return (UrlPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UrlPackage getPackage() {
		return UrlPackage.eINSTANCE;
	}

} // UrlFactoryImpl
