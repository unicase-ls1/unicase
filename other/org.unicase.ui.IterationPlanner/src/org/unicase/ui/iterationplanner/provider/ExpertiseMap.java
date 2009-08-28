/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.unicase.model.organization.OrgUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author hodaie
 */
public class ExpertiseMap {

	private Map<OrgUnit, Double> map;

	/**
	 * Constructor.
	 */
	public ExpertiseMap() {
		map = new HashMap<OrgUnit, Double>();
	}

	/**
	 * @param map expertise map
	 */
	public void setExpertiseMap(Map<OrgUnit, Double> expertiseMap) {
		this.map = expertiseMap;
	}

	/**
	 * expertise map.
	 * 
	 * @return expertise map
	 */
	public void put(OrgUnit assignee, Double expertise) {
		map.put(assignee, expertise);
	}

	/**
	 * sort by expertise.
	 * 
	 * @return sorted list of assignees based on their experties
	 */
	public List<Entry<OrgUnit, Double>> sortByExpertise() {
		List<Entry<OrgUnit, Double>> list = new ArrayList<Entry<OrgUnit, Double>>();
		list.addAll(map.entrySet());
		Collections.sort(list, new ExpertiseMapEntryComparator());
		return list;
	}

	/**
	 * If nobody has any expertise about this task.
	 * 
	 * @return If nobody has any expertise about this task
	 */
	public boolean isAllZero() {
		for (Double value : map.values()) {
			if (value != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @author hodaie
	 */
	private class ExpertiseMapEntryComparator implements Comparator<Entry<OrgUnit, Double>> {

		public int compare(Entry<OrgUnit, Double> e1, Entry<OrgUnit, Double> e2) {
			return e2.getValue().compareTo(e1.getValue());
		}

	}

	public Iterator<Entry<OrgUnit, Double>> getIterator() {
		return map.entrySet().iterator();
	}

}
