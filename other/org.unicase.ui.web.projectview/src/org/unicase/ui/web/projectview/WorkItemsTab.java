package org.unicase.ui.web.projectview;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.swt.custom.CTabFolder;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.web.views.ProjectAwareTab;
import org.unicase.workspace.ProjectSpace;

/**
 * A tab that shows open work items.
 * 
 * @author emueller
 *
 */
public class WorkItemsTab extends ProjectAwareTab {
	
	private WorkItemsTableViewer workItemsTableViewer;
	
	/**
	 * Initializes a new instance of the WorkItemsTab. 
	 * 
	 * @param projectSpace The project space this tab depends on
	 * @param tabFolder The parent tab folder of this tab
	 */
	public WorkItemsTab(ProjectSpace projectSpace, CTabFolder tabFolder) {
		super(projectSpace, tabFolder, "Open work items");
		workItemsTableViewer = new WorkItemsTableViewer(composite);
	}
	
	public void modelElementAdded(Project project, ModelElement modelElement) {
		refreshInput();
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		refreshInput();
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		refreshInput();
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		refreshInput();
	}
	
	public void refreshInput() {
			final List<? extends Checkable> taskItems = projectSpace
					.getProject().getAllModelElementsbyClass(
							TaskPackage.eINSTANCE.getCheckable(),
							new BasicEList<Checkable>());

			for (Iterator<? extends Checkable> iterator = taskItems.iterator(); iterator
					.hasNext();) {
				Checkable item = iterator.next();
				if (item instanceof ActionItem) {
					if (((ActionItem) item).isDone()) {
						iterator.remove();
					}
				} else if (item instanceof BugReport) {
					if (((BugReport) item).isDone()) {
						iterator.remove();
					}
				} else if (item instanceof Issue) {
					if (((Issue) item).getSolution() != null) {
						iterator.remove();
					}
				}
			}
			
			final WritableList list = (WritableList) (workItemsTableViewer.getInput());
			if (list == null) {
				// the case of first time of input setting to table
				WritableList emfList = new WritableList(Realm.getDefault(),
						taskItems, UnicaseModelElement.class);
				workItemsTableViewer.setInput(emfList);
			} else {
				list.getRealm().asyncExec(new Runnable() {

					public void run() {
						// remove all elements
						list.retainAll(new BasicEList<UnicaseModelElement>());
						// adds new task items
						list.addAll(taskItems);
					}
				});
			}
	}

}
