/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationalePackage;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Comment</b></em>'. <!-- end-user-doc --> <p>
 * The following features are implemented: <ul> <li>{@link org.unicase.model.rationale.impl.CommentImpl#getReplies
 * <em>Replies</em>}</li> </ul> </p>
 * @generated
 */
public class CommentImpl extends AnnotationImpl implements Comment {
	/**
	 * The cached value of the '{@link #getReplies() <em>Replies</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getReplies()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> replies;

	/**
	 * The cached value of the '{@link #getRecipient() <em>Recipient</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit recipient;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.COMMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Comment> getReplies() {
		if (replies == null) {
			replies = new EObjectContainmentEList.Resolving<Comment>(Comment.class, this,
				RationalePackage.COMMENT__REPLIES);
		}
		return replies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OrgUnit getRecipient() {
		if (recipient != null && recipient.eIsProxy()) {
			InternalEObject oldRecipient = (InternalEObject) recipient;
			recipient = (OrgUnit) eResolveProxy(oldRecipient);
			if (recipient != oldRecipient) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RationalePackage.COMMENT__RECIPIENT,
						oldRecipient, recipient));
			}
		}
		return recipient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OrgUnit basicGetRecipient() {
		return recipient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRecipient(OrgUnit newRecipient) {
		OrgUnit oldRecipient = recipient;
		recipient = newRecipient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.COMMENT__RECIPIENT, oldRecipient,
				recipient));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RationalePackage.COMMENT__REPLIES:
			return ((InternalEList<?>) getReplies()).basicRemove(otherEnd, msgs);
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
		case RationalePackage.COMMENT__REPLIES:
			return getReplies();
		case RationalePackage.COMMENT__RECIPIENT:
			if (resolve)
				return getRecipient();
			return basicGetRecipient();
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
		case RationalePackage.COMMENT__REPLIES:
			getReplies().clear();
			getReplies().addAll((Collection<? extends Comment>) newValue);
			return;
		case RationalePackage.COMMENT__RECIPIENT:
			setRecipient((OrgUnit) newValue);
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
		case RationalePackage.COMMENT__REPLIES:
			getReplies().clear();
			return;
		case RationalePackage.COMMENT__RECIPIENT:
			setRecipient((OrgUnit) null);
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
		case RationalePackage.COMMENT__REPLIES:
			return replies != null && !replies.isEmpty();
		case RationalePackage.COMMENT__RECIPIENT:
			return recipient != null;
		}
		return super.eIsSet(featureID);
	}

} // CommentImpl
