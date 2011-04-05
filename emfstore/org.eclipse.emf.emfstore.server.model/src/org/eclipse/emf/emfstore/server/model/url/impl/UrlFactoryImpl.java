/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.url.impl;

import java.net.MalformedURLException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrl;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.url.UrlFactory;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UrlFactoryImpl extends EFactoryImpl implements UrlFactory {

	/**
	 * The prefix for all EMFStore URLs.
	 * 
	 * @generated NOT
	 */
	public static final String PREFIX = "emfstore://";

	/**
	 * The standard parsing exception message.
	 * 
	 * @generated NOT
	 */
	private static final String EXCEPTION_MESSAGE = "Invalid EMFStore URL!";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UrlFactory init() {
		try {
			UrlFactory theUrlFactory = (UrlFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://eclipse.org/emf/emfstore/server/model/url");
			if (theUrlFactory != null) {
				return theUrlFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UrlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

	// begin of custom code

	/**
	 * {@inheritDoc}
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
			if (elements.length >= 3) {
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
				ProjectId projectId = ModelFactory.eINSTANCE.createProjectId();
				projectId.setId(project[1]);
				projectFragment.setProjectId(projectId);

				StringBuilder model = new StringBuilder();
				for (int i = 2; i < elements.length; i++) {
					model.append(elements[i]);
				}
				final String string = model.toString();
				int p = string.lastIndexOf("%");
				if (p == -1) {
					throw new MalformedURLException(EXCEPTION_MESSAGE);
				}
				modelFragment.setName(string.substring(0, p));
				ModelElementId modelElementId = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE
					.createModelElementId();
				modelElementId.setId(string.substring(p + 1));
				modelFragment.setModelElementId(modelElementId);
			}
		}
		return modelURL;
	}

	// end of custom code

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
