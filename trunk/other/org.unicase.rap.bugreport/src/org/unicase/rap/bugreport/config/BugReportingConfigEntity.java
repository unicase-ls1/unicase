package org.unicase.rap.bugreport.config;

import config.impl.ConfigEntityImpl;

public class BugReportingConfigEntity extends ConfigEntityImpl {
	
	public class Keys {
		public final static String BUG_CONTAINER = "BUG_CONTAINER";
	}
	

	private static final long serialVersionUID = -5461631585176746027L;
	
	public void setBugContainerId(String bugContainerId) {
		getProperties().put(Keys.BUG_CONTAINER, bugContainerId);
	}

	public String getBugContainer() {
		Object w = getProperties().get(Keys.BUG_CONTAINER);
		
		if (w == null) {
			return null;
		}
		
		return (String) w;
	}
}
