/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.model.ModelElement;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Attribute Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultAttributeRendererImpl extends AttributeRendererImpl implements DefaultAttributeRenderer {
	
	private LayoutOptions layoutOptions;
	private Template template;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultAttributeRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_ATTRIBUTE_RENDERER;
	}

	//begin custom code
	/**
	 * renders an attribute (feature) of a modelElement and adds it to the USection parent of the modelELement.
	 * The rendering strongly depends on the type of the attribute: EAttribute, single EReference and multi EReference.
	 */
	public void render(EStructuralFeature feature, ModelElement modelElement,
			UCompositeSection parent, Template template) {
		this.layoutOptions = template.getLayoutOptions();
		this.template = template;
		
		if (getAttributeOption().isHide()) {
			return;
		}
		
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
		Object content = modelElement.eGet(feature);
		if (feature.eClass().getInstanceClass().equals(EAttribute.class)) {
			if (content != null) {
				renderSimpleAttribute(content, parent, feature);
			}
		} else { //EReference	
			if (content != null) {
				if (((SingleReferenceAttributeOption)getAttributeOption()).isContained() ) {
					renderContainedReference((ModelElement)content, parent, feature);
					template.addRenderedModelElement((ModelElement) content);
				} else {
					renderLinkedReference((ModelElement)content, parent, feature);
				}
			}
		}
	}

	private void renderSimpleAttribute(
			Object content, 
			UCompositeSection parent, 
			EStructuralFeature feature
		) {
		
		if (getAttributeOption() instanceof StringAttributeOption) {
			StringAttributeOption option = (StringAttributeOption) getAttributeOption();
			UParagraph name = new UParagraph(
					"" + feature.getName() + ": " + 
					content.toString(), 
					option.getTextOption()
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
		
		

		String text = "" + feature.getName() + ": " + 
		content.getName();
		
		if (getAttributeOption() instanceof MultiReferenceAttributeOption) {
			MultiReferenceAttributeOption option2 = (MultiReferenceAttributeOption) getAttributeOption();
			ListOption listOption = option2.getListOption();
			
			if (listOption. getListStyle() == ListStyle.BULLETED) {
				text = "- " + content.getName();
			} else if (listOption.getListStyle() == ListStyle.SEPERATED_LIST) {
				text = content.getName() + ", ";
			} else if (listOption.getListStyle() == ListStyle.JUST_NEW_LINES) {
				//nothing?!
			}
		}	
		
		
		UParagraph name = new UParagraph(
				text, 
				layoutOptions.getDefaultTextOption()
			);
		name.setIndentionLeft(1);
		parent.add(name);
		
		if (false) {
			addDescription(parent, content.getDescriptionPlainText());
		}
	}

	private void renderContainedReference(
			ModelElement content, 
			UCompositeSection attributeSection, 
			EStructuralFeature feature
		) {
		
		ModelElementRenderer renderer = getModelElementRenderer(content.eClass());
		try {
			renderer.render(content, attributeSection);
		} catch (Exception e) {
			WorkspaceUtil.log(
					"Error in the renderer " + renderer.getClass().getSimpleName(), 
					e, 
					IStatus.ERROR
				);
		}
		
	}
	
	private ModelElementRenderer getModelElementRenderer(EClass eClass) {
		for (ModelElementRendererMapping mapping : template.getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(eClass.getName()))
				return mapping.getRenderer();
		}
		return null;
	}

	private ReferenceOption getRefenceOption (AttributeOption option) {
		if (option instanceof MultiReferenceAttributeOption) {
			return ((MultiReferenceAttributeOption)option).getReferenceOption();
		}
		else if (option instanceof SingleReferenceAttributeOption) {
			return ((SingleReferenceAttributeOption)option).getReferenceOption();
		}
		return OptionsFactory.eINSTANCE.createReferenceOption();
	}
	
	
	/**
	 * renders an attribute with can have more than one reference to a modelElement.
	 */
	@SuppressWarnings("unchecked")
	private void renderMultiFeature(
			EStructuralFeature feature,
			ModelElement modelElement, 
			UCompositeSection parent) {
		
		MultiReferenceAttributeOption option = (MultiReferenceAttributeOption) getAttributeOption();
		ListOption listOption = option.getListOption();
		
		ReferenceOption refOption = getRefenceOption(getAttributeOption());
		
		Object attributeValue = modelElement.eGet(feature);

		if (attributeValue instanceof EList) {
			EList<ModelElement> objectList = (EList<ModelElement>)attributeValue;

			if (((ReferenceAttributeOption) getAttributeOption()).isContained()) {
				for (ModelElement me : objectList) {
					renderContainedReference(me, parent, feature);
				}				
			} else { 
				renderList(parent, objectList, feature, listOption, refOption);
			}
		}
	}
	
	private void renderList (
			UCompositeSection parent, 
			EList<ModelElement> objectList,
			EStructuralFeature feature,
			ListOption listOpion,
			ReferenceOption refOption) {
		

		
		UList list = new UList(listOpion, template.getLayoutOptions().getSectionTextOption());
		list.setIndentionLeft(1);
		
		for (ModelElement me : objectList) {
			list.add(me.getName());
		}

		UParagraph head = new UParagraph(
				feature.getName(),
				template.getLayoutOptions().getSectionTextOption()
			);
		head.setIndentionLeft(1);
		
		if (objectList.size() > 0) {
			parent.add(head);
			parent.add(list);
		}
	}
	
	private void addDescription(UCompositeSection parent, String descriptionText) {
		UParagraph description = new UParagraph(
				descriptionText, 
				layoutOptions.getDefaultTextOption()
			);		
		description.setIndentionLeft(3);
		parent.add(description);
	}
	//end custom code

} //DefaultAttributeRendererImpl
