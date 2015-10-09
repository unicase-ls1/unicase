/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.exportModel.Template;

/**
 * Superclass of all TabItems of the TemplateEditor. It automatically creates a ScrolledComposite into the TabItem and
 * binds the TabItem to the TabFolder and the ScrolledComposite to its content for resizing purposes.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateEditorTabItem extends CTabItem {

	private Template template;
	private ScrolledComposite scrolledComposite;
	private Composite container;
	private TemplateEditor editor;

	/**
	 * @param parent The TabFolder where this TabItem is inserted.
	 * @param template The template containing the template options which are edited in the editor
	 * @param editor The editor where the template options are edited.
	 */
	public TemplateEditorTabItem(CTabFolder parent, Template template, TemplateEditor editor) {
		super(parent, SWT.NONE);

		this.editor = editor;
		this.template = template;

		scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		GridLayout layout1 = new GridLayout();
		GridData data1 = new GridData();
		scrolledComposite.setLayout(layout1);
		scrolledComposite.setLayoutData(data1);
		setControl(scrolledComposite);

		// An additional Composite is needed to adjust the scrollbar when the content changes.
		container = new Composite(scrolledComposite, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		GridData data2 = new GridData();
		container.setLayout(layout2);
		container.setLayoutData(data2);
		scrolledComposite.setContent(container);
	}

	/**
	 * @return the template
	 */
	protected Template getTemplate() {
		return template;
	}

	/**
	 * @return the container
	 */
	protected Composite getContainer() {
		return container;
	}

	/**
	 * @return the editor
	 */
	public TemplateEditor getEditor() {
		return editor;
	}

	/**
	 * Packs and layouts all concerning SWT Elements. Additionally, the ScrolledComposite content is reset, so that the
	 * size of the scrollbar is adjusted to the changed content siize.
	 */
	protected void layoutAndPackAll() {
		getContainer().pack(true);
		getContainer().layout(true, true);

		scrolledComposite.pack(true);
		scrolledComposite.layout(true, true);

		scrolledComposite.setContent(getContainer());
		scrolledComposite.setMinSize(getContainer().computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		scrolledComposite.pack(true);
		scrolledComposite.layout(true, true);

		scrolledComposite.getParent().pack(true);
		scrolledComposite.getParent().layout(true, true);

		scrolledComposite.getParent().getParent().layout(true, true);
	}

	/**
	 * Helper function which creates a two column Composite.
	 * 
	 * @return the two Column Composite.
	 */
	protected Composite createTwoColumnComposite() {
		Composite container = new Composite(getContainer(), SWT.NONE);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayout(gLayout);
		container.setLayoutData(gData);
		gLayout.numColumns = 2;

		return container;
	}
}
