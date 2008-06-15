/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage
 * @generated
 */
public interface ChangemanagmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ChangemanagmentFactory eINSTANCE = org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Tag Version Spec</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Tag Version Spec</em>'.
	 * @generated
	 */
	TagVersionSpec createTagVersionSpec();

	/**
	 * Returns a new object of class '<em>Date Version Spec</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Date Version Spec</em>'.
	 * @generated
	 */
	DateVersionSpec createDateVersionSpec();

	/**
	 * Returns a new object of class '<em>Primary Version Spec</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Primary Version Spec</em>'.
	 * @generated
	 */
	PrimaryVersionSpec createPrimaryVersionSpec();

	/**
	 * Returns a new object of class '<em>Log Message</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Log Message</em>'.
	 * @generated
	 */
	LogMessage createLogMessage();

	/**
	 * Returns a new object of class '<em>Change Package</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Change Package</em>'.
	 * @generated
	 */
	ChangePackage createChangePackage();

	/**
	 * Returns a new object of class '<em>History Info</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>History Info</em>'.
	 * @generated
	 */
	HistoryInfo createHistoryInfo();

	/**
	 * Returns a new object of class '<em>Version</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns a new object of class '<em>Head Version Spec</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Head Version Spec</em>'.
	 * @generated
	 */
	HeadVersionSpec createHeadVersionSpec();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ChangemanagmentPackage getChangemanagmentPackage();

} // ChangemanagmentFactory
