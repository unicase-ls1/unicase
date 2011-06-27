/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
/*******************************************************************************
 * Copyright (c) 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Mathias Kinzler <mathias.kinzler@sap.com> - initial implementation
 *******************************************************************************/
package org.unicase.changetracking.git.common;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.egit.core.op.IEGitOperation;
import org.eclipse.jgit.api.FetchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidMergeHeadsException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;

/**
 * Wraps the JGit API {@link PullCommand} into an operation.
 * 
 * C&P'ed from EGit
 * 
 * @author jfinis
 */

public class SelectivePullOperation implements IEGitOperation {
	private final Repository repository;

	private SelectivePullResult pullResult;

	private final int timeout;

	private URIish remote;


	private RefSpec refSpecs;

	/**
	 * Default constructor.
	 * 
	 * @param repository local repository to pull into
	 * @param remoteRepo the repository to pull from
	 * @param timeout in seconds
	 * @param refSpec ref spec to specify what to pull
	 */
	public SelectivePullOperation(Repository repository, URIish remoteRepo, int timeout, RefSpec refSpecs) {
		this.timeout = timeout;
		this.remote = remoteRepo;
		this.refSpecs = refSpecs;
		this.repository = repository;
	}

	// BEGIN COMPLEX CODE
	public void execute(IProgressMonitor m) {
		IProgressMonitor monitor;
		if (m == null) {
			monitor = new NullProgressMonitor();
		} else {
			monitor = m;
		}
		IWorkspaceRunnable action = new IWorkspaceRunnable() {
			public void run(IProgressMonitor mymonitor) throws CoreException {
				EclipseGitProgressTransformer gitMonitor = new EclipseGitProgressTransformer(mymonitor);

				mymonitor.beginTask("Pulling from remote repository", 2);

				if (!repository.getRepositoryState().equals(RepositoryState.SAFE))
					throw new UnexpectedGitException("Cannot pull if the repository is not in a safe state!");

				FetchCommand fetch = new Git(repository).fetch();

				fetch.setRemote(remote.toString());
				fetch.setProgressMonitor(gitMonitor);
				fetch.setTimeout(timeout);
				fetch.setRefSpecs(refSpecs);
				FetchResult fetchRes;
				try {
					fetchRes = fetch.call();
				} catch (JGitInternalException e1) {
					throw new UnexpectedGitException(e1);
				} catch (InvalidRemoteException e1) {
					throw new UnexpectedGitException(e1);
				}
				

				gitMonitor.update(1);

				// we check the updates to see which of the updated branches
				// corresponds
				// to the remote branch name

				AnyObjectId commitToMerge;

				Ref r = null;
				if (fetchRes != null) {
					r = fetchRes.getAdvertisedRef(refSpecs.getSource());
					if (r == null)
						r = fetchRes.getAdvertisedRef(Constants.R_HEADS + refSpecs.getSource());
				}
				if (r == null)
					throw new UnexpectedGitException("Remote repository does not have the expected branch");
				else
					commitToMerge = r.getObjectId();

				if (gitMonitor.isCancelled())
					throw new UnexpectedGitException("Operation canceled by user");

				MergeCommand merge = new Git(repository).merge();
				merge.include("branch \'" + refSpecs.getSource() + "\' of " + refSpecs.getDestination(), commitToMerge);
				MergeResult mergeRes;
				try {
					mergeRes = merge.call();
					gitMonitor.update(1);
				} catch (NoHeadException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (ConcurrentRefUpdateException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (CheckoutConflictException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (InvalidMergeHeadsException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (WrongRepositoryStateException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (NoMessageException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				}
				gitMonitor.endTask();
				pullResult = new SelectivePullResult(fetchRes, remote.toString(), mergeRes);
			}
		};
		// lock workspace to protect working tree changes
		try {
			ResourcesPlugin.getWorkspace().run(action, monitor);
		} catch (CoreException e) {
			throw new UnexpectedGitException(e);
		}
	}

	// END COMPLEX CODE

	/**
	 * @return the merge result, or <code>null</code> if this has not been
	 *         executed or if an exception occurred
	 */
	public SelectivePullResult getResult() {
		return this.pullResult;
	}

	/**
	 * {@inheritDoc}
	 */
	public ISchedulingRule getSchedulingRule() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
}
