/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.Set;

import org.unicase.model.ModelElement;

/**
 * Interface for a taxonomy. Taxonomies are used for runtime classification of {@link ModelElement}
 * 
 * @author helming
 */
public interface Taxonomy {
	/**
	 * Returns the classes which belong to the taxonomy.
	 * 
	 * @return a set of {@link ModelElement} classes
	 */
	Set<Class<? extends ModelElement>> getTaxonomyClasses();

	/**
	 * Returns if the class is in the taxonomy.
	 * 
	 * @param clazz the specific class
	 * @return true if the class is in the taxonomy
	 */
	boolean isInTaxonomy(Class<? extends ModelElement> clazz);
}
