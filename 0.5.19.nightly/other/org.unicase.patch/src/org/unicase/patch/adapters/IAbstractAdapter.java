package org.unicase.patch.adapters;

import org.eclipse.core.resources.IProject;

public interface IAbstractAdapter {

	void createPatch(IProject project);
	
	boolean isResponsible(String repositoryId);
	
}
