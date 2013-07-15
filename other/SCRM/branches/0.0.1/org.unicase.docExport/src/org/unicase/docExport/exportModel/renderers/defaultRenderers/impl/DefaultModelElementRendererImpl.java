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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;
import org.unicase.workspace.util.UnicaseCommand;
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultModelElementRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

		if (!(eObject instanceof UnicaseModelElement)) {
			return;
		}

		UnicaseModelElement modelElement = (UnicaseModelElement) eObject;

		FeatureOrdering ordering = orderFeatures(modelElement);

		// Render title and description
		USection modelElementSection = new USection();
		parent.add(modelElementSection);
		renderTitleAndDescription(modelElement, modelElementSection, false);

		// Diagrams need to be rendered in a different way.
		if (modelElement instanceof MEDiagram) {
			renderDiagram(modelElement, modelElementSection);
			return;
		}

		// TODO: fix show image for fileattachments linking to images

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
	}

	/**
	 * A Diagram needs to be rendered into the document as an image. Therefore, the GMF diagram must be exported
	 * temporarily to an image format like SVG. Then the image must be added to the section of the ModelElement and must
	 * be fit to the page size.
	 * 
	 * @param modelElement the ModelElement which contains a GMF diagram
	 * @param parent the parent section where the diagram shall be rendered.
	 */
	private void renderDiagram(final UnicaseModelElement modelElement, final USection parent) {

		final MEDiagram diagram = (MEDiagram) modelElement;

		try {
			ModelElementId diagramId = ModelUtil.getProject(diagram).getModelElementId(diagram);
			final File tmpImage = File.createTempFile(diagramId.getId(), ".jpeg");

			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					final CopyToImageUtil util = new CopyToImageUtil();

					new UnicaseCommand() {

						@Override
						protected void doRun() {
							try {
								diagram.loadDiagramLayout();
								/*
								 * View view = diagram.getGmfdiagram(); XMLResource res = (XMLResource)
								 * view.eResource(); String id = res.getID(view); DiagramEditor openedDiagramEditor =
								 * DiagramEditorUtil.findOpenedDiagramEditorForID(id);
								 */
								Shell shell = new Shell();
								try {

									DiagramEditPart editPart = util.createDiagramEditPart(diagram.getGmfdiagram(),
										shell, PreferencesHint.USE_DEFAULTS);
									Assert.isNotNull(editPart.getDiagramView().getDiagram());
									Assert.isNotNull(editPart);
									util.copyToImage(editPart, new Path(tmpImage.toString()), ImageFileFormat.JPEG,
										new NullProgressMonitor());

								} finally {
									shell.dispose();
								}
								/*
								 * util.copyToImage(diagram.getGmfdiagram(), new Path(tmpImage.toString()),
								 * ImageFileFormat.SVG, new NullProgressMonitor(), PreferencesHint.USE_DEFAULTS);
								 */
							} catch (DiagramLoadException e) {
								WorkspaceUtil.log("A diagram could not be loaded while exporting.", e, IStatus.WARNING);
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

			addDiagramUImage(modelElement, parent, diagram, tmpImage);

		} catch (IOException e1) {
			WorkspaceUtil.log("Diagram image rendering error", e1, IStatus.WARNING);
		}
	}

	private void addDiagramUImage(UnicaseModelElement modelElement, USection parent, final MEDiagram diagram,
		final File tmpImage) {
		UImage image = new UImage(new Path(tmpImage.toString()));
		image.getBoxModel().setBorder(0.5);
		image.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		image.setFitToPage(true);
		parent.add(image);

		UParagraph label = new UParagraph(diagram.getGmfdiagram().getType() + ": " + modelElement.getName(), template
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
	 * @param modelElement the modelElement containing the information of the property
	 * @param modelElementSection the section of the ModelElement
	 */
	@SuppressWarnings("unchecked")
	private void renderMutliProperties(Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable,
		UnicaseModelElement modelElement, USection modelElementSection) {

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

			EList<UnicaseModelElement> objectList = (EList<UnicaseModelElement>) modelElement.eGet(feature);

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
		Vector<IItemPropertyDescriptor> containedProperties, UnicaseModelElement modelElement) {

		for (IItemPropertyDescriptor propertyDescriptor : containedProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);
			if (feature.isMany()) {
				EList<UnicaseModelElement> objectList = (EList<UnicaseModelElement>) modelElement.eGet(feature);

				for (EObject eObject : objectList) {
					remainingContainedModelElements.remove(eObject);
				}
			} else {
				remainingContainedModelElements.remove(modelElement.eGet(feature));
			}
		}
	}

	/**
	 * Contained properties (attributes) are just rendered in a their own renderer.
	 */
	private void renderContainedProperties(Vector<IItemPropertyDescriptor> properties,
		UnicaseModelElement modelElement, UCompositeSection parent) {

		for (IItemPropertyDescriptor propertyDescriptor : properties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(modelElement);

			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			renderer.render(feature, modelElement, parent, getTemplate());
		}
	}

	// end custom code

} // DefaultModelElementRendererImpl
