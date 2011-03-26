/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceSelection;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Merge Choice Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getMyChanges <em>My Changes</em>}
 * </li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getTheirChanges <em>Their Changes
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getContextModelElement <em>
 * Context Model Element</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getSelection <em>Selection</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getContextFeature <em>Context
 * Feature</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.MergeChoiceEventImpl#getCreatedIssue <em>Created Issue
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MergeChoiceEventImpl extends EventImpl implements MergeChoiceEvent {
	/**
	 * The cached value of the '{@link #getMyAcceptedChanges() <em>My Accepted Changes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMyAcceptedChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationId> myAcceptedChanges;

	/**
	 * The cached value of the '{@link #getTheirRejectedChanges() <em>Their Rejected Changes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTheirRejectedChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationId> theirRejectedChanges;

	/**
	 * The cached value of the '{@link #getContextModelElement() <em>Context Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContextModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId contextModelElement;

	/**
	 * The default value of the '{@link #getSelection() <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected static final MergeChoiceSelection SELECTION_EDEFAULT = MergeChoiceSelection.MINE;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected MergeChoiceSelection selection = SELECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextFeature() <em>Context Feature</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getContextFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContextFeature() <em>Context Feature</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getContextFeature()
	 * @generated
	 * @ordered
	 */
	protected String contextFeature = CONTEXT_FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedIssueName() <em>Created Issue Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatedIssueName()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_ISSUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedIssueName() <em>Created Issue Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatedIssueName()
	 * @generated
	 * @ordered
	 */
	protected String createdIssueName = CREATED_ISSUE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MergeChoiceEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.MERGE_CHOICE_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationId> getMyAcceptedChanges() {
		if (myAcceptedChanges == null) {
			myAcceptedChanges = new EObjectContainmentEList.Resolving<OperationId>(OperationId.class, this, EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES);
		}
		return myAcceptedChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationId> getTheirRejectedChanges() {
		if (theirRejectedChanges == null) {
			theirRejectedChanges = new EObjectContainmentEList.Resolving<OperationId>(OperationId.class, this, EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES);
		}
		return theirRejectedChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getContextModelElement() {
		if (contextModelElement != null && contextModelElement.eIsProxy()) {
			InternalEObject oldContextModelElement = (InternalEObject)contextModelElement;
			contextModelElement = (ModelElementId)eResolveProxy(oldContextModelElement);
			if (contextModelElement != oldContextModelElement) {
				InternalEObject newContextModelElement = (InternalEObject)contextModelElement;
				NotificationChain msgs = oldContextModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, null, null);
				if (newContextModelElement.eInternalContainer() == null) {
					msgs = newContextModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, oldContextModelElement, contextModelElement));
			}
		}
		return contextModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetContextModelElement() {
		return contextModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextModelElement(ModelElementId newContextModelElement, NotificationChain msgs) {
		ModelElementId oldContextModelElement = contextModelElement;
		contextModelElement = newContextModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, oldContextModelElement, newContextModelElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextModelElement(ModelElementId newContextModelElement) {
		if (newContextModelElement != contextModelElement) {
			NotificationChain msgs = null;
			if (contextModelElement != null)
				msgs = ((InternalEObject)contextModelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, null, msgs);
			if (newContextModelElement != null)
				msgs = ((InternalEObject)newContextModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, null, msgs);
			msgs = basicSetContextModelElement(newContextModelElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT, newContextModelElement, newContextModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeChoiceSelection getSelection() {
		return selection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelection(MergeChoiceSelection newSelection) {
		MergeChoiceSelection oldSelection = selection;
		selection = newSelection == null ? SELECTION_EDEFAULT : newSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE_EVENT__SELECTION, oldSelection, selection));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextFeature() {
		return contextFeature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextFeature(String newContextFeature) {
		String oldContextFeature = contextFeature;
		contextFeature = newContextFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE, oldContextFeature, contextFeature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreatedIssueName() {
		return createdIssueName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedIssueName(String newCreatedIssueName) {
		String oldCreatedIssueName = createdIssueName;
		createdIssueName = newCreatedIssueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME, oldCreatedIssueName, createdIssueName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
				return ((InternalEList<?>)getMyAcceptedChanges()).basicRemove(otherEnd, msgs);
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
				return ((InternalEList<?>)getTheirRejectedChanges()).basicRemove(otherEnd, msgs);
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				return basicSetContextModelElement(null, msgs);
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
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
				return getMyAcceptedChanges();
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
				return getTheirRejectedChanges();
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				if (resolve) return getContextModelElement();
				return basicGetContextModelElement();
			case EventsPackage.MERGE_CHOICE_EVENT__SELECTION:
				return getSelection();
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE:
				return getContextFeature();
			case EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME:
				return getCreatedIssueName();
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
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
				getMyAcceptedChanges().clear();
				getMyAcceptedChanges().addAll((Collection<? extends OperationId>)newValue);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
				getTheirRejectedChanges().clear();
				getTheirRejectedChanges().addAll((Collection<? extends OperationId>)newValue);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				setContextModelElement((ModelElementId)newValue);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__SELECTION:
				setSelection((MergeChoiceSelection)newValue);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE:
				setContextFeature((String)newValue);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME:
				setCreatedIssueName((String)newValue);
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
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
				getMyAcceptedChanges().clear();
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
				getTheirRejectedChanges().clear();
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				setContextModelElement((ModelElementId)null);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__SELECTION:
				setSelection(SELECTION_EDEFAULT);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE:
				setContextFeature(CONTEXT_FEATURE_EDEFAULT);
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME:
				setCreatedIssueName(CREATED_ISSUE_NAME_EDEFAULT);
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
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
				return myAcceptedChanges != null && !myAcceptedChanges.isEmpty();
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
				return theirRejectedChanges != null && !theirRejectedChanges.isEmpty();
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				return contextModelElement != null;
			case EventsPackage.MERGE_CHOICE_EVENT__SELECTION:
				return selection != SELECTION_EDEFAULT;
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE:
				return CONTEXT_FEATURE_EDEFAULT == null ? contextFeature != null : !CONTEXT_FEATURE_EDEFAULT.equals(contextFeature);
			case EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME:
				return CREATED_ISSUE_NAME_EDEFAULT == null ? createdIssueName != null : !CREATED_ISSUE_NAME_EDEFAULT.equals(createdIssueName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (selection: ");
		result.append(selection);
		result.append(", contextFeature: ");
		result.append(contextFeature);
		result.append(", createdIssueName: ");
		result.append(createdIssueName);
		result.append(')');
		return result.toString();
	}

} // MergeChoiceEventImpl
