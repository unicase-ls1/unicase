package org.unicase.iterationplanner.planner;

import java.util.Random;


public class EvaluatorParameters {

	private final double expertiesWeight;
	private final double priorityWeight;
	private final double developerLoadWeight;
	private final Random random;

	


	public EvaluatorParameters(double expertiesWeight, double priorityWeight, double developerLoadWeight, Random random) {
		this.expertiesWeight = expertiesWeight;
		this.priorityWeight = priorityWeight;
		this.developerLoadWeight = developerLoadWeight;
		this.random = random;
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
	
	
	public Random getRandom() {
		return random;
	}


}
