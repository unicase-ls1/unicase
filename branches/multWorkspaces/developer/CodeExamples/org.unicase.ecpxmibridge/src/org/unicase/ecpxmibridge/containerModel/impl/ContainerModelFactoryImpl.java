/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpxmibridge.containerModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.ecpxmibridge.containerModel.ContainerModelFactory;
import org.unicase.ecpxmibridge.containerModel.ContainerModelPackage;
import org.unicase.ecpxmibridge.containerModel.XMIRootContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainerModelFactoryImpl extends EFactoryImpl implements ContainerModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerModelFactory init() {
		try {
			ContainerModelFactory theContainerModelFactory = (ContainerModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/ecpxmibridge/containerModel"); 
			if (theContainerModelFactory != null) {
				return theContainerModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContainerModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerModelFactoryImpl() {
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
			case ContainerModelPackage.XMI_ROOT_CONTAINER: return createXMIRootContainer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIRootContainer createXMIRootContainer() {
		XMIRootContainerImpl xmiRootContainer = new XMIRootContainerImpl();
		return xmiRootContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerModelPackage getContainerModelPackage() {
		return (ContainerModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ContainerModelPackage getPackage() {
		return ContainerModelPackage.eINSTANCE;
	}

} //ContainerModelFactoryImpl
