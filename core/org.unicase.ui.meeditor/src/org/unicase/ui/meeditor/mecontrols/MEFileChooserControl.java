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

		// Grid layout with three columns
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		// Left column: file name
		final Link fileName = new Link(composite, SWT.RIGHT);
		fileName.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, true, false));
		fileName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.CENTER).grab(true, true).applyTo(fileName);

		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new LinkContentConverter());
		dbc.bindValue(SWTObservables.observeText(fileName), model, null, strategy);

		fileName.addSelectionListener(new TransferSelectionListener());

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
					try {
						WorkspaceManager.getProjectSpace((FileAttachment) getModelElement()).addFileTransfer(
							fileInformation,
							new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()), true);
					} catch (FileTransferException e1) {
						DialogHandler.showErrorDialog(e1.getMessage());
					}
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
	 * @author pfeifferc
	 */
	private final class LinkContentConverter implements IConverter {
		public Object getToType() {
			return String.class;
		}

		public Object getFromType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			return "<a>" + fromObject.toString() + "</a>";
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
					DialogHandler.showErrorDialog("There is no file attached to this file attachment!");
					return;
				}
				fileInformation.setFileAttachmentId(fileAttachment.getIdentifier());
				fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
				fileInformation.setFileName(fileAttachment.getFileName());
				File cachedFile;
				try {
					cachedFile = FileTransferUtil.findCachedFile(fileInformation, WorkspaceManager.getProjectSpace(
						fileAttachment).getProjectId());
					long supposedSize = fileAttachment.getFileSize();
					int actualSize = new FileInputStream(cachedFile).available();
					if (supposedSize != actualSize) {
						MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Please wait!",
							"File download has not yet been completed!");
					} else {
						MEFileChooserControl.this.openFile(fileInformation, WorkspaceManager.getProjectSpace(
							fileAttachment).getProjectId());
					}
				} catch (FileNotFoundException e1) {
					try {
						WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(fileInformation, null, false);
					} catch (FileTransferException e) {
						DialogHandler.showErrorDialog(e.getMessage());
					}
				} catch (IOException e) {
					DialogHandler.showErrorDialog("There was an error accessing the location of the downloaded file!");
				}
			}
		}
	}
}
