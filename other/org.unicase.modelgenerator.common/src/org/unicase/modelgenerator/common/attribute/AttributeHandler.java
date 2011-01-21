package org.unicase.modelgenerator.common.attribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.unicase.modelgenerator.common.attribute.AttributSetterEString;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEBigDecimal;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEBigInteger;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEBoolean;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEByte;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEByteArray;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEChar;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEDate;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEDouble;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEFloat;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEInt;
import org.unicase.modelgenerator.common.attribute.AttributeSetterELong;
import org.unicase.modelgenerator.common.attribute.AttributeSetterEShort;
import org.unicase.modelgenerator.common.attribute.IAttributeSetter;

public class AttributeHandler {
	
	private Random random;
	
	public AttributeHandler(Random random) {
		this.random = random;
	}
	
	private Map<EClassifier, IAttributeSetter<?>> attributeSetters;
	
	public Map<EClassifier, IAttributeSetter<?>> getAttributeSetters() {
		if(attributeSetters != null)
			return attributeSetters;
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
}
