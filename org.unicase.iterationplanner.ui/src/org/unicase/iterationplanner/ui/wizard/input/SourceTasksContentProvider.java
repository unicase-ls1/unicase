package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.iterationplanner.ui.wizard.ProjectController;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class SourceTasksContentProvider extends AdapterFactoryContentProvider {

	private List<WorkItem> allUndoneWorkItems;
	private ProjectController projectBridge;
	
	public SourceTasksContentProvider(ProjectController projectBridge, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.projectBridge = projectBridge;
	}

	
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof WorkPackage){
			List<WorkItem> result = new ArrayList<WorkItem>();
			EList<WorkItem> containedWorkItems = ((WorkPackage) object).getContainedWorkItems();
			for(WorkItem wi : containedWorkItems){
				if(wi instanceof WorkPackage){
					if(!isAllWorkItemsResolved((WorkPackage) wi)){
						result.add(wi);
					}
				}else{
					if(allUndoneWorkItems.contains(wi)){
						result.add(wi);
					}
				}
			}
			
			return result.toArray();
		}
		return null;
		
	}

	@Override
	public Object[] getElements(Object object) {
		ArrayList<WorkItem> result = new ArrayList<WorkItem>();
		result.addAll(getFirstLevelWorkPacages());
		result.addAll(getOrphans());
		
		return result.toArray();
	}
	
	

	private List<WorkItem> getOrphans() {
		List<WorkItem> orphans = new ArrayList<WorkItem>();
		for(WorkItem wi : allUndoneWorkItems){
			if(wi.getContainingWorkpackage() == null){
				orphans.add(wi);
			}
		}
		
		return orphans;
	}


	private List<WorkPackage> getFirstLevelWorkPacages() {
		List<WorkPackage> result = new ArrayList<WorkPackage>();
		List<WorkPackage> topLevelWorkPackages = projectBridge.getTopLevelWorkPackages();
		for(WorkPackage wp : topLevelWorkPackages){
			if(!isAllWorkItemsResolved(wp)){
				result.add(wp);
			}
		}
		return result;
	}


	private boolean isAllWorkItemsResolved(WorkPackage wp) {
		for(WorkItem wi : wp.getAllContainedWorkItems()){
			if(wi instanceof ActionItem || wi instanceof BugReport || wi instanceof Issue){
				if(allUndoneWorkItems.contains(wi)){
					return false;
				}
			}
		}
		return true;
	}


	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		initAllUndoneWorkItems(newInput);
	}

	private void initAllUndoneWorkItems(Object newInput) {
		allUndoneWorkItems = new ArrayList<WorkItem>();
		if(newInput == null){
			return;
		}
		List<WorkItem> allWorkItems = projectBridge.getAllWorkItems();
		for(WorkItem wi : allWorkItems){
			if(wi instanceof ActionItem){
				if(!((ActionItem)wi).isDone()){
					allUndoneWorkItems.add(wi);
				}
			}
			if(wi instanceof BugReport){
				if(!((BugReport)wi).isDone()){
					allUndoneWorkItems.add(wi);
				}
			}
			if(wi instanceof Issue){
				if(!((Issue)wi).isResolved()){
					if(((Issue)wi).getSolution() == null){
						allUndoneWorkItems.add(wi);
					}
				}
			}
		}
	}


	@Override
	public boolean hasChildren(Object object) {
		return object instanceof WorkPackage;
	}


	public void removeWorkItem(WorkItem wi) {
		if(wi instanceof WorkPackage){
			allUndoneWorkItems.removeAll(wi.getAllContainedModelElements());
		}else{
			allUndoneWorkItems.remove(wi);
		}
	}


	public void addWorkItem(WorkItem obj) {
		allUndoneWorkItems.add(obj);
	}

	




}
