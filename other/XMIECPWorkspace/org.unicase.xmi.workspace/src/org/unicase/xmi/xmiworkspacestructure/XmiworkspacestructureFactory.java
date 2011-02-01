/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage
 * @generated
 */
public interface XmiworkspacestructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmiworkspacestructureFactory eINSTANCE = org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XMIECP File Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMIECP File Project</em>'.
	 * @generated
	 */
	XMIECPFileProject createXMIECPFileProject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XmiworkspacestructurePackage getXmiworkspacestructurePackage();

} //XmiworkspacestructureFactory
