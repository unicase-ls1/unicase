package org.unicase.documentexport.renderers;

import java.io.Serializable;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.StringAttributeOption;
import org.unicase.model.ModelElement;

@SuppressWarnings("serial")
public abstract class AttributeRenderer implements Serializable {
	
	class AttributeType {
		public boolean multi;
		public Class<ModelElement> clazz;
	}
	
	public AttributeOption option = new StringAttributeOption();
	
	public abstract void render(
			EStructuralFeature feature, 
			ModelElement modelElement, 
			UCompositeSection section, 
			LayoutOptions layoutOptions, 
			ModelElementRendererMappings modelElementRendererMappings, 
			DocumentTemplate template
		);
}
