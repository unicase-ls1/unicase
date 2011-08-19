/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.PreferenceHelper;
import org.eclipse.emf.ecp.editor.ModelElementChangeListener;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileDownloadStatus;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileInformation;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileTransferUtil;
import org.eclipse.emf.emfstore.client.model.observers.CommitObserver;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.util.FileUtil;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.unicasecommon.Activator;

/**
 * This class handles file attachments. If the file attachment has no file attached yet, this control allows to attach a
 * file If a file is already attached, the control allows to save that file. The file can also be replaced. If the file
 * is not yet commited, it can be removed.
 * 
 * @author pfeifferc, jfinis
 */
public class MEFileChooserControl extends AbstractUnicaseMEControl {

	private static final String UPLOAD_NOTPENDING_TOOL_TIP = "Click to upload a new file attachment to the server. "
		+ "\nThe file attachment will be transferred upon commiting.\n\nIf you have already a file attached, this file will be replaced.";

	private static final String CANCEL_UPLOAD_TOOLTIP = "If you wish to cancel the pending upload and upload another file, \nplease click this button.";

	private static final int PRIORITY = 2;

	private static final Image ICON_ADD_FILE = Activator.getImageDescriptor("icons/page_add.png").createImage();
	private static final Image ICON_DELETE_FILE = Activator.getImageDescriptor("icons/delete.png").createImage();
	private static final Image ICON_SAVE_FILE = Activator.getImageDescriptor("icons/disk.png").createImage();
	private static final Image ICON_OPEN_FILE = Activator.getImageDescriptor("icons/lrun.gif").createImage();

	private FileAttachment fileAttachment;

	private AddFileOrCancelListener uploadListener;

	private EMFDataBindingContext dbc;

	private Button upload;

	private Link fileName;

	private boolean canCancelUpload;

	private Button saveAs;

	/**
	 * This observer listens for commits, so it can update the button status. This is necessary because a formerly
	 * pending upload is no longer pending after a commit, because it was submitted during the commit.
	 */
	private CommitObserver commitObserver = new CommitObserver() {

		public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
			return true;
		}

