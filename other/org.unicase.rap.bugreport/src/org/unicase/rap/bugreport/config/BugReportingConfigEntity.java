/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.bugreport.config;

import org.unicase.workspace.ProjectSpace;

import config.impl.ConfigEntityImpl;

/**
 * Config entity for bug reporting application.
 * 
 * @author Edgar Mueller
 */
public class BugReportingConfigEntity extends ConfigEntityImpl {
	
	private static final long serialVersionUID = -5461631585176746027L;
	
	private ProjectSpace projectSpace;
	
	/** The keys. */
	public class Keys {
		/** Key for bug container name. */
		public static final String BUG_CONTAINER = "BUG_CONTAINER";
		
	}
	
	/**
	 * The constructor.
	 * 
	 * @param projectSpace .
	 */
	public BugReportingConfigEntity(ProjectSpace projectSpace) {
		super();
		this.projectSpace = projectSpace;
	}
	
	/**
	 * 
	 * @param bugContainerName bug container name
	 */
	public void setBugContainerName(String bugContainerName) {
		getProperties().put(Keys.BUG_CONTAINER, bugContainerName);
	}

	/**
	 * 
	 * @return document name of bug container
	 */
	public String getBugContainerName() {
		Object w = getProperties().get(Keys.BUG_CONTAINER);
		
		if (w == null) {
			return null;
		}
		
		return (String) w;
	}
	
	/**
	 * Gets configuration file name.
	 * 
	 * @return configuration file name
	 */
	public String getConfigFilename() {
		if (projectSpace == null) {
			return BugReportingConfigEntity.class.getCanonicalName();
		} else {
			return projectSpace.getProjectName() + "." + BugReportingConfigEntity.class.getCanonicalName();
		}
	}
	
}

