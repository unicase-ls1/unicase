package org.unicase.projectgenerator2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEChar implements IAttributeSetter<Character> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


	public AttributeSetterEChar(int maxObjects, Random randomObj) {
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


	
	public Character createNewAttribute() {
		return (char)(randomObj.nextInt(94) + 33);
	}

	public Collection<Character> createNewAttributes(){
		List<Character> newAttrs = new ArrayList<Character>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
