/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import org.unicase.model.task.WorkItem;

/**
 * Interface for sprint status view filters.
 * 
 * @author Shterev
 */
public interface SprintFilter {

	/**
	 * @param workItem the work item
	 * @return true if the work item meets this filters criteria
	 */
	boolean accept(WorkItem workItem);

}
