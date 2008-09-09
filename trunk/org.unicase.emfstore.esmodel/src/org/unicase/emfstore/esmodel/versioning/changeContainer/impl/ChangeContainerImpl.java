/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.changeContainer.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl#getForwardDelta <em>Forward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl#getBackwardDelta <em>Backward Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeContainerImpl extends EObjectImpl implements ChangeContainer {
	/**
	 * The default value of the '{@link #getForwardDelta() <em>Forward Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getForwardDelta()
	 * @generated
	 * @ordered
	 */
	protected static final String FORWARD_DELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForwardDelta() <em>Forward Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getForwardDelta()
	 * @generated
	 * @ordered
	 */
	protected String forwardDelta = FORWARD_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKWARD_DELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected String backwardDelta = BACKWARD_DELTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangeContainerPackage.Literals.CHANGE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getForwardDelta() {
		return forwardDelta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardDelta(String newForwardDelta) {
		String oldForwardDelta = forwardDelta;
		forwardDelta = newForwardDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangeContainerPackage.CHANGE_CONTAINER__FORWARD_DELTA,
					oldForwardDelta, forwardDelta));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackwardDelta() {
		return backwardDelta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwardDelta(String newBackwardDelta) {
		String oldBackwardDelta = backwardDelta;
		backwardDelta = newBackwardDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangeContainerPackage.CHANGE_CONTAINER__BACKWARD_DELTA,
					oldBackwardDelta, backwardDelta));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ChangeContainer reverse() {
		ChangeContainer changeContainer = ChangeContainerFactory.eINSTANCE
				.createChangeContainer();
		changeContainer.setBackwardDelta(this.getForwardDelta());
		changeContainer.setForwardDelta(this.getBackwardDelta());
		return changeContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void apply(Project project) {
		// preserve old container
		EReference containmentFeature = project.eContainmentFeature();
		EObject oldContainer = project.eContainer();

		// integrate project and cp into shared resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource projectResource = resourceSet
				.createResource(VIRTUAL_PROJECT_URI);
		projectResource.getContents().add(project);
		Resource changeDescriptionResource = resourceSet
				.createResource(VIRTUAL_CHANGEDESCRIPTION_URI);
		try {
			changeDescriptionResource.load(new ByteArrayInputStream(
					this.forwardDelta.getBytes("UTF-8")), null);
		} catch (UnsupportedEncodingException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}

		ChangeDescription fowardChangeDescription = (ChangeDescription) changeDescriptionResource
				.getContents().get(0);

		fowardChangeDescription.apply();

		// reintegrate project into old container
		if (oldContainer != null) {
			oldContainer.eSet(containmentFeature, project);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractOperation> getOperations() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void init(Project project,
			ChangeDescription backwardChangeDescription) {
		// preserve old project container
		EReference containmentFeature = project.eContainmentFeature();
		EObject oldContainer = project.eContainer();

		// important in order to keep the changes in case of connection problems
		// when commiting
		ChangeDescription newbackwardChangeDescription = (ChangeDescription) EcoreUtil
				.copy(backwardChangeDescription);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource projectResource = resourceSet
				.createResource(VIRTUAL_PROJECT_URI);
		projectResource.getContents().add(project);
		Resource changeDescriptionResource = resourceSet
				.createResource(VIRTUAL_CHANGEDESCRIPTION_URI);
		changeDescriptionResource.getContents().add(
				newbackwardChangeDescription);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			changeDescriptionResource.save(out, null);
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}
		this.setBackwardDelta(out.toString());

		newbackwardChangeDescription.applyAndReverse();

		out.reset();
		try {
			changeDescriptionResource.save(out, null);
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}
		this.setForwardDelta(out.toString());

		newbackwardChangeDescription.apply();

		// reintegrate project into old container
		if (oldContainer != null) {
			oldContainer.eSet(containmentFeature, project);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangeContainerPackage.CHANGE_CONTAINER__FORWARD_DELTA:
			return getForwardDelta();
		case ChangeContainerPackage.CHANGE_CONTAINER__BACKWARD_DELTA:
			return getBackwardDelta();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangeContainerPackage.CHANGE_CONTAINER__FORWARD_DELTA:
			setForwardDelta((String) newValue);
			return;
		case ChangeContainerPackage.CHANGE_CONTAINER__BACKWARD_DELTA:
			setBackwardDelta((String) newValue);
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
		case ChangeContainerPackage.CHANGE_CONTAINER__FORWARD_DELTA:
			setForwardDelta(FORWARD_DELTA_EDEFAULT);
			return;
		case ChangeContainerPackage.CHANGE_CONTAINER__BACKWARD_DELTA:
			setBackwardDelta(BACKWARD_DELTA_EDEFAULT);
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
		case ChangeContainerPackage.CHANGE_CONTAINER__FORWARD_DELTA:
			return FORWARD_DELTA_EDEFAULT == null ? forwardDelta != null
					: !FORWARD_DELTA_EDEFAULT.equals(forwardDelta);
		case ChangeContainerPackage.CHANGE_CONTAINER__BACKWARD_DELTA:
			return BACKWARD_DELTA_EDEFAULT == null ? backwardDelta != null
					: !BACKWARD_DELTA_EDEFAULT.equals(backwardDelta);
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
		result.append(" (forwardDelta: ");
		result.append(forwardDelta);
		result.append(", backwardDelta: ");
		result.append(backwardDelta);
		result.append(')');
		return result.toString();
	}

} // ChangeContainerImpl
