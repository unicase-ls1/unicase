package org.unicase.documentexport.views;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererRegistry;
import org.unicase.documentexport.renderers.modelElement.ModelElementRendererMappings.ModelElementRendererMapping;
import org.unicase.documentexport.renderers.options.RendererOption;
import org.unicase.documentexport.views.RendererOptionFactory.AttributeOptionFactory;
import org.unicase.model.ModelElement;

public class RendererOptions {
	
	Composite modelElementTypeList;
	Composite rendererOptionsSelector;
	Composite rendererOptions;
	
	List rendererOptionsList;
	DocumentTemplate template;
	
	
	public RendererOptions(Composite parent, DocumentTemplate template) {
		this.template = template;
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gLayout2 = new GridLayout();
		gLayout2.numColumns = 3;
		gLayout2.makeColumnsEqualWidth = false;
		composite.setLayout(gLayout2);
		GridData gdata2 = new GridData();
		composite.setLayoutData(gdata2);
		
		cleanTabContainers(composite);
		

		createModelElementTypeList(template);

		
		
		layoutTabs();
	}
	
	private void createModelElementTypeList(DocumentTemplate template) {
		List list = new List(modelElementTypeList, SWT.BORDER);
		
		ModelElementRendererMappings mappings = template.modelElementRendererMappings;
		final ArrayList<ModelElementRendererMapping> mappingList = mappings.getRendererList();

		for (int i = 0; i < mappingList.size(); i++) {
			list.add(mappingList.get(i).modelElementType.getSimpleName(), i);	
		}

		
		list.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent event) {
				ModelElementRendererMapping mapping = mappingList.get(((List)event.widget).getSelectionIndices()[0]);
				createRendererOptionsSelector(mapping.renderer, mapping.modelElementType);
			}
		});
	}
	
	private void createRendererOptionsSelector(final ModelElementRenderer renderer, final Class<ModelElement> clazz) {
		cleanRendererOptionsSelectorContainer(rendererOptionsSelector.getParent());
		cleanRendererOptionsContainer(rendererOptions.getParent());
		
		
		
		Combo rendererSelect = new Combo(rendererOptionsSelector, SWT.READ_ONLY);
		final ArrayList<ModelElementRenderer> renderers = ModelElementRendererRegistry.getSupportedModelElementRenderers(clazz);
		rendererSelect.add(renderer.getClass().getSimpleName(), 0);
		for (int i = 0; i < renderers.size(); i++){
			rendererSelect.add(renderers.get(i).getClass().getSimpleName(), i + 1);
		}
		
		final DocumentTemplate template2 = this.template;
		
		rendererOptionsList = new List(rendererOptionsSelector, SWT.BORDER);

		rendererSelect.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				int selectionIndex = ((Combo)event.widget).getSelectionIndex();
				if (selectionIndex == 0) {
					template2.modelElementRendererMappings.set(clazz, renderer);
					createRendererOptionsList(renderer);
				}
				else {
					template2.modelElementRendererMappings.set(clazz, renderers.get(selectionIndex - 1) );
					createRendererOptionsList(renderers.get(selectionIndex - 1));	
				}
									
				layoutTabs();
				cleanRendererOptionsContainer(rendererOptions.getParent());
				
			}
		});		
		
		rendererSelect.select(0);
		
		layoutTabs();
	}
	
	private void createRendererOptionsList(final ModelElementRenderer renderer) {
		rendererOptionsList.dispose();
		rendererOptionsList = new List(rendererOptionsSelector, SWT.BORDER);
		
		ArrayList<RendererOption> rendererOptions = renderer.rendererOptions;
		for (int i = 0; i < rendererOptions.size(); i++) {
			rendererOptionsList.add(rendererOptions.get(i).getName(), i);
		}
		
		
		rendererOptionsList.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent event) {
				createRendererOptions(renderer.rendererOptions.get(((List)event.widget).getSelectionIndices()[0]));	
			}
		});
	}
	
	private void createRendererOptions(RendererOption option) {
		cleanRendererOptionsContainer(rendererOptions.getParent());
		
		AttributeOptionFactory factory = new AttributeOptionFactory();
		factory.buildOptionsFormular(rendererOptions, option);
		
		layoutTabs();
	}
	
	
	
	
	
	private void cleanTabContainers(Composite parent) {		
		cleanModelElementTypeContainer(parent);
		cleanRendererOptionsSelectorContainer(parent);
		cleanRendererOptionsContainer(parent);
	}	
	
	private void cleanModelElementTypeContainer(Composite parent) {
		if (modelElementTypeList != null)
			modelElementTypeList.dispose();
		modelElementTypeList = new Composite(parent, SWT.FILL | SWT.BORDER);
		modelElementTypeList.setLayout(new GridLayout());
		modelElementTypeList.setLayoutData(new GridData(GridData.FILL_BOTH));	
	}
	
	private void cleanRendererOptionsSelectorContainer(Composite parent) {
		if (rendererOptionsSelector != null)
			rendererOptionsSelector.dispose();
		rendererOptionsSelector = new Composite(parent, SWT.FILL | SWT.BORDER);
		rendererOptionsSelector.setLayout(new GridLayout());
		rendererOptionsSelector.setLayoutData(new GridData(GridData.FILL_BOTH));		
	}
	
	private void cleanRendererOptionsContainer(Composite parent) {
		if (rendererOptions != null)
			rendererOptions.dispose();
		rendererOptions = new Composite(parent, SWT.FILL | SWT.BORDER);
		rendererOptions.setLayout(new GridLayout(2, false));
		rendererOptions.setLayoutData(new GridData(GridData.FILL_BOTH));		
	}
	
	private void layoutTabs() {
		modelElementTypeList.pack();
		modelElementTypeList.getParent().pack();
		modelElementTypeList.getParent().getParent().pack();
		modelElementTypeList.getParent().layout(true, true);
		rendererOptionsSelector.getParent().layout(true, true);
		rendererOptionsSelector.pack();
		rendererOptionsSelector.getParent().pack();
		rendererOptionsSelector.getParent().getParent().pack();
		rendererOptions.getParent().layout(true, true);	
	}
	
}
