package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.organization.User;

public class UserAvailability {

	private User user;
	

	private List<Integer> availabilities;
	
	public UserAvailability(User user, int defaultAvailability) {
		this.user = user;
		availabilities = new ArrayList<Integer>();
		availabilities.add(defaultAvailability);
	}
	
	
	public int getNumOfIterations() {
		return availabilities.size();
	}


	public int getAvailability(int iterNumber){
		return availabilities.get(iterNumber);
	}

	public void setAvailability(int iterNumber, int availability){
		availabilities.remove(iterNumber);
		availabilities.add(iterNumber, availability);
	}


	public boolean hasUndifinedAvailability() {
		return availabilities.contains(-1);
	}
	
	public User getUser() {
		return user;
	}


	public void removeIteration() {
		availabilities.remove(availabilities.size() - 1);
	}


	public void addIteration(int defaultAvailability) {
		availabilities.add(defaultAvailability);
	}	
}
