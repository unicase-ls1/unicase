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
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;

/**
 * Creates a List of available ModelElementRenderers for Unicase Classes.
 * 
 * @author Sebastian Hoecht
 */
public class ClassRenderersBuilder extends ModelElementRendererBuilder {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.exportModel.builders.modelElementRenderers.ModelElementRendererBuilder#buildRenderers(org.unicase.docExport.exportModel.Template)
	 */
	@Override
	public ArrayList<ModelElementRenderer> buildRenderers(Template template) {
		ArrayList<ModelElementRenderer> ret = super.buildRenderers(template);

		ClassRenderer renderer = SpecialRenderersFactory.eINSTANCE.createClassRenderer();
		renderer.setTemplate(template);
		ret.add(renderer);

		return ret;
	}
}
