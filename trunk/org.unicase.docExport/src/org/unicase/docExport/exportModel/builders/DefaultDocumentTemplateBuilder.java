package org.unicase.docExport.exportModel.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.docExport.exportModel.DocumentTemplateFactory;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UColor;
import org.unicase.model.ModelElement;

/**
 * This class create a new DocumentTemplate. Therefore all available ModelElement types have to be added. For each
 * ModelElement type, a DefaultModelElementRenderer is created. The default LayoutOptions are set.
 */
public final class DefaultDocumentTemplateBuilder {

	private DefaultDocumentTemplateBuilder() {
	}

	/**
	 * Build Pattern: Builds a Default Template. Create the default LayoutOptions and fills the list of
	 * modelELementRenderers with DefaultModelElementRenderers.
	 * 
	 * @return a new Template
	 */
	public static Template build() {
		Template template = DocumentTemplateFactory.eINSTANCE.createTemplate();

		// ArrayList<EClass> modelElementTypes = getModelElements(ModelPackage.eINSTANCE.eContents());

		LayoutOptions layoutOptions = OptionsFactory.eINSTANCE.createLayoutOptions();
		template.setLayoutOptions(layoutOptions);

		UColor darkBlue = OptionsFactory.eINSTANCE.createUColor();
		darkBlue.setBlue(90);
		darkBlue.setGreen(40);
		darkBlue.setRed(0);

		layoutOptions.setHeaderText("Chair for Applied Software Engineering \n DOLLI2-Project");
		layoutOptions.getHeaderTextOption().setFontFamily(FontFamily.HELVETICA);
		layoutOptions.getHeaderTextOption().setFontSize(10);
		layoutOptions.getHeaderTextOption().setBold(true);

		layoutOptions.getSectionTextOption().setBold(true);
		layoutOptions.getSectionTextOption().setFontSize(20);
		layoutOptions.getSectionTextOption().setFontColor(darkBlue);

		layoutOptions.getModelElementTextOption().setFontSize(12);
		layoutOptions.getModelElementTextOption().setBold(true);
		layoutOptions.getModelElementTextOption().setFontColor(darkBlue);

		layoutOptions.getDefaultTextOption().setFontSize(10);

		layoutOptions.setHideAnnotations(true);
		layoutOptions.setHideAttachments(true);
		layoutOptions.setHideIncomingDocumentReferences(true);

		layoutOptions.getDocumentTitleTextOption().setFontSize(24);
		layoutOptions.getDocumentTitleTextOption().setTextAlign(TextAlign.CENTER);
		layoutOptions.getDocumentTitleTextOption().setBold(true);

		StringAttributeOption stringAttributeOption = OptionsFactory.eINSTANCE.createStringAttributeOption();
		stringAttributeOption.setName("Text");
		SingleReferenceAttributeOption singleReferenceAttributeOption = OptionsFactory.eINSTANCE
			.createSingleReferenceAttributeOption();
		singleReferenceAttributeOption.setName("Single reference");
		MultiReferenceAttributeOption multiReferenceAttributeOption = OptionsFactory.eINSTANCE
			.createMultiReferenceAttributeOption();
		multiReferenceAttributeOption.setName("Mutli reference");
		DateAttributeOption dateAttributeOption = OptionsFactory.eINSTANCE.createDateAttributeOption();
		dateAttributeOption.setName("Date attributes");
		BooleanAttributeOption booleanAttributeOption = OptionsFactory.eINSTANCE.createBooleanAttributeOption();
		booleanAttributeOption.setName("Boolean attributes");

		template.getGlobalRendererOptions().add(stringAttributeOption);
		template.getGlobalRendererOptions().add(singleReferenceAttributeOption);
		template.getGlobalRendererOptions().add(multiReferenceAttributeOption);
		template.getGlobalRendererOptions().add(dateAttributeOption);
		template.getGlobalRendererOptions().add(booleanAttributeOption);

		// for (EClass eClass : modelElementTypes) {
		// ModelElementRenderer renderer;
		// if (eClass.getInstanceClass().equals(Meeting.class)) {
		// renderer = SpecialRenderersFactory.eINSTANCE.createMeetingRenderer(template);
		// } else {
		// renderer = DefaultModelElementRendererBuilder.build(eClass, template);
		// }
		//			
		//			
		// ModelElementRendererMapping mapping = RenderersFactory.eINSTANCE.createModelElementRendererMapping();
		// mapping.setEClassName(eClass.getName());
		// mapping.setRenderer(renderer);
		// template.getModelElementRendererMapping().add(mapping);
		// }

		return template;
	}

	/**
	 * This function looks up the contents of a package for instantiatable ModelELements to add them to the result of
	 * this function. This function looks up the subPackages recursively. Normally you will start this function with
	 * ModelPackage.eINSTANCE.eContents()
	 * 
	 * @param objectList the myPackage.eContents() value where you want to look for EClasses
	 * @return a list of EClasses which represent modelElement types
	 */
	public static ArrayList<EClass> getModelElements(EList<EObject> objectList) {

		/**
		 * Compare two EClasses by EClass name
		 * 
		 * @author Sebastian Höcht
		 */
		class EClassComparator implements Comparator<EClass> {

			/**
			 * @param o1 first eClass
			 * @param o2 seconds eClass
			 * @return -1; 0 or 1 like the string compareTo function
			 */
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}

		}

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

		Collections.sort(modelElementTypes, new EClassComparator());

		return modelElementTypes;
	}
}
