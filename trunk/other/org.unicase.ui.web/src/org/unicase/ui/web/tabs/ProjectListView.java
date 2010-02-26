package org.unicase.ui.web.tabs;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.web.views.AbstractETableViewer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class ProjectListView extends AbstractETableViewer implements SelectionListener {

	private String currProjectName;

	public ProjectListView(Composite composite) {
		super(composite);	
		getTable().addSelectionListener((SelectionListener) this);
	}

	@Override
	public void refreshView() {
		List<ProjectSpace> spaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		
		// the case of first time of input setting to table
		WritableList emfList = new WritableList(Realm.getDefault(),
				spaces, ModelElement.class);
		setInput(emfList);
	}
	

//	/**
//	 * Gets current project name.
//	 * 
//	 * @return
//	 */
//	public String getCurrProjectName() {
//		return currProjectName;
//	}
//
//	/**
//	 * Sets current project name.
//	 * 
//	 * @param currProjectName
//	 */
//	public void setCurrProjectName(String currProjectName) {
//		this.currProjectName = currProjectName;
//	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

public void widgetDefaultSelected(SelectionEvent e) {
	System.out.println("ProjectListView: " + e.getID());	
}

public void widgetSelected(SelectionEvent e) {
	System.out.println("ProjectListView: " + e.getID());	
}
	
	
}
