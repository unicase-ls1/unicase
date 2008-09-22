package org.unicase.emfstore.update;

import org.osgi.framework.Version;
import org.unicase.emfstore.esmodel.ProjectHistory;

public interface UpdateStep {

	public Version getSourceVersion();
	public Version getTargetVersion();
	
	public void updateProjectHistory(ProjectHistory projectHistory);
	
}
