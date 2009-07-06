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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.docExport.AttributeRendererRegistry;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class ModelElementRenderersTab extends TemplateEditorTab {
	private Composite rendererSelectContainer;
	private Composite optionsContainer;
	private Combo modelElementRendererSelect;
	private Group attributeOptionsContainer;
	private Composite attributeOptionsSubContainer;
	private Group rendererOptionsContainer;
	private Combo attributeRendererSelector;
	
	/**
	 * 
	 * @param parent the ScrolledComposite which is contained in a tabItem
	 * @param style the SWT style
	 * @param tabFolder the tabFolder where the ScrolledComposite is contained
	 * @param template the template for this Formular
	 */
	public ModelElementRenderersTab(Composite parent, int style, CTabFolder tabFolder, Template template) {
		super(parent, style, tabFolder, template);
		setContainerTab(rebuildTabContainer(getContainerTab(), parent));

			
		
		rendererSelectContainer = new Composite(getContainerTab(), SWT.FILL);
		GridLayout gLayout5 = new GridLayout();
		gLayout5.numColumns = 2;
		GridData gData5 = new GridData(GridData.FILL_HORIZONTAL);
		rendererSelectContainer.setLayout(gLayout5);
		rendererSelectContainer.setLayoutData(gData5);
		
		new Label(rendererSelectContainer, SWT.NONE).setText("ModelElement type");
		new Label(rendererSelectContainer, SWT.NONE).setText("ModelElement renderer");
		
		final ArrayList<EClass> modelElementTypes = DefaultDocumentTemplateBuilder.getModelElements(ModelPackage.eINSTANCE.eContents());

		Combo modelElementType = new Combo(rendererSelectContainer, SWT.READ_ONLY);
		
		optionsContainer = new Composite(getContainerTab(), SWT.FILL);
		GridLayout gLayout4 = new GridLayout();
		gLayout4.numColumns = 2;
		GridData gData4 = new GridData(GridData.FILL_HORIZONTAL);
		optionsContainer.setLayout(gLayout4);
		optionsContainer.setLayoutData(gData4);	
		
		for (int i = 0; i < modelElementTypes.size(); i++) {
			modelElementType.add(modelElementTypes.get(i).getName(), i);
		}
		
		modelElementType.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				EClass modelElementEClass = modelElementTypes.get(((Combo) e.widget).getSelectionIndex());
				createRendererSelector(modelElementEClass);
			}
			
		});
		modelElementType.select(0);
		
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
		

