package org.unicase.iterationplanner.planner.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

	private void setRandom(Random random) {
		this.random = random;
	}

	public Random getRandom() {
		return random;
	}

}
