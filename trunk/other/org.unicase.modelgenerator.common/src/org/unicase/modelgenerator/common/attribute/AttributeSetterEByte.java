package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEByte implements IAttributeSetter<byte[]> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


	public AttributeSetterEByte(int maxObjects, Random randomObj) {
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


	
	public byte[] createNewAttribute() {
		byte[] singlebyte = new byte[1];
		randomObj.nextBytes(singlebyte);
		return singlebyte;
	}

	public Collection<byte[]> createNewAttributes(){
		List<byte[]> newAttrs = new ArrayList<byte[]>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
