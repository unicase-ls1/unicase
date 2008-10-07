package org.unicase.documentexport.renderers.attribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.renderers.AttributeRenderer;

public class AttributeRendererMappings implements Serializable {


	
	public class AttributeRendererMapping implements Serializable {
		public String attributeName;
		public AttributeRenderer renderer;
	}
	
	public ArrayList<AttributeRendererMapping> attributeRenderers = new ArrayList<AttributeRendererMapping>();
	
	public void set(EStructuralFeature feature, AttributeRenderer renderer) {
		//default renderers are always returned if there is no entry in the attributeRendererMappings.
		//so just do nothing here.
		if (renderer.getClass().equals(DefaultAttributeRenderer.class))
			return;
		
		//there isn't any entry for this feature yet -> add it
		if ((get(feature)).getClass().equals(DefaultAttributeRenderer.class)) {
			AttributeRendererMapping mapping = new AttributeRendererMapping();
			mapping.attributeName = feature.getName();
			mapping.renderer = renderer;
			attributeRenderers.add(mapping);			
		} 
		//change the existing entry for this feature
		else {
			for (AttributeRendererMapping mapping : attributeRenderers) {
				if (mapping.attributeName == feature.getName())
					mapping.renderer = renderer;
			}		
		}
	}
	
	public AttributeRenderer get(EStructuralFeature feature) {
		for (AttributeRendererMapping mapping : attributeRenderers) {
			if (mapping.attributeName == feature.getName())
				return mapping.renderer;
		}
		
		//no match found -> default renderer
		return new DefaultAttributeRenderer();
	}
	
	public ArrayList<AttributeRendererMapping> getRendererList() {
		return attributeRenderers;
	}
}
