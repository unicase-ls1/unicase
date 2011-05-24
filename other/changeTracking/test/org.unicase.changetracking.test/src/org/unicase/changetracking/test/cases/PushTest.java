package org.unicase.changetracking.test.cases;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;
import org.eclipse.jgit.transport.URIish;
import org.junit.Test;
import org.unicase.changetracking.git.common.GitPushOperation;
import org.unicase.changetracking.test.GitTestCase;

public class PushTest extends GitTestCase{

	@Test
	public void test() throws JGitInternalException, RefAlreadyExistsException, RefNotFoundException, InvalidRefNameException, IOException, URISyntaxException, NoHeadException, NoMessageException, ConcurrentRefUpdateException, WrongRepositoryStateException, NoFilepatternException{
		// create other repository
		Repository repo = createLocalRepo(false);

		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
	
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
			});
		
		String branchName = "test-" + System.currentTimeMillis() + "";
		
		String refname = "refs/heads/" + branchName;

		// setup the first repository
		

		Git git1 = new Git(repo);
		// create some refs via commits and tag
		git1.commit().setMessage("initial commit on test branch " + branchName).call();
		git1.checkout().setCreateBranch(true).setName(branchName).call();
		Collection<RefSpec> refUpdates = new ArrayList<RefSpec>();
		refUpdates.add(new RefSpec(refname));
		//RevTag tag = git1.tag().setName("tag").call();
		PushResult result = new GitPushOperation(repo, getRemoteURI(), refUpdates , false, 0, getCredentialsProvider()).run(getProgressMonitor());
		System.out.println("Pushing branch " +  branchName);
		
		RemoteRefUpdate res = result.getRemoteUpdate(refname);
		assertTrue(res.getStatus() == Status.OK);
		System.out.println(res.toString());
		
		//Another commit on the branch

		writeTestFile("Foobar.txt", "a file with content...");
		git1.add().addFilepattern("Foobar.txt").call();
		git1.commit().setMessage("second commit on test branch " + branchName).call();
		
		
		result = new GitPushOperation(repo, getRemoteURI(), refUpdates , false, 0, getCredentialsProvider()).run(getProgressMonitor());
		System.out.println("Pushing branch " +  branchName);
		
		res = result.getRemoteUpdate(refname);
		assertTrue(res.getStatus() == Status.OK);
		System.out.println(res.toString());
		System.out.println("PUSH COMPLETED");
		
;
	}
}