		public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
			// Upon commit, update the status of the button, since the file upload
			// may no longer be pending
			updateStatus(getProjectSpace().getFileInfo(fileAttachment.getFileIdentifier()).isPendingUpload());
		}

	};

	private Button open;

	private ModelElementChangeListener modelElementChangeListener;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		if (!(modelElement instanceof FileAttachment)) {
			return DO_NOT_RENDER;
		}
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && !((EAttribute) feature).getName().equals("fileName")) {
			return DO_NOT_RENDER;
		}
		return PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {

		this.fileAttachment = (FileAttachment) getModelElement();

		// COMPOSITE FOR WIDGETS

		Composite composite = getToolkit().createComposite(parent, style);
		// Grid layout with four columns
		GridLayoutFactory.swtDefaults().equalWidth(false).numColumns(5).spacing(0, 0).applyTo(composite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		// ADDING WIDGETS AND SETTING LAYOUT DATA

		// Column 1: file name
		fileName = new Link(composite, SWT.NONE);
		fileName.setLayoutData(new GridData(SWT.NONE, SWT.BEGINNING, true, true));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).hint(300, 15).grab(true, true).applyTo(fileName);

		open = new Button(composite, SWT.RIGHT);
		open.setImage(ICON_OPEN_FILE);
		open.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, false, false));
		open.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		// Column 2: save as button
		saveAs = new Button(composite, SWT.RIGHT);
		saveAs.setImage(ICON_SAVE_FILE);
		saveAs.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, false, false));
		saveAs.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		// GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).grab(false, false).applyTo(saveAs);

		// Column 3: button to open a dialog for uploading files

		upload = new Button(composite, SWT.PUSH);
		upload.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		// Column x: invisible label to fix databinding direction problem

		Label fix = new Label(composite, SWT.NONE);
		fix.setVisible(false);
		GridDataFactory.fillDefaults().hint(0, 0).grab(false, false).applyTo(fix);

		// ADDING LISTENERS AND TOOLTIPS TO THE WIDGETS

		// initialize listeners
		uploadListener = new AddFileOrCancelListener();
		upload.addSelectionListener(uploadListener);

		open.addSelectionListener(new SaveAsSelectionListener(false, true));
		open.setToolTipText("Opens the file.\nWorks only if your OS has registered a handler for the file's extension");

		saveAs.addSelectionListener(new SaveAsSelectionListener(true, false));
		saveAs.setToolTipText("Saves the file to a user specified location");

		// Set status of the upload button according to the file upload being pending
		// (if the upload of the attachment is still pending, it can be removed)
		updateStatus(getProjectSpace().getFileInfo(fileAttachment.getFileIdentifier()).isPendingUpload());

		// Add the commit observer which handles pending files being commited
		getProjectSpace().addCommitObserver(commitObserver);

		modelElementChangeListener = new ModelElementChangeListener(fileAttachment) {

			public void onRuntimeExceptionInListener(RuntimeException exception) {
			}

			@Override
			public void onChange(Notification notification) {
				updateStatusAsync();
			}
		};

		fileAttachment
			.addModelElementChangeListener((org.eclipse.emf.emfstore.common.model.util.ModelElementChangeListener) modelElementChangeListener);
		return parent;
	}

	/**
	 * Updates the status of the upload button and the file name.
	 * 
	 * @param uploadPending if the upload of the file is pending and thus can be canceled
	 */
	private void updateStatus(boolean uploadPending) {
		if (fileAttachment.getFileName() == null) {
			fileName.setText("No file attached.");
			saveAs.setVisible(false);
			open.setVisible(false);
		} else {
			String suffix = "";
			if (uploadPending) {
				suffix = " (not commited)";
			} else if (getProjectSpace().getFileInfo(fileAttachment.getFileIdentifier()).isCached()) {
				suffix = " (cached)";
			}
			fileName.setText(/* "<a>" + */fileAttachment.getFileName() + suffix /* + "</a>" */);
			saveAs.setVisible(true);
			open.setVisible(true);
		}
		saveAs.getParent().layout();

		canCancelUpload = uploadPending;
		if (!uploadPending) {
			upload.setToolTipText(UPLOAD_NOTPENDING_TOOL_TIP);
			upload.setImage(ICON_ADD_FILE);
		} else {
			upload.setToolTipText(CANCEL_UPLOAD_TOOLTIP);
			upload.setImage(ICON_DELETE_FILE);
		}
	}

	private void updateStatusAsync() {
		open.getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateStatus(getProjectSpace().getFileInfo(fileAttachment.getFileIdentifier()).isPendingUpload());
			}
		});
	}

	/**
	 * Retrieves the project space of the file attachment.
	 * 
	 * @return
	 */
	private ProjectSpace getProjectSpace() {
		return WorkspaceManager.getProjectSpace(fileAttachment);
	}

	/**
	 * Opens an information dialog.
	 * 
	 * @param title the title
	 * @param message the message
	 */
	private void openInformation(final String title, final String message) {
		upload.getDisplay().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(upload.getShell(), title, message);
			}
		});
	}

	/**
	 * Opens an error dialog.
	 * 
	 * @param title the title
	 * @param message the message
	 */
	private void openError(final String title, final String message) {
		upload.getDisplay().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(upload.getShell(), title, message);
			}
		});
	}

	/**
	 * @author jfinis
	 */
	private final class SaveAsSelectionListener extends SelectionAdapter {

		private static final String FILE_CHOOSER_PATH = "org.unicase.ui.unicasecommon.fileChooserPath";
		private boolean allowTargetSelection;
		private boolean openOnFinish;

		public SaveAsSelectionListener(boolean allowTargetSelection, boolean openOnFinish) {
			this.allowTargetSelection = allowTargetSelection;
			this.openOnFinish = openOnFinish;
		}

		/**
		 * This method is called when the user presses the "Save as..." text. {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {

			final File destinationFile = (allowTargetSelection) ? selectTargetFile() : getTempfile();

			try {
				// Get the file
				final FileDownloadStatus status = getProjectSpace().getFile(fileAttachment.getFileIdentifier());

				// Add observer that copies the file once the download is finished
				status.addTransferFinishedObserver(new Observer() {
					public void update(Observable o, Object arg) {
						try {
							FileUtil.copyFile(status.getTransferredFile(), destinationFile);
							if (openOnFinish) {
								openFile(destinationFile);
							} else {
								openInformation("File saved successfully", "The file was saved successfully");
							}
						} catch (IOException e1) {
							registerSaveAsException(e1);
						} catch (FileTransferException e) {
							registerSaveAsException(e);
						}
						updateStatusAsync();
					}
				});

				// Add observer that registers the exception if the download fails
				status.addDefaultFailObserver();
			} catch (FileTransferException e1) {
				registerSaveAsException(e1);
				return;
			}

		}

		/**
		 * {@inheritDoc}
		 */
		public void openFile(File file) {
			try {
				FileTransferUtil.openFile(file);
			} catch (FileTransferException e) {
				DialogHandler.showErrorDialog(e.getMessage());
			}
		}

		private File getTempfile() {
			return FileTransferUtil.getOpenFileLocation(getProjectSpace(), fileAttachment.getFileName());
		}

		private File selectTargetFile() {
			// Show file dialog to save the file to
			FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			String initialPath = PreferenceHelper.getPreference(FILE_CHOOSER_PATH, System.getProperty("user.home"));
			String initialName = fileAttachment.getFileName();
			fileDialog.setFileName(initialName);
			fileDialog.setFilterPath(initialPath);
			fileDialog.setOverwrite(true);
			fileDialog.setText("Save as...");
			final String fileDestinationPath = fileDialog.open();

			// If no file was selected, abort
			if (fileDestinationPath == null || fileDestinationPath.equals("")) {
				return null;
			}

			// Set the chosen path as a preference for the next saves
			PreferenceHelper.setPreference(FILE_CHOOSER_PATH, fileDialog.getFilterPath());
			return new File(fileDestinationPath);
		}

		/**
		 * Exception handling in the save as usecase.
		 * 
		 * @param e1 the exception to handle
		 */
		private void registerSaveAsException(Exception e1) {
			String fail = "Save as... failed!";
			WorkspaceUtil.logException(fail, e1);
		}
	}

	/**
	 * This listener handles when the user presses the Add File/Cancel Upload button.
	 * 
	 * @author jfinis
	 */
	private final class AddFileOrCancelListener extends SelectionAdapter {

		/**
		 * This method is called when the "Add File" or "Cancel upload" button is pressed. (This is one button that
		 * switches its icon and semantics)
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			// do we want to cancel or to add a new file?
			if (canCancelUpload) {
				doCancelUpload();
			} else {
				doAddUpload();
			}
		}

		/**
		 * Adds a file to upload by presenting a file chooser dialog and then adding the file to the upload queue.
		 */
		private void doAddUpload() {
			// open a file dialog
			final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell());
			fileDialog.open();
			// check if user actually selected a file
			if (fileDialog.getFileName().equals("")) {
				return;
			}

			// Check that the selected file actually exists (this should always be the case)
			final File uploadFile = new File(fileDialog.getFilterPath(), fileDialog.getFileName());
			if (!uploadFile.exists()) {
				openError("Error", "File to upload does not exist");
				return;
			}

			// Add the file to the pending uploads and set the data in the attachment
			// Since this modifies the project space, it has to be done in a unicase command
			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					try {
						// Add file
						FileIdentifier ident = getProjectSpace().addFile(uploadFile);
						// Check that if there was already a file attached
						// If so, remove it if it was still pending
						ProjectSpace space = getProjectSpace();
						FileIdentifier oldId = fileAttachment.getFileIdentifier();
						FileInformation oldInfo = space.getFileInfo(oldId);
						if (oldInfo.isPendingUpload()) {
							oldInfo.cancelPendingUpload();
						}
						fileAttachment.setFileName(fileDialog.getFileName());
						fileAttachment.setFileIdentifier(ident);
						fileAttachment.setFileSize(uploadFile.length());
						// Update button status (cancel allowed)
						updateStatus(true);
					} catch (FileTransferException e) {
						ModelUtil.logException("Couldn't upload file", e);
						return;
					}
				}
			}.run(false);

		}

		/**
		 * Cancels the current upload if it is pending.
		 */
		private void doCancelUpload() {
			// Some error catching for robustness
			final FileIdentifier id = fileAttachment.getFileIdentifier();
			final FileInformation fileInfo = getProjectSpace().getFileInfo(id);
			if (id == null) {
				openError("Error!", "Could not cancel the upload because no file identifier was set.");
				return;
			}
			if (!fileInfo.isPendingUpload()) {
				openError("Error!", "Could not cancel the upload because it is not pending.");
				return;
			}

			// Remove the pending upload and clear the file attachment
			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					fileInfo.cancelPendingUpload();
					fileAttachment.setFileName(null);
					fileAttachment.setFileIdentifier(null);
					fileAttachment.setFileSize(0);
				}
			}.run(false);

			// Update button status (no more cancel allowed)
			updateStatus(false);
		}
	}

	/**
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#dispose()
	 */
	@Override
	public void dispose() {
		getProjectSpace().removeCommitObserver(commitObserver);
		if (uploadListener != null && !upload.isDisposed()) {
			upload.removeSelectionListener(uploadListener);
			upload.dispose();
		}
		if (modelElementChangeListener != null) {
			fileAttachment
				.removeModelElementChangeListener((org.eclipse.emf.emfstore.common.model.util.ModelElementChangeListener) modelElementChangeListener);
		}
		if (dbc != null) {
			dbc.dispose();
		}
		super.dispose();
	}

}
