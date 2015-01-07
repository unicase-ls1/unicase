/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Section Option</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl#getSectionNumberingStyle <em>
 * Section Numbering Style</em>}</li>
 * <li>
 * {@link org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl#isLeaveOutPreviousSectionNumbering
 * <em>Leave Out Previous Section Numbering</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SectionOptionImpl extends RendererOptionImpl implements SectionOption {
	/**
	 * The default value of the '{@link #getSectionNumberingStyle() <em>Section Numbering Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSectionNumberingStyle()
	 * @generated
	 * @ordered
	 */
	protected static final SectionNumberingStyle SECTION_NUMBERING_STYLE_EDEFAULT = SectionNumberingStyle.NUMERICAL;

	/**
	 * The cached value of the '{@link #getSectionNumberingStyle() <em>Section Numbering Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSectionNumberingStyle()
	 * @generated
	 * @ordered
	 */
	protected SectionNumberingStyle sectionNumberingStyle = SECTION_NUMBERING_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLeaveOutPreviousSectionNumbering()
	 * <em>Leave Out Previous Section Numbering</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLeaveOutPreviousSectionNumbering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEAVE_OUT_PREVIOUS_SECTION_NUMBERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLeaveOutPreviousSectionNumbering()
	 * <em>Leave Out Previous Section Numbering</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLeaveOutPreviousSectionNumbering()
	 * @generated
	 * @ordered
	 */
	protected boolean leaveOutPreviousSectionNumbering = LEAVE_OUT_PREVIOUS_SECTION_NUMBERING_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SectionOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.SECTION_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SectionNumberingStyle getSectionNumberingStyle() {
		return sectionNumberingStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSectionNumberingStyle(SectionNumberingStyle newSectionNumberingStyle) {
		SectionNumberingStyle oldSectionNumberingStyle = sectionNumberingStyle;
		sectionNumberingStyle = newSectionNumberingStyle == null ? SECTION_NUMBERING_STYLE_EDEFAULT
			: newSectionNumberingStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OptionsPackage.SECTION_OPTION__SECTION_NUMBERING_STYLE, oldSectionNumberingStyle, sectionNumberingStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isLeaveOutPreviousSectionNumbering() {
		return leaveOutPreviousSectionNumbering;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLeaveOutPreviousSectionNumbering(boolean newLeaveOutPreviousSectionNumbering) {
		boolean oldLeaveOutPreviousSectionNumbering = leaveOutPreviousSectionNumbering;
		leaveOutPreviousSectionNumbering = newLeaveOutPreviousSectionNumbering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OptionsPackage.SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING,
				oldLeaveOutPreviousSectionNumbering, leaveOutPreviousSectionNumbering));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OptionsPackage.SECTION_OPTION__SECTION_NUMBERING_STYLE:
			return getSectionNumberingStyle();
		case OptionsPackage.SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING:
			return isLeaveOutPreviousSectionNumbering();
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
		case OptionsPackage.SECTION_OPTION__SECTION_NUMBERING_STYLE:
			setSectionNumberingStyle((SectionNumberingStyle) newValue);
			return;
		case OptionsPackage.SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING:
			setLeaveOutPreviousSectionNumbering((Boolean) newValue);
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
		case OptionsPackage.SECTION_OPTION__SECTION_NUMBERING_STYLE:
			setSectionNumberingStyle(SECTION_NUMBERING_STYLE_EDEFAULT);
			return;
		case OptionsPackage.SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING:
			setLeaveOutPreviousSectionNumbering(LEAVE_OUT_PREVIOUS_SECTION_NUMBERING_EDEFAULT);
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
		case OptionsPackage.SECTION_OPTION__SECTION_NUMBERING_STYLE:
			return sectionNumberingStyle != SECTION_NUMBERING_STYLE_EDEFAULT;
		case OptionsPackage.SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING:
			return leaveOutPreviousSectionNumbering != LEAVE_OUT_PREVIOUS_SECTION_NUMBERING_EDEFAULT;
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
		result.append(" (sectionNumberingStyle: ");
		result.append(sectionNumberingStyle);
		result.append(", leaveOutPreviousSectionNumbering: ");
		result.append(leaveOutPreviousSectionNumbering);
		result.append(')');
		return result.toString();
	}

} // SectionOptionImpl
