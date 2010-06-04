/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Text Option</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#getFontFamily <em>Font Family
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#getFontSize <em>Font Size</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#isBold <em>Bold</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#isUnderline <em>Underline</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#getFontColor <em>Font Color</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#getTextAlign <em>Text Align</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl#isItalics <em>Italics</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TextOptionImpl extends RendererOptionImpl implements TextOption {
	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final FontFamily FONT_FAMILY_EDEFAULT = FontFamily.SANS_SERIF;

	/**
	 * The cached value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected FontFamily fontFamily = FONT_FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_SIZE_EDEFAULT = 12;

	/**
	 * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected int fontSize = FONT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBold() <em>Bold</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOLD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBold() <em>Bold</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected boolean bold = BOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnderline() <em>Underline</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isUnderline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNDERLINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnderline() <em>Underline</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isUnderline()
	 * @generated
	 * @ordered
	 */
	protected boolean underline = UNDERLINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFontColor() <em>Font Color</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected UColor fontColor;

	/**
	 * The default value of the '{@link #getTextAlign() <em>Text Align</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTextAlign()
	 * @generated
	 * @ordered
	 */
	protected static final TextAlign TEXT_ALIGN_EDEFAULT = TextAlign.START;

	/**
	 * The cached value of the '{@link #getTextAlign() <em>Text Align</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTextAlign()
	 * @generated
	 * @ordered
	 */
	protected TextAlign textAlign = TEXT_ALIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #isItalics() <em>Italics</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isItalics()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ITALICS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isItalics() <em>Italics</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isItalics()
	 * @generated
	 * @ordered
	 */
	protected boolean italics = ITALICS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TextOptionImpl() {
		super();
		fontColor = OptionsFactory.eINSTANCE.createUColor();
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.TEXT_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FontFamily getFontFamily() {
		return fontFamily;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFontFamily(FontFamily newFontFamily) {
		FontFamily oldFontFamily = fontFamily;
		fontFamily = newFontFamily == null ? FONT_FAMILY_EDEFAULT : newFontFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__FONT_FAMILY,
				oldFontFamily, fontFamily));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFontSize(int newFontSize) {
		int oldFontSize = fontSize;
		fontSize = newFontSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__FONT_SIZE, oldFontSize,
				fontSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT there is a strange null pointer exception... so i make sure, it cant be null here
	 */
	public UColor getFontColor() {
		if (fontColor == null) {
			fontColor = OptionsFactory.eINSTANCE.createUColor();
		}
		return fontColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetFontColor(UColor newFontColor, NotificationChain msgs) {
		UColor oldFontColor = fontColor;
		fontColor = newFontColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OptionsPackage.TEXT_OPTION__FONT_COLOR, oldFontColor, newFontColor);
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
	public void setFontColor(UColor newFontColor) {
		if (newFontColor != fontColor) {
			NotificationChain msgs = null;
			if (fontColor != null)
				msgs = ((InternalEObject) fontColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OptionsPackage.TEXT_OPTION__FONT_COLOR, null, msgs);
			if (newFontColor != null)
				msgs = ((InternalEObject) newFontColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OptionsPackage.TEXT_OPTION__FONT_COLOR, null, msgs);
			msgs = basicSetFontColor(newFontColor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__FONT_COLOR, newFontColor,
				newFontColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TextAlign getTextAlign() {
		return textAlign;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTextAlign(TextAlign newTextAlign) {
		TextAlign oldTextAlign = textAlign;
		textAlign = newTextAlign == null ? TEXT_ALIGN_EDEFAULT : newTextAlign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__TEXT_ALIGN, oldTextAlign,
				textAlign));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isItalics() {
		return italics;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setItalics(boolean newItalics) {
		boolean oldItalics = italics;
		italics = newItalics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__ITALICS, oldItalics,
				italics));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OptionsPackage.TEXT_OPTION__FONT_COLOR:
			return basicSetFontColor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isBold() {
		return bold;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBold(boolean newBold) {
		boolean oldBold = bold;
		bold = newBold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__BOLD, oldBold, bold));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isUnderline() {
		return underline;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUnderline(boolean newUnderline) {
		boolean oldUnderline = underline;
		underline = newUnderline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.TEXT_OPTION__UNDERLINE, oldUnderline,
				underline));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OptionsPackage.TEXT_OPTION__FONT_FAMILY:
			return getFontFamily();
		case OptionsPackage.TEXT_OPTION__FONT_SIZE:
			return getFontSize();
		case OptionsPackage.TEXT_OPTION__BOLD:
			return isBold();
		case OptionsPackage.TEXT_OPTION__UNDERLINE:
			return isUnderline();
		case OptionsPackage.TEXT_OPTION__FONT_COLOR:
			return getFontColor();
		case OptionsPackage.TEXT_OPTION__TEXT_ALIGN:
			return getTextAlign();
		case OptionsPackage.TEXT_OPTION__ITALICS:
			return isItalics();
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
		case OptionsPackage.TEXT_OPTION__FONT_FAMILY:
			setFontFamily((FontFamily) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__FONT_SIZE:
			setFontSize((Integer) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__BOLD:
			setBold((Boolean) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__UNDERLINE:
			setUnderline((Boolean) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__FONT_COLOR:
			setFontColor((UColor) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__TEXT_ALIGN:
			setTextAlign((TextAlign) newValue);
			return;
		case OptionsPackage.TEXT_OPTION__ITALICS:
			setItalics((Boolean) newValue);
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
		case OptionsPackage.TEXT_OPTION__FONT_FAMILY:
			setFontFamily(FONT_FAMILY_EDEFAULT);
			return;
		case OptionsPackage.TEXT_OPTION__FONT_SIZE:
			setFontSize(FONT_SIZE_EDEFAULT);
			return;
		case OptionsPackage.TEXT_OPTION__BOLD:
			setBold(BOLD_EDEFAULT);
			return;
		case OptionsPackage.TEXT_OPTION__UNDERLINE:
			setUnderline(UNDERLINE_EDEFAULT);
			return;
		case OptionsPackage.TEXT_OPTION__FONT_COLOR:
			setFontColor((UColor) null);
			return;
		case OptionsPackage.TEXT_OPTION__TEXT_ALIGN:
			setTextAlign(TEXT_ALIGN_EDEFAULT);
			return;
		case OptionsPackage.TEXT_OPTION__ITALICS:
			setItalics(ITALICS_EDEFAULT);
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
		case OptionsPackage.TEXT_OPTION__FONT_FAMILY:
			return fontFamily != FONT_FAMILY_EDEFAULT;
		case OptionsPackage.TEXT_OPTION__FONT_SIZE:
			return fontSize != FONT_SIZE_EDEFAULT;
		case OptionsPackage.TEXT_OPTION__BOLD:
			return bold != BOLD_EDEFAULT;
		case OptionsPackage.TEXT_OPTION__UNDERLINE:
			return underline != UNDERLINE_EDEFAULT;
		case OptionsPackage.TEXT_OPTION__FONT_COLOR:
			return fontColor != null;
		case OptionsPackage.TEXT_OPTION__TEXT_ALIGN:
			return textAlign != TEXT_ALIGN_EDEFAULT;
		case OptionsPackage.TEXT_OPTION__ITALICS:
			return italics != ITALICS_EDEFAULT;
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
		result.append(" (fontFamily: ");
		result.append(fontFamily);
		result.append(", fontSize: ");
		result.append(fontSize);
		result.append(", bold: ");
		result.append(bold);
		result.append(", underline: ");
		result.append(underline);
		result.append(", textAlign: ");
		result.append(textAlign);
		result.append(", italics: ");
		result.append(italics);
		result.append(')');
		return result.toString();
	}

} // TextOptionImpl
