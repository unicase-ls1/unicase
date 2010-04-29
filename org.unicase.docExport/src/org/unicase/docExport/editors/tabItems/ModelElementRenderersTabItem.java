/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.docExport.AttributeRendererRegistry;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.editors.options.TAttributeOption;
import org.unicase.docExport.editors.options.TOptionsFactory;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.model.UnicaseModelElement;

/**
 * A TemplateEditor TabItem where the ModelElementRenderer of a ModelElement type can be chosen, and its options can be
 * changed.
 * 
 * @author Sebastian Hoecht
 */
public class ModelElementRenderersTabItem extends TemplateEditorTabItem {
	private Composite rendererSelectContainer;
	private Composite optionsContainer;
	private Combo modelElementRendererSelect;
	private Composite attributeOptionsContainer;
	private Composite attributeOptionsSubContainer;
	private Composite rendererOptionsContainer;
	private Combo attributeRendererSelector;
	private Combo attributeOptionsSelector;
	private Label modelElementType;

	/**
	 * @param parent the ScrolledComposite which is contained in a tabItem
	 * @param template the template for this form
	 * @param editor the editor which contains this tab.
	 */
	public ModelElementRenderersTabItem(CTabFolder parent, Template template, TemplateEditor editor) {
		super(parent, template, editor);

		setText("Renderers");

		rendererSelectContainer = new Composite(getContainer(), SWT.FILL);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gLayout.makeColumnsEqualWidth = true;
		rendererSelectContainer.setLayout(gLayout);
		rendererSelectContainer.setLayoutData(gData);

		modelElementType = new Label(rendererSelectContainer, SWT.NONE);

		optionsContainer = new Composite(getContainer(), SWT.FILL);
		GridLayout gLayout1 = new GridLayout();
		gLayout1.numColumns = 1;
		GridData gData1 = new GridData(GridData.FILL_HORIZONTAL);
		optionsContainer.setLayout(gLayout1);
		optionsContainer.setLayoutData(gData1);

	}

	/**
	 * @param modelElementEClass the EClass of the modelElement
	 * @param featureName the name of the requested feature
	 */
	public void chooseFeature(EClass modelElementEClass, String featureName) {
		chooseModelElementType(modelElementEClass);

		int i = 0;
		for (String item : attributeOptionsSelector.getItems()) {
			if (item.equals(featureName)) {
				attributeOptionsSelector.select(i);
			}
			i++;
		}
	}

