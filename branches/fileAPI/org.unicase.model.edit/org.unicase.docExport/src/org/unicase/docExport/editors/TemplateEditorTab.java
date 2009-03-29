/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.exportModel.Template;

/**
 * @author Sebastian Hoecht
 */
public class TemplateEditorTab extends Composite {
	private Template template;
	private Composite containerTab;
	private CTabFolder tabFolder;

	/**
	 * @param parent the ScrolledComposite which is contained in a tabItem
	 * @param style the SWT style
	 * @param tabFolder the tabFolder where the ScrolledComposite is contained
	 * @param template the template for this Formular
	 */
	public TemplateEditorTab(Composite parent, int style, CTabFolder tabFolder, Template template) {
		super(parent, style);
		this.setTemplate(template);
		this.setTabFolder(tabFolder);
		// this.setContainerTab(containerTab);
	}

	/**
	 * @param modelElementRenderersTab the modelElementRenderersTab to set
	 */
	protected void setContainerTab(Composite modelElementRenderersTab) {
		this.containerTab = modelElementRenderersTab;
	}

	/**
	 * @return the modelElementRenderersTab
	 */
	protected Composite getContainerTab() {
		return containerTab;
	}

	/**
	 * @param tabFolder the tabFolder to set
	 */
	protected void setTabFolder(CTabFolder tabFolder) {
		this.tabFolder = tabFolder;
	}

	/**
	 * @return the tabFolder
	 */
	protected CTabFolder getTabFolder() {
		return tabFolder;
	}

	/**
	 * @param template the template to set
	 */
	protected void setTemplate(Template template) {
		this.template = template;
	}

	/**
	 * @return the template
	 */
	protected Template getTemplate() {
		return template;
	}

	/**
	 * re Layout and packs all important SWT composites. This is needed if the contents are changed.
	 */
	protected void layoutAndPack() {
		getContainerTab().pack(true);
		getContainerTab().layout(true, true);

		ScrolledComposite scrolledComposite = (ScrolledComposite) getContainerTab().getParent();
		scrolledComposite.pack(true);
		scrolledComposite.layout(true, true);

		getTabFolder().pack(true);
		getTabFolder().layout(true, true);

		scrolledComposite.setContent(getContainerTab());
		scrolledComposite.setMinSize(getContainerTab().computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		scrolledComposite.pack(true);
		scrolledComposite.layout(true, true);

		scrolledComposite.getParent().pack(true);
		scrolledComposite.getParent().layout(true, true);

		getTabFolder().getParent().layout(true, true);
	}
}
