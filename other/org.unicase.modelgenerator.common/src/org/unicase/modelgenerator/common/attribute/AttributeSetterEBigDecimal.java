package org.unicase.modelgenerator.common.attribute;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class AttributeSetterEBigDecimal implements IAttributeSetter<BigDecimal> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	


	public AttributeSetterEBigDecimal(int maxObjects, Random randomObj) {
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


	
	public BigDecimal createNewAttribute() {
		return new BigDecimal(randomObj.nextDouble()*randomObj.nextInt());
	}

	public Collection<BigDecimal> createNewAttributes(){
		List<BigDecimal> newAttrs = new ArrayList<BigDecimal>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
