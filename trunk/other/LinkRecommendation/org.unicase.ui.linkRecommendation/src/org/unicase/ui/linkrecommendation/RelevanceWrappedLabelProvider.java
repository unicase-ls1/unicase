/**
 * <copyright> Copyright (c) 2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.linkrecommendation;

import java.text.NumberFormat;
import java.util.Map;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.unicase.model.ModelElement;

public class RelevanceWrappedLabelProvider extends AdapterFactoryLabelProvider {

	Map<ModelElement, Double> relevanceValues;

	public RelevanceWrappedLabelProvider(Map<ModelElement, Double> relevanceVals) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.relevanceValues = relevanceVals;
	}

	@Override
	public String getText(Object o) {
		String text = super.getText(o);
		if (o instanceof ModelElement) {
			Double sim = relevanceValues.get(o);
			if (sim != null)
				return text + " (Relevance: " + formatDouble(sim) + ")";
		}
		return text;
	}

	public static String formatDouble(double val) {
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(4);

		return n.format(val);
	}
}
