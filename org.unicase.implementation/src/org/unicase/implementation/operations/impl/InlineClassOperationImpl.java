/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.validation.ClassesHelper;
import org.unicase.model.classes.validation.MultiplicityParseResult;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Inline Class Operation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.unicase.implementation.operations.impl.InlineClassOperationImpl#getAssociation
 * <em>Association</em>}</li>
 * <li>
 * {@link org.unicase.implementation.operations.impl.InlineClassOperationImpl#getInlineClass
 * <em>Inline Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineClassOperationImpl
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
		implements InlineClassOperation {
	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.common.model.ModelElementId association;

	/**
	 * The cached value of the '{@link #getInlineClass() <em>Inline Class</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInlineClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.common.model.ModelElementId inlineClass;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InlineClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.INLINE_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.common.model.ModelElementId getAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAssociation(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newAssociation,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.common.model.ModelElementId oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION,
					oldAssociation, newAssociation);
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
	public void setAssociation(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newAssociation) {
		if (newAssociation != association) {
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject) association)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION,
								null, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject) newAssociation)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION,
								null, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION,
					newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.common.model.ModelElementId getInlineClass() {
		return inlineClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInlineClass(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newInlineClass,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.common.model.ModelElementId oldInlineClass = inlineClass;
		inlineClass = newInlineClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS,
					oldInlineClass, newInlineClass);
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
	public void setInlineClass(
			org.eclipse.emf.emfstore.internal.common.model.ModelElementId newInlineClass) {
		if (newInlineClass != inlineClass) {
			NotificationChain msgs = null;
			if (inlineClass != null)
				msgs = ((InternalEObject) inlineClass)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS,
								null, msgs);
			if (newInlineClass != null)
				msgs = ((InternalEObject) newInlineClass)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS,
								null, msgs);
			msgs = basicSetInlineClass(newInlineClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS,
					newInlineClass, newInlineClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Association getAssociation(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElement(project, getAssociation());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.unicase.model.classes.Class getInlineClass(
			final org.eclipse.emf.emfstore.internal.common.model.Project project) {
		return OperationHelper.getElement(project, getInlineClass());
	}

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleAssociation(Project project) {
		Class inlineClass = getInlineClass(project);
		EList<Association> associations = new BasicEList<Association>();
		for (Association association : inlineClass.getIncomingAssociations()) {
			boolean composition = association.getType() == AssociationType.COMPOSITION;
			boolean oneToOne = ClassesHelper.getMaximumMultiplicity(association
					.getSourceMultiplicity()) == 1
					&& ClassesHelper.getMaximumMultiplicity(association
							.getTargetMultiplicity()) == 1;
			if (composition && oneToOne) {
				associations.add(association);
			}
		}
		return associations;
	}

	// end of custom code

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<org.unicase.model.classes.Class> getPossibleInlineClass(
			Project project) {
		Association association = getAssociation(project);
		EList<Class> inlineClasses = new BasicEList<Class>();
		inlineClasses.add(association.getTarget());
		return inlineClasses;
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationComposition(Project project) {
		Association association = getAssociation(project);
		return association.getType() == AssociationType.COMPOSITION;
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationMultiplicity(Project project) {
		Association association = getAssociation(project);
		MultiplicityParseResult targetMultiplicity = ClassesHelper
				.parseMultiplicity(association.getTargetMultiplicity());
		MultiplicityParseResult sourceMultiplicity = ClassesHelper
				.parseMultiplicity(association.getSourceMultiplicity());

		return targetMultiplicity.getMaximumMultiplicity() == 1
				&& sourceMultiplicity.getMaximumMultiplicity() == 1;
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateInlineClassSubClasses(Project project) {
		Class inlinedClass = getInlineClass(project);
		return inlinedClass.getSubClasses().isEmpty();
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateInlineClassAssociationTarget(Project project) {
		Association association = getAssociation(project);
		Class inlinedClass = getInlineClass(project);

		EList<Association> incomingAssociations = inlinedClass
				.getIncomingAssociations();
		return incomingAssociations.size() == 1
				&& incomingAssociations.get(0) == association;
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
		case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
			return basicSetAssociation(null, msgs);
		case OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS:
			return basicSetInlineClass(null, msgs);
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
		case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
			return getAssociation();
		case OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS:
			return getInlineClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
			setAssociation((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) newValue);
			return;
		case OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS:
			setInlineClass((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) newValue);
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
		case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
			setAssociation((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) null);
			return;
		case OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS:
			setInlineClass((org.eclipse.emf.emfstore.internal.common.model.ModelElementId) null);
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
		case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
			return association != null;
		case OperationsPackage.INLINE_CLASS_OPERATION__INLINE_CLASS:
			return inlineClass != null;
		}
		return super.eIsSet(featureID);
	}

	public void semanticApply(Project project) {
		Association association = getAssociation(project);
		org.unicase.model.classes.Class inlinedClass = association.getTarget();
		org.unicase.model.classes.Class contextClass = association.getSource();
		List<Attribute> attributes = inlinedClass.getAttributes();
		List<Association> associations = inlinedClass.getOutgoingAssociations();

		contextClass.getAttributes().addAll(attributes);
		contextClass.getOutgoingAssociations().addAll(associations);
		ModelUtil.getProject(association).deleteModelElement(association);
		ModelUtil.getProject(inlinedClass).deleteModelElement(inlinedClass);
	}

} // InlineClassOperationImpl
