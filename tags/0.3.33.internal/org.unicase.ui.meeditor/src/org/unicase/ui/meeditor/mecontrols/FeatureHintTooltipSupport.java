/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * Defines a tooltip support displaying brief feature descriptions as tooltip hints.
 * 
 * @author Shterev
 */
public class FeatureHintTooltipSupport extends DefaultToolTip {

	private IItemPropertyDescriptor itemPropertyDescriptor;

	/**
	 * Default constructor.
	 * 
	 * @param control the control that should receive the tooltip
	 * @param itemPropertyDescriptor the feature's property descriptor.
	 */
	public FeatureHintTooltipSupport(Control control, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(control, ToolTip.NO_RECREATE, false);
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getText(Event event) {
		Object o = getElement(event);
		String description = itemPropertyDescriptor.getDescription(o);
		return (description == null ? "No description available" : description);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean shouldCreateToolTip(Event event) {
		return (getElement(event) != null && super.shouldCreateToolTip(event));
	}

	private Object getElement(Event event) {
		return event.widget.getData();
	}

	/**
	 * Enable ToolTip support for the control by creating an instance from this class.
	 * 
	 * @param control the control
	 * @param itemPropertyDescriptor the feature's property descriptor.
	 */
	public static void enableFor(Control control, IItemPropertyDescriptor itemPropertyDescriptor) {
		new FeatureHintTooltipSupport(control, itemPropertyDescriptor);
	}
}
