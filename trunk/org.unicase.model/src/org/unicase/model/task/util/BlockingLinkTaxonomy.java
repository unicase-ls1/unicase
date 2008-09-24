/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;

public class BlockingLinkTaxonomy {

	public ArrayList<ModelElement> getBlocked(ModelElement modelElement) {
		ArrayList<ModelElement> blocked = new ArrayList<ModelElement>();
		if(modelElement instanceof WorkItem){
			EList<WorkItem> successors = ((WorkItem) modelElement).getSuccessors();
			if(successors!=null){
				blocked.addAll(successors);
			}
		}
		return blocked;
	}

	public Set<ModelElement> getBlockers(ModelElement modelElement) {
		Set<ModelElement> blockers = new HashSet<ModelElement>();
		if(modelElement instanceof WorkItem){
			EList<WorkItem> predecessors = ((WorkItem) modelElement).getPredecessors();
			if(predecessors!=null){
				blockers.addAll(predecessors);
			}
		}
		return blockers;
	}

}
