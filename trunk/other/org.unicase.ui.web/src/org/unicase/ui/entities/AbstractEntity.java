package org.unicase.ui.entities;

import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6428677838227012400L;
	
	private static final String ID_KEY = "ID"; 
	
	private String id;
	protected Properties properties;
	
	public AbstractEntity(String id) {
		this.id = id;
		properties = new Properties();
		properties.put(ID_KEY, id);
	}
	
	public Properties getProperties() {
		return properties;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
