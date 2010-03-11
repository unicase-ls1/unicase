package org.unicase.rap.config;

import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractConfigEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6428677838227012400L;
	
	protected Properties properties;
	
	public AbstractConfigEntity() {
		properties = new Properties();
	}
	
	public Properties getProperties() {
		return properties;
	}

	protected abstract String getId();
}
