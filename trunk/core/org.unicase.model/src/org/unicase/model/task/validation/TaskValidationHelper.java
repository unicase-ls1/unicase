/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import java.util.Date;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;

/**
 * Helper for task validation.
 * 
 * @author helming
 */
public abstract class TaskValidationHelper {
	private TaskValidationHelper() {
	}

	/**
	 * Returns the due date of an modelelemtn or null if the modelement has none.
	 * 
	 * @param obj the modelelement
	 * @return the due date
	 */
	public static Date getDueDate(UnicaseModelElement obj) {
		if (obj instanceof Issue) {
			return ((Issue) obj).getDueDate();
		}
		if (obj instanceof ActionItem) {
			return ((ActionItem) obj).getDueDate();
		}
		return null;
	}

	/**
	 * Returns the activity of an modelelemtn or null if the modelement has none.
	 * 
	 * @param obj the modelelement
	 * @return the activity
	 */
	public static ActivityType getActivity(UnicaseModelElement obj) {
		if (obj instanceof Issue) {
			return ((Issue) obj).getActivity();
		}
		if (obj instanceof ActionItem) {
			return ((ActionItem) obj).getActivity();
		}
		return null;
	}
}
