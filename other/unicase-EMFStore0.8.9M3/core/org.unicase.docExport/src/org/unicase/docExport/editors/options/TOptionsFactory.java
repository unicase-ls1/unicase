/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * Creates some SWT Elements which are bound to a TemplateEditor enabling The user to edit the Options of a Renderer.
 * 
 * @author Sebastian Hoecht
 */
public final class TOptionsFactory {

	private TOptionsFactory() {
	}

	/**
	 * Creates some SWT Elements which are bound to a TemplateEditor enabling The user to edit the Options of a
	 * Renderer.
	 * 
	 * @param option the RendererOption
	 * @param parent SWT parent
	 * @param editor the TemplateEditor
	 */
	public static void build(RendererOption option, Composite parent, TemplateEditor editor) {
		if (option instanceof TextOption) {
			new TTextoption(parent, editor, ((TextOption) option).getName(), (TextOption) option);
		} else {
			WorkspaceUtil.log("Unknown RendererOption type", new Exception(), IStatus.ERROR);
		}
	}

}
