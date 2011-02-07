/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.modelgenerator.common.attribute;

import java.util.Collection;
import java.util.Random;

/**
 * Interface that defines methods for creating attributes in order
 * to generate or change Ecore models. Attributes are created
 * using a Random object.
 * 
 * @param <E> the attribute type of the attributes to create 
 */
public interface IAttributeSetter<E> {
	
	
	/**
	 * @return maximum number of attributes to create
	 */
	int getMaxObjects();

	/**
	 * Set the number of maximum attributes to create.
	 * 
	 * @param maxObjects the new value for 
	 * <code>this.maxObjects</code>
	 */
	void setMaxObjects(int maxObjects);

	/**
	 * @return the Random object used to create attributes
	 */
	Random getRandomObj();

	/**
	 * Sets the Random object used to create attributes.
	 * 
	 * @param randomObj the new value for 
	 * <code>this.randomObj</code>
	 */
	void setRandomObj(Random randomObj);
	
	/**
	 * Creates one attribute of type <code>E</code>.
	 * The result is determined by <code>randomObj</code>.
	 * 
	 * @return the created attribute
	 */
	E createNewAttribute();

	/**
	 * Creates a collection of attributes of type <code>E</code>. 
	 * The result is determined by <code>randomObj</code>.
	 * 
	 * @return all created attributes as a collection
	 */
	Collection<E> createNewAttributes();

}