package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.workspace.WorkspaceManager;

public class ListContentProvider extends
		TransactionalAdapterFactoryContentProvider {

	@Override
	public Object[] getElements(Object object) {
		
		String tabName = (String)object;
		if(tabName.equals("Projects")){
			//return a list of Projects in project space
			EList<ProjectInfo> projectInfos = WorkspaceManager.getInstance().getAdminConnectionManager().getProjectInfos();
			return projectInfos.toArray(new ProjectInfo[projectInfos.size()]);
			
		}else if (tabName.equals("Groups")){
			//return a list of Groups in project space
			EList<ACGroup> groups = WorkspaceManager.getInstance().getAdminConnectionManager().getGroups();
			return groups.toArray(new ACGroup[groups.size()]);
		}else if(tabName.equals("Users")){
			//return a list of Users in project space
			EList<ACUser> users = WorkspaceManager.getInstance().getAdminConnectionManager().getUsers();
			return users.toArray(new ACUser[users.size()]);
		}
		
		return super.getElements(object);
	}

	public ListContentProvider() {
		
		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(),
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

}
