/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.modelgenerator.common.attribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Class that grants access to the attribute setters in order to generate 
 * new attributes when generating or changing an Ecore model. These setters
 * can be accessed by {@link #getAttributeSetters()}.
 * 
 * @see IAttributeSetter
 */
public final class AttributeHandler {
	
	/**
	 * The Random-object corresponding to the current map of AttributeSetters.
	 * 
	 * @see #setRandom(Random)
	 */
	private static Random random;
	
	/**
	 * Map that maps every attributeType to an AttributeSetter.
	 * 
	 * @see #getAttributeSetters()
	 */
	private static Map<EClassifier, IAttributeSetter<?>> attributeSetters;

	/**
	 * Private constructor.
	 */
	private AttributeHandler() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Returns a map containing an AttributeSetter-instance for each 
	 * attribute type, granting access to all AttributeSetters.
	 *  
	 * @return the map that maps every attribute type to its attribute setter
	 * @see AttributeSetter
	 */
	public static Map<EClassifier, IAttributeSetter<?>> getAttributeSetters() {
		if(attributeSetters != null) {
			return attributeSetters;
		}
		EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
		
		attributeSetters = new LinkedHashMap<EClassifier, IAttributeSetter<?>>();
		IAttributeSetter<?> oAttributeSetter;
		
		oAttributeSetter = new AttributeSetterEBoolean(3, random);
		attributeSetters.put(ecoreInstance.getEBoolean(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEBooleanObject(), oAttributeSetter);
	
		attributeSetters.put(ecoreInstance.getEByteArray(), new AttributeSetterEByteArray(3, random, 100));
		
		attributeSetters.put(ecoreInstance.getEString(), new AttributSetterEString(3, random));
		
		oAttributeSetter = new AttributeSetterEInt(3, random);
		attributeSetters.put(ecoreInstance.getEInt(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEIntegerObject(), oAttributeSetter);
		
		attributeSetters.put(ecoreInstance.getEDate(), new AttributeSetterEDate(3, random));
		
		oAttributeSetter = new AttributeSetterELong(3, random);
		attributeSetters.put(ecoreInstance.getELong(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getELongObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEByte(3, random);
		attributeSetters.put(ecoreInstance.getEByte(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEByteObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEChar(3, random);
		attributeSetters.put(ecoreInstance.getEChar(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getECharacterObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEDouble(3, random);
		attributeSetters.put(ecoreInstance.getEDouble(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEDoubleObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEFloat(3, random);
		attributeSetters.put(ecoreInstance.getEFloat(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEFloatObject(), oAttributeSetter);
		
		oAttributeSetter = new AttributeSetterEShort(3, random);
		attributeSetters.put(ecoreInstance.getEShort(), oAttributeSetter);
		attributeSetters.put(ecoreInstance.getEShortObject(), oAttributeSetter);
		
		attributeSetters.put(ecoreInstance.getEBigInteger(),new AttributeSetterEBigInteger(3, random));
		
		attributeSetters.put(ecoreInstance.getEBigDecimal(),new AttributeSetterEBigDecimal(3, random));
		
		return attributeSetters;
		
	}
	
	/**
	 * Sets the current Random-object to <code>newRandom</code>.
	 * The {@link #attributeSetters}-map is set to <code>null</code>,
	 * as new AttributeSetters have to be created for the new random value.
	 *   
	 * @param newRandom the new value for <code>this.random</code>
	 */
	public static void setRandom(Random newRandom) {
		attributeSetters = null;
		random = newRandom;
	}
}
