/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders.modelElementRenderers;

import java.util.ArrayList;

import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;

/**
 * Creates a List of available ModelElementRenderers for any Unicase model.
 * 
 * @author Sebastian Hoecht
 */
public class ModelElementRendererBuilder {

	/**
	 * @param template The template for the Renderer shall be created for.
	 * @return a list of all available ModelElementRenderers, which are ready to be used.
	 */
	public ArrayList<ModelElementRenderer> buildRenderers(Template template) {
		ArrayList<ModelElementRenderer> renderers = new ArrayList<ModelElementRenderer>();

		DefaultModelElementRenderer renderer = DefaultRenderersFactory.eINSTANCE.createDefaultModelElementRenderer();
		renderer.setTemplate(template);
		renderers.add(renderer);

		return renderers;
	}
}
