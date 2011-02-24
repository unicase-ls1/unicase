/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.dialog;

import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;

/**
 * A model element selection dialog, that allows to select each element that is contained by a project. The parent class
 * provides all that is needed, but it is abstract.
 * 
 * @author Adrian Staudt
 */
public class JDTModelElementSelectDialog extends ModelElementSelectionDialog {

	/**
	 * Constructor.
	 * 
	 * @param context The context, that defines which objects can be selected.
	 */
	public JDTModelElementSelectDialog(ECPModelelementContext context) {
		super(context, false); // no multi selection
	}

}
