/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PushDownOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Push Down Operation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.unicase.implementation.operations.impl.PushDownOperationImpl#getSuperClass
 * <em>Super Class</em>}</li>
 * <li>
 * {@link org.unicase.implementation.operations.impl.PushDownOperationImpl#getAttributes
 * <em>Attributes</em>}</li>
 * <li>
 * {@link org.unicase.implementation.operations.impl.PushDownOperationImpl#getOutgoingAssociations
 * <em>Outgoing Associations</em>}</li>
 * <li>
 * {@link org.unicase.implementation.operations.impl.PushDownOperationImpl#getIncomingAssociations
 * <em>Incoming Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PushDownOperationImpl
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
		implements PushDownOperation {
	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.common.model.ModelElementId superClass;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> attributes;

	/**
	 * The cached value of the '{@link #getOutgoingAssociations()
	 * <em>Outgoing Associations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutgoingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> outgoingAssociations;

	/**
	 * The cached value of the '{@link #getIncomingAssociations()
	 * <em>Incoming Associations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncomingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> incomingAssociations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PushDownOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.PUSH_DOWN_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.common.model.ModelElementId getSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSuperClass(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newSuperClass,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.common.model.ModelElementId oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS,
					oldSuperClass, newSuperClass);
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
	public void setSuperClass(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newSuperClass) {
		if (newSuperClass != superClass) {
			NotificationChain msgs = null;
			if (superClass != null)
				msgs = ((InternalEObject) superClass)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS,
								null, msgs);
			if (newSuperClass != null)
				msgs = ((InternalEObject) newSuperClass)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS,
								null, msgs);
			msgs = basicSetSuperClass(newSuperClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS,
					newSuperClass, newSuperClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId>(
					org.eclipse.emf.emfstore.internal.common.model.ModelElementId.class,
					this, OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectContainmentEList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId>(
					org.eclipse.emf.emfstore.internal.common.model.ModelElementId.class,
					this,
					OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectContainmentEList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId>(
					org.eclipse.emf.emfstore.internal.common.model.ModelElementId.class,
					this,
					OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.unicase.model.classes.Class getSuperClass(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElement(project, getSuperClass());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Attribute> getAttributes(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElements(project, getAttributes());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Association> getOutgoingAssociations(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElements(project, getOutgoingAssociations());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Association> getIncomingAssociations(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElements(project, getIncomingAssociations());
	}

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Attribute> getPossibleAttributes(Project project) {
		Class superClass = getSuperClass(project);
		return superClass.getAttributes();
	}

	// end of custom code

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleOutgoingAssociations(Project project) {
		Class superClass = getSuperClass(project);
		return superClass.getOutgoingAssociations();
	}

	// end of custom code

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleIncomingAssociations(Project project) {
		Class superClass = getSuperClass(project);
		return superClass.getIncomingAssociations();
	}

	// end of custom code

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateSuperClassSubClasses(Project project) {
		Class superClass = getSuperClass(project);
		return !superClass.getSubClasses().isEmpty();
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAttributesAssociations(Project project) {
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);

		return attributes.size() + outgoingAssociations.size()
				+ incomingAssociations.size() > 0;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS:
			return basicSetSuperClass(null, msgs);
		case OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd,
					msgs);
		case OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS:
			return ((InternalEList<?>) getOutgoingAssociations()).basicRemove(
					otherEnd, msgs);
		case OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS:
			return ((InternalEList<?>) getIncomingAssociations()).basicRemove(
					otherEnd, msgs);
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
		case OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS:
			return getSuperClass();
		case OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES:
			return getAttributes();
		case OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS:
			return getOutgoingAssociations();
		case OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS:
			return getIncomingAssociations();
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
		case OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS:
			setSuperClass((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) newValue);
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES:
			getAttributes().clear();
			getAttributes()
					.addAll((Collection<? extends org.eclipse.emf.emfstore.internal.common.model.ModelElementId>) newValue);
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS:
			getOutgoingAssociations().clear();
			getOutgoingAssociations()
					.addAll((Collection<? extends org.eclipse.emf.emfstore.internal.common.model.ModelElementId>) newValue);
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS:
			getIncomingAssociations().clear();
			getIncomingAssociations()
					.addAll((Collection<? extends org.eclipse.emf.emfstore.internal.common.model.ModelElementId>) newValue);
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
		case OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS:
			setSuperClass((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) null);
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES:
			getAttributes().clear();
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS:
			getOutgoingAssociations().clear();
			return;
		case OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS:
			getIncomingAssociations().clear();
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
		case OperationsPackage.PUSH_DOWN_OPERATION__SUPER_CLASS:
			return superClass != null;
		case OperationsPackage.PUSH_DOWN_OPERATION__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case OperationsPackage.PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS:
			return outgoingAssociations != null
					&& !outgoingAssociations.isEmpty();
		case OperationsPackage.PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS:
			return incomingAssociations != null
					&& !incomingAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void semanticApply(Project project) {
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);
		Class superClass = getSuperClass(project);

		pushDownAttributes(attributes, superClass);
		pushDownOutgoingAssociations(outgoingAssociations, superClass);
		pushDownIncomingAssociations(incomingAssociations, superClass);
	}

	public static void pushDownAttributes(List<Attribute> attributes,
			Class superClass) {
		for (Attribute attribute : attributes) {
			for (org.unicase.model.classes.Class subClass : superClass
					.getSubClasses()) {
				Attribute subAttribute = ModelUtil.clone(attribute);
				subClass.getAttributes().add(subAttribute);
			}

			ModelUtil.getProject(attribute).deleteModelElement(attribute);
		}
	}

	@SuppressWarnings("unchecked")
	public static void pushDownOutgoingAssociations(
			List<Association> associations, Class superClass) {
		for (Association association : associations) {
			for (org.unicase.model.classes.Class subClass : superClass
					.getSubClasses()) {
				Association subAssociation = ModelUtil.clone(association);
				((List<Association>) association.eContainer().eGet(
						association.eContainmentFeature())).add(subAssociation);
				subAssociation.setSource(subClass);
				if (association.getSourceRole() != null
						&& superClass.getSubClasses().size() > 1) {
					subAssociation.setSourceRole(OperationHelper
							.firstLower(subClass.getName()));
				}
				subAssociation.setTarget(association.getTarget());
			}

			ModelUtil.getProject(association).deleteModelElement(association);
		}
	}

	@SuppressWarnings("unchecked")
	public static void pushDownIncomingAssociations(
			List<Association> associations, Class superClass) {
		for (Association association : associations) {
			for (org.unicase.model.classes.Class subClass : superClass
					.getSubClasses()) {
				Association subAssociation = ModelUtil.clone(association);
				((List<Association>) association.eContainer().eGet(
						association.eContainmentFeature())).add(subAssociation);
				subAssociation.setTarget(subClass);
				if (association.getTargetRole() != null
						&& superClass.getSubClasses().size() > 1) {
					subAssociation.setTargetRole(OperationHelper
							.firstLower(subClass.getName()));
				}
				subAssociation.setSource(association.getSource());
			}

			ModelUtil.getProject(association).deleteModelElement(association);
		}
	}
} // PushDownOperationImpl
