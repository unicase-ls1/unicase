package org.unicase.rap.config;

import config.ConfigEntity;
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
	
	private class Keys {
		final static String POSTFIX_ACTIVATED = "_ACTIVATED";
		final static String POSTFIX_ACCESS_KEY = "_ACCESS_KEY";
	}
	
	public ProjectKeysConfigEntity() {
		
	}
	
	public ProjectKeysConfigEntity(ConfigEntity configEntity) {
		properties = configEntity.getProperties();
	}
	
	/**
	 * Adds a project name and its access key to the configuration entity. 
	 * 
	 * @param projectName The name of the project
	 * @param key The access key of the project
	 */
	public void addAccessKey(String projectName, String key) {
		getProperties().put(projectName + Keys.POSTFIX_ACCESS_KEY, key);
	}
	
	/**
	 * Returns the access key for the given project.
	 * 
	 * @param projectName The name of the project whose access key should be looked up.
	 * @return The access key or null, if no access key has been defined.
	 */
	public String getAccessKey(String projectName) {
		
		Object o = getProperties().get(projectName + Keys.POSTFIX_ACCESS_KEY);
		
		if (o != null) {
			return (String) o;
		}
		
		return null; 
	}
	
	/**
	 * Sets the activated bit for the given project.
	 * @param projectName The name of a project.
	 * @param isActivated Whether the project should be activated.
	 */
	public void setProjectActivated(String projectName, boolean isActivated) {
		getProperties().put(projectName + Keys.POSTFIX_ACTIVATED, new Boolean(isActivated));
	}
	
	/**
	 * Returns whether the given project is activated.
	 * 
	 * @param projectName The name of the project, which should be determined whether it is activated.
	 * @return True, if the project is activated, false else.
	 */
	public boolean getProjectActivated(String projectName) {
		
		Object o = getProperties().get(projectName + Keys.POSTFIX_ACTIVATED);
		
		if (o != null) {
			return ((Boolean) o).booleanValue();
		}
		
		return false; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConfigFilename() {
		return CFG_FILENAME;
	}
}
