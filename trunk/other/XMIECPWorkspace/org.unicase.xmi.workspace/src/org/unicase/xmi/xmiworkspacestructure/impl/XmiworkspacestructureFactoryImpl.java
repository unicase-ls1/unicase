/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.xmi.xmiworkspacestructure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmiworkspacestructureFactoryImpl extends EFactoryImpl implements XmiworkspacestructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XmiworkspacestructureFactory init() {
		try {
			XmiworkspacestructureFactory theXmiworkspacestructureFactory = (XmiworkspacestructureFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/xmiworkspace/structureModel"); 
			if (theXmiworkspacestructureFactory != null) {
				return theXmiworkspacestructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XmiworkspacestructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiworkspacestructureFactoryImpl() {
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
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT: return createXMIECPFileProject();
			case XmiworkspacestructurePackage.XMIECP_FOLDER: return createXMIECPFolder();
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
	public XMIECPFolder createXMIECPFolder() {
		XMIECPFolderImpl xmiecpFolder = new XMIECPFolderImpl();
		return xmiecpFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiworkspacestructurePackage getXmiworkspacestructurePackage() {
		return (XmiworkspacestructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XmiworkspacestructurePackage getPackage() {
		return XmiworkspacestructurePackage.eINSTANCE;
	}

} //XmiworkspacestructureFactoryImpl
