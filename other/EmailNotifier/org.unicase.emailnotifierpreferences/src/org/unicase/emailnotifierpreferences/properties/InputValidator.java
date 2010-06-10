package org.unicase.emailnotifierpreferences.properties;

import java.util.List;

import org.eclipse.jface.dialogs.IInputValidator;
import org.unicase.model.emailnotificationgroup.NotificationGroup;

/**
 * This class validates a String. It is used to validate the input when a NotificationGroup is added or edited. The
 * string that is validated is the name of the NotificationGroup.The string has to be between 1 and 14 characters long
 * and it may not be identical to any NotificationGroup names that already exist for the current users's project.
 * 
 * @author fuesescc
 */
class InputValidator implements IInputValidator {
	
	private List<NotificationGroup> tempNotificationGroups;
	/**
	 * Validates the String. Returns null for no error, or an error message
	 * 
	 * @param newText the String to validate
	 * @return String
	 * @author fuesescc
	 * @param tempNotificationGroups 
	 */
	public InputValidator(List<NotificationGroup> tempNotificationGroups) {
		this.tempNotificationGroups = tempNotificationGroups;
	}
	public String isValid(String s) {
		int len = s.length();
		if (len < 1) {
			return "Notification Group name is too short";
		}
		if (len > 14) {
			return "Notification Group name is too long";
		}
		for (int i = 0; i < tempNotificationGroups.size(); i++) {
			if (s.equals(tempNotificationGroups.get(i).getNotificationGroupName())) {
				return "A Notification Group with this name already exists";
			}
		}
		return null;
	}
}
