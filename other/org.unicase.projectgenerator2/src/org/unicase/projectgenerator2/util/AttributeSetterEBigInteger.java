package org.unicase.projectgenerator2.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEBigInteger implements IAttributeSetter<BigInteger> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


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
