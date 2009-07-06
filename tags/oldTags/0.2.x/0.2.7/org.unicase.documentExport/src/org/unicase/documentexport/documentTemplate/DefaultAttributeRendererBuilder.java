package org.unicase.documentexport.documentTemplate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.renderers.attribute.DefaultAttributeRenderer;

public class DefaultAttributeRendererBuilder {

	public DefaultAttributeRenderer build(EStructuralFeature feature) {
		DefaultAttributeRenderer renderer = new DefaultAttributeRenderer();
		
		return renderer;
	}

}
