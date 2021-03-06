/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

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
