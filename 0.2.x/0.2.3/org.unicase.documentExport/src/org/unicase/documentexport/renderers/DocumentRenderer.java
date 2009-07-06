package org.unicase.documentexport.renderers;

import org.eclipse.emf.common.util.EList;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UDocument;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.document.impl.LeafSectionImpl;

public class DocumentRenderer {
	
	protected DocumentTemplate template;
	protected UCompositeSection doc;
	
	public UDocument getDocument() {
		return doc;
	}
	
	public UCompositeSection renderDocument(ModelElement modelElement, DocumentTemplate template) {
		TemplateSaveHelper.meCount = 0;
		this.template = template;
		doc = new UCompositeSection();
		doc.option = template.layoutOptions;
		
		UParagraph coverPage = new UParagraph(template.layoutOptions.coverPage);
		coverPage.option = template.layoutOptions.coverTextOption;
		doc.add(coverPage);
		
		if (modelElement instanceof CompositeSection) {
			renderCompositeSection(doc, (CompositeSection)modelElement);
		} else if (modelElement instanceof LeafSection) {
			renderLeafSection(doc, (LeafSectionImpl)modelElement);
		} else {
			renderModelElement(doc, modelElement);
		}

		return doc;
	}

	/**
	 * renders a composite section recursivly until an Leafsection appears. Then the leafsection renderer is called.
	 */
	private void renderCompositeSection(UCompositeSection parent, CompositeSection compositeSection) {

		USection section = new USection(
				compositeSection.getName(), 
				template.layoutOptions.sectionTextOption
			);
		parent.add(section);
			
		section.add(new UParagraph(
				compositeSection.getDescription(), 
				template.layoutOptions.defaultTextOption)
			);
		
		
		EList<Section>  subSections = compositeSection.getSubsections();
		for (Section child : subSections) {
			if (child instanceof LeafSection) {
				renderLeafSection(section, (LeafSection) child);
			} else { //instanceof CompositeSection
				renderCompositeSection(section, (CompositeSection)child);
			}
		}
	}

	private void renderLeafSection(UCompositeSection parent, LeafSection leafSection) {
		USection section = new USection(
				leafSection.getName(), 
				template.layoutOptions.sectionTextOption
			);
		parent.add(section);
			
		section.add(new UParagraph(
				leafSection.getDescription(), 
				template.layoutOptions.defaultTextOption)
			);	
		
		EList<ModelElement>  subSections = leafSection.getModelElements();
		for (ModelElement child : subSections) {
			renderModelElement(section, child);
		}
	}

	/**
	 * Render the ModelElement using the Renderer defined in the modelElementRendererMappings
	 */
	private void renderModelElement(UCompositeSection parent, ModelElement modelElement) {
		ModelElementRenderer renderer = 
			template.modelElementRendererMappings.get(modelElement.eClass());
		renderer.render(modelElement, parent, template.layoutOptions);
	}	
}
