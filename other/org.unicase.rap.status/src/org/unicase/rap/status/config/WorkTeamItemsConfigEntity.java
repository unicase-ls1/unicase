package org.unicase.rap.status.config;

import config.impl.ConfigEntityImpl;

public class WorkTeamItemsConfigEntity extends ConfigEntityImpl {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1726480282495024383L;
	
	
	public class Keys {
		public static final String CRYPTIC_ELEMENT_KEY = "CRYPTIC_ELEMENT";
		public static final String TEAMLIST_KEY = "TEAMLIST";
		public static final String WORKITEMLIST_KEY = "WORKITEMLIST";
	}
	
	public void setCrypticElement(String crypticElement) {
		getProperties().put(Keys.CRYPTIC_ELEMENT_KEY, crypticElement);
	}

	public String getCrypticElement() {
		return (String) getProperties().get(Keys.CRYPTIC_ELEMENT_KEY);
	}

	public void setTeamListVisible(boolean teamListVisible) {
		getProperties().put(Keys.TEAMLIST_KEY, new Boolean(teamListVisible));
	}

	public boolean isTeamListVisible() {
		Boolean b = (Boolean) getProperties().get(Keys.TEAMLIST_KEY);
		return b.booleanValue();
	}

	public void setWorkItemsVisible(boolean workItemsListVisible) {
		getProperties().put(Keys.WORKITEMLIST_KEY, new Boolean(workItemsListVisible));
	}

	public boolean isWorkItemsVisible() {
		Boolean b = (Boolean) getProperties().get(Keys.WORKITEMLIST_KEY);
		return b.booleanValue();
	}
}
