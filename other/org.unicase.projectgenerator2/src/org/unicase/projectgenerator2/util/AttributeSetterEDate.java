package org.unicase.projectgenerator2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

public class AttributeSetterEDate implements IAttributeSetter<Date> {
	
	protected int maxObjects;
	protected Random randomObj;
	

	public AttributeSetterEDate(int maxObjects, Random randomObj) {
		super();
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

	
	public Date createNewAttribute() {
		return new Date();
	}

	public Collection<Date> createNewAttributes(){
		List<Date> newAttrs = new ArrayList<Date>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
