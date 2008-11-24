/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.docExport.exportModel.builders.DefaultAttributeRendererBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UEntry;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.model.ModelElement;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Model Element Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultModelElementRendererImpl extends ModelElementRendererImpl implements DefaultModelElementRenderer {
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

	//begin custom code
	/**
	 * Renders a ModelElement into the UCompositeSection parent.
	 */
	public void render(ModelElement modelElement, UCompositeSection parent) {
		UCompositeSection modelElementContainer;

		UParagraph titleParagraph = new UParagraph("      " + modelElement.getName());

		Image image = new TransactionalAdapterFactoryLabelProvider(
				WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(),
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
					)
			).getImage(modelElement);
		
		
		titleParagraph.add(new UTextPart(
				"    [" + modelElement.eClass().getName() + "]",
				getTemplate().getLayoutOptions().getDefaultTextOption()
		));
		
		UImage uImage = new UImage(image);
		if (parent instanceof USection) {
			USection uSection = (USection) parent;
			float scale = (float) (getTemplate().getLayoutOptions().getModelElementTextOption().getFontSize() / 14.0);
			int indentionStep = (int)(scale * 12);
			uImage.setIndentionLeft(indentionStep * (uSection.getDepth() + 1));
		}
		
		if (!getTemplate().getLayoutOptions().isHideModelElementImages()) {
			titleParagraph.add(uImage);
		}
		
		titleParagraph.setOption(getTemplate().getLayoutOptions().getModelElementTextOption());
		
		USection section = new USection(titleParagraph);
		parent.add(section);
		modelElementContainer = section;
		
		UParagraph description = new UParagraph(
				modelElement.getDescriptionPlainText(), 
				getTemplate().getLayoutOptions().getDefaultTextOption()
			);
		section.add(description);
			
		/*
		 * order the features by the following types:
		 * singleProperties: EAttribute and single ERference linked
		 * multiProperties: EReference, multi
		 * containedProperties: single EReference rendered as contained.
		 */
		Vector<IItemPropertyDescriptor> singleProperties = new Vector<IItemPropertyDescriptor>();
		Vector<EStructuralFeature> multiProperties = new Vector<EStructuralFeature>();
		Vector<EStructuralFeature> containedProperties = new Vector<EStructuralFeature>();
		Vector<EStructuralFeature> otherProperties = new Vector<EStructuralFeature>();
		
		Vector<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(modelElement);
		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			EStructuralFeature feature = (EStructuralFeature)propertyDescriptor.getFeature(modelElement);
	
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			AttributeOption attributeOption = renderer.getAttributeOption();
			
			LayoutOptions layoutOptions = getTemplate().getLayoutOptions();
			if ((feature.getName().equals("annotations") && layoutOptions.isHideAnnotations())
				|| (feature.getName().equals("incomingDocumentReferences") && layoutOptions.isHideIncomingDocumentReferences())
				|| (feature.getName().equals("attachments") && layoutOptions.isHideAttachments())
				|| feature.getName().equals("description")
				|| feature.getName().equals("name") 
				|| attributeOption.isHide()
				|| modelElement.eGet(feature) == null
				){
				// do nothing!  don't render these properties
			} else {
				
				if (feature.eClass().getInstanceClass().equals(EAttribute.class)) {
					if (getAttributeRenderer(feature) instanceof DefaultAttributeRenderer) {
						singleProperties.add(propertyDescriptor);
					} else {
						otherProperties.add(feature);
					}
					
				} else {
					if (feature.isMany()) {		
						multiProperties.add(feature);
					} else {
						ReferenceAttributeOption option = (ReferenceAttributeOption) renderer.getAttributeOption();
						
						if (option.isContained()) {
							containedProperties.add(feature);
						} else {
							singleProperties.add(propertyDescriptor);
						}
					}
				}
			}	
		}
		
		renderSingleProperties(singleProperties, modelElement, modelElementContainer);
		renderMultiProperties(multiProperties, modelElement, modelElementContainer);
		renderContainedProperties(containedProperties, modelElement, modelElementContainer);
		renderOtherProperties(otherProperties, modelElement, modelElementContainer);
		
		section.add(new UParagraph("\n"));
	}

	
	private void renderSingleProperties(
			Vector<IItemPropertyDescriptor> properties,
			ModelElement modelElement,
			UCompositeSection parent) {

		if (properties.size() < 1) {
			return;
		}
		
//		parent.add(new USeperator());
		UTable table = new UTable(2);
		table.setCellBorder(0);
		table.setColumnsWidths(new float[]{30,80});
		table.setBorderBottom(1);
		
		TextOption headOption = OptionsFactory.eINSTANCE.createTextOption();
		headOption.setFontSize(getTemplate().getLayoutOptions().getDefaultTextOption().getFontSize());
		headOption.setBold(true);
		UEntry property = new UEntry("property", headOption);
		UEntry value = new UEntry("value", headOption);
		property.setBorderBottom((float)0.8);
		value.setBorderBottom((float)0.8);
		table.addEntry(property);
		table.addEntry(value);
		
		for (IItemPropertyDescriptor propertyDescriptor : properties) {
			EStructuralFeature feature = (EStructuralFeature)propertyDescriptor.getFeature(modelElement);
				
			Object obj = modelElement.eGet(feature);
			if (obj != null) {
				AttributeRenderer renderer = getAttributeRendererNotNull(feature);
				AttributeOption option = renderer.getAttributeOption();
				TextOption textOption = OptionsFactory.eINSTANCE.createTextOption();
				if (option instanceof StringAttributeOption) {
					textOption = ((StringAttributeOption) option).getTextOption();
				} else {
					if (option instanceof ReferenceAttributeOption) {
						textOption = ((ReferenceAttributeOption) option).getReferenceOption().getTextOption();
					} else {
						WorkspaceUtil.log(
								"this should not happen", 
								new Exception(), 
								IStatus.ERROR
							);
					}
				}
				
				table.addEntry(
						new UParagraph(
							propertyDescriptor.getDisplayName(modelElement),
							textOption
							)
					);
				

				String content;
				if (modelElement.eGet(feature) instanceof ModelElement) {
					ModelElement featureModelElement = (ModelElement) modelElement.eGet(feature);
					content = featureModelElement.getName();
				} else {
					content = modelElement.eGet(feature).toString();
				}
				UParagraph entry = new UParagraph(content, textOption);
				
				table.addEntry(entry);
			} 
		}
		
		parent.add(table);
		
//		parent.add(new USeperator());
	}
	
	private void renderMultiProperties(
			Vector<EStructuralFeature> properties,
			ModelElement modelElement,
			UCompositeSection parent) {
		
		for (EStructuralFeature feature : properties) {
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(
					feature, 
					modelElement, 
					parent,  
					getTemplate()
				);			
		}

	}	
	
	private void renderContainedProperties(
			Vector<EStructuralFeature> properties,
			ModelElement modelElement,
			UCompositeSection parent) {
		
		for (EStructuralFeature feature : properties) {
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(
					feature, 
					modelElement, 
					parent,  
					getTemplate()
				);			
		}

	}
	
	private void renderOtherProperties(
			Vector<EStructuralFeature> properties,
			ModelElement modelElement,
			UCompositeSection parent) {
		
		for (EStructuralFeature feature : properties) {
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(
					feature, 
					modelElement, 
					parent,  
					getTemplate()
				);			
		}

	}

	public AttributeRenderer getAttributeRendererNotNull (
			EStructuralFeature feature) {
		
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName()))
				return mapping.getAttributeRenderer();
		}
		
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
