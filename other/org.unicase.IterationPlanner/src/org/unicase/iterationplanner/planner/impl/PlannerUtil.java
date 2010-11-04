package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.Task;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;

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
	public int getIterationNumberProbabilistic(Task task, int numOfIterations) {
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
	public AssigneeExpertise getAssigneeProbabilistic(List<AssigneeExpertise> potentialAssignees) {
		double p[] = new double[potentialAssignees.size()];
		double sumExpertise = 0.0;
		for (AssigneeExpertise ae : potentialAssignees) {
			sumExpertise += ae.getExpertise();
		}
		if (sumExpertise == 0.0) {
			// nobody is expert! everybody has expertise == 0
			return potentialAssignees.get(getRandom().nextInt(potentialAssignees.size()));
		}
		for (int i = 0; i < potentialAssignees.size(); i++) {
			AssigneeExpertise ae = potentialAssignees.get(i);
			p[i] = ae.getExpertise() / sumExpertise;
		}

		double measure = getRandom().nextDouble();
		double sum = 0.0;
		for (int i = 0; i < p.length; i++) {
			if (measure >= sum && measure < sumExpertise + p[i]) {
				return potentialAssignees.get(i);
			}
			sumExpertise += p[i];
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
	public Set<PlannedTask> getPlannedTasks(IterationPlan iterPlan) {
		Set<PlannedTask> plannedTasks = new HashSet<PlannedTask>();
		//we consider the tasks in backlog too; therefore iterPlan.getNumOfIterations() + 1
		for(int i = 0; i < iterPlan.getNumOfIterations() + 1; i++){
			plannedTasks.addAll(iterPlan.getAllPlannedTasksForIteration(i));
		}
		return plannedTasks;
	}

	public Set<Task> getTasks(Set<PlannedTask> plannedTasks) {
		Set<Task> result = new HashSet<Task>();
		for(PlannedTask pt : plannedTasks){
			result.add(pt.getTask());
		}
		
		return result;
	}

	public Set<PlannedTask> unionOnTasks(Set<PlannedTask> plannedTasks1, Set<PlannedTask> plannedTasks2) {
		Set<PlannedTask> union = new HashSet<PlannedTask>();
		Set<PlannedTask> difference = new HashSet<PlannedTask>();
		union.addAll(plannedTasks1);
		for(PlannedTask pt2 : plannedTasks2){
			boolean alreadyExists = false;
			for(PlannedTask ptInUnion : union){
				if(pt2.equalsTask(ptInUnion)){
					alreadyExists = true;
				}
			}
			if(!alreadyExists){
				difference.add(pt2);
			}
		}
		union.addAll(difference);
		return union;
	}

	public Set<PlannedTask> subtractOnTasks(Set<PlannedTask> fromSet, Set<PlannedTask> subtractSet) {
		Set<PlannedTask> result = new HashSet<PlannedTask>();
		result.addAll(fromSet);
		//remove from fromSet the intersection of fromSet and subtractSet
		Set<PlannedTask> intersectOnTasks = intersectOnTasks(fromSet, subtractSet);
		for(PlannedTask pt : intersectOnTasks){
			for(PlannedTask ptInResult : fromSet){
				if(pt.equalsTask(ptInResult)){
					result.remove(ptInResult);
				}
			}
		}
		return result;
	}
	
	public Set<PlannedTask> intersectOnTasks(Set<PlannedTask> set1, Set<PlannedTask> set2){
		Set<PlannedTask> intersection = new HashSet<PlannedTask>();
		// find those planned tasks that have equal tasks
		for(PlannedTask pt1 : set1){
			for(PlannedTask pt2 : set2){
				if(pt1.equalsTask(pt2)){
					intersection.add(pt1);
				}
			}
		}
		return intersection;
	}

}
