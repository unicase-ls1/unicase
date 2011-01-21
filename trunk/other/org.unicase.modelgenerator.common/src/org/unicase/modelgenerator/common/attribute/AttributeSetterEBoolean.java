package org.unicase.modelgenerator.common.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AttributeSetterEBoolean implements IAttributeSetter<Boolean> {
	
	private int maxObjects;
	private Random randomObj;
	
	public AttributeSetterEBoolean(int maxObjects, Random randomObj) {
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

	

	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.util.IAttributeSetter#createNewAttribute()
	 */
	public Boolean createNewAttribute() {
		return randomObj.nextBoolean();
	}

	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.util.IAttributeSetter#createNewAttributes()
	 */
	public Collection<Boolean> createNewAttributes() {
		List<Boolean> newAttributes = new ArrayList<Boolean>();
		for (int i=0; i<maxObjects; i++) {
			newAttributes.add(createNewAttribute());
		}
		return newAttributes;
	}
	
	
}
