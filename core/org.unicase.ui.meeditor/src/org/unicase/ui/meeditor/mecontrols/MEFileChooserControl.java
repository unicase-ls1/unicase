/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
import org.eclipse.swt.widgets.Text;
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

		// Grid layout with three columns
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		// Left column: file name
		final Text fileName = new Text(composite, SWT.RIGHT);
		fileName.setEditable(false);
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(fileName);
		// Display.getDefault().syncExec(new Runnable() {

		// public void run() {
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(fileName, SWT.FocusOut), model, null, null);

		// }
		// });

		// Middle column: open/download file
		Button open = new Button(composite, SWT.PUSH);
		open.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		open.setImage(Activator.getImageDescriptor("icons/page_go.png").createImage());
		open.addSelectionListener(new TransferSelectionListener());

		// Right column: button to open a dialog for uploading files
		Button upload = new Button(composite, SWT.PUSH);
		upload.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				final FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell());
				fileDialog.open();
				if (!fileDialog.getFileName().equals("")) {
					final FileInformation fileInformation = new FileInformation();
					fileInformation.setChunkNumber(0);
					fileInformation.setFileVersion(-1);
					fileInformation.setFileName(fileDialog.getFileName());
					fileInformation.setFileAttachmentId(((FileAttachment) getModelElement()).getIdentifier());
					WorkspaceManager.getProjectSpace((FileAttachment) getModelElement()).addFileTransfer(
						fileInformation,
						new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()), true);
				}
			}
		});
		upload.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
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
	 * Transfer selection listener.
	 * 
	 * @author pfeifferc
	 */
	private final class TransferSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			Display.getCurrent().asyncExec(new TransferRunnable());
		}

		/**
		 * @author pfeifferc
		 */
		private final class TransferRunnable implements Runnable {
			public void run() {
				FileInformation fileInformation = new FileInformation();
				FileAttachment fileAttachment = (FileAttachment) getModelElement();
				if (fileAttachment.getFileName() == null || fileAttachment.getFileID() == null) {
					return;
				}
				fileInformation.setFileAttachmentId(fileAttachment.getIdentifier());
				fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
				File cachedFile = FileTransferUtil.findCachedFile(fileInformation, WorkspaceManager.getProjectSpace(
					fileAttachment).getProjectId());
				try {
					if (cachedFile != null) {
						if (cachedFile.exists()) {
							long supposedSize = fileAttachment.getFileSize();
							int actualSize = new FileInputStream(cachedFile).available();
							if (supposedSize != actualSize) {
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Please wait!",
									"File download has not yet been completed!");
							} else {
								MEFileChooserControl.this.openFile(fileInformation, WorkspaceManager.getProjectSpace(
									fileAttachment).getProjectId());
							}
						}
					} else {
						WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInformation, null, false);
					}
				} catch (IOException e) {
					DialogHandler.showErrorDialog("There was an error accessing the location of the downloaded file!");
				}
			}
		}
	}
}
