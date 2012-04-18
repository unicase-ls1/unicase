/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;

/**
 * Taxonomy to define blocking links.
 * 
 * @author helming
 */
public class BlockingLinkTaxonomy {
	/**
	 * Returns all elements which are blocked by the source model element. That means, they are connected with the
	 * source by a blocking link. The target element has not to be blocked until the source is open or blocked.
	 * 
	 * @param modelElement The source modelelement
	 * @return all blocke modelelements
	 */
	public ArrayList<UnicaseModelElement> getBlocked(UnicaseModelElement modelElement) {
		ArrayList<UnicaseModelElement> blocked = new ArrayList<UnicaseModelElement>();
		if (modelElement instanceof WorkItem) {
			EList<WorkItem> successors = ((WorkItem) modelElement).getSuccessors();
			if (successors != null) {
				blocked.addAll(successors);
			}
		}
		blocked.remove(modelElement);
		return blocked;
	}

	/**
	 * Returns all elements which are blocking the target model element. That means, they are connected with the target
	 * by a blocking link. The target element has not to be blocked until one of the sources is open or blocked.
	 * 
	 * @param modelElement The target modelelement
	 * @return all blocking modelelements
	 */
	public Set<UnicaseModelElement> getBlockers(UnicaseModelElement modelElement) {
		Set<UnicaseModelElement> blockers = new HashSet<UnicaseModelElement>();
		if (modelElement instanceof WorkItem) {
			EList<WorkItem> predecessors = ((WorkItem) modelElement).getPredecessors();
			if (predecessors != null) {
				blockers.addAll(predecessors);
			}
		}
		blockers.remove(modelElement);
		return blockers;
	}

}
