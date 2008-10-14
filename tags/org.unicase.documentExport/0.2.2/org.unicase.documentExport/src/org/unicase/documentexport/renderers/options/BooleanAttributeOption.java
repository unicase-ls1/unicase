package org.unicase.documentexport.renderers.options;

public class BooleanAttributeOption extends AttributeOption {

	public BooleanOption booleanOption = new BooleanOption();
	public BooleanAttributeOption globalOption = null;
	
	public BooleanOption getBooleanOption() {
		if (useGlobalOption()) {
			return globalOption.booleanOption;
			
		} else {
			return booleanOption;
		}
	}
}
