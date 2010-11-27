/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.XMIWorkspaceStructure.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.xmi.XMIWorkspaceStructure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMIWorkspaceStructureFactoryImpl extends EFactoryImpl implements XMIWorkspaceStructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XMIWorkspaceStructureFactory init() {
		try {
			XMIWorkspaceStructureFactory theXMIWorkspaceStructureFactory = (XMIWorkspaceStructureFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/xmiworkspace/structureModel"); 
			if (theXMIWorkspaceStructureFactory != null) {
				return theXMIWorkspaceStructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XMIWorkspaceStructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIWorkspaceStructureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT: return createXMIECPFileProject();
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER: return createXMIECPVirtualContainer();
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER: return createXMIECPFolder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIECPFileProject createXMIECPFileProject() {
		XMIECPFileProjectImpl xmiecpFileProject = new XMIECPFileProjectImpl();
		return xmiecpFileProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIECPVirtualContainer createXMIECPVirtualContainer() {
		XMIECPVirtualContainerImpl xmiecpVirtualContainer = new XMIECPVirtualContainerImpl();
		return xmiecpVirtualContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIECPFolder createXMIECPFolder() {
		XMIECPFolderImpl xmiecpFolder = new XMIECPFolderImpl();
		return xmiecpFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIWorkspaceStructurePackage getXMIWorkspaceStructurePackage() {
		return (XMIWorkspaceStructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XMIWorkspaceStructurePackage getPackage() {
		return XMIWorkspaceStructurePackage.eINSTANCE;
	}

} //XMIWorkspaceStructureFactoryImpl
