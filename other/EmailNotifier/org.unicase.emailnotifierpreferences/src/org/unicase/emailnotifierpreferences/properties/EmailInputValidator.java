package org.unicase.emailnotifierpreferences.properties;

import org.eclipse.jface.dialogs.IInputValidator;

/**
 * This class validates a String. It is used to validate the input when a NotificationGroup is added or edited. The
 * string that is validated is the name of the NotificationGroup.The string has to be between 1 and 14 characters long
 * and it may not be identical to any NotificationGroup names that already exist for the current users's project.
 * 
 * @author fuesescc
 */
class EmailInputValidator implements IInputValidator {
	
	/**
	 * Validates the String. Returns null for no error, or an error message
	 * 
	 * @param newText the String to validate
	 * @return String
	 * 
	 * @author fuesescc
	 */
	public EmailInputValidator() {
	}
	
	public String isValid(String s) {
		int len = s.length();
		if (len < 1) {
			return "Notification Group name is too short";
		}
		if (len > 14) {
			return "Notification Group name is too long";
		}
		
		return null;
	}
}
