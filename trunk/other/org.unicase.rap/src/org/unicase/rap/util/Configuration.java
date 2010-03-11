package org.unicase.rap.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Represents the web application Configuration.
 * 
 * @author Fatih Ulusoy
 */
public final class Configuration {
	
	private static Properties properties;

	private static Configuration configuration;
	
	public static final String CONFIG_FILE = "conf/web-app.properties";
	
	
	private Configuration(){
		
	}
	
	/**
	 * Initialize configuration
	 */
	public static void initialize() {
		if (configuration == null) {
			properties = new Properties();
			try {
				ClassLoader classLoader = Configuration.class.getClassLoader();
				InputStream inStream = classLoader.getResourceAsStream(CONFIG_FILE);
				properties.load(inStream);
				inStream.close();
				configuration = new Configuration();
			} catch (IOException e) {
				WorkspaceUtil.logWarning("Property initialization failed, using default properties.", e);
			} 
		}
	}
	
	/**
	 * Gets properties.
	 * 
	 * @return
	 */
	public static Properties getProperties() {
		if(properties == null)
			properties = new Properties();
		return properties;
	}

	/**
	 * Sets properties.
	 * @param prop
	 */
	public static void setProperties(Properties prop) {
		properties = prop;
	}
	
}


