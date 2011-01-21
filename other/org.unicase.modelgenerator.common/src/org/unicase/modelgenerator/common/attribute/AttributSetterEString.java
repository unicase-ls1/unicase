package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random String values.
 * 
 * @see IAttributeSetter
 */
public class AttributSetterEString implements IAttributeSetter<String> {
	
	/**
	 * Maximum amount of attributes that are created by {@link #createNewAttributes()}.
	 */
	protected int maxObjects;
	
	/**
	 * Random object that is used to determine values for attributes created 
	 * by {@link #createNewAttribute()} and {@link #createNewAttributes()}.
	 */
	protected Random randomObj;	
	
	/**
	 * Creates a new AttributeSetter for String attributes.
	 * 
	 * @param maxObjects maximum amount of attributes to create
	 * @param randomObj Random object used to create attribute values
	 */
	public AttributSetterEString(int maxObjects, Random randomObj) {
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
	public String createNewAttribute() {
		 StringBuffer string = new StringBuffer();
		 string.delete(0, string.length());
			for(int j = -5; j<randomObj.nextInt(10); j++) {
				string.append((char)(randomObj.nextInt(94) + 33));
			}
		return string.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> createNewAttributes(){
		List<String> newAttrs = new ArrayList<String>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
