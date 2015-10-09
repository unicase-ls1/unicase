/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;

/**
 * Creates a new default AttributeRenderer and adds the correct AttributeOption objects. This is a factory method design
 * pattern.
 * 
 * @author Sebastian Hoecht
 */
public final class DefaultAttributeRendererFactory {

	private DefaultAttributeRendererFactory() {

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
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			} else if (feature.getEGenericType().getERawType().equals(EcorePackage.eINSTANCE.getEDate())) {
				DateAttributeOption option = OptionsFactory.eINSTANCE.createDateAttributeOption();
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			} else {
				StringAttributeOption option = OptionsFactory.eINSTANCE.createStringAttributeOption();
				option.setName(feature.getName());
				renderer.setAttributeOption(option);
			}
		} else { // EReference
			ReferenceAttributeOption option;
			if (feature.isMany()) {
				option = OptionsFactory.eINSTANCE.createMultiReferenceAttributeOption();
				((MultiReferenceAttributeOption) option).getListOption().setListStyle(ListStyle.TABLE);
			} else {
				option = OptionsFactory.eINSTANCE.createSingleReferenceAttributeOption();
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
