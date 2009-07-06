package org.unicase.documentexport.renderers.attribute;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.AttributeRenderer;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.BooleanAttributeOption;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.ListOption;
import org.unicase.documentexport.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.ReferenceOption;
import org.unicase.documentexport.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.StringAttributeOption;
import org.unicase.model.ModelElement;

@SuppressWarnings("serial")
public class DefaultAttributeRenderer extends AttributeRenderer {

    private LayoutOptions layoutOptions;
    private ModelElementRendererMappings modelElementRendererMappings;
    
    public void render(
			EStructuralFeature feature,
			ModelElement modelElement, 
			UCompositeSection parent,
			LayoutOptions layoutOptions,
			ModelElementRendererMappings modelElementRendererMappings,
			DocumentTemplate template
		) {
		
		this.layoutOptions = layoutOptions;
		this.modelElementRendererMappings = modelElementRendererMappings;
		
		if (option instanceof StringAttributeOption) {
			this.option.globalOption = (StringAttributeOption) 
				template.getGlobalAttributeRendererOption(StringAttributeOption.class);
		}
		if (option instanceof BooleanAttributeOption) {
			this.option.globalOption = (BooleanAttributeOption) 
				template.getGlobalAttributeRendererOption(BooleanAttributeOption.class);			
		}
		if (option instanceof SingleReferenceAttributeOption) {
			this.option.globalOption = (SingleReferenceAttributeOption) 
				template.getGlobalAttributeRendererOption(SingleReferenceAttributeOption.class);		
		}
		if (option instanceof MultiReferenceAttributeOption) {
			this.option.globalOption = (MultiReferenceAttributeOption) 
				template.getGlobalAttributeRendererOption(MultiReferenceAttributeOption.class);	
		}
		

		if (option.hide)
			return;
		
		if (feature.isMany()) {
			renderMultiFeature(feature, modelElement, parent);
		} else {
			renderSingleFeature(feature, modelElement, parent);
		}

	}

	private void renderSingleFeature(
			EStructuralFeature feature,
			ModelElement modelElement, 
			UCompositeSection parent) {	
		TemplateSaveHelper.meCount++;
		
		Object content = modelElement.eGet(feature);
		if (feature.eClass().getInstanceClass() == EAttribute.class) {
			if (content == null && !layoutOptions.hideEmptyAttributes) {
				content = "";
			}
			if (content != null) {
				renderSimpleAttribute(content, parent, feature);
			}
		} else { //EReference	
			if (content != null) {
				if (((EReference) feature).isContainment())
					renderContainedReference((ModelElement)content, parent, feature);
				else
					renderLinkedReference((ModelElement)content, parent, feature);
			}
		}
	}

	private void renderSimpleAttribute(
			Object content, 
			UCompositeSection parent, 
			EStructuralFeature feature
		) {
		
		if (option instanceof StringAttributeOption) {
			StringAttributeOption option2 = (StringAttributeOption)option;
			UParagraph name = new UParagraph(
					"# " + feature.getName() + ": " + 
					content.toString(), 
					option2.getTextOption()
				);
			name.setIndentionLeft(1);
			parent.add(name);		
		} else if (option instanceof BooleanAttributeOption) {
			BooleanAttributeOption option2 = (BooleanAttributeOption)option;
			UParagraph name = new UParagraph(
					"# " + feature.getName() + ": " + 
					content.toString(), 
					option2.getBooleanOption()
				);
			name.setIndentionLeft(1);
			parent.add(name);			
		}

	}

	private void renderLinkedReference(
			ModelElement content, 
			UCompositeSection parent, 
			EStructuralFeature feature
		) {
		
		

		String text = "# " + feature.getName() + ": " + 
		content.getName();
		
		if (option instanceof MultiReferenceAttributeOption) {
			MultiReferenceAttributeOption option2 = (MultiReferenceAttributeOption) option;
			ListOption listOption = option2.getListOption();
			
			if (listOption.listStyle == ListOption.BULLETED) {
				text = listOption.bullet + content.getName();
			} else if (listOption.listStyle == ListOption.SPERERATED_LIST) {
				text = content.getName() + listOption.seperator;
			} else if (listOption.listStyle == ListOption.JUST_NEW_LINES) {
				//nothing?!
			}
		}	
		
		
		UParagraph name = new UParagraph(
				text, 
				layoutOptions.defaultTextOption
			);
		name.setIndentionLeft(1);
		parent.add(name);
		
		if (layoutOptions.alwaysShowDescription)
			addDescription(parent, content.getDescription());
	}

