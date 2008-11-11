package org.unicase.docExport;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.docExport.exportModel.builders.DefaultModelElementRendererBuilder;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.util.WorkspaceUtil;

public class ModelElementRendererRegistry {

	public static ArrayList<ModelElementRenderer> getSupportedModelElementRenderers(
			String modelElementEClass, 
			Template template) {
		
		ArrayList<ModelElementRenderer> renderers = new ArrayList<ModelElementRenderer>();
		
		ModelElementRenderer defaultRenderer = DefaultModelElementRendererBuilder.build(
				getEClassOfString(modelElementEClass), 
				template
			);
		renderers.add(defaultRenderer);
		
		if (modelElementEClass.equals("Meeting")) {
			renderers.add(SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template));
		} else if (modelElementEClass.equals("Milestone")) {
			MilestoneRenderer renderer = SpecialRenderersFactory.eINSTANCE.createMilestoneRenderer();
			renderer.setTemplate(template);
			renderers.add(renderer);
		}
		
		return renderers;
	}
	
	public static EClass getEClassOfString(String clazz) {
		ArrayList<EClass> modelElementTypes = 
			DefaultDocumentTemplateBuilder.getModelElements(ModelPackage.eINSTANCE.eContents());
		
		for (EClass eClass : modelElementTypes) {
			if (eClass.getName().equals(clazz)) {
				return eClass;
			}
		}
		
		WorkspaceUtil.log(
				"can't find an EClass for the ModelElement Type " + clazz,
				new Exception(),
				IStatus.WARNING
			);
		return null;
	}
}
