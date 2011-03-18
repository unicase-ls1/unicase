/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.recommendation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * This is an interface for the operation known as link selection, where a couple of links are chosen from a bigger
 * number.
 * 
 * @author Henning Femmer
 */
public interface LinkSelectionStrategy {

	/**
	 * This method removes unwanted elements (normally because their probability is to low). The original map should not
	 * be changed.
	 * 
	 * @param selectionMap the map indicating the probabilities of each element.
	 * @return the resulting map
	 */
	Map<EObject, Double> selectCandidates(final Map<EObject, Double> selectionMap);

	/**
	 * Returns a short name for this selection.
	 * 
	 * @return short name
	 */
	String getName();
}
