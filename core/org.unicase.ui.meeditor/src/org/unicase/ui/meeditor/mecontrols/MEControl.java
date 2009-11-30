/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;

/**
 * Interface for all ME controls.
 * 
 * @author helming
 */
public interface MEControl {

	/**
	 * The default constant in case the widgets decides it shouldn't render the attribute.
	 */
	int DO_NOT_RENDER = Integer.MIN_VALUE;

	/**
	 * Creates and renders the control in the parent composite.
	 * 
	 * @param parent the parent composite
	 * @param style the style for rendering
	 * @return the control
	 */
	Control createControl(Composite parent, int style);

	/**
	 * @param editingDomain the editing domain
	 * @param modelElement the ME
	 * @param toolkit gui toolkit used for rendering
	 * @param itemPropertyDescriptor the ItemPropertyDescriptor
	 * @return the integer priority for rendering this widget (higher number for higher priority). Widgets can choose
	 *         not to render by returning MEControl#DO_NOT_RENDER.
	 */
	int init(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement, EditingDomain editingDomain,
		FormToolkit toolkit);

	/**
	 * Disposes the control correctly by removing all model listeners.
	 */
	void dispose();

}
