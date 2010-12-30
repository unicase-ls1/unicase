/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import java.util.ArrayList;
import java.util.List;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * Wrap class for the preferences tree.
 * @author kami
 *
 */
public class PreferenceList {
	
	private  Preferences node;
	
	/**
	 * The construct.
	 * @param node the preference node
	 */
	public PreferenceList(Preferences node){
		this.node = node; 
	}
	
	/**
	 * Gets the preference list.
	 * @return list the list
	 */
	public  List<String> getList() {
		List<String> result = new ArrayList<String>();
		int i = 0;
		while (true) {
			String value = node.get(i + "", null);
			if (value != null) {
				result.add(value);
				i++;
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * Sets the preference list.
	 * @param input the input
	 */
	public  void setList(List<String> input) {
		int i = 0;
		for (String s : input) {
			node.put(i + "", s);
			i++;
		}

	}
	
	/**
	 * Adds value to the preference list. 
	 * @param value the value
	 */
	public void add(String value) {
		int i = 0;
		while (node.get(i +"", null) != null){
			i++;
		}
		node.put(i + "", value);
	}

	/**
	 * Saves changes to the persistent store.
	 * @throws BackingStoreException .
	 */
	public void flush() throws BackingStoreException {
		this.node.flush();
	}
	
	
}
