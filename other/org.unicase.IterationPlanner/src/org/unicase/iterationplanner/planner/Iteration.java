package org.unicase.iterationplanner.planner;

import java.util.HashSet;
import java.util.Set;

/**
 * An IterationPlan consists of multiple Iterations. The user defines number of iterations to plan before the planner
 * algorithm begins. An iteration has also a form like IterationPlan, i.e {(task, assignee, iteration)}. The difference
 * is the cardinality of this set is less than or equal size of all tasks to be planned; and all the (task, assignee,
 * iteration) triples in an Iteration have the same iteration component (number). In terms of genetics, we can think of
 * an Iteration as a Gene. The Genome (IterationPlan) consists of Genes (Iteration).
 * 
 * @author zardosht
 */
public class Iteration {

	private final int iterationNumber;
	private Set<PlannedTask> plannedTasks;

	public Iteration(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	@Override
	public Iteration clone() {
		Iteration clone = new Iteration(this.iterationNumber);
		for (PlannedTask plannedTask : this.plannedTasks) {
			clone.getPlannedTasks().add(plannedTask.clone());
		}
		return clone;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Iteration)) {
			return false;
		}
		Iteration incomming = (Iteration) obj;
		if (!this.plannedTasks.equals(incomming.plannedTasks)) {
			return false;
		}
		return true;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	public Set<PlannedTask> getPlannedTasks() {
		if (plannedTasks == null) {
			plannedTasks = new HashSet<PlannedTask>();
		}
		return plannedTasks;
	}

}
