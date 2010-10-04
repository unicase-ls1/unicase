package org.unicase.iterationplanner.assigneerecommendation;

/**
 * This class is only for implementation reason. It has only in relation to a Task a semantic meaning, and expresses the
 * expertise of the assignee regarding that task.
 * 
 * @author zardosht
 */
public class AssigneeExpertise implements Comparable<AssigneeExpertise> {

	private final Assignee assignee;
	private final double expertise;

	public AssigneeExpertise(Assignee assignee, double expertise) {
		this.assignee = assignee;
		this.expertise = expertise;
	}

	public double getExpertise() {
		return expertise;
	}

	public Assignee getAssignee() {
		return assignee;
	}

	public int compareTo(AssigneeExpertise otherAssignee) {
		if (otherAssignee.getExpertise() > this.expertise) {
			return -1;
		}
		return 1;
	}

}
