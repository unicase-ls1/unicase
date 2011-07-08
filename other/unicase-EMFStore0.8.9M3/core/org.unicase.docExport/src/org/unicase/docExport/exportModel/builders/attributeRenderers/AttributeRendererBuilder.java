/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders.attributeRenderers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultAttributeRendererFactory;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;

/**
 * Creates a List of available AttributeRenderers for any Unicase model attribute.
 * 
 * @author Sebastian Hoecht
 */
public class AttributeRendererBuilder {

	/**
	 * @param template The template for the Renderer shall be created for.
	 * @param feature the feature the AttributeRenderer is used for.
	 * @return a list of all available ModelElementRenderers, which are ready to be used.
	 */
	public ArrayList<AttributeRenderer> buildRenderers(EStructuralFeature feature, Template template) {
		ArrayList<AttributeRenderer> renderers = new ArrayList<AttributeRenderer>();

		AttributeRenderer renderer = DefaultAttributeRendererFactory.build(feature, template);
		renderers.add(renderer);

		return renderers;
	}
}
