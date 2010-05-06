/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.Set;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * Util Methods.
 * 
 * @author mkagel
 */
public final class TaskUtil {

	private TaskUtil() {
	}

	/**
	 * This method looks after all leafOpeners of a given system model element, checks if there are some, which are NOT
	 * closed and adds them to the target workPackage. If there are no leafOpeners, which are not closed, the method
	 * creates a new ActionItem, adds it to the workPackage and annotates it with the system model.
	 * 
	 * @param dragSource system model which should be moved
	 * @param workPackage the target in which the system model should be moved to
	 */
	public static void putNonWorkItemInWorkPackage(UnicaseModelElement dragSource, WorkPackage workPackage) {
		Set<UnicaseModelElement> openersForSource = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(dragSource);
		boolean setActionItem = true;
		for (UnicaseModelElement me : openersForSource) {
			if (me instanceof WorkItem) {
				try {
					if (!me.getMEState().getStatus().equals(MEState.CLOSED)) {

						workPackage.getContainedWorkItems().add((WorkItem) me);
						setActionItem = false;
					}

				} catch (CircularDependencyException e) {
					// Do nothing
				}

			}
		}
		if (setActionItem) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			workPackage.getContainedWorkItems().add(ai);
			ai.setName("New Action Item relating " + dragSource.getName());
			ai.getAnnotatedModelElements().add(dragSource);

		}
	}
}
