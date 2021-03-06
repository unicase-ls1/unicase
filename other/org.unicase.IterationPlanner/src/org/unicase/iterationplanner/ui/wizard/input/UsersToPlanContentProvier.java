package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

public class UsersToPlanContentProvier extends AdapterFactoryContentProvider {
	
	private List<UserAvailability> userAvailabilities;
	private int numOfIterations = 1;
	
	public UsersToPlanContentProvier( AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public List<UserAvailability> getUserAvailabilities() {
		return userAvailabilities;
	}


	@Override
	public Object[] getElements(Object object) {
		return userAvailabilities.toArray();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		initUserAvailabilities();
	}

	private void initUserAvailabilities() {
		userAvailabilities = new ArrayList<UserAvailability>();
	}
	
	public void addOrgUnit(OrgUnit orgUnit){
		if(orgUnit instanceof User){
			UserAvailability ua = new UserAvailability((User) orgUnit);
			for(int i = 0; i < numOfIterations -1; i++){
				//-1 because a UserAvailability initializes with a first iteration (that is it already has a first iteration)
				ua.addIteration();
			}
			userAvailabilities.add(ua);
		}else{
			for(OrgUnit ou : ((Group)orgUnit).getOrgUnits()){
				if(ou instanceof User){
					UserAvailability ua = new UserAvailability((User)ou);
					for(int i = 0; i < numOfIterations - 1; i++){
						//-1 because a UserAvailability initializes with a first iteration (that is it already has a first iteration)
						ua.addIteration();
					}
					userAvailabilities.add(ua);
				}
			}
		}
	}
	
	public void removeUserAvailability(UserAvailability ua){
		userAvailabilities.remove(ua);
	}

	public void addIteration() {
		for(UserAvailability ua : userAvailabilities){
			ua.addIteration();
		}
		numOfIterations ++;
		
	}

	public void removeIteration() {
		for(UserAvailability ua : userAvailabilities){
			ua.removeIteration();
		}
		numOfIterations --;
		
	}

}
