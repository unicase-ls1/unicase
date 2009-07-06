/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.document.impl.LeafSectionImpl;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Document Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultDocumentRendererImpl extends DocumentRendererImpl implements DefaultDocumentRenderer {
	
	private Template template;
	private UCompositeSection doc;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultDocumentRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_DOCUMENT_RENDERER;
	}

	//begin custom code
	/**
	 * Renders a document of the ModelElement modelElement using the Template template.
	 * The rendered Document will be returned containing all information needed to use a DocWriter.
	 */
	public UCompositeSection render(
		ModelElement modelElement, 
		Template template) {
		
		this.template = template;
		template.initiateRenderedModelElements();
		setDoc(new URootCompositeSection());
		getDoc().setOption(
				template.getLayoutOptions()
			);
		
		UParagraph coverPage = new UParagraph(template.getLayoutOptions().getCoverText());
		coverPage.setOption(template.getLayoutOptions().getCoverTextTextOption());
		getDoc().add(coverPage);
		
		if (modelElement instanceof CompositeSection) {
			renderDocCompositeSection((CompositeSection)modelElement, template.getLayoutOptions());
		} else if (modelElement instanceof LeafSection) {
			renderDocLeafSection((LeafSectionImpl)modelElement, template.getLayoutOptions());
		} else {
			renderModelElement(getDoc(), modelElement);
		}

		return getDoc();
	}

	/**
	 * Renders a LeafSection as the first section of the document. There won't be an USection for 
	 * the LeafSection. The Main chapters of the rendered Document will be the modelElements contained
	 * in this LeafSection.
	 */
	private void renderDocLeafSection(LeafSectionImpl modelElement, LayoutOptions layoutOptions) {
		
		USection section = new USection(
				modelElement.getName(), 
				layoutOptions.getSectionTextOption()
			);
		getDoc().add(section);
				
		section.add(new UParagraph(WorkspaceUtil.cleanFormatedText(modelElement.getDescription()) + "\n", layoutOptions.getDefaultTextOption()));
		
		EList<ModelElement>  subSections = modelElement.getModelElements();
		for (ModelElement child : subSections) {
			renderModelElement(section, child);
		}
	}
	
	/**
	 * Renders a CompositeSection as the first section of the document. Therefore there won't be an USection
	 * for the CompositeSection. The Main chapters of the rendered document will be the sub sections of the
	 * CompositeSection.
	 */
	private void renderDocCompositeSection(CompositeSection modelElement, LayoutOptions layoutOptions) {
		USection section = new USection(
				modelElement.getName(),
				layoutOptions.getSectionTextOption()
			);
		getDoc().add(section);
		section.add(new UParagraph(WorkspaceUtil.cleanFormatedText(modelElement.getDescription()) + "\n", layoutOptions.getDefaultTextOption()));
		
		EList<Section>  subSections = modelElement.getSubsections();
		for (Section child : subSections) {
			if (child instanceof LeafSection) {
				renderLeafSection(section, (LeafSection) child, layoutOptions);
			} else { //instanceof CompositeSection
				renderCompositeSection(section, (CompositeSection)child, layoutOptions);
			}
		}		
		
	}

	/**
	 * renders a composite section recursivly until a LeafSection appears. Then the LeafSection renderer is called.
	 */
	private void renderCompositeSection(
			UCompositeSection parent, 
			CompositeSection compositeSection,
			LayoutOptions layoutOptions) {
	
	
		USection section = new USection(
					compositeSection.getName(), 
					layoutOptions.getSectionTextOption()
				);
			parent.add(section);
		
			
		section.add(new UParagraph(
				WorkspaceUtil.cleanFormatedText(compositeSection.getDescription()) + "\n", 
				layoutOptions.getDefaultTextOption())
			);
		
		
		EList<Section>  subSections = compositeSection.getSubsections();
		for (Section child : subSections) {
			if (child instanceof LeafSection) {
				renderLeafSection(section, (LeafSection) child, layoutOptions);
			} else { //instanceof CompositeSection
				renderCompositeSection(section, (CompositeSection)child, layoutOptions);
			}
		}
	}

	/**
	 * Renders the LeafSection with a new USection and renders the containing modelElements
	 */
	private void renderLeafSection(
			UCompositeSection parent, 
			LeafSection leafSection,
			LayoutOptions layoutOptions) {
	
		UCompositeSection section = new USection(
				leafSection.getName(), 
				layoutOptions.getSectionTextOption()
			);
		parent.add(section);
	
			
			
		section.add(new UParagraph(
				WorkspaceUtil.cleanFormatedText(leafSection.getDescription()) + "\n", 
				layoutOptions.getDefaultTextOption())
			);	
		
		EList<ModelElement>  subSections = leafSection.getModelElements();
		for (ModelElement child : subSections) {
			renderModelElement(section, child);
		}
	}

	/**
	 * Render the ModelElement using the Renderer defined in the modelElementRendererMappings.
	 */
	private void renderModelElement(UCompositeSection parent, ModelElement modelElement) {
		ModelElementRenderer renderer = getRenderer(modelElement.eClass());
		if (renderer != null) {
			try {
				renderer.render(modelElement, parent);
			} catch (Exception e) {
				WorkspaceUtil.log(
						"Error in the renderer " + renderer.getClass().getSimpleName(), 
						e, 
						IStatus.ERROR
					);
			}
			template.addRenderedModelElement(modelElement);
		}
	}
	
	private ModelElementRenderer getRenderer(EClass eClass) {
		for (ModelElementRendererMapping mapping: template.getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(eClass.getName()))
				return mapping.getRenderer();
		}
		
//		WorkspaceUtil.log(
//				"There is no render for the modelElement type " + eClass().getName(), 
//				new Exception(), 
//				IStatus.WARNING
//			);
//		return DefaultModelElementRendererBuilder.build(eClass, template);
		
		return ModelElementRendererRegistry.getDefaultSpecialModelElementRenderer(eClass, template);
	}
	
	
	
	/**
	 * @param doc the doc to set
	 */
	protected void setDoc(UCompositeSection doc) {
		this.doc = doc;
	}
	
	/**
	 * @return the doc
	 */
	protected UCompositeSection getDoc() {
		return doc;
	}	
	//end custom code

} //DefaultDocumentRendererImpl
