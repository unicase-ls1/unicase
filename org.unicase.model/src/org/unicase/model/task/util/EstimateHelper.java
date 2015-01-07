/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.Iterator;
import java.util.Set;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;

/**
 * EstimateHelper for computing numbers/estimates of a ModelElements LeafOpeners. LeafOpeners are a subset of all tasks
 * in the OpeningLinkTaxonomy that a ModelElements needs to be closed in order to be closed itself. See also:
 * TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(ModelElement)
 * 
 * @author hohenegg
 */
public final class EstimateHelper {
	private static final byte ALL = 1;
	private static final byte CLOSED = 2;
	private static final byte AGGREGATE = 4;
	private static final byte COUNT = 8;

	private EstimateHelper() {
		// Added to satisfy checkstyle. Nothing to do here.
	}

	/**
	 * @param me the ModelElement which you want the remaining estimate for
	 * @return the aggregated estimates of all open WorkItems
	 */
	public static int getRemainingEstimate(UnicaseModelElement me) {
		return getAggregatedEstimate(me) - getClosedAggregatedEstimate(me);
	}

	/**
	 * @param me the ModelElement you want to aggregate the estimate for
	 * @return the aggregated estimates of all closed WorkItems
	 */
	public static int getClosedAggregatedEstimate(UnicaseModelElement me) {
		return genericCounter(me, AGGREGATE, CLOSED);
	}

	/**
	 * @param me the ModelElement you want to count closed tasks for
	 * @return the number of all closed tasks in the set of LeafOpeners
	 */
	public static int getClosedTasks(UnicaseModelElement me) {
		return genericCounter(me, COUNT, CLOSED);
	}

	/**
	 * @param me the ModelElement you want to aggregate the estimate for
	 * @return the aggregated estimates of all WorkItems
	 */
	public static int getAggregatedEstimate(UnicaseModelElement me) {
		return genericCounter(me, AGGREGATE, ALL);
		// return genericCounter(me, new AllAggregator());
	}

	/**
	 * @param me the ModelElement you want to count tasks for
	 * @return the number of all tasks in the set of LeafOpeners
	 */
	public static int getAllTasks(UnicaseModelElement me) {
		return genericCounter(me, COUNT, ALL);
	}

	/**
	 * Iterate over all LeafOpeners of a ModelElement with matching state and return the aggregated estimate/number of
	 * iterations.
	 */
	private static int genericCounter(UnicaseModelElement me, int operation, int state) {
		int result = 0;

		Set<UnicaseModelElement> leafOpeners = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(me);

		if (operation == COUNT && state == ALL) {
			// In this case .size() is probably faster
			return leafOpeners.size();
		}

		Iterator<UnicaseModelElement> iterator = leafOpeners.iterator();

		while (iterator.hasNext()) {
			UnicaseModelElement nextMe = iterator.next();

			if (state == CLOSED && !(nextMe.getState().equals(MEState.CLOSED))) {
				continue;
			}

			// Only WorkItems have estimates
			if (operation == AGGREGATE && !(nextMe instanceof WorkItem)) {
				continue;
			}

			switch (operation) {
			case COUNT:
				result++;
				break;

			case AGGREGATE:
				WorkItem workItem = (WorkItem) nextMe;
				result += workItem.getEstimate();
				break;

			default:
				continue;
			}
		}

		return result;
	}
}
