package org.unicase.documentexport.renderers.elements;

import org.unicase.documentexport.renderers.options.RendererOption;

public abstract class UDocument {
	
	public RendererOption option;
	
	private UDocument parent = null;
	
	
	public UDocument() {
		
	}
	
	protected void setParent(UDocument newParent) {
		this.parent = newParent;
	}
	
	public UDocument getParent() {
		return this.parent;
	}
	
}
