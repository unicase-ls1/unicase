package org.unicase.documentexport.renderers.options;

import java.io.Serializable;

public class RendererOption implements Serializable {
	protected String optionName = "unnamed";
	
	
	public RendererOption() {
		
	}
	
	public RendererOption(String name) {
		this.optionName = name;
	}
	
	public String getName() {
		return optionName;
	}
	
	public void setName(String name) {
		this.optionName = name;
	}
}
