/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * Defines a tooltip support for the model element link widget.
 * 
 * @author Shterev
 */
// TODO RAP
public class ModelElementTooltip {

	private AdapterFactoryLabelProvider labelProvider;

	/**
	 * Default constructor.
	 * 
	 * @param control the control that should receive the tooltip
	 */
	public ModelElementTooltip(Control control) {
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	protected String getText(Event event) {
		Object o = getElement(event);
		return labelProvider.getText(o);

	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean shouldCreateToolTip(Event event) {
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
		new ModelElementTooltip(control);
	}
}
