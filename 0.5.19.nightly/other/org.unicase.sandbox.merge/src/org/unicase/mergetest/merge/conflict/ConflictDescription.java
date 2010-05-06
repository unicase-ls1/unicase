package org.unicase.mergetest.merge.conflict;

import java.util.HashMap;
import java.util.Map;

public class ConflictDescription {

	private Map<String,Object> values;
	private final String description;
	private String imageName;

	public ConflictDescription(String description) {
		this.description = description;
		values = new HashMap<String, Object>();
	}
	
	public void add(String key, Object value) {
		values.put(key, value);
	}
	
	public String getDescription() {
		return description;
	}
	
	public Map<String, Object> getValues() {
		return values;
	}

	public String getImage() {
		return imageName;
	}
	
	public void setImage(String name) {
		this.imageName = name;
		
	}
}
