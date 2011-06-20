/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.utilities;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * Defines a tooltip support for the model element icons.
 * 
 * @author Shterev
 */
public class ModelElementClassTooltip extends DefaultToolTip {

	/**
	 * Default constructor.
	 * 
	 * @param control the control that should receive the tooltip
	 */
	public ModelElementClassTooltip(Control control) {
		super(control, ToolTip.NO_RECREATE, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getText(Event event) {
		Object o = getElement(event);
		return ((EClass) o).getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean shouldCreateToolTip(Event event) {
		final Object element = getElement(event);
		return (element != null && element instanceof EClass && super.shouldCreateToolTip(event));
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
