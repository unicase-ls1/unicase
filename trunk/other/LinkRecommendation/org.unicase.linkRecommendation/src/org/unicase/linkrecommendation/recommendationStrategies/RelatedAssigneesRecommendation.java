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
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

/**
 * This method tries to find the related assignee and looks at his other items. In case a couple of those are suggested
 * they are ranked higher than others.
 * 
 * @author Henning Femmer
 */
public class RelatedAssigneesRecommendation implements RecommendationStrategy {

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

		if (base instanceof WorkItem) {
			WorkItem wi = (WorkItem) base;
			OrgUnit wu = wi.getAssignee();

			if (wu != null) {

				// CHANGED FROM GET LINKED MES
				EList<WorkItem> relatedWIs = wu.getAssignments();
				for (WorkItem item : relatedWIs) {
					Set<ModelElement> linkedMEs = item.getLinkedModelElements();
					linkedMEs.retainAll(elements);
					for (ModelElement me : linkedMEs) {
						// System.out.println(wi.getName());
						// System.out.println("Assignee:" + wu.getName());
						// System.out.println("WI:" + item.getName());
						// System.out.println("ME:" + me.getName());
						result.put(me, 1.0 / (linkedMEs.size()));
					}
				}
			}

		}

		return result;
	}

	/**
	 * Name of this strategy.
	 * 
	 * @return "RAR"
	 * @see org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy#getName()
	 */
	public String getName() {
		return "RAR";
	}

}
