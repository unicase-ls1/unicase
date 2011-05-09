package org.unicase.codetrace.team.commands;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.unicase.codetrace.team.exported.AbstractTeamAdapter;
import org.unicase.codetrace.team.exported.CodetraceTeamException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.workspace.filetransfer.FileInformation;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.common.util.ActionHelper;
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


	
	protected void doRun() {

		try {
		//1) **** Create the patch ****
			
			//No resources? Error
			if(sources==null||sources.length==0) throw new CodetraceTeamException("No sources provided for attach patch command");

			//Create the patch
			File patch = null;
			try {
				patch = teamAdapter.createPatch(sources);
			} catch (Throwable e) {
				throw new CodetraceTeamException(e);
			}
			if(patch==null) throw new CodetraceTeamException("Patch was not be created by team adapter (returned null)");
			
		//2) **** Create the model element for the patch, add it to the project and link it ****
			FileAttachment f = (FileAttachment) AttachmentFactory.eINSTANCE.create(AttachmentPackage.Literals.FILE_ATTACHMENT);
			

			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(attachTo);
			Project p = projectSpace.getProject();
			//<<< Begin composite operation
			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			//Add the model element and link it
			p.addModelElement(f);
			attachTo.getAttachments().add(f);
			

			
//			
//		//3) **** Upload the patch ****
//			
//				// set information needed for this particular upload
//				final FileInformation fileInformation = new FileInformation();
//				fileInformation.setFileVersion(-1);
//				fileInformation.setFileName("patch.txt");
//				fileInformation.setFileAttachmentId(f.getIdentifier());
//				try {
//					// adds a pending file upload request
//					WorkspaceManager.getProjectSpace(f).addFileTransfer(fileInformation,
//						patch, true, true);
//				} catch (FileTransferException e1) {
//					throw new CodetraceTeamException("File Transfer Exception:" + e1.getMessage(), e1);
//				}
//			
//			//<<< End composite operation
//			try {
//				operationHandle.end("Attached patch",
//						"Attached a patch to " + attachTo.getName() + ".", attachTo.getModelElementId());
//			} catch (InvalidHandleException e) {
//				throw new CodetraceTeamException("Composite Operation failed!", e);
//			}
			
		//4) **** Open the model element ****
			ActionHelper.openModelElement(attachTo, this.getClass().getName());
		
		} catch (CodetraceTeamException e) {
			handleException(e);
		} catch (NullPointerException e){
			handleException(e);
		}
		

	}


	private void handleException(Exception e) {
		WorkspaceUtil.logException("Error while attaching a patch to unicase.", e);
	}
}
