/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Default Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class DefaultModelElementRendererImpl extends ModelElementRendererImpl implements DefaultModelElementRenderer {
	private static final int DESCRIPTION_MIN_SIZE = 500;
	private static final int SECTION_DESCRIPTION_MARGIN = 10;
	private static final double SECTION_INITIAL_BORDER_SIZE = 2;
	private static final int SECTION_LEFT_BORDER_PADDING = 5;
	private static final int INDENTION_WIDTH = 15;
	private static final int SECTION_MARGIN_BOTTOM = 15;
	private static final int SECTION_MARGIN_TOP = 15;
	private static final double PROPERTIES_TABLE_BORDER_SIZE = 0.8;

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

	private class FeatureOrdering {
		public Vector<IItemPropertyDescriptor> singleProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> multiProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> containedProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> specialRendererProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable = new Vector<IItemPropertyDescriptor>();
	}

	@SuppressWarnings("unchecked")
	private FeatureOrdering orderFeatures(final ModelElement modelElement) {
		/*
		 * order the features by the following types: singleProperties: EAttribute and single ERference linked
		 * multiProperties: EReference, multi containedProperties: single EReference rendered as contained.
		 */
		Vector<IItemPropertyDescriptor> singleProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> multiProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> containedProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> specialRendererProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable = new Vector<IItemPropertyDescriptor>();

		Vector<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(modelElement);

		Collections.sort(propertyDescriptors, new Comparator() {
			public int compare(Object o1, Object o2) {
				IItemPropertyDescriptor pD1 = (IItemPropertyDescriptor) o1;
				IItemPropertyDescriptor pD2 = (IItemPropertyDescriptor) o2;

				EStructuralFeature feature1 = (EStructuralFeature) pD1.getFeature(modelElement);
				EStructuralFeature feature2 = (EStructuralFeature) pD2.getFeature(modelElement);

				AttributeRenderer renderer1 = getAttributeRendererNotNull(feature1);
				AttributeOption attributeOption1 = renderer1.getAttributeOption();

				AttributeRenderer renderer2 = getAttributeRendererNotNull(feature2);
				AttributeOption attributeOption2 = renderer2.getAttributeOption();

				if (attributeOption1 == null || attributeOption2 == null) {
					return 0;
				}
				int orderNumber1 = attributeOption1.getOrderNumber();
				int orderNumber2 = attributeOption2.getOrderNumber();

				if (orderNumber1 > orderNumber2) {
					return 1;
				} else if (orderNumber1 == orderNumber2) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);

			boolean hide;
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			AttributeOption attributeOption = renderer.getAttributeOption();
			if (attributeOption == null) {
				hide = false;
			} else {
				hide = attributeOption.isHide();
			}

			LayoutOptions layoutOptions = getTemplate().getLayoutOptions();

			/*
			 * Don't render a feature (attribute) in the following cases: 1) the feature is annotation,
			 * incomingDocumentReferences or attachments and the layoutOptions say, that they should be hidden. Normally
			 * these features are not relevant. 2) The feature is called name or description. Those features are always
			 * rendered in the title and description of the section. 3) The attributeOption hide is set to true 4) The
			 * content of the feature is empty
			 */
			if ((feature.getName().equals("annotations") && layoutOptions.isHideAnnotations())
				|| (feature.getName().equals("incomingDocumentReferences") && layoutOptions
					.isHideIncomingDocumentReferences())
				|| (feature.getName().equals("attachments") && layoutOptions.isHideAttachments())
				|| feature.getName().equals("description") || feature.getName().equals("name")
				|| hide
				|| modelElement.eGet(feature) == null // hide features with no content
				|| (modelElement.eGet(feature) instanceof EList && ((EList<Object>) modelElement.eGet(feature)).size() < 1)) {
				// do nothing! do not render these features
			} else {
				// do not show features with special renderers in the table
				if (!(getAttributeRendererNotNull(feature) instanceof DefaultAttributeRenderer)) {
					specialRendererProperties.add(propertyDescriptor);
				}
				// simple EAttributes - String, numbers, boolean etc.
				else if (feature.eClass().getInstanceClass().equals(EAttribute.class)) {
					singleProperties.add(propertyDescriptor);
				}
				// EReference
				else {
					ReferenceAttributeOption option = (ReferenceAttributeOption) renderer.getAttributeOption();
					if (option.isContained()) {
						containedProperties.add(propertyDescriptor);
					}
					// Multi references (EList)
					else if (feature.isMany()) {
						if (((MultiReferenceAttributeOption) option).getListOption().getListStyle().equals(
							ListStyle.TABLE)) {
							multiProperties.add(propertyDescriptor);
						} else {
							multiPropertiesOutsideOfTable.add(propertyDescriptor);
						}
					}
					// a single reference, which is not contained
					else {
						singleProperties.add(propertyDescriptor);
					}
				}
			}
		}

		FeatureOrdering ordering = new FeatureOrdering();
		ordering.singleProperties = singleProperties;
		ordering.multiProperties = multiProperties;
		ordering.containedProperties = containedProperties;
		ordering.specialRendererProperties = specialRendererProperties;
		ordering.multiPropertiesOutsideOfTable = multiPropertiesOutsideOfTable;

		return ordering;
	}

	/**
	 * Renders a ModelElement into the UCompositeSection parent.
	 */
	@Override
	public void doRender(ModelElement modelElement, UCompositeSection parent) {
		FeatureOrdering ordering = orderFeatures(modelElement);

		// Render title and description
		USection modelElementSection = new USection();
		parent.add(modelElementSection);
		renderTitleAndDescription(modelElement, modelElementSection);

		// Diagrams need to be rendered in a different way.
		if (modelElement instanceof MEDiagram) {
			renderDiagram(modelElement, modelElementSection);
			return;
		}

		renderPropertiesTable(ordering.singleProperties, ordering.multiProperties, modelElement, modelElementSection);

		renderMutliProperties(ordering.multiPropertiesOutsideOfTable, modelElement, modelElementSection);

		renderContainedProperties(ordering.containedProperties, modelElement, modelElementSection);
		renderContainedProperties(ordering.specialRendererProperties, modelElement, modelElementSection);

		// Possibly, there are contained ModelElements, which aren't contained in a feature.
		// In this case, they have to be rendered too.
		// So I have to get all contained ModelELement (eContents()), and remove the already rendered
		// ModelElements from it.
		// Additionally, i have to convert this stupid EList to an ArrayList because EList remove is buggy
		EList<EObject> tmp = modelElement.eContents();
		ArrayList<EObject> remainingContainedModelElements = new ArrayList<EObject>();
		remainingContainedModelElements.addAll(tmp);
		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.containedProperties, modelElement);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.specialRendererProperties,
			modelElement);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.multiProperties, modelElement);

		removeAlreadyRenderedModelElements(remainingContainedModelElements, ordering.multiPropertiesOutsideOfTable,
			modelElement);

		// for (EObject containedModelElement : remainingContainedModelElements) {
		// if (containedModelElement instanceof ModelElement) {
		// renderContainedModelElement((ModelElement) containedModelElement, modelElementSection);
		// }
		// }

	}

	/**
	 * A Diagram needs to be rendered into the document as an image. Therefore, the GMF diagram must be exported
	 * temporarily to an image format like SVG. Then the image must be added to the section of the ModelElement and must
	 * be fit to the page size.
	 * 
	 * @param modelElement the ModelElement which contains a GMF diagram
	 * @param parent the parent section where the diagram shall be rendered.
	 */
	private void renderDiagram(ModelElement modelElement, USection parent) {

		final MEDiagram diagram = (MEDiagram) modelElement;

		try {
			final File tmpImage = File.createTempFile(diagram.getModelElementId().getId(), ".svg");

			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					final CopyToImageUtil util = new CopyToImageUtil();

					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							try {
								diagram.loadDiagramLayout();
								util.copyToImage(diagram.getGmfdiagram(), new Path(tmpImage.toString()),
									ImageFileFormat.SVG, new NullProgressMonitor(), PreferencesHint.USE_DEFAULTS);
							} catch (DiagramLoadException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (CoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}
			});

			UImage image = new UImage(new Path(tmpImage.toString()));
			parent.add(image);
			image.getBoxModel().setBorder(0.5);
			image.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
			image.setFitToPage(true);

			UParagraph label = new UParagraph(diagram.getType() + ": " + modelElement.getName(), template
				.getLayoutOptions().getDefaultTextOption());
			label.getOption().setTextAlign(TextAlign.CENTER);
			label.getBoxModel().setMarginTop(5);
			parent.add(label);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * There are multi reference properties, which shall not be rendered in the properties table, but in an own sub
	 * paragraph as a list or something different.
	 * 
	 * @param multiPropertiesOutsideOfTable properties of the ModelElement, which shall be rendered outside of the
	 *            properties table
	 * @param modelElement the modelElement containing the information of the property
	 * @param modelElementSection the section of the ModelElement
	 */
	@SuppressWarnings("unchecked")
	private void renderMutliProperties(Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable,
		ModelElement modelElement, USection modelElementSection) {

		for (IItemPropertyDescriptor propertyDescriptor : multiPropertiesOutsideOfTable) {
			UParagraph propertiesHeader = new UParagraph(propertyDescriptor.getDisplayName(modelElement) + ": ",
				template.getLayoutOptions().getModelElementTextOption());
			modelElementSection.add(propertiesHeader);

			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);
			String attributeName;
			// If there is no special name for the attribute of the attribute, use the properties display name
			if (getAttributeRendererNotNull(feature).getAttributeOption().getAttributeText().equals("")) {
				attributeName = propertyDescriptor.getDisplayName(modelElement);
			} else {
				attributeName = getAttributeRenderer(feature).getAttributeOption().getAttributeText();
			}

			modelElementSection.add(new UParagraph(attributeName));

			EList<ModelElement> objectList = (EList<ModelElement>) modelElement.eGet(feature);

			MultiReferenceAttributeOption referenceOption = (MultiReferenceAttributeOption) getAttributeRendererNotNull(
				feature).getAttributeOption();
			ListOption listOption = referenceOption.getListOption();
			UList list = new UList(listOption, template.getLayoutOptions().getDefaultTextOption());

			for (ModelElement me : objectList) {
				list.add(me.getName());
			}

			modelElementSection.add(list);
		}
	}

	/**
	 * The name of the ModelElement is the title of the section. The description will always be rendered, and is
	 * connected to the section. So there is no page break direktly after the section's title.
	 * 
	 * @param modelElement the modelElement which shall be rendered
	 * @param modelElementSection the section of the ModelElement
	 */
	private void renderTitleAndDescription(ModelElement modelElement, USection modelElementSection) {

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
		// Modelelements, which have a depth greater than 2 of the document sectioning, a left
		// border is added, to structure the range of the ModelElement clearly.
		// The border size of contained ModelElements decrease by the Section depth.
		if (mayRenderStructuralLine(modelElement) && !(modelElement instanceof MEDiagram)) {
			double borderSize = SECTION_INITIAL_BORDER_SIZE / (modelElementSection.getDepth());
			modelElementSection.getBoxModel().setBorderLeft(borderSize);
			modelElementSection.getBoxModel().setBorderStyle(UBorderStyle.GROOVE);
			modelElementSection.getBoxModel().setPaddingLeft(SECTION_LEFT_BORDER_PADDING);
		}

		// There is no section numbering for ModelElements
		modelElementSection.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		modelElementSection.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);
		String modelElementName;
		if (modelElement.getName() == null || modelElement.getName().equals("")
			|| modelElement.getName().equals("null")) {
			modelElementName = "(noName)";
		} else {
			modelElementName = modelElement.getName();
		}

		UParagraph titleParagraph = new UParagraph(modelElementName);
		if (getTemplate().getLayoutOptions().isShowModelElementTypeInSectionTitle()) {
			UTextPart modelElementType = new UTextPart(" [" + modelElement.eClass().getName() + "]", getTemplate()
				.getLayoutOptions().getDefaultTextOption());
			modelElementType.getOption().setItalics(true);
			modelElementType.getOption().setFontSize(modelElementType.getOption().getFontSize() - 2);
			titleParagraph.add(modelElementType);
		}

		titleParagraph.setOption(getTemplate().getLayoutOptions().getModelElementTextOption());
		modelElementSection.setTitle(titleParagraph);

		// ########################## Description ##########################
		UParagraph description = new UParagraph(WorkspaceUtil.cleanFormatedText(modelElement.getDescription()),
			getTemplate().getLayoutOptions().getDefaultTextOption());
		description.getBoxModel().setKeepWithPrevious(true);
		description.getOption().setTextAlign(TextAlign.JUSTIFY);

		if (!description.equals("")) {
			modelElementSection.add(description);
		}

		// keep with properties table, if the description is short
		if (description.getText().length() < DESCRIPTION_MIN_SIZE) {
			description.getBoxModel().setKeepWithNext(true);
		}
		description.getBoxModel().setMarginBottom(SECTION_DESCRIPTION_MARGIN);
	}

	@SuppressWarnings("unchecked")
	private void removeAlreadyRenderedModelElements(ArrayList<EObject> remainingContainedModelElements,
		Vector<IItemPropertyDescriptor> containedProperties, ModelElement modelElement) {

		for (IItemPropertyDescriptor propertyDescriptor : containedProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);
			if (feature.isMany()) {
				EList<ModelElement> objectList = (EList<ModelElement>) modelElement.eGet(feature);

				for (EObject eObject : objectList) {
					remainingContainedModelElements.remove(eObject);
				}
			} else {
				remainingContainedModelElements.remove(modelElement.eGet(feature));
			}
		}
	}

	/**
	 * @param singleProperties all properties, which have a single value like an EAttribute or a single ERference.
	 * @param multiProperties all multi EReferences
	 * @param modelElement the modelElement containing the values of the properties
	 * @param parent the section of the ModelELement
	 */
	@SuppressWarnings("unchecked")
	private void renderPropertiesTable(Vector<IItemPropertyDescriptor> singleProperties,
		Vector<IItemPropertyDescriptor> multiProperties, ModelElement modelElement, USection parent) {

		if (singleProperties.size() + multiProperties.size() < 1) {
			return;
		}

		UTable table = new UTable(2);

		// count the rows of the table, to decide, if the table should be shown on one page
		int rowCount = 0;
		table.setColumnsWidths(new float[] { 30, 70 });

		// ############### Single Properties ########################
		for (IItemPropertyDescriptor propertyDescriptor : singleProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);

			Object obj = modelElement.eGet(feature);
			if (obj != null) {
				// count the modelElements beeing rendered
				if (!feature.eClass().getInstanceClass().equals(EAttribute.class)) {
					TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);
				}

				rowCount++;

				UParagraph leftParagraph = new UParagraph(getAttributeName(feature, propertyDescriptor
					.getDisplayName(modelElement)), template.getLayoutOptions().getDefaultTextOption());
				UTableCell tableCellLeft = new UTableCell(leftParagraph);
				tableCellLeft.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
				tableCellLeft.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
				table.addCell(tableCellLeft);

				UTableCell tableCellRight = new UTableCell("");
				tableCellRight.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
				tableCellRight.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
				table.addCell(tableCellRight);

				if (modelElement.eGet(feature) instanceof ModelElement) {
					ModelElement featureModelElement = (ModelElement) modelElement.eGet(feature);
					ULink link = new ULink(featureModelElement.getName(), featureModelElement.getModelElementId()
						.getId());
					link.setOption(template.getLayoutOptions().getDefaultTextOption());
					UParagraph par = new UParagraph("");
					par.add(link);
					tableCellRight.setContent(par);
				} else {
					AttributeRenderer attributeRenderer = getAttributeRendererNotNull(feature);
					UParagraph attributeContainer = new UParagraph("");
					tableCellRight.setContent(attributeContainer);
					attributeRenderer.render(feature, modelElement, attributeContainer, template);
				}
			}
		}

		// ############################ Multi Properties ###########################
		for (IItemPropertyDescriptor propertyDescriptor : multiProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);
			Object attributeValue = modelElement.eGet(feature);
			if (attributeValue instanceof EList) {
				EList<ModelElement> objectList = (EList<ModelElement>) attributeValue;

				if (objectList.size() > 0) {
					UParagraph par = new UParagraph("");
					for (ModelElement me : objectList) {
						// count the modelElements beeing rendered
						TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);
						UParagraph entryContainer = new UParagraph("");
						entryContainer.getBoxModel().setBorderBottom(0.5);
						entryContainer.getBoxModel().setBorderStyle(UBorderStyle.DOTTED);
						par.add(entryContainer);
						ULink entry = new ULink(me.getName(), me.getModelElementId().getId());
						// register the ModelElement as a link, so that it can be rendered in the
						// appendix if wanted and neccessary
						DocumentExport.addLinkedModelElement(me);
						entry.setOption(template.getLayoutOptions().getDefaultTextOption());
						// entry.getBoxModel().setBorderBottom(0.5);
						// entry.getBoxModel().setBorderStyle(UBorderStyle.DOTTED);
						entryContainer.add(entry);
						rowCount++;
					}
					// The last row has no border bottom.
					par.getChildren().get(par.getChildren().size() - 1).getBoxModel().setBorderBottom(0);

					UTableCell leftTableCell = new UTableCell(getAttributeName(feature, propertyDescriptor
						.getDisplayName(modelElement)), template.getLayoutOptions().getDefaultTextOption());
					leftTableCell.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
					leftTableCell.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
					table.addCell(leftTableCell);

					UTableCell rightTableCell = new UTableCell(par);
					rightTableCell.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
					rightTableCell.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
					table.addCell(rightTableCell);
				}
			}
		}

		table.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
		table.getBoxModel().setBorderTop(PROPERTIES_TABLE_BORDER_SIZE);

		if (rowCount < 20) {
			table.getBoxModel().setKeepTogether(true);
		}

		parent.add(table);
	}

	/**
	 * Contained properties (attributes) are just rendered in a their own renderer.
	 */
	private void renderContainedProperties(Vector<IItemPropertyDescriptor> properties, ModelElement modelElement,
		UCompositeSection parent) {

		for (IItemPropertyDescriptor propertyDescriptor : properties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);

			// UParagraph propertiesHeader = new UParagraph(
			// getAttributeName(feature, propertyDescriptor.getDisplayName(modelElement)) + ": ",
			// template.getLayoutOptions().getAttributeTextOption()
			// );
			// parent.add(propertiesHeader);
			// propertiesHeader.getBoxModel().setMarginTop(15);

			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(feature, modelElement, parent, getTemplate());
		}
	}

	/**
	 * Returns a Vector of the propertyDecriptors of a modelElement. Only editable properties are in this Vector.
	 */
	private Vector<IItemPropertyDescriptor> getPropertyDescriptors(ModelElement modelElement) {
		Vector<IItemPropertyDescriptor> ret = new Vector<IItemPropertyDescriptor>();

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			ret.addAll(propertyDescriptors);
		}

		return ret;
	}

	/**
	 * Returns the default display name of the attribute. If there is a text in the attribute option different from the
	 * empty string, it will be used instead of the defaultName.
	 * 
	 * @param feature the feature of the attribute
	 * @param defaultName the default name of the feature
	 * @return the name of the feature how it shall appear in the document
	 */
	private String getAttributeName(EStructuralFeature feature, String defaultName) {
		String attributeName;
		if (getAttributeRendererNotNull(feature).getAttributeOption().getAttributeText().equals("")) {
			attributeName = defaultName;
		} else {
			attributeName = getAttributeRenderer(feature).getAttributeOption().getAttributeText();
		}
		return attributeName;
	}

	/**
	 * Structural lines shall be rendered, if any modelElement on the same layer has contained modelElements, or if the
	 * parent modelElement has structural lines, too.
	 * 
	 * @param object the ModelElement, where structural lines shall be rendered
	 * @return true, if structural lines shall be rendered
	 */
	private boolean mayRenderStructuralLine(EObject object) {
		// if the recursive depth of the Model Element structure is 1, there wonn't be any children.
		// so there won't be any structural line be needed.
		if (DocumentExport.getRecursionDepth() == 1) {
			return false;
		}

		if (object == null || object.eContainer() == null || object instanceof LeafSection
			|| object instanceof CompositeSection) {
			return false;
		}
		if (mayRenderStructuralLine(object.eContainer())) {
			return true;
		}

		for (EObject content : object.eContainer().eContents()) {
			if (content instanceof ModelElement && !(content instanceof LeafSection)
				&& !(content instanceof CompositeSection)) {
				FeatureOrdering ordering = orderFeatures((ModelElement) content);

				// check if the special attribute renderer has the hideStructuralLines() option activated
				// if it is activated, the attribute wont be counted as a contained property
				// because it is only used to decide whether the structural lines should be drawn or not
				int containedProperties = 0;
				for (IItemPropertyDescriptor property : ordering.containedProperties) {
					EStructuralFeature feature = (EStructuralFeature) property.getFeature(content);
					AttributeRenderer attributeRenderer = getAttributeRendererNotNull(feature);
					if (!attributeRenderer.hideStructuralLines()) {
						containedProperties++;
					}
				}

				if (ordering.containedProperties.size() + containedProperties > 0) {
					return true;
				}
			}
		}
		return false;
	}
	// end custom code

} // DefaultModelElementRendererImpl
