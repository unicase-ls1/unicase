package org.unicase.modelgenerator.attributesetter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEFloat implements IAttributeSetter<Float> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


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
