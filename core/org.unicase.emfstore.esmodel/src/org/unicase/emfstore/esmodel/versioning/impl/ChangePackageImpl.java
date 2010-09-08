/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersionProperty;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCanonizer;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Change Package</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getOperations <em>Operations</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getEvents <em>Events</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getLogMessage <em>Log Message</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> operations;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getLogMessage() <em>Log Message</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogMessage()
	 * @generated
	 * @ordered
	 */
	protected LogMessage logMessage;

	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ESNotification> notifications;

	/**
	 * The cached value of the '{@link #getVersionProperties() <em>Version Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersionProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<VersionProperty> versionProperties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<AbstractOperation>(AbstractOperation.class, this, VersioningPackage.CHANGE_PACKAGE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList.Resolving<Event>(Event.class, this, VersioningPackage.CHANGE_PACKAGE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage getLogMessage() {
		if (logMessage != null && logMessage.eIsProxy()) {
			InternalEObject oldLogMessage = (InternalEObject)logMessage;
			logMessage = (LogMessage)eResolveProxy(oldLogMessage);
			if (logMessage != oldLogMessage) {
				InternalEObject newLogMessage = (InternalEObject)logMessage;
				NotificationChain msgs = oldLogMessage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, null, null);
				if (newLogMessage.eInternalContainer() == null) {
					msgs = newLogMessage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, oldLogMessage, logMessage));
			}
		}
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage basicGetLogMessage() {
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogMessage(LogMessage newLogMessage, NotificationChain msgs) {
		LogMessage oldLogMessage = logMessage;
		logMessage = newLogMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, oldLogMessage, newLogMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogMessage(LogMessage newLogMessage) {
		if (newLogMessage != logMessage) {
			NotificationChain msgs = null;
			if (logMessage != null)
				msgs = ((InternalEObject)logMessage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, null, msgs);
			if (newLogMessage != null)
				msgs = ((InternalEObject)newLogMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, null, msgs);
			msgs = basicSetLogMessage(newLogMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE, newLogMessage, newLogMessage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<ESNotification>(ESNotification.class, this, VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionProperty> getVersionProperties() {
		if (versionProperties == null) {
			versionProperties = new EObjectContainmentEList.Resolving<VersionProperty>(VersionProperty.class, this, VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES);
		}
		return versionProperties;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Reverse the change package. That applying the change package and the reversed change
	 * package to a project is a nop.
	 * 
	 * @return the reversed change package <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// reverse subOperations and add in reverse order
		EList<AbstractOperation> copiedSubOperations = changePackage.getOperations();
		for (AbstractOperation abstractOperation : getOperations()) {
			copiedSubOperations.add(0, abstractOperation.reverse());
		}
		return changePackage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#apply(org.unicase.metamodel.Project)
	 * @generated NOT
	 */
	public void apply(Project project) {
		apply(project, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#apply(org.unicase.metamodel.Project, boolean)
	 */
	public void apply(Project project, boolean force) {
		for (AbstractOperation operation : getOperations()) {
			try {
				operation.apply(project);
			} catch (IllegalStateException e) {
				if (!force) {
					throw e;
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> Cannonize the change package, that is remove all operations that are masked by later
	 * operations. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void cannonize() {
		OperationsCanonizer.canonize(getOperations());
	}

	// end of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case VersioningPackage.CHANGE_PACKAGE__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE:
				return basicSetLogMessage(null, msgs);
			case VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS:
				return ((InternalEList<?>)getNotifications()).basicRemove(otherEnd, msgs);
			case VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES:
				return ((InternalEList<?>)getVersionProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
				return getOperations();
			case VersioningPackage.CHANGE_PACKAGE__EVENTS:
				return getEvents();
			case VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE:
				if (resolve) return getLogMessage();
				return basicGetLogMessage();
			case VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS:
				return getNotifications();
			case VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES:
				return getVersionProperties();
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
			case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends AbstractOperation>)newValue);
				return;
			case VersioningPackage.CHANGE_PACKAGE__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE:
				setLogMessage((LogMessage)newValue);
				return;
			case VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS:
				getNotifications().clear();
				getNotifications().addAll((Collection<? extends ESNotification>)newValue);
				return;
			case VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES:
				getVersionProperties().clear();
				getVersionProperties().addAll((Collection<? extends VersionProperty>)newValue);
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
			case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
				getOperations().clear();
				return;
			case VersioningPackage.CHANGE_PACKAGE__EVENTS:
				getEvents().clear();
				return;
			case VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE:
				setLogMessage((LogMessage)null);
				return;
			case VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS:
				getNotifications().clear();
				return;
			case VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES:
				getVersionProperties().clear();
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
			case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case VersioningPackage.CHANGE_PACKAGE__EVENTS:
				return events != null && !events.isEmpty();
			case VersioningPackage.CHANGE_PACKAGE__LOG_MESSAGE:
				return logMessage != null;
			case VersioningPackage.CHANGE_PACKAGE__NOTIFICATIONS:
				return notifications != null && !notifications.isEmpty();
			case VersioningPackage.CHANGE_PACKAGE__VERSION_PROPERTIES:
				return versionProperties != null && !versionProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#getCopyOfOperations()
	 */
	public List<AbstractOperation> getCopyOfOperations() {
		List<AbstractOperation> copiedOperations = new ArrayList<AbstractOperation>();
		for (AbstractOperation operation : getOperations()) {
			copiedOperations.add((AbstractOperation) EcoreUtil.copy(operation));
		}
		return copiedOperations;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AbstractOperation> getLeafOperations() {
		List<AbstractOperation> leafOperations = new ArrayList<AbstractOperation>();
		for (AbstractOperation operation : getOperations()) {
			leafOperations.addAll(operation.getLeafOperations());
		}
		return leafOperations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#getAllInvolvedModelElements()
	 */
	public Set<ModelElementId> getAllInvolvedModelElements() {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		for (AbstractOperation operation : getOperations()) {
			result.addAll(operation.getAllInvolvedModelElements());
		}
		return result;
	}

	public List<AbstractOperation> getTouchingOperations(ModelElementId modelElementId) {
		ArrayList<AbstractOperation> result = new ArrayList<AbstractOperation>();
		for (AbstractOperation operation : getOperations()) {
			if (operation.getAllInvolvedModelElements().contains(modelElementId)) {
				result.add(operation);
			}
		}
		return result;
	}

} // ChangePackageImpl
