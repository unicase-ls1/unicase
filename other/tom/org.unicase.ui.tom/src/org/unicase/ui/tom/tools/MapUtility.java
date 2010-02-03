/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.tools;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author schroech
 *
 */
public final class MapUtility {

	private MapUtility(){
		super();
	}
	
	/**
	 * @param <K> The map type 
	 * @param <V> The set enumerated
	 * @param map The map being queried
	 * @param object The object of interest
	 * @return The keys for which the object is registered
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Set<K> getKeysForObject(Map<K, Set<V>> map,
			V object) {
		Set<K> keysForObject = new HashSet<K>();
		Set<K> keySet = map.keySet();

		for (K key : keySet) {
			Set set = map.get(key);
			if (set.contains(object)) {
				keysForObject.add(key);
			}
		}

		return keysForObject;
	}
}
