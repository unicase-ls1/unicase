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
