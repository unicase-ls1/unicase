/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.mindmap.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Priority;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.Topic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getPercentComplete <em>Percent Complete</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getSubtopics <em>Subtopics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopicImpl extends EObjectImpl implements Topic {
	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.gmf.examples.mindmap.Thread> comments;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final float DURATION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected float duration = DURATION_EDEFAULT;

	/**
	 * This is true if the Duration attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean durationESet;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPercentComplete() <em>Percent Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentComplete()
	 * @generated
	 * @ordered
	 */
	protected static final float PERCENT_COMPLETE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPercentComplete() <em>Percent Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentComplete()
	 * @generated
	 * @ordered
	 */
	protected float percentComplete = PERCENT_COMPLETE_EDEFAULT;

	/**
	 * This is true if the Percent Complete attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean percentCompleteESet;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Priority PRIORITY_EDEFAULT = Priority.ZERO;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Priority priority = PRIORITY_EDEFAULT;

	/**
	 * This is true if the Priority attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean priorityESet;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar startDate = START_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubtopics() <em>Subtopics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> subtopics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MindmapPackage.Literals.TOPIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.gmf.examples.mindmap.Thread> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList<org.eclipse.gmf.examples.mindmap.Thread>(org.eclipse.gmf.examples.mindmap.Thread.class, this, MindmapPackage.TOPIC__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(float newDuration) {
		float oldDuration = duration;
		duration = newDuration;
		boolean oldDurationESet = durationESet;
		durationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__DURATION, oldDuration, duration, !oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		float oldDuration = duration;
		boolean oldDurationESet = durationESet;
		duration = DURATION_EDEFAULT;
		durationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MindmapPackage.TOPIC__DURATION, oldDuration, DURATION_EDEFAULT, oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return durationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(XMLGregorianCalendar newEndDate) {
		XMLGregorianCalendar oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPercentComplete() {
		return percentComplete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentComplete(float newPercentComplete) {
		float oldPercentComplete = percentComplete;
		percentComplete = newPercentComplete;
		boolean oldPercentCompleteESet = percentCompleteESet;
		percentCompleteESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__PERCENT_COMPLETE, oldPercentComplete, percentComplete, !oldPercentCompleteESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPercentComplete() {
		float oldPercentComplete = percentComplete;
		boolean oldPercentCompleteESet = percentCompleteESet;
		percentComplete = PERCENT_COMPLETE_EDEFAULT;
		percentCompleteESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MindmapPackage.TOPIC__PERCENT_COMPLETE, oldPercentComplete, PERCENT_COMPLETE_EDEFAULT, oldPercentCompleteESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPercentComplete() {
		return percentCompleteESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(Priority newPriority) {
		Priority oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		boolean oldPriorityESet = priorityESet;
		priorityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__PRIORITY, oldPriority, priority, !oldPriorityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPriority() {
		Priority oldPriority = priority;
		boolean oldPriorityESet = priorityESet;
		priority = PRIORITY_EDEFAULT;
		priorityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MindmapPackage.TOPIC__PRIORITY, oldPriority, PRIORITY_EDEFAULT, oldPriorityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPriority() {
		return priorityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectWithInverseResolvingEList.ManyInverse<Resource>(Resource.class, this, MindmapPackage.TOPIC__RESOURCES, MindmapPackage.RESOURCE__TOPICS);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(XMLGregorianCalendar newStartDate) {
		XMLGregorianCalendar oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Topic> getSubtopics() {
		if (subtopics == null) {
			subtopics = new EObjectResolvingEList<Topic>(Topic.class, this, MindmapPackage.TOPIC__SUBTOPICS);
		}
		return subtopics;
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
			case MindmapPackage.TOPIC__RESOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResources()).basicAdd(otherEnd, msgs);
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
			case MindmapPackage.TOPIC__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case MindmapPackage.TOPIC__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case MindmapPackage.TOPIC__COMMENTS:
				return getComments();
			case MindmapPackage.TOPIC__DURATION:
				return getDuration();
			case MindmapPackage.TOPIC__END_DATE:
				return getEndDate();
			case MindmapPackage.TOPIC__NAME:
				return getName();
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				return getPercentComplete();
			case MindmapPackage.TOPIC__PRIORITY:
				return getPriority();
			case MindmapPackage.TOPIC__RESOURCES:
				return getResources();
			case MindmapPackage.TOPIC__START_DATE:
				return getStartDate();
			case MindmapPackage.TOPIC__SUBTOPICS:
				return getSubtopics();
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
			case MindmapPackage.TOPIC__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends org.eclipse.gmf.examples.mindmap.Thread>)newValue);
				return;
			case MindmapPackage.TOPIC__DURATION:
				setDuration((Float)newValue);
				return;
			case MindmapPackage.TOPIC__END_DATE:
				setEndDate((XMLGregorianCalendar)newValue);
				return;
			case MindmapPackage.TOPIC__NAME:
				setName((String)newValue);
				return;
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				setPercentComplete((Float)newValue);
				return;
			case MindmapPackage.TOPIC__PRIORITY:
				setPriority((Priority)newValue);
				return;
			case MindmapPackage.TOPIC__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case MindmapPackage.TOPIC__START_DATE:
				setStartDate((XMLGregorianCalendar)newValue);
				return;
			case MindmapPackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
				getSubtopics().addAll((Collection<? extends Topic>)newValue);
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
			case MindmapPackage.TOPIC__COMMENTS:
				getComments().clear();
				return;
			case MindmapPackage.TOPIC__DURATION:
				unsetDuration();
				return;
			case MindmapPackage.TOPIC__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				unsetPercentComplete();
				return;
			case MindmapPackage.TOPIC__PRIORITY:
				unsetPriority();
				return;
			case MindmapPackage.TOPIC__RESOURCES:
				getResources().clear();
				return;
			case MindmapPackage.TOPIC__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
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
			case MindmapPackage.TOPIC__COMMENTS:
				return comments != null && !comments.isEmpty();
			case MindmapPackage.TOPIC__DURATION:
				return isSetDuration();
			case MindmapPackage.TOPIC__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case MindmapPackage.TOPIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				return isSetPercentComplete();
			case MindmapPackage.TOPIC__PRIORITY:
				return isSetPriority();
			case MindmapPackage.TOPIC__RESOURCES:
				return resources != null && !resources.isEmpty();
			case MindmapPackage.TOPIC__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case MindmapPackage.TOPIC__SUBTOPICS:
				return subtopics != null && !subtopics.isEmpty();
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
		result.append(" (duration: ");
		if (durationESet) result.append(duration); else result.append("<unset>");
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", name: ");
		result.append(name);
		result.append(", percentComplete: ");
		if (percentCompleteESet) result.append(percentComplete); else result.append("<unset>");
		result.append(", priority: ");
		if (priorityESet) result.append(priority); else result.append("<unset>");
		result.append(", startDate: ");
		result.append(startDate);
		result.append(')');
		return result.toString();
	}

} //TopicImpl
