package org.unicase.rap.status.config;

import org.unicase.rap.config.AbstractConfigEntity;

public class WorkTeamItemsConfigEntity extends AbstractConfigEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1726480282495024383L;
	
	private static final String CRYPTIC_ELEMENT_KEY = "CRYPTIC_ELEMENT";
	private static final String BUG_CONTAINER_KEY = "BUG_CONTAINER";
	private static final String TEAMLIST_KEY = "TEAMLIST";
	private static final String WORKITEMLIST_KEY = "WORKITEMLIST";
	
	public WorkTeamItemsConfigEntity() {
	}

	public void setCrypticElement(String crypticElement) {
		properties.put(CRYPTIC_ELEMENT_KEY, crypticElement);
	}

	public String getCrypticElement() {
		return (String) properties.get(CRYPTIC_ELEMENT_KEY);
	}

	// TODO: parameter should be of type ModelElement of similiar
	public void setBugContainer(Object bugContainer) {
		properties.put(BUG_CONTAINER_KEY, bugContainer);
	}

	public Object getBugContainer() {
		return properties.get(BUG_CONTAINER_KEY);
	}

	public void setTeamListVisible(boolean teamListVisible) {
		properties.put(TEAMLIST_KEY, new Boolean(teamListVisible).toString());
	}

	public boolean isTeamListVisible() {
		Boolean b = (Boolean) properties.get(TEAMLIST_KEY);
		return b.booleanValue();
	}

	public void setWorkItemsVisible(boolean workItemsListVisible) {
		properties.put(WORKITEMLIST_KEY, new Boolean(workItemsListVisible).toString());
	}

	public boolean isWorkItemsVisible() {
		Boolean b = (Boolean) properties.get(WORKITEMLIST_KEY);
		return b.booleanValue();
	}

	@Override
	protected String getId() {
		return "org.unicase.ui.web.projectview.WorkTeamItemsConfigEntity";
	}
}
