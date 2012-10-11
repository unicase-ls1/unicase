/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Template</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.impl.TemplateImpl#getModelElementRendererMapping <em>Model Element Renderer Mapping</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.impl.TemplateImpl#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.impl.TemplateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.impl.TemplateImpl#isDefaultTemplate <em>Default Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends EObjectImpl implements Template {

	/**
	 * The cached value of the '{@link #getModelElementRendererMapping() <em>Model Element Renderer Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getModelElementRendererMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementRendererMapping> modelElementRendererMapping;

	/**
	 * The cached value of the '{@link #getLayoutOptions() <em>Layout Options</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLayoutOptions()
	 * @generated
	 * @ordered
	 */
	protected LayoutOptions layoutOptions;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isDefaultTemplate() <em>Default Template</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isDefaultTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultTemplate() <em>Default Template</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isDefaultTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultTemplate = DEFAULT_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TemplateImpl() {
		super();
		layoutOptions = OptionsFactory.eINSTANCE.createLayoutOptions();
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExportModelPackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementRendererMapping> getModelElementRendererMapping() {
		if (modelElementRendererMapping == null) {
			modelElementRendererMapping = new EObjectContainmentEList<ModelElementRendererMapping>(ModelElementRendererMapping.class, this, ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING);
		}
		return modelElementRendererMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutOptions getLayoutOptions() {
		return layoutOptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutOptions(LayoutOptions newLayoutOptions, NotificationChain msgs) {
		LayoutOptions oldLayoutOptions = layoutOptions;
		layoutOptions = newLayoutOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS, oldLayoutOptions, newLayoutOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutOptions(LayoutOptions newLayoutOptions) {
		if (newLayoutOptions != layoutOptions) {
			NotificationChain msgs = null;
			if (layoutOptions != null)
				msgs = ((InternalEObject)layoutOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS, null, msgs);
			if (newLayoutOptions != null)
				msgs = ((InternalEObject)newLayoutOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS, null, msgs);
			msgs = basicSetLayoutOptions(newLayoutOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS, newLayoutOptions, newLayoutOptions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportModelPackage.TEMPLATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultTemplate() {
		return defaultTemplate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTemplate(boolean newDefaultTemplate) {
		boolean oldDefaultTemplate = defaultTemplate;
		defaultTemplate = newDefaultTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportModelPackage.TEMPLATE__DEFAULT_TEMPLATE, oldDefaultTemplate, defaultTemplate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return ((InternalEList<?>)getModelElementRendererMapping()).basicRemove(otherEnd, msgs);
			case ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS:
				return basicSetLayoutOptions(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return getModelElementRendererMapping();
			case ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS:
				return getLayoutOptions();
			case ExportModelPackage.TEMPLATE__NAME:
				return getName();
			case ExportModelPackage.TEMPLATE__DEFAULT_TEMPLATE:
				return isDefaultTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				getModelElementRendererMapping().clear();
				getModelElementRendererMapping().addAll((Collection<? extends ModelElementRendererMapping>)newValue);
				return;
			case ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS:
				setLayoutOptions((LayoutOptions)newValue);
				return;
			case ExportModelPackage.TEMPLATE__NAME:
				setName((String)newValue);
				return;
			case ExportModelPackage.TEMPLATE__DEFAULT_TEMPLATE:
				setDefaultTemplate((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				getModelElementRendererMapping().clear();
				return;
			case ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS:
				setLayoutOptions((LayoutOptions)null);
				return;
			case ExportModelPackage.TEMPLATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExportModelPackage.TEMPLATE__DEFAULT_TEMPLATE:
				setDefaultTemplate(DEFAULT_TEMPLATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExportModelPackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return modelElementRendererMapping != null && !modelElementRendererMapping.isEmpty();
			case ExportModelPackage.TEMPLATE__LAYOUT_OPTIONS:
				return layoutOptions != null;
			case ExportModelPackage.TEMPLATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExportModelPackage.TEMPLATE__DEFAULT_TEMPLATE:
				return defaultTemplate != DEFAULT_TEMPLATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", defaultTemplate: ");
		result.append(defaultTemplate);
		result.append(')');
		return result.toString();
	}

	// begin custom code
	/**
	 * @see org.unicase.docExport.exportModel.Template#setModelElementRenderer(EClass, ModelElementRenderer)
	 */
	public void setModelElementRenderer(EClass eClass, ModelElementRenderer renderer) {
		for (ModelElementRendererMapping mapping : getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(ModelElementRendererRegistry.getStringOfEClass(eClass))) {
				mapping.setRenderer(renderer);
				return;
			}
		}

		ModelElementRendererMapping mapping = RenderersFactory.eINSTANCE.createModelElementRendererMapping();
		mapping.setEClassName(ModelElementRendererRegistry.getStringOfEClass(eClass));
		mapping.setRenderer(renderer);
		getModelElementRendererMapping().add(mapping);

	}

	/**
	 * @see org.unicase.docExport.exportModel.Template#getModelElementRenderer(EClass)
	 */
	public ModelElementRenderer getModelElementRenderer(EClass eClass) {
		for (ModelElementRendererMapping mapping : getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(ModelElementRendererRegistry.getStringOfEClass(eClass))) {
				return mapping.getRenderer();
			}
		}
		return null;
	}

	/**
	 * @see org.unicase.docExport.exportModel.Template#getModelElementRendererNotNull(EClass,
	 *      org.unicase.docExport.exportModel.Template)
	 */
	public ModelElementRenderer getModelElementRendererNotNull(EClass eClass, Template template) {
		for (ModelElementRendererMapping mapping : getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(ModelElementRendererRegistry.getStringOfEClass(eClass))) {
				return mapping.getRenderer();
			}
		}

		DefaultModelElementRenderer renderer = DefaultRenderersFactory.eINSTANCE.createDefaultModelElementRenderer();
		renderer.setTemplate(template);

		return renderer;
	}

	/**
	 * @see org.unicase.docExport.exportModel.Template#removeModelElementRenderer(EClass)
	 */
	public void removeModelElementRenderer(EClass modelElementEClass) {
		ModelElementRendererMapping mappingToRemove = null;
		for (ModelElementRendererMapping mapping : getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(ModelElementRendererRegistry.getStringOfEClass(modelElementEClass))) {
				mappingToRemove = mapping;
			}
		}

		if (mappingToRemove != null) {
			getModelElementRendererMapping().remove(mappingToRemove);
		}
	}
	// end custom code
} // TemplateImpl