	private void renderContainedReference(
			ModelElement content, 
			UCompositeSection attributeSection, 
			EStructuralFeature feature
		) {
		
		ModelElementRenderer renderer = modelElementRendererMappings.get(
				((ModelElement)content).eClass()
			);
		renderer.render(content, attributeSection, layoutOptions);
	}
	
	private ReferenceOption getRefenceOption (AttributeOption option) {
		if (option instanceof MultiReferenceAttributeOption)
			return ((MultiReferenceAttributeOption)option).getReferenceOption();
		else if (option instanceof SingleReferenceAttributeOption)
			return ((SingleReferenceAttributeOption)option).getReferenceOption();
		return new ReferenceOption();
	}
	
	
	/**
	 * renders an attribute with can have more than one reference to a modelElement
	 */
	private void renderMultiFeature(
			EStructuralFeature feature,
			ModelElement modelElement, 
			UCompositeSection parent) {
		
		UParagraph paragraph = new UParagraph(feature.getName(), layoutOptions.sectionTextOption);
		paragraph.setIndentionLeft(1);
		parent.add(paragraph);
		
		ReferenceOption refOption = getRefenceOption(option);
		Object attributeValue = modelElement.eGet(feature);

		EList<ModelElement> objectList = (EList<ModelElement>)attributeValue;
		ListOption listOption = ((MultiReferenceAttributeOption)option).getListOption();
		
		
		if (objectList != null) {
			if (!refOption.contained) {
				int listStyle = listOption.listStyle;
				if (listStyle == ListOption.SPERERATED_LIST) {
					renderList(parent, objectList, feature, listOption, refOption);
				} else if (listStyle == ListOption.JUST_NEW_LINES) {
					renderJustNewLines(parent, objectList, feature, listOption, refOption);
				} else if (listStyle == ListOption.BULLETED) {
					renderBulletedList(parent, objectList, feature, listOption, refOption);
				}				
			} else { //contained
				for (ModelElement me : objectList) {
					renderContainedReference(me, parent, feature);
				}			
			}
		}
	}
	
	private void renderList (
			UCompositeSection parent, 
			EList<ModelElement> objectList,
			EStructuralFeature feature,
			ListOption listOpion,
			ReferenceOption refOption) {
		
		String text = "";
		for (ModelElement me : objectList) {
			TemplateSaveHelper.meCount++;
			text += me.getName() + ", ";
		}
		
		UParagraph paragraph = new UParagraph(text, refOption.textOption);
		paragraph.setIndentionLeft(2);
		parent.add(paragraph);	
	}
	
	private void renderJustNewLines (			
			UCompositeSection parent, 
			EList<ModelElement> objectList,
			EStructuralFeature feature,
			ListOption listOpion,
			ReferenceOption refOption) {
		
		for (ModelElement me : objectList) {
			TemplateSaveHelper.meCount++;
			UParagraph paragraph = new UParagraph(me.getName(), refOption.textOption);
			paragraph.setIndentionLeft(2);
			parent.add(paragraph);	
			
			if (layoutOptions.alwaysShowDescription)
				addDescription(parent, me.getDescription());
		}
	}
	
	private void renderBulletedList (			
			UCompositeSection parent, 
			EList<ModelElement> objectList,
			EStructuralFeature feature,
			ListOption listOpion,
			ReferenceOption refOption) {
		
		for (ModelElement me : objectList) {
			TemplateSaveHelper.meCount++;
			UParagraph paragraph = new UParagraph(listOpion.bullet + " " + 
					me.getName(), refOption.textOption);
			paragraph.setIndentionLeft(2);
			parent.add(paragraph);	
			
			if (layoutOptions.alwaysShowDescription)
				addDescription(parent, me.getDescription());
		}	
	}
	
	private void addDescription(UCompositeSection parent, String descriptionText) {
		UParagraph description = new UParagraph(
				descriptionText, 
				layoutOptions.defaultTextOption
			);		
		description.setIndentionLeft(3);
		parent.add(description);
	}
}
