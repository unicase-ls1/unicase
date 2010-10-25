package org.unicase.iterationplanner.planner.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.Task;

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

		// we want also consider backlog, hence numOfIterations + 1
		int k = numOfIterations + 1;
		double[] p = new double[k];
		double maxPrio = 10.0;
		// no task is allowed to have max priority, otherwise p0 = 1, and the method does not work.
		double taskPrio = task.getPriority();
		if (taskPrio == 10) {
			taskPrio -= 0.5;
		}
		p[0] = task.getPriority() / maxPrio;
		double pNtoK = 1 - p[0]; // 1 to k
		double pNMinus1toK = 1.0; // 0 to k
		for (int i = 1; i < p.length; i++) {
			p[i] = p[0] * pNtoK;
			if (i == p.length - 1) {
				// this is the last one; pNtoK is now pK-1ToK, and p[i-1] is pK-1
				p[i] = pNtoK - p[i - 1];
			}
			pNtoK = pNMinus1toK - p[i - 1];
			pNMinus1toK = pNtoK;

		}

		// we got the priorites for each iteration.
		// now return one of them.
		getRandom().nextDouble();
		return 0;
	}

	public void testIterProbs(int prio, int numOfIters) {
		if (prio > 10) {
			throw new RuntimeException("Task priority must be between 0 and 10.");
		}

		// we want also consider backlog, hence numOfIterations + 1
		int k = numOfIters + 1;
		double[] p = new double[k];
		double maxPrio = 10.0;
		// no task is allowed to have max priority, otherwise p0 = 1, and the method does not work.
		double taskPrio = prio;
		if (taskPrio == 10) {
			taskPrio -= 1;
		}
		p[0] = taskPrio / maxPrio;
		double pNtoK = 1 - p[0]; // 1 to k
		double pNMinus1toK = 1.0; // 0 to k
		for (int i = 1; i < p.length; i++) {
			p[i] = p[0] * pNtoK;
			if (i == p.length - 1) {
				// this is the last one; pNtoK is now pK-1ToK, and p[i-1] is pK-1
				p[i] = pNtoK;
			}
			pNMinus1toK = pNtoK;
			pNtoK = pNMinus1toK - p[i];
		}

		for (int j = 0; j < p.length; j++) {
			System.out.println("Iteration" + j + " -----> " + round(p[j], 3));
		}
	}

	public double round(double d, int decimalPlace) {
		// see the Javadoc about why we use a String in the constructor
		// http://java.sun.com/j2se/1.5.0/docs/api/java/math/BigDecimal.html#BigDecimal(double)
		BigDecimal bd = new BigDecimal(Double.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * @return
	 */
	public AssigneeExpertise getAssigneeProbabilistic(List<AssigneeExpertise> potentialAssignees) {
		return null;
	}

	private void setRandom(Random random) {
		this.random = random;
	}

	public Random getRandom() {
		return random;
	}

}
