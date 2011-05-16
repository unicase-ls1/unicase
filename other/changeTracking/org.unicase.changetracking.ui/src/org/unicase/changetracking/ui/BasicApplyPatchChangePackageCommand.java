/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ApplyPatchOperation;
import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.filetransfer.FileDownloadStatus;

public class BasicApplyPatchChangePackageCommand extends ChangeTrackingCommand{


	private PatchChangePackage fileAttachment;
	private boolean resumed;

	/**
	 * Default constructor creating a command from a patch attachment.
	 * @param attachment the attachment
	 */
	public BasicApplyPatchChangePackageCommand(PatchChangePackage attachment) {
		super();
		this.fileAttachment = attachment;
	}
	
	private void resume() {
		synchronized (this) {
			resumed = true;
			this.notify();
		}
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {

		FileIdentifier fileId = fileAttachment.getFileIdentifier();

		if (fileId == null) {
			throw new UnexpectedChangeTrackingException("No patch saved here.");
		}


		ProjectSpace projectSpace = WorkspaceManager
		.getProjectSpace(fileAttachment);
		
		// Get the file

		FileDownloadStatus status;
		try {
			status = projectSpace.getFile(fileAttachment.getFileIdentifier());
		} catch (FileTransferException e1) {
			throw new UnexpectedChangeTrackingException(e1);
		}

		// Add observers that resume the operation once the download is finished
		Observer resumeObserver = new Observer() {
			public void update(Observable o, Object arg) {
				resume();
			}
		};
		status.addTransferFinishedObserver(resumeObserver);
		status.addTransferFailedObserver(resumeObserver);
		
		//sleep until resumed
		synchronized(this){
			if(!resumed){
				try {
					this.wait();
				} catch (InterruptedException e) {
					throw new UnexpectedChangeTrackingException(e);
				}
			}
		}
		
		//check if an exception occurred
		switch(status.getStatus()){
		case CANCELLED: return cancelResult();
		case FAILED: throw new UnexpectedChangeTrackingException(status.getException());
		case FINISHED: break;
		default:
			throw new UnexpectedChangeTrackingException("Invalid file download status");
		}
		
		//file donwload finished successfully, apply the patch now
		boolean success;
		try {
			success = ApplyPatchOperation.applyPatch(status.getTransferredFile(), null);
		} catch (FileTransferException e) {
			throw new UnexpectedChangeTrackingException(e);
		}
		
		if(success){
			return successResult("Change package successfully applied.");
		}
		return cancelResult();
		 
		
			
	}
	

}
