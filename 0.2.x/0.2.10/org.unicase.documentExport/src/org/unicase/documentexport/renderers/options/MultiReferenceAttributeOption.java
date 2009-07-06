package org.unicase.documentexport.renderers.options;

@SuppressWarnings("serial")
public class MultiReferenceAttributeOption extends AttributeOption {
	public ReferenceOption referenceOption = new ReferenceOption();
	public ListOption listOption = new ListOption();
	
	public MultiReferenceAttributeOption globalOption = null;
	
	public ReferenceOption getReferenceOption() {
		if (useGlobalOption()) {
			globalOption.referenceOption.contained = referenceOption.contained;
			return globalOption.referenceOption;
		} else {
			return referenceOption;
		}
	}
	
	public ListOption getListOption() {
		if (useGlobalOption()) {
			return globalOption.listOption;
		} else {
			return listOption;
		}	
	}
}
