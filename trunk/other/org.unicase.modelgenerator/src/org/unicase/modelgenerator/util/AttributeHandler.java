package org.unicase.modelgenerator.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.unicase.modelgenerator.attributesetter.AttributSetterEString;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEBigDecimal;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEBigInteger;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEBoolean;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEByte;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEByteArray;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEChar;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEDate;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEDouble;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEFloat;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEInt;
import org.unicase.modelgenerator.attributesetter.AttributeSetterELong;
import org.unicase.modelgenerator.attributesetter.AttributeSetterEShort;
import org.unicase.modelgenerator.attributesetter.IAttributeSetter;

public class AttributeHandler {
	
	private Map<EClassifier, IAttributeSetter<?>> attributeSetters;
	
	public Map<EClassifier, IAttributeSetter<?>> getAttributeSetters(Random random) {
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
