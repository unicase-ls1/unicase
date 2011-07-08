/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.docExport.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.emf.ecp.common.util.PreferenceHelper;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.docWriter.DocWriter;
import org.unicase.docExport.docWriter.DocWriterRegistry;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;

/**
 * A custom Dialog for the document export function.
 * 
 * @author Sebastian Hoecht
 */
public class ExportDialog extends TitleAreaDialog {

	private UnicaseModelElement modelElement;

	private ArrayList<DocWriter> docWriters;
	private DocumentRenderer docRenderer;
	private ArrayList<Template> templates;

	private Combo template;
	private Combo exportType;
	private Text fileLocation;
	private Text fileName;
	private Group container;

	private Combo recursionDepth;

	private static Shell platformShell;

	private static final String EXPORT_PATH_QUALIFIER = "org.unicase.docExport.exportPath";
	private static final String DEFAULT_EXPORT_PATH = System.getProperty("user.home");

	/**
	 * the constructor.
	 * 
	 * @param parentShell the parent shell object
	 * @param docRenderer the DocumentRenderer which will use the template to render it to an URootCompositeSection,
	 *            which is used by the DocWriter
	 * @param modelElement the modelElement which shall be exported to a document
	 */
	public ExportDialog(Shell parentShell, DocumentRenderer docRenderer, UnicaseModelElement modelElement) {
		super(parentShell);

		this.docRenderer = docRenderer;
		this.modelElement = modelElement;

		platformShell = parentShell;
		setHelpAvailable(false);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		this.docWriters = DocWriterRegistry.getDocWriters();
		try {
			this.templates = TemplateRegistry.getAllTemplates();
		} catch (TemplatesFileNotFoundException e1) {
			MessageBox finished = new MessageBox(ExportDialog.platformShell, SWT.OK | SWT.ERROR);
			finished.setText("Error");
			finished.setMessage("Export templates could not be loaded");
			finished.open();
			close();
		}

		GridLayout layout0 = new GridLayout();
		layout0.numColumns = 1;
		parent.setLayout(layout0);

		container = new Group(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		GridData gData1 = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayoutData(gData1);

		Label label1 = new Label(container, SWT.None);
		label1.setText("File name");
		fileName = new Text(container, SWT.BORDER);
		GridData gData2 = new GridData(GridData.FILL_HORIZONTAL);
		fileName.setLayoutData(gData2);
		fileName.setText(modelElement.getName().replaceAll("\\W+", ""));

		Label label2 = new Label(container, SWT.READ_ONLY);
		label2.setText("File location");
		Composite fileChooser = new Composite(container, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		fileChooser.setLayout(gLayout);
		fileChooser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileLocation = new Text(fileChooser, SWT.BORDER);

		fileLocation.setText(PreferenceHelper.getPreference(EXPORT_PATH_QUALIFIER, DEFAULT_EXPORT_PATH));
		fileLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button selectFileLocation = new Button(fileChooser, SWT.PUSH);
		selectFileLocation.setText("choose...");
		selectFileLocation.addSelectionListener(new FileLocationSelectionListener());

		fileChooser.layout();
		fileChooser.pack();

		Label label4 = new Label(container, SWT.READ_ONLY);
		label4.setText("Template");
		template = new Combo(container, SWT.READ_ONLY);
		for (int i = 0; i < templates.size(); i++) {
			Template innerTemplate = templates.get(i);
			template.add(innerTemplate.getName(), i);
		}
		template.select(0);

		Label label3 = new Label(container, SWT.READ_ONLY);
		label3.setText("File type");
		exportType = new Combo(container, SWT.BORDER);
		for (int i = 0; i < docWriters.size(); i++) {
			DocWriter writer = docWriters.get(i);
			exportType.add(writer.getFileType() + " (" + writer.getClass().getSimpleName() + ")", i);
		}
		exportType.select(0);

		Label label5 = new Label(container, SWT.NONE);
		label5.setText("recursion depth");

		recursionDepth = new Combo(container, SWT.READ_ONLY);
		for (int i = 1; i <= 10; i++) {
			recursionDepth.add(String.valueOf(i), i - 1);
		}
		recursionDepth.select(9);
		recursionDepth.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				DocumentExport.setRecursionDepth(recursionDepth.getSelectionIndex() + 1);
			}
		});

