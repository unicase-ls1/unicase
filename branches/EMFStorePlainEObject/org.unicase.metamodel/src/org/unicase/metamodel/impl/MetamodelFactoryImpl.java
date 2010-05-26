/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.metamodel.*;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.ModelVersion;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class MetamodelFactoryImpl extends EFactoryImpl implements MetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MetamodelFactory init() {
		try {
			MetamodelFactory theMetamodelFactory = (MetamodelFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/metamodel");
			if (theMetamodelFactory != null) {
				return theMetamodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MetamodelPackage.PROJECT:
			return createProject();
		case MetamodelPackage.MODEL_ELEMENT_ID:
			return createModelElementId();
		case MetamodelPackage.MODEL_VERSION:
			return createModelVersion();
		case MetamodelPackage.EOBJECT_TO_MODEL_ELEMENT_ID_MAP:
			return (EObject) createEObjectToModelElementIdMap();
		case MetamodelPackage.EOBJECT_TO_MODEL_ELEMENT_ID_CONTAINMENT_MAP:
			return (EObject) createEObjectToModelElementIdContainmentMap();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId createModelElementId() {
		ModelElementIdImpl modelElementId = new ModelElementIdImpl();
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelVersion createModelVersion() {
		ModelVersionImpl modelVersion = new ModelVersionImpl();
		return modelVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EObject, ModelElementId> createEObjectToModelElementIdMap() {
		EObjectToModelElementIdMapImpl eObjectToModelElementIdMap = new EObjectToModelElementIdMapImpl();
		return eObjectToModelElementIdMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EObject, ModelElementId> createEObjectToModelElementIdContainmentMap() {
		EObjectToModelElementIdContainmentMapImpl eObjectToModelElementIdContainmentMap = new EObjectToModelElementIdContainmentMapImpl();
		return eObjectToModelElementIdContainmentMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	//	public ModelElementEObjectWrapper createModelElementEObjectWrapper() {
	//		ModelElementEObjectWrapperImpl modelElementEObjectWrapper = new ModelElementEObjectWrapperImpl();
	//		return modelElementEObjectWrapper;
	//	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelPackage getMetamodelPackage() {
		return (MetamodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetamodelPackage getPackage() {
		return MetamodelPackage.eINSTANCE;
	}

} // MetamodelFactoryImpl
