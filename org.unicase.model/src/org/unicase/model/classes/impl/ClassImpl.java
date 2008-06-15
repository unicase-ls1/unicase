/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.ClassesPackage;

import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getParticipatedUseCases
 * <em>Participated Use Cases</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getSuperClass <em>Super
 * Class</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getSubClasses <em>Sub
 * Classes</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getIncomingAssociations
 * <em>Incoming Associations</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getOutgoingAssociations
 * <em>Outgoing Associations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ClassImpl extends PackageElementImpl implements
		org.unicase.model.classes.Class {
	/**
	 * The cached value of the '{@link #getParticipatedUseCases()
	 * <em>Participated Use Cases</em>}' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getParticipatedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> participatedUseCases;
	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected org.unicase.model.classes.Class superClass;
	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> subClasses;

	/**
	 * The cached value of the '{@link #getIncomingAssociations()
	 * <em>Incoming Associations</em>}' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIncomingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incomingAssociations;
	/**
	 * The cached value of the '{@link #getOutgoingAssociations()
	 * <em>Outgoing Associations</em>}' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOutgoingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoingAssociations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UseCase> getParticipatedUseCases() {
		if (participatedUseCases == null) {
			participatedUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(
					UseCase.class, this,
					ClassesPackage.CLASS__PARTICIPATED_USE_CASES,
					RequirementPackage.USE_CASE__IDENTIFIED_CLASSES);
		}
		return participatedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.unicase.model.classes.Class getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject) superClass;
			superClass = (org.unicase.model.classes.Class) eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ClassesPackage.CLASS__SUPER_CLASS, oldSuperClass,
							superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.unicase.model.classes.Class basicGetSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSuperClass(
			org.unicase.model.classes.Class newSuperClass,
			NotificationChain msgs) {
		org.unicase.model.classes.Class oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ClassesPackage.CLASS__SUPER_CLASS,
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
	public void setSuperClass(org.unicase.model.classes.Class newSuperClass) {
		if (newSuperClass != superClass) {
			NotificationChain msgs = null;
			if (superClass != null)
				msgs = ((InternalEObject) superClass).eInverseRemove(this,
						ClassesPackage.CLASS__SUB_CLASSES,
						org.unicase.model.classes.Class.class, msgs);
			if (newSuperClass != null)
				msgs = ((InternalEObject) newSuperClass).eInverseAdd(this,
						ClassesPackage.CLASS__SUB_CLASSES,
						org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetSuperClass(newSuperClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.CLASS__SUPER_CLASS, newSuperClass,
					newSuperClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectWithInverseResolvingEList<org.unicase.model.classes.Class>(
					org.unicase.model.classes.Class.class, this,
					ClassesPackage.CLASS__SUB_CLASSES,
					ClassesPackage.CLASS__SUPER_CLASS);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Association> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectWithInverseResolvingEList<Association>(
					Association.class, this,
					ClassesPackage.CLASS__INCOMING_ASSOCIATIONS,
					ClassesPackage.ASSOCIATION__TARGET);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Association> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectWithInverseResolvingEList<Association>(
					Association.class, this,
					ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS,
					ClassesPackage.ASSOCIATION__SOURCE);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipatedUseCases())
					.basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__SUPER_CLASS:
			if (superClass != null)
				msgs = ((InternalEObject) superClass).eInverseRemove(this,
						ClassesPackage.CLASS__SUB_CLASSES,
						org.unicase.model.classes.Class.class, msgs);
			return basicSetSuperClass(
					(org.unicase.model.classes.Class) otherEnd, msgs);
		case ClassesPackage.CLASS__SUB_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubClasses())
					.basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncomingAssociations())
					.basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoingAssociations())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return ((InternalEList<?>) getParticipatedUseCases()).basicRemove(
					otherEnd, msgs);
		case ClassesPackage.CLASS__SUPER_CLASS:
			return basicSetSuperClass(null, msgs);
		case ClassesPackage.CLASS__SUB_CLASSES:
			return ((InternalEList<?>) getSubClasses()).basicRemove(otherEnd,
					msgs);
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return ((InternalEList<?>) getIncomingAssociations()).basicRemove(
					otherEnd, msgs);
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return ((InternalEList<?>) getOutgoingAssociations()).basicRemove(
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return getParticipatedUseCases();
		case ClassesPackage.CLASS__SUPER_CLASS:
			if (resolve)
				return getSuperClass();
			return basicGetSuperClass();
		case ClassesPackage.CLASS__SUB_CLASSES:
			return getSubClasses();
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return getIncomingAssociations();
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return getOutgoingAssociations();
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			getParticipatedUseCases().addAll(
					(Collection<? extends UseCase>) newValue);
			return;
		case ClassesPackage.CLASS__SUPER_CLASS:
			setSuperClass((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.CLASS__SUB_CLASSES:
			getSubClasses().clear();
			getSubClasses()
					.addAll(
							(Collection<? extends org.unicase.model.classes.Class>) newValue);
			return;
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			getIncomingAssociations().clear();
			getIncomingAssociations().addAll(
					(Collection<? extends Association>) newValue);
			return;
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			getOutgoingAssociations().clear();
			getOutgoingAssociations().addAll(
					(Collection<? extends Association>) newValue);
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			return;
		case ClassesPackage.CLASS__SUPER_CLASS:
			setSuperClass((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.CLASS__SUB_CLASSES:
			getSubClasses().clear();
			return;
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			getIncomingAssociations().clear();
			return;
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			getOutgoingAssociations().clear();
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return participatedUseCases != null
					&& !participatedUseCases.isEmpty();
		case ClassesPackage.CLASS__SUPER_CLASS:
			return superClass != null;
		case ClassesPackage.CLASS__SUB_CLASSES:
			return subClasses != null && !subClasses.isEmpty();
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return incomingAssociations != null
					&& !incomingAssociations.isEmpty();
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return outgoingAssociations != null
					&& !outgoingAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ClassImpl
