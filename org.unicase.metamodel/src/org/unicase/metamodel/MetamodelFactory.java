/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.metamodel.MetamodelPackage
 * @generated
 */
public interface MetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	MetamodelFactory eINSTANCE = org.unicase.metamodel.impl.MetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>Model Element Id</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Element Id</em>'.
	 * @generated
	 */
	ModelElementId createModelElementId();

	/**
	 * Returns a new object of class '<em>Model Version</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Version</em>'.
	 * @generated
	 */
	ModelVersion createModelVersion();

	/**
	 * Returns a new object of class '<em>Model Element EObject Wrapper</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Model Element EObject Wrapper</em>'.
	 * @generated
	 */
	ModelElementEObjectWrapper createModelElementEObjectWrapper();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetamodelPackage getMetamodelPackage();

} // MetamodelFactory
