package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEDouble implements IAttributeSetter<Double> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


	public AttributeSetterEDouble(int maxObjects, Random randomObj) {
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


	
	public Double createNewAttribute() {
		return randomObj.nextDouble()*randomObj.nextInt();
	}

	public Collection<Double> createNewAttributes(){
		List<Double> newAttrs = new ArrayList<Double>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
