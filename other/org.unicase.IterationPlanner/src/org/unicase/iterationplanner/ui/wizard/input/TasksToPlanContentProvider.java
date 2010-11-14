package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class TasksToPlanContentProvider extends AdapterFactoryContentProvider {

	public TasksToPlanContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	private List<WorkItem> workItemsToPlan;

	@Override
	public void dispose() {
	}
	
	

	@Override
	public Object[] getElements(Object object) {
		return workItemsToPlan.toArray();
	}



	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		workItemsToPlan = new ArrayList<WorkItem>();
	}

	public void addWorkItem(WorkItem wi) {
		if (wi instanceof WorkPackage) {
			workItemsToPlan.addAll(getAllUndoneWorkItems((WorkPackage) wi));
		} else {
			workItemsToPlan.add(wi);
		}
	}

	private List<WorkItem> getAllUndoneWorkItems(WorkPackage wp) {
		ArrayList<WorkItem> result = new ArrayList<WorkItem>();
		List<WorkItem> allWorkItems = wp.getAllContainedWorkItems();
		for (WorkItem wi : allWorkItems) {
			if (wi instanceof ActionItem) {
				if (!((ActionItem) wi).isDone()) {
					result.add(wi);
				}
			}
			if (wi instanceof BugReport) {
				if (!((BugReport) wi).isDone()) {
					result.add(wi);
				}
			}
			if (wi instanceof Issue) {
				if (!((Issue) wi).isResolved()) {
					result.add(wi);
				}
			}
		}

		return result;
	}



	public void removeWorkItem(WorkItem obj) {
		workItemsToPlan.remove(obj);
	}

}
