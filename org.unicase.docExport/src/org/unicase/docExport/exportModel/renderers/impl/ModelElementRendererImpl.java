/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultAttributeRendererBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getRendererOptions <em>Renderer
 * Options</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getTemplate <em>Template</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getAttributeRendererMapping <em>
 * Attribute Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ModelElementRendererImpl extends EObjectImpl implements ModelElementRenderer {
	/**
	 * The cached value of the '{@link #getRendererOptions() <em>Renderer Options</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRendererOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<RendererOption> rendererOptions;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected Template template;

	/**
	 * The cached value of the '{@link #getAttributeRendererMapping() <em>Attribute Renderer Mapping</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributeRendererMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeRendererMapping> attributeRendererMapping;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelElementRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.MODEL_ELEMENT_RENDERER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RendererOption> getRendererOptions() {
		if (rendererOptions == null) {
			rendererOptions = new EObjectContainmentEList<RendererOption>(RendererOption.class, this,
				RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS);
		}
		return rendererOptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Template getTemplate() {
		if (template != null && template.eIsProxy()) {
			InternalEObject oldTemplate = (InternalEObject) template;
			template = (Template) eResolveProxy(oldTemplate);
			if (template != oldTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE, oldTemplate, template));
			}
		}
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Template basicGetTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTemplate(Template newTemplate) {
		Template oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE,
				oldTemplate, template));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AttributeRendererMapping> getAttributeRendererMapping() {
		if (attributeRendererMapping == null) {
			attributeRendererMapping = new EObjectContainmentEList<AttributeRendererMapping>(
				AttributeRendererMapping.class, this,
				RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING);
		}
		return attributeRendererMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return ((InternalEList<?>) getRendererOptions()).basicRemove(otherEnd, msgs);
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return ((InternalEList<?>) getAttributeRendererMapping()).basicRemove(otherEnd, msgs);
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return getRendererOptions();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			if (resolve)
				return getTemplate();
			return basicGetTemplate();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return getAttributeRendererMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			getRendererOptions().clear();
			getRendererOptions().addAll((Collection<? extends RendererOption>) newValue);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			setTemplate((Template) newValue);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			getAttributeRendererMapping().clear();
			getAttributeRendererMapping().addAll((Collection<? extends AttributeRendererMapping>) newValue);
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			getRendererOptions().clear();
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			setTemplate((Template) null);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			getAttributeRendererMapping().clear();
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
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return rendererOptions != null && !rendererOptions.isEmpty();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			return template != null;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return attributeRendererMapping != null && !attributeRendererMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	// begin custom code
	public final void render(ModelElement modelElement, UCompositeSection parent) {
		TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);

		/*
		 * A ModelElement should not be rendered twice with the default renderer, because a recursive call may appear,
		 * which will result in a non-terminating algorithm. If this is the first time, the ModelElement is rendred, add
		 * a reference, so that the ModelElement can be linked.
		 */
		if (!DocumentExport.hasAlreadyBeenRendered(modelElement)) {
			DocumentExport.addRenderedModelElement(modelElement);
			parent.add(new URef(modelElement.getModelElementId().getId()));
		} else {
			return;
		}

		if (getModelElementDepth(modelElement, 1) <= DocumentExport.getRecursionDepth()) {
			doRender(modelElement, parent);
		}
	}

	public static int getModelElementDepth(ModelElement modelElement, int depth) {
		EObject parent = modelElement.eContainer();
		if (parent == null || parent instanceof LeafSection || parent instanceof CompositeSection) {
			return depth;
		} else if (parent instanceof ModelElement) {
			return getModelElementDepth((ModelElement) parent, depth + 1);
		} else {
			return depth;
		}
	}

	protected abstract void doRender(ModelElement modelElement, UCompositeSection parent);

	public AttributeRenderer getAttributeRenderer(EStructuralFeature feature) {
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				return mapping.getAttributeRenderer();
			}
		}
		return null;
	}

	public AttributeRenderer getAttributeRendererNotNull(EStructuralFeature feature) {

		AttributeRenderer renderer = getAttributeRenderer(feature);
		if (renderer == null) {
			return DefaultAttributeRendererBuilder.build(feature, template);
		} else {
			return renderer;
		}
	}

	public void setAttributeRenderer(EStructuralFeature feature, AttributeRenderer renderer) {
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				mapping.setAttributeRenderer(renderer);
				return;
			}
		}

		AttributeRendererMapping mapping = RenderersFactory.eINSTANCE.createAttributeRendererMapping();
		mapping.setFeatureName(feature.getName());
		mapping.setAttributeRenderer(renderer);
		getAttributeRendererMapping().add(mapping);

	}

	public void removeAttributeRenderer(EStructuralFeature feature) {
		if (getAttributeRendererMapping().size() < 1) {
			return;
		}
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				getAttributeRendererMapping().remove(mapping);
			}
		}
	}
	// end custom code

} // ModelElementRendererImpl
