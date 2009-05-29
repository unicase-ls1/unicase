/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.io.File;
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
import org.eclipse.jface.viewers.LabelProvider;
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
import org.unicase.model.attachment.FileAttachment;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.meeditor.Activator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.FileTransferObserver;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class MEFileChooserControl extends AbstractMEControl implements FileTransferObserver {

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
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(fileName, SWT.FocusOut), model, null, null);

		// Middle column: open/download file
		Button open = new Button(composite, SWT.PUSH);
		open.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		open.setImage(Activator.getImageDescriptor("icons/page_go.png").createImage());
		open.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				WorkspaceManager.getProjectSpace((FileAttachment) getModelElement()).downloadFileFromServer(
					(FileAttachment) getModelElement(), MEFileChooserControl.this);
				openFile((FileAttachment) getModelElement());
			}

		});

		// Right column: button to open a dialog for uploading files
		Button button = new Button(composite, SWT.PUSH);
		button.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell());
				fileDialog.open();
				if (!fileDialog.getFileName().equals("")) {
					WorkspaceManager.getProjectSpace((FileAttachment) getModelElement()).uploadFileToServer(
						new File(fileDialog.getFilterPath() + File.separator + fileDialog.getFileName()),
						(FileAttachment) getModelElement(), MEFileChooserControl.this);
				}
			}
		});
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		button.setImage(Activator.getImageDescriptor("icons/page_add.png").createImage());

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	public void downloadFinished(final Exception exception, final FileAttachment fileAttachment) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (exception != null) {
					DialogHandler.showErrorDialog(exception.getMessage());
				} else {
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Download succeeded!",
						"Download of the file " + fileAttachment.getFileName() + " has succeeded!");
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void uploadFinished(final Exception exception, final FileAttachment fileAttachment) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (exception != null) {
					DialogHandler.showErrorDialog(exception.getMessage());
				} else {
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Upload succeeded!",
						"Upload of the file " + fileAttachment.getFileName() + " has succeeded!");
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void resumeUploads(FileAttachment fileAttachment) {
	}

	/**
	 * Attempts to open the file linked to by the file attachment according to the operating system.
	 * 
	 * @param fileAttachment
	 */
	private static void openFile(FileAttachment fileAttachment) {
		String os = System.getProperty("os.name");
		try {
			if (os.toLowerCase().contains("windows")) {
				Runtime.getRuntime().exec(
					"rundll32 SHELL32.DLL,ShellExec_RunDLL " + FileTransferUtil.getCachedFileLocation(fileAttachment));
			} else if (os.toLowerCase().contains("mac os")) {
				Runtime.getRuntime().exec("open " + FileTransferUtil.getCachedFileLocation(fileAttachment));
			} else if (os.toLowerCase().contains("linux")) {
				DialogHandler.showErrorDialog("Opening files is not yet supported for " + os + ". Please go to "
					+ FileTransferUtil.getCachedFileLocation(fileAttachment) + " and open the file manually.");
			} else {
				DialogHandler.showErrorDialog("Opening files is not yet supported for " + os + ". Please go to "
					+ FileTransferUtil.getCachedFileLocation(fileAttachment) + " and open the file manually.");
			}
		} catch (IOException e) {
			DialogHandler.showErrorDialog("Could not open the specified file!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void resumeTransfers(final ProjectSpace projectSpace) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				RunningFileTransfersDialog runningFileTransfersDialog = new RunningFileTransfersDialog(Display
					.getDefault().getActiveShell(), new LabelProvider() {
					@Override
					public String getText(Object element) {
						return element.toString();
					}
				}, projectSpace);
				runningFileTransfersDialog.setBlockOnOpen(false);
				runningFileTransfersDialog.open();
			}
		});
	}
}