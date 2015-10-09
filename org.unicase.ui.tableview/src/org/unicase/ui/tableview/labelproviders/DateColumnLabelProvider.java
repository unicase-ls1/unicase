/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import java.text.Format;
import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.unicase.model.UnicaseModelElement;

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

		String formatedDate = "";
		Format formatter = new SimpleDateFormat("yyyy MM.dd. HH:mm:ss");
		if (element instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) element;
			Object date = me.eGet(feature);
			if (date != null) {
				try {
					formatedDate = formatter.format(date);
				} catch (IllegalArgumentException e) {
					formatedDate = "";
				}

				return formatedDate;
			}
		}
		return formatedDate;
	}

}
