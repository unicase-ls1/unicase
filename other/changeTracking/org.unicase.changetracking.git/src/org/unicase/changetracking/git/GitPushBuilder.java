package org.unicase.changetracking.git;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.git.GitRepository;

/**
 *
 * @author jfinis
 *
 */
public class GitPushBuilder {
	
	
	private GitRepository remoteRepo;
	private Repository localRepo;
	private CredentialsProvider provider;

	public GitPushBuilder(Repository localRepo, GitRepository remoteRepo, CredentialsProvider provider){
		this.localRepo = localRepo;
		this.remoteRepo = remoteRepo;
		this.provider = provider;
	}
	
	public GitPushOperation build(String... branches){
		ArrayList<RefSpec> refUpdates = new ArrayList<RefSpec>(1);
		for(String branch: branches){
			refUpdates.add(new RefSpec(branch));
		}
		try {
			//FIXME hack inserteed
			RemoteConfig rc = new RemoteConfig(localRepo.getConfig(), "Git-Hub");
			GitPushOperation op = new GitPushOperation(localRepo, GitUtil.getUriFromRemote(remoteRepo), refUpdates, false, rc, 60);
			op.setCredentialsProvider(provider);
			return op;
		} catch (URISyntaxException e) {
			throw new UnexpectedGitException(e);
		}
	}
	
}