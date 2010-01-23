package org.unicase.ui.web.labelproviders;

import java.text.Format;
import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EStructuralFeature;
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
