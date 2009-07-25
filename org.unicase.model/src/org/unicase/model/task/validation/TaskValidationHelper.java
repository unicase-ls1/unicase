/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import java.util.Date;

import org.unicase.model.ModelElement;
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
	public static Date getDueDate(ModelElement obj) {
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
	public static ActivityType getActivity(ModelElement obj) {
		if (obj instanceof Issue) {
			return ((Issue) obj).getActivity();
		}
		if (obj instanceof ActionItem) {
			return ((ActionItem) obj).getActivity();
		}
		return null;
	}
}
