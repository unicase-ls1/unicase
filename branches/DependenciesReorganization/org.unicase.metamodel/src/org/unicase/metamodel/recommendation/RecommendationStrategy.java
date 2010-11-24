/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.recommendation;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Henning Femmer
 */
public interface RecommendationStrategy {

	/**
	 * This method returns value pairs (ModelElement, Double) which indicate how probable a certain element might be
	 * linked. The Double values should be in (0,1) to support combination of methods.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base, also referred as candidates.
	 * @return a Map (ModelElement,Double)
	 */
	Map<EObject, Double> getMatchingMap(EObject base, Collection<EObject> elements);

	/**
	 * Returns the name of this strategy for output reasons.
	 * 
	 * @return the name
	 */
	String getName();
}
