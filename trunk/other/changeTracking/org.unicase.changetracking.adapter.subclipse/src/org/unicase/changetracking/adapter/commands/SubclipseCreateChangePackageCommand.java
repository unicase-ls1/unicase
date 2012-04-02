/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.adapter.commands;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.model.changetracking.patch.PatchFactory;
import org.unicase.model.task.WorkItem;

/**
 * Subclipse implementation of the create change package command.
 * 
 * @author jfinis
 * 
 */
public class SubclipseCreateChangePackageCommand extends ChangeTrackingCommand {

	private IProject[] localProjects;
	private WorkItem workItem;
	private String name;
	private String shortDescription;
	private String longDescription;

	/**
	 * Default constructor.
	 * 
	 * @param localProjects
	 *            local project
	 * @param workItem
	 *            work item
	 * @param name
	 *            name for the change package
	 * @param shortDescription
	 *            short description
	 * @param longDescription
	 *            long description
	 */
	public SubclipseCreateChangePackageCommand(IProject[] localProjects,
			WorkItem workItem, String name, String shortDescription,
			String longDescription) {
		this.localProjects = localProjects;
		this.workItem = workItem;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	/**
	 * Performs the creation.
	 * 
	 * @return execution result.
	 */
	@Override
	protected ChangeTrackingCommandResult doRun() {
		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				// 1) **** Create the patch ****
				File patch;
				try {
					patch = new SubclipseCreatePatchAction().createPatch(
							localProjects, true);
					if (patch == null) {
						throw new UnexpectedChangeTrackingException(
								"No patch was created.");
					}
				} catch (VCSException e) {
					throw new UnexpectedChangeTrackingException(e.getMessage(),
							e.getCause());
				}

				// 2) **** Upload the patch ****
				PatchChangePackage changePackage = PatchFactory.eINSTANCE
						.createPatchChangePackage();
				changePackage.setName(name);
				changePackage.setShortDescription(shortDescription);
				changePackage.setDescription(longDescription);

				org.eclipse.emf.emfstore.common.model.Project p = org.eclipse.emf.emfstore.common.model.util.ModelUtil
						.getProject(workItem);
				if (p == null) {
					throw new MisuseException(
							"The supplied work item does not belong to a project");
				}

				final org.eclipse.emf.emfstore.client.model.ProjectSpace projectSpace = org.eclipse.emf.emfstore.client.model.WorkspaceManager
						.getProjectSpace(p);

				org.eclipse.emf.emfstore.server.model.FileIdentifier fid;
				try {
					fid = projectSpace.addFile(patch);
				} catch (org.eclipse.emf.emfstore.server.exceptions.FileTransferException e1) {
					throw new UnexpectedChangeTrackingException(
							"File Transfer Exception:" + e1.getMessage(), e1);
				}
				changePackage.setFileName("patch.txt");
				changePackage.setFileSize(patch.length());
				changePackage.setFileIdentifier(fid);

				// 3) **** Add the change package to the project and attach to
				// work item
				// ****
				ChangeTrackingUtil.addToProjectRelative(changePackage,
						workItem, false);
				workItem.getAttachments().add(changePackage);
				// TODO Auto-generated method stub

			}
		}.run(true);

		return successResult("Change package created successfully");

	}

}
