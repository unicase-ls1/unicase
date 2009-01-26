package org.unicase.docExport.views;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
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
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.editors.AttributeOptionFactory;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;

/**
 * @author Sebastian Hoecht
 */
public class RendererOptionsTab {

	private Composite modelElementTypeList;
	private Composite rendererOptionsSelector;
	private Composite rendererOptions;

	private List rendererOptionsList;
	private final Template template;

	/**
	 * I hate you.
	 */
	public void noThisIsNotAUtilityClassStupidCheckstyle() {

	}

	/**
	 * @param parent the SWT parent where the fomular shall be added
	 * @param template the corresponding template
	 */
	public RendererOptionsTab(Composite parent, Template template) {
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

	private void createModelElementTypeList(Template template) {
		List list = new List(modelElementTypeList, SWT.BORDER);

		EList<ModelElementRendererMapping> mappings = template.getModelElementRendererMapping();
		final ArrayList<ModelElementRendererMapping> mappingList = new ArrayList<ModelElementRendererMapping>();
		mappingList.addAll(mappings);

		for (int i = 0; i < mappingList.size(); i++) {
			list.add(mappingList.get(i).getEClassName(), i);
		}

		list.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent event) {
				ModelElementRendererMapping mapping = mappingList.get(((List) event.widget).getSelectionIndices()[0]);
				createRendererOptionsSelector(mapping.getRenderer(), mapping.getEClassName());
			}
		});
	}

	private void createRendererOptionsSelector(final ModelElementRenderer renderer, final String eClassName) {
		cleanRendererOptionsSelectorContainer(rendererOptionsSelector.getParent());
		cleanRendererOptionsContainer(rendererOptions.getParent());

		Combo rendererSelect = new Combo(rendererOptionsSelector, SWT.READ_ONLY);
		final ArrayList<ModelElementRenderer> renderers = ModelElementRendererRegistry
			.getSupportedModelElementRenderers(eClassName, template);
		rendererSelect.add(renderer.eClass().getName() + " (*)", 0);
		for (int i = 0; i < renderers.size(); i++) {
			rendererSelect.add(renderers.get(i).eClass().getName(), i + 1);
		}

		rendererOptionsList = new List(rendererOptionsSelector, SWT.BORDER);

		rendererSelect.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				int selectionIndex = ((Combo) event.widget).getSelectionIndex();
				if (selectionIndex == 0) {
					template.setModelElementRenderer(eClassName, renderer);
					createRendererOptionsList(renderer);
				} else {
					template.setModelElementRenderer(eClassName, renderers.get(selectionIndex - 1));
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

		ArrayList<RendererOption> rendererOptions = new ArrayList<RendererOption>();
		rendererOptions.addAll(renderer.getRendererOptions());
		for (int i = 0; i < rendererOptions.size(); i++) {
			rendererOptionsList.add(rendererOptions.get(i).getName(), i);
		}

		rendererOptionsList.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent event) {
				createRendererOptions(renderer.getRendererOptions().get(((List) event.widget).getSelectionIndices()[0]));
			}
		});
	}

	private void createRendererOptions(RendererOption option) {
		cleanRendererOptionsContainer(rendererOptions.getParent());

		AttributeOptionFactory.buildOptionsFormular(rendererOptions, option);

		layoutTabs();
	}

	private void cleanTabContainers(Composite parent) {
		cleanModelElementTypeContainer(parent);
		cleanRendererOptionsSelectorContainer(parent);
		cleanRendererOptionsContainer(parent);
	}

	private void cleanModelElementTypeContainer(Composite parent) {
		if (modelElementTypeList != null) {
			modelElementTypeList.dispose();
		}
		modelElementTypeList = new Composite(parent, SWT.FILL | SWT.BORDER);
		modelElementTypeList.setLayout(new GridLayout());
		modelElementTypeList.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	private void cleanRendererOptionsSelectorContainer(Composite parent) {
		if (rendererOptionsSelector != null) {
			rendererOptionsSelector.dispose();
		}
		rendererOptionsSelector = new Composite(parent, SWT.FILL | SWT.BORDER);
		rendererOptionsSelector.setLayout(new GridLayout());
		rendererOptionsSelector.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	private void cleanRendererOptionsContainer(Composite parent) {
		if (rendererOptions != null) {
			rendererOptions.dispose();
		}
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
