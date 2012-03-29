/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.editors.tabItems.LayoutOptionsCoverpageTabItem;
import org.unicase.docExport.editors.tabItems.LayoutOptionsGeneralTabItem;
import org.unicase.docExport.editors.tabItems.LayoutOptionsHeaderAndFooterTabItem;
import org.unicase.docExport.editors.tabItems.LayoutOptionsLogoTabItem;
import org.unicase.docExport.editors.tabItems.LayoutOptionsSectionTabItem;
import org.unicase.docExport.editors.tabItems.ModelElementRenderersTabItem;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;

/**
 * A template editor for all the options of a template.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateEditor extends EditorPart {

	private CTabFolder tabFolder;

	private ModelElementRenderersTabItem modelElementRenderersTabItem;
	private ArrayList<TemplateEditorTabItem> layoutTabItems = new ArrayList<TemplateEditorTabItem>();

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
	public TemplateEditor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		if (getTemplate().isDefaultTemplate()) {
			MessageBox messageBox = new MessageBox(PlatformUI.getWorkbench().getDisplay().getActiveShell());
			messageBox.setMessage("you can't save a default template. Use save as instead");
			messageBox.open();

			Template newTemplate = EcoreUtil.copy(template);

			TemplateSaveAsDialog dialog = new TemplateSaveAsDialog(PlatformUI.getWorkbench().getDisplay()
				.getActiveShell(), newTemplate);

			dialog.open();
		} else {
			try {
				TemplateRegistry.saveTemplate(getTemplate());
				oldTemplate = EcoreUtil.copy(template);
				testDirty();
			} catch (TemplatesFileNotFoundException e) {
				WorkspaceUtil.log("could not save the Template", e, IStatus.WARNING);
				MessageBox messageBox = new MessageBox(PlatformUI.getWorkbench().getDisplay().getActiveShell());
				messageBox.setMessage("Saving the template failed!");
				messageBox.open();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
		Template template2 = EcoreUtil.copy(getTemplate());
		template2.setDefaultTemplate(false);
		TemplateSaveAsDialog dialog = new TemplateSaveAsDialog(this.getSite().getShell(), template2);
		dialog.open();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

		setSite(site);
		setInput(input);

		this.template = ((TemplateEditorInput) input).getTemplate();
		this.oldTemplate = EcoreUtil.copy(this.getTemplate());
		setPartName(getTemplate().getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return !EcoreUtil.equals(template, oldTemplate);
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
		Composite twoColumn = new Composite(parent, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		GridData gData = new GridData(GridData.FILL_BOTH);
		twoColumn.setLayout(gLayout);
		twoColumn.setLayoutData(gData);

		createTemplateTreeViewer(twoColumn, template);

		tabFolder = new CTabFolder(twoColumn, SWT.TOP);
		tabFolder.setTabPosition(SWT.BOTTOM);
		tabFolder.setBackground(new Color(parent.getShell().getDisplay(), 240, 240, 240));
		GridLayout tabLayout = new GridLayout();
		tabLayout.numColumns = 1;
		GridData tabLayoutData = new GridData(GridData.FILL_BOTH);
		tabLayoutData.grabExcessHorizontalSpace = true;
		tabFolder.setLayout(tabLayout);
		tabFolder.setLayoutData(tabLayoutData);

		modelElementRenderersTabItem = new ModelElementRenderersTabItem(tabFolder, template, this);
		getLayoutTabItems().add(new LayoutOptionsGeneralTabItem(tabFolder, template, this));
		getLayoutTabItems().add(new LayoutOptionsHeaderAndFooterTabItem(tabFolder, template, this));
		getLayoutTabItems().add(new LayoutOptionsCoverpageTabItem(tabFolder, template, this));
		getLayoutTabItems().add(new LayoutOptionsSectionTabItem(tabFolder, template, this));
		getLayoutTabItems().add(new LayoutOptionsLogoTabItem(tabFolder, template, this));

		tabFolder.setSelection(layoutTabItems.get(0));
		tabFolder.setBackground(new Color(Display.getDefault(), 255, 255, 255));
	}

	private void createTemplateTreeViewer(Composite parent, Template template) {
		TemplateTreeViewer viewer = new TemplateTreeViewer(parent, template, this);

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getTree());
		viewer.getTree().setMenu(menu);

		getSite().registerContextMenu(menuManager, viewer);
		getSite().setSelectionProvider(viewer);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection sel = event.getSelection();
				if (sel instanceof IStructuredSelection) {
					IStructuredSelection ssel = (IStructuredSelection) sel;
					if (!ssel.isEmpty()) {
						Object o = ssel.getFirstElement();
						if ((o instanceof ModelElementRendererMapping)) {
							tabFolder.setSelection(modelElementRenderersTabItem);
							ModelElementRendererMapping mapping = (ModelElementRendererMapping) o;
							modelElementRenderersTabItem.chooseModelElementType(ModelElementRendererRegistry
								.getEClassOfString(mapping.getEClassName()));
						} else if (o instanceof TemplateEditorTabItem) {
							tabFolder.setSelection((TemplateEditorTabItem) o);
						}
					}
				}
			}

		});

		getSite().setSelectionProvider(viewer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		tabFolder.setFocus();
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}

	/**
	 * trigger the dirty event.
	 */
	public void testDirty() {
		firePropertyChange(TemplateEditor.PROP_DIRTY);
	}

	/**
	 * @return the modelElementRenderersTab
	 */
	public ModelElementRenderersTabItem getModelElementRenderersTabItem() {
		return modelElementRenderersTabItem;
	}

	/**
	 * @return the layoutTabItems
	 */
	public ArrayList<TemplateEditorTabItem> getLayoutTabItems() {
		return layoutTabItems;
	}
}
