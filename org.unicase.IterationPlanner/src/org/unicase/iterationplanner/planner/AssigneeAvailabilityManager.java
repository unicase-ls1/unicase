package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Before planner algorithm can begin, it needs to know how long every developer (assignee) will be available during
 * each iteration. The sets these values before the planning starts.
 * 
 * @author zardosht
 */
public class AssigneeAvailabilityManager {

	private Map<Integer, List<AssigneeAvailability>> assigneeAvailabilities;

	public AssigneeAvailabilityManager(int numOfIterations) {
		assigneeAvailabilities = new HashMap<Integer, List<AssigneeAvailability>>();

		for (int i = 0; i < numOfIterations; i++) {
			assigneeAvailabilities.put(new Integer(i), new ArrayList<AssigneeAvailability>());
		}
	}

	public void setAvailability(int iterationNumber, IAssignee assignee, int availability) {
		List<AssigneeAvailability> avsForIter = assigneeAvailabilities.get(iterationNumber);
		for (AssigneeAvailability aa : avsForIter) {
			if (aa.getAssignee().equals(assignee)) {
				aa.setAvailability(availability);
				return;
			}
		}
		// we didn't find any match. this assignee is new
		avsForIter.add(new AssigneeAvailability(assignee, availability));
	}

	public int getAvailability(int iterationNumber, IAssignee assignee) {
		assert (iterationNumber < assigneeAvailabilities.keySet().size());
		List<AssigneeAvailability> avsForIter = assigneeAvailabilities.get(iterationNumber);
		for (AssigneeAvailability aa : avsForIter) {
			if (aa.getAssignee().equals(assignee)) {
				return aa.getAvailability();
			}
		}
		return 0;
	}

	private class AssigneeAvailability {

		private final IAssignee assignee;
		private int availability;

		public AssigneeAvailability(IAssignee assignee, int availability) {
			this.assignee = assignee;
			this.availability = availability;
		}

		public int getAvailability() {
			return availability;
		}

		public void setAvailability(int availability) {
			this.availability = availability;
		}

		public IAssignee getAssignee() {
			return assignee;
		}
	}

}
