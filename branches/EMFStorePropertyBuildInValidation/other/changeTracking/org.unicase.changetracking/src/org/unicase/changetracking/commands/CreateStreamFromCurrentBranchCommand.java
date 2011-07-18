/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.common.IDecisionProvider.PlacementAndNameDecision;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.ChangetrackingFactory;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;

/**
 * Command to create a stream from the currently checked out branch, or more
 * general repository stream. The version control adapter is responsible for
 * determining this stream.
 * 
 * @author jfinis
 * 
 */
public class CreateStreamFromCurrentBranchCommand extends CreateStreamCommand {

	private IProject workspaceProject;
	private IDecisionProvider decisionProvider;
	private IVCSAdapter vcs;
	private Stream stream;

	/**
	 * Standard constructor.
	 * 
	 * @param vcs adapter to be used.
	 * @param decisionProvider decision provider to be used.
	 * @param workspaceProject the project from which to create the stream.
	 */
	public CreateStreamFromCurrentBranchCommand(IVCSAdapter vcs, IDecisionProvider decisionProvider, IProject workspaceProject) {
		this.workspaceProject = workspaceProject;
		this.decisionProvider = decisionProvider;
		this.vcs = vcs;
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {

		try {

			stream = ChangetrackingFactory.eINSTANCE.createStream();

			PlacementAndNameDecision placementDecision = decisionProvider.decideModelElementPlacementAndName(stream, "");

			Project project = ModelUtil.getProject(placementDecision.getDestination());

			// Find a matching repository location in the project
			RepositoryLocation repoLocation = vcs.findRepoLocation(new IProject[]{workspaceProject}, project);

			// Ask the version control adapter to create a repository stream
			// from the current branch
			RepositoryStream repoStream = vcs.createRepositoryStream(workspaceProject, repoLocation);

			// No repo found? Ask the user what to do...
			if (repoLocation == null) {
				if (decisionProvider.decideCreateRepoLocation()) {
					repoLocation = vcs.createRepositoryLocation(new IProject[]{workspaceProject});
					ChangeTrackingUtil.putInto(repoLocation, placementDecision.getDestination());

				}
			}

			// *** Create and add the stream and the branch.
			// 1. place the stream
			placementDecision.executeDecision();

			// 2. link and place the branch (in the same folder)
			repoStream.setLocation(repoLocation);
			stream.setRepositoryStream(repoStream);
			ChangeTrackingUtil.putInto(repoStream, placementDecision.getDestination());

		} catch (CancelledByUserException e) {
			return cancelResult();
		} catch (VCSException e) {
			return errorResult(e);
		}

		return successResult("Stream successfully created.");
	}

	/**
	 * This command needs no progress monitor as it is very fast.
	 * 
	 * @return NONE
	 */
	@Override
	public ProgressDisplayKind getPreferredProgressDisplayKind() {
		return ProgressDisplayKind.NONE;
	}

	@Override
	public Stream getCreatedStream() {
		return stream;
	}

}
