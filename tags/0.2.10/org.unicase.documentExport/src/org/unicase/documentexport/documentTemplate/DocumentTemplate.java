package org.unicase.documentexport.documentTemplate;

import java.util.ArrayList;

import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;

public class DocumentTemplate implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 180124716270123330L;
	
	public ModelElementRendererMappings modelElementRendererMappings = new ModelElementRendererMappings();
	public ArrayList<AttributeOption> globalRendererOptions = new ArrayList<AttributeOption>();
	public LayoutOptions layoutOptions;
	public String name = "unnamed";

	public AttributeOption getGlobalAttributeRendererOption(Class clazz) {
		for (int i = 0; i < globalRendererOptions.size(); i++) {
			if (globalRendererOptions.get(i).getClass() == clazz)
				return globalRendererOptions.get(i);
		}
		
		return null;
	}
}
