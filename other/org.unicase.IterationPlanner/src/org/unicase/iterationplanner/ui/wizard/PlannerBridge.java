package org.unicase.iterationplanner.ui.wizard;

public class PlannerBridge {
	
	private int numOfIteations; 
	
	public PlannerBridge(){
		
	}


	public int getNumOfIteations() {
		return numOfIteations == 0 ? 1 : numOfIteations;
	}

	public void setNumOfIteations(int numOfIteations) {
		this.numOfIteations = numOfIteations;
	}

	
	
}
