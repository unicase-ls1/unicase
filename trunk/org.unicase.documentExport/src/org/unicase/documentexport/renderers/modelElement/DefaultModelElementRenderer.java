package org.unicase.documentexport.renderers.modelElement;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.AttributeRenderer;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.documentexport.renderers.attribute.AttributeRendererMappings;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UDocument;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.RendererOption;
import org.unicase.model.ModelElement;

@SuppressWarnings("serial")
public class DefaultModelElementRenderer extends ModelElementRenderer {
	
	public AttributeRendererMappings attributeRendererMappings = new AttributeRendererMappings();
	public ModelElementRendererMappings modelElementRendererMappings;

	public void setAttributeRendererMappings(AttributeRendererMappings mappings) {
		attributeRendererMappings = mappings;
	}
	
	public void setModelElementRendererMappings(ModelElementRendererMappings mappings) {
		this.modelElementRendererMappings = mappings;
	}
	
	public DefaultModelElementRenderer(DocumentTemplate template) {
		super(template);
	}

	
	public void render(
			ModelElement modelElement, 
			UCompositeSection parent, 
			LayoutOptions layoutOptions
		) {
	
		TemplateSaveHelper.meCount++;
		
		USection section = new USection(
				modelElement.getName(), 
				layoutOptions.sectionTextOption
			);
		parent.add(section);
			
		
		Vector<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(modelElement);
		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			EStructuralFeature feature = (EStructuralFeature)propertyDescriptor.getFeature(modelElement);
			
			AttributeRenderer renderer = attributeRendererMappings.get(feature);
			for (RendererOption option : rendererOptions) {
				if (option instanceof AttributeOption) {
					if (option.getName().equals(feature.getName())) {
						renderer.option = (AttributeOption)option;
					}
				}
			}
			
			if (
					(feature.getName() == "annotations" && layoutOptions.hideAnnotations)
					|| (feature.getName() == "incomingDocumentReferences" && layoutOptions.hideDocumentReferences)
					|| (feature.getName() == "attachments" && layoutOptions.hideAttachments)
				) {
				// do nothing!  dont render these properties
			} else {
			renderer.render(
					feature, 
					modelElement, 
					section, 
					layoutOptions, 
					modelElementRendererMappings,
					template
				);
			}	
		}
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
	

}
