/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egit.core.CoreText;
import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;
import org.eclipse.jgit.transport.Transport;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;

/**
 * Push operation: pushing from local repository to one or many remote ones.
 */
public class GitPushOperation {
	private static final int WORK_UNITS_PER_TRANSPORT = 10;

	private final Repository localDb;

	private final URIish remoteRepo;
	
	private Collection<RemoteRefUpdate> refUpdates = null;

	private final boolean dryRun;

	private final RemoteConfig rc;

	private final int timeout;

	private CredentialsProvider credentialsProvider;

	private PushResult pushResult;

	public PushResult getPushResult() {
		return pushResult;
	}
	
	public RemoteRefUpdate getSingleResult(){
		Collection<RemoteRefUpdate> updates = pushResult.getRemoteUpdates();
		if(updates.isEmpty())
			return null;
		return updates.iterator().next();
	}


	/**
	 * Create push operation for provided specification.
	 * <p>
	 * Operation is not performed within constructor,
	 * {@link #run(IProgressMonitor)} method must be called for that.
	 *
	 * @param localDb
	 *            local repository.
	 * @param specification
	 *            specification of ref updates for remote repositories.
	 * @param rc
	 *            optional remote config to apply on used transports. May be
	 *            null.
	 * @param dryRun
	 *            true if push operation should just check for possible result
	 *            and not really update remote refs, false otherwise - when push
	 *            should act normally.
	 * @param timeout the timeout in seconds (0 for no timeout)
	 */
	public GitPushOperation(Repository localDb, URIish remoteRepo, Collection<RefSpec> refUpdates,
			final boolean dryRun, final RemoteConfig rc, int timeout) {
		this.localDb = localDb;
		try {
			this.refUpdates = Transport.findRemoteRefUpdatesFor(localDb, refUpdates, null);
		} catch (IOException e) {
		}
		this.remoteRepo = remoteRepo;
		this.dryRun = dryRun;
		this.rc = rc;
		this.timeout = timeout;
	}


	/**
	 * Sets a credentials provider
	 * @param credentialsProvider
	 */
	public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
		this.credentialsProvider = credentialsProvider;
	}

	/**
	 * @return push operation result.
	 */
	public void getOperationResult() {
//		if (operationResult == null)
//			throw new IllegalStateException(CoreText.OperationNotYetExecuted);
//		return operationResult;
	}


	/**
	 * Execute operation and store result. Operation is executed independently
	 * on each remote repository.
	 * <p>
	 *
	 * @param actMonitor
	 *            the monitor to be used for reporting progress and responding
	 *            to cancellation. The monitor is never <code>null</code>
	 * @return 
	 *
	 * @throws InvocationTargetException
	 *             Cause of this exceptions may include
	 *             {@link TransportException}, {@link NotSupportedException} or
	 *             some unexpected {@link RuntimeException}.
	 */
	public PushResult run(IProgressMonitor actMonitor) {

		//if (operationResult != null)
		//	throw new IllegalStateException(CoreText.OperationAlreadyExecuted);

			for (RemoteRefUpdate update : refUpdates)
				if (update.getStatus() != Status.NOT_ATTEMPTED)
					throw new IllegalStateException(
							CoreText.RemoteRefUpdateCantBeReused);
		
		IProgressMonitor monitor;
		if (actMonitor == null)
			monitor = new NullProgressMonitor();
		else
			monitor = actMonitor;

		final int totalWork = WORK_UNITS_PER_TRANSPORT;
		if (dryRun)
			monitor.beginTask(CoreText.PushOperation_taskNameDryRun, totalWork);
		else
			monitor.beginTask(CoreText.PushOperation_taskNameNormalRun,
					totalWork);

		//operationResult = new PushOperationResult();
		PushResult pr = null;
		URIish uri = remoteRepo;
			Transport transport = null;
			try {
				if (monitor.isCanceled()) {
					//operationResult.addOperationResult(uri,
					//		CoreText.PushOperation_resultCancelled);
					monitor.done();
					return pr;
				}
				transport = Transport.open(localDb, uri);
				if (credentialsProvider != null)
					transport.setCredentialsProvider(credentialsProvider);
				transport.setTimeout(this.timeout);

				if (rc != null)
					transport.applyConfig(rc);
				transport.setDryRun(dryRun);
				final EclipseGitProgressTransformer gitSubMonitor = new EclipseGitProgressTransformer(
						monitor);
				pr = transport.push(gitSubMonitor,refUpdates);
				this.pushResult = pr;
				//operationResult.addOperationResult(uri, pr);
				monitor.worked(WORK_UNITS_PER_TRANSPORT);
			} catch (final NoRemoteRepositoryException e) {
				throw new UnexpectedGitException(e);
			} catch (final TransportException e) {
				throw new UnexpectedGitException(e);
			} catch (final NotSupportedException e) {
				throw new UnexpectedGitException(e);
			} finally {
				if (transport != null) {
					transport.close();
				}

				monitor.done();
			}
			
		return pr;
	}
}
