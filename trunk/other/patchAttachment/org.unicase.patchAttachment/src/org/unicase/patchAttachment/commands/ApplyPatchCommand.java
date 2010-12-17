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
import org.eclipse.swt.events.SelectionEvent;
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

public class ApplyPatchCommand extends UnicaseCommand {

	private PatchAttachment fileAttachment;

	public ApplyPatchCommand(PatchAttachment attachment) {
		super();
		this.fileAttachment = attachment;
	}

	private void applyFile(File f) {
		boolean succeeded = new BasicApplyPatchMethod().applyPatch(
				new LocalFileStorage(f), null);
		if (succeeded)
			openInformation("Patch applied", "Patch successfully applied");
	}

	@Override
	protected void doRun() {
		new DownloadRunnable().run();
	}

	public void widgetSelected(SelectionEvent e) {
		Display.getCurrent().asyncExec(new DownloadRunnable());
	}

	private void openInformation(String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				title, message);
	}

	private final class DownloadRunnable implements Runnable {

		public void run() {

			FileIdentifier fileId = fileAttachment.getFileIdentifier();

			if (fileId == null) {
				openInformation("Error", "No patch saved here.");
				return;
			}

			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(fileAttachment);

			// Do the download, this is done in a progress monitor
			try {
				new ProgressMonitorDialog(Display.getDefault().getActiveShell())
						.run(false, true, new IRunnableWithProgress() {

							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								try {

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
						});
			} catch (Exception e1) {
				ModelUtil.logException(e1);
			}

		}
	}

}
