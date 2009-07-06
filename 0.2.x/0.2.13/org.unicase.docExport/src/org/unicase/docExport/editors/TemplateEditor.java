package org.unicase.docExport.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.unicase.docExport.AttributeRendererRegistry;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.views.AttributeOptionFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class TemplateEditor extends EditorPart {

	private TabFolder tabFolder;
	
	private Composite globalAttributeOptionsTab;
	private Composite layoutOptionsTab;
	private Composite modelElementRenderersTab;
	
	private Composite rendererSelectContainer;
	
	private Group attributeOptionsContainer;
	private Group rendererOptionsContainer;
	private Composite optionsContainer;
	
	private Combo modelElementRendererSelect;
	private Combo attributeRendererSelector;
	
	/**
	 * .
	 */
	public static final String COMMAND_ID = "org.unicase.docExport.callTemplateEditor";
	
	/**
	 * .
	 */
	public static final String ID = "org.unicase.docExport.editors.TemplateEditor";
	
	private Template oldTemplate;
	private Template template;
	
	/**
	 * The default constructor.
	 */
	public TemplateEditor () {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			TemplateRegistry.saveTemplate(template);
		} catch (TemplateSaveException e) {
			WorkspaceUtil.log(
					"could not save the Template",
					e,
					IStatus.ERROR
				);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
		TemplateSaveAsDialog dialog = new TemplateSaveAsDialog(this.getSite().getShell(), template);
		dialog.open();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
	
		setSite(site);
		setInput(input);
		
		this.template = ((TemplateEditorInput) input).getTemplate();
		this.oldTemplate = this.template;
		setPartName(template.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		oldTemplate.getName(); //rofl.. just to kill the warning of not read locally...
//		return !template.equals(oldTemplate);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		tabFolder = new TabFolder(parent, SWT.LEAD);
		GridLayout tabLayout = new GridLayout();
		tabLayout.numColumns = 1;
		GridData tabLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		tabLayoutData.grabExcessHorizontalSpace = true;
		tabFolder.setLayout(tabLayout);
		tabFolder.setLayoutData(tabLayoutData);
	
		TabItem tabItem1 = new TabItem(tabFolder, SWT.None);
		tabItem1.setText("ModelElement Renderers");
		ScrolledComposite sc1 = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sc1.setLayout(gLayout);
		sc1.setLayoutData(gData);
		tabItem1.setControl(sc1);	
		modelElementRenderersTab = rebuildTabContainer(modelElementRenderersTab, sc1);
		
		TabItem tabItem2 = new TabItem(tabFolder, SWT.None);
		tabItem2.setText("Layout options");
		ScrolledComposite sc2 = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		GridLayout gLayout2 = new GridLayout();
		GridData gData2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		sc1.setLayout(gLayout2);
		sc1.setLayoutData(gData2);
		tabItem1.setControl(sc2);	
		layoutOptionsTab = rebuildTabContainer(layoutOptionsTab, sc2);
		
		AttributeOptionFactory factory = new AttributeOptionFactory();
		factory.buildOptionsFormular(layoutOptionsTab, template.getLayoutOptions());
		
		TabItem tabItem3 = new TabItem(tabFolder, SWT.None);
		tabItem3.setText("global attribute options");
		ScrolledComposite sc3 = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		GridLayout gLayout3 = new GridLayout();
		GridData gData3 = new GridData(SWT.FILL, SWT.FILL, true, true);
		sc1.setLayout(gLayout3);
		sc1.setLayoutData(gData3);
		tabItem1.setControl(sc3);	
		globalAttributeOptionsTab = rebuildTabContainer(globalAttributeOptionsTab, sc3);
		
		

		rendererSelectContainer = new Composite(modelElementRenderersTab, SWT.FILL);
		GridLayout gLayout5 = new GridLayout();
		gLayout2.numColumns = 2;
		GridData gData5 = new GridData(GridData.FILL_HORIZONTAL);
		rendererSelectContainer.setLayout(gLayout5);
		rendererSelectContainer.setLayoutData(gData5);
		
		new Label(rendererSelectContainer, SWT.NONE).setText("ModelElement type");
		new Label(rendererSelectContainer, SWT.NONE).setText("ModelElement renderer");
		
		final ArrayList<EClass> modelElementTypes = DefaultDocumentTemplateBuilder.getModelElements(ModelPackage.eINSTANCE.eContents());

		Combo modelElementType = new Combo(rendererSelectContainer, SWT.READ_ONLY);
		
		optionsContainer = new Composite(modelElementRenderersTab, SWT.FILL);
		GridLayout gLayout4 = new GridLayout();
		gLayout.numColumns = 2;
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
		
		
		layout(modelElementRenderersTab);
		layout(layoutOptionsTab);
		layout(globalAttributeOptionsTab);

	}
	
	private void createRendererSelector(final EClass modelElementEClass) {
		final ArrayList<ModelElementRenderer> modelElementRenderers = ModelElementRendererRegistry.getSupportedModelElementRenderers(modelElementEClass.getName(), template);
	
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
		
		
		ModelElementRenderer modelElementRenderer = template.getModelElementRenderer(modelElementEClass);
		modelElementRendererSelect.select(0);
		if (modelElementRenderer != null) {
			for (int i = 0; i < modelElementRenderers.size(); i++) {
				if (modelElementRenderers.get(i).getClass().equals(modelElementRenderer.getClass())) {
					modelElementRendererSelect.select(i + 1);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		tabFolder.setFocus();
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
			template.setModelElementRenderer(eClass.getName(), renderer);
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
			template.removeModelElementRenderer(eClass);
		}
		

		
		attributeOptionsContainer.pack(true);
		attributeOptionsContainer.layout(true, true);
		rendererOptionsContainer.pack(true);
		rendererOptionsContainer.layout(true, true);
		
		optionsContainer.pack(true);
		optionsContainer.layout(true, true);
		
		modelElementRenderersTab.pack(true);
		modelElementRenderersTab.layout(true, true);
	}

	
	private Composite rebuildTabContainer(Composite container, ScrolledComposite parent) {
		if (container != null) {
			container.dispose();
		}
		container = new Composite(parent, SWT.FILL);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayout(gLayout);
		container.setLayoutData(gData);
		

		parent.setContent(container);
		parent.setExpandHorizontal(true);
		parent.setExpandVertical(true);
		parent.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		return container;
	}
	
	private void layout(Composite container) {
		ScrolledComposite sc = (ScrolledComposite) container.getParent();
		
		container.layout(true);
		
		sc.setContent(container);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
	
	private void createAttributeRendererSelector(
			final EStructuralFeature feature,
			final ModelElementRenderer modelElementRenderer) {
		final ArrayList<AttributeRenderer> renderers = AttributeRendererRegistry.getSupportedAttributeRenderers(feature, template);
		
		attributeRendererSelector = new Combo(attributeOptionsContainer, SWT.READ_ONLY);
		
		attributeRendererSelector.add("-", 0);
		for (int i = 0; i < renderers.size(); i++) {
			attributeRendererSelector.add(renderers.get(i).getClass().getSimpleName(), i + 1);
		}
		
		attributeRendererSelector.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				int selectionIndex = ((Combo) e.widget).getSelectionIndex();
				
				if (selectionIndex == 0) {
					modelElementRenderer.removeAttributeRenderer(feature);
				} else {
					AttributeRenderer attributeRenderer = renderers.get(selectionIndex - 1);
					modelElementRenderer.setAttributeRenderer(feature, attributeRenderer);
					AttributeOptionFactory factory = new AttributeOptionFactory();
					AttributeOption attributeOption = attributeRenderer.getAttributeOption();
					if (attributeOption != null) {
						factory.buildOptionsFormular(attributeOptionsContainer, attributeRenderer.getAttributeOption());
					}					
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

}
