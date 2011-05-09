/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.validation;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;

/**
 * The list of the validation filters.
 * 
 * @author pfeifferc
 */
public class ValidationFilterList extends ListSelectionDialog {

	/**
	 * @param parentShell the
	 * @param input the
	 * @param contentProvider the
	 * @param labelProvider the
	 * @param message the
	 */
	public ValidationFilterList(Shell parentShell, Object input, IStructuredContentProvider contentProvider,
		ILabelProvider labelProvider, String message) {
		super(parentShell, input, contentProvider, labelProvider, message);
	}

}
