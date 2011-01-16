package org.unicase.projectgenerator2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEShort implements IAttributeSetter<Short> {

	protected int maxObjects;
	protected Random randomObj;
	
	


	public AttributeSetterEShort(int maxObjects, Random randomObj) {
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


	
	public Short createNewAttribute() {
		return (short)randomObj.nextInt();
	}

	public Collection<Short> createNewAttributes(){
		List<Short> newAttrs = new ArrayList<Short>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
