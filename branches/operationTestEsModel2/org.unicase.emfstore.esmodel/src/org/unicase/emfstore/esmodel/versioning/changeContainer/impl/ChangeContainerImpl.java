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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.impl.EObjectToChangesMapEntryImpl;
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
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
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
	 * 
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractOperation> getOperations(Project project) {
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
			//TODO: Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//TODO: Auto-generated catch block
			e.printStackTrace();
		}

		ChangeDescription changeDescription = (ChangeDescription) changeDescriptionResource
				.getContents().get(0);
		EList<AbstractOperation> results = new BasicEList<AbstractOperation>();
		for (EObject obj : changeDescription.getObjectsToAttach()) {
			CreateOperation op = OperationsFactory.eINSTANCE
					.createCreateOperation();
			op.setObjectToCreate(obj);
			op.setName("Created new "+obj.eClass().getName());
			op.setUsername("coldphusion");
			op.setDescription("Name: "+((ModelElement)obj).getName());
			results.add(op);
		}
		for (EObject obj : changeDescription.getObjectsToDetach()) {
			DeleteOperation op = OperationsFactory.eINSTANCE
					.createDeleteOperation();
			op.setObjectToDelete(obj);
			op.setName("Deleted "+obj.eClass().getName());
			op.setUsername("coldphusion");
			op.setDescription("Name: "+((ModelElement)obj).getName());
			results.add(op);
		}
		for (Map.Entry<EObject, EList<FeatureChange>> entry : changeDescription
				.getObjectChanges()) {
			EObject objectToChange = entry.getKey();
			FeatureOperation op = null;
			for (FeatureChange featureChange : entry.getValue()) {
				if (featureChange.getFeature() instanceof EReference) {
					if (featureChange.getFeature().getUpperBound() != 1) {
						op = OperationsFactory.eINSTANCE
								.createMultiReferenceOperation();
						MultiReferenceOperation mr = (MultiReferenceOperation) op;
						mr.getOldValues().clear();
						mr
								.getOldValues()
								.addAll(
										(EList<EObject>) ((EObjectToChangesMapEntryImpl) featureChange.eContainer())
												.getTypedKey().eGet(
														featureChange
																.getFeature()));
						mr.getNewValues().clear();
						mr.getNewValues().addAll(
								(EList<EObject>) featureChange.getValue());
					} else if (featureChange.getFeature().getUpperBound() == 1) {
						op = OperationsFactory.eINSTANCE
								.createSingleReferenceOperation();
						SingleReferenceOperation sr = (SingleReferenceOperation) op;
						sr
								.setOldValue((EObject) ((EObjectToChangesMapEntryImpl) featureChange.eContainer())
										.getTypedKey().eGet(
												featureChange.getFeature()));
						sr.setNewValue(featureChange.getReferenceValue());
					}
				} else if (featureChange.getFeature() instanceof EAttribute) {
					op = OperationsFactory.eINSTANCE.createAttributeOperation();
					AttributeOperation ao = (AttributeOperation) op;
					ao
							.setOldValue(((EObjectToChangesMapEntryImpl) featureChange.eContainer())
									.getTypedKey().eGet(
											featureChange.getFeature())
									.toString());
					ao.setNewValue(featureChange.getValue().toString());
				}
				op.setModelElement((ModelElement) objectToChange);
				op.setFeatureName(featureChange.getFeatureName());
				op.setName("ME changed: "+op.getModelElement().getName());
				op.setUsername("coldphusion");
				op.setDescription("Feature: "+op.getFeatureName());
				results.add(op);
			}
		}

		// reintegrate project into old container
		if (oldContainer != null) {
			oldContainer.eSet(containmentFeature, project);
		}
		return results;
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

		// move all model elements to virtual resource
		Map<EObject, Resource> touchedMEResourceMap = new HashMap<EObject, Resource>();
		
		for (EObject eObject : project.getAllModelElements()) {
			// preserve old resource
			Resource resource = eObject.eResource();
			touchedMEResourceMap.put(eObject, resource);
			// remove from its resource
			resource.getContents().remove(eObject);
		}
		
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
