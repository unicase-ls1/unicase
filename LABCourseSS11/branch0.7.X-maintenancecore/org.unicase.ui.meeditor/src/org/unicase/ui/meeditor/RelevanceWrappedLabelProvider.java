/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.meeditor;

import java.text.NumberFormat;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * Wraps the relevance around an element if present.
 * 
 * @author Henning Femmer
 */
public class RelevanceWrappedLabelProvider extends AdapterFactoryLabelProvider {

	private Map<EObject, Double> relevanceValues;

	/**
	 * The constructor.
	 * 
	 * @param relevanceVals the relevance map: element->double value
	 */
	public RelevanceWrappedLabelProvider(Map<EObject, Double> relevanceVals) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.relevanceValues = relevanceVals;
	}

	/**
	 * Returns the superclasses text, but adds the relevance if present.
	 * 
	 * @param o the object
	 * @return the wrapped text
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object o) {
		String text = super.getText(o);
		if (o instanceof EObject) {
			Double sim = relevanceValues.get(o);
			if (sim != null) {
				return text + " (Relevance: " + formatDouble(sim) + ")";
			}
		}
		return text;
	}

	/**
	 * Formats the relevance to a readable format.
	 * 
	 * @param val the double value
	 * @return a number with maximum 4 fraction digits as string
	 */
	public static String formatDouble(double val) {
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(4);

		return n.format(val);
	}
}
