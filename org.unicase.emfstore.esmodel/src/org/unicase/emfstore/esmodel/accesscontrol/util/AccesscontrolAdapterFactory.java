/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.metamodel.UniqueIdentifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage
 * @generated
 */
public class AccesscontrolAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static AccesscontrolPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AccesscontrolAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AccesscontrolPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * 
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
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AccesscontrolSwitch<Adapter> modelSwitch = new AccesscontrolSwitch<Adapter>() {
		@Override
		public Adapter caseACUser(ACUser object) {
			return createACUserAdapter();
		}

		@Override
		public Adapter caseACOrgUnit(ACOrgUnit object) {
			return createACOrgUnitAdapter();
		}

		@Override
		public Adapter caseACGroup(ACGroup object) {
			return createACGroupAdapter();
		}

		@Override
		public Adapter caseACOrgUnitId(ACOrgUnitId object) {
			return createACOrgUnitIdAdapter();
		}

		@Override
		public Adapter caseOrgUnitProperty(OrgUnitProperty object) {
			return createOrgUnitPropertyAdapter();
		}

		@Override
		public Adapter caseIdentifiableElement(IdentifiableElement object) {
			return createIdentifiableElementAdapter();
		}

		@Override
		public Adapter caseUniqueIdentifier(UniqueIdentifier object) {
			return createUniqueIdentifierAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.accesscontrol.ACUser
	 * <em>AC User</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.ACUser
	 * @generated
	 */
	public Adapter createACUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit
	 * <em>AC Org Unit</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit
	 * @generated
	 */
	public Adapter createACOrgUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class ' {@link org.unicase.emfstore.esmodel.accesscontrol.ACGroup
	 * <em>AC Group</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.ACGroup
	 * @generated
	 */
	public Adapter createACGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId
	 * <em>AC Org Unit Id</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId
	 * @generated
	 */
	public Adapter createACOrgUnitIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty
	 * <em>Org Unit Property</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty
	 * @generated
	 */
	public Adapter createOrgUnitPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.metamodel.IdentifiableElement
	 * <em>Identifiable Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.metamodel.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.metamodel.UniqueIdentifier
	 * <em>Unique Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.metamodel.UniqueIdentifier
	 * @generated
	 */
	public Adapter createUniqueIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // AccesscontrolAdapterFactory
