package org.unicase.documentexport.renderers;

import java.io.Serializable;
import java.util.ArrayList;

import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.RendererOption;
import org.unicase.model.ModelElement;

@SuppressWarnings("serial")
public abstract class ModelElementRenderer implements Serializable {
	public ArrayList<RendererOption> rendererOptions = new ArrayList<RendererOption>();
	
	protected LayoutOptions layoutOptions;
	protected DocumentTemplate template;
	
	public abstract void render(
			ModelElement modelElement, 
			UCompositeSection section, 
			LayoutOptions layoutOptions
		);
	
	public ModelElementRenderer(DocumentTemplate template) {
		this.template = template;
	}
}
