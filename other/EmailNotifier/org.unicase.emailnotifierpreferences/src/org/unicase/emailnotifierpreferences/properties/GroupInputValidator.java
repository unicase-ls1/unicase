/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
public class GroupInputValidator implements IInputValidator {
	
	private List<NotificationGroup> tempNotificationGroups;
	private Integer max;
	
	/**
	 * GroupInputValidator Constructor
	 * 
	 * @param max The maximum length that a Notification Group can have
	 * @param tempNotificationGroups A List of Notification Groups
	 * @author fuesescc
	 */
	public GroupInputValidator(List<NotificationGroup> tempNotificationGroups, Integer max) {
		this.tempNotificationGroups = tempNotificationGroups;
		this.max = max;
	}
	
	/**
	 * Validates the String. Returns null for no error, or an error message
	 * 
	 * @param s the String to validate
	 * @return String The error message
	 * @author fuesescc
	 */
	public String isValid(String s) {
		int len = s.length();
		if (len < 1) {
			return "Notification Group name is too short";
		}
		if (len > max) {
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
