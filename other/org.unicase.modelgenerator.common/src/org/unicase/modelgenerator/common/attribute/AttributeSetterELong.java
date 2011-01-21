package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AttributeSetterELong implements IAttributeSetter<Long> {
	
	protected int maxObjects;
	protected Random randomObj;
	

	public AttributeSetterELong(int maxObjects, Random randomObj) {
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
		
	public Long createNewAttribute() {
		return randomObj.nextLong();
	}

	public Collection<Long> createNewAttributes(){
		List<Long> newAttrs = new ArrayList<Long>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
