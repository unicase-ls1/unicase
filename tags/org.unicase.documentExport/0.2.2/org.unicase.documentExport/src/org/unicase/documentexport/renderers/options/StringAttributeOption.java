package org.unicase.documentexport.renderers.options;


public class StringAttributeOption extends AttributeOption {
	
	public TextOption textOption = new TextOption();
	
	public StringAttributeOption globalOption = null;
	
	public TextOption getTextOption() {
		if (useGlobalOption()) {
			return globalOption.textOption;
		} else {
			return textOption;
		}
	}
}
