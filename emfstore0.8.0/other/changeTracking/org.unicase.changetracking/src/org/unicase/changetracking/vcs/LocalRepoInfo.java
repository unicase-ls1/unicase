package org.unicase.changetracking.vcs;

/**
 * This abstract class represents the information about the local copy of a part of a repository,
 * corresponding to a certain remote repository. 
 * 
 * For git for example, this represents the local repository.
 * 
 * This class is intended to be subclassed by the different VCS Adapters since it contains no useful
 * information by default. The information that is needed for the local copy of a VCS depends on the VCS
 * itself and thus no meaningful default implementation can be provided.
 * 
 * @author jfinis
 *
 */
public abstract class LocalRepoInfo {
	
	private VCSAdapter vcs;

	public LocalRepoInfo(VCSAdapter vcs){
		this.vcs = vcs;
	}
	
	public VCSAdapter getVCS() {
		return vcs;
	}

}
