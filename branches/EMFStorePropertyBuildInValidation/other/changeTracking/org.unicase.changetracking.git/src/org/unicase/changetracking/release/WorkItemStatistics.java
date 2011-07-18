package org.unicase.changetracking.release;

public class WorkItemStatistics {

	private final int numWorkItems;
	private final int numResolved;


	public WorkItemStatistics(int num, int numResolved) {
		this.numWorkItems = num;
		this.numResolved = numResolved;
	}

	public int getNumWorkItems() {
		return numWorkItems;
	}

	public int getNumResolved() {
		return numResolved;
	}
	
	public int getNumUnfinished(){
		return numWorkItems - numResolved;
	}

	public int getPercentage() {
		return numResolved * 100 / numWorkItems;
	}
}
