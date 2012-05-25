package org.unicase.changetracking.test.cases;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.junit.Test;
import org.unicase.changetracking.test.GitTestCase;

public class SelectivePullTest extends GitTestCase{

	@Test
	public void test() throws JGitInternalException, RefAlreadyExistsException, RefNotFoundException, InvalidRefNameException, IOException, URISyntaxException, NoHeadException, NoMessageException, ConcurrentRefUpdateException, WrongRepositoryStateException, InvalidRemoteException{
		// create repository
		//Repository repo = createLocalRepo(false);
		Repository repo = getLocalRepo();
		Git git1 = new Git(repo);
	//	RevCommit commit = git1.commit().setMessage("initial commit ").call();
		
		System.out.println("Pulling one branch");
		String branchName = "uu";
		String refname = "refs/heads/" + branchName;
		RefSpec refSpec = new RefSpec(refname + ":" + refname);
		branchName = "23";
		 refname = "refs/heads/" + branchName;
		RefSpec refSpec2 = new RefSpec(refname + ":" + refname);
		
		FetchResult res = git1.fetch().setRefSpecs(refSpec2,refSpec).setRemote(getRemoteURI().toString()).call();
		System.out.println(res.toString());
		//SelectivePullOperation op = new SelectivePullOperation(repo, getRemoteURI(), 0, refSpec);
		//op.execute(getProgressMonitor());
		//SelectivePullResult res = op.getResult();
		
		System.out.println(res);
	}
}
