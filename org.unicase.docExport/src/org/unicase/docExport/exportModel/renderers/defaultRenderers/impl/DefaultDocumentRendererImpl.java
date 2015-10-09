/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.util.ArrayList;
import java.util.Calendar;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.Workspace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UPageNumber;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTableOfContents;
import org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.document.impl.LeafSectionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Default Document Renderer</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultDocumentRendererImpl extends DocumentRendererImpl implements
		DefaultDocumentRenderer {

	private Template template;
	private URootCompositeSection doc;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefaultDocumentRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_DOCUMENT_RENDERER;
	}

	// begin custom code
	public URootCompositeSection render(UnicaseModelElement modelElement,
			Template template) {

		if (!(modelElement instanceof LeafSection)
				&& !(modelElement instanceof CompositeSection)) {
			template = EcoreUtil.copy(template);

			// hiding the header and footer on a document without and document
			// structure is not good.
			template.getLayoutOptions()
					.setHideHeaderAndFooterOnCoverPage(false);
		}

		this.template = template;
		URootCompositeSection root = new URootCompositeSection();
		setHeader(root);
		setFooter(root, modelElement);
		setDoc(root);
		getDoc().setLayoutOptions(template.getLayoutOptions());

		if (template.getLayoutOptions().getHeaderStyle()
				.equals(HeaderStyle.ONLY_TEXT)) {
			UImage logo = new UImage(new Path(
					TemplateRegistry.TEMPLATE_IMAGE_FOLDER
							+ template.getLayoutOptions().getLogoImage()));
			logo.setWidth(template.getLayoutOptions().getLogoWidth());
			logo.setHeight(template.getLayoutOptions().getLogoHeight());
			getDoc().add(logo);
			logo.setTextAlign(TextAlign.CENTER);
			logo.getBoxModel().setMarginBottom(15);
		}

		if (modelElement instanceof CompositeSection) {
			try {
				renderDocCompositeSection((CompositeSection) modelElement,
						template.getLayoutOptions());
			} catch (UnkownProjectException e) {
				ModelUtil.logException("Failed to receive project!", e);
			}
		} else if (modelElement instanceof LeafSection) {
			renderDocLeafSection((LeafSectionImpl) modelElement,
					template.getLayoutOptions());
		} else {
			if (DocumentExport.isTreatModelElementAsLeafSection()) {
				for (EObject content : modelElement.eContents()) {
					renderModelElement(getDoc(), content);

				}
			} else {
				renderModelElement(getDoc(), modelElement);
			}
		}

		if (template.getLayoutOptions().getAppendixStyle()
				.equals(AppendixStyle.SHOW_FLAT)) {
			renderAppendix();
		}

		URef lastPage = new URef("last_page");
		getDoc().add(lastPage);
		return getDoc();
	}

	private void setFooter(URootCompositeSection root,
			UnicaseModelElement modelElement) {

		UTable footerTable = new UTable(3);
		root.setFooter(footerTable);

		UTableCell leftCell = new UTableCell("");
		UTableCell middleCell = new UTableCell("");
		UTableCell rightCell = new UTableCell("");
		footerTable.add(leftCell);
		footerTable.add(middleCell);
		footerTable.add(rightCell);

		if (template.getLayoutOptions().isFooterShowDocumentTitle()) {
			UParagraph docTitle = new UParagraph(modelElement.getName(),
					template.getLayoutOptions().getFooterTextOption());
			docTitle.getOption().setTextAlign(TextAlign.CENTER);
			middleCell.setContent(docTitle);
		}

		if (template.getLayoutOptions().getFooterText() != null
				&& !template.getLayoutOptions().getFooterText().equals("")) {
			UParagraph footerText = new UParagraph(template.getLayoutOptions()
					.getFooterText(), template.getLayoutOptions()
					.getFooterTextOption());
			footerText.getOption().setTextAlign(TextAlign.START);
			leftCell.setContent(footerText);
		}

		ULink footerLink = new ULink("", "table_of_contents");
		rightCell.setContent(footerLink);
		footerLink.setHideLinkedPage(true);
		footerLink.setOption(template.getLayoutOptions().getFooterTextOption());
		footerLink.getOption().setTextAlign(TextAlign.END);
		UPageNumber pageNumbering = new UPageNumber(template.getLayoutOptions()
				.getPageCitationStyle());
		footerLink.add(pageNumbering);
	}

	private void setHeader(URootCompositeSection root) {
		HeaderStyle headerStyle = template.getLayoutOptions().getHeaderStyle();

		UParagraph headerContainer = new UParagraph("");
		root.setHeader(headerContainer);

		// This is a hack for margin top of the header region.
		// Apache FOP doesn't render the extend attribute of the
		// fo:xsl-region-before
		UImage marginTop = new UImage(new Path("i_do_not_exist"));
		headerContainer.add(marginTop);
		marginTop.setHeight(15);

		if (headerStyle.equals(HeaderStyle.ONLY_TEXT)) {
			UParagraph header = new UParagraph(template.getLayoutOptions()
					.getHeaderText(), template.getLayoutOptions()
					.getHeaderTextOption());
			headerContainer.add(header);
		} else if (headerStyle.equals(HeaderStyle.TEXT_AND_LOGO)) {
			UTable headerTable = new UTable(2);

			UParagraph header = new UParagraph(template.getLayoutOptions()
					.getHeaderText(), template.getLayoutOptions()
					.getHeaderTextOption());

			UImage logo = new UImage(new Path(
					TemplateRegistry.TEMPLATE_IMAGE_FOLDER
							+ template.getLayoutOptions().getLogoImage()));
			logo.setWidth(template.getLayoutOptions().getLogoWidth());
			logo.setHeight(template.getLayoutOptions().getLogoHeight());
			logo.setTextAlign(TextAlign.END);
			UTableCell leftCell = new UTableCell(header);
			UTableCell rightCell = new UTableCell(logo);
			headerTable.add(leftCell);
			headerTable.add(rightCell);

			headerContainer.add(headerTable);
		} else {
			WorkspaceUtil.log("The HeaderStyle " + headerStyle
					+ "isn't implemented yet", new Exception(), IStatus.ERROR);
		}
	}

	private void renderAppendix() {
		ArrayList<EObject> linkedModelElements = new ArrayList<EObject>();
		linkedModelElements.addAll(DocumentExport.getLinkedModelElements());
		if (linkedModelElements.size() < 1) {
			return;
		}
		USection appendix = new USection("Appendix", template
				.getLayoutOptions().getDocumentTitleTextOption());
		appendix.getBoxModel().setBreakBefore(true);
		appendix.getSectionOption().setSectionNumberingStyle(
				SectionNumberingStyle.NONE);

		// make sure, that the appendix section is added to the CompositeSection
		// if
		// a Composite Section is exported. If you don't do this, the Appendix
		// won't
		// appear in the Table of Contents
		if (getDoc().getChildren().get(0) instanceof UCompositeSection) {
			((UCompositeSection) getDoc().getChildren().get(0)).add(appendix);
		} else {
			getDoc().add(appendix);
		}

		for (EObject eObject : linkedModelElements) {
			template.getModelElementRendererNotNull(eObject.eClass(), template)
					.render(eObject, appendix);
		}
	}

	/**
	 * Renders a LeafSection as the first section of the document. There won't
	 * be an USection for the LeafSection. The Main chapters of the rendered
	 * Document will be the modelElements contained in this LeafSection.
	 */
	private void renderDocLeafSection(LeafSectionImpl modelElement,
			LayoutOptions layoutOptions) {
		USection section = new USection("  " + modelElement.getName(),
				layoutOptions.getSectionTextOption());
		getDoc().add(section);

		section.add(new UParagraph(DocumentExport
				.cleanFormatedText(modelElement.getDescription()) + "\n",
				layoutOptions.getDefaultTextOption()));

		EList<EObject> subSections = modelElement.getModelElements();
		for (EObject child : subSections) {
			renderModelElement(section, child);
		}
	}

	/**
	 * Renders a CompositeSection as the first section of the document.
	 * Therefore there won't be an USection for the CompositeSection. The Main
	 * chapters of the rendered document will be the sub sections of the
	 * CompositeSection.
	 * 
	 * @throws UnkownProjectException
	 *             if receiving the project failed
	 */
	private void renderDocCompositeSection(CompositeSection modelElement,
			LayoutOptions layoutOptions) throws UnkownProjectException {
		Workspace currentWorkspace = ESWorkspaceProviderImpl.getInstance()
				.getInternalWorkspace();
		ProjectSpace ps = currentWorkspace.getProjectSpace(ModelUtil
				.getProject(modelElement));

		if (layoutOptions.isLogoOnCoverPage()) {
			UImage logo = new UImage(new Path(
					TemplateRegistry.TEMPLATE_IMAGE_FOLDER
							+ layoutOptions.getLogoImage()));
			getDoc().add(logo);
			logo.setTextAlign(TextAlign.CENTER);
			logo.setWidth(200);
			logo.getBoxModel().setMargin(15);
		}

		USection section = new USection(modelElement.getName(),
				layoutOptions.getDocumentTitleTextOption());
		getDoc().add(section);
		UParagraph descr = new UParagraph(
				DocumentExport.cleanFormatedText(modelElement.getDescription()),
				layoutOptions.getDefaultTextOption());
		section.add(descr);

		String date = "";
		Calendar now = Calendar.getInstance();
		date += now.get(Calendar.DAY_OF_MONTH);
		date += "." + (now.get(Calendar.MONTH) + 1);
		date += "." + now.get(Calendar.YEAR);

		UTable documentInfo = new UTable(2);
		section.add(documentInfo);
		documentInfo.setDefaultTextOption(layoutOptions.getDefaultTextOption());
		documentInfo.getBoxModel().setMarginLeft(130);
		documentInfo.getBoxModel().setMarginTop(15);

		UParagraph project = new UParagraph("Project:",
				layoutOptions.getDefaultTextOption());
		project.getOption().setTextAlign(TextAlign.END);
		project.getBoxModel().setMarginRight(8);
		documentInfo.add(project);
		documentInfo.add(ps.getProjectName());

		UParagraph unicaseVersion = new UParagraph("Project version:",
				layoutOptions.getDefaultTextOption());
		unicaseVersion.getOption().setTextAlign(TextAlign.END);
		unicaseVersion.getBoxModel().setMarginRight(8);
		documentInfo.add(unicaseVersion);
		if (ps.getBaseVersion() != null) {
			documentInfo.add(String
					.valueOf(ps.getBaseVersion().getIdentifier()));
		} else {
			documentInfo.add("(local Project)");
		}

		UParagraph exportDate = new UParagraph("Export date:",
				layoutOptions.getDefaultTextOption());
		exportDate.getOption().setTextAlign(TextAlign.END);
		exportDate.getBoxModel().setMarginRight(8);
		documentInfo.add(exportDate);
		documentInfo.add(date);

		documentInfo.getBoxModel().setWidth(200);

		descr.getBoxModel().setMarginTop(10);
		descr.getOption().setTextAlign(TextAlign.JUSTIFY);

		if (!layoutOptions.isHideTableOfContents()) {
			UTableOfContents toc = new UTableOfContents(section,
					layoutOptions.getTableOfContentsTextOption());
			section.add(toc);
		}

		EList<Section> subSections = modelElement.getSubsections();
		boolean first = true;
		for (Section child : subSections) {
			if (child instanceof LeafSection) {
				renderLeafSection(section, (LeafSection) child, layoutOptions,
						first);
			} else { // instanceof CompositeSection
				renderCompositeSection(section, (CompositeSection) child,
						layoutOptions, first);
			}
			first = false;
		}

	}

	/**
	 * renders a composite section recursivly until a LeafSection appears. Then
	 * the LeafSection renderer is called.
	 */
	private void renderCompositeSection(UCompositeSection parent,
			CompositeSection compositeSection, LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {

		renderSection(parent, compositeSection, layoutOptions,
				firstChapterOfDocument);
	}

	/**
	 * Renders the LeafSection with a new USection and renders the containing
	 * modelElements
	 */
	private void renderSection(UCompositeSection parent,
			Section unicaseSection, LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {

		USection section = new USection("  " + unicaseSection.getName(),
				layoutOptions.getSectionTextOption());
		parent.add(section);
		section.getBoxModel().setBreakBefore(firstChapterOfDocument);

		section.getBoxModel().setMarginTop(35);
		section.getBoxModel().setMarginBottom(15);

		if (section.getDepth() > 1 && section.getDepth() < 4) {
			section.getTitlParagraph()
					.getOption()
					.setFontSize(
							layoutOptions.getSectionTextOption().getFontSize()
									- layoutOptions
											.getSectionFontSizeDecreaseStep()
									* section.getDepth());
		}

		UParagraph description = new UParagraph(
				DocumentExport.cleanFormatedText(unicaseSection
						.getDescription()) + "\n",
				layoutOptions.getDefaultTextOption());
		description.getBoxModel().setKeepWithPrevious(true);
		section.add(description);

		if (unicaseSection instanceof LeafSection) {
			EList<EObject> subSections = ((LeafSection) unicaseSection)
					.getModelElements();
			for (EObject child : subSections) {
				if (child instanceof LeafSection) {
					renderSection(section, (LeafSection) child, layoutOptions,
							false);
				} else {
					renderModelElement(section, child);
				}
			}
		}
		if (unicaseSection instanceof CompositeSection) {
			EList<Section> subSections = ((CompositeSection) unicaseSection)
					.getSubsections();
			for (Section child : subSections) {
				if (child instanceof LeafSection) {
					renderLeafSection(section, (LeafSection) child,
							layoutOptions, false);
				} else { // instanceof CompositeSection
					renderCompositeSection(section, (CompositeSection) child,
							layoutOptions, false);
				}
			}
		}

	}

	/**
	 * Renders the LeafSection with a new USection and renders the containing
	 * modelElements
	 */
	private void renderLeafSection(UCompositeSection parent,
			LeafSection leafSection, LayoutOptions layoutOptions,
			boolean firstChapterOfDocument) {
		renderSection(parent, leafSection, layoutOptions,
				firstChapterOfDocument);
	}

	/**
	 * Render the ModelElement using the Renderer defined in the
	 * modelElementRendererMappings.
	 */
	private void renderModelElement(UCompositeSection parent, EObject eObject) {
		ModelElementRenderer renderer = template
				.getModelElementRendererNotNull(eObject.eClass(), template);
		try {
			renderer.render(eObject, parent);
		} catch (RuntimeException e) {
			WorkspaceUtil.log("Error in the renderer "
					+ renderer.getClass().getSimpleName(), e, IStatus.ERROR);
		}
	}

	/**
	 * @param doc
	 *            the doc to set
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
	// end custom code

} // DefaultDocumentRendererImpl
