package org.unicase.model.search.views.validator;

import java.util.List;

import org.eclipse.jface.dialogs.IInputValidator;

/**
 * Validates a description for search parameter.
 * @author Markus Fischer
 *
 */
public class DescriptionValidator implements IInputValidator {

	private List<String> descriptions;
	
	/**
	 * Creates a new validator using the existing descriptions.
	 * @param descriptions list of existing descriptions
	 */
	public DescriptionValidator(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * Validates a given description. The description is valid if it is not null 
	 * and there is not already such a description.
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	@Override
	public String isValid(String newText) {
		if (newText == null || newText.length() == 0) {
			return "Please enter a description";
		} else {
			for (String description : descriptions) {
				if (newText.equals(description)) {
					return "There is already a query '" + newText + "'";
				}
			}
		}
		return null;
	}

}
