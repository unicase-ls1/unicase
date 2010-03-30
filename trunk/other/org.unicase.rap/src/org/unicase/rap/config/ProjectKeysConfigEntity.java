package org.unicase.rap.config;

import config.impl.ConfigEntityImpl;

/**
 * Config entity that is responsible for saving the access keys for each project.
 * 
 * @author emueller
 *
 */
public class ProjectKeysConfigEntity extends ConfigEntityImpl {
	
	/**
	 * Name of the configuration file used.
	 */
	private static final String CFG_FILENAME = "org.unicase.rap.config.ProjectKeysConfigEntity";
	
	/**
	 * Adds a project name and its access key to the configuration entity. 
	 * 
	 * @param projectName The name of the project
	 * @param key The access key of the project
	 */
	public void addAccessKey(String projectName, String key) {
		getProperties().put(projectName, key);
	}
	
	/**
	 * Returns the access key for the given project.
	 * 
	 * @param projectName The name of the project whose access key should be looked up.
	 * @return The access key or null, if no access key has been defined.
	 */
	public String getAccessKey(String projectName) {
		
		Object o = getProperties().get(projectName);
		
		if (o != null) {
			return (String) o;
		}
		
		return null; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConfigFilename() {
		return CFG_FILENAME;
	}
}
