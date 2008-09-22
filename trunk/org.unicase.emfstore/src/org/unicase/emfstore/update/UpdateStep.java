package org.unicase.emfstore.update;

import org.osgi.framework.Version;
import org.unicase.emfstore.esmodel.ProjectHistory;

public interface UpdateStep {

	public String getTitle();
	public Version getSourceVersion();
	public Version getTargetVersion();
	
	public int updateProjectHistory(ProjectHistory projectHistory);
}
