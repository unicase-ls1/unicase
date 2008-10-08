package org.unicase.documentexport.renderers.modelElement;

import java.io.Serializable;
import java.util.ArrayList;

import org.unicase.documentexport.renderers.ModelElementRenderer;

/**
 * This class has contains a mapping from ModeElement type to ModelElementRenderer.
 * This mapping is needed in a DocumentTemplate to know which renderer should be used for each
 * ModelElement type.
 */
@SuppressWarnings("serial")
public class ModelElementRendererMappings implements Serializable {

	public class ModelElementRendererMapping implements Serializable {
		public Class modelElementType;
		public ModelElementRenderer renderer;
	}
	
	private ArrayList<ModelElementRendererMapping> modelElementRenderers = new ArrayList<ModelElementRendererMapping>();
	
	public ArrayList<ModelElementRendererMapping> getRendererList() {
		return modelElementRenderers;
	}
	
	public void set(Class clazz, ModelElementRenderer renderer) {
		
		//there isn't any entry for this ModelElement type yet -> add it
		if ((get(clazz)) == null) {
			ModelElementRendererMapping mapping = new ModelElementRendererMapping();
			mapping.modelElementType = clazz;
			mapping.renderer = renderer;
			modelElementRenderers.add(mapping);			
		} 
		//change the existing entry for this modelElement type
		else {
			for (ModelElementRendererMapping mapping : modelElementRenderers) {
				if (mapping.modelElementType.equals(clazz))
					mapping.renderer = renderer;
			}		
		}
	}

	public ModelElementRenderer get(Class clazz) {
		for (ModelElementRendererMapping mapping : modelElementRenderers) {
			if (mapping.modelElementType.equals(clazz))
				return mapping.renderer;
		}
		
		//no match found -> return null
		return null;
	}

}
