package org.unicase.iterationplanner.planner;

/**
 * This represents single individuals in population. Hence, this is the representation of our genome. Our genome is a
 * set of Iterations. An Iteration is itself as set of TaskAssignees, i.e. IterationPlan = {(task, assignee,
 * iteration)}. The cardinality of this set is number of tasks that are to be planned.
 * 
 * @author zardosht
 */
public class IterationPlan implements Comparable<IterationPlan> {

	private final Iteration[] iterations;
	private final int numOfIterations;
	private double score;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations);
		for (int i = 0; i < this.iterations.length; i++) {
			Iteration iteration = this.iterations[i];
			clone.iterations[i] = iteration.clone();
		}

		return clone;
	}

	public IterationPlan(int numOfIterations) {
		this.numOfIterations = numOfIterations;
		iterations = new Iteration[numOfIterations];
	}

	public Iteration[] getIterations() {
		return iterations;
	}

	public int getNumOfIterations() {
		return numOfIterations;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public int compareTo(IterationPlan otherPlan) {
		if (otherPlan.getScore() > this.score) {
			return -1;
		}
		return 1;
	}

}
