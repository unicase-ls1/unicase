/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl#getGlobalOption <em>Global Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleReferenceAttributeOptionImpl extends ReferenceAttributeOptionImpl implements SingleReferenceAttributeOption {
	/**
	 * The cached value of the '{@link #getGlobalOption() <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected SingleReferenceAttributeOption globalOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SingleReferenceAttributeOptionImpl() {
		super();
		referenceOption = OptionsFactory.eINSTANCE.createReferenceOption();
	}

	/**
	 * <!-- begin-user-doc -->
	 * .
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleReferenceAttributeOption getGlobalOption() {
		if (globalOption != null && globalOption.eIsProxy()) {
			InternalEObject oldGlobalOption = (InternalEObject)globalOption;
			globalOption = (SingleReferenceAttributeOption)eResolveProxy(oldGlobalOption);
			if (globalOption != oldGlobalOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
			}
		}
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleReferenceAttributeOption basicGetGlobalOption() {
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOption(SingleReferenceAttributeOption newGlobalOption) {
		SingleReferenceAttributeOption oldGlobalOption = globalOption;
		globalOption = newGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param ignoreGlobalOption if true, always returns the ReferenceOption of this object
	 * @return the ReferenceOption which decorates the text of this attribute
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
	 * .
	 * @return the ReferenceOption the object. This could be the globalOption if the overwrite flag 
	 * hasn't been set
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ReferenceOption getReferenceOption() {
		return getReferenceOption(false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * .
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				if (resolve) return getGlobalOption();
				return basicGetGlobalOption();
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
			case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((SingleReferenceAttributeOption)newValue);
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
			case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((SingleReferenceAttributeOption)null);
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
			case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				return globalOption != null;
		}
		return super.eIsSet(featureID);
	}

} //SingleReferenceAttributeOptionImpl
