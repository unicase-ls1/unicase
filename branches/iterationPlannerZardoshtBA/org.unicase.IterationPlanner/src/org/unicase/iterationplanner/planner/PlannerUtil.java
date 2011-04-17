package org.unicase.iterationplanner.planner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.ITask;
import org.unicase.iterationplanner.planner.impl.shiftdownplanner.ShiftDownPlannedTask;

public class PlannerUtil {

	private static PlannerUtil instance;
	private Random random;

	private PlannerUtil() {

	}

	public static PlannerUtil getInstance(Random random) {
		if (instance == null) {
			instance = new PlannerUtil();
		}
		instance.setRandom(random);
		return instance;
	}

	public <T> List<T> selectRandomElementsFromList(List<T> list, int percentOfReturnElements) {
		List<T> result = new ArrayList<T>();
		Random random = getRandom();
		int numOfElements = (int) ((percentOfReturnElements / 100.0) * list.size());
		for (int i = 0; i < numOfElements; i++) {
			T selectedElement = list.get(random.nextInt(list.size()));
			result.add(selectedElement);
		}
		return result;

	}
	
	public <T> List<T> selectFirstElementsFromSortedList(List<T> list, int percentOfReturnElements) {
		List<T> result = new ArrayList<T>();
		int numOfElements = (int) ((percentOfReturnElements / 100.0) * list.size());
		for (int i = 0; i < numOfElements; i++) {
			T selectedElement = list.get(i);
			result.add(selectedElement);
		}
		return result;

	}
	

	@SuppressWarnings("unchecked")
	public <T> Set<T> selectRandomElementsFromSet(Set<T> set, int percentOfReturnElements) {
		Set<T> result = new HashSet<T>();
		Random random = getRandom();
		int numOfElements = (int) ((percentOfReturnElements / 100.0) * set.size());
		for (int i = 0; i < numOfElements; i++) {
			T selectedElement = (T) set.toArray()[random.nextInt(set.size())];
			result.add(selectedElement);
		}
		return result;

	}

	/**
	 * return a Probabilistic iteration number for this task based on its priority. we use subjective method to assign
	 * probabilities to each possible iteration number for a given task. The main assumption is, for a given task, the
	 * more its priority, the higher the probability that it will be assigned an earlier iteration (less iteraion
	 * number)?????????????
	 * 
	 * @param task
	 * @return
	 */
	public int getIterationNumberProbabilistic(ITask task, int numOfIterations) {
		if (task.getPriority() > 10) {
			throw new RuntimeException("Task priority must be between 0 and 10.");
		}
		// we consider backlog too. Therefore this method returns an array of length numOfIterations + 1
		double[] p = getIteratioinProbabilities(task.getPriority(), numOfIterations);
		double measure = getRandom().nextDouble();

		double sum = 0.0;
		for (int i = 0; i < p.length; i++) {
			if (measure >= sum && measure < sum + p[i]) {
				return i;
			}
			sum += p[i];
		}

		// return backlog
		return numOfIterations + 1;
	}

	public int testGetIterationNumberProbabilistic(int priority, int numOfIterations) {
		if (priority > 10) {
			throw new RuntimeException("Task priority must be between 0 and 10.");
		}
		// we consider backlog too. Therefore this method returns an array of length numOfIterations + 1
		double[] p = getIteratioinProbabilities(priority, numOfIterations);
		double measure = getRandom().nextDouble();

		double sum = 0.0;
		for (int i = 0; i < p.length; i++) {
			if (measure >= sum && measure < sum + p[i]) {
				return i;
			}
			sum += p[i];
		}

		// return backlog
		return numOfIterations + 1;
	}

	private double[] getIteratioinProbabilities(int priority, int numOfIterations) {
		// we consider backlog too. Therefore numOfIterations + 1
		double[] p = new double[numOfIterations + 1];
		switch (numOfIterations) {
		case 1: {
			if (priority >= 7) {
				p[0] = 0.9;
				p[1] = 0.1;
			} else if (priority >= 4 && priority < 7) {
				p[0] = 0.7;
				p[1] = 0.3;

			} else {
				p[0] = 0.6;
				p[1] = 0.4;

			}
		}
			break;
		case 2: {
			if (priority >= 7) {
				p[0] = 0.75;
				p[1] = 0.2;
				p[2] = 0.05;

			} else if (priority >= 4 && priority < 7) {
				p[0] = 0.4;
				p[1] = 0.4;
				p[2] = 0.2;

			} else {
				p[0] = 0.2;
				p[1] = 0.5;
				p[2] = 0.3;

			}

		}
			break;
		case 3: {
			if (priority >= 7) {
				p[0] = 0.7;
				p[1] = 0.15;
				p[2] = 0.1;
				p[3] = 0.05;

			} else if (priority >= 4 && priority < 7) {
				p[0] = 0.4;
				p[1] = 0.3;
				p[2] = 0.2;
				p[3] = 0.1;

			} else {
				p[0] = 0.15;
				p[1] = 0.4;
				p[2] = 0.3;
				p[3] = 0.15;

			}

		}
			break;
		case 4: {
			if (priority >= 7) {
				p[0] = 0.65;
				p[1] = 0.25;
				p[2] = 0.07;
				p[3] = 0.03;
				p[4] = 0.0;

			} else if (priority >= 4 && priority < 7) {
				p[0] = 0.2;
				p[1] = 0.25;
				p[2] = 0.30;
				p[3] = 0.15;
				p[4] = 0.1;

			} else {
				p[0] = 0.05;
				p[1] = 0.2;
				p[2] = 0.25;
				p[3] = 0.4;
				p[4] = 0.1;

			}

		}
			break;
		case 5: {
			if (priority >= 7) {
				p[0] = 0.5;
				p[1] = 0.3;
				p[2] = 0.15;
				p[3] = 0.05;
				p[4] = 0.0;
				p[5] = 0.0;

			} else if (priority >= 4 && priority < 7) {
				p[0] = 0.05;
				p[1] = 0.15;
				p[2] = 0.25;
				p[3] = 0.25;
				p[4] = 0.20;
				p[5] = 0.10;

			} else {
				p[0] = 0.0;
				p[1] = 0.05;
				p[2] = 0.15;
				p[3] = 0.30;
				p[4] = 0.40;
				p[5] = 0.10;

			}

		}
			break;
		default: {
			throw new RuntimeException(
				"Number of iterations invalid. -Planning more than 5 iterations is not supported. Number of iterations:"
					+ numOfIterations);
		}
		}
		return p;
	}

