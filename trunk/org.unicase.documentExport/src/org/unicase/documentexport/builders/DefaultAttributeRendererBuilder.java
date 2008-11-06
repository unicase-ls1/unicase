package org.unicase.documentexport.builders;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.ReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.StringAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.impl.MultiReferenceAttributeOptionImpl;
import org.unicase.documentexport.documentTemplate.renderers.options.impl.SingleReferenceAttributeOptionImpl;
import org.unicase.documentexport.documentTemplate.renderers.options.impl.StringAttributeOptionImpl;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class DefaultAttributeRendererBuilder {

	/**
	 * 
	 * @param feature the feature of the attribute
	 * @return a new DeafultAttributeRenderer
	 */
	public static DefaultAttributeRenderer build(EStructuralFeature feature, Template template) {
		DefaultAttributeRenderer renderer = DefaultRenderersFactory.eINSTANCE.createDefaultAttributeRenderer();

		if (feature.eClass().getInstanceClass() == EAttribute.class) {
			StringAttributeOption option = OptionsFactory.eINSTANCE.createStringAttributeOption();
			option.setGlobalOption((StringAttributeOption) template.getGlobalAttributeRendererOption(
						StringAttributeOptionImpl.class));
			option.setName(feature.getName());
			renderer.setAttributeOption(option);
		} else { //EReference	
			ReferenceAttributeOption option;
			if (feature.isMany()) {
				option = OptionsFactory.eINSTANCE.createMultiReferenceAttributeOption();
				((MultiReferenceAttributeOption)option).setGlobalOption((MultiReferenceAttributeOption) template.getGlobalAttributeRendererOption(
							MultiReferenceAttributeOptionImpl.class));
			} else {
				option = OptionsFactory.eINSTANCE.createSingleReferenceAttributeOption();
				((SingleReferenceAttributeOption)option).setGlobalOption((SingleReferenceAttributeOption) template.getGlobalAttributeRendererOption(
							SingleReferenceAttributeOptionImpl.class));
			}
			
			option.setName(feature.getName());
			if (((EReference) feature).isContainment()) {
				option.setContained(true);
			}
			else {
				option.setContained(false);
			}
			
			renderer.setAttributeOption(option);
		}
		
		return renderer;
	}

}
