package org.unicase.rapclient;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class NavigationView extends ViewPart
	implements ISelectionChangedListener {
	
	public static final String ID = "catshelter.navigationView";
	private TreeViewer viewer;
	 
	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		
		private final Object[] EMPTY_ARRAY = new Object[0];
		
		public Object[] getChildren(Object parentElement) {
			
			if (parentElement instanceof Workspace) {
				return ((Workspace) parentElement).getProjectSpaces().toArray();
				
			} else if (parentElement instanceof ProjectSpace) {
				// return the project
				ProjectSpace pSpace = (ProjectSpace) parentElement;
				
				if (pSpace.getProject() != null) {
					Object[] project = new Object[1];
					project[0] = pSpace.getProject();
					return project;
				}
				
			} else if (parentElement instanceof Project) {
				// TODO: in which elements are we interested in?
				Project p = (Project) parentElement;
				List<WorkItem> workItems = new ArrayList<WorkItem>();
			
				for (ModelElement me : p.getAllModelElements()) {
					// show only bug reports and action items
					if (me instanceof ActionItem || me instanceof BugReport) {
						WorkItem workItem = (WorkItem) me;
						if (!workItem.isResolved()) {
							workItems.add((WorkItem) me);
						}
					}
				}
				
				return workItems.toArray();
			}
			
			return EMPTY_ARRAY;
		}

		public Object getParent(Object element) {
			
			if (element instanceof ModelElement) {
				return ((ModelElement) element).getProject();
			} else if (element instanceof ProjectSpace) {
				return WorkspaceManager.getInstance().getCurrentWorkspace();
			} else if (element instanceof Project) {
				Project p = (Project) element;
				return WorkspaceManager.getInstance().getProjectSpace(p);
			}
			
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof ProjectSpace 
					|| element instanceof Project
					|| element instanceof Workspace) {
				return true;
			}
			
			return false;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
			// nothing to do		
		}
		
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO: what to do?		
		}
	}
	
	/**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		viewer.addSelectionChangedListener(this);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection sel = event.getSelection();
		TreeSelection treeSelection = (TreeSelection) sel;
		final Object o = treeSelection.getFirstElement();
		viewer.refresh();
//		Display.getDefault().asyncExec(new Runnable() {
//			
//			public void run() {
//				MessageDialog.openInformation(
//						Display.getDefault().getActiveShell(),
//						"Info", o.getClass().getSimpleName()); 
//			}
//		});
	}
}