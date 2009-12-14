/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Attribute Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl#getOldValue <em>Old Value
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl#getNewValue <em>New Value
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AttributeOperationImpl extends FeatureOperationImpl implements AttributeOperation {
	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object OLD_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected Object oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object NEW_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected Object newValue = NEW_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.ATTRIBUTE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOldValue(Object newOldValue) {
		Object oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.ATTRIBUTE_OPERATION__OLD_VALUE,
				oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewValue(Object newNewValue) {
		Object oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.ATTRIBUTE_OPERATION__NEW_VALUE,
				oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.ATTRIBUTE_OPERATION__OLD_VALUE:
			return getOldValue();
		case OperationsPackage.ATTRIBUTE_OPERATION__NEW_VALUE:
			return getNewValue();
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
		case OperationsPackage.ATTRIBUTE_OPERATION__OLD_VALUE:
			setOldValue(newValue);
			return;
		case OperationsPackage.ATTRIBUTE_OPERATION__NEW_VALUE:
			setNewValue(newValue);
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
		case OperationsPackage.ATTRIBUTE_OPERATION__OLD_VALUE:
			setOldValue(OLD_VALUE_EDEFAULT);
			return;
		case OperationsPackage.ATTRIBUTE_OPERATION__NEW_VALUE:
			setNewValue(NEW_VALUE_EDEFAULT);
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
		case OperationsPackage.ATTRIBUTE_OPERATION__OLD_VALUE:
			return OLD_VALUE_EDEFAULT == null ? oldValue != null : !OLD_VALUE_EDEFAULT.equals(oldValue);
		case OperationsPackage.ATTRIBUTE_OPERATION__NEW_VALUE:
			return NEW_VALUE_EDEFAULT == null ? newValue != null : !NEW_VALUE_EDEFAULT.equals(newValue);
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
		result.append(" (oldValue: ");
		result.append(oldValue);
		result.append(", newValue: ");
		result.append(newValue);
		result.append(')');
		return result.toString();
	}

	public void apply(Project project) {
		ModelElement modelElement = project.getModelElement(this.getModelElementId());
		if (modelElement == null) {
			// silently fail
			return;
		}
		EAttribute attribute;
		try {
			attribute = (EAttribute) this.getFeature(modelElement);
			modelElement.eSet(attribute, this.getNewValue());
		} catch (UnkownFeatureException e) {
			// fail silently
			return;
		}
	}

	@Override
	public AbstractOperation reverse() {
		AttributeOperation attributeOperation = OperationsFactory.eINSTANCE.createAttributeOperation();
		super.reverse(attributeOperation);
		// swap old and new value
		attributeOperation.setNewValue(getOldValue());
		attributeOperation.setOldValue(getNewValue());
		return attributeOperation;
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		if (getOldValue() == null) {
			stringBuilder.append("Set ");
			stringBuilder.append(getFeatureName());
			stringBuilder.append(" to ");
			stringBuilder.append("\"");
			stringBuilder.append(getNewValue());
			stringBuilder.append("\"");
		} else {
			stringBuilder.append("Changed ");
			stringBuilder.append(getFeatureName());
			stringBuilder.append(" from ");
			stringBuilder.append("\"");
			stringBuilder.append(getOldValue());
			stringBuilder.append("\"");
			stringBuilder.append(" to ");
			stringBuilder.append("\"");
			stringBuilder.append(getNewValue());
			stringBuilder.append("\"");
		}
		// stringBuilder.append(".");
		String name = stringBuilder.toString();
		return name;
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Set ");
		stringBuilder.append(getFeatureName());
		stringBuilder.append(" attribute");
		String name = stringBuilder.toString();
		return name;
	}

} // AttributeOperationImpl
