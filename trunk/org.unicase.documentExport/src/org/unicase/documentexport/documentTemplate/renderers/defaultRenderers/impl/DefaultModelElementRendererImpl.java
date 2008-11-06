/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.impl;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.documentexport.builders.DefaultAttributeRendererBuilder;
import org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer;
import org.unicase.documentexport.documentTemplate.renderers.AttributeRendererMapping;
import org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.documentexport.documentTemplate.renderers.impl.ModelElementRendererImpl;
import org.unicase.documentexport.documentTemplate.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.model.ModelElement;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Model Element Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.impl.DefaultModelElementRendererImpl#getAttributeRendererMapping <em>Attribute Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultModelElementRendererImpl extends ModelElementRendererImpl implements DefaultModelElementRenderer {
	/**
	 * The cached value of the '{@link #getAttributeRendererMapping() <em>Attribute Renderer Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeRendererMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeRendererMapping> attributeRendererMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultModelElementRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_MODEL_ELEMENT_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeRendererMapping> getAttributeRendererMapping() {
		if (attributeRendererMapping == null) {
			attributeRendererMapping = new EObjectContainmentEList<AttributeRendererMapping>(AttributeRendererMapping.class, this, DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING);
		}
		return attributeRendererMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
				return ((InternalEList<?>)getAttributeRendererMapping()).basicRemove(otherEnd, msgs);
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
			case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
				return getAttributeRendererMapping();
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
			case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
				getAttributeRendererMapping().clear();
				getAttributeRendererMapping().addAll((Collection<? extends AttributeRendererMapping>)newValue);
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
			case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
				getAttributeRendererMapping().clear();
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
			case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
				return attributeRendererMapping != null && !attributeRendererMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	//begin custom code
	/**
	 * Renders a ModelElement into the UCompositeSection parent.
	 */
	public void render(ModelElement modelElement, UCompositeSection parent) {
		UCompositeSection modelElementContainer;
//		if (parent instanceof URootCompositeSection) {
//			UParagraph par = new UParagraph(
//					modelElement.getName(), 
//					template.getLayoutOptions().getSectionTextOption()
//				);
//			modelElementContainer = new UCompositeSection();
//			modelElementContainer.add(par);
//			parent.add(modelElementContainer);
//		} else {
			USection section = new USection(
					modelElement.getName(), 
					getTemplate().getLayoutOptions().getSectionTextOption()
				);
			parent.add(section);
			modelElementContainer = section;
//		}
			
		
		Vector<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(modelElement);
		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			EStructuralFeature feature = (EStructuralFeature)propertyDescriptor.getFeature(modelElement);
			
			AttributeRenderer renderer = getAttributeRenderer(feature);
			
			LayoutOptions layoutOptions = getTemplate().getLayoutOptions();
			if ((feature.getName() == "annotations" && layoutOptions.isHideAnnotations())
				|| (feature.getName() == "incomingDocumentReferences" && layoutOptions.isHideIncomingDocumentReferences())
				|| (feature.getName() == "attachments" && layoutOptions.isHideAttachments())) {
				// do nothing!  don't render these properties
			} else {
				renderer.render(
						feature, 
						modelElement, 
						modelElementContainer,  
						getTemplate()
					);
			}	
		}
	}

	
	private AttributeRenderer getAttributeRenderer(
			EStructuralFeature feature) {
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName()))
				return mapping.getAttributeRenderer();
		}
		
		WorkspaceUtil.log(
				"no attribute renderer for the attribute " + feature.getName() + ". A new default renderer has been created.",
				new Exception(),
				IStatus.WARNING);
		return DefaultAttributeRendererBuilder.build(feature, template);
	}

	/**
	 * Returns a Vector of the propertyDecriptors of a modelElement.
	 * Only editable properties are in this Vector.
	 */
	private Vector<IItemPropertyDescriptor> getPropertyDescriptors(ModelElement modelElement) {
		Vector<IItemPropertyDescriptor> ret = new Vector<IItemPropertyDescriptor>();
		
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
				)
		);

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
				.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			ret.addAll(propertyDescriptors);
		}
		
		return ret;
	}
	//end custom code

} //DefaultModelElementRendererImpl
