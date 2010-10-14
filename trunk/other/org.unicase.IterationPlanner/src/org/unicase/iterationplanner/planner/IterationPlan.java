package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This represents single individuals in population. Hence, this is the representation of our genome. Our genome is a
 * set of Iterations. An Iteration is itself as set of PlannedTasks, i.e. IterationPlan = {(task, assignee, iteration)}.
 * The cardinality of this set is number of tasks that are to be planned.
 * 
 * @author zardosht
 */
public class IterationPlan implements Comparable<IterationPlan> {

	private final Iteration[] iterations;
	private final int numOfIterations;
	private double score;
	private List<PlannedTask> plannedTasks;

	@Override
	public IterationPlan clone() {
		IterationPlan clone = new IterationPlan(this.numOfIterations);
		clone.plannedTasks = this.plannedTasks; // is it really possible? plannedTasks is private!
		for (int i = 0; i < this.iterations.length; i++) {
			Iteration iteration = this.iterations[i];
			clone.iterations[i] = iteration.clone();
		}
		return clone;
	}

	public IterationPlan(int numOfIterations) {
		this.numOfIterations = numOfIterations;
		iterations = new Iteration[numOfIterations];
		for (int i = 0; i < numOfIterations; i++) {
			iterations[i] = new Iteration(new Integer(i));
		}
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
			return 1;
		}
		return -1;
	}

	public List<PlannedTask> getPlannedTasks() {
		if (plannedTasks == null) {
			plannedTasks = new ArrayList<PlannedTask>();
		}
		return plannedTasks;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IterationPlan)) {
			return false;
		}
		IterationPlan incomming = (IterationPlan) obj;
		if (this.iterations.length != incomming.iterations.length) {
			return false;
		}
		for (int i = 0; i < this.iterations.length; i++) {
			if (!(this.iterations[i].equals(incomming.iterations[i]))) {
				return false;
			}
		}
		return true;
	}

	public void setIterationNumberFor(PlannedTask plannedTask, int newIterationNumber) {
		int oldIterationNumber = plannedTask.getIterationNumber();
		if (oldIterationNumber == -1) {
			// this is the first time putting this task in an iteration
			iterations[newIterationNumber].plannedTasksInIteration.add(plannedTask);
		} else {
			iterations[oldIterationNumber].plannedTasksInIteration.remove(plannedTask);
			iterations[newIterationNumber].plannedTasksInIteration.add(plannedTask);
		}
		plannedTask.setIterationNumber(newIterationNumber);
	}

	public List<PlannedTask> getAllPlannedTasksForIteration(int iterationNumber) {
		List<PlannedTask> result = new ArrayList<PlannedTask>();
		for (PlannedTask pt : getPlannedTasks()) {
			if (pt.getIterationNumber() == iterationNumber) {
				result.add(pt);
			}
		}

		return result;
	}

	private class Iteration {
		private final int iterationNumber;
		private final Set<PlannedTask> plannedTasksInIteration = new HashSet<PlannedTask>();

		private Iteration(int iterationNumber) {
			this.iterationNumber = iterationNumber;
		}

		@Override
		public Iteration clone() {
			Iteration clone = new Iteration(this.iterationNumber);
			for (PlannedTask plannedTask : this.plannedTasksInIteration) {
				clone.plannedTasksInIteration.add(plannedTask.clone());
			}
			return clone;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Iteration)) {
				return false;
			}
			Iteration incomming = (Iteration) obj;
			if (!this.plannedTasksInIteration.equals(incomming.plannedTasksInIteration)) {
				return false;
			}
			return true;
		}

	}
}
