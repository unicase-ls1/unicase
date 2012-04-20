/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.DocumentPackage;
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
	public static Map<ModelElementId, ModelElementPath> getObjectsOfWork(User user) {
		Map<ModelElementId, ModelElementPath> ret = new HashMap<ModelElementId, ModelElementPath>();

		Set<WorkItem> workItemsOfUser = TaskQuery.getWorkItemsOfUser(user);
		for (WorkItem workItem : workItemsOfUser) {
			ArrayList<UnicaseModelElement> list = new ArrayList<UnicaseModelElement>();
			handleObject(workItem, list, ret);
		}
		return ret;
	}

	private static void handleObject(UnicaseModelElement source, ArrayList<UnicaseModelElement> list,
		Map<ModelElementId, ModelElementPath> ret) {

		list.add(source);
		OpeningLinkTaxonomy openingLinkTaxonomy = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy();
		ArrayList<UnicaseModelElement> openeds = openingLinkTaxonomy.getOpened(source);
		for (UnicaseModelElement opened : openeds) {
			if (DocumentPackage.eINSTANCE.getSection().isInstance(opened)) {
				continue;
			}
			// Create path
			ModelElementPath path = UtilFactory.eINSTANCE.createModelElementPath();
			path.setSource(ModelUtil.getProject(list.get(0)).getModelElementId(list.get(0)));
			path.setTarget(ModelUtil.getProject(opened).getModelElementId(opened));
			if (list.size() > 1) {
				for (int i = 1; i < list.size(); i++) {
					path.getPath().add(ModelUtil.getProject(list.get(i)).getModelElementId(list.get(i)));
				}
			}
			if (!ret.containsKey(ModelUtil.getProject(opened).getModelElementId(opened))) {
				ret.put(ModelUtil.getProject(opened).getModelElementId(opened), path);

				ArrayList<UnicaseModelElement> newList = new ArrayList<UnicaseModelElement>();
				newList.addAll(list);
				handleObject(opened, newList, ret);
			}

		}
	}
}
