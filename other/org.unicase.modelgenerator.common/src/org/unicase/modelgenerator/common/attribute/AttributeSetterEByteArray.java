package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Class for creating random Byte[] values.
 * 
 * @see IAttributeSetter
 */
public class AttributeSetterEByteArray implements IAttributeSetter<byte[]> {

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
	 * length of the Byte-array that is randomly filled
	 */
	private int bytesize;
	
	/**
	 * Creates a new AttributeSetter for Byte[] attributes.
	 * 
	 * @param maxObjects maximum amount of attributes to create
	 * @param randomObj Random object used to create attribute values
	 * @param bytesize length of the Byte-array
	 */
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
		randomObj.nextBytes(bytes);
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
