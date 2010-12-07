/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage
 * @generated
 */
public interface XMIWorkspaceStructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XMIWorkspaceStructureFactory eINSTANCE = XMIWorkspaceStructure.impl.XMIWorkspaceStructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XMIECP File Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMIECP File Project</em>'.
	 * @generated
	 */
	XMIECPFileProject createXMIECPFileProject();

	/**
	 * Returns a new object of class '<em>XMIECP Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMIECP Folder</em>'.
	 * @generated
	 */
	XMIECPFolder createXMIECPFolder();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XMIWorkspaceStructurePackage getXMIWorkspaceStructurePackage();

} //XMIWorkspaceStructureFactory
