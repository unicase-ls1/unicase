/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.versionspec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.versionspec.VersionspecPackage
 * @generated
 */
public interface VersionspecFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VersionspecFactory eINSTANCE = org.unicase.esmodel.versionspec.impl.VersionspecFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tag Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Version Spec</em>'.
	 * @generated
	 */
	TagVersionSpec createTagVersionSpec();

	/**
	 * Returns a new object of class '<em>Date Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date Version Spec</em>'.
	 * @generated
	 */
	DateVersionSpec createDateVersionSpec();

	/**
	 * Returns a new object of class '<em>Primary Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primary Version Spec</em>'.
	 * @generated
	 */
	PrimaryVersionSpec createPrimaryVersionSpec();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VersionspecPackage getVersionspecPackage();

} //VersionspecFactory
