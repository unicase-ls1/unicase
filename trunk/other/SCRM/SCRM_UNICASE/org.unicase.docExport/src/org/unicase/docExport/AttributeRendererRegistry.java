/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.attributeRenderers.AttributeRendererBuilder;
import org.unicase.docExport.exportModel.builders.attributeRenderers.ClassAttributeRendererBuilder;
import org.unicase.docExport.exportModel.builders.attributeRenderers.MethodRendererBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.model.classes.ClassesPackage;

/**
 * This class creates a mapping from a ModelElement's feature to a its possible AttributeRenderers. So if you create a
 * new AttributeRenderer, it should be returned in the function getSupportedAttributeRenderers for all features it
 * supports.
 * 
 * @author Sebastian Hoecht
 */
public final class AttributeRendererRegistry {

	private AttributeRendererRegistry() {

	}

	/**
	 * Returns all supported AttributeRenderers for a given feature.
	 * 
	 * @param feature the feature the supported attribute renderers are requestet
	 * @param template the Template which is needed to build the attribute renderers
	 * @return a list of newly created attribute renderers
	 */
	public static ArrayList<AttributeRenderer> getSupportedAttributeRenderers(EStructuralFeature feature,
		Template template) {

		AttributeRendererBuilder builder = new AttributeRendererBuilder();

		if (feature instanceof EReference) {
			EClass referenceType = ((EReference) feature).getEReferenceType();
			if (referenceType.equals(ClassesPackage.eINSTANCE.getMethod())) {
				builder = new MethodRendererBuilder();
			} else if (referenceType.equals(ClassesPackage.eINSTANCE.getAttribute())) {
				builder = new ClassAttributeRendererBuilder();
			}
		}

		return builder.buildRenderers(feature, template);
	}
}
