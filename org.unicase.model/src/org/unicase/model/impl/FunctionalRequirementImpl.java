/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.FunctionalRequirement;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#isReviewed <em>Reviewed</em>}</li>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#getRefiningRequirements <em>Refining Requirements</em>}</li>
 *   <li>{@link org.unicase.model.impl.FunctionalRequirementImpl#getRefinedRequirement <em>Refined Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalRequirementImpl extends ModelElementImpl implements FunctionalRequirement {
	/**
	 * The default value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVIEWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected boolean reviewed = REVIEWED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int STORY_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected int storyPoints = STORY_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefiningRequirements() <em>Refining Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefiningRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> refiningRequirements;

	/**
	 * The cached value of the '{@link #getRefinedRequirement() <em>Refined Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedRequirement()
	 * @generated
	 * @ordered
	 */
	protected FunctionalRequirement refinedRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReviewed() {
		return reviewed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewed(boolean newReviewed) {
		boolean oldReviewed = reviewed;
		reviewed = newReviewed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__REVIEWED, oldReviewed, reviewed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStoryPoints() {
		return storyPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoryPoints(int newStoryPoints) {
		int oldStoryPoints = storyPoints;
		storyPoints = newStoryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS, oldStoryPoints, storyPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getRefiningRequirements() {
		if (refiningRequirements == null) {
			refiningRequirements = new EObjectWithInverseResolvingEList<FunctionalRequirement>(FunctionalRequirement.class, this, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT);
		}
		return refiningRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getRefinedRequirement() {
		if (refinedRequirement != null && refinedRequirement.eIsProxy()) {
			InternalEObject oldRefinedRequirement = (InternalEObject)refinedRequirement;
			refinedRequirement = (FunctionalRequirement)eResolveProxy(oldRefinedRequirement);
			if (refinedRequirement != oldRefinedRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT, oldRefinedRequirement, refinedRequirement));
			}
		}
		return refinedRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetRefinedRequirement() {
		return refinedRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedRequirement(FunctionalRequirement newRefinedRequirement, NotificationChain msgs) {
		FunctionalRequirement oldRefinedRequirement = refinedRequirement;
		refinedRequirement = newRefinedRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT, oldRefinedRequirement, newRefinedRequirement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedRequirement(FunctionalRequirement newRefinedRequirement) {
		if (newRefinedRequirement != refinedRequirement) {
			NotificationChain msgs = null;
			if (refinedRequirement != null)
				msgs = ((InternalEObject)refinedRequirement).eInverseRemove(this, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS, FunctionalRequirement.class, msgs);
			if (newRefinedRequirement != null)
				msgs = ((InternalEObject)newRefinedRequirement).eInverseAdd(this, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS, FunctionalRequirement.class, msgs);
			msgs = basicSetRefinedRequirement(newRefinedRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT, newRefinedRequirement, newRefinedRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefiningRequirements()).basicAdd(otherEnd, msgs);
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				if (refinedRequirement != null)
					msgs = ((InternalEObject)refinedRequirement).eInverseRemove(this, ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS, FunctionalRequirement.class, msgs);
				return basicSetRefinedRequirement((FunctionalRequirement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				return ((InternalEList<?>)getRefiningRequirements()).basicRemove(otherEnd, msgs);
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				return basicSetRefinedRequirement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
				return isReviewed() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
				return new Integer(getStoryPoints());
			case ModelPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
				return new Integer(getPriority());
			case ModelPackage.FUNCTIONAL_REQUIREMENT__DATE:
				return getDate();
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				return getRefiningRequirements();
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				if (resolve) return getRefinedRequirement();
				return basicGetRefinedRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
				setReviewed(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
				setStoryPoints(((Integer)newValue).intValue());
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
				setPriority(((Integer)newValue).intValue());
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__DATE:
				setDate((Date)newValue);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				getRefiningRequirements().clear();
				getRefiningRequirements().addAll((Collection<? extends FunctionalRequirement>)newValue);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				setRefinedRequirement((FunctionalRequirement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
				setReviewed(REVIEWED_EDEFAULT);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
				setStoryPoints(STORY_POINTS_EDEFAULT);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				getRefiningRequirements().clear();
				return;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				setRefinedRequirement((FunctionalRequirement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
				return reviewed != REVIEWED_EDEFAULT;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
				return storyPoints != STORY_POINTS_EDEFAULT;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ModelPackage.FUNCTIONAL_REQUIREMENT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
				return refiningRequirements != null && !refiningRequirements.isEmpty();
			case ModelPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
				return refinedRequirement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reviewed: ");
		result.append(reviewed);
		result.append(", storyPoints: ");
		result.append(storyPoints);
		result.append(", priority: ");
		result.append(priority);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //FunctionalRequirementImpl
