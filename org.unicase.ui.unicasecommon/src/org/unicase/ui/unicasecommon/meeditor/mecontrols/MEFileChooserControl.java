/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import java.io.File;
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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.filetransfer.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class MEFileChooserControl extends AbstractMEControl {

	private static final String UPLOAD_NOTPENDING_TOOL_TIP = "Click to upload a new file attachment to the server. "
		+ "\nThe file attachment will be transferred when online. "
		+ "\nYou can interrupt the file upload at any time and even "
		+ "\nclose the program, as it will be resumed automatically.";

	private static final String CANCEL_UPLOAD_TOOLTIP = "If you wish to cancel the pending upload and upload another file, \nplease click this button.";

	private static final int PRIORITY = 2;

	private FileAttachment fileAttachment;

	private UploadSelectionListener uploadListener;

	private RemoveTransferSelectionListener removeListener;

	private EMFDataBindingContext dbc;

	private Button upload;

	private Link fileName;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
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

		// Column 1: file name
		fileName = new Link(composite, SWT.NONE);
		fileName.setLayoutData(new GridData(SWT.NONE, SWT.BEGINNING, true, true));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).hint(300, 15).grab(true, true).applyTo(fileName);

		// Column 2: save as button
		Link saveAs = new Link(composite, SWT.RIGHT);
		saveAs.setText("<a>Save as...</a>");
		saveAs.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, false, false));
		saveAs.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).grab(false, false).applyTo(saveAs);

		// Column 3: button to open a dialog for uploading files

		upload = new Button(composite, SWT.PUSH);
		upload.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		// Column x: invisible label to fix databinding direction problem

		Label fix = new Label(composite, SWT.NONE);
		fix.setVisible(false);
		GridDataFactory.fillDefaults().hint(0, 0).grab(false, false).applyTo(fix);

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
		IObservableValue model1 = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(),
			AttachmentFactory.eINSTANCE.getAttachmentPackage().getFileAttachment_FileID());
		UpdateValueStrategy strategy1 = new UpdateValueStrategy();
		strategy1.setConverter(new FileIDContentConverter());
		dbc.bindValue(SWTObservables.observeText(fix), model1, null, strategy1);

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

	private void setUploadButtonAccordingToTransferStatus(boolean uploading) {
		if (!uploading) {
			upload.removeSelectionListener(removeListener);
			upload.addSelectionListener(uploadListener);
			upload.setToolTipText(UPLOAD_NOTPENDING_TOOL_TIP);
			upload.setImage(Activator.getImageDescriptor("icons/page_add.png").createImage());
		} else {
			upload.removeSelectionListener(uploadListener);
			upload.addSelectionListener(removeListener);
			upload.setToolTipText(CANCEL_UPLOAD_TOOLTIP);
			upload.setImage(Activator.getImageDescriptor("icons/delete.png").createImage());
		}
	}

	/**
	 * Responds to changes of the file version to trigger correct UI behaviour.
	 * 
	 * @author pfeifferc
	 */
	private final class FileIDContentConverter implements IConverter {

		public Object convert(Object fromObject) {
			try {
				if (WorkspaceManager.getProjectSpace(fileAttachment).hasFileTransfer(
					createFileInformationFromFileAttachment(fileAttachment), true)) {
					setUploadButtonAccordingToTransferStatus(true);
				} else {
					setUploadButtonAccordingToTransferStatus(false);
				}
			} catch (FileTransferException e) {
				setUploadButtonAccordingToTransferStatus(false);
			}
			if (fileAttachment.getFileName() == null) {
				fileName.setText("No file attached.");
			} else {
				fileName.setText("<a>" + fileAttachment.getFileName() + "</a>");
			}
			return fromObject;
		}

		public Object getFromType() {
			return String.class;
		}

		public Object getToType() {
			return String.class;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	private final class RemoveTransferSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			WorkspaceManager.getProjectSpace(fileAttachment).removePendingFileUpload(fileAttachment.getIdentifier());
			setUploadButtonAccordingToTransferStatus(false);
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class SaveAsSelectionListener implements SelectionListener {

		private static final String FILE_CHOOSER_PATH = "org.unicase.ui.unicasecommon.fileChooserPath";

		public void widgetSelected(SelectionEvent e) {
			try {
				findCachedFile(fileAttachment, WorkspaceManager.getProjectSpace(fileAttachment).getProjectId());
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
			String initialPath = PreferenceHelper.getPreference(FILE_CHOOSER_PATH, System.getProperty("user.home"));
			fileDialog.setFilterPath(initialPath);
			fileDialog.setOverwrite(true);
			String fileDestinationPath = fileDialog.open();
			fileDialog.setText("Save as...");
			if (fileDestinationPath != null && !fileDestinationPath.equals("")) {
				PreferenceHelper.setPreference(FILE_CHOOSER_PATH, fileDialog.getFilterPath());
				copyFile(fileDestinationPath);
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
							FileTransferUtil.copyFileFromCacheToNewLocation(findCachedFile(fileAttachment,
								WorkspaceManager.getProjectSpace(fileAttachment).getProjectId()), destination, monitor);
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
			// nothing to do
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
					fileInfo = createFileInformationFromFileAttachment(fileAttachment);
				} catch (FileTransferException e2) {
					openInformation("Please observe:", e2.getMessage());
					return;
				}
				try {
					if (WorkspaceManager.getProjectSpace(fileAttachment).hasFileTransfer(fileInfo, false)) {
						openInformation("Please observe:", "File download has not yet been fulfilled!");
					} else {
						// try to localize the cached file
						if (!FileTransferUtil.findCachedFile(fileInfo,
							WorkspaceManager.getProjectSpace(fileAttachment).getProjectId()).exists()) {
							throw new FileNotFoundException("File could not be localized!");
						}
						// open file
						openFile(fileInfo, WorkspaceManager.getProjectSpace(fileAttachment).getProjectId());
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
			// check if user actually selected a file
			if (!fileDialog.getFileName().equals("")) {
				// set information needed for this particular upload
				final FileInformation fileInformation = new FileInformation();
				// fileInformation.setChunkNumber(0);
				fileInformation.setFileVersion(-1);
				fileInformation.setFileName(fileDialog.getFileName());
				fileInformation.setFileAttachmentId((fileAttachment).getIdentifier());
				try {
					// adds a pending file upload request
					WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInformation,
						new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()), true, true);
					setUploadButtonAccordingToTransferStatus(true);
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
		if (uploadListener != null && removeListener != null && !upload.isDisposed()) {
			upload.removeSelectionListener(uploadListener);
			upload.removeSelectionListener(removeListener);
			upload.dispose();
		}
		if (dbc != null) {
			dbc.dispose();
		}
		super.dispose();
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

	/**
	 * @param fileAttachment the file Attachment
	 * @param projectId project id
	 * @return the cached file
	 * @throws FileNotFoundException if the file could not be found
	 */
	private File findCachedFile(FileAttachment fileAttachment, ProjectId projectId) throws FileNotFoundException {
		FileInformation fileInformation = new FileInformation();
		fileInformation.setFileAttachmentId(fileAttachment.getIdentifier());
		if (fileAttachment.getFileID() == null || fileAttachment.getFileID().equals("")) {
			throw new FileNotFoundException("File does not exist!");
		}
		fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
		fileInformation.setFileName(fileAttachment.getFileName());
		return FileTransferUtil.findCachedFile(FileTransferUtil
			.constructFileNameBasedOnAttachmentIdAndVersion(fileInformation), new File(FileTransferUtil
			.constructCacheFolder(projectId)));
	}

}
