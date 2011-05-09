package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;


public interface VCSAdapterProvider {
	
	boolean providesForStream(RepositoryStream stream);
	
	boolean providesForRevision(RepositoryRevision revision);
	
	boolean providesForChangePackage(ChangePackage pkg);
	
	boolean providesForProject(IProject project);
	
	VCSAdapter create();
	
}
