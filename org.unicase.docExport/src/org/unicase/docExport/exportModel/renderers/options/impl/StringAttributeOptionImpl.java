/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl#getTextOption <em>Text Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringAttributeOptionImpl extends AttributeOptionImpl implements StringAttributeOption {
	/**
	 * The cached value of the '{@link #getGlobalOption() <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected StringAttributeOption globalOption;

	/**
	 * The cached value of the '{@link #getTextOption() <em>Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption textOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected StringAttributeOptionImpl() {
		super();
		textOption = OptionsFactory.eINSTANCE.createTextOption();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.STRING_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAttributeOption getGlobalOption() {
		if (globalOption != null && globalOption.eIsProxy()) {
			InternalEObject oldGlobalOption = (InternalEObject)globalOption;
			globalOption = (StringAttributeOption)eResolveProxy(oldGlobalOption);
			if (globalOption != oldGlobalOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
			}
		}
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAttributeOption basicGetGlobalOption() {
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOption(StringAttributeOption newGlobalOption) {
		StringAttributeOption oldGlobalOption = globalOption;
		globalOption = newGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param ignoreGlobalOption if true, always returns the TextOption of this object
	 * @return the TextOption which decoreates the text of this attribute
	 * <!-- end-user-doc -->s
	 * @generated NOT
	 */
	public TextOption getTextOption(Boolean ignoreGlobalOption) {
		if (!isOverwriteGlobalOption()  && globalOption != null && !ignoreGlobalOption) {
			return globalOption.getTextOption();
		} else {
			return textOption;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * @return the TextOption the object. This could be the globalOption if the overwrite flag 
	 * hasn't been set
	 * <!-- end-user-doc -->s
	 * @generated NOT
	 */
	public TextOption getTextOption() {
		return getTextOption(false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextOption(TextOption newTextOption, NotificationChain msgs) {
		TextOption oldTextOption = textOption;
		textOption = newTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION, oldTextOption, newTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextOption(TextOption newTextOption) {
		if (newTextOption != textOption) {
			NotificationChain msgs = null;
			if (textOption != null)
				msgs = ((InternalEObject)textOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION, null, msgs);
			if (newTextOption != null)
				msgs = ((InternalEObject)newTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION, null, msgs);
			msgs = basicSetTextOption(newTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION, newTextOption, newTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION:
				return basicSetTextOption(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				if (resolve) return getGlobalOption();
				return basicGetGlobalOption();
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION:
				return getTextOption();
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
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((StringAttributeOption)newValue);
				return;
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION:
				setTextOption((TextOption)newValue);
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
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((StringAttributeOption)null);
				return;
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION:
				setTextOption((TextOption)null);
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
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				return globalOption != null;
			case OptionsPackage.STRING_ATTRIBUTE_OPTION__TEXT_OPTION:
				return textOption != null;
		}
		return super.eIsSet(featureID);
	}

} //StringAttributeOptionImpl
