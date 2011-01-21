package org.unicase.modelgenerator.common.attribute;

import java.util.Collection;
import java.util.Random;

public interface IAttributeSetter<E> {
	
	public abstract int getMaxObjects();

	public abstract void setMaxObjects(int maxObjects);

	public abstract Random getRandomObj();

	public abstract void setRandomObj(Random randomObj);
	
	public abstract E createNewAttribute();

	public abstract Collection<E> createNewAttributes();

}