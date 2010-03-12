package org.unicase.rap.bugreport.config;

import org.unicase.rap.config.AbstractConfigEntity;

public class BugReportingConfigEntity extends AbstractConfigEntity {

	private static final long serialVersionUID = -5461631585176746027L;
	
	private String bugContainerId;

	/**
	 * Initializes a new instance of the BugReportingConfigEntity class.
	 * @param id The id of the configuration entity
	 */
	public BugReportingConfigEntity(String id) {
		super(id);
	}

	public void setBugContainerId(String bugContainerId) {
		this.bugContainerId = bugContainerId;
	}

	public String getBugContainerId() {
		return bugContainerId;
	}
	
}
