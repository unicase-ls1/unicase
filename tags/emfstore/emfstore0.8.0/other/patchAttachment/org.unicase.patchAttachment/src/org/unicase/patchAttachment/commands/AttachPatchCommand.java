/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.commands;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.model.patchAttachment.PatchAttachmentFactory;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;
import org.unicase.patchAttachment.exported.PatchAttachmentException;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This class attaches a given patch to a model element in a unicase project.
 * The attached file is created a sub-type of file attachment and the file is uploaded.
 * Afterwards, the model element is opened.
 * @author jfinis
 *
 */
public class AttachPatchCommand extends UnicaseCommand{

	private UnicaseModelElement attachTo;
	private IResource[] sources;
	private AbstractTeamAdapter teamAdapter;
	
	
	/**
	 * Default constructor.
	 * @param attachTo model element to attach the patch to
	 * @param sources list of sources to add to the patch
	 * @param teamAdapter team adapter to create the patch
	 */
	public AttachPatchCommand(UnicaseModelElement attachTo, IResource[] sources, AbstractTeamAdapter teamAdapter) {
		super();
		this.attachTo = attachTo;
		this.sources = sources;
		this.teamAdapter = teamAdapter;
	}


	@Override
	protected void doRun() {

		try {
		//1) **** Create the patch ****
			
			//No resources? Error
			if(sources==null||sources.length==0){
				throw new PatchAttachmentException("No sources provided for attach patch command");
			}

			//Create the patch
			File patch = null;
			patch = teamAdapter.createPatch(sources);
			
			if(patch==null){
				throw new PatchAttachmentException("Patch was not be created by team adapter (returned null)");
			}
			
		//2) **** Create the model element for the patch, add it to the project and link it ****
			PatchAttachment f = PatchAttachmentFactory.eINSTANCE.createPatchAttachment();
			
			
			Project p = ModelUtil.getProject(attachTo);
			
			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(p);

			//<<< Begin composite operation
			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			//Add the model element and link it
			p.addModelElement(f);
			attachTo.getAttachments().add(f);
			

			
			
		//3) **** Upload the patch ****
			//Set the data for the patch attachment
			f.setFileName("patch.txt");
			f.setFileSize(patch.length());
			FileIdentifier fid;
			try {
				fid = WorkspaceManager.getProjectSpace(f).addFile(patch);
			} catch (FileTransferException e1) {
				throw new PatchAttachmentException("File Transfer Exception:" + e1.getMessage(), e1);
			}
			f.setFileIdentifier(fid);
	
			//<<< End composite operation
			try {
				operationHandle.end("Attached patch",
						"Attached a patch to " + attachTo.getName() + ".", p.getModelElementId(attachTo));
			} catch (InvalidHandleException e) {
				throw new PatchAttachmentException("Composite Operation failed!", e);
			}
			
		//4) **** Open the model element ****
			UnicaseActionHelper.openModelElement(attachTo, this.getClass().getName());
			
			
		} catch (PatchAttachmentException e) {
			handleException(e);
		// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e){
		// END SUPRESS CATCH EXCEPTION
			handleException(e);
		}
		

	}


	private void handleException(Exception e) {
		WorkspaceUtil.logException("Error while attaching a patch to unicase.", e);
	}
}
