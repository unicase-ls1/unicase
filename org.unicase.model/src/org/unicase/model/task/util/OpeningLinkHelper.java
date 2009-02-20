/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.model.util.ModelElementPath;
import org.unicase.model.util.UtilFactory;

/**
 * this class provides methods related to opening links and depends on the current {@link OpeningLinkTaxonomy}.
 * 
 * @author helming
 */
public final class OpeningLinkHelper {

	private OpeningLinkHelper() {

	}

	/**
	 * Return a list of traces to the objects of all work items of a certain user.
	 * 
	 * @param user the User.
	 * @return a map of modelelemts to path
	 */
	public static Map<ModelElement, ModelElementPath> getObjectsOfWork(User user) {
		Map<ModelElement, ModelElementPath> ret = new HashMap<ModelElement, ModelElementPath>();

		Set<WorkItem> workItemsOfUser = TaskQuery.getWorkItemsOfUser(user);
		for (WorkItem workItem : workItemsOfUser) {
			ArrayList<ModelElement> list = new ArrayList<ModelElement>();
			handleObject(workItem, list, ret);
		}
		return ret;
	}

	private static void handleObject(ModelElement source, ArrayList<ModelElement> list,
		Map<ModelElement, ModelElementPath> ret) {
		if (ret.containsKey(source)) {
			return;
		}
		list.add(source);
		OpeningLinkTaxonomy openingLinkTaxonomy = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy();
		ArrayList<ModelElement> openeds = openingLinkTaxonomy.getOpened(source);
		for (ModelElement opened : openeds) {
			// Create path
			ModelElementPath path = UtilFactory.eINSTANCE.createModelElementPath();
			path.setSource(list.get(0).getModelElementId());
			path.setTarget(opened.getModelElementId());
			if (list.size() > 1) {
				for (int i = 1; i < list.size(); i++) {
					path.getPath().add(list.get(i).getModelElementId());
				}
			}
			ret.put(opened, path);

			ArrayList<ModelElement> newList = new ArrayList<ModelElement>();
			newList.addAll(list);
			handleObject(opened, newList, ret);
		}
	}
}