//		parent.setContent(container);
//		parent.setExpandHorizontal(true);
//		parent.setExpandVertical(true);
//		parent.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		return container;
	}
	
	private void createRendererSelector(final EClass modelElementEClass) {
		final ArrayList<ModelElementRenderer> modelElementRenderers = ModelElementRendererRegistry.getSupportedModelElementRenderers(modelElementEClass.getName(), getTemplate());
	
		if (modelElementRendererSelect != null) {
			modelElementRendererSelect.dispose();
		}
		modelElementRendererSelect = new Combo(rendererSelectContainer, SWT.READ_ONLY);
		modelElementRendererSelect.add("-");
		for (int i = 0; i < modelElementRenderers.size(); i++) {
			modelElementRendererSelect.add(modelElementRenderers.get(i).getClass().getSimpleName(), i + 1);
		}
		modelElementRendererSelect.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				int selectionIndex = ((Combo) e.widget).getSelectionIndex();
				if (selectionIndex > 0) {
					rebuildModelElementRendererOptions(
							modelElementRenderers.get(selectionIndex - 1),
							modelElementEClass
						);
				} else {
					rebuildModelElementRendererOptions(
							null,
							modelElementEClass
						);
				}
			}
		});
		
		
		ModelElementRenderer modelElementRenderer = getTemplate().getModelElementRenderer(modelElementEClass);
		modelElementRendererSelect.select(0);
		if (modelElementRenderer != null) {
			for (int i = 0; i < modelElementRenderers.size(); i++) {
				if (modelElementRenderers.get(i).getClass().equals(modelElementRenderer.getClass())) {
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
			attributeOptionsContainer.setText("attributes");
			rendererOptionsContainer.setText("renderer options");
		
			
			final ArrayList<EStructuralFeature> attributes = getAttributes(eClass);
			Combo attributeOptionsSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);
			for (int i = 0; i < attributes.size(); i++) {
				attributeOptionsSelector.add(attributes.get(i).getName(), i);
			}
			
			attributeOptionsSelector.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					attributes.get(((Combo) e.widget).getSelectionIndex());
					createAttributeRendererSelector(
							attributes.get(((Combo) e.widget).getSelectionIndex()),
							renderer
						);

					layoutAndPackAll();
				}
			});
			attributeOptionsSelector.select(0);
			
			
			//rendererOptions
			final ArrayList<RendererOption> rendererOptions = new ArrayList<RendererOption>();
			rendererOptions.addAll(renderer.getRendererOptions());
			if (rendererOptions.size() > 0) {
				Combo rendererOptionSelector = new Combo(rendererOptionsContainer, SWT.READ_ONLY);
				for (int i = 0; i < renderer.getRendererOptions().size(); i++) {
					rendererOptionSelector.add(
							renderer.getRendererOptions().get(i).getName(),
							i
						);
				}
				rendererOptionSelector.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						AttributeOptionFactory factory = new AttributeOptionFactory();
						factory.buildOptionsFormular(
								rendererOptionsContainer,
								rendererOptions.get(((Combo) e.widget).getSelectionIndex())
							);
					}
				});
				rendererOptionSelector.select(0);

			}
		} else {
			//remove renderer
			getTemplate().removeModelElementRenderer(eClass);
		}
		
		layoutAndPackAll();
	}	
	
	private void createAttributeRendererSelector(
			final EStructuralFeature feature,
			final ModelElementRenderer modelElementRenderer) {
		final ArrayList<AttributeRenderer> renderers = AttributeRendererRegistry.getSupportedAttributeRenderers(feature, getTemplate());
		if (attributeRendererSelector != null) {
			attributeRendererSelector.dispose();
		}

		
		attributeRendererSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);
		

		
		attributeRendererSelector.add("-", 0);
		for (int i = 0; i < renderers.size(); i++) {
			attributeRendererSelector.add(renderers.get(i).getClass().getSimpleName(), i + 1);
		}
		
		attributeRendererSelector.getParent().layout(true);
		
		attributeRendererSelector.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				int selectionIndex = ((Combo) e.widget).getSelectionIndex();
				if (attributeOptionsSubContainer != null) {
					attributeOptionsSubContainer.dispose();
				}
				attributeOptionsSubContainer = new Composite(attributeOptionsContainer, SWT.FILL);
				GridLayout gLayout4 = new GridLayout();
				GridData gData4 = new GridData(GridData.FILL_HORIZONTAL);
				attributeOptionsSubContainer.setLayout(gLayout4);
				attributeOptionsSubContainer.setLayoutData(gData4);
				if (selectionIndex == 0) {
					modelElementRenderer.removeAttributeRenderer(feature);
				} else {
					AttributeRenderer attributeRenderer = renderers.get(selectionIndex - 1);
					modelElementRenderer.setAttributeRenderer(feature, attributeRenderer);
					AttributeOptionFactory factory = new AttributeOptionFactory();
					AttributeOption attributeOption = attributeRenderer.getAttributeOption();
					if (attributeOption != null) {
						factory.buildOptionsFormular(attributeOptionsSubContainer, attributeRenderer.getAttributeOption());
					}	
					layoutAndPackAll();
				}
			}
		});
		
		AttributeRenderer attributeRenderer = modelElementRenderer.getAttributeRenderer(feature);
		if (attributeRenderer != null) {
			for (int i = 0; i < renderers.size(); i++) {
				if (renderers.get(i).getClass().equals(attributeRenderer.getClass())) {
					attributeRendererSelector.select(i + 1);
				}
			}
		} else {
			attributeRendererSelector.select(0);
		}
	}		

	private ArrayList<EStructuralFeature> getAttributes(EClass eClass) {
		ArrayList<EStructuralFeature> ret = new ArrayList<EStructuralFeature>();
		
		ModelElement modelElement = 
			(ModelElement)eClass.getEPackage().getEFactoryInstance().create(eClass);

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
				)
		);

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.
			getPropertyDescriptors(modelElement);
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
