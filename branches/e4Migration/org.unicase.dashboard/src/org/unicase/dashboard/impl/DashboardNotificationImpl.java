/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Notification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#isSeen <em>Seen</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getRecipient <em>Recipient</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getRelatedModelElements <em>Related Model Elements</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.DashboardNotificationImpl#getRelatedOperations <em>Related Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DashboardNotificationImpl extends EObjectImpl implements
		DashboardNotification {
	/**
	 * The default value of the '{@link #isSeen() <em>Seen</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isSeen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSeen() <em>Seen</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isSeen()
	 * @generated
	 * @ordered
	 */
	protected boolean seen = SEEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDetails() <em>Details</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected static final String DETAILS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDetails() <em>Details</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected String details = DETAILS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSender() <em>Sender</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected static final String SENDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected String sender = SENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecipient() <em>Recipient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected static final String RECIPIENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecipient() <em>Recipient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected String recipient = RECIPIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.server.model.ProjectId project;

	/**
	 * The cached value of the '{@link #getRelatedModelElements() <em>Related Model Elements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelatedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> relatedModelElements;

	/**
	 * The cached value of the '{@link #getRelatedOperations() <em>Related Operations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelatedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId> relatedOperations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DashboardNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DashboardPackage.Literals.DASHBOARD_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSeen() {
		return seen;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeen(boolean newSeen) {
		boolean oldSeen = seen;
		seen = newSeen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__SEEN, oldSeen,
					seen));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__MESSAGE,
					oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetails(String newDetails) {
		String oldDetails = details;
		details = newDetails;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__DETAILS,
					oldDetails, details));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(String newSender) {
		String oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__SENDER, oldSender,
					sender));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecipient(String newRecipient) {
		String oldRecipient = recipient;
		recipient = newRecipient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__RECIPIENT,
					oldRecipient, recipient));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__PROVIDER,
					oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__CREATION_DATE,
					oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.ProjectId getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject) project;
			project = (org.eclipse.emf.emfstore.internal.server.model.ProjectId) eResolveProxy(oldProject);
			if (project != oldProject) {
				InternalEObject newProject = (InternalEObject) project;
				NotificationChain msgs = oldProject
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
								null, null);
				if (newProject.eInternalContainer() == null) {
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
							- DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
							oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.ProjectId basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(
			org.eclipse.emf.emfstore.internal.server.model.ProjectId newProject,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.server.model.ProjectId oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
					oldProject, newProject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(
			org.eclipse.emf.emfstore.internal.server.model.ProjectId newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject) project)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
								null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject) newProject)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
								null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT,
					newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getRelatedModelElements() {
		if (relatedModelElements == null) {
			relatedModelElements = new EObjectContainmentEList.Resolving<org.eclipse.emf.emfstore.internal.common.model.ModelElementId>(
					org.eclipse.emf.emfstore.internal.common.model.ModelElementId.class,
					this,
					DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS);
		}
		return relatedModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId> getRelatedOperations() {
		if (relatedOperations == null) {
			relatedOperations = new EObjectContainmentEList.Resolving<org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId>(
					org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId.class,
					this,
					DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS);
		}
		return relatedOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT:
			return basicSetProject(null, msgs);
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS:
			return ((InternalEList<?>) getRelatedModelElements()).basicRemove(
					otherEnd, msgs);
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS:
			return ((InternalEList<?>) getRelatedOperations()).basicRemove(
					otherEnd, msgs);
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
		case DashboardPackage.DASHBOARD_NOTIFICATION__SEEN:
			return isSeen();
		case DashboardPackage.DASHBOARD_NOTIFICATION__NAME:
			return getName();
		case DashboardPackage.DASHBOARD_NOTIFICATION__MESSAGE:
			return getMessage();
		case DashboardPackage.DASHBOARD_NOTIFICATION__DETAILS:
			return getDetails();
		case DashboardPackage.DASHBOARD_NOTIFICATION__SENDER:
			return getSender();
		case DashboardPackage.DASHBOARD_NOTIFICATION__RECIPIENT:
			return getRecipient();
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROVIDER:
			return getProvider();
		case DashboardPackage.DASHBOARD_NOTIFICATION__CREATION_DATE:
			return getCreationDate();
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT:
			if (resolve)
				return getProject();
			return basicGetProject();
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS:
			return getRelatedModelElements();
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS:
			return getRelatedOperations();
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
		case DashboardPackage.DASHBOARD_NOTIFICATION__SEEN:
			setSeen((Boolean) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__NAME:
			setName((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__MESSAGE:
			setMessage((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__DETAILS:
			setDetails((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__SENDER:
			setSender((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RECIPIENT:
			setRecipient((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROVIDER:
			setProvider((String) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__CREATION_DATE:
			setCreationDate((Date) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT:
			setProject((org.eclipse.emf.emfstore.internal.server.model.ProjectId) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS:
			getRelatedModelElements().clear();
			getRelatedModelElements()
					.addAll((Collection<? extends org.eclipse.emf.emfstore.internal.common.model.ModelElementId>) newValue);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS:
			getRelatedOperations().clear();
			getRelatedOperations()
					.addAll((Collection<? extends org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId>) newValue);
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
		case DashboardPackage.DASHBOARD_NOTIFICATION__SEEN:
			setSeen(SEEN_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__MESSAGE:
			setMessage(MESSAGE_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__DETAILS:
			setDetails(DETAILS_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__SENDER:
			setSender(SENDER_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RECIPIENT:
			setRecipient(RECIPIENT_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROVIDER:
			setProvider(PROVIDER_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__CREATION_DATE:
			setCreationDate(CREATION_DATE_EDEFAULT);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT:
			setProject((org.eclipse.emf.emfstore.internal.server.model.ProjectId) null);
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS:
			getRelatedModelElements().clear();
			return;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS:
			getRelatedOperations().clear();
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
		case DashboardPackage.DASHBOARD_NOTIFICATION__SEEN:
			return seen != SEEN_EDEFAULT;
		case DashboardPackage.DASHBOARD_NOTIFICATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case DashboardPackage.DASHBOARD_NOTIFICATION__MESSAGE:
			return MESSAGE_EDEFAULT == null ? message != null
					: !MESSAGE_EDEFAULT.equals(message);
		case DashboardPackage.DASHBOARD_NOTIFICATION__DETAILS:
			return DETAILS_EDEFAULT == null ? details != null
					: !DETAILS_EDEFAULT.equals(details);
		case DashboardPackage.DASHBOARD_NOTIFICATION__SENDER:
			return SENDER_EDEFAULT == null ? sender != null : !SENDER_EDEFAULT
					.equals(sender);
		case DashboardPackage.DASHBOARD_NOTIFICATION__RECIPIENT:
			return RECIPIENT_EDEFAULT == null ? recipient != null
					: !RECIPIENT_EDEFAULT.equals(recipient);
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROVIDER:
			return PROVIDER_EDEFAULT == null ? provider != null
					: !PROVIDER_EDEFAULT.equals(provider);
		case DashboardPackage.DASHBOARD_NOTIFICATION__CREATION_DATE:
			return CREATION_DATE_EDEFAULT == null ? creationDate != null
					: !CREATION_DATE_EDEFAULT.equals(creationDate);
		case DashboardPackage.DASHBOARD_NOTIFICATION__PROJECT:
			return project != null;
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS:
			return relatedModelElements != null
					&& !relatedModelElements.isEmpty();
		case DashboardPackage.DASHBOARD_NOTIFICATION__RELATED_OPERATIONS:
			return relatedOperations != null && !relatedOperations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (seen: ");
		result.append(seen);
		result.append(", name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", details: ");
		result.append(details);
		result.append(", sender: ");
		result.append(sender);
		result.append(", recipient: ");
		result.append(recipient);
		result.append(", provider: ");
		result.append(provider);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} // DashboardNotificationImpl
