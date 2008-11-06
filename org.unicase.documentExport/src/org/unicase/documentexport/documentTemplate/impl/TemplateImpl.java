/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.impl;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.documentexport.documentTemplate.DocumentTemplatePackage;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.ModelElementRenderer;
import org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping;
import org.unicase.documentexport.documentTemplate.renderers.options.AttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.LayoutOptions;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.impl.TemplateImpl#getModelElementRendererMapping <em>Model Element Renderer Mapping</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.impl.TemplateImpl#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.impl.TemplateImpl#getGlobalRendererOptions <em>Global Renderer Options</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.impl.TemplateImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends EObjectImpl implements Template {
	
	/**
	 * @generated NOT
	 */
	protected HashSet<ModelElementId> renderedModelElements;
	
	/**
	 * The cached value of the '{@link #getModelElementRendererMapping() <em>Model Element Renderer Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementRendererMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementRendererMapping> modelElementRendererMapping;

	/**
	 * The cached value of the '{@link #getLayoutOptions() <em>Layout Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOptions()
	 * @generated
	 * @ordered
	 */
	protected LayoutOptions layoutOptions;

	/**
	 * The cached value of the '{@link #getGlobalRendererOptions() <em>Global Renderer Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalRendererOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeOption> globalRendererOptions;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TemplateImpl() {
		super();
		layoutOptions = OptionsFactory.eINSTANCE.createLayoutOptions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocumentTemplatePackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementRendererMapping> getModelElementRendererMapping() {
		if (modelElementRendererMapping == null) {
			modelElementRendererMapping = new EObjectContainmentEList<ModelElementRendererMapping>(ModelElementRendererMapping.class, this, DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING);
		}
		return modelElementRendererMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutOptions getLayoutOptions() {
		return layoutOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutOptions(LayoutOptions newLayoutOptions, NotificationChain msgs) {
		LayoutOptions oldLayoutOptions = layoutOptions;
		layoutOptions = newLayoutOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS, oldLayoutOptions, newLayoutOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutOptions(LayoutOptions newLayoutOptions) {
		if (newLayoutOptions != layoutOptions) {
			NotificationChain msgs = null;
			if (layoutOptions != null)
				msgs = ((InternalEObject)layoutOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS, null, msgs);
			if (newLayoutOptions != null)
				msgs = ((InternalEObject)newLayoutOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS, null, msgs);
			msgs = basicSetLayoutOptions(newLayoutOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS, newLayoutOptions, newLayoutOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeOption> getGlobalRendererOptions() {
		if (globalRendererOptions == null) {
			globalRendererOptions = new EObjectContainmentEList<AttributeOption>(AttributeOption.class, this, DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS);
		}
		return globalRendererOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocumentTemplatePackage.TEMPLATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return ((InternalEList<?>)getModelElementRendererMapping()).basicRemove(otherEnd, msgs);
			case DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS:
				return basicSetLayoutOptions(null, msgs);
			case DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS:
				return ((InternalEList<?>)getGlobalRendererOptions()).basicRemove(otherEnd, msgs);
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
			case DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return getModelElementRendererMapping();
			case DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS:
				return getLayoutOptions();
			case DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS:
				return getGlobalRendererOptions();
			case DocumentTemplatePackage.TEMPLATE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				getModelElementRendererMapping().clear();
				getModelElementRendererMapping().addAll((Collection<? extends ModelElementRendererMapping>)newValue);
				return;
			case DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS:
				setLayoutOptions((LayoutOptions)newValue);
				return;
			case DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS:
				getGlobalRendererOptions().clear();
				getGlobalRendererOptions().addAll((Collection<? extends AttributeOption>)newValue);
				return;
			case DocumentTemplatePackage.TEMPLATE__NAME:
				setName((String)newValue);
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
			case DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				getModelElementRendererMapping().clear();
				return;
			case DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS:
				setLayoutOptions((LayoutOptions)null);
				return;
			case DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS:
				getGlobalRendererOptions().clear();
				return;
			case DocumentTemplatePackage.TEMPLATE__NAME:
				setName(NAME_EDEFAULT);
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
			case DocumentTemplatePackage.TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING:
				return modelElementRendererMapping != null && !modelElementRendererMapping.isEmpty();
			case DocumentTemplatePackage.TEMPLATE__LAYOUT_OPTIONS:
				return layoutOptions != null;
			case DocumentTemplatePackage.TEMPLATE__GLOBAL_RENDERER_OPTIONS:
				return globalRendererOptions != null && !globalRendererOptions.isEmpty();
			case DocumentTemplatePackage.TEMPLATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	//begin custom code
	public AttributeOption getGlobalAttributeRendererOption(
			Class<? extends AttributeOption> clazz) {
		for (AttributeOption option : globalRendererOptions) {
			if (option.getClass().equals(clazz))
				return option;
		}
		
		WorkspaceUtil.log(
				"Couldn't find a global AttributeOption for " + clazz.getSimpleName(), 
				new Exception(), 
				IStatus.ERROR
			);
		return null;
	}
	
	public void addRenderedModelElement(ModelElement me) {
		renderedModelElements.add(me.getModelElementId());
	}
	
	public boolean hasAlreadyBeenRendered(ModelElement me) {
		return renderedModelElements.contains(me);
	}
	
	public void initiateRenderedModelElements() {
		renderedModelElements = new HashSet<ModelElementId>();
	}
	
	public void setModelElementRenderer(String className,
			ModelElementRenderer renderer) {
		for (ModelElementRendererMapping mapping : getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(className)) {
				mapping.setRenderer(renderer);
				return;
			}
		}
		WorkspaceUtil.log(
				"couldn't find an entry in the modelElementRenderer mappings for the " +
				"ModelElement type " + className,
				new Exception(),
				IStatus.WARNING
			);
	}
	//end custom code
} //TemplateImpl
