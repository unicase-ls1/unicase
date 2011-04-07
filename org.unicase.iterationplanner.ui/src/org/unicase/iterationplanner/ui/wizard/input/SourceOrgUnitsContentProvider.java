package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.iterationplanner.ui.wizard.ProjectController;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

public class SourceOrgUnitsContentProvider extends AdapterFactoryContentProvider {
	
	private List<User> allUsers;
	private ProjectController projectBridge;

	public SourceOrgUnitsContentProvider(ProjectController projectBridge, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.projectBridge = projectBridge;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		initAllUsers(newInput);
	}

	private void initAllUsers(Object newInput) {
		allUsers = new ArrayList<User>();
		allUsers.addAll(projectBridge.getAllUsers());
	}

	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof Group){
			List<OrgUnit> result = new ArrayList<OrgUnit>();
			List<OrgUnit> orgUnits = ((Group)object).getOrgUnits();
			for(OrgUnit ou : orgUnits){
				if(ou instanceof User){
					if(allUsers.contains(ou)){
						result.add(ou);
					}
				}else{
					if(hasUserInAllUsers((Group)ou)){
						result.add(ou);
					}
				}
			}
			return result.toArray();
		}
		return super.getChildren(object);
	}

	private boolean hasUserInAllUsers(Group group) {
		EList<OrgUnit> orgUnits = group.getOrgUnits();
		for(OrgUnit ou : orgUnits){
			if (allUsers.contains(ou)){
				return true;
			}
			if(ou instanceof Group){
				boolean value = hasUserInAllUsers((Group) ou);
				if(value){
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public Object[] getElements(Object object) {
		//return top level gourps (those that are not included in any group) + those users that are not memeber of any group
		ArrayList<OrgUnit> result = new ArrayList<OrgUnit>();
		List<Group> topLevelGroups = projectBridge.getTopLevelGroups();
		for(Group group : topLevelGroups){
			if(hasUserInAllUsers(group)){
				result.add(group);
			}
		}
		result.addAll(getOrphans());
		
		return result.toArray();
	}

	private List<User> getOrphans() {
		List<User> orphans = new ArrayList<User>();
		for(User user : allUsers){
			if(user.getGroupMemberships().size() == 0){
				orphans.add(user);
			}
		}
		return orphans;
	}

	@Override
	public boolean hasChildren(Object object) {
		return object instanceof Group;
	}
	
	
	public void addUser(User user){
		if(!allUsers.contains(user)){
			allUsers.add(user);
		}
	}
	
	public void removeOrgUnit(OrgUnit orgUnit){
		if(orgUnit instanceof User){
			allUsers.remove(orgUnit);
		}else if(orgUnit instanceof Group){
			removeAllUsers((Group)orgUnit);
		}
	}

	private void removeAllUsers(Group group) {
		for(OrgUnit ou : group.getOrgUnits()){
			if(ou instanceof User){
				allUsers.remove(ou);
			}
		}
	}

}
