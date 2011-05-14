package org.unicase.changetracking.adapter.subclipse;

import org.eclipse.core.resources.IProject;
import org.eclipse.team.core.RepositoryProvider;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterProvider;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.patch.PatchChangePackage;

public class SubclipseVCSAdapterProvider implements VCSAdapterProvider {

	public static final String SUBCLIPSE_REPO_PROVIDER_ID = "org.tigris.subversion.subclipse.core.svnnature";
	
	public boolean providesForStream(RepositoryStream stream) {
		return false; /* Not implemented for this provider */
	}

	public boolean providesForRevision(RepositoryRevision revision) {
		return false; /* Not implemented for this provider */
	}

	public boolean providesForChangePackage(ChangePackage pkg) {
		return pkg instanceof PatchChangePackage;
	}

	public boolean providesForProject(IProject project) {
		RepositoryProvider provider = RepositoryProvider.getProvider(project);
		if(provider == null){
			return false;
		}
		if(SUBCLIPSE_REPO_PROVIDER_ID.equals(provider.getID())){
			return true;
		}
		return false;
	}

	public VCSAdapter create() {
		return new SubclipseVCSAdapter();
	}

}
