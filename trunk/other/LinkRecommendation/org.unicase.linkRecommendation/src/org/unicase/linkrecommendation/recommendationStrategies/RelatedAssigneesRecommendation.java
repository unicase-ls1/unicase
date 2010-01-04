/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

/**
 * This method tries to find the related assignee and looks at his other items. In case a couple of those are suggested
 * they are ranked higher than others.
 * 
 * @author Henning Femmer
 */
public class RelatedAssigneesRecommendation implements RecommendationStrategy {

	private boolean ignoreEnabled;

	/**
	 * The standard constructor.
	 */
	public RelatedAssigneesRecommendation() {
		this(false);
	}

	/**
	 * The constructor for testing. The base will be ignored at a certain point. Don't use it in running applications.
	 * 
	 * @param ignoreEnabled set it to true in testing cases.
	 */
	public RelatedAssigneesRecommendation(boolean ignoreEnabled) {
		this.ignoreEnabled = ignoreEnabled;
	}

	/**
	 * This method returns value pairs (ModelElement, Double) which indicate how probable a certain element might be
	 * linked.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		HashMap<ModelElement, Double> result = new HashMap<ModelElement, Double>();
		double max = 1.0;

		if (base instanceof WorkItem) {
			WorkItem wi = (WorkItem) base;
			OrgUnit wu = wi.getAssignee();

			// has no assignee
			if (wu == null) {
				return result;
			}
			// CHANGED FROM GET LINKED MES
			EList<WorkItem> relatedWIs = wu.getAssignments();

			// System.out.println(wi.getName());
			// System.out.println("Assignee:" + wu.getName());

			for (WorkItem item : relatedWIs) {
				if (ignoreEnabled && item == base) {
					continue;
				}

				Set<ModelElement> linkedMEs = item.getLinkedModelElements();
				linkedMEs.retainAll(elements);
				// the work unit is not of interest.
				linkedMEs.remove(wu);

				for (ModelElement me : linkedMEs) {
					// count it, add it up
					if (result.containsKey(me)) {
						Double newVal = result.get(me) + 1;
						result.put(me, newVal);
						if (newVal > max) {
							max = newVal;
						}
					} else {
						result.put(me, 1.0);
					}
					// System.out.println("ME:" + me.getName() + (1.0 / (linkedMEs.size())));
				}
			}
		}

		// normalize
		for (ModelElement me : result.keySet()) {
			result.put(me, result.get(me) / max);
		}

		return result;
	}

	/**
	 * Name of this strategy.
	 * 
	 * @return "RAR"
	 * @see org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy#getName()
	 */
	public String getName() {
		return "RAR";
	}

}
