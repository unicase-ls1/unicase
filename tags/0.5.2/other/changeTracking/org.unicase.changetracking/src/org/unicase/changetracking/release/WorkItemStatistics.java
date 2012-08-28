/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

/**
 * Work item statistics are generated during release checking and contain the
 * total number of work items and the number of resolved ones.
 * 
 * @author jfinis
 * 
 */
public class WorkItemStatistics {

	private final int numWorkItems;
	private final int numResolved;

	/**
	 * Default constructor.
	 * 
	 * @param num total number of work items
	 * @param numResolved number of resolved ones
	 */
	public WorkItemStatistics(int num, int numResolved) {
		this.numWorkItems = num;
		this.numResolved = numResolved;
	}

	/**
	 * .
	 * 
	 * @return total number of work items
	 */
	public int getNumWorkItems() {
		return numWorkItems;
	}

	/**
	 * .
	 * 
	 * @return number of resolved work items
	 */
	public int getNumResolved() {
		return numResolved;
	}

	/**
	 * .
	 * 
	 * @return number of unfinished (i.e.) un-resolved work items
	 */
	public int getNumUnfinished() {
		return numWorkItems - numResolved;
	}

	/**
	 * Returns the resolve percentage (i.e. ratio between numbeer of resolved
	 * and total number of work items) as an int between 0 and 100
	 * 
	 * @return resolve percentage
	 */
	public int getPercentage() {
		return numResolved * 100 / numWorkItems;
	}
}
