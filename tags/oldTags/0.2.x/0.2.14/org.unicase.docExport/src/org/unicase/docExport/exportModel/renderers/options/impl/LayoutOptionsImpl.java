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

import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getCoverText <em>Cover Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getCoverTextTextOption <em>Cover Text Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getDefaultTextOption <em>Default Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getSectionTextOption <em>Section Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideAnnotations <em>Hide Annotations</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideAttachments <em>Hide Attachments</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideIncomingDocumentReferences <em>Hide Incoming Document References</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getPageNumberingStyle <em>Page Numbering Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideModelElementImages <em>Hide Model Element Images</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getModelElementTextOption <em>Model Element Text Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutOptionsImpl extends RendererOptionImpl implements LayoutOptions {
	/**
	 * The default value of the '{@link #getCoverText() <em>Cover Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoverText()
	 * @generated
	 * @ordered
	 */
	protected static final String COVER_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoverText() <em>Cover Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoverText()
	 * @generated
	 * @ordered
	 */
	protected String coverText = COVER_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCoverTextTextOption() <em>Cover Text Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoverTextTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption coverTextTextOption;

	/**
	 * The cached value of the '{@link #getDefaultTextOption() <em>Default Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption defaultTextOption;

	/**
	 * The cached value of the '{@link #getSectionTextOption() <em>Section Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectionTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption sectionTextOption;

	/**
	 * The default value of the '{@link #isHideAnnotations() <em>Hide Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_ANNOTATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideAnnotations() <em>Hide Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean hideAnnotations = HIDE_ANNOTATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideAttachments() <em>Hide Attachments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideAttachments()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_ATTACHMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideAttachments() <em>Hide Attachments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideAttachments()
	 * @generated
	 * @ordered
	 */
	protected boolean hideAttachments = HIDE_ATTACHMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideIncomingDocumentReferences() <em>Hide Incoming Document References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideIncomingDocumentReferences() <em>Hide Incoming Document References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected boolean hideIncomingDocumentReferences = HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageNumberingStyle() <em>Page Numbering Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageNumberingStyle()
	 * @generated
	 * @ordered
	 */
	protected static final PageNumberingStyle PAGE_NUMBERING_STYLE_EDEFAULT = PageNumberingStyle.PAGE_ONLY;

	/**
	 * The cached value of the '{@link #getPageNumberingStyle() <em>Page Numbering Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageNumberingStyle()
	 * @generated
	 * @ordered
	 */
	protected PageNumberingStyle pageNumberingStyle = PAGE_NUMBERING_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideModelElementImages() <em>Hide Model Element Images</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideModelElementImages()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideModelElementImages() <em>Hide Model Element Images</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHideModelElementImages()
	 * @generated
	 * @ordered
	 */
	protected boolean hideModelElementImages = HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElementTextOption() <em>Model Element Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption modelElementTextOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LayoutOptionsImpl() {
		super();
		coverTextTextOption = OptionsFactory.eINSTANCE.createTextOption();
		defaultTextOption = OptionsFactory.eINSTANCE.createTextOption();
		sectionTextOption = OptionsFactory.eINSTANCE.createTextOption();
		modelElementTextOption = OptionsFactory.eINSTANCE.createTextOption();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.LAYOUT_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoverText() {
		return coverText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoverText(String newCoverText) {
		String oldCoverText = coverText;
		coverText = newCoverText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT, oldCoverText, coverText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getCoverTextTextOption() {
		return coverTextTextOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoverTextTextOption(TextOption newCoverTextTextOption, NotificationChain msgs) {
		TextOption oldCoverTextTextOption = coverTextTextOption;
		coverTextTextOption = newCoverTextTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION, oldCoverTextTextOption, newCoverTextTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoverTextTextOption(TextOption newCoverTextTextOption) {
		if (newCoverTextTextOption != coverTextTextOption) {
			NotificationChain msgs = null;
			if (coverTextTextOption != null)
				msgs = ((InternalEObject)coverTextTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION, null, msgs);
			if (newCoverTextTextOption != null)
				msgs = ((InternalEObject)newCoverTextTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION, null, msgs);
			msgs = basicSetCoverTextTextOption(newCoverTextTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION, newCoverTextTextOption, newCoverTextTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getDefaultTextOption() {
		return defaultTextOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultTextOption(TextOption newDefaultTextOption, NotificationChain msgs) {
		TextOption oldDefaultTextOption = defaultTextOption;
		defaultTextOption = newDefaultTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, oldDefaultTextOption, newDefaultTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTextOption(TextOption newDefaultTextOption) {
		if (newDefaultTextOption != defaultTextOption) {
			NotificationChain msgs = null;
			if (defaultTextOption != null)
				msgs = ((InternalEObject)defaultTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, null, msgs);
			if (newDefaultTextOption != null)
				msgs = ((InternalEObject)newDefaultTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, null, msgs);
			msgs = basicSetDefaultTextOption(newDefaultTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, newDefaultTextOption, newDefaultTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getSectionTextOption() {
		return sectionTextOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSectionTextOption(TextOption newSectionTextOption, NotificationChain msgs) {
		TextOption oldSectionTextOption = sectionTextOption;
		sectionTextOption = newSectionTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, oldSectionTextOption, newSectionTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionTextOption(TextOption newSectionTextOption) {
		if (newSectionTextOption != sectionTextOption) {
			NotificationChain msgs = null;
			if (sectionTextOption != null)
				msgs = ((InternalEObject)sectionTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, null, msgs);
			if (newSectionTextOption != null)
				msgs = ((InternalEObject)newSectionTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, null, msgs);
			msgs = basicSetSectionTextOption(newSectionTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, newSectionTextOption, newSectionTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideAnnotations() {
		return hideAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideAnnotations(boolean newHideAnnotations) {
		boolean oldHideAnnotations = hideAnnotations;
		hideAnnotations = newHideAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS, oldHideAnnotations, hideAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideAttachments() {
		return hideAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideAttachments(boolean newHideAttachments) {
		boolean oldHideAttachments = hideAttachments;
		hideAttachments = newHideAttachments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS, oldHideAttachments, hideAttachments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideIncomingDocumentReferences() {
		return hideIncomingDocumentReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideIncomingDocumentReferences(boolean newHideIncomingDocumentReferences) {
		boolean oldHideIncomingDocumentReferences = hideIncomingDocumentReferences;
		hideIncomingDocumentReferences = newHideIncomingDocumentReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES, oldHideIncomingDocumentReferences, hideIncomingDocumentReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageNumberingStyle getPageNumberingStyle() {
		return pageNumberingStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageNumberingStyle(PageNumberingStyle newPageNumberingStyle) {
		PageNumberingStyle oldPageNumberingStyle = pageNumberingStyle;
		pageNumberingStyle = newPageNumberingStyle == null ? PAGE_NUMBERING_STYLE_EDEFAULT : newPageNumberingStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE, oldPageNumberingStyle, pageNumberingStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideModelElementImages() {
		return hideModelElementImages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideModelElementImages(boolean newHideModelElementImages) {
		boolean oldHideModelElementImages = hideModelElementImages;
		hideModelElementImages = newHideModelElementImages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES, oldHideModelElementImages, hideModelElementImages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getModelElementTextOption() {
		return modelElementTextOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementTextOption(TextOption newModelElementTextOption, NotificationChain msgs) {
		TextOption oldModelElementTextOption = modelElementTextOption;
		modelElementTextOption = newModelElementTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, oldModelElementTextOption, newModelElementTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementTextOption(TextOption newModelElementTextOption) {
		if (newModelElementTextOption != modelElementTextOption) {
			NotificationChain msgs = null;
			if (modelElementTextOption != null)
				msgs = ((InternalEObject)modelElementTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, null, msgs);
			if (newModelElementTextOption != null)
				msgs = ((InternalEObject)newModelElementTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, null, msgs);
			msgs = basicSetModelElementTextOption(newModelElementTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, newModelElementTextOption, newModelElementTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION:
				return basicSetCoverTextTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return basicSetDefaultTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return basicSetSectionTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return basicSetModelElementTextOption(null, msgs);
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
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT:
				return getCoverText();
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION:
				return getCoverTextTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return getDefaultTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return getSectionTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				return isHideAnnotations() ? Boolean.TRUE : Boolean.FALSE;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				return isHideAttachments() ? Boolean.TRUE : Boolean.FALSE;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				return isHideIncomingDocumentReferences() ? Boolean.TRUE : Boolean.FALSE;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE:
				return getPageNumberingStyle();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				return isHideModelElementImages() ? Boolean.TRUE : Boolean.FALSE;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return getModelElementTextOption();
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
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT:
				setCoverText((String)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION:
				setCoverTextTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				setDefaultTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				setSectionTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				setHideAnnotations(((Boolean)newValue).booleanValue());
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				setHideAttachments(((Boolean)newValue).booleanValue());
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				setHideIncomingDocumentReferences(((Boolean)newValue).booleanValue());
				return;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE:
				setPageNumberingStyle((PageNumberingStyle)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				setHideModelElementImages(((Boolean)newValue).booleanValue());
				return;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				setModelElementTextOption((TextOption)newValue);
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
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT:
				setCoverText(COVER_TEXT_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION:
				setCoverTextTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				setDefaultTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				setSectionTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				setHideAnnotations(HIDE_ANNOTATIONS_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				setHideAttachments(HIDE_ATTACHMENTS_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				setHideIncomingDocumentReferences(HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE:
				setPageNumberingStyle(PAGE_NUMBERING_STYLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				setHideModelElementImages(HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				setModelElementTextOption((TextOption)null);
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
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT:
				return COVER_TEXT_EDEFAULT == null ? coverText != null : !COVER_TEXT_EDEFAULT.equals(coverText);
			case OptionsPackage.LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION:
				return coverTextTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return defaultTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return sectionTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				return hideAnnotations != HIDE_ANNOTATIONS_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				return hideAttachments != HIDE_ATTACHMENTS_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				return hideIncomingDocumentReferences != HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE:
				return pageNumberingStyle != PAGE_NUMBERING_STYLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				return hideModelElementImages != HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return modelElementTextOption != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (coverText: ");
		result.append(coverText);
		result.append(", hideAnnotations: ");
		result.append(hideAnnotations);
		result.append(", hideAttachments: ");
		result.append(hideAttachments);
		result.append(", hideIncomingDocumentReferences: ");
		result.append(hideIncomingDocumentReferences);
		result.append(", pageNumberingStyle: ");
		result.append(pageNumberingStyle);
		result.append(", hideModelElementImages: ");
		result.append(hideModelElementImages);
		result.append(')');
		return result.toString();
	}

} //LayoutOptionsImpl
