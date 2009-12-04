/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoice;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Merge Choice</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getMyChanges <em>My Changes</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getTheirChanges <em>Their Changes
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getContextModelElement <em>Context
 * Model Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getSelection <em>Selection</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getContextFeature <em>Context Feature
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeChoiceImpl#getCreatedIssue <em>Created Issue
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MergeChoiceImpl extends EventImpl implements MergeChoice {
	/**
	 * The cached value of the '{@link #getMyChanges() <em>My Changes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMyChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> myChanges;

	/**
	 * The cached value of the '{@link #getTheirChanges() <em>Their Changes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTheirChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> theirChanges;

	/**
	 * The cached value of the '{@link #getContextModelElement() <em>Context Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContextModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId contextModelElement;

	/**
	 * The default value of the '{@link #getSelection() <em>Selection</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected static final MergeChoiceSelection SELECTION_EDEFAULT = MergeChoiceSelection.MINE;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected MergeChoiceSelection selection = SELECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextFeature() <em>Context Feature</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getContextFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContextFeature() <em>Context Feature</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getContextFeature()
	 * @generated
	 * @ordered
	 */
	protected String contextFeature = CONTEXT_FEATURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreatedIssue() <em>Created Issue</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatedIssue()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId createdIssue;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergeChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.MERGE_CHOICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractOperation> getMyChanges() {
		if (myChanges == null) {
			myChanges = new EObjectContainmentEList.Resolving<AbstractOperation>(AbstractOperation.class, this,
				EventsPackage.MERGE_CHOICE__MY_CHANGES);
		}
		return myChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractOperation> getTheirChanges() {
		if (theirChanges == null) {
			theirChanges = new EObjectContainmentEList.Resolving<AbstractOperation>(AbstractOperation.class, this,
				EventsPackage.MERGE_CHOICE__THEIR_CHANGES);
		}
		return theirChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getContextModelElement() {
		if (contextModelElement != null && contextModelElement.eIsProxy()) {
			InternalEObject oldContextModelElement = (InternalEObject) contextModelElement;
			contextModelElement = (ModelElementId) eResolveProxy(oldContextModelElement);
			if (contextModelElement != oldContextModelElement) {
				InternalEObject newContextModelElement = (InternalEObject) contextModelElement;
				NotificationChain msgs = oldContextModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, null, null);
				if (newContextModelElement.eInternalContainer() == null) {
					msgs = newContextModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, oldContextModelElement, contextModelElement));
			}
		}
		return contextModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetContextModelElement() {
		return contextModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContextModelElement(ModelElementId newContextModelElement, NotificationChain msgs) {
		ModelElementId oldContextModelElement = contextModelElement;
		contextModelElement = newContextModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, oldContextModelElement, newContextModelElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContextModelElement(ModelElementId newContextModelElement) {
		if (newContextModelElement != contextModelElement) {
			NotificationChain msgs = null;
			if (contextModelElement != null)
				msgs = ((InternalEObject) contextModelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, null, msgs);
			if (newContextModelElement != null)
				msgs = ((InternalEObject) newContextModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT, null, msgs);
			msgs = basicSetContextModelElement(newContextModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT,
				newContextModelElement, newContextModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MergeChoiceSelection getSelection() {
		return selection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSelection(MergeChoiceSelection newSelection) {
		MergeChoiceSelection oldSelection = selection;
		selection = newSelection == null ? SELECTION_EDEFAULT : newSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE__SELECTION, oldSelection,
				selection));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getContextFeature() {
		return contextFeature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContextFeature(String newContextFeature) {
		String oldContextFeature = contextFeature;
		contextFeature = newContextFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE,
				oldContextFeature, contextFeature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getCreatedIssue() {
		if (createdIssue != null && createdIssue.eIsProxy()) {
			InternalEObject oldCreatedIssue = (InternalEObject) createdIssue;
			createdIssue = (ModelElementId) eResolveProxy(oldCreatedIssue);
			if (createdIssue != oldCreatedIssue) {
				InternalEObject newCreatedIssue = (InternalEObject) createdIssue;
				NotificationChain msgs = oldCreatedIssue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CREATED_ISSUE, null, null);
				if (newCreatedIssue.eInternalContainer() == null) {
					msgs = newCreatedIssue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.MERGE_CHOICE__CREATED_ISSUE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.MERGE_CHOICE__CREATED_ISSUE, oldCreatedIssue, createdIssue));
			}
		}
		return createdIssue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetCreatedIssue() {
		return createdIssue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCreatedIssue(ModelElementId newCreatedIssue, NotificationChain msgs) {
		ModelElementId oldCreatedIssue = createdIssue;
		createdIssue = newCreatedIssue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.MERGE_CHOICE__CREATED_ISSUE, oldCreatedIssue, newCreatedIssue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreatedIssue(ModelElementId newCreatedIssue) {
		if (newCreatedIssue != createdIssue) {
			NotificationChain msgs = null;
			if (createdIssue != null)
				msgs = ((InternalEObject) createdIssue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CREATED_ISSUE, null, msgs);
			if (newCreatedIssue != null)
				msgs = ((InternalEObject) newCreatedIssue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_CHOICE__CREATED_ISSUE, null, msgs);
			msgs = basicSetCreatedIssue(newCreatedIssue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_CHOICE__CREATED_ISSUE,
				newCreatedIssue, newCreatedIssue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
			return ((InternalEList<?>) getMyChanges()).basicRemove(otherEnd, msgs);
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
			return ((InternalEList<?>) getTheirChanges()).basicRemove(otherEnd, msgs);
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
			return basicSetContextModelElement(null, msgs);
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			return basicSetCreatedIssue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
			return getMyChanges();
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
			return getTheirChanges();
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
			if (resolve)
				return getContextModelElement();
			return basicGetContextModelElement();
		case EventsPackage.MERGE_CHOICE__SELECTION:
			return getSelection();
		case EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE:
			return getContextFeature();
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			if (resolve)
				return getCreatedIssue();
			return basicGetCreatedIssue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
			getMyChanges().clear();
			getMyChanges().addAll((Collection<? extends AbstractOperation>) newValue);
			return;
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
			getTheirChanges().clear();
			getTheirChanges().addAll((Collection<? extends AbstractOperation>) newValue);
			return;
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
			setContextModelElement((ModelElementId) newValue);
			return;
		case EventsPackage.MERGE_CHOICE__SELECTION:
			setSelection((MergeChoiceSelection) newValue);
			return;
		case EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE:
			setContextFeature((String) newValue);
			return;
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			setCreatedIssue((ModelElementId) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
			getMyChanges().clear();
			return;
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
			getTheirChanges().clear();
			return;
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
			setContextModelElement((ModelElementId) null);
			return;
		case EventsPackage.MERGE_CHOICE__SELECTION:
			setSelection(SELECTION_EDEFAULT);
			return;
		case EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE:
			setContextFeature(CONTEXT_FEATURE_EDEFAULT);
			return;
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			setCreatedIssue((ModelElementId) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
			return myChanges != null && !myChanges.isEmpty();
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
			return theirChanges != null && !theirChanges.isEmpty();
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
			return contextModelElement != null;
		case EventsPackage.MERGE_CHOICE__SELECTION:
			return selection != SELECTION_EDEFAULT;
		case EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE:
			return CONTEXT_FEATURE_EDEFAULT == null ? contextFeature != null : !CONTEXT_FEATURE_EDEFAULT
				.equals(contextFeature);
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			return createdIssue != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (selection: ");
		result.append(selection);
		result.append(", contextFeature: ");
		result.append(contextFeature);
		result.append(')');
		return result.toString();
	}

} // MergeChoiceImpl
