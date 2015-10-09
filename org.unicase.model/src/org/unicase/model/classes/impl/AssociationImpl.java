/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Association</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getSourceMultiplicity <em>Source Multiplicity</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getTargetMultiplicity <em>Target Multiplicity</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getSourceRole <em>Source Role</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#getTargetRole <em>Target Role</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AssociationImpl#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends UnicaseModelElementImpl implements
		Association {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected org.unicase.model.classes.Class source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected org.unicase.model.classes.Class target;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AssociationType TYPE_EDEFAULT = AssociationType.UNDIRECTED_ASSOCIATION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AssociationType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceMultiplicity() <em>Source Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_MULTIPLICITY_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getSourceMultiplicity() <em>Source Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String sourceMultiplicity = SOURCE_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetMultiplicity() <em>Target Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_MULTIPLICITY_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getTargetMultiplicity() <em>Target Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String targetMultiplicity = TARGET_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceRole() <em>Source Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceRole()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceRole() <em>Source Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceRole()
	 * @generated
	 * @ordered
	 */
	protected String sourceRole = SOURCE_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetRole() <em>Target Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTargetRole()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetRole() <em>Target Role</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTargetRole()
	 * @generated
	 * @ordered
	 */
	protected String targetRole = TARGET_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (org.unicase.model.classes.Class) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ClassesPackage.ASSOCIATION__SOURCE, oldSource,
							source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(
			org.unicase.model.classes.Class newSource, NotificationChain msgs) {
		org.unicase.model.classes.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ClassesPackage.ASSOCIATION__SOURCE,
					oldSource, newSource);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(org.unicase.model.classes.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (org.unicase.model.classes.Class) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ClassesPackage.ASSOCIATION__TARGET, oldTarget,
							target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(
			org.unicase.model.classes.Class newTarget, NotificationChain msgs) {
		org.unicase.model.classes.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ClassesPackage.ASSOCIATION__TARGET,
					oldTarget, newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(org.unicase.model.classes.Class newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this,
						ClassesPackage.CLASS__INCOMING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject) newTarget).eInverseAdd(this,
						ClassesPackage.CLASS__INCOMING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AssociationType newType) {
		AssociationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceMultiplicity() {
		return sourceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMultiplicity(String newSourceMultiplicity) {
		String oldSourceMultiplicity = sourceMultiplicity;
		sourceMultiplicity = newSourceMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY,
					oldSourceMultiplicity, sourceMultiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetMultiplicity() {
		return targetMultiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMultiplicity(String newTargetMultiplicity) {
		String oldTargetMultiplicity = targetMultiplicity;
		targetMultiplicity = newTargetMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY,
					oldTargetMultiplicity, targetMultiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceRole() {
		return sourceRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRole(String newSourceRole) {
		String oldSourceRole = sourceRole;
		sourceRole = newSourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__SOURCE_ROLE, oldSourceRole,
					sourceRole));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetRole() {
		return targetRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRole(String newTargetRole) {
		String oldTargetRole = targetRole;
		targetRole = newTargetRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__TARGET_ROLE, oldTargetRole,
					targetRole));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransient(boolean newTransient) {
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ASSOCIATION__TRANSIENT, oldTransient,
					transient_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.ASSOCIATION__SOURCE:
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						ClassesPackage.CLASS__OUTGOING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			return basicSetSource((org.unicase.model.classes.Class) otherEnd,
					msgs);
		case ClassesPackage.ASSOCIATION__TARGET:
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this,
						ClassesPackage.CLASS__INCOMING_ASSOCIATIONS,
						org.unicase.model.classes.Class.class, msgs);
			return basicSetTarget((org.unicase.model.classes.Class) otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.ASSOCIATION__SOURCE:
			return basicSetSource(null, msgs);
		case ClassesPackage.ASSOCIATION__TARGET:
			return basicSetTarget(null, msgs);
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
		case ClassesPackage.ASSOCIATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case ClassesPackage.ASSOCIATION__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case ClassesPackage.ASSOCIATION__TYPE:
			return getType();
		case ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY:
			return getSourceMultiplicity();
		case ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY:
			return getTargetMultiplicity();
		case ClassesPackage.ASSOCIATION__SOURCE_ROLE:
			return getSourceRole();
		case ClassesPackage.ASSOCIATION__TARGET_ROLE:
			return getTargetRole();
		case ClassesPackage.ASSOCIATION__TRANSIENT:
			return isTransient();
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
		case ClassesPackage.ASSOCIATION__SOURCE:
			setSource((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.ASSOCIATION__TARGET:
			setTarget((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.ASSOCIATION__TYPE:
			setType((AssociationType) newValue);
			return;
		case ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY:
			setSourceMultiplicity((String) newValue);
			return;
		case ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY:
			setTargetMultiplicity((String) newValue);
			return;
		case ClassesPackage.ASSOCIATION__SOURCE_ROLE:
			setSourceRole((String) newValue);
			return;
		case ClassesPackage.ASSOCIATION__TARGET_ROLE:
			setTargetRole((String) newValue);
			return;
		case ClassesPackage.ASSOCIATION__TRANSIENT:
			setTransient((Boolean) newValue);
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
		case ClassesPackage.ASSOCIATION__SOURCE:
			setSource((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.ASSOCIATION__TARGET:
			setTarget((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.ASSOCIATION__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY:
			setSourceMultiplicity(SOURCE_MULTIPLICITY_EDEFAULT);
			return;
		case ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY:
			setTargetMultiplicity(TARGET_MULTIPLICITY_EDEFAULT);
			return;
		case ClassesPackage.ASSOCIATION__SOURCE_ROLE:
			setSourceRole(SOURCE_ROLE_EDEFAULT);
			return;
		case ClassesPackage.ASSOCIATION__TARGET_ROLE:
			setTargetRole(TARGET_ROLE_EDEFAULT);
			return;
		case ClassesPackage.ASSOCIATION__TRANSIENT:
			setTransient(TRANSIENT_EDEFAULT);
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
		case ClassesPackage.ASSOCIATION__SOURCE:
			return source != null;
		case ClassesPackage.ASSOCIATION__TARGET:
			return target != null;
		case ClassesPackage.ASSOCIATION__TYPE:
			return type != TYPE_EDEFAULT;
		case ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY:
			return SOURCE_MULTIPLICITY_EDEFAULT == null ? sourceMultiplicity != null
					: !SOURCE_MULTIPLICITY_EDEFAULT.equals(sourceMultiplicity);
		case ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY:
			return TARGET_MULTIPLICITY_EDEFAULT == null ? targetMultiplicity != null
					: !TARGET_MULTIPLICITY_EDEFAULT.equals(targetMultiplicity);
		case ClassesPackage.ASSOCIATION__SOURCE_ROLE:
			return SOURCE_ROLE_EDEFAULT == null ? sourceRole != null
					: !SOURCE_ROLE_EDEFAULT.equals(sourceRole);
		case ClassesPackage.ASSOCIATION__TARGET_ROLE:
			return TARGET_ROLE_EDEFAULT == null ? targetRole != null
					: !TARGET_ROLE_EDEFAULT.equals(targetRole);
		case ClassesPackage.ASSOCIATION__TRANSIENT:
			return transient_ != TRANSIENT_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", sourceMultiplicity: ");
		result.append(sourceMultiplicity);
		result.append(", targetMultiplicity: ");
		result.append(targetMultiplicity);
		result.append(", sourceRole: ");
		result.append(sourceRole);
		result.append(", targetRole: ");
		result.append(targetRole);
		result.append(", transient: ");
		result.append(transient_);
		result.append(')');
		return result.toString();
	}

} // AssociationImpl
