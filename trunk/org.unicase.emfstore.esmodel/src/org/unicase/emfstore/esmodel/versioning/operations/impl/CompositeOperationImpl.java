/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.Project;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Composite Operation</b></em>'. <!--
 * end-user-doc --> <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getSubOperations <em>Sub
 * Operations</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getCompositeName <em>Composite
 * Name</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getCompositeDescription <em>Composite
 * Description</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#isReversed <em>Reversed</em>}</li>
 * </ul> </p>
 * @generated
 */
public class CompositeOperationImpl extends AbstractOperationImpl implements CompositeOperation {

	@Override
	public boolean isChange() {
		for (AbstractOperation abstractOperation : getSubOperations()) {
			if (abstractOperation.isChange()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The cached value of the '{@link #getSubOperations() <em>Sub Operations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> subOperations;

	/**
	 * The default value of the '{@link #getCompositeName() <em>Composite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompositeName() <em>Composite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeName()
	 * @generated
	 * @ordered
	 */
	protected String compositeName = COMPOSITE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getCompositeDescription() <em>Composite Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCompositeDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITE_DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompositeDescription() <em>Composite Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCompositeDescription()
	 * @generated
	 * @ordered
	 */
	protected String compositeDescription = COMPOSITE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isReversed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVERSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isReversed()
	 * @generated
	 * @ordered
	 */
	protected boolean reversed = REVERSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.COMPOSITE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractOperation> getSubOperations() {
		if (subOperations == null) {
			subOperations = new EObjectContainmentEList.Resolving<AbstractOperation>(AbstractOperation.class, this,
				OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS);
		}
		return subOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositeName() {
		return compositeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeName(String newCompositeName) {
		String oldCompositeName = compositeName;
		compositeName = newCompositeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME, oldCompositeName, compositeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositeDescription() {
		return compositeDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeDescription(String newCompositeDescription) {
		String oldCompositeDescription = compositeDescription;
		compositeDescription = newCompositeDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION, oldCompositeDescription,
				compositeDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReversed() {
		return reversed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReversed(boolean newReversed) {
		boolean oldReversed = reversed;
		reversed = newReversed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.COMPOSITE_OPERATION__REVERSED,
				oldReversed, reversed));
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void cannonize() {
		// MK: implement
		throw new UnsupportedOperationException();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			return ((InternalEList<?>) getSubOperations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			return getSubOperations();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			return getCompositeName();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			return getCompositeDescription();
		case OperationsPackage.COMPOSITE_OPERATION__REVERSED:
			return isReversed() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			getSubOperations().addAll((Collection<? extends AbstractOperation>) newValue);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			setCompositeName((String) newValue);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			setCompositeDescription((String) newValue);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__REVERSED:
			setReversed(((Boolean) newValue).booleanValue());
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			setCompositeName(COMPOSITE_NAME_EDEFAULT);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			setCompositeDescription(COMPOSITE_DESCRIPTION_EDEFAULT);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__REVERSED:
			setReversed(REVERSED_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			return subOperations != null && !subOperations.isEmpty();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			return COMPOSITE_NAME_EDEFAULT == null ? compositeName != null : !COMPOSITE_NAME_EDEFAULT
				.equals(compositeName);
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			return COMPOSITE_DESCRIPTION_EDEFAULT == null ? compositeDescription != null
				: !COMPOSITE_DESCRIPTION_EDEFAULT.equals(compositeDescription);
		case OperationsPackage.COMPOSITE_OPERATION__REVERSED:
			return reversed != REVERSED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (compositeName: ");
		result.append(compositeName);
		result.append(", compositeDescription: ");
		result.append(compositeDescription);
		result.append(", reversed: ");
		result.append(reversed);
		result.append(')');
		return result.toString();
	}

	@Override
	public void apply(Project project) {
		super.apply(project);
		for (AbstractOperation abstractOperation : getSubOperations()) {
			abstractOperation.apply(project);
		}
	}

	@Override
	public boolean canApply(Project project) {
		for (AbstractOperation abstractOperation : getSubOperations()) {
			if (!abstractOperation.canApply(project)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isReversed()) {
			stringBuilder.append("Undo of ");
		}
		stringBuilder.append(getCompositeDescription());
		stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isReversed()) {
			stringBuilder.append("Undo of ");
		}
		stringBuilder.append(getCompositeName());
		return stringBuilder.toString();
	}

	@Override
	public AbstractOperation reverse() {
		CompositeOperation compositeOperation = OperationsFactory.eINSTANCE.createCompositeOperation();
		super.reverse(compositeOperation);
		compositeOperation.setCompositeName(getCompositeName());
		compositeOperation.setCompositeDescription(getCompositeDescription());
		compositeOperation.setReversed(!isReversed());
		// reverse subOperations and add in reverse order
		EList<AbstractOperation> copiedSubOperations = compositeOperation.getSubOperations();
		for (AbstractOperation abstractOperation : getSubOperations()) {
			copiedSubOperations.add(0, abstractOperation.reverse());
		}
		return compositeOperation;
	}

} // CompositeOperationImpl
