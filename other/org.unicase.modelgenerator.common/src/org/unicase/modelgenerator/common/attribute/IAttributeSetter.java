package org.unicase.modelgenerator.common.attribute;

import java.util.Collection;
import java.util.Random;

/**
 * Interface that defines methods for creating attributes in order
 * to generate or change Ecore models. Attributes are created
 * using a Random object.
 * 
 * @param <E> the attribute type of the attributes to create 
 */
public interface IAttributeSetter<E> {
	
	
	/**
	 * @return maximum number of attributes to create
	 */
	public abstract int getMaxObjects();

	/**
	 * Set the number of maximum attributes to create
	 * 
	 * @param maxObjects the new value for 
	 * <code>this.maxObjects</code>
	 */
	public abstract void setMaxObjects(int maxObjects);

	/**
	 * @return the Random object used to create attributes
	 */
	public abstract Random getRandomObj();

	/**
	 * Sets the Random object used to create attributes.
	 * 
	 * @param randomObj the new value for 
	 * <code>this.randomObj</code>
	 */
	public abstract void setRandomObj(Random randomObj);
	
	/**
	 * Creates one attribute of type <code>E</code>.
	 * The result is determined by <code>randomObj</code>.
	 * 
	 * @return the created attribute
	 */
	public abstract E createNewAttribute();

	/**
	 * Creates a collection of attributes of type <code>E</code>. 
	 * The result is determined by <code>randomObj</code>.
	 * 
	 * @return all created attributes as a collection
	 */
	public abstract Collection<E> createNewAttributes();

}