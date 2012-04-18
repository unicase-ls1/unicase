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
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;

/**
 * <!-- begin-user-doc --> Maps an ModelElementRenderer to a ModelElement type. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl#getRenderer <em>Renderer
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl#getEClassName <em>EClass
 * Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelElementRendererMappingImpl extends EObjectImpl implements ModelElementRendererMapping {
	/**
	 * The cached value of the '{@link #getRenderer() <em>Renderer</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRenderer()
	 * @generated
	 * @ordered
	 */
	protected ModelElementRenderer renderer;

	/**
	 * The default value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String ECLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected String eClassName = ECLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelElementRendererMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.MODEL_ELEMENT_RENDERER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementRenderer getRenderer() {
		return renderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRenderer(ModelElementRenderer newRenderer, NotificationChain msgs) {
		ModelElementRenderer oldRenderer = renderer;
		renderer = newRenderer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER, oldRenderer, newRenderer);
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
	public void setRenderer(ModelElementRenderer newRenderer) {
		if (newRenderer != renderer) {
			NotificationChain msgs = null;
			if (renderer != null)
				msgs = ((InternalEObject) renderer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER, null, msgs);
			if (newRenderer != null)
				msgs = ((InternalEObject) newRenderer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER, null, msgs);
			msgs = basicSetRenderer(newRenderer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER, newRenderer, newRenderer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEClassName() {
		return eClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEClassName(String newEClassName) {
		String oldEClassName = eClassName;
		eClassName = newEClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME, oldEClassName, eClassName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER:
			return basicSetRenderer(null, msgs);
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER:
			return getRenderer();
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME:
			return getEClassName();
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER:
			setRenderer((ModelElementRenderer) newValue);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME:
			setEClassName((String) newValue);
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER:
			setRenderer((ModelElementRenderer) null);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME:
			setEClassName(ECLASS_NAME_EDEFAULT);
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__RENDERER:
			return renderer != null;
		case RenderersPackage.MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME:
			return ECLASS_NAME_EDEFAULT == null ? eClassName != null : !ECLASS_NAME_EDEFAULT.equals(eClassName);
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
		result.append(" (eClassName: ");
		result.append(eClassName);
		result.append(')');
		return result.toString();
	}

} // ModelElementRendererMappingImpl
