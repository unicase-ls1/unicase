/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

/**
 * Computer related tasks directly.
 * @author hodaie
 *
 */
public class ImperativeRelatedTasks implements RelatedTasksSterategy {

	/**
	 * {@inheritDoc}
	 * 
	 */
	public List<WorkItem> getRelatedTasks(WorkItem workItem) {
		// find model elements requirements annotated with this task
		List<ModelElement> relatedMEs = new ArrayList<ModelElement>();
		relatedMEs.addAll(workItem.getAnnotatedModelElements());
		
		for (ModelElement me : workItem.getAnnotatedModelElements()) {
			if(me instanceof FunctionalRequirement){
				relatedMEs.addAll(getAllRefiningRequirements((FunctionalRequirement) me));
			}
		
		}

	
		List<WorkItem> relatedWorkItems = new ArrayList<WorkItem>();
		for (ModelElement me : relatedMEs) {
			for (Annotation annotation : me.getAnnotations()) {
				if (annotation instanceof WorkItem) {
					relatedWorkItems.add((WorkItem) annotation);
				}
			}
		}

		return relatedWorkItems;
		
	}

	private List<ModelElement> getAllRefiningRequirements(FunctionalRequirement req) {
		List<ModelElement> result = new ArrayList<ModelElement>();
		for(FunctionalRequirement fr : req.getRefiningRequirements()){
			result.add(fr);
			result.addAll(getAllRefiningRequirements(fr));
		}
		return result;
	}

}
