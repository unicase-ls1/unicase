/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.documentexport.documentTemplate.renderers.options.ListOption;
import org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage;
import org.unicase.documentexport.documentTemplate.renderers.options.ReferenceOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.impl.MultiReferenceAttributeOptionImpl#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.impl.MultiReferenceAttributeOptionImpl#getReferenceOption <em>Reference Option</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.impl.MultiReferenceAttributeOptionImpl#getListOption <em>List Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiReferenceAttributeOptionImpl extends ReferenceAttributeOptionImpl implements MultiReferenceAttributeOption {
	/**
	 * The cached value of the '{@link #getGlobalOption() <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected MultiReferenceAttributeOption globalOption;

	/**
	 * The cached value of the '{@link #getReferenceOption() <em>Reference Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceOption()
	 * @generated
	 * @ordered
	 */
	protected ReferenceOption referenceOption;

	/**
	 * The cached value of the '{@link #getListOption() <em>List Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListOption()
	 * @generated
	 * @ordered
	 */
	protected ListOption listOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MultiReferenceAttributeOptionImpl() {
		super();
		listOption = OptionsFactory.eINSTANCE.createListOption();
		referenceOption = OptionsFactory.eINSTANCE.createReferenceOption();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.MULTI_REFERENCE_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiReferenceAttributeOption getGlobalOption() {
		if (globalOption != null && globalOption.eIsProxy()) {
			InternalEObject oldGlobalOption = (InternalEObject)globalOption;
			globalOption = (MultiReferenceAttributeOption)eResolveProxy(oldGlobalOption);
			if (globalOption != oldGlobalOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
			}
		}
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiReferenceAttributeOption basicGetGlobalOption() {
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOption(MultiReferenceAttributeOption newGlobalOption) {
		MultiReferenceAttributeOption oldGlobalOption = globalOption;
		globalOption = newGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ReferenceOption getReferenceOption(Boolean ignoreGlobalOption) {
		if (!isOverwriteGlobalOption()  && globalOption != null && !ignoreGlobalOption) {
			return globalOption.getReferenceOption();
		} else {
			return referenceOption;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ReferenceOption getReferenceOption() {
		return getReferenceOption(false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferenceOption(ReferenceOption newReferenceOption, NotificationChain msgs) {
		ReferenceOption oldReferenceOption = referenceOption;
		referenceOption = newReferenceOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, oldReferenceOption, newReferenceOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceOption(ReferenceOption newReferenceOption) {
		if (newReferenceOption != referenceOption) {
			NotificationChain msgs = null;
			if (referenceOption != null)
				msgs = ((InternalEObject)referenceOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, null, msgs);
			if (newReferenceOption != null)
				msgs = ((InternalEObject)newReferenceOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, null, msgs);
			msgs = basicSetReferenceOption(newReferenceOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, newReferenceOption, newReferenceOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ListOption getListOption(Boolean ignoreGlobalOption) {
		if (!isOverwriteGlobalOption()  && globalOption != null && !ignoreGlobalOption) {
			return getGlobalOption().getListOption();
		} else {
			return listOption;
		}
	}
	
	/**
	 * @generated NOT
	 */
	public ListOption getListOption() {
		return getListOption(false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetListOption(ListOption newListOption, NotificationChain msgs) {
		ListOption oldListOption = listOption;
		listOption = newListOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION, oldListOption, newListOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListOption(ListOption newListOption) {
		if (newListOption != listOption) {
			NotificationChain msgs = null;
			if (listOption != null)
				msgs = ((InternalEObject)listOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION, null, msgs);
			if (newListOption != null)
				msgs = ((InternalEObject)newListOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION, null, msgs);
			msgs = basicSetListOption(newListOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION, newListOption, newListOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
				return basicSetReferenceOption(null, msgs);
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION:
				return basicSetListOption(null, msgs);
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
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				if (resolve) return getGlobalOption();
				return basicGetGlobalOption();
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
				return getReferenceOption();
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION:
				return getListOption();
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
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((MultiReferenceAttributeOption)newValue);
				return;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
				setReferenceOption((ReferenceOption)newValue);
				return;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION:
				setListOption((ListOption)newValue);
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
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((MultiReferenceAttributeOption)null);
				return;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
				setReferenceOption((ReferenceOption)null);
				return;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION:
				setListOption((ListOption)null);
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
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				return globalOption != null;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
				return referenceOption != null;
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION:
				return listOption != null;
		}
		return super.eIsSet(featureID);
	}

} //MultiReferenceAttributeOptionImpl
