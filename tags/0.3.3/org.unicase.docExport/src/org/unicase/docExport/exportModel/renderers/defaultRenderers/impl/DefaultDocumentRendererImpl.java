/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTableOfContents;
import org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
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
	private URootCompositeSection doc;
	
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
		setDoc(new URootCompositeSection());
		getDoc().setLayoutOptions(
				template.getLayoutOptions()
			);
		
		getDoc().getLayoutOptions().setFooterText(modelElement.getName());
		
		UImage logo = new UImage(new Path(TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getLogoImage()));
		getDoc().add(logo);
		logo.setCenter(true);
		logo.getBoxModel().setMarginBottom(15);
		
//		UParagraph coverPage = new UParagraph(template.getLayoutOptions().getCoverText());
//		coverPage.setOption(template.getLayoutOptions().getCoverTextTextOption());
//		getDoc().add(coverPage);
		
		if (modelElement instanceof CompositeSection) {
			renderDocCompositeSection(
					(CompositeSection)modelElement, 
					template.getLayoutOptions()
				);
		} else if (modelElement instanceof LeafSection) {
			renderDocLeafSection(
					(LeafSectionImpl)modelElement, 
					template.getLayoutOptions()
				);
		} else {
			renderModelElement(getDoc(), modelElement);
		}
		
		if (template.getLayoutOptions().getAppendixStyle().equals(AppendixStyle.SHOW_FLAT)) {
			renderAppendix();
		}

		return getDoc();
	}
	
	private void renderAppendix() {
		ArrayList<ModelElement> linkedModelElements = new ArrayList<ModelElement>();
		linkedModelElements.addAll(DocumentExport.getLinkedModelElements());
		USection appendix = new USection(
				"Appendix", 
				template.getLayoutOptions().getDocumentTitleTextOption()
			);
		appendix.getBoxModel().setBreakBefore(true);
		appendix.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);
		
		//make sure, that the appendix section is added to the CompositeSection if 
		//a Composite Section is exported. If you don't do this, the Appendix won't
		//appear in the Table of Contents
		if (getDoc().getChildren().get(0) instanceof UCompositeSection) {
			((UCompositeSection) getDoc().getChildren().get(0)).add(appendix);
		} else {
			getDoc().add(appendix);	
		}

		for (ModelElement me : linkedModelElements) {
			template.getModelElementRendererNotNull(me.eClass(), template).render(me, appendix);
		}
	}

	/**
	 * Renders a LeafSection as the first section of the document. There won't be an USection for 
	 * the LeafSection. The Main chapters of the rendered Document will be the modelElements contained
	 * in this LeafSection.
	 */
	private void renderDocLeafSection(LeafSectionImpl modelElement, LayoutOptions layoutOptions) {
		USection section = new USection(
				"  " + modelElement.getName(), 
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
				layoutOptions.getDocumentTitleTextOption()
			);
		getDoc().add(section);
		UParagraph descr = new UParagraph(
				WorkspaceUtil.cleanFormatedText(modelElement.getDescription()), 
				layoutOptions.getDefaultTextOption()
			);
		section.add(descr);
		descr.getBoxModel().setMarginTop(10);
		descr.getOption().setTextAlign(TextAlign.JUSTIFY);
		
		UTableOfContents toc = new UTableOfContents(section, layoutOptions.getDefaultTextOption());
		section.add(toc);
		
		EList<Section>  subSections = modelElement.getSubsections();
		boolean first = true;
		for (Section child : subSections) {
			if (child instanceof LeafSection) {
				renderLeafSection(section, (LeafSection) child, layoutOptions, first);
			} else { //instanceof CompositeSection
				renderCompositeSection(section, (CompositeSection)child, layoutOptions, first);
			}
			first = false;
		}		
		
	}

	/**
	 * renders a composite section recursivly until a LeafSection appears. Then the LeafSection renderer is called.
	 */
	private void renderCompositeSection(
			UCompositeSection parent, 
			CompositeSection compositeSection,
			LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {
	
		renderSection(parent, compositeSection, layoutOptions, firstChapterOfDocument);
	}

	/**
	 * Renders the LeafSection with a new USection and renders the containing modelElements
	 */
	private void renderSection(
			UCompositeSection parent, 
			ModelElement modelElementSection,
			LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {
		
		USection section = new USection(
				"  " + modelElementSection.getName(),
				layoutOptions.getSectionTextOption()
			);
		parent.add(section);
		section.getBoxModel().setBreakBefore(firstChapterOfDocument);
		
		section.getBoxModel().setMarginTop(35);
		section.getBoxModel().setMarginBottom(15);
	
		if (section.getDepth() > 1 && section.getDepth() < 4) {
			section.getTitlParagraph().getOption().setFontSize(
					layoutOptions.getSectionTextOption().getFontSize() 
					- layoutOptions.getSectionFontSizeDecreaseStep() * section.getDepth()
				);
		}

		UParagraph description = new UParagraph(
				WorkspaceUtil.cleanFormatedText(modelElementSection.getDescription()) + "\n", 
				layoutOptions.getDefaultTextOption()
			);
		description.getBoxModel().setKeepWithPrevious(true);
		section.add(description);	
		
		if (modelElementSection instanceof LeafSection) {
			EList<ModelElement>  subSections = ((LeafSection) modelElementSection).getModelElements();
			for (ModelElement child : subSections) {
				if (child instanceof LeafSection) {
					renderSection(section, child, layoutOptions, false);
				} else {
					renderModelElement(section, child);		
				}
			}		
		}
		if (modelElementSection instanceof CompositeSection) {
			EList<Section>  subSections = ((CompositeSection) modelElementSection).getSubsections();
			for (Section child : subSections) {
				if (child instanceof LeafSection) {
					renderLeafSection(section, (LeafSection) child, layoutOptions, false);
				} else { //instanceof CompositeSection
					renderCompositeSection(section, (CompositeSection)child, layoutOptions, false);
				}
			}
		}
	
	}
	
	/**
	 * Renders the LeafSection with a new USection and renders the containing modelElements
	 */
	private void renderLeafSection(
			UCompositeSection parent, 
			LeafSection leafSection,
			LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {
		renderSection(parent, leafSection, layoutOptions, firstChapterOfDocument);
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
		}
	}
	
	private ModelElementRenderer getRenderer(EClass eClass) {
		for (ModelElementRendererMapping mapping: template.getModelElementRendererMapping()) {
			if (mapping.getEClassName().equals(eClass.getName())) {
				return mapping.getRenderer();
			}
		}

		return ModelElementRendererRegistry.getDefaultSpecialModelElementRenderer(eClass, template);
	}
	
	
	
	/**
	 * @param doc the doc to set
	 */
	protected void setDoc(URootCompositeSection doc) {
		this.doc = doc;
	}
	
	/**
	 * @return the doc
	 */
	protected URootCompositeSection getDoc() {
		return doc;
	}	
	//end custom code

} //DefaultDocumentRendererImpl
