/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage
 * @generated
 */
public class ChangepackageAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangepackagePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackageAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ChangepackagePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangepackageSwitch<Adapter> modelSwitch = new ChangepackageSwitch<Adapter>() {
		@Override
		public Adapter caseChangePackage(ChangePackage object) {
			return createChangePackageAdapter();
		}

		@Override
		public Adapter caseESAbstractOperation(ESAbstractOperation object) {
			return createESAbstractOperationAdapter();
		}

		@Override
		public Adapter caseESOperation(ESOperation object) {
			return createESOperationAdapter();
		}

		@Override
		public Adapter caseESEvent(ESEvent object) {
			return createESEventAdapter();
		}

		@Override
		public Adapter caseESeAttributeEvent(ESeAttributeEvent object) {
			return createESeAttributeEventAdapter();
		}

		@Override
		public Adapter caseESListEvent(ESListEvent object) {
			return createESListEventAdapter();
		}

		@Override
		public Adapter caseESModifyElementEvent(ESModifyElementEvent object) {
			return createESModifyElementEventAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangePackage
	 * @generated
	 */
	public Adapter createChangePackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation <em>ES Abstract Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation
	 * @generated
	 */
	public Adapter createESAbstractOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation <em>ES Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation
	 * @generated
	 */
	public Adapter createESOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent <em>ES Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent
	 * @generated
	 */
	public Adapter createESEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent <em>ESe Attribute Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent
	 * @generated
	 */
	public Adapter createESeAttributeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent <em>ES List Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent
	 * @generated
	 */
	public Adapter createESListEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent <em>ES Modify Element Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent
	 * @generated
	 */
	public Adapter createESModifyElementEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ChangepackageAdapterFactory
