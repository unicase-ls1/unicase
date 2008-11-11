/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl#getAttributeOption <em>Attribute Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AttributeRendererImpl extends EObjectImpl implements AttributeRenderer {
	/**
	 * The cached value of the '{@link #getAttributeOption() <em>Attribute Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeOption()
	 * @generated
	 * @ordered
	 */
	protected AttributeOption attributeOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.ATTRIBUTE_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeOption getAttributeOption() {
		if (attributeOption != null && attributeOption.eIsProxy()) {
			InternalEObject oldAttributeOption = (InternalEObject)attributeOption;
			attributeOption = (AttributeOption)eResolveProxy(oldAttributeOption);
			if (attributeOption != oldAttributeOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, oldAttributeOption, attributeOption));
			}
		}
		return attributeOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeOption basicGetAttributeOption() {
		return attributeOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeOption(AttributeOption newAttributeOption) {
		AttributeOption oldAttributeOption = attributeOption;
		attributeOption = newAttributeOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION, oldAttributeOption, attributeOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
				if (resolve) return getAttributeOption();
				return basicGetAttributeOption();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
				setAttributeOption((AttributeOption)newValue);
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
			case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
				setAttributeOption((AttributeOption)null);
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
			case RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION:
				return attributeOption != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeRendererImpl
