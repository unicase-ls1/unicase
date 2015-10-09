/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;

/**
 * @author Sebastian Hoecht
 */
public class TStringAttributeOption extends Composite {

	/**
	 * This currently creates an Empty Composite, because there arent any string specific options yet.
	 * 
	 * @param parent SWT Composite parent
	 * @param option a StringAttributeOption
	 * @param editor the editor for dirty checking
	 */
	public TStringAttributeOption(Composite parent, StringAttributeOption option, TemplateEditor editor) {
		super(parent, SWT.NONE);
	}

}
