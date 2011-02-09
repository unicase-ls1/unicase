/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random Short values.
 * 
 * @see IAttributeSetter
 */
public class AttributeSetterEShort implements IAttributeSetter<Short> {

	/**
	 * Maximum amount of attributes that are created by {@link #createNewAttributes()}.
	 */
	private int maxObjects;
	
	/**
	 * Random object that is used to determine values for attributes created 
	 * by {@link #createNewAttribute()} and {@link #createNewAttributes()}.
	 */
	private Random randomObj;

	/**
	 * Creates a new AttributeSetter for Short attributes.
	 * 
	 * @param maxObjects maximum amount of attributes to create
	 * @param randomObj Random object used to create attribute values
	 */
	public AttributeSetterEShort(int maxObjects, Random randomObj) {
		this.maxObjects = maxObjects;
		this.randomObj = randomObj;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getMaxObjects() {
		return maxObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setMaxObjects(int maxObjects) {
		this.maxObjects = maxObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	public Random getRandomObj() {
		return randomObj;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRandomObj(Random randomObj) {
		this.randomObj = randomObj;
	}

	/**
	 * {@inheritDoc}
	 */
	public Short createNewAttribute() {
		return (short)randomObj.nextInt();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Short> createNewAttributes(){
		List<Short> newAttrs = new ArrayList<Short>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
