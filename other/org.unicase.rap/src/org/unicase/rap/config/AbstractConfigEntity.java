package org.unicase.rap.config;

import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractConfigEntity implements Serializable {
	
	protected String id;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6428677838227012400L;
	
	protected Properties properties;
	
	public AbstractConfigEntity(String id) {
		properties = new Properties();
		this.id = id;
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public String getId() {
		return id;
	}

}
