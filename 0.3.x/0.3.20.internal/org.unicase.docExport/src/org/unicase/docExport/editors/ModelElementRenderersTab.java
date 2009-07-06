/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.docExport.AttributeRendererRegistry;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.model.ModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.dialogs.METypeTreeSelectionDialog;

/**
 * @author Sebastian Hoecht
 */
public class ModelElementRenderersTab extends TemplateEditorTab {
	private Composite rendererSelectContainer;
	private Composite optionsContainer;
	private Combo modelElementRendererSelect;
	private Composite attributeOptionsContainer;
	private Composite attributeOptionsSubContainer;
	private Composite rendererOptionsContainer;
	private Combo attributeRendererSelector;
	private Combo attributeOptionsSelector;
	private Label modelElementType;
	private TemplateEditor editor;

	/**
	 * @param parent the ScrolledComposite which is contained in a tabItem
	 * @param style the SWT style
	 * @param tabFolder the tabFolder where the ScrolledComposite is contained
	 * @param template the template for this form
	 * @param editor the editor which contains this tab.
	 */
	public ModelElementRenderersTab(Composite parent, int style, CTabFolder tabFolder, Template template,
		final TemplateEditor editor) {
		super(parent, style, tabFolder, template);
		setContainerTab(rebuildTabContainer(getContainerTab(), parent));

		this.editor = editor;

		rendererSelectContainer = new Composite(getContainerTab(), SWT.FILL);
		GridLayout gLayout5 = new GridLayout();
		gLayout5.numColumns = 2;
		GridData gData5 = new GridData(GridData.FILL_HORIZONTAL);
		gLayout5.makeColumnsEqualWidth = true;
		rendererSelectContainer.setLayout(gLayout5);
		rendererSelectContainer.setLayoutData(gData5);

		modelElementType = new Label(rendererSelectContainer, SWT.NONE);
		modelElementType.setText(TaskPackage.eINSTANCE.getActionItem().getInstanceClass().getSimpleName());
		new Label(rendererSelectContainer, SWT.NONE).setText("ModelElement renderer");

		final Button selectModelElementType = new Button(rendererSelectContainer, SWT.PUSH);
		selectModelElementType.setText("Select Model Element Type");

		selectModelElementType.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				METypeTreeSelectionDialog dialog = new METypeTreeSelectionDialog(rendererSelectContainer.getShell(),
					false);

				if (dialog.open() == METypeTreeSelectionDialog.OK) {
					createRendererSelector(dialog.getResult()[0]);
					modelElementType.setText(dialog.getResult()[0].getInstanceClass().getSimpleName());
				}

			}
		});

		optionsContainer = new Composite(getContainerTab(), SWT.FILL);
		GridLayout gLayout4 = new GridLayout();
		gLayout4.numColumns = 1;
		GridData gData4 = new GridData(GridData.FILL_HORIZONTAL);
		optionsContainer.setLayout(gLayout4);
		optionsContainer.setLayoutData(gData4);

		createRendererSelector(TaskPackage.eINSTANCE.getActionItem());

		layoutAndPackAll();
	}

	private Composite rebuildTabContainer(Composite container, Composite parent) {
		if (container != null) {
			container.dispose();
		}
		container = new Composite(parent, SWT.FILL);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayout(gLayout);
		container.setLayoutData(gData);

		// parent.setContent(container);
		// parent.setExpandHorizontal(true);
		// parent.setExpandVertical(true);
		// parent.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return container;
	}

	/**
	 * @param modelElementEClass the Model Element type which shall be selected
	 */
	public void chooseModelElementType(EClass modelElementEClass) {
		modelElementType.setText(modelElementEClass.getInstanceClass().getSimpleName());
		createRendererSelector(modelElementEClass);
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

	private void createRendererSelector(final EClass modelElementEClass) {
		final ArrayList<ModelElementRenderer> modelElementRenderers = new ArrayList<ModelElementRenderer>();
		modelElementRenderers.addAll(ModelElementRendererRegistry.getSupportedModelElementRenderers(modelElementEClass
			.getName(), getTemplate()));

		if (modelElementRendererSelect != null) {
			modelElementRendererSelect.dispose();
		}

		modelElementRendererSelect = new Combo(rendererSelectContainer, SWT.READ_ONLY);
		modelElementRendererSelect.add("(unset)");
		for (int i = 0; i < modelElementRenderers.size(); i++) {
			modelElementRendererSelect.add(modelElementRenderers.get(i).eClass().getInstanceClass().getSimpleName(),
				i + 1);
		}

		final ModelElementRenderer currentRenderer = getTemplate().getModelElementRenderer(modelElementEClass);

		modelElementRendererSelect.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				int selectionIndex = ((Combo) e.widget).getSelectionIndex();
				if (selectionIndex > 0) {
					if (currentRenderer != null
						&& modelElementRenderers.get(selectionIndex - 1).eClass().getInstanceClass().equals(
							currentRenderer.eClass().getInstanceClass())) {
						rebuildModelElementRendererOptions(currentRenderer, modelElementEClass);
					} else {
						rebuildModelElementRendererOptions(modelElementRenderers.get(selectionIndex - 1),
							modelElementEClass);
					}

				} else {
					rebuildModelElementRendererOptions(null, modelElementEClass);
				}
				editor.setDirty();
			}
		});
		modelElementRendererSelect.select(0);

		if (currentRenderer != null) {
			for (int i = 0; i < modelElementRenderers.size(); i++) {
				if (modelElementRenderers.get(i).eClass().getInstanceClass().equals(
					currentRenderer.eClass().getInstanceClass())) {
					modelElementRendererSelect.select(i + 1);
				}
			}
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

		if (renderer != null) {
			getTemplate().setModelElementRenderer(eClass.getName(), renderer);
			((Group) attributeOptionsContainer).setText(" Attributes ");
			((Group) rendererOptionsContainer).setText(" Renderer options ");

			final ArrayList<EStructuralFeature> attributes = getAttributes(eClass);
			attributeOptionsSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);
			for (int i = 0; i < attributes.size(); i++) {
				attributeOptionsSelector.add(attributes.get(i).getName(), i);
			}

			attributeOptionsSelector.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					createAttributeRendererSelector(attributes.get(((Combo) e.widget).getSelectionIndex()), renderer);
					layoutAndPackAll();
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
						AttributeOptionFactory.buildOptionsFormular(rendererOptionsContainer, rendererOptions
							.get(((Combo) e.widget).getSelectionIndex()));
					}
				});
				rendererOptionSelector.select(0);
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

		layoutAndPackAll();
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
					if (currentAttributeRenderer != null
						&& currentAttributeRenderer.eClass().getInstanceClass().equals(
							attributeRenderer.eClass().getInstanceClass())) {
						AttributeOptionFactory.buildOptionsFormular(attributeOptionsSubContainer,
							currentAttributeRenderer.getAttributeOption());
						modelElementRenderer.setAttributeRenderer(feature, currentAttributeRenderer);
					} else {
						AttributeOptionFactory.buildOptionsFormular(attributeOptionsSubContainer, attributeRenderer
							.getAttributeOption());
						modelElementRenderer.setAttributeRenderer(feature, attributeRenderer);
					}
					layoutAndPackAll();
					editor.setDirty();
				}
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

	private void rebuildAttributeOptionsContainer() {
		if (attributeOptionsSubContainer != null) {
			attributeOptionsSubContainer.dispose();
		}
		attributeOptionsSubContainer = new Composite(attributeOptionsContainer, SWT.FILL);
		attributeOptionsSubContainer.setLayout(new GridLayout());
		attributeOptionsSubContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	private ArrayList<EStructuralFeature> getAttributes(EClass eClass) {
		ArrayList<EStructuralFeature> ret = new ArrayList<EStructuralFeature>();

		ModelElement modelElement = (ModelElement) eClass.getEPackage().getEFactoryInstance().create(eClass);

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				ret.add((EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement));
			}
		}

		return ret;
	}

	private void layoutAndPackAll() {
		attributeOptionsContainer.pack(true);
		attributeOptionsContainer.layout(true, true);
		rendererOptionsContainer.pack(true);
		rendererOptionsContainer.layout(true, true);

		optionsContainer.pack(true);
		optionsContainer.layout(true, true);

		layoutAndPack();
	}
}
