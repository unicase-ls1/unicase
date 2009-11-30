/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url;

import java.net.MalformedURLException;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.url.UrlPackage
 * @generated
 */
public interface UrlFactory extends EFactory {

	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UrlFactory eINSTANCE = org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Server Url</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Server Url</em>'.
	 * @generated
	 */
	ServerUrl createServerUrl();

	/**
	 * Returns a new object of class '<em>Project Url Fragment</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Project Url Fragment</em>'.
	 * @generated
	 */
	ProjectUrlFragment createProjectUrlFragment();

	/**
	 * Returns a new object of class '<em>Model Element Url Fragment</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Model Element Url Fragment</em>'.
	 * @generated
	 */
	ModelElementUrlFragment createModelElementUrlFragment();

	/**
	 * Returns a new object of class '<em>Model Element Url</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Element Url</em>'.
	 * @generated
	 */
	ModelElementUrl createModelElementUrl();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UrlPackage getUrlPackage();

	/**
	 * Creates and parses the model element url.
	 * 
	 * @throws MalformedURLException when the url is malformed (d'oh!)
	 * @generated NOT
	 * @return the newly created {@link ModelElementUrl}
	 * @param url the url as a string.
	 */
	ModelElementUrl createModelElementUrl(String url) throws MalformedURLException;

} // UrlFactory
