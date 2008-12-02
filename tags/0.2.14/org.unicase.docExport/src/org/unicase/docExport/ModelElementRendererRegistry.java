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

/**
 * 
 * @author Sebastian Höcht
 * 
 */
public final class ModelElementRendererRegistry {

	private ModelElementRendererRegistry() {
		
	}
	
	/**
	 * Returns all possible ModelElementRenderers for a given modelElement EClass.
	 * 
	 * @param modelElementEClass the EClass of the ModelElement type
	 * @param template the template where the ModelElementRenderers are needed. This 
	 * parameter is required, because the a new default model element renderer is created.
	 * The build requires a template (because of the global renderer options)
	 * @return all possible ModelElementRenderers
	 */
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
	
	/**
	 * Returns the deafult renderer which shall be used, if no renderer has been selected.
	 * 
	 * @param modelElementEClass the modelElement type a renderer is needed for
	 * @param template the template where this renderer is used
	 * @return the fully configured default special renderer or a DefaultModelElementRenderer
	 */
	public static ModelElementRenderer getDefaultSpecialModelElementRenderer(
			EClass modelElementEClass, 
			Template template) {
		
		if (modelElementEClass.getName().equals("Meeting")) {
			return SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template);
		} else if (modelElementEClass.getName().equals("Milestone")) {
			return SpecialRenderersFactory.eINSTANCE.createMilestoneRenderer();
		} else {
			return DefaultModelElementRendererBuilder.build(
					modelElementEClass, 
					template
				);		
		}
	}
	
	/**
	 * Returns the EClass of a ModelElement type given the clazz name of the ModelELement.
	 * 
	 * @param clazz thez class name of the ModelElement
	 * @return the EClass of the ModelElement
	 */
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
