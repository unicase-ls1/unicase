package org.unicase.documentexport.renderers.options;

@SuppressWarnings("serial")
public class SingleReferenceAttributeOption extends AttributeOption {
	public ReferenceOption referenceOption = new ReferenceOption();
	
	public SingleReferenceAttributeOption globalOption = null;
	
	public ReferenceOption getReferenceOption() {
		if (useGlobalOption()) {
			return globalOption.referenceOption;
		} else {
			return referenceOption;
		}
	}
}
