/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import java.text.Format;
import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.unicase.model.ModelElement;

/**
 * @author hamidmomeny
 */
public class DateColumnLabelProvider extends ColumnLabelProvider {

	private EStructuralFeature feature;

	/**
	 * default constructor.
	 * 
	 * @param feature the feature.
	 */
	public DateColumnLabelProvider(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		if (!feature.getEType().equals(EcorePackage.Literals.EDATE)) {
			return "";
		}

		Format formatter = new SimpleDateFormat("yyyy MM.dd. HH:mm:ss");
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			Object date = me.eGet(feature);
			if (date != null) {
				return formatter.format(date);
			}
		}

		return "";
	}

}
