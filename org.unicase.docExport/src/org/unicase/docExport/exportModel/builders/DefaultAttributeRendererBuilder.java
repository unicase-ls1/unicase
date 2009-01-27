/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl;
import org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl;

/**
 * @author Sebastian Hoecht
 */
public final class DefaultAttributeRendererBuilder {

	private DefaultAttributeRendererBuilder() {

	}

	/**
	 * @param feature the feature of the attribute
	 * @param template the Template where this renderer is used.
	 * @return a new DeafultAttributeRenderer
	 */
	public static AttributeRenderer build(EStructuralFeature feature, Template template) {

		AttributeRenderer renderer;
		renderer = DefaultRenderersFactory.eINSTANCE.createDefaultAttributeRenderer();

		if (feature.eClass().getInstanceClass() == EAttribute.class) {
			if (feature.getEGenericType().getERawType().equals(EcorePackage.eINSTANCE.getEBoolean())) {
				BooleanAttributeOption option = OptionsFactory.eINSTANCE.createBooleanAttributeOption();
				option.setGlobalOption((BooleanAttributeOption) template
					.getGlobalAttributeRendererOption(BooleanAttributeOptionImpl.class));
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			} else if (feature.getEGenericType().getERawType().equals(EcorePackage.eINSTANCE.getEDate())) {
				DateAttributeOption option = OptionsFactory.eINSTANCE.createDateAttributeOption();
				option.setGlobalOption((DateAttributeOption) template
					.getGlobalAttributeRendererOption(DateAttributeOptionImpl.class));
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			} else {
				StringAttributeOption option = OptionsFactory.eINSTANCE.createStringAttributeOption();
				option.setGlobalOption((StringAttributeOption) template
					.getGlobalAttributeRendererOption(StringAttributeOptionImpl.class));
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			}
		} else { // EReference
			ReferenceAttributeOption option;
			if (feature.isMany()) {
				option = OptionsFactory.eINSTANCE.createMultiReferenceAttributeOption();
				((MultiReferenceAttributeOption) option).setGlobalOption((MultiReferenceAttributeOption) template
					.getGlobalAttributeRendererOption(MultiReferenceAttributeOptionImpl.class));
				((MultiReferenceAttributeOption) option).getGlobalOption().getListOption()
					.setListStyle(ListStyle.TABLE);
			} else {
				option = OptionsFactory.eINSTANCE.createSingleReferenceAttributeOption();
				((SingleReferenceAttributeOption) option).setGlobalOption((SingleReferenceAttributeOption) template
					.getGlobalAttributeRendererOption(SingleReferenceAttributeOptionImpl.class));
			}

			option.setName(feature.getName());
			if (((EReference) feature).isContainment()) {
				option.setContained(true);
			} else {
				option.setContained(false);
			}

			option.setAttributeText("");
			renderer.setAttributeOption(option);
		}

		return renderer;
	}
}
