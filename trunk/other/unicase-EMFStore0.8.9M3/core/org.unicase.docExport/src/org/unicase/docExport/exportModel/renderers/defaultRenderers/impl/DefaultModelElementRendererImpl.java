/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Default Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class DefaultModelElementRendererImpl extends ModelElementRendererImpl implements DefaultModelElementRenderer {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefaultModelElementRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_MODEL_ELEMENT_RENDERER;
	}

	// begin custom code

	/**
	 * Renders a ModelElement into the UCompositeSection parent.
	 */
	@Override
	public void doRender(EObject eObject, UCompositeSection parent) {

		FeatureOrdering ordering = orderFeatures(eObject);

		USection modelElementSection = new USection();
		parent.add(modelElementSection);

		initSection(modelElementSection, eObject);

		if (eObject instanceof UnicaseModelElement) {
			renderTitleAndDescription((UnicaseModelElement) eObject, modelElementSection, false);
		}

		if (eObject instanceof MEDiagram) {
			renderDiagram(((MEDiagram) eObject).getGmfdiagram(), modelElementSection);
			return;
		}

		if (getDiagram(eObject) != null) {
			Diagram diagram = getDiagram(eObject);
			renderDiagram(diagram, modelElementSection);
		}

		renderPropertiesTable(ordering.singleProperties, ordering.multiProperties, eObject, modelElementSection);

		renderMutliProperties(ordering.multiPropertiesOutsideOfTable, eObject, modelElementSection);

		renderContainedProperties(ordering.containedProperties, eObject, modelElementSection);
		renderContainedProperties(ordering.specialRendererProperties, eObject, modelElementSection);

		EList<EObject> tmp = eObject.eContents();
		ArrayList<EObject> remainingContainedModelElements = new ArrayList<EObject>(tmp);
		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.containedProperties, eObject);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.specialRendererProperties, eObject);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.multiProperties, eObject);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.multiPropertiesOutsideOfTable,
			eObject);

	}

	private Diagram getDiagram(EObject eObject) {
		for (EObject content : eObject.eContents()) {
			if (content instanceof Diagram) {
				return (Diagram) content;
			}
		}
		return null;
	}

	private void initSection(USection modelElementSection, EObject eObject) {
		modelElementSection.getBoxModel().setMarginTop(SECTION_MARGIN_TOP);
		modelElementSection.getBoxModel().setMarginBottom(SECTION_MARGIN_BOTTOM);

		int indentionLeft = 0;
		// Every ModelElement has an indention to the left, if it isn't the first Section
		// of the document. This happens, if a single ModelElement is rendered to the whole
		// document.
		if (modelElementSection.getParent() instanceof USection) {
			indentionLeft++;
		}
		modelElementSection.setIndentionLeft(indentionLeft);

		modelElementSection.getBoxModel().setMarginLeft(INDENTION_WIDTH * modelElementSection.getIndentionLeft());
		// ModelElements, which have a depth greater than 2 of the document sectioning, a left
		// border is added, to structure the range of the ModelElement clearly.
		// The border size of contained ModelElements decrease by the Section depth.
		if (mayRenderStructuralLine(eObject)) {
			double borderSize = SECTION_INITIAL_BORDER_SIZE / (modelElementSection.getDepth());
			modelElementSection.getBoxModel().setBorderLeft(borderSize);
			modelElementSection.getBoxModel().setBorderStyle(UBorderStyle.GROOVE);
			modelElementSection.getBoxModel().setPaddingLeft(SECTION_LEFT_BORDER_PADDING);
		}

		// There is no section numbering for ModelElements
		modelElementSection.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		modelElementSection.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);

		UParagraph titleParagraph = new UParagraph(getText(eObject));
		if (getTemplate().getLayoutOptions().isShowModelElementTypeInSectionTitle()) {
			UTextPart modelElementType = new UTextPart(" [" + eObject.eClass().getName() + "]", getTemplate()
				.getLayoutOptions().getDefaultTextOption());
			modelElementType.getOption().setItalics(true);
			modelElementType.getOption().setFontSize(modelElementType.getOption().getFontSize() - 2);
			titleParagraph.add(modelElementType);
		}

		titleParagraph.setOption(getTemplate().getLayoutOptions().getModelElementTextOption());
		modelElementSection.setTitle(titleParagraph);

	}

	/**
	 * A Diagram needs to be rendered into the document as an image. Therefore, the GMF diagram must be exported
	 * temporarily to an image format like SVG. Then the image must be added to the section of the ModelElement and must
	 * be fit to the page size.
	 * 
	 * @param modelElement the ModelElement which contains a GMF diagram
	 * @param parent the parent section where the diagram shall be rendered.
	 */
	private void renderDiagram(final Diagram diagram, final USection parent) {

		try {
			final File tmpImage = File.createTempFile(EcoreUtil.generateUUID(), ".jpeg");

			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					final CopyToImageUtil util = new CopyToImageUtil();

					new EMFStoreCommand() {

						@Override
						protected void doRun() {
							try {
								// DiagramEditPart editPart = util.createDiagramEditPart(diagram, shell,
								// PreferencesHint.USE_DEFAULTS);
								// Assert.isNotNull(editPart.getDiagramView().getDiagram());
								// Assert.isNotNull(editPart);
								util.copyToImage(diagram, new Path(tmpImage.toString()), ImageFileFormat.JPEG,
									new NullProgressMonitor(), PreferencesHint.USE_DEFAULTS);
							} catch (CoreException e) {
								WorkspaceUtil.log("Exception while loading the diagram.", e, IStatus.WARNING);
							} catch (RuntimeException e) {
								WorkspaceUtil.log(
									"Exception while converting diagram into an image. Diagram is probably corrupt.",
									e, IStatus.WARNING);
							}
						}
					}.run();
				}
			});

			addDiagramUImage(parent, diagram, tmpImage);

		} catch (IOException e1) {
			WorkspaceUtil.log("Diagram image rendering error", e1, IStatus.WARNING);
		}
	}

	private void addDiagramUImage(USection parent, final Diagram diagram, final File tmpImage) {
		UImage image = new UImage(new Path(tmpImage.toString()));
		image.getBoxModel().setBorder(0.5);
		image.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		image.setFitToPage(true);
		parent.add(image);

		UParagraph label = new UParagraph(diagram.getType() + ": " + getText(diagram.eContainer()), template
			.getLayoutOptions().getDefaultTextOption());
		label.getOption().setTextAlign(TextAlign.CENTER);
		label.getBoxModel().setMarginTop(5);
		parent.add(label);
	}

	/**
	 * There are multi reference properties, which shall not be rendered in the properties table, but in an own sub
	 * paragraph as a list or something different.
	 * 
	 * @param multiPropertiesOutsideOfTable properties of the ModelElement, which shall be rendered outside of the
	 *            properties table
	 * @param eObject the modelElement containing the information of the property
	 * @param modelElementSection the section of the ModelElement
	 */
	@SuppressWarnings("unchecked")
	private void renderMutliProperties(Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable, EObject eObject,
		USection modelElementSection) {

		for (IItemPropertyDescriptor propertyDescriptor : multiPropertiesOutsideOfTable) {
			UParagraph propertiesHeader = new UParagraph(propertyDescriptor.getDisplayName(eObject) + ": ", template
				.getLayoutOptions().getModelElementTextOption());
			modelElementSection.add(propertiesHeader);

			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);
			String attributeName;
			// If there is no special name for the attribute of the attribute, use the properties display name
			if (getAttributeRendererNotNull(feature).getAttributeOption().getAttributeText().equals("")) {
				attributeName = propertyDescriptor.getDisplayName(eObject);
			} else {
				attributeName = getAttributeRenderer(feature).getAttributeOption().getAttributeText();
			}

			modelElementSection.add(new UParagraph(attributeName));

			EList<UnicaseModelElement> objectList = (EList<UnicaseModelElement>) eObject.eGet(feature);

			MultiReferenceAttributeOption referenceOption = (MultiReferenceAttributeOption) getAttributeRendererNotNull(
				feature).getAttributeOption();
			ListOption listOption = referenceOption.getListOption();
			UList list = new UList(listOption, template.getLayoutOptions().getDefaultTextOption());

			for (UnicaseModelElement me : objectList) {
				list.add(me.getName());
			}

			modelElementSection.add(list);
		}
	}

	@SuppressWarnings("unchecked")
	private void removeAlreadyRenderedModelElements(ArrayList<EObject> remainingContainedModelElements,
		Vector<IItemPropertyDescriptor> containedProperties, EObject eObject) {

		for (IItemPropertyDescriptor propertyDescriptor : containedProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);
			if (feature.isMany()) {
				EList<UnicaseModelElement> objectList = (EList<UnicaseModelElement>) eObject.eGet(feature);

				for (EObject referencedObject : objectList) {
					remainingContainedModelElements.remove(referencedObject);
				}
			} else {
				remainingContainedModelElements.remove(eObject.eGet(feature));
			}
		}
	}

	/**
	 * Contained properties (attributes) are just rendered in a their own renderer.
	 */
	private void renderContainedProperties(Vector<IItemPropertyDescriptor> properties, EObject eObject,
		UCompositeSection parent) {

		for (IItemPropertyDescriptor propertyDescriptor : properties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);

			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(feature, eObject, parent, getTemplate());
		}
	}

	// end custom code

} // DefaultModelElementRendererImpl
