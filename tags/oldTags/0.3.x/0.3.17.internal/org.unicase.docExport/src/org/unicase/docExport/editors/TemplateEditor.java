/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Sebastian Hoecht
 */
public class TemplateEditor extends EditorPart {

	private CTabFolder tabFolder;

	private ScrolledComposite modelElementRendererScrolledComposite;
	private ScrolledComposite layoutOptionsScrolledComposite;
	private ModelElementRenderersTab modelElementRenderersTab;

	
	
	/**
	 * .
	 */
	public static final String COMMAND_ID = "org.unicase.docExport.callTemplateEditor";

	/**
	 * .
	 */
	public static final String ID = "org.unicase.docExport.editors.TemplateEditor";

	/**
	 * this supress warning is temporarily!! TODO remove this suprress warning.. old template will be needed for dirty
	 * check
	 */
	@SuppressWarnings("unused")
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
		} else {
			try {
				TemplateRegistry.saveTemplate(getTemplate());
			} catch (TemplateSaveException e) {
				WorkspaceUtil.log("could not save the Template", e, IStatus.ERROR);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
		Template template2 = (Template) EcoreUtil.copy(getTemplate());
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
		this.oldTemplate = (Template) EcoreUtil.copy(this.getTemplate());
		setPartName(getTemplate().getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		// return !EcoreUtil.equals(template, oldTemplate);

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
		tabFolder = new CTabFolder(parent, SWT.LEAD);
		tabFolder.setBackground(new Color(parent.getShell().getDisplay(), 240, 240, 240));
		GridLayout tabLayout = new GridLayout();
		tabLayout.numColumns = 1;
		GridData tabLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		tabLayoutData.grabExcessHorizontalSpace = true;
		tabFolder.setLayout(tabLayout);
		tabFolder.setLayoutData(tabLayoutData);

		modelElementRendererScrolledComposite = createTab("ModelElement Renderers");
		layoutOptionsScrolledComposite = createTab("layoutOptions");

		modelElementRenderersTab = new ModelElementRenderersTab(modelElementRendererScrolledComposite, SWT.NONE,
			tabFolder, getTemplate());

		new LayoutOptionsTab(layoutOptionsScrolledComposite, SWT.NONE, tabFolder, getTemplate());
	}

	/**
	 * @param modelElementEClass the Model Element type which shall be selected
	 */
	public void chooseModelElementType(EClass modelElementEClass) {
		modelElementRenderersTab.chooseModelElementType(modelElementEClass);
	}

	/**
	 * @param modelElementEClass the EClass of the modelElement
	 * @param featureName the name of the requested feature
	 */
	public void chooseFeature(EClass modelElementEClass, String featureName) {
		modelElementRenderersTab.chooseFeature(modelElementEClass, featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		tabFolder.setFocus();
	}

	private ScrolledComposite createTab(String text) {
		CTabItem tabItem1 = new CTabItem(tabFolder, SWT.BOTTOM);
		tabItem1.setText(text);
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER
			| SWT.BOTTOM);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		GridLayout layout1 = new GridLayout();
		GridData data1 = new GridData();
		scrolledComposite.setLayout(layout1);
		scrolledComposite.setLayoutData(data1);
		tabItem1.setControl(scrolledComposite);
		
		return scrolledComposite;
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}

}
