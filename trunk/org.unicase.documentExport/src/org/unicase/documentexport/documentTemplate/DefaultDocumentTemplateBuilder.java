package org.unicase.documentexport.documentTemplate;

import java.util.Vector;

import org.unicase.documentexport.renderers.attribute.AttributeRendererMappings.AttributeRendererMapping;
import org.unicase.documentexport.renderers.modelElement.DefaultModelElementRenderer;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings.ModelElementRendererMapping;
import org.unicase.documentexport.renderers.options.BooleanAttributeOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.StringAttributeOption;
import org.unicase.documentexport.renderers.options.TextOption;
import org.unicase.model.ModelElement;

/**
 * This class create a new DocumentTemplate.
 * Therefore all available ModelElement types have to be added.
 * For each ModelElement type, a DefaultModelElementRenderer is created.
 * The default LayoutOptions are set.
 */
public class DefaultDocumentTemplateBuilder {

	private Vector<ModelElement> modelElementTypes;

	public void setModelElementTypes(Vector<ModelElement> modelElementTypes) {
		this.modelElementTypes = modelElementTypes;
	}
	
	public DocumentTemplate build() {
		DocumentTemplate documentTemplate = new DocumentTemplate();
		
		LayoutOptions layoutOptions = new LayoutOptions();
		layoutOptions.coverPage = "Lehrstuhl für Angewandte Softwaretechnik \n DOLLI-Projekt";
		layoutOptions.coverTextOption.fontFamily = TextOption.ARIAL;
		layoutOptions.coverTextOption.size = 10;
		layoutOptions.coverTextOption.bold = true;
		documentTemplate.layoutOptions = layoutOptions;
		
		BooleanAttributeOption booleanAttributeOption = new BooleanAttributeOption();
		booleanAttributeOption.setName("Boolean");
		StringAttributeOption stringAttributeOption = new StringAttributeOption();
		stringAttributeOption.setName("Text");
		SingleReferenceAttributeOption singleReferenceAttributeOption = new SingleReferenceAttributeOption();
		singleReferenceAttributeOption.setName("Single reference");
		MultiReferenceAttributeOption multiReferenceAttributeOption = new MultiReferenceAttributeOption();
		multiReferenceAttributeOption.setName("Mutli reference");
		
		
		documentTemplate.globalRendererOptions.add(booleanAttributeOption);
		documentTemplate.globalRendererOptions.add(stringAttributeOption);
		documentTemplate.globalRendererOptions.add(singleReferenceAttributeOption);
		documentTemplate.globalRendererOptions.add(multiReferenceAttributeOption);

		for (ModelElement modelElement : modelElementTypes) {
			DefaultModelElementRendererBuilder builder = new DefaultModelElementRendererBuilder();
			DefaultModelElementRenderer renderer = builder.build(modelElement, documentTemplate);
			renderer.modelElementRendererMappings = documentTemplate.modelElementRendererMappings;
			
			documentTemplate.modelElementRendererMappings.set(
					modelElement.eClass().getInstanceClass(), 
					renderer
				);
		}
		
		return documentTemplate;
	}
}
