/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * Defines a tooltip support for the model element icons.
 * 
 * @author Shterev
 */
// TODO RAP
public class ModelElementClassTooltip {

	/**
	 * Default constructor.
	 * 
	 * @param control the control that should receive the tooltip
	 */
	public ModelElementClassTooltip(Control control) {
	}

	/**
	 * {@inheritDoc}
	 */
	protected String getText(Event event) {
		Object o = getElement(event);
		return ((EClass) o).getName();
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean shouldCreateToolTip(Event event) {
		final Object element = getElement(event);
		return false;
	}

	private Object getElement(Event event) {
		return event.widget.getData();
	}

	/**
	 * Enable ToolTip support for the control by creating an instance from this class.
	 * 
	 * @param control the control
	 */
	public static void enableFor(Control control) {
		new ModelElementClassTooltip(control);
	}
}
