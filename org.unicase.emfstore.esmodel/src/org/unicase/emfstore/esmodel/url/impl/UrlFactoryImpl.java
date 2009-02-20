/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url.impl;

import java.net.MalformedURLException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;

/*
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class UrlFactoryImpl extends EFactoryImpl implements UrlFactory {

	/**
	 * The prefix for all unicase URLs.
	 * 
	 * @generated NOT
	 */
	public static final String PREFIX = "unicase://";

	/**
	 * The standard parsing exception message.
	 * 
	 * @generated NOT
	 */
	private static final String EXCEPTION_MESSAGE = "Invalid unicase URL!";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static UrlFactory init() {
		try {
			UrlFactory theUrlFactory = (UrlFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/emfstore/esmodel/url"); 
			if (theUrlFactory != null) {
				return theUrlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UrlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UrlPackage.SERVER_URL: return createServerUrl();
			case UrlPackage.PROJECT_URL_FRAGMENT: return createProjectUrlFragment();
			case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT: return createModelElementUrlFragment();
			case UrlPackage.MODEL_ELEMENT_URL: return createModelElementUrl();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerUrl createServerUrl() {
		ServerUrlImpl serverUrl = new ServerUrlImpl();
		return serverUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUrlFragment createProjectUrlFragment() {
		ProjectUrlFragmentImpl projectUrlFragment = new ProjectUrlFragmentImpl();
		return projectUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementUrlFragment createModelElementUrlFragment() {
		ModelElementUrlFragmentImpl modelElementUrlFragment = new ModelElementUrlFragmentImpl();
		return modelElementUrlFragment;
	}

	// BEGIN OF CUSTOM CODE
	/**
	 * Creates and parses the model element url.
	 * 
	 * @throws MalformedURLException when the url is malformed (d'oh!)
	 * @generated NOT
	 * @return the newly created {@link ModelElementUrl}
	 * @param url the url as a string.
	 */
	public ModelElementUrl createModelElementUrl(String url) throws MalformedURLException {

		ModelElementUrl modelURL = createModelElementUrl();

		ModelElementUrlFragment modelFragment = createModelElementUrlFragment();
		ProjectUrlFragment projectFragment = createProjectUrlFragment();
		ServerUrl serverFragment = createServerUrl();
		modelURL.setModelElementUrlFragment(modelFragment);
		modelURL.setProjectUrlFragment(projectFragment);
		modelURL.setServerUrl(serverFragment);
		if (url.startsWith(PREFIX)) {
			int trail = 0;
			if (url.endsWith("/")) {
				trail = 1;
			}
			String text = url.substring(PREFIX.length(), url.length() - trail);
			String[] elements = text.split("/");
			if (elements.length == 3) {
				String[] server = elements[0].split(":");
				if (server.length != 2) {
					throw new MalformedURLException(EXCEPTION_MESSAGE);
				}
				serverFragment.setHostName(server[0]);
				try {
					serverFragment.setPort(Integer.parseInt(server[1]));
				} catch (NumberFormatException e) {
					throw new MalformedURLException(EXCEPTION_MESSAGE);
				}

				String[] project = elements[1].split("%");
				if (project.length != 2) {
					throw new MalformedURLException(EXCEPTION_MESSAGE);
				}
				projectFragment.setName(project[0]);
				ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
				projectId.setId(project[1]);
				projectFragment.setProjectId(projectId);

				String[] model = elements[2].split("%");
				if (model.length != 2) {
					throw new MalformedURLException(EXCEPTION_MESSAGE);
				}
				modelFragment.setName(model[0]);
				ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
				modelElementId.setId(model[1]);
				modelFragment.setModelElementId(modelElementId);
			}
		}
		return modelURL;
	}

	// END OF CUSTOM CODE

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementUrl createModelElementUrl() {
		ModelElementUrlImpl modelElementUrl = new ModelElementUrlImpl();
		return modelElementUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrlPackage getUrlPackage() {
		return (UrlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UrlPackage getPackage() {
		return UrlPackage.eINSTANCE;
	}

} // UrlFactoryImpl
