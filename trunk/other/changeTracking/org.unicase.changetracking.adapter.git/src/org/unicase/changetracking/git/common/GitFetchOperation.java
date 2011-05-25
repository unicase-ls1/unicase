/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.jgit.api.FetchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.git.GitRepository;


/**
 * Operation for conducting a fetch conveniently.
 * 
 * @author jfinis
 *
 */
public class GitFetchOperation {

	private GitRepository repoLoc;
	private CredentialsProvider credentialsProvider;
	private List<RefSpec> refSpecs;
	private Repository localRepo;
	private int timeout;
	private EclipseGitProgressTransformer progressMonitor;
	
	/**
	 * Constructor using a collection of refs.
	 * 
	 * @param repoLoc the remote repository location
	 * @param localRepo the local repository
	 * @param p a credentials provider for username and password
	 * @param timeout timeout for the connection in milliseconds (0 = no timeout)
	 * @param refSpecs ref specs to be fetched.
	 */
	public GitFetchOperation(GitRepository repoLoc, Repository localRepo, CredentialsProvider p, int timeout, Collection<RefSpec> refSpecs) {
		this.repoLoc = repoLoc;
		this.credentialsProvider = p;
		this.localRepo = localRepo;
		this.refSpecs = new ArrayList<RefSpec>(refSpecs.size());
		this.refSpecs.addAll(refSpecs);
		this.timeout = timeout;
	}
	
	/**
	 * Sets the progress monitor to be used.
	 * @param m progress monitor
	 */
	public void setProgressMonitor(IProgressMonitor m){
		this.progressMonitor = new EclipseGitProgressTransformer(m);
	}
	
	/**
	 * Constructor using an array of refs.
	 * 
	 * @param repoLoc the remote repository location
	 * @param localRepo the local repository
	 * @param p a credentials provider for username and password
	 * @param timeout timeout for the connection in milliseconds (0 = no timeout)
	 * @param refSpecs ref specs to be fetched.
	 */
	public GitFetchOperation(GitRepository repoLoc, Repository localRepo, CredentialsProvider p, int timeout, RefSpec... refSpecs) {
		this(repoLoc, localRepo, p, timeout, Arrays.asList(refSpecs));
	}
	
	/**
	 * Executes the fetch and returns its result.
	 * @return fetch result
	 */
	public FetchResult run() {
		try {
			URIish uri = GitUtil.getURIFromRemote(repoLoc);
			FetchCommand cmd = new Git(localRepo).fetch();
			if(progressMonitor != null){
				cmd.setProgressMonitor(progressMonitor);
			}
			FetchResult result = cmd.setCredentialsProvider(credentialsProvider).setRefSpecs(refSpecs).setRemote(uri.toString()).setTimeout(timeout).call();
			return result;
		} catch (JGitInternalException e) {
			String extractMissingRef = extractMissingRef(e);
			if(extractMissingRef != null){
				throw new UnexpectedGitException(extractMissingRef);
			}
			throw buildException(e);
		} catch (InvalidRemoteException e) {
			throw buildException(e);
		} catch (URISyntaxException e) {
			throw buildException(e);
		}
		
	}

	private UnexpectedGitException buildException(Exception e) {
		return new UnexpectedGitException("Unable to fetch the requested contents from the remote repository\n(See error log for details)",e);
	}

	private String extractMissingRef(JGitInternalException e) {
		Throwable c = e.getCause();
		if(c != null){
			String msg = c.getMessage();
			if(msg.contains("available for fetch")){
				return msg;
			}
		}
		return null;
	}
}
