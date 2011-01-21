package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AttributeSetterEByteArray implements IAttributeSetter<byte[]> {

	private int maxObjects;
	private Random randomObj;
	private int bytesize;
	
	public AttributeSetterEByteArray(int maxObjects, Random randomObj,
			int bytesize) {
		this.maxObjects = maxObjects;
		this.randomObj = randomObj;
		this.bytesize = bytesize;
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

	public int getBytesize() {
		return bytesize;
	}

	public void setBytesize(int bytesize) {
		this.bytesize = bytesize;
	}
 
		
	public byte[] createNewAttribute() {
		byte[] bytes = new byte[bytesize];
		return bytes;
	}

	public Collection<byte[]> createNewAttributes() {
		List<byte[]> newAttributes = new ArrayList<byte[]>(maxObjects);
		for (int i=0; i<maxObjects; i++) {
			newAttributes.add(createNewAttribute());
		}
 		
		return newAttributes;
	}

}
