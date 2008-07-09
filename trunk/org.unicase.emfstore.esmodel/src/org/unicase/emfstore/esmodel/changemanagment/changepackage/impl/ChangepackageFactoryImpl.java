/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackageFactory;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ChangepackageFactoryImpl extends EFactoryImpl implements
		ChangepackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ChangepackageFactory init() {
		try {
			ChangepackageFactory theChangepackageFactory = (ChangepackageFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/esmodel/changemanagment/changepackage");
			if (theChangepackageFactory != null) {
				return theChangepackageFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangepackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ChangepackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ChangepackagePackage.ES_CHANGE_PACKAGE:
			return createESChangePackage();
		case ChangepackagePackage.ES_OPERATION:
			return createESOperation();
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT:
			return createESeAttributeEvent();
		case ChangepackagePackage.ES_LIST_EVENT:
			return createESListEvent();
		case ChangepackagePackage.ES_MODIFY_ELEMENT_EVENT:
			return createESModifyElementEvent();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESChangePackage createESChangePackage() {
		ESChangePackageImpl esChangePackage = new ESChangePackageImpl();
		return esChangePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ESOperation createESOperation() {
		ESOperationImpl esOperation = new ESOperationImpl();
		return esOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ESeAttributeEvent createESeAttributeEvent() {
		ESeAttributeEventImpl eSeAttributeEvent = new ESeAttributeEventImpl();
		return eSeAttributeEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ESListEvent createESListEvent() {
		ESListEventImpl esListEvent = new ESListEventImpl();
		return esListEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ESModifyElementEvent createESModifyElementEvent() {
		ESModifyElementEventImpl esModifyElementEvent = new ESModifyElementEventImpl();
		return esModifyElementEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackagePackage getChangepackagePackage() {
		return (ChangepackagePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChangepackagePackage getPackage() {
		return ChangepackagePackage.eINSTANCE;
	}

	/**
	 * Converts ChangeDescription to Changepackage. !ONLY WORKS FOR eATTRIBUTES!
	 * 
	 * @param the
	 *            changeDescription from changeRecorder
	 * @return a changepackage
	 */
	public ESChangePackage convertToChangepackage(
			ChangeDescription changeDescription) {
		ESChangePackage changePackage = createESChangePackage();
		ChangeDescription newChangeDescription = (ChangeDescription) EcoreUtil
				.copy(changeDescription);
		newChangeDescription.applyAndReverse();
		Iterator<Entry<EObject, EList<FeatureChange>>> iterator = newChangeDescription
				.getObjectChanges().iterator();
		while (iterator.hasNext()) {
			Entry<EObject, EList<FeatureChange>> next = iterator.next();
			if (next.getKey() instanceof ModelElement) {
				ESOperation esOperation = ChangepackageFactory.eINSTANCE
						.createESOperation();
				esOperation.setName("name");
				esOperation.setDescription("desc");
				for (FeatureChange featureChange : next.getValue()) {
					if (featureChange.getFeature() instanceof EAttribute) {
						ESModifyElementEvent esEvent = ChangepackageFactory.eINSTANCE
								.createESModifyElementEvent();
						esEvent.setModelElementId((ModelElementId) EcoreUtil
								.copy(((ModelElement) next.getKey())
										.getIdentifier()));
						esEvent.setFeatureId(featureChange.getFeature()
								.getFeatureID());
						esEvent.setModelElementClass(next.getKey().getClass());

						esEvent.setPreviousState(featureChange.getDataValue());

						EDataType type = (EDataType) featureChange.getFeature()
								.getEType();
						String value = EcoreUtil.convertToString(type, next
								.getKey().eGet(featureChange.getFeature()));
						esEvent.setSubsequentState(value);

						// esEvent.setPreviousState(
						esOperation.getOperations().add(esEvent);
					}
				}
				changePackage.getOperations().add(esOperation);
			}
		}
		return changePackage;
	}

} // ChangepackageFactoryImpl
