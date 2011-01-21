package org.unicase.modelgenerator.common.attribute;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random BigInteger values.
 * 
 * @see IAttributeSetter
 */
public class AttributeSetterEBigInteger implements IAttributeSetter<BigInteger> {

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
	 * Creates a new AttributeSetter for Integer attributes.
	 * 
	 * @param maxObjects maximum amount of attributes to create
	 * @param randomObj Random object used to create attribute values
	 */
	public AttributeSetterEBigInteger(int maxObjects, Random randomObj) {
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

	public BigInteger createNewAttribute() {
		return new BigInteger(20, randomObj);
	}

	public Collection<BigInteger> createNewAttributes(){
		List<BigInteger> newAttrs = new ArrayList<BigInteger>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
