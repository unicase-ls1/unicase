/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

/**
 * Computer related tasks directly.
 * 
 * @author hodaie
 */
public class ImperativeAssigneePrediction implements AssigneePredictionStrategy {

	/**
	 * {@inheritDoc}
	 */
	public OrgUnit predictAssignee(WorkItem task) {
		return null;
	}

}
