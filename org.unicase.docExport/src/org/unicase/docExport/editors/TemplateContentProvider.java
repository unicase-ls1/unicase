/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
/**
 * This ContentProvider changes the children of the LayoutOptions to the available tabs of the options.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateContentProvider extends AdapterFactoryContentProvider {

	private TemplateEditor editor;

	/**
	 * @param adapterFactory {@inheritDoc}
	 * @param editor The TemplateEditor where this view is used. The Editor is required for dirty state refreshing.
	 */
	public TemplateContentProvider(AdapterFactory adapterFactory, TemplateEditor editor) {
		super(adapterFactory);

		this.editor = editor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof LayoutOptions) {
			return editor.getLayoutTabItems().toArray();
		} else {
			return super.getChildren(object);
		}
	}

}
