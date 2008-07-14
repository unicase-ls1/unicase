/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getForwardDelta <em>Forward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getBackwardDelta <em>Backward Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The default value of the '{@link #getForwardDelta() <em>Forward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardDelta()
	 * @generated
	 * @ordered
	 */
	protected static final String FORWARD_DELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForwardDelta() <em>Forward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardDelta()
	 * @generated
	 * @ordered
	 */
	protected String forwardDelta = FORWARD_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKWARD_DELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected String backwardDelta = BACKWARD_DELTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForwardDelta() {
		return forwardDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardDelta(String newForwardDelta) {
		String oldForwardDelta = forwardDelta;
		forwardDelta = newForwardDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__FORWARD_DELTA,
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwardDelta(String newBackwardDelta) {
		String oldBackwardDelta = backwardDelta;
		backwardDelta = newBackwardDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA,
					oldBackwardDelta, backwardDelta));
	}

	//begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		changePackage.setBackwardDelta(this.forwardDelta);
		changePackage.setForwardDelta(this.backwardDelta);
		return changePackage;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#apply(org.unicase.model.Project)
	 * @generated NOT
	 */
	public void apply(Project project) {
		//preserve old container
		EObject oldContainer = project.eContainer();

		//integrate project and cp into shared resource set
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

		//reintegrate project into old container
		oldContainer.eContents().add(project);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void init(Project project,
			ChangeDescription backwardChangeDescription) {

		EReference containmentFeature = project.eContainmentFeature();
		EObject oldContainer = project.eContainer();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource projectResource = resourceSet
				.createResource(VIRTUAL_PROJECT_URI);
		projectResource.getContents().add(project);
		Resource changeDescriptionResource = resourceSet
				.createResource(VIRTUAL_CHANGEDESCRIPTION_URI);
		changeDescriptionResource.getContents().add(backwardChangeDescription);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			changeDescriptionResource.save(out, null);
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}
		this.backwardDelta = out.toString();

		backwardChangeDescription.applyAndReverse();

		out.reset();
		try {
			changeDescriptionResource.save(out, null);
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}
		this.forwardDelta = out.toString();

		backwardChangeDescription.apply();

		//reintegrate project into old container
		oldContainer.eSet(containmentFeature, project);
	}

	//end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__FORWARD_DELTA:
			return getForwardDelta();
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
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
		case VersioningPackage.CHANGE_PACKAGE__FORWARD_DELTA:
			setForwardDelta((String) newValue);
			return;
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
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
		case VersioningPackage.CHANGE_PACKAGE__FORWARD_DELTA:
			setForwardDelta(FORWARD_DELTA_EDEFAULT);
			return;
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
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
		case VersioningPackage.CHANGE_PACKAGE__FORWARD_DELTA:
			return FORWARD_DELTA_EDEFAULT == null ? forwardDelta != null
					: !FORWARD_DELTA_EDEFAULT.equals(forwardDelta);
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			return BACKWARD_DELTA_EDEFAULT == null ? backwardDelta != null
					: !BACKWARD_DELTA_EDEFAULT.equals(backwardDelta);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

} // ChangePackageImpl
