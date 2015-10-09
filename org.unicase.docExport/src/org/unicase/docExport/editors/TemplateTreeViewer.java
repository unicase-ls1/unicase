/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.exportModel.Template;

/**
 * A TreeViewer showing all EMF containments of a template.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateTreeViewer extends TreeViewer {

	/**
	 * @param parent parent SWT Composite
	 * @param template the template which containments shall be shown
	 * @param templateEditor The Editor for dirty checking.
	 */
	public TemplateTreeViewer(Composite parent, Template template, TemplateEditor templateEditor) {
		super(parent);

		AdapterFactory myAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		setLabelProvider(new TemplateLabelProvider(myAdapterFactory));
		setContentProvider(new TemplateContentProvider(myAdapterFactory, templateEditor));

		getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		setInput(template);
	}
}
