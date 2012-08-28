/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;

/**
 * <!-- begin-user-doc --> Maps an AttributeRenderer to a feature of a ModelElement. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl#getAttributeRenderer <em>
 * Attribute Renderer</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl#getFeatureName <em>Feature
 * Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AttributeRendererMappingImpl extends EObjectImpl implements AttributeRendererMapping {
	/**
	 * The cached value of the '{@link #getAttributeRenderer() <em>Attribute Renderer</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributeRenderer()
	 * @generated
	 * @ordered
	 */
	protected AttributeRenderer attributeRenderer;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeRendererMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.ATTRIBUTE_RENDERER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeRenderer getAttributeRenderer() {
		return attributeRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttributeRenderer(AttributeRenderer newAttributeRenderer, NotificationChain msgs) {
		AttributeRenderer oldAttributeRenderer = attributeRenderer;
		attributeRenderer = newAttributeRenderer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER, oldAttributeRenderer,
				newAttributeRenderer);
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
	public void setAttributeRenderer(AttributeRenderer newAttributeRenderer) {
		if (newAttributeRenderer != attributeRenderer) {
			NotificationChain msgs = null;
			if (attributeRenderer != null)
				msgs = ((InternalEObject) attributeRenderer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER, null, msgs);
			if (newAttributeRenderer != null)
				msgs = ((InternalEObject) newAttributeRenderer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER, null, msgs);
			msgs = basicSetAttributeRenderer(newAttributeRenderer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER, newAttributeRenderer,
				newAttributeRenderer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER:
			return basicSetAttributeRenderer(null, msgs);
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
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER:
			return getAttributeRenderer();
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME:
			return getFeatureName();
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
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER:
			setAttributeRenderer((AttributeRenderer) newValue);
			return;
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME:
			setFeatureName((String) newValue);
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
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER:
			setAttributeRenderer((AttributeRenderer) null);
			return;
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME:
			setFeatureName(FEATURE_NAME_EDEFAULT);
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
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER:
			return attributeRenderer != null;
		case RenderersPackage.ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME:
			return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
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
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(')');
		return result.toString();
	}

} // AttributeRendererMappingImpl
