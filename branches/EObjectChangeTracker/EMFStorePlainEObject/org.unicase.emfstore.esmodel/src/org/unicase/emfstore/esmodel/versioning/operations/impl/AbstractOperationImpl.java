/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.impl.IdentifiableElementImpl;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getDescription <em>
 * Description</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getModelElementId <em>Model
 * Element Id</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#isAccepted <em>Accepted
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getClientDate <em>Client
 * Date</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractOperationImpl extends IdentifiableElementImpl implements AbstractOperation {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getModelElementId() <em>Model Element Id</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElementId;

	/**
	 * The default value of the '{@link #isAccepted() <em>Accepted</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAccepted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACCEPTED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAccepted() <em>Accepted</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAccepted()
	 * @generated
	 * @ordered
	 */
	protected boolean accepted = ACCEPTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientDate() <em>Client Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getClientDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CLIENT_DATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getClientDate() <em>Client Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getClientDate()
	 * @generated
	 * @ordered
	 */
	protected Date clientDate = CLIENT_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.ABSTRACT_OPERATION;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Return the operations name.
	 * 
	 * @return the name <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getName();

	/**
	 * <!-- begin-user-doc --> Return the operations description.
	 * 
	 * @return the description <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getDescription();

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getModelElementId() {
		if (modelElementId != null && modelElementId.eIsProxy()) {
			InternalEObject oldModelElementId = (InternalEObject) modelElementId;
			modelElementId = (ModelElementId) eResolveProxy(oldModelElementId);
			if (modelElementId != oldModelElementId) {
				InternalEObject newModelElementId = (InternalEObject) modelElementId;
				NotificationChain msgs = oldModelElementId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, null, null);
				if (newModelElementId.eInternalContainer() == null) {
					msgs = newModelElementId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, oldModelElementId, modelElementId));
			}
		}
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetModelElementId() {
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModelElementId(ModelElementId newModelElementId, NotificationChain msgs) {
		ModelElementId oldModelElementId = modelElementId;
		modelElementId = newModelElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, oldModelElementId, newModelElementId);
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
	public void setModelElementId(ModelElementId newModelElementId) {
		if (newModelElementId != modelElementId) {
			NotificationChain msgs = null;
			if (modelElementId != null)
				msgs = ((InternalEObject) modelElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, null, msgs);
			if (newModelElementId != null)
				msgs = ((InternalEObject) newModelElementId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, null, msgs);
			msgs = basicSetModelElementId(newModelElementId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, newModelElementId, newModelElementId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAccepted(boolean newAccepted) {
		boolean oldAccepted = accepted;
		accepted = newAccepted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.ABSTRACT_OPERATION__ACCEPTED,
				oldAccepted, accepted));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getClientDate() {
		return clientDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClientDate(Date newClientDate) {
		Date oldClientDate = clientDate;
		clientDate = newClientDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE,
				oldClientDate, clientDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			return basicSetModelElementId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public abstract AbstractOperation reverse();

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	protected void reverse(AbstractOperation abstractOperation) {
		abstractOperation.setModelElementId(ModelUtil.clone(getModelElementId()));
		abstractOperation.setClientDate(new Date());
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__NAME:
			return getName();
		case OperationsPackage.ABSTRACT_OPERATION__DESCRIPTION:
			return getDescription();
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			if (resolve)
				return getModelElementId();
			return basicGetModelElementId();
		case OperationsPackage.ABSTRACT_OPERATION__ACCEPTED:
			return isAccepted();
		case OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE:
			return getClientDate();
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
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) newValue);
			return;
		case OperationsPackage.ABSTRACT_OPERATION__ACCEPTED:
			setAccepted((Boolean) newValue);
			return;
		case OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE:
			setClientDate((Date) newValue);
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
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) null);
			return;
		case OperationsPackage.ABSTRACT_OPERATION__ACCEPTED:
			setAccepted(ACCEPTED_EDEFAULT);
			return;
		case OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE:
			setClientDate(CLIENT_DATE_EDEFAULT);
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
		case OperationsPackage.ABSTRACT_OPERATION__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		case OperationsPackage.ABSTRACT_OPERATION__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT
				.equals(getDescription());
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			return modelElementId != null;
		case OperationsPackage.ABSTRACT_OPERATION__ACCEPTED:
			return accepted != ACCEPTED_EDEFAULT;
		case OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE:
			return CLIENT_DATE_EDEFAULT == null ? clientDate != null : !CLIENT_DATE_EDEFAULT.equals(clientDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accepted: ");
		result.append(accepted);
		result.append(", clientDate: ");
		result.append(clientDate);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.ModelElement#getModelElementId()
	 */
	public OperationId getOperationId() {
		if (this.identifier == null) {
			throw new IllegalStateException("Operation does not have an identifier");
		}
		OperationId operationId = OperationsFactory.eINSTANCE.createOperationId();
		operationId.setId(this.identifier);
		return operationId;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getAllInvolvedModelElements()
	 */
	public Set<ModelElementId> getAllInvolvedModelElements() {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		if (getModelElementId() != null) {
			result.add(getModelElementId());
		}
		result.addAll(getOtherInvolvedModelElements());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getOtherInvolvedModelElements()
	 */
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		return new HashSet<ModelElementId>();
	}

} // AbstractOperationImpl
