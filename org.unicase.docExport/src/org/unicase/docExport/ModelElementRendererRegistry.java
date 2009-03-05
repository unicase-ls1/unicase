/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.docExport.exportModel.builders.DefaultModelElementRendererBuilder;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Sebastian Hoecht
 */
public final class ModelElementRendererRegistry {

	private ModelElementRendererRegistry() {

	}

	/**
	 * Returns all possible ModelElementRenderers for a given modelElement EClass.
	 * 
	 * @param modelElementEClass the EClass of the ModelElement type
	 * @param template the template where the ModelElementRenderers are needed. This parameter is required, because the
	 *            a new default model element renderer is created. The build requires a template (because of the global
	 *            renderer options)
	 * @return all possible ModelElementRenderers
	 */
	public static ArrayList<ModelElementRenderer> getSupportedModelElementRenderers(String modelElementEClass,
		Template template) {

		ArrayList<ModelElementRenderer> renderers = new ArrayList<ModelElementRenderer>();

		ModelElementRenderer defaultRenderer = DefaultModelElementRendererBuilder.build(
			getEClassOfString(modelElementEClass), template);
		renderers.add(defaultRenderer);

		if (modelElementEClass.equals("Meeting")) {
			MeetingRenderer renderer = SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template);
			renderers.add(renderer);

			FhmMeetingRenderer renderer2 = SpecialRenderersFactory.eINSTANCE.createFhmMeetingRenderer();
			renderer2.setTemplate(template);
			renderers.add(renderer2);

		} else if (modelElementEClass.equals("Milestone")) {
			MilestoneRenderer renderer = SpecialRenderersFactory.eINSTANCE.createMilestoneRenderer();
			renderer.setTemplate(template);
			renderers.add(renderer);
		} else if (modelElementEClass.equals("Package")) {
			PackageFlatRenderer renderer = SpecialRenderersFactory.eINSTANCE.createPackageFlatRenderer();
			renderer.setTemplate(template);
			renderers.add(renderer);
		} else if (modelElementEClass.equals("Class")) {
			ClassRenderer renderer = SpecialRenderersFactory.eINSTANCE.createClassRenderer();
			renderer.setTemplate(template);
			renderers.add(renderer);
		}

		return renderers;
	}

	/**
	 * Returns the deafult renderer which shall be used, if no renderer has been selected.
	 * 
	 * @param modelElementEClass the modelElement type a renderer is needed for
	 * @param template the template where this renderer is used
	 * @return the fully configured default special renderer or a DefaultModelElementRenderer
	 */
	public static ModelElementRenderer getDefaultSpecialModelElementRenderer(EClass modelElementEClass,
		Template template) {

		if (modelElementEClass.getName().equals("Meeting")) {
			return SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template);
		} else if (modelElementEClass.getName().equals("Milestone")) {
			return SpecialRenderersFactory.eINSTANCE.createMilestoneRenderer();
		} else {
			return DefaultModelElementRendererBuilder.build(modelElementEClass, template);
		}
	}

	/**
	 * Returns the EClass of a ModelElement type given the clazz name of the ModelELement.
	 * 
	 * @param clazz thez class name of the ModelElement
	 * @return the EClass of the ModelElement
	 */
	public static EClass getEClassOfString(String clazz) {
		ArrayList<EClass> modelElementTypes = DefaultDocumentTemplateBuilder.getModelElements(ModelPackage.eINSTANCE
			.eContents());

		for (EClass eClass : modelElementTypes) {
			if (eClass.getName().equals(clazz)) {
				return eClass;
			}
		}

		WorkspaceUtil.log("can't find an EClass for the ModelElement Type " + clazz, new Exception(), IStatus.WARNING);
		return null;
	}
}
