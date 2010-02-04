package org.unicase.ui.web.tabs;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class ProjectListView extends AbstractListView {

	public ProjectListView(Composite composite) {
		super(composite);	
		
	}

	@Override
	public void update() {
		List<ProjectSpace> spaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		
		// the case of first time of input setting to table
		WritableList emfList = new WritableList(Realm.getDefault(),
				spaces, ModelElement.class);
		setInput(emfList);
	}
	
	
}