		if (!(modelElement instanceof LeafSection) && !(modelElement instanceof CompositeSection)) {
			Label label6 = new Label(container, SWT.NONE);
			label6.setText("treat Model Element as Leaf Section");

			Button modelElementAsLeafSection = new Button(container, SWT.CHECK);
			modelElementAsLeafSection.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					DocumentExport.setTreatModelElementAsLeafSection(((Button) e.widget).getSelection());
				}
			});
			modelElementAsLeafSection.setSelection(false);
		}

		Composite container2 = new Composite(parent, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 3;
		container2.setLayout(layout2);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container2.setLayoutData(gData);

		Button saveButton = new Button(container2, SWT.PUSH);
		saveButton.setText("Export");
		saveButton.addSelectionListener(new SaveSelectionListener());

		Button saveAndOpenButton = new Button(container2, SWT.PUSH);
		saveAndOpenButton.setText("Export and open");
		saveAndOpenButton.addSelectionListener(new SaveAndOpenSelectionListener());

		Button cancelButton = new Button(container2, SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.addSelectionListener(new CancelSelectionListener());

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Export document");
		setMessage("Please select a file.", IMessageProvider.INFORMATION);
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

	}

	private void exportDocument(DocumentExport docExport, String fileUrl) {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getShell());

		try {
			TemplateRegistry.setMeCount(0);
			dialog.run(true, true, docExport);
			// System.out.println(TemplateRegistry.getMeCount());
		} catch (InvocationTargetException e) {
			MessageBox finished = new MessageBox(ExportDialog.platformShell, SWT.OK | SWT.ICON_ERROR);
			finished.setText(e.getTargetException().getClass().getSimpleName());
			finished.setMessage("Fatal Error: " + e.getTargetException().getMessage() + "\n"
				+ "Please contact a unicase developer");
			finished.open();
		} catch (InterruptedException e) {
			MessageBox finished = new MessageBox(ExportDialog.platformShell, SWT.OK | SWT.ICON_INFORMATION);
			finished.setText("Export status");
			finished.setMessage("Export interrupted");
			finished.open();
		}
	}

	/**
	 * Check if the file already exists and returns true, if the file shall be written. If the file already exists, a
	 * prompt message box will appear, which asks the user, if he really wants to overwrite the file.
	 * 
	 * @param fileUrl the system dependent url to the file
	 * @return true if (over)writing is allowed, else false
	 */
	private boolean checkFileName(String fileUrl) {
		File f = new File(fileUrl);

		try {
			if (f.createNewFile()) {
				f.delete();
			}
		} catch (IOException e1) {
			String err = "The file name '" + fileUrl + "' you entered is invalid.\n";
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid file name", err);
			return false;
		}

		Boolean doIt = true;

		if (f.exists()) {

			try {
				FileOutputStream out = new FileOutputStream(fileUrl);

				MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.YES | SWT.NO | SWT.ICON_WARNING
					| SWT.CENTER);
				messageBox.setMessage("The file '" + fileUrl + "' already exists. Do you want to overwrite it?");
				messageBox.setText("File already exists");
				int result = messageBox.open();
				if (result == SWT.NO) {
					doIt = false;
				}
				out.close();
			} catch (FileNotFoundException e) {
				MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.OK | SWT.ICON_ERROR | SWT.CENTER);
				messageBox.setMessage(e.getMessage());
				messageBox.setText("File in use");
				messageBox.open();
				doIt = false;
			} catch (IOException e) {
				MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.OK | SWT.ICON_ERROR | SWT.CENTER);
				messageBox.setMessage(e.getMessage());
				messageBox
					.setText("The File could not be accessed for some reason. The solution my depend on your operating system:"
						+ "" + e.getMessage());
				messageBox.open();
				doIt = false;
			}

		}

		return doIt;
	}

	private DocumentExport createDocumentExport() {
		DocWriter docWriter = docWriters.get(exportType.getSelectionIndex());
		DocumentExport docExport = new DocumentExport(modelElement, docWriter, templates.get(template
			.getSelectionIndex()), docRenderer);

		docExport.setFileLocation(getFileUrl());

		return docExport;
	}

	private String getFileUrl() {
		String fileUrl = fileLocation.getText() + File.separatorChar + fileName.getText() + "."
			+ docWriters.get(exportType.getSelectionIndex()).getFileType();
		return fileUrl;
	}

	/**
	 * Listener for the save button, which simply exports the document to a file.
	 */
	class SaveSelectionListener extends SelectionAdapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (fileName.getText().length() < 1) {
				setErrorMessage("Please enter a file name");
			} else {
				DocumentExport docExport = createDocumentExport();
				String fileUrl = getFileUrl();
				if (checkFileName(fileUrl)) {
					PreferenceHelper.setPreference(EXPORT_PATH_QUALIFIER, fileLocation.getText());
					exportDocument(docExport, fileUrl);
					close();
				}
			}
		}
	}

	/**
	 * Listener for the save and open button, which exports the document and opens the file afterwards.
	 */
	class SaveAndOpenSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (fileName.getText().length() < 1) {
				setErrorMessage("Please enter a file name");
			} else {
				DocumentExport docExport = createDocumentExport();
				String fileUrl = getFileUrl();
				if (checkFileName(fileUrl)) {
					PreferenceHelper.setPreference(EXPORT_PATH_QUALIFIER, fileLocation.getText());
					exportDocument(docExport, fileUrl);
					WorkspaceUtil.openFile(fileUrl);
					close();
				}
			}
		}
	}

	/**
	 * Listener for the cancel button.
	 */
	class CancelSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			close();
		}
	}

	/**
	 * Listener for the file location selection.
	 */
	class FileLocationSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			DirectoryDialog fd = new DirectoryDialog(((Button) e.widget).getParent().getShell());
			fd.setText("select the folder where you want to save the exported document ");
			String selected = fd.open();

			if (selected != null) {
				fileLocation.setText(selected);
			}
		}
	}
}