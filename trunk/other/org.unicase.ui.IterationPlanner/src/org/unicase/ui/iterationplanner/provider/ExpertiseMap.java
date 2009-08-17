/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.unicase.model.organization.User;

/**
 * 
 * @author hodaie
 *
 */
public class ExpertiseMap {

	private Map<User, Double> expertiseMap;
	
	/**
	 * Constructor.
	 */
	public ExpertiseMap(){
		expertiseMap = new HashMap<User, Double>();
	}

	/**
	 * 
	 * @param expertiseMap expertise map
	 */
	public void setExpertiseMap(Map<User, Double> expertiseMap) {
		this.expertiseMap = expertiseMap;
	}

	/**
	 * expertise map.
	 * @return expertise map
	 */
	public Map<User, Double> getExpertiseMap() {
		return expertiseMap;
	}
	
	/**
	 * sort by expertise.
	 * @return sorted list of assignees based on their experties
	 */
	public List<Entry<User, Double>> sortByExpertise(){
		List<Entry<User, Double>> list = new ArrayList<Entry<User,Double>>();
		list.addAll(expertiseMap.entrySet());
		Collections.sort(list, new ExpertiseMapEntryComparator());
		return list;
	}
	

	/**
	 * If nobody has any expertise about this task.
	 * @return If nobody has any expertise about this task
	 */
	public boolean isAllZero(){
		for(Double value : expertiseMap.values()){
			if(value != 0){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 
	 * @author hodaie
	 *
	 */
	private class ExpertiseMapEntryComparator implements Comparator<Entry<User, Double>>{

		public int compare(Entry<User, Double> e1, Entry<User, Double> e2) {
			return e2.getValue().compareTo(e1.getValue());
		}

		
	}
	
	
	
}
