/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;

/**
 * Defines a tooltip support displaying brief feature descriptions as tooltip hints.
 * 
 * @author Shterev
 */
public class FeatureHintTooltipSupport extends DefaultToolTip {

	private IItemPropertyDescriptor itemPropertyDescriptor;
	private EObject eObject;

	/**
	 * Default constructor.
	 * 
	 * @param control the control that should receive the tooltip
	 * @param itemPropertyDescriptor the feature's property descriptor.
	 * @param eObject the {@link EObject} for which the tooltip is to be displayed
	 */
	public FeatureHintTooltipSupport(Control control, IItemPropertyDescriptor itemPropertyDescriptor, EObject eObject) {
		super(control, ToolTip.NO_RECREATE, false);
		this.itemPropertyDescriptor = itemPropertyDescriptor;
		this.eObject = eObject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getText(Event event) {
		Object o = getElement(event);
		String description = itemPropertyDescriptor.getDescription(o);
		ValidationResultProvider validationResultProvider = ValidationResultProviderRegistry.getInstance()
			.getValidationResultProvider(eObject);
		if (validationResultProvider != null) {
			Set<IConstraintStatus> constraintStati = validationResultProvider
				.getConstraintStatiForInvalidEStructuralFeature(eObject, (EStructuralFeature) itemPropertyDescriptor
					.getFeature(eObject));
			if (!constraintStati.isEmpty()) {
				description += "\n\nViolations:";
			}
			for (IConstraintStatus constraintStatus : constraintStati) {
				description += "\n";
				description += " - " + constraintStatus.getMessage();
			}
		}
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
	 * @param eObject the {@link EObject} for which the tooltip is to be displayed
	 */
	public static void enableFor(Control control, IItemPropertyDescriptor itemPropertyDescriptor, EObject eObject) {
		new FeatureHintTooltipSupport(control, itemPropertyDescriptor, eObject);
	}
}
