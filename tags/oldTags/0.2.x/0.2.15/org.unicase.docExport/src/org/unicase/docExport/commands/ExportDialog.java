package org.unicase.docExport.commands;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
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
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.model.ModelElement;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class ExportDialog extends TitleAreaDialog {

	private ModelElement modelElement;
	
	private ArrayList<DocWriter> docWriters;
	private DocumentRenderer docRenderer;
	private ArrayList<Template> templates;
	
	private Combo template;
	private Combo exportType;
	private Text fileLocation;
	private Text fileName;
	
	
	/**
	 * the constructor.
	 * @param parentShell the parent shell object
	 * @param docRenderer the DocumentRenderer which will use the template to render it to an
	 * URootCompositeSection, which is used by the DocWriter
	 * @param modelElement the modelElement which shall be exported to a document
	 * @throws TemplateSaveException -
	 */
	public ExportDialog(
			Shell parentShell, 
			DocumentRenderer docRenderer,
			ModelElement modelElement
	) throws TemplateSaveException {
		super(parentShell);
		setHelpAvailable(false);
		this.docRenderer = docRenderer;
		this.docWriters = DocWriterRegistry.getDocWriters();
		this.templates = TemplateRegistry.getAllTemplates();
		this.modelElement = modelElement;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// return super.createDialogArea(parent);
		
		GridLayout layout0 = new GridLayout();
		layout0.numColumns = 1;
		parent.setLayout(layout0);
		
		
		
		Group container = new Group(parent, SWT.BORDER);
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
		
		Label label2 = new Label(container, SWT.READ_ONLY);
		label2.setText("File location");
		Composite fileChooser = new Composite(container, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		fileChooser.setLayout(gLayout);
		fileChooser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileLocation = new Text(fileChooser, SWT.BORDER);
		fileLocation.setText(System.getProperty("user.home"));
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
	

		Composite container2 = new Composite(parent, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 3;
		container2.setLayout(layout2);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container2.setLayoutData(gData);
		
		Button saveButton = new Button(container2, SWT.PUSH);
		saveButton.setText("export");
		saveButton.addSelectionListener(new SaveSelectionListener());
		
		Button saveAndOpenButton = new Button(container2, SWT.PUSH);
		saveAndOpenButton.setText("export and open");
		saveAndOpenButton.addSelectionListener(new SaveAndOpenSelectionListener());
		
		Button cancelButton = new Button(container2, SWT.PUSH);
		cancelButton.setText("cancel");
		cancelButton.addSelectionListener(new CancelSelectionListener());
		
		return parent;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// Set the title
		setTitle("Export document");
		// Set the message
		setMessage("Please select a enter a file.", IMessageProvider.INFORMATION);
		return contents;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

	}

	private void exportDocument(
			DocumentExport docExport,
			String fileUrl
		) {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		
		try {
			dialog.run(true, true, docExport);
		} catch (InvocationTargetException e) {
			MessageBox finished = new MessageBox(new Shell(), SWT.OK | SWT.ICON_WORKING);
			finished.setText("Export status");
			finished.setMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
			finished.open();
			e.printStackTrace();
		} catch (InterruptedException e) {
			MessageBox finished = new MessageBox(new Shell(), SWT.OK | SWT.ICON_WORKING);
			finished.setText("Export status");
			finished.setMessage("Export interrupted");
			finished.open();
			e.printStackTrace();
		}
	}
	
	private void openFile(String fileUrl) {
		String lcOSName = System.getProperty("os.name").toLowerCase();
		String cmd = "";
		
		if (lcOSName.startsWith("mac os x")) {
			cmd = "open " + fileUrl;
		} else if (lcOSName.startsWith("linux")) {
			//works for ubuntu and the most common linux systems
			cmd = "xdg-open " + fileUrl;
		} else if (lcOSName.startsWith("windows")) {
			cmd = "cmd.exe /c start " + fileUrl;
		} else {
			//bad luck .. java 1.5 ;(
			//fall through
		}
		
		if (!cmd.equals("")) {
			try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				WorkspaceUtil.log(
						"could not open the file with the system dependant command: " + cmd,
						new Exception(),
						IStatus.WARNING
					);
			}
		}
	}

	/**
	 * Check if the file already exists and returns true, if the file shall be written.
	 * If the file already exists, a prompt message box will appear, which asks
	 * the users, if he really wants to overwrite the file.
	 * 
	 * @param fileUrl the system dependent url to the file
	 * @return true if (over)writing is allowed, else false
	 */
	private boolean checkFileName(String fileUrl) {
		File f = new File(fileUrl);
		Boolean doIt = true;
		
		if (f.exists()) {
			MessageBox messageBox = new MessageBox(new Shell(), 
					SWT.YES | SWT.NO | SWT.ICON_WARNING | SWT.CENTER );
			messageBox.setMessage("The file '" + fileUrl + "' already exists. Do you want to overwrite it?");
			messageBox.setText("File already exists");
			int result = messageBox.open();
			if (result == SWT.NO) {
				doIt = false;
			}
		} 	
		
		return doIt;
	}
	/**
	 * 
	 * @author Sebastian Höcht
	 *
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
				DocWriter docWriter = docWriters.get(exportType.getSelectionIndex());
				DocumentExport docExport = new DocumentExport(
						modelElement, 
						docWriter,
						templates.get(template.getSelectionIndex()),
						docRenderer 
					);
				String fileUrl = 
					fileLocation.getText() + 
					File.separatorChar +
					fileName.getText() + 
					"." +
					docWriter.getFileType();
				docExport.setFileLocation(fileUrl);
				
				if (checkFileName(fileUrl)) {
					exportDocument(docExport, fileUrl);
					close();
				}
			}
		}
	}

	/**
	 * 
	 * @author Sebastian Höcht
	 *
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
				DocWriter docWriter = docWriters.get(exportType.getSelectionIndex());
				DocumentExport docExport = new DocumentExport(
						modelElement, 
						docWriter,
						templates.get(template.getSelectionIndex()),
						docRenderer
					);
				String fileUrl = fileLocation.getText() + 
					File.separatorChar +
					fileName.getText() + 
					"." +
					docWriter.getFileType();
				docExport.setFileLocation(fileUrl);
				
				if (checkFileName(fileUrl)) {
					exportDocument(docExport, fileUrl);
					openFile(fileUrl);
					close();
				}
			}
		}	
	}
	
	/**
	 * 
	 * @author Sebastian Höcht
	 *
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
	 * 
	 * @author Sebastian Höcht
	 *
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