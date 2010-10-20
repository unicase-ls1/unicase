/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * The list of the validation filters.
 * 
 * @author pfeifferc
 *
 */
public class ValidationFilterList extends ElementListSelectionDialog {

	/**
	 * The default constructor.
	 * @param parent the
	 * @param renderer the
	 */
	public ValidationFilterList(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
	}

	
	
}