	/**
	 * Choose a ModelElementType for which the the ModelElementRenderer can be selected.
	 * 
	 * @param modelElementEClass the EClass of a ModelElement.
	 */
	public void chooseModelElementType(final EClass modelElementEClass) {
		final ArrayList<ModelElementRenderer> modelElementRenderers = new ArrayList<ModelElementRenderer>();
		modelElementRenderers.addAll(ModelElementRendererRegistry.getSupportedModelElementRenderers(modelElementEClass,
			getTemplate()));

		modelElementType.setText(modelElementEClass.getInstanceClass().getSimpleName());

		if (modelElementRendererSelect != null) {
			modelElementRendererSelect.dispose();
		}

		modelElementRendererSelect = new Combo(rendererSelectContainer, SWT.READ_ONLY);
		for (int i = 0; i < modelElementRenderers.size(); i++) {
			modelElementRendererSelect.add(modelElementRenderers.get(i).eClass().getInstanceClass().getSimpleName(), i);
		}

		final ModelElementRenderer currentRenderer = getTemplate().getModelElementRenderer(modelElementEClass);

		modelElementRendererSelect.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				rebuildModelElementRendererOptions(modelElementRenderers.get(modelElementRendererSelect
					.getSelectionIndex()), modelElementEClass);
				getEditor().testDirty();
			}
		});

		// if there currently is a renderer - choose it!
		if (currentRenderer != null) {
			for (int i = 0; i < modelElementRenderers.size(); i++) {
				if (modelElementRenderers.get(i).eClass().getInstanceClass().equals(
					currentRenderer.eClass().getInstanceClass())) {
					modelElementRendererSelect.select(i);
				}
			}
		} else {
			// no renderer -> choose the default renderer which is the first one
			modelElementRendererSelect.select(0);
		}
	}

	private void rebuildModelElementRendererOptions(final ModelElementRenderer renderer, EClass eClass) {
		if (attributeOptionsContainer != null) {
			attributeOptionsContainer.dispose();
		}

		if (rendererOptionsContainer != null) {
			rendererOptionsContainer.dispose();
		}

		attributeOptionsContainer = new Group(optionsContainer, SWT.FILL | SWT.BORDER);
		GridLayout gLayout2 = new GridLayout();
		GridData gData2 = new GridData(GridData.FILL_HORIZONTAL);
		attributeOptionsContainer.setLayout(gLayout2);
		attributeOptionsContainer.setLayoutData(gData2);

		rendererOptionsContainer = new Group(optionsContainer, SWT.FILL | SWT.BORDER);
		GridLayout gLayout3 = new GridLayout();
		GridData gData3 = new GridData(GridData.FILL_HORIZONTAL);
		rendererOptionsContainer.setLayout(gLayout3);
		rendererOptionsContainer.setLayoutData(gData3);

		// an ModelElementRenderer has been chosen -> show the options
		if (renderer != null) {
			final ModelElementRenderer currentRenderer = getTemplate().getModelElementRenderer(eClass);

			// if and only if there is a new ModelElementRendererMapping or a different renderer from the current
			// renderer has been selected, the renderer needs and must be set.
			if (currentRenderer == null || !currentRenderer.eClass().equals(renderer.eClass())) {
				getTemplate().setModelElementRenderer(eClass, renderer);
			}
			((Group) attributeOptionsContainer).setText(" Attributes ");
			((Group) rendererOptionsContainer).setText(" Renderer options ");

			final ArrayList<IItemPropertyDescriptor> attributes = getPropertyDescriptors(eClass);
			final UnicaseModelElement modelElement = (UnicaseModelElement) eClass.getEPackage().getEFactoryInstance()
				.create(eClass);

			attributeOptionsSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);
			for (int i = 0; i < attributes.size(); i++) {
				attributeOptionsSelector.add(attributes.get(i).getDisplayName(modelElement), i);
			}

			attributeOptionsSelector.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					EStructuralFeature feature = (EStructuralFeature) attributes.get(
						((Combo) e.widget).getSelectionIndex()).getFeature(modelElement);
					if (currentRenderer == null || !currentRenderer.eClass().equals(renderer.eClass())) {
						createAttributeRendererSelector(feature, renderer);
					} else {
						createAttributeRendererSelector(feature, currentRenderer);
					}
				}
			});
			attributeOptionsSelector.select(0);

			// rendererOptions
			final ArrayList<RendererOption> rendererOptions = new ArrayList<RendererOption>();
			rendererOptions.addAll(renderer.getRendererOptions());
			if (rendererOptions.size() > 0) {
				Combo rendererOptionSelector = new Combo(rendererOptionsContainer, SWT.READ_ONLY);
				for (int i = 0; i < renderer.getRendererOptions().size(); i++) {
					rendererOptionSelector.add(renderer.getRendererOptions().get(i).getName(), i);
				}
				rendererOptionSelector.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						TOptionsFactory.build(rendererOptions.get(((Combo) e.widget).getSelectionIndex()),
							rendererOptionsContainer, getEditor());
					}
				});
				rendererOptionSelector.select(0);
				layoutAndPackAll();
			}
			if (rendererOptions.size() < 1) {
				rendererOptionsContainer.dispose();
				rendererOptionsContainer = new Composite(optionsContainer, SWT.NONE);
			}
		} else {
			// remove renderer
			rendererOptionsContainer.dispose();
			rendererOptionsContainer = new Composite(optionsContainer, SWT.NONE);
			attributeOptionsContainer.dispose();
			attributeOptionsContainer = new Composite(optionsContainer, SWT.NONE);
			getTemplate().removeModelElementRenderer(eClass);
		}
	}

	private void createAttributeRendererSelector(final EStructuralFeature feature,
		final ModelElementRenderer modelElementRenderer) {

		final ArrayList<AttributeRenderer> renderers = new ArrayList<AttributeRenderer>();
		renderers.addAll(AttributeRendererRegistry.getSupportedAttributeRenderers(feature, getTemplate()));

		final AttributeRenderer currentAttributeRenderer = modelElementRenderer.getAttributeRenderer(feature);

		if (attributeRendererSelector != null) {
			attributeRendererSelector.dispose();
		}

		attributeRendererSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);

		attributeRendererSelector.add("(unset)", 0);
		for (int i = 0; i < renderers.size(); i++) {
			attributeRendererSelector.add(renderers.get(i).eClass().getInstanceClass().getSimpleName(), i + 1);
		}

		attributeRendererSelector.getParent().layout(true);

		attributeRendererSelector.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				rebuildAttributeOptionsContainer();
				if (((Combo) e.widget).getSelectionIndex() == 0) {
					modelElementRenderer.removeAttributeRenderer(feature);
				} else {
					AttributeRenderer attributeRenderer = renderers.get(((Combo) e.widget).getSelectionIndex() - 1);

					if (attributeRenderer.getAttributeOption() != null) {
						new TAttributeOption(attributeOptionsSubContainer, attributeRenderer.getAttributeOption(),
							getEditor());
					}
					modelElementRenderer.setAttributeRenderer(feature, attributeRenderer);

					getEditor().testDirty();
				}
				layoutAndPackAll();
			}
		});
		if (currentAttributeRenderer == null) {
			attributeRendererSelector.select(0);
		} else {
			for (int i = 0; i < renderers.size(); i++) {
				if (renderers.get(i).eClass().getInstanceClass().equals(
					currentAttributeRenderer.eClass().getInstanceClass())) {
					attributeRendererSelector.select(i + 1);
				}
			}
		}
	}

	private ArrayList<IItemPropertyDescriptor> getPropertyDescriptors(EClass eClass) {
		final ArrayList<IItemPropertyDescriptor> attributes = new ArrayList<IItemPropertyDescriptor>();

		final UnicaseModelElement modelElement = (UnicaseModelElement) eClass.getEPackage().getEFactoryInstance()
			.create(eClass);

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				attributes.add(itemPropertyDescriptor);
			}
		}

		return attributes;
	}

	private void rebuildAttributeOptionsContainer() {
		if (attributeOptionsSubContainer != null) {
			attributeOptionsSubContainer.dispose();
		}
		attributeOptionsSubContainer = new Composite(attributeOptionsContainer, SWT.FILL);
		attributeOptionsSubContainer.setLayout(new GridLayout());
		attributeOptionsSubContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.editors.TemplateEditorTabItem#layoutAndPackAll()
	 */
	@Override
	protected void layoutAndPackAll() {
		attributeOptionsContainer.pack(true);
		attributeOptionsContainer.layout(true, true);
		rendererOptionsContainer.pack(true);
		rendererOptionsContainer.layout(true, true);

		optionsContainer.pack(true);
		optionsContainer.layout(true, true);

		super.layoutAndPackAll();
	}
}
