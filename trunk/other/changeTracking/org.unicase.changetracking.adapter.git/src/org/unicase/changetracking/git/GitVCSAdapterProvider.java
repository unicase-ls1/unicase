package org.unicase.changetracking.git;

import org.eclipse.core.resources.IProject;
import org.eclipse.egit.core.GitTag;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterProvider;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;

public class GitVCSAdapterProvider implements VCSAdapterProvider {

	@Override
	public boolean providesForStream(RepositoryStream stream) {
		return stream instanceof GitBranch;
	}

	@Override
	public boolean providesForRevision(RepositoryRevision revision) {
		return revision instanceof GitTag;
	}

	@Override
	public boolean providesForChangePackage(ChangePackage pkg) {
		return pkg instanceof GitBranchChangePackage;
	}

	@Override
	public boolean providesForProject(IProject project) {
		return null != GitRepoFindUtil.findRepository(project.getFullPath().toFile());
	}

	@Override
	public VCSAdapter create() {
		return new GitVCSAdapter();
	}

}
