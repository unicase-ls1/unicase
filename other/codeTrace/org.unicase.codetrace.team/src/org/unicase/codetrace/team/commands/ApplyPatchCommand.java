package org.unicase.codetrace.team.commands;

import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.filetransfer.FileDownloadStatus;
import org.unicase.workspace.util.UnicaseCommand;

public class ApplyPatchCommand extends UnicaseCommand{

	private FileAttachment attachment;
	
	public ApplyPatchCommand(FileAttachment attachment) {
		super();
		this.attachment = attachment;
	}

	
	protected void doRun() {
		try {
			FileDownloadStatus f = WorkspaceManager.getProjectSpace(attachment).getFile(attachment.getFileIdentifier());
			while(f.isTransferFinished()){
				System.out.println("NOT FINISHED");
			}
			System.out.println("FINISHED");
		} catch (FileTransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
