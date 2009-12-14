/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders.attributeRenderers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;

/**
 * Creates a List of available AttributeRenderers for the Unicase model feature attribute.
 * 
 * @author Sebastian Hoecht
 */
public class ClassAttributeRendererBuilder extends AttributeRendererBuilder {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.exportModel.builders.attributeRenderers.AttributeRendererBuilder#buildRenderers(org.unicase.docExport.exportModel.Template)
	 */
	@Override
	public ArrayList<AttributeRenderer> buildRenderers(EStructuralFeature feature, Template template) {
		ArrayList<AttributeRenderer> renderers = super.buildRenderers(feature, template);

		renderers.add(SpecialRenderersFactory.eINSTANCE.createClassAttributesRenderer());

		return renderers;
	}

}
