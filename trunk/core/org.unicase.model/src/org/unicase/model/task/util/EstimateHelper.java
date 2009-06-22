/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.Iterator;
import java.util.Set;

import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;

/**
 * EstimateHelper for calculating estimates of ModelElements.
 * 
 * @author hohenegg
 */
public final class EstimateHelper {

	private EstimateHelper() {
		// Added to satisfy checkstyle. Nothing to do here.
	}

	/**
	 * @param me the ModelElement you want to aggregate the estimate for
	 * @return the sum of estimates of all closed items beneath this WorkPackage
	 */
	public static int getClosedAggregatedEstimate(ModelElement me) {
		return genericCounter(me, new ClosedAggregator());
	}

	/**
	 * @param me the ModelElement you want to count closed Tasks for
	 * @return the number of all closed tasks beneath the ModelElement
	 */
	public static int getClosedTasks(ModelElement me) {
		return genericCounter(me, new ClosedIncrementor());
	}

	/**
	 * @param me the ModelElement you want to aggregate the estimate for
	 * @return the sum of estimates of all items beneath this WorkPackage and the WorkPackage itself
	 */
	public static int getAggregatedEstimate(ModelElement me) {
		return genericCounter(me, new AllAggregator());
	}

	/**
	 * @param me the ModelElement you want to count open Tasks for
	 * @return the number of all open tasks beneath the ModelElement
	 */
	public static int getOpenTasks(ModelElement me) {
		return genericCounter(me, new AllIncrementor());
	}

	/**
	 * Superclass for the two different operations that can be done here.
	 */
	private static interface FunctionPointer {
		int execute(WorkItem workItem, int currentResult);
	}

	/**
	 * Class that provides only one operation for incrementing a number depending on the state (OPEN/CLOSED) of a
	 * WorkItem.
	 */
	private static class ClosedIncrementor implements FunctionPointer {
		public int execute(WorkItem workItem, int currentResult) {
			if (workItem.getState().equals(MEState.CLOSED)) {
				currentResult++;
			}
			return currentResult;
		}
	}

	/**
	 * Increments for all WorkItems independent of their state.
	 */
	private static class AllIncrementor implements FunctionPointer {
		public int execute(WorkItem workItem, int currentResult) {
			currentResult++;
			return currentResult;
		}
	}

	/**
	 * Class that provides only one operation for adding the estimate of a WorkItem to a given number, considering only
	 * CLOSED WorkItems.
	 */
	private static class ClosedAggregator implements FunctionPointer {
		public int execute(WorkItem workItem, int currentResult) {
			if (workItem.getState().equals(MEState.CLOSED)) {
				currentResult += workItem.getEstimate();
			}
			return currentResult;
		}
	}

	/**
	 * Class that provides only one operation for adding the estimate of a WorkItem to a given number.
	 */
	private static class AllAggregator implements FunctionPointer {
		public int execute(WorkItem workItem, int currentResult) {
			currentResult += workItem.getEstimate();
			return currentResult;
		}
	}

	/**
	 * Iterate over all LeafOpeners of a ModelElement and execute a given operation. This methods exists to prevent
	 * redundancy.
	 */
	private static int genericCounter(ModelElement me, FunctionPointer operation) {
		int result = 0;

		Set<ModelElement> leafOpeners = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(me);
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement nextMe = iterator.next();
			if (me instanceof WorkItem) {
				WorkItem workItem = (WorkItem) nextMe;
				// result = operation.execute(state, workItem, result);
				result = operation.execute(workItem, result);
			}
		}

		return result;
	}
}
