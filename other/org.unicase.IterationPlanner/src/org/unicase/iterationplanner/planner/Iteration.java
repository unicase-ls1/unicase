package org.unicase.iterationplanner.planner;

import java.util.List;

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
	private List<TaskAssignee> taskAssignees;

	public Iteration(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	public List<TaskAssignee> getTaskAssignees() {
		return taskAssignees;
	}

}
