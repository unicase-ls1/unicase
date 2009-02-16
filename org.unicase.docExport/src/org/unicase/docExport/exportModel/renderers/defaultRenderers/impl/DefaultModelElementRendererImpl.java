/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
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
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;

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
	public void doRender(ModelElement modelElement, UCompositeSection parent) {
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

	// end custom code

} // DefaultModelElementRendererImpl
