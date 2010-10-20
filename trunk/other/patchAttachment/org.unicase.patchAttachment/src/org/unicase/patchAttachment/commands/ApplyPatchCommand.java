package org.unicase.patchAttachment.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.patchAttachment.applyPatch.BasicApplyPatchMethod;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.filetransfer.FileRequestHandler;
import org.unicase.workspace.filetransfer.FileTransferUtil;
import org.unicase.workspace.util.UnicaseCommand;
import org.eclipse.debug.core.sourcelookup.containers.LocalFileStorage;

public class ApplyPatchCommand extends UnicaseCommand{

	private PatchAttachment fileAttachment;
	
	public ApplyPatchCommand(PatchAttachment attachment) {
		super();
		this.fileAttachment = attachment;
	}

	@Override
	protected void doRun() {
		new DownloadRunnable().run();
//		try {d
//			FileRequestHandler f = WorkspaceManager.getProjectSpace(attachment).getFile(attachment.getFileID());
////			while(!f.isDownloadFinished()){
////				try {
////					Thread.sleep(10);
////				} catch (InterruptedException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				System.out.println("Not finished");
////				
////				
////			}
//			try {
//				BufferedReader b = new BufferedReader(new FileReader(f.getLocation()));
//				String line;
//				while((line=b.readLine())!=null){
//					System.out.println(line);
//				}
//				b.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			System.out.println("Finished");
//		} catch (FileTransferException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	/*
	 * THE FOLLOWING CODE IS HEAVILY COPY PASTED FROM MEFileChooserControl
	 * AND IS ONLY TO BE USED UNTIL THE FILE API IS REWRITTEN!
	 */
	
	public void widgetSelected(SelectionEvent e) {
		Display.getCurrent().asyncExec(new DownloadRunnable());
	}
	

	private void openInformation(String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, message);
	}
	
	/**
	 * @param fileAttachment file attachment
	 * @return file information containing the information related to the specified file attachment
	 * @throws FileTransferException if there is no file attached to the file attachment
	 */
	private FileInformation createFileInformationFromFileAttachment(FileAttachment fileAttachment)
		throws FileTransferException {
		// check if the file attachment attributes are set, otherwise return error dialog
		if (fileAttachment.getFileName() == null || fileAttachment.getFileID() == null) {
			throw new FileTransferException("There is no file attached to this file attachment!");
		}
		// set information needed for transfer
		FileInformation fileInfo = new FileInformation();
		fileInfo.setFileAttachmentId(fileAttachment.getIdentifier());
		fileInfo.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
		fileInfo.setFileName(fileAttachment.getFileName());
		return fileInfo;
	}
	
	private final class DownloadRunnable implements Runnable {

		public void run() {
		
			//Generate file info from File Attachment
			FileInformation fileInfo;
			try {
				fileInfo = createFileInformationFromFileAttachment(fileAttachment);
			} catch (FileTransferException e2) {
				openInformation("Please observe:", e2.getMessage());
				return;
			}
			
			
			try {
				
				//File transfer already running
				if (WorkspaceManager.getProjectSpace(fileAttachment).hasFileTransfer(fileInfo, false)) {
					openInformation("Please observe:", "File download has not yet been fulfilled!");
				} else {
					
				
					// try to localize the cached file
					if (!FileTransferUtil.findCachedFile(fileInfo,
						WorkspaceManager.getProjectSpace(fileAttachment).getProjectId()).exists()) {
						throw new FileNotFoundException("File could not be localized!");
					}
					// open file
					File f = getFile(fileInfo, WorkspaceManager.getProjectSpace(fileAttachment).getProjectId());
					
					applyFile(f);
				}
			} catch (FileNotFoundException e) {
				try {
					// if file could not be found, initiate transfer
					WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInfo, null, false, true);
					openInformation("Please observe:",
						"The file will be downloaded as soon as you login, or now if you are already logged in.");
				} catch (FileTransferException e1) {
					openInformation("Please observe:", e1.getMessage());
				}
			}
		}

		private void applyFile(File f) {
			boolean succeeded = new BasicApplyPatchMethod().applyPatch(new LocalFileStorage(f), null);
			if(succeeded)openInformation("Patch applied","Patch successfully applied");
		}
	}

	private File getFile(FileInformation fileInfo, ProjectId projectId) throws FileNotFoundException {
			return FileTransferUtil.findCachedFile(FileTransferUtil.constructFileNameBasedOnAttachmentIdAndVersion(fileInfo),
				new File(FileTransferUtil.constructCacheFolder(projectId)));
		}




}
