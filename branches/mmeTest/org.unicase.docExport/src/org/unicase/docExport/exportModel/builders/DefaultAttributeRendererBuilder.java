package org.unicase.docExport.exportModel.builders;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public final class DefaultAttributeRendererBuilder {

	private DefaultAttributeRendererBuilder() {
		
	}
	/**
	 * 
	 * @param feature the feature of the attribute
	 * @param template the Template where this renderer is used.
	 * @return a new DeafultAttributeRenderer
	 */
	public static AttributeRenderer build(EStructuralFeature feature, Template template) {
		
		AttributeRenderer renderer;
		
//		if (feature.getEGenericType().getEClassifier().getName().equals(RequirementPackage.eINSTANCE.getStep().getName())) {
//			renderer = SpecialRenderersFactory.eINSTANCE.createStepsAttributeRenderer();
//		} else {
//			renderer = DefaultRenderersFactory.eINSTANCE.createDefaultAttributeRenderer();
//		}
		
		renderer = DefaultRenderersFactory.eINSTANCE.createDefaultAttributeRenderer();
		
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
