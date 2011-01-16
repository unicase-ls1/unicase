package org.unicase.projectgenerator2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

public class AttributSetterEString implements IAttributeSetter<String> {
	
	protected int maxObjects;
	protected Random randomObj;
	
	
	
	public AttributSetterEString(int maxObjects, Random randomObj) {
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


	
	public String createNewAttribute() {
		 StringBuffer string = new StringBuffer();
		 string.delete(0, string.length());
			for(int j = -5; j<randomObj.nextInt(10); j++) {
				string.append((char)(randomObj.nextInt(94) + 33));
			}
		return string.toString();
	}

	public Collection<String> createNewAttributes(){
		List<String> newAttrs = new ArrayList<String>(maxObjects);
		for (int i=0; i<maxObjects;i++) {
			newAttrs.add(createNewAttribute());
		}
		return newAttrs;
	}

}
