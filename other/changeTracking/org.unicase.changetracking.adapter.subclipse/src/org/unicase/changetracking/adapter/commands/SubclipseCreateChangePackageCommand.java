/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.adapter.commands;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.model.changetracking.patch.PatchFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

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
	 * @param localProjects local project
	 * @param workItem work item
	 * @param name name for the change package
	 * @param shortDescription short description
	 * @param longDescription long description
	 */
	public SubclipseCreateChangePackageCommand(IProject[] localProjects, WorkItem workItem, String name, String shortDescription, String longDescription) {
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

		// 1) **** Create the patch ****
		File patch;
		try {
			patch = new SubclipseCreatePatchAction().createPatch(localProjects, true);
			if (patch == null) {
				throw new UnexpectedChangeTrackingException("No patch was created.");
			}
		} catch (VCSException e) {
			throw new UnexpectedChangeTrackingException(e.getMessage(), e.getCause());
		}

		// 2) **** Upload the patch ****
		PatchChangePackage changePackage = PatchFactory.eINSTANCE.createPatchChangePackage();
		changePackage.setName(name);
		changePackage.setShortDescription(shortDescription);
		changePackage.setDescription(longDescription);

		Project p = ModelUtil.getProject(workItem);
		if (p == null) {
			throw new MisuseException("The supplied work item does not belong to a project");
		}

		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(p);

		FileIdentifier fid;
		try {
			fid = projectSpace.addFile(patch);
		} catch (FileTransferException e1) {
			throw new UnexpectedChangeTrackingException("File Transfer Exception:" + e1.getMessage(), e1);
		}
		changePackage.setFileName("patch.txt");
		changePackage.setFileSize(patch.length());
		changePackage.setFileIdentifier(fid);

		// 3) **** Add the change package to the project and attach to work item
		// ****
		ChangeTrackingUtil.addToProjectRelative(changePackage, workItem, false);
		workItem.getAttachments().add(changePackage);

		return successResult("Change package created successfully");

	}

}