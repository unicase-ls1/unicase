/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Renderer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl#getAttributeOption <em>Attribute
 * Option</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AttributeRendererImpl extends EObjectImpl implements AttributeRenderer {
	/**
	 * The cached value of the '{@link #getAttributeOption() <em>Attribute Option</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributeOption()
	 * @generated
	 * @ordered
	 */
	protected AttributeOption attributeOption;
	private final AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.ATTRIBUTE_RENDERER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeOption getAttributeOption() {
		return attributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttributeOption(AttributeOption newAttributeOption, NotificationChain msgs) {
		AttributeOption oldAttributeOption = attributeOption;
		attributeOption = newAttributeOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, oldAttributeOption, newAttributeOption);
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
	public void setAttributeOption(AttributeOption newAttributeOption) {
		if (newAttributeOption != attributeOption) {
			NotificationChain msgs = null;
			if (attributeOption != null)
				msgs = ((InternalEObject) attributeOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, null, msgs);
			if (newAttributeOption != null)
				msgs = ((InternalEObject) newAttributeOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, null, msgs);
			msgs = basicSetAttributeOption(newAttributeOption, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, newAttributeOption, newAttributeOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
			return basicSetAttributeOption(null, msgs);
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
		case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
			return getAttributeOption();
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
		case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
			setAttributeOption((AttributeOption) newValue);
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
		case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
			setAttributeOption((AttributeOption) null);
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
		case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
			return attributeOption != null;
		}
		return super.eIsSet(featureID);
	}

	// begin custom code
	/**
	 * Hide the structural lines of the default ModelElementRenderer.
	 */
	public boolean hideStructuralLines() {
		return false;
	}

	protected String getText(EObject eObject) {
		return adapterFactoryItemDelegator.getText(eObject);
	}// end custom code
} // AttributeRendererImpl
