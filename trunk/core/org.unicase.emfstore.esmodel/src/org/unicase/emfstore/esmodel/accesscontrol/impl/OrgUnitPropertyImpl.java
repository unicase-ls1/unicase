/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Org Unit Properties</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.impl.OrgUnitPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.impl.OrgUnitPropertyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.accesscontrol.impl.OrgUnitPropertyImpl#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrgUnitPropertyImpl extends EObjectImpl implements OrgUnitProperty {
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected ProjectId project;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgUnitPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.ORG_UNIT_PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ORG_UNIT_PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ORG_UNIT_PROPERTY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (ProjectId)eResolveProxy(oldProject);
			if (project != oldProject) {
				InternalEObject newProject = (InternalEObject)project;
				NotificationChain msgs = oldProject.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, null, null);
				if (newProject.eInternalContainer() == null) {
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(ProjectId newProject, NotificationChain msgs) {
		ProjectId oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, oldProject, newProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(ProjectId newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT:
				return basicSetProject(null, msgs);
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
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__NAME:
				return getName();
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__VALUE:
				return getValue();
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
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
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__VALUE:
				setValue((String)newValue);
				return;
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT:
				setProject((ProjectId)newValue);
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
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT:
				setProject((ProjectId)null);
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
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case AccesscontrolPackage.ORG_UNIT_PROPERTY__PROJECT:
				return project != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(boolean value) {
		String newValue = null;
		if (value) {
			newValue = "true";
		} else {
			newValue = "false";
		}
		setValue(newValue);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(int value) {
		setValue(new Integer(value).toString());
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(String[] value) {
		if (value.length == 0) {
			setValue("");
			return;
		}
		StringBuilder newValue = new StringBuilder();
		for (String s : value) {
			newValue.append(s);
			newValue.append(OrgUnitProperty.ARRAY_SEPARATOR);
		}
		String ret = newValue.toString();
		setValue(ret.substring(0, ret.length() - 2));
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(EObject[] value) {
		String[] newValue = new String[value.length];
		try {
			for (int i = 0; i < value.length; i++) {
				newValue[i] = ModelUtil.eObjectToString(value[i]);
			}
			setValue(newValue);
		} catch (SerializationException e) {
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean getBooleanProperty() {
		String value = getValue();
		if (value != null) {
			Boolean b = new Boolean(value);
			return b;
		}
		throw new IllegalStateException("Existing key without value!");
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getIntegerProperty() {
		String value = getValue();
		if (value != null) {
			Integer b = new Integer(value);
			return b;
		}
		throw new IllegalStateException("Existing key without value!");
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getStringArrayProperty() {
		String value = getValue();
		if (value != null) {
			if (value.equals("")) {
				return new String[0];
			}
			String[] split = value.split(OrgUnitProperty.ARRAY_SEPARATOR);
			return split;
		}
		throw new IllegalStateException("Existing key without value!");
	}

	/**
	 * {@inheritDoc}
	 */
	/**
	 * @see org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getEObjectListProperty(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getEObjectListProperty(List<T> result) {
		String[] value = getStringArrayProperty();
		List<Exception> causes = new ArrayList<Exception>();
		if (value != null && value.length > 0) {
			for (int i = 0; i < value.length; i++) {
				try {
					EObject eObject = ModelUtil.stringToEObject(value[i]);
					result.add((T) eObject);
				} catch (SerializationException e) {
					causes.add(e);
				} catch (ClassCastException e) {
					causes.add(e);
				}
			}
			if (!causes.isEmpty()) {
				setValue(result.toArray(new EObject[0]));
				for (Exception cause : causes) {
					ModelUtil.logWarning("Removed broken entries from property " + this.getName() + ".", cause);
				}
			}
		}
		return result;
	}
} // OrgUnitPropertyImpl
