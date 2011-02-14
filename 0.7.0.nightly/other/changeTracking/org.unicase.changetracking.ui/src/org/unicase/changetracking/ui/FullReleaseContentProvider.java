package org.unicase.changetracking.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.release.Release;
import org.unicase.model.task.WorkItem;

public class FullReleaseContentProvider implements ITreeContentProvider{
	
	private static final Object[] EMPTY = new Object[0];
	private Object input;
	private boolean showRoot = false;
	private boolean showWorkItems = true;
	

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof ChangeTrackingRelease){
			EList<WorkItem> workItems = ((ChangeTrackingRelease) parentElement).getIncludedWorkItems();
			if(showWorkItems){
				return workItems.toArray();
			} else {
				ArrayList<Object> result = new ArrayList<Object>();
				for(WorkItem o: workItems){
					Object[] children = getChildren(o);
					for(Object o2 : children){
						result.add(o2);
					}
				}
				return result.toArray();
			}
		} else if(parentElement instanceof WorkItem){
			EList<Attachment> list = ((WorkItem) parentElement).getAttachments();
			List<ChangePackage> result = new ArrayList<ChangePackage>();
			for(Attachment a : list){
				if(a instanceof ChangePackage){
					result.add((ChangePackage) a);
				}
			}
			return result.toArray();
		}
		return EMPTY;
	}

	@Override
	public Object getParent(Object element) {
		return null;
//		if(element instanceof ChangePackage){
//			EList<UnicaseModelElement> elems = ((ChangePackage) element).getReferringModelElements();
//			if(elems.isEmpty()){
//				return null;
//			} else {
//				return elems.get(0);
//			}
//		} else if(element instanceof WorkItem){
//			EList<Release> elems = ((WorkItem) element).getIncludingReleases();
//			for(Release e : elems){
//				if(e.equals(input)){
//					return e;
//				}
//			}
//			return null;
//		}
//		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof ChangeTrackingRelease){
			EList<WorkItem> workItems = ((ChangeTrackingRelease) element).getIncludedWorkItems();
			if(showWorkItems){
				return !workItems.isEmpty();
			} else {
				for(WorkItem w: workItems){
					if(hasChildren(w)){
						return true;
					}
				}
				return false;
			}
		} else if(element instanceof WorkItem){
			EList<Attachment> list = ((WorkItem) element).getAttachments();
			for(Attachment a : list){
				if(a instanceof ChangePackage){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Object[]){
			Object[] input = (Object[]) inputElement;
			if(showRoot){
				return input;
			} else if(input.length == 0){
				return null;
			} else if(input.length == 1){
				return getChildren(input[0]);
			} else {
				ArrayList<Object> result = new ArrayList<Object>();
				for(Object o: input){
					Object[] children = getChildren(o);
					for(Object o2 : children){
						result.add(children);
					}
				}
				return result.toArray();
			}
		}
		return EMPTY;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		input = newInput;
	}

	public void setShowRoot(boolean show) {
		showRoot = show;
	}

	public void setShowWorkItems(boolean show) {
		showWorkItems = show;
	}

}
