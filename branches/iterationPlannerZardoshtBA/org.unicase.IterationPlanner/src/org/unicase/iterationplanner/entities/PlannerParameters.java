package org.unicase.iterationplanner.entities;

import java.util.Random;

public final class PlannerParameters {

	private final int populationSize;
	private final int resultSize;
	private final int maxNumOfGenerations;
	private final int percentOfCrossOverChildren;
	private final int precentOfMutants;
	private final int percentOfClones;
	private final int percentOfCrossOverParents;
	private final int percentOfMutationCandidates;
	private final int percentOfCloneCandidates;
	private final int percentOfTasksToMutate;
	private final Random random;
	private final double developerLoadWeight;
	private final double priorityWeight;
	private final double expertiseWeight;

	public double getDeveloperLoadWeight() {
		return developerLoadWeight;
	}

	public double getPriorityWeight() {
		return priorityWeight;
	}

	public double getExpertiseWeight() {
		return expertiseWeight;
	}

	/**
	 * @param populationSize
	 * @param resultSize
	 * @param upperBoundOfRun
	 * @param percentOfCrossOverChildren
	 * @param precentOfMutants
	 * @param percentOfClones
	 * @param percentOfCrossOverParents
	 * @param percentOfMutationCandidates
	 * @param percentOfCloneCandidates
	 * @param developerLoadWeight 
	 * @param priorityWeight 
	 * @param expertiseWeight 
	 */
	public PlannerParameters(int populationSize, int resultSize, int maxNumOfGenerations,
		int percentOfCrossOverChildren, int precentOfMutants, int percentOfClones, int percentOfCrossOverParents,
		int percentOfMutationCandidates, int percentOfCloneCandidates, int percentOfTasksToMutate, Random random, double expertiseWeight, double priorityWeight, double developerLoadWeight) {

		this.populationSize = populationSize;
		this.maxNumOfGenerations = maxNumOfGenerations;
		this.resultSize = resultSize;
		this.percentOfCrossOverChildren = percentOfCrossOverChildren;
		this.precentOfMutants = precentOfMutants;
		this.percentOfClones = percentOfClones;
		this.percentOfCrossOverParents = percentOfCrossOverParents;
		this.percentOfMutationCandidates = percentOfMutationCandidates;
		this.percentOfCloneCandidates = percentOfCloneCandidates;
		this.percentOfTasksToMutate = percentOfTasksToMutate;
		this.random = random;
		
		this.expertiseWeight = expertiseWeight;
		this.priorityWeight = priorityWeight;
		this.developerLoadWeight = developerLoadWeight;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public int getMaxNumOfGenerations() {
		return maxNumOfGenerations;
	}

	/**
	 * How many of best IterationPlans in the last population should be returned as result.
	 * 
	 * @return
	 */
	public int getResultSize() {
		return resultSize;
	}

	public int getPercentOfCrossOverChildren() {
		return percentOfCrossOverChildren;
	}

	public int getPrecentOfMutants() {
		return precentOfMutants;
	}

	public int getPercentOfClones() {
		return percentOfClones;
	}

	public int getPercentOfCrossOverParents() {
		return percentOfCrossOverParents;
	}

	public int getPercentOfMutationCandidates() {
		return percentOfMutationCandidates;
	}

	public int getPercentOfCloneCandidates() {
		return percentOfCloneCandidates;
	}

	public Random getRandom() {
		return random;
	}

	public int getPercentOfTasksToMutate() {
		return percentOfTasksToMutate;
	}

}
