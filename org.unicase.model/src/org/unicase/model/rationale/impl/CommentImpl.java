/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.impl.AnnotationImpl;

import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationalePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Comment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.rationale.impl.CommentImpl#getReplies <em>
 * Replies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CommentImpl extends AnnotationImpl implements Comment {
	/**
	 * The cached value of the '{@link #getReplies() <em>Replies</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReplies()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> replies;

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
			replies = new EObjectResolvingEList<Comment>(Comment.class, this,
					RationalePackage.COMMENT__REPLIES);
		}
		return replies;
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
		}
		return super.eIsSet(featureID);
	}

} // CommentImpl
