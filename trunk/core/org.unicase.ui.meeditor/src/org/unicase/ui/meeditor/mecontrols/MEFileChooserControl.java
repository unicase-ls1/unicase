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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
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
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.meeditor.Activator;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class MEFileChooserControl extends AbstractMEControl {

	private EAttribute attribute;

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
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);

		// Grid layout with two columns
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		// Left column: file name
		final Link fileName = new Link(composite, SWT.NONE);
		fileName.setLayoutData(new GridData(SWT.NONE, SWT.BEGINNING, true, true));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).hint(300, 15).grab(true, false).applyTo(fileName);

		// bind the fileName widget to the correspondent file attachment attribute value
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		// update strategy with specific converter added
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		// the converter sees to that the file name is surrouned by hyperlink html tags, so that it is underlined
		strategy.setConverter(new FileNameLinkContentConverter());
		dbc.bindValue(SWTObservables.observeText(fileName), model, null, strategy);
		// add a listener for initiation of file downloads or to open files, respectively
		fileName.addSelectionListener(new DownloadSelectionListener());

		// Right column: button to open a dialog for uploading files
		Button upload = new Button(composite, SWT.PUSH);
		upload.addSelectionListener(new UploadSelectionListener());
		upload.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		upload.setImage(Activator.getImageDescriptor("icons/page_add.png").createImage());

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
				FileAttachment fileAttachment = (FileAttachment) getModelElement();
				// check if the file attachment attributes are set, otherwise return error dialog
				if (fileAttachment.getFileName() == null || fileAttachment.getFileID() == null) {
					DialogHandler.showErrorDialog("There is no file attached to this file attachment!");
					return;
				}
				// set information needed for download
				FileInformation fileInformation = new FileInformation();
				fileInformation.setFileAttachmentId(fileAttachment.getIdentifier());
				fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
				fileInformation.setFileName(fileAttachment.getFileName());
				File cachedFile;
				try {
					// try to localize the cached file
					cachedFile = FileTransferUtil.findCachedFile(fileInformation, WorkspaceManager.getProjectSpace(
						fileAttachment).getProjectId());
					// as the cache file might still be downloaded, it is checked wether download is complete or not
					long supposedSize = fileAttachment.getFileSize();
					int actualSize = new FileInputStream(cachedFile).available();
					if (supposedSize != actualSize) {
						// if incomplete, the user is notified of the file still being downloaded
						MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Please wait!",
							"File download has not yet been completed!");
					} else {
						// if complete, the file is opened
						MEFileChooserControl.this.openFile(fileInformation, WorkspaceManager.getProjectSpace(
							fileAttachment).getProjectId());
					}
				} catch (FileNotFoundException e1) {
					try {
						// if the cached file does not exist, there has not been any download attempt so far. therefore,
						// a new file download request is created.
						WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInformation, null, false);
					} catch (FileTransferException e) {
						// if the file transfer can not be added (if for example the file that is to be uploaded no more
						// exists), an error dialog is shown
						DialogHandler.showErrorDialog(e.getMessage());
					}
				} catch (IOException e) {
					// if there occurred an error trying to access the cached file, an error dialog is shown
					DialogHandler.showErrorDialog("There was an error accessing the location of the downloaded file!");
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
				fileInformation.setFileAttachmentId(((FileAttachment) getModelElement()).getIdentifier());
				try {
					// adds a pending file upload request
					WorkspaceManager.getProjectSpace((FileAttachment) getModelElement()).addFileTransfer(
						fileInformation,
						new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()), true);
				} catch (FileTransferException e1) {
					DialogHandler.showErrorDialog(e1.getMessage());
				}
			}
		}
	}
}
