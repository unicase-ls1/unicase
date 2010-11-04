package org.unicase.patchAttachment.commands;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.model.patchAttachment.PatchAttachmentFactory;
import org.unicase.model.patchAttachment.PatchAttachmentPackage;
import org.unicase.patchAttachment.adapter.TeamAdapterFactory;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;
import org.unicase.patchAttachment.exported.PatchAttachmentException;
import org.unicase.ui.common.util.ActionHelper;
//import org.unicase.ui.unicasecommon.UnicaseActionHelper;
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
			if(sources==null||sources.length==0) throw new PatchAttachmentException("No sources provided for attach patch command");

			//Create the patch
			File patch = null;
			try {
				patch = teamAdapter.createPatch(sources);
			} catch (Throwable e) {
				throw new PatchAttachmentException(e);
			}
			if(patch==null) throw new PatchAttachmentException("Patch was not be created by team adapter (returned null)");
			
		//2) **** Create the model element for the patch, add it to the project and link it ****
			PatchAttachment f = (PatchAttachment) PatchAttachmentFactory.eINSTANCE.create(PatchAttachmentPackage.Literals.PATCH_ATTACHMENT);
			Project p = ModelUtil.getProject(attachTo);
			
			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(p);

			//<<< Begin composite operation
			//!!! DOES NOT WORK DUE TO NULL POINTER EXCEPTION INSIDE BEGIN COMPOSITE OPERATION !!!
			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			//Add the model element and link it
			p.addModelElement(f);
			attachTo.getAttachments().add(f);
			

			
			
		//3) **** Upload the patch ****
			
				// set information needed for this particular upload
				final FileInformation fileInformation = new FileInformation();
				fileInformation.setFileVersion(-1);
				fileInformation.setFileName("patch.txt");
				fileInformation.setFileAttachmentId(p.getModelElementId(f).getId());
				try {
					// adds a pending file upload request
					WorkspaceManager.getProjectSpace(f).addFileTransfer(fileInformation,
						patch, true, true);
				} catch (FileTransferException e1) {
					throw new PatchAttachmentException("File Transfer Exception:" + e1.getMessage(), e1);
				}
			
			//<<< End composite operation
			try {
				operationHandle.end("Attached patch",
						"Attached a patch to " + attachTo.getName() + ".", p.getModelElementId(attachTo));
			} catch (InvalidHandleException e) {
				throw new PatchAttachmentException("Composite Operation failed!", e);
			}
			
		//4) **** Open the model element ****
			try{

				//UnicaseActionHelper.openModelElement(attachTo, this.getClass().getName());
			} catch (Throwable t){}
			
		} catch (Exception e) {
			handleException(e);
		} catch (Throwable t){
			handleException(new Exception("An error was thrown:\n" + t.getMessage(),t));
		}
		

	}


	private void handleException(Exception e) {
		WorkspaceUtil.logException("Error while attaching a patch to unicase.", e);
	}
}
