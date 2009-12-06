/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.validation.ClassesHelper;
import org.unicase.model.classes.validation.MultiplicityParseResult;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Inline Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.InlineClassOperationImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineClassOperationImpl extends SemanticCompositeOperationImpl implements InlineClassOperation {
	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId association;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InlineClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.INLINE_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(ModelElementId newAssociation, NotificationChain msgs) {
		ModelElementId oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION, oldAssociation, newAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(ModelElementId newAssociation) {
		if (newAssociation != association) {
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject)association).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION, null, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION, null, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Association getAssociation(Project project) {
		return OperationHelper.getElement(project, getAssociation());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationComposition(Project project) {
		Association association = getAssociation(project);
		return association.getType() == AssociationType.COMPOSITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationMultiplicity(Project project) {
		Association association = getAssociation(project);
		MultiplicityParseResult targetMultiplicity = ClassesHelper.parseMultiplicity(association
			.getTargetMultiplicity());
		MultiplicityParseResult sourceMultiplicity = ClassesHelper.parseMultiplicity(association
			.getSourceMultiplicity());

		return targetMultiplicity.getMaximumMultiplicity() == 1 && sourceMultiplicity.getMaximumMultiplicity() == 1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateInlineClassSubClasses(Project project) {
		Association association = getAssociation(project);
		Class inlinedClass = association.getTarget();

		return inlinedClass.getSubClasses().isEmpty();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateInlineClassAssociationTarget(Project project) {
		Association association = getAssociation(project);
		Class inlinedClass = association.getTarget();

		EList<Association> incomingAssociations = inlinedClass.getIncomingAssociations();
		return incomingAssociations.size() == 1 && incomingAssociations.get(0) == association;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
				return basicSetAssociation(null, msgs);
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
			case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
				return getAssociation();
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
			case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
				setAssociation((ModelElementId)newValue);
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
			case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
				setAssociation((ModelElementId)null);
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
			case OperationsPackage.INLINE_CLASS_OPERATION__ASSOCIATION:
				return association != null;
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
		association.delete();
		inlinedClass.delete();
	}

} // InlineClassOperationImpl
