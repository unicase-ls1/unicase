package org.unicase.rap.status.config;

import org.unicase.workspace.ProjectSpace;

import config.impl.ConfigEntityImpl;

/**
 * Config entity that holds status view related configuration settings for a project.
 * This is just a convenience class for wrapping <code>getProperties()</code> 
 * calls of the parent class. 
 * 
 * @author emueller
 *
 */
public class StatusConfigEntity extends ConfigEntityImpl {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1726480282495024383L;
	
	private ProjectSpace projectSpace;
	
	/**
	 * Keys used for storing configuration settings.
	 * 
	 * @author emueller
	 *
	 */
	public class Keys {
		public static final String CRYPTIC_ELEMENT_KEY = "CRYPTIC_ELEMENT";
		public static final String TEAMLIST_KEY = "TEAMLIST";
		public static final String WORKITEMLIST_KEY = "WORKITEMLIST";
	}
	
	public StatusConfigEntity(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}
	
	/**
	 * Sets the cryptic element that is needed in order to access the project status view.
	 * 
	 * @param crypticElement The cryptic element that is needed to appear in the URL.
	 * The cryptic element may be any string, but whitespaces will be removed.
	 */
	public void setCrypticElement(String crypticElement) {
		String c = crypticElement.trim().replaceAll("\\s", "");	
		getProperties().put(Keys.CRYPTIC_ELEMENT_KEY, c);
	}

	/**
	 * Returns the cryptic element that is needed to appear in the URL when accessing a project.
	 * 
	 * @return The cryptic element.
	 */
	public String getCrypticElement() {
		return (String) getProperties().get(Keys.CRYPTIC_ELEMENT_KEY);
	}

	/**
	 * Determines whether the team member tab should be visible in the status view.
	 * 
	 * @param teamListVisible True, if the team member tab should be visible, else false.
	 */
	public void setTeamListVisible(boolean teamListVisible) {
		getProperties().put(Keys.TEAMLIST_KEY, new Boolean(teamListVisible));
	}

	/**
	 * Determines whether the team member tab is visible in the status view.
	 * 
	 * @return True, if the team member tab should is visible, else false.
	 */
	public boolean isTeamListVisible() {
		Boolean b = (Boolean) getProperties().get(Keys.TEAMLIST_KEY);
		return b.booleanValue();
	}

	/**
	 * Determines whether the workitems tab should be visible in the status view.
	 * 
	 * @param workItemsListVisible True, if the workitems tab should be visible, else false.
	 */
	public void setWorkItemsVisible(boolean workItemsListVisible) {
		getProperties().put(Keys.WORKITEMLIST_KEY, new Boolean(workItemsListVisible));
	}

	/**
	 * Determines whether the workitems tab is visible in the status view.
	 * 
	 * @return True, if the workitems tab should is visible, else false.
	 */
	public boolean isWorkItemsVisible() {
		Boolean b = (Boolean) getProperties().get(Keys.WORKITEMLIST_KEY);
		return b.booleanValue();
	}
	
	@Override
	public String getConfigFilename() {
		if (projectSpace == null) {
			return  StatusConfigEntity.class.getCanonicalName();
		} else {
			return projectSpace.getProjectName() + "." + StatusConfigEntity.class.getCanonicalName(); 
		}
	}


}
