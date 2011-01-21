package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random Float values.
 * 
 * @see IAttributeSetter
 */
public class AttributeSetterEFloat implements IAttributeSetter<Float> {
	
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
	 * Creates a new AttributeSetter for Float attributes.
	 * 
	 * @param maxObjects maximum amount of attributes to create
	 * @param randomObj Random object used to create attribute values
	 */
	public AttributeSetterEFloat(int maxObjects, Random randomObj) {
		this.maxObjects = maxObjects;
		this.randomObj = randomObj;
	}

	public int getMaxObjects() {
		return maxObjects;
	}

	public void setMaxObjects(int maxObjects) {
		this.maxObjects = maxObjects;
	}

	public Random getRandomObj() {
		return randomObj;
	}

	public void setRandomObj(Random randomObj) {
		this.randomObj = randomObj;
	}
	
	public Float createNewAttribute() {
		return randomObj.nextFloat()*randomObj.nextInt();
	}

	public Collection<Float> createNewAttributes(){
		List<Float> newAttrs = new ArrayList<Float>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