	/**
	 * @return
	 */
	public AssigneeExpertise getAssigneeProbabilistic(List<AssigneeExpertise> potentialAssignees, AssigneeExpertise currentAssignee) {
		double p[] = new double[potentialAssignees.size()];
		double sumExpertise = 0.0;
		for (AssigneeExpertise ae : potentialAssignees) {
			sumExpertise += ae.getExpertise();
		}
		if (sumExpertise == 0.0) {
			// nobody is expert! everybody has expertise == 0
			return potentialAssignees.get(getRandom().nextInt(potentialAssignees.size()));
		}
		
		//assign to each assignee a probability base on his expertise
		for (int i = 0; i < potentialAssignees.size(); i++) {
			AssigneeExpertise ae = potentialAssignees.get(i);
			p[i] = ae.getExpertise() / sumExpertise;
			
		}
		//if this task had already an assignee, give this assignee probability 0.0
		if(currentAssignee != null){
			int indexOfCurrentAssignee = potentialAssignees.indexOf(currentAssignee);
			p[indexOfCurrentAssignee] = 0.0;
		}

		
		double measure = getRandom().nextDouble();
		double sum = 0.0;
		for (int i = 0; i < p.length; i++) {
			if (measure >= sum && measure < sum + p[i]) {
				return potentialAssignees.get(i);
			}
			sum += p[i];
		}

		return potentialAssignees.get(getRandom().nextInt(potentialAssignees.size()));
	}

	private void setRandom(Random random) {
		this.random = random;
	}

	public Random getRandom() {
		return random;
	}
	
	/**
	 * returns all planned tasks in this iteration including those set to backlog.
	 * @param iterPlan
	 * @return
	 */
	public Set<IPlannedTask> getPlannedTasks(IIterationPlan iterPlan) {
		Set<IPlannedTask> plannedTasks = new HashSet<IPlannedTask>();
		//we consider the tasks in backlog too; therefore iterPlan.getNumOfIterations() + 1
		for(int i = 0; i < iterPlan.getNumOfIterations() + 1; i++){
			plannedTasks.addAll(iterPlan.getAllPlannedTasksForIteration(i));
		}
		return plannedTasks;
	}

	public Set<ITask> getTasks(Set<ShiftDownPlannedTask> plannedTasks) {
		Set<ITask> result = new HashSet<ITask>();
		for(ShiftDownPlannedTask pt : plannedTasks){
			result.add(pt.getTask());
		}
		
		return result;
	}

	/**
	 * Unions the PlannedTasks in plannedTasks1 and plannedTasks2 based on their their Task.
	 * That is, if two instances of ShiftDownPlannedTask have the same instance of Task only one of them will be in union.
	 * The ShiftDownPlannedTask instance that survives is the one whose AssigneeExpertise have a less value of Expertise.
	 * This decision is made to add more variety in resulting sets of PlannedTasks and 
	 * helps avoiding early convergence of populations.
	 * @param plannedTasks1
	 * @param plannedTasks2
	 * @return
	 */
	public Set<IPlannedTask> unionOnTasks(Set<IPlannedTask> plannedTasks1, Set<IPlannedTask> plannedTasks2) {
		Set<IPlannedTask> union = new HashSet<IPlannedTask>();
		union.addAll(plannedTasks1);
		for(IPlannedTask pt2 : plannedTasks2){
			boolean exists = false;
			for(IPlannedTask unionPt : union){
				if(pt2.equalsTask(unionPt)){
					exists = true;
					break;
				}
			}
			if(!exists){
				union.add(pt2);
			}
		}
		return union; 
	}

	/**
	 * Removes from fromSet those PlannedTasks in subtractSet that have the same Task instance. 
	 * 
	 * @param fromSet
	 * @param subtractSet
	 * @return
	 */
	public Set<IPlannedTask> subtractOnTasks(Set<IPlannedTask> fromSet, Set<IPlannedTask> subtractSet) {
		Set<IPlannedTask> result = new HashSet<IPlannedTask>();
		Set<IPlannedTask> remove = new HashSet<IPlannedTask>();
		result.addAll(fromSet);
		for(IPlannedTask subtractPt : subtractSet){
			for(IPlannedTask pt : result){
				if(subtractPt.equalsTask(pt)){
					remove.add(pt);
					break;
				}
			}
		}
		result.removeAll(remove);
		return result; 
	}
	

}
