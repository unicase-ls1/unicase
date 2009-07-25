/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.meeditor.Activator;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.FileTransferUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class MEFileChooserControl extends AbstractMEControl {

	private static final String UPLOAD_NOTPENDING_TOOL_TIP = "Click to upload a new file attachment to the server. "
		+ "\nThe file attachment will be transferred when online. "
		+ "\nYou can interrupt the file upload at any time or even "
		+ "\nclose the program, as it will be resumed automatically.";

	private EAttribute attribute;

	private FileAttachment fileAttachment;

	private UploadSelectionListener uploadListener;

	private RemoveTransferSelectionListener removeListener;

	private EMFDataBindingContext dbc;

	/**
	 * Default constructor.
	 * 
	 * @param attribute The filename attribute
	 * @param toolkit The SWT toolkit
	 * @param modelElement The user
	 * @param editingDomain the editing domain
	 */
	public MEFileChooserControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement,
		EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
		fileAttachment = (FileAttachment) getModelElement();
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {

		// COMPOSITE FOR WIDGETS

		Composite composite = getToolkit().createComposite(parent, style);
		// Grid layout with four columns
		GridLayout gridLayout = new GridLayout(4, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		// check if project is shared. if not, display label with error message
		if (WorkspaceManager.getProjectSpace(fileAttachment).getProjectId() == null) {
			Label label = new Label(composite, SWT.RIGHT);
			label.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
			label.setText("Please share your project. Otherwise the FileAttachment functionality can not be enabled.");
			return parent;
		}

		// ADDING WIDGETS AND SETTING LAYOUT DATA

		// Column 1: downloadPending, icon to display status of cached file
		Label downloadPending = new Label(composite, SWT.NONE);
		downloadPending.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		// Column 2: file name
		Link fileName = new Link(composite, SWT.NONE);
		fileName.setLayoutData(new GridData(SWT.NONE, SWT.BEGINNING, true, true));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).hint(300, 15).grab(true, true).applyTo(fileName);

		// Column 3: save as button
		Button saveAs = new Button(composite, SWT.RIGHT);
		saveAs.setText("Save as... ");
		saveAs.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, false, false));
		saveAs.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).grab(false, false).applyTo(saveAs);

		// Column 4: button to open a dialog for uploading files
		Button upload = new Button(composite, SWT.PUSH);
		upload.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		// ADDING LISTENERS AND TOOLTIPS TO THE WIDGETS

		// initialize listeners
		uploadListener = new UploadSelectionListener();
		removeListener = new RemoveTransferSelectionListener();
		DownloadSelectionListener downloadSelectionListener = new DownloadSelectionListener();
		// add listeners
		saveAs.addSelectionListener(new SaveAsSelectionListener());
		saveAs.setToolTipText("As modifying of cached files is not endorsed "
			+ "(the changes simply won't be uploaded until you do so manually), "
			+ "\nyou can choose to save a copy of the downloaded file at another location.");
		fileName.addSelectionListener(downloadSelectionListener);

		// ECLIPSE DATABINDING: BIND WIDGETS TO ATTRIBUTES

		// data binding context
		dbc = new EMFDataBindingContext();
		// file name binding
		IObservableValue model1 = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		UpdateValueStrategy strategy1 = new UpdateValueStrategy();
		strategy1.setConverter(new FileNameLinkContentConverter());
		dbc.bindValue(SWTObservables.observeText(fileName), model1, null, strategy1);
		// upload binding
		// TODO: eclipse 3.4 compatibility
		@SuppressWarnings("unused")
		IObservableValue model2 = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(),
			AttachmentFactory.eINSTANCE.getAttachmentPackage().getFileAttachment_Uploading());
		UpdateValueStrategy strategy2 = new UpdateValueStrategy();
		strategy2.setConverter(new UploadImageConverter(upload));
		// dbc.bindValue(SWTObservables.observeImage(upload), model2, null, strategy2);
		// download binding
		// TODO: eclipse 3.4 compatibility
		@SuppressWarnings("unused")
		IObservableValue model3 = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(),
			AttachmentFactory.eINSTANCE.getAttachmentPackage().getFileAttachment_Downloading());
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new DownloadImageConverter(downloadPending, saveAs));
		// dbc.bindValue(SWTObservables.observeImage(downloadPending), model3, null, strategy);

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	public void openFile(FileInformation fileInfo, ProjectId projectId) {
		try {
			FileTransferUtil.openFile(fileInfo, projectId);
		} catch (FileTransferException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	private final class DownloadImageConverter implements IConverter {

		private Label downloadPending;
		private Button saveAs;

		public DownloadImageConverter(Label downloadPending, Button saveAs) {
			this.downloadPending = downloadPending;
			this.saveAs = saveAs;
		}

		public Object getToType() {
			return Image.class;
		}

		public Object getFromType() {
			return Boolean.class;
		}

		public Object convert(Object fromObject) {
			if (fileAttachment.getFileID() == null) {
				return setToolTipAndSaveAsStatus("There is no file attached to this file attachment.", false);
			}
			File cachedFile;
			try {
				cachedFile = FileTransferUtil.findCachedFile(fileAttachment, WorkspaceManager.getProjectSpace(
					fileAttachment).getProjectId());
				FileInputStream fileInputStream = new FileInputStream(cachedFile);
				int size = fileInputStream.available();
				fileInputStream.close();
				if (size == fileAttachment.getFileSize()) {
					return setToolTipAndSaveAsStatus(
						"The download has succeeded. \nYou can open or save the file at another location at any time.",
						true);
				} else {
					if (fileAttachment.isDownloading()) {
						return setToolTipAndSaveAsStatus(
							"A download request is pending. \nPlease wait for it to be finished.", false);
					} else {
						return setToolTipAndSaveAsStatus(
							"Please login and click the file name \nto initiate the download of the file.", false);
					}
				}
			} catch (FileNotFoundException e) {
				if (fileAttachment.isDownloading()) {
					return setToolTipAndSaveAsStatus(
						"A download request is pending. \nPlease wait for it to be finished.", false);
				} else {
					return setToolTipAndSaveAsStatus(
						"Please login and click the file name \nto initiate the download of the file.", false);
				}
			} catch (IOException e) {
				return setToolTipAndSaveAsStatus("Could not locate the file in the cache.", false);
			}
		}

		private Object setToolTipAndSaveAsStatus(String toolTipText, boolean enabled) {
			saveAs.setEnabled(enabled);
			downloadPending.setToolTipText(toolTipText);
			if (enabled) {
				return Activator.getImageDescriptor("icons/drive_go.png").createImage();
			} else {
				return Activator.getImageDescriptor("icons/drive_error.png").createImage();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	private final class UploadImageConverter implements IConverter {
		private final Button upload;

		private UploadImageConverter(Button upload) {
			this.upload = upload;
		}

		public Object getToType() {
			return Image.class;
		}

		public Object getFromType() {
			return Boolean.class;
		}

		public Object convert(Object fromObject) {
			boolean uploading = (Boolean) fromObject;
			if (!uploading) {
				upload.removeSelectionListener(removeListener);
				upload.addSelectionListener(uploadListener);
				upload.setToolTipText(UPLOAD_NOTPENDING_TOOL_TIP);
				return Activator.getImageDescriptor("icons/page_add.png").createImage();
			} else {
				upload.removeSelectionListener(uploadListener);
				upload.addSelectionListener(removeListener);
				upload
					.setToolTipText("If you wish to cancel the pending upload and upload another file, \nplease click this button.");
				return Activator.getImageDescriptor("icons/delete.png").createImage();
			}
		}
	}

	/**
	 * Converts the content of the file name attribute value to a hyperlink.
	 * 
	 * @author pfeifferc
	 */
	private final class FileNameLinkContentConverter implements IConverter {

		public Object getToType() {
			return String.class;
		}

		public Object getFromType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return "There is no file attached.";
			}
			return "<a>" + fromObject.toString() + "</a>";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	private final class RemoveTransferSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			WorkspaceManager.getProjectSpace(fileAttachment).removePendingFileUpload(fileAttachment.getIdentifier());
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					fileAttachment.setUploading(false);
				}
			}.run();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class SaveAsSelectionListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			try {
				FileTransferUtil.findCachedFile(fileAttachment, WorkspaceManager.getProjectSpace(fileAttachment)
					.getProjectId());
			} catch (FileNotFoundException e2) {
				if ((fileAttachment).getFileName() == null) {
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Please observe:",
						"There is no file attached to this FileAttachment!");
				} else {
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Please observe:",
						"The cached file could not be found! It may not have been downloaded yet.");
				}
				return;
			}
			FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			fileDialog.setOverwrite(true);
			fileDialog.open();
			fileDialog.setText("Save as...");
			String value = fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();
			if (!fileDialog.getFileName().equals("")) {
				copyFile(value);
			}
		}

		private void copyFile(final String destPath) {
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(Display.getCurrent()
				.getActiveShell());
			try {
				progressMonitorDialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						File destination = new File(destPath);
						if (destination.isDirectory()) {
							destination = new File(destination.getAbsolutePath() + File.separator
								+ (fileAttachment).getFileName());
						}
						try {
							FileTransferUtil.copyFileFromCacheToNewLocation(FileTransferUtil.findCachedFile(
								fileAttachment, WorkspaceManager.getProjectSpace(fileAttachment).getProjectId()),
								destination, monitor);
						} catch (FileNotFoundException e) {
							openInformation("File could not be found:", e.getMessage());
						} catch (IOException e) {
							openInformation("File could not be accessed:", e.getMessage());
						}
					}
				});
				progressMonitorDialog.open();
				progressMonitorDialog.close();

			} catch (InvocationTargetException e1) {
				openInformation("An error occurred", e1.getMessage());
			} catch (InterruptedException e1) {
				openInformation("An error occurred", e1.getMessage());
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}

	/**
	 * Transfer selection listener.
	 * 
	 * @author pfeifferc
	 */
	private final class DownloadSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			Display.getCurrent().asyncExec(new DownloadRunnable());
		}

		/**
		 * @author pfeifferc
		 */
		private final class DownloadRunnable implements Runnable {

			public void run() {
				FileInformation fileInfo;
				try {
					fileInfo = getFileInformationForFileAttachment();
				} catch (FileTransferException e2) {
					openInformation("Please observe:", e2.getMessage());
					return;
				}
				try {
					// try to localize the cached file
					File cachedFile = FileTransferUtil.findCachedFile(fileInfo, WorkspaceManager.getProjectSpace(
						fileAttachment).getProjectId());
					FileInputStream fileInputStream = new FileInputStream(cachedFile);
					int size = fileInputStream.available();
					fileInputStream.close();
					if (fileAttachment.getFileSize() != size) {
						openInformation("Please observe: ", "File transfer has not been completed yet!");
					} else {
						// open file
						openFile(fileInfo, WorkspaceManager.getProjectSpace(fileAttachment).getProjectId());
					}
				} catch (FileNotFoundException e) {
					try {
						// if file could not be found, initiate transfer
						WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInfo, null, false);
						new UnicaseCommand() {
							@Override
							protected void doRun() {
								fileAttachment.setDownloading(true);
							}
						}.run();
					} catch (FileTransferException e1) {
						openInformation("Please observe:", e1.getMessage());
					}
				} catch (IOException e) {
					openInformation("Please observe:", e.getMessage());
				}
			}

		}
	}

	/**
	 * Transfer selection listener.
	 * 
	 * @author pfeifferc
	 */
	private final class UploadSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}

		public void widgetSelected(SelectionEvent e) {
			// open a file dialog
			final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell());
			fileDialog.open();
			// check if user actually selected a dialog
			if (!fileDialog.getFileName().equals("")) {
				// set information needed for this particular upload
				final FileInformation fileInformation = new FileInformation();
				fileInformation.setChunkNumber(0);
				fileInformation.setFileVersion(-1);
				fileInformation.setFileName(fileDialog.getFileName());
				fileInformation.setFileAttachmentId((fileAttachment).getIdentifier());
				try {
					// adds a pending file upload request
					WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInformation,
						new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()), true);
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							fileAttachment.setUploading(true);
						}
					}.run();
				} catch (FileTransferException e1) {
					openInformation("File Transfer Exception:", e1.getMessage());
				}
			}
		}
	}

	private void openInformation(String title, String message) {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, message);
	}

	/**
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#dispose()
	 */
	@Override
	public void dispose() {
		dbc.dispose();
		super.dispose();
	}

	private FileInformation getFileInformationForFileAttachment() throws FileTransferException {
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
}
