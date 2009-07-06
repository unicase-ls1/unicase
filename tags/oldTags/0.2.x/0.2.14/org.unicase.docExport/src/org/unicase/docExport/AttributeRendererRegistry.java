package org.unicase.docExport;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultAttributeRendererBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.model.requirement.RequirementPackage;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public final class AttributeRendererRegistry {
	
	private AttributeRendererRegistry() {
		
	}
	
	/**
	 * Returns all supported Attribute renderers for a given feature.
	 * 
	 * @param feature the feature the supported attribute renderers are requestet
	 * @param template the Template which is needed to build the attribute renderers
	 * @return a list of newly created attribute renderers
	 */
	public static ArrayList<AttributeRenderer> getSupportedAttributeRenderers(EStructuralFeature feature, Template template) {
		ArrayList<AttributeRenderer> ret = new ArrayList<AttributeRenderer>();
		
		ret.add(DefaultAttributeRendererBuilder.build(feature, template));
		
		if (feature.eContainmentFeature().eClass().equals(RequirementPackage.eINSTANCE.getStep())) {
			ret.add(SpecialRenderersFactory.eINSTANCE.createStepsAttributeRenderer());
		}
		
		return ret;
	}
}
