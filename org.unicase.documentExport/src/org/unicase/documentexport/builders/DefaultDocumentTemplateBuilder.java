package org.unicase.documentexport.builders;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.documentexport.documentTemplate.DocumentTemplateFactory;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.ModelElementRenderer;
import org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping;
import org.unicase.documentexport.documentTemplate.renderers.RenderersFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.FontFamily;
import org.unicase.documentexport.documentTemplate.renderers.options.LayoutOptions;
import org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.options.StringAttributeOption;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.meeting.Meeting;

/**
 * This class create a new DocumentTemplate.
 * Therefore all available ModelElement types have to be added.
 * For each ModelElement type, a DefaultModelElementRenderer is created.
 * The default LayoutOptions are set.
 */
public class DefaultDocumentTemplateBuilder {
	
	/**
	 * Build Pattern: Builds a Default Template.
	 * Create the default LayoutOptions and fills the list of modelELementRenderers with
	 * DefaultModelElementRenderers.
	 * @return a new Template
	 */
	public static Template build() {
		Template template = DocumentTemplateFactory.eINSTANCE.createTemplate();
		
		ArrayList<EClass> modelElementTypes = getModelElements(ModelPackage.eINSTANCE.eContents());
		
		LayoutOptions layoutOptions = OptionsFactory.eINSTANCE.createLayoutOptions();
		layoutOptions.setCoverText("Lehrstuhl für Angewandte Softwaretechnik \n DOLLI2-Projekt");
		layoutOptions.getCoverTextTextOption().setFontFamily(FontFamily.ARIAL);
		layoutOptions.getCoverTextTextOption().setFontSize(10);
		layoutOptions.getCoverTextTextOption().setBold(true);
		
		layoutOptions.getSectionTextOption().setBold(true);
		layoutOptions.getSectionTextOption().setFontSize(14);
		template.setLayoutOptions(layoutOptions);
		
		StringAttributeOption stringAttributeOption = OptionsFactory.eINSTANCE.createStringAttributeOption();
		stringAttributeOption.setName("Text");
		SingleReferenceAttributeOption singleReferenceAttributeOption = OptionsFactory.eINSTANCE.createSingleReferenceAttributeOption();
		singleReferenceAttributeOption.setName("Single reference");
		MultiReferenceAttributeOption multiReferenceAttributeOption = OptionsFactory.eINSTANCE.createMultiReferenceAttributeOption();
		multiReferenceAttributeOption.setName("Mutli reference");
		
		template.getGlobalRendererOptions().add(stringAttributeOption);
		template.getGlobalRendererOptions().add(singleReferenceAttributeOption);
		template.getGlobalRendererOptions().add(multiReferenceAttributeOption);

		for (EClass eClass : modelElementTypes) {
			ModelElementRenderer renderer;
			if (eClass.getInstanceClass().equals(Meeting.class)) {
				renderer = SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template);
			} else {
				renderer = DefaultModelElementRendererBuilder.build(eClass, template);
			}
			
			
			ModelElementRendererMapping mapping = RenderersFactory.eINSTANCE.createModelElementRendererMapping();
			mapping.setEClassName(eClass.getName());
			mapping.setRenderer(renderer);
			template.getModelElementRendererMapping().add(mapping);
		}
		
		return template;
	}
	
	/**
	 * This function looks up the contents of a package for instantiatable ModelELements
	 * to add them to the result of this function. This function looks up the subPackages
	 * recursively. Normally you will start this function with 
	 * ModelPackage.eINSTANCE.eContents()
	 * @param the myPackage.eContents() value where you want to look for EClasses
	 * @return
	 */
	public static ArrayList<EClass> getModelElements(EList<EObject> objectList) {
		ArrayList<EClass> modelElementTypes = new ArrayList<EClass>();
		
		for (EObject object : objectList) {
			if (object instanceof EClass) {
				EClass eClass = (EClass) object;
				EObject me;
				if (!(eClass.isAbstract() || eClass.isInterface())) {
					me = eClass.getEPackage().getEFactoryInstance().create(eClass);
					if (me instanceof ModelElement) {
						modelElementTypes.add((EClass) object);
					}
				}
			} else if (object instanceof EPackage) {
					modelElementTypes.addAll(getModelElements(object.eContents()));
			}			
		}
		return modelElementTypes;
	}
}
