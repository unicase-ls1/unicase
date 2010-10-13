package org.unicase.iterationplanner.planner;

public class EvaluatorParameters {

	private final double expertiesWeight;
	private final double priorityWeight;
	private final double developerLoadWeight;

	public EvaluatorParameters(double expertiesWeight, double priorityWeight, double developerLoadWeight) {
		this.expertiesWeight = expertiesWeight;
		this.priorityWeight = priorityWeight;
		this.developerLoadWeight = developerLoadWeight;
	}

	public double getDeveloperLoadWeight() {
		return developerLoadWeight;
	}

	public double getPriorityWeight() {
		return priorityWeight;
	}

	public double getExpertiesWeight() {
		return expertiesWeight;
	}

}
