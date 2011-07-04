package org.eclipse.emf.ecp.buildInValidation.providers;

import org.eclipse.emf.ecp.buildInValidation.Activator;
import org.eclipse.emf.ecp.buildInValidation.filter.ValidationFilter;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * The label provider for the validation filter.
 * 
 * @author Carmen Carlan
 * 
 */
public class ValidationFilterLabelProvider extends LabelProvider {

	private static final String DESC_NA = "There is no description available for this specific filter.";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ValidationFilter) {
			ValidationFilter validationFilter = (ValidationFilter) element;
			Image image = validationFilter.getImage();
			if (image != null) {
				return image;
			}
		}
		return Activator.getImageDescriptor("icons/defaultfiltericon.png")
				.createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof ValidationFilter) {
			ValidationFilter validationFilter = (ValidationFilter) element;
			String description = validationFilter.getName();
			if (description != null && !description.equals("")) {
				return description;
			}
		}
		return DESC_NA;
	}
}
