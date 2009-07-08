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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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

/**
 * @author pfeifferc
 */
public class MEFileChooserControl extends AbstractMEControl {

	private static final String UPLOAD_NOTPENDING_TOOL_TIP = "Click to upload a new file attachment to the server. "
		+ "\nThe file attachment will be transferred when online. "
		+ "\nYou can interrupt the file upload at any time or even "
		+ "\nclose the program, as it will be resumed automatically.";

	private EAttribute attribute;

	private EMFDataBindingContext dbc;

	private FileAttachment fileAttachment;

	private EMFDataBindingContext dbc2;

	private UploadSelectionListener uploadListener;

	private RemoveTransferSelectionListener removeListener;

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
		Composite composite = getToolkit().createComposite(parent, style);

		// Grid layout with two columns
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		if (WorkspaceManager.getProjectSpace(fileAttachment).getProjectId() == null) {
			Label label = new Label(composite, SWT.RIGHT);
			label.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
			label.setText("Please share your project. Otherwise the FileAttachment functionality can not be enabled.");
			return parent;
		}

		// Left column: file name
		Link fileName = new Link(composite, SWT.NONE);
		fileName.setLayoutData(new GridData(SWT.NONE, SWT.BEGINNING, true, true));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).hint(300, 15).grab(true, true).applyTo(fileName);

		// bind the fileName widget to the correspondent file attachment attribute value
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		dbc = new EMFDataBindingContext();
		// update strategy with specific converter added
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		// the converter sees to that the file name is surrouned by hyperlink html tags, so that it is underlined
		strategy.setConverter(new FileNameLinkContentConverter());
		dbc.bindValue(SWTObservables.observeText(fileName), model, null, strategy);
		// add a listener for initiation of file downloads or to open files, respectively
		DownloadSelectionListener downloadSelectionListener = new DownloadSelectionListener();
		fileName.addSelectionListener(downloadSelectionListener);

		// Middle column: file name
		Button saveAs = new Button(composite, SWT.RIGHT);
		saveAs.setText("Save as... ");
		saveAs.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, false, false));
		saveAs.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		saveAs.addSelectionListener(new SaveAsSelectionListener());
		saveAs.setToolTipText("As modifying of cached files is not endorsed "
			+ "(the changes simply won't be uploaded until you do so manually), "
			+ "\nyou can choose to save a copy of the downloaded file at another location.");
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).grab(false, false).applyTo(saveAs);

		// Right column: button to open a dialog for uploading files
		final Button upload = new Button(composite, SWT.PUSH);
		uploadListener = new UploadSelectionListener();
		removeListener = new RemoveTransferSelectionListener();
		upload.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		dbc2 = new EMFDataBindingContext();
		IObservableValue model2 = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(),
			AttachmentFactory.eINSTANCE.getAttachmentPackage().getFileAttachment_Uploading());
		// update strategy with specific converter added
		UpdateValueStrategy strategy2 = new UpdateValueStrategy();
		strategy2.setConverter(new UploadImageConverter(upload));
		dbc2.bindValue(SWTObservables.observeImage(upload), model2, null, strategy2);

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
	 * {@inheritDoc}
	 */
	private final class RemoveTransferSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			WorkspaceManager.getProjectSpace(fileAttachment).removePendingFileUpload(fileAttachment.getIdentifier());
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					fileAttachment.setUploading(false);
				}
			});
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
	 * Converts the content of the file name attribute value to a hyperlink.
	 * 
	 * @author pfeifferc
	 */
	private final class FileNameLinkContentConverter implements IConverter {

		/**
		 * {@inheritDoc}
		 */
		public Object getToType() {
			return String.class;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getFromType() {
			return String.class;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return "";
			}
			return "<a>" + fromObject.toString() + "</a>";
		}
	}

	/**
	 * Transfer selection listener.
	 * 
	 * @author pfeifferc
	 */
	private final class DownloadSelectionListener implements SelectionListener {

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			Display.getCurrent().asyncExec(new DownloadRunnable());
		}

		/**
		 * @author pfeifferc
		 */
		private final class DownloadRunnable implements Runnable {

			/**
			 * {@inheritDoc}
			 */
			public void run() {
				// check if the file attachment attributes are set, otherwise return error dialog
				if (fileAttachment.getFileName() == null || fileAttachment.getFileID() == null) {
					DialogHandler.showErrorDialog("There is no file attached to this file attachment!");
					return;
				}
				// set information needed for transfer
				FileInformation fileInfo = new FileInformation();
				fileInfo.setFileAttachmentId(fileAttachment.getIdentifier());
				fileInfo.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
				fileInfo.setFileName(fileAttachment.getFileName());
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

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
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
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							fileAttachment.setUploading(true);
						}
					});
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
		if (dbc != null) {
			dbc.dispose();
		}
		if (dbc2 != null) {
			dbc2.dispose();
		}
		super.dispose();
	}
}
