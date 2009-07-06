/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.classes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Method;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Class</b></em>'. <!-- end-user-doc --> <p> The
 * following features are implemented: <ul> <li>{@link org.unicase.model.classes.impl.ClassImpl#getParticipatedUseCases
 * <em>Participated Use Cases</em>}</li> <li>{@link org.unicase.model.classes.impl.ClassImpl#getSuperClasses <em>Super
 * Classes</em>}</li> <li>{@link org.unicase.model.classes.impl.ClassImpl#getSubClasses <em>Sub Classes</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getIncomingAssociations <em>Incoming Associations</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.ClassImpl#getAttributes <em>Attributes</em>}</li> <li>{@link
 * org.unicase.model.classes.impl.ClassImpl#getMethods <em>Methods</em>}</li> </ul> </p>
 * @generated
 */
public class ClassImpl extends PackageElementImpl implements org.unicase.model.classes.Class {
	/**
	 * The cached value of the '{@link #getParticipatedUseCases() <em>Participated Use Cases</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParticipatedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> participatedUseCases;
	/**
	 * The cached value of the '{@link #getSuperClasses() <em>Super Classes</em>}' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> superClasses;
	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> subClasses;

	/**
	 * The cached value of the '{@link #getIncomingAssociations() <em>Incoming Associations</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncomingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incomingAssociations;
	/**
	 * The cached value of the '{@link #getOutgoingAssociations() <em>Outgoing Associations</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutgoingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoingAssociations;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getParticipatedUseCases() {
		if (participatedUseCases == null) {
			participatedUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(UseCase.class, this,
				ClassesPackage.CLASS__PARTICIPATED_USE_CASES, RequirementPackage.USE_CASE__IDENTIFIED_CLASSES);
		}
		return participatedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getSuperClasses() {
		if (superClasses == null) {
			superClasses = new EObjectWithInverseResolvingEList.ManyInverse<org.unicase.model.classes.Class>(
				org.unicase.model.classes.Class.class, this, ClassesPackage.CLASS__SUPER_CLASSES,
				ClassesPackage.CLASS__SUB_CLASSES);
		}
		return superClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectWithInverseResolvingEList.ManyInverse<org.unicase.model.classes.Class>(
				org.unicase.model.classes.Class.class, this, ClassesPackage.CLASS__SUB_CLASSES,
				ClassesPackage.CLASS__SUPER_CLASSES);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectWithInverseResolvingEList<Association>(Association.class, this,
				ClassesPackage.CLASS__INCOMING_ASSOCIATIONS, ClassesPackage.ASSOCIATION__TARGET);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectWithInverseResolvingEList<Association>(Association.class, this,
				ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS, ClassesPackage.ASSOCIATION__SOURCE);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList.Resolving<Attribute>(Attribute.class, this,
				ClassesPackage.CLASS__ATTRIBUTES, ClassesPackage.ATTRIBUTE__DEFINING_CLASS);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentWithInverseEList.Resolving<Method>(Method.class, this,
				ClassesPackage.CLASS__METHODS, ClassesPackage.METHOD__DEFINING_CLASS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipatedUseCases()).basicAdd(otherEnd,
				msgs);
		case ClassesPackage.CLASS__SUPER_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuperClasses()).basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__SUB_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubClasses()).basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncomingAssociations()).basicAdd(otherEnd,
				msgs);
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoingAssociations()).basicAdd(otherEnd,
				msgs);
		case ClassesPackage.CLASS__ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAttributes()).basicAdd(otherEnd, msgs);
		case ClassesPackage.CLASS__METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMethods()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return ((InternalEList<?>) getParticipatedUseCases()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__SUPER_CLASSES:
			return ((InternalEList<?>) getSuperClasses()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__SUB_CLASSES:
			return ((InternalEList<?>) getSubClasses()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return ((InternalEList<?>) getIncomingAssociations()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return ((InternalEList<?>) getOutgoingAssociations()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case ClassesPackage.CLASS__METHODS:
			return ((InternalEList<?>) getMethods()).basicRemove(otherEnd, msgs);
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return getParticipatedUseCases();
		case ClassesPackage.CLASS__SUPER_CLASSES:
			return getSuperClasses();
		case ClassesPackage.CLASS__SUB_CLASSES:
			return getSubClasses();
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return getIncomingAssociations();
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return getOutgoingAssociations();
		case ClassesPackage.CLASS__ATTRIBUTES:
			return getAttributes();
		case ClassesPackage.CLASS__METHODS:
			return getMethods();
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			getParticipatedUseCases().addAll((Collection<? extends UseCase>) newValue);
			return;
		case ClassesPackage.CLASS__SUPER_CLASSES:
			getSuperClasses().clear();
			getSuperClasses().addAll((Collection<? extends org.unicase.model.classes.Class>) newValue);
			return;
		case ClassesPackage.CLASS__SUB_CLASSES:
			getSubClasses().clear();
			getSubClasses().addAll((Collection<? extends org.unicase.model.classes.Class>) newValue);
			return;
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			getIncomingAssociations().clear();
			getIncomingAssociations().addAll((Collection<? extends Association>) newValue);
			return;
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			getOutgoingAssociations().clear();
			getOutgoingAssociations().addAll((Collection<? extends Association>) newValue);
			return;
		case ClassesPackage.CLASS__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends Attribute>) newValue);
			return;
		case ClassesPackage.CLASS__METHODS:
			getMethods().clear();
			getMethods().addAll((Collection<? extends Method>) newValue);
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			return;
		case ClassesPackage.CLASS__SUPER_CLASSES:
			getSuperClasses().clear();
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
		case ClassesPackage.CLASS__ATTRIBUTES:
			getAttributes().clear();
			return;
		case ClassesPackage.CLASS__METHODS:
			getMethods().clear();
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
		case ClassesPackage.CLASS__PARTICIPATED_USE_CASES:
			return participatedUseCases != null && !participatedUseCases.isEmpty();
		case ClassesPackage.CLASS__SUPER_CLASSES:
			return superClasses != null && !superClasses.isEmpty();
		case ClassesPackage.CLASS__SUB_CLASSES:
			return subClasses != null && !subClasses.isEmpty();
		case ClassesPackage.CLASS__INCOMING_ASSOCIATIONS:
			return incomingAssociations != null && !incomingAssociations.isEmpty();
		case ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS:
			return outgoingAssociations != null && !outgoingAssociations.isEmpty();
		case ClassesPackage.CLASS__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case ClassesPackage.CLASS__METHODS:
			return methods != null && !methods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ClassImpl
