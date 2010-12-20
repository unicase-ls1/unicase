/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.commands;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.sourcelookup.containers.LocalFileStorage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.patchAttachment.applyPatch.BasicApplyPatchMethod;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.filetransfer.FileDownloadStatus;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Command for applying a patch.
 * @author jfinis
 *
 */
public class ApplyPatchCommand extends UnicaseCommand {

	private PatchAttachment fileAttachment;

	/**
	 * Default constructor creating a command from a patch attachment.
	 * @param attachment the attachment
	 */
	public ApplyPatchCommand(PatchAttachment attachment) {
		super();
		this.fileAttachment = attachment;
	}

	private void applyFile(File f) {
		boolean succeeded = new BasicApplyPatchMethod().applyPatch(
				new LocalFileStorage(f), null);
		if (succeeded){
			openInformation("Patch applied", "Patch successfully applied");
		}
	}

	@Override
	protected void doRun() {
		new DownloadRunnable().run();
	}
	
	private void openInformation(String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				title, message);
	}

	/**
	 * Runnable that executes the download and the application of the patch.
	 * @author jfinis
	 *
	 */
	private final class DownloadRunnable implements Runnable {

		public void run() {

			FileIdentifier fileId = fileAttachment.getFileIdentifier();

			if (fileId == null) {
				openInformation("Error", "No patch saved here.");
				return;
			}

		
			// Do the download, this is done in a progress monitor
			try {
				new ProgressMonitorDialog(Display.getDefault().getActiveShell())
						.run(false, true, new DownloadProgressRunner());
			} catch (InvocationTargetException e) {
				ModelUtil.logException(e);
			} catch (InterruptedException e) {
				ModelUtil.logException(e);
			}

		}
	}
	
	/**
	 * Executes the download and the application with a progress monitor.
	 * 
	 * @author jfinis
	 *
	 */
	private class DownloadProgressRunner implements IRunnableWithProgress{

		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			try {

				final ProjectSpace projectSpace = WorkspaceManager
				.getProjectSpace(fileAttachment);
				
				// Get the file
				final FileDownloadStatus status = projectSpace
						.getFile(fileAttachment
								.getFileIdentifier(),
								monitor);

				// Add observer that applies the file once
				// the download is finished
				status
						.addTransferFinishedObserver(new Observer() {
							public void update(
									Observable o, Object arg) {
								try {
									applyFile(status
											.getTransferredFile());
								} catch (FileTransferException e1) {
									ModelUtil
											.logException(e1);
								}
							}
						});

				// Add observer that registers the exception
				// if the download fails
				status.addDefaultFailObserver();
			} catch (FileTransferException e1) {
				ModelUtil.logException(e1);
			}
		}
		
	}

}
