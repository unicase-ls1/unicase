package org.unicase.exportbb.commands;

import java.awt.Component;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.exportbb.CreateBBCodeFormat;
import org.unicase.exportbb.CreateBBCodeFormatString;
import org.unicase.model.UnicaseModelElement;

import org.unicase.model.meeting.Meeting;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.workspace.util.WorkspaceUtil;


/**
 * A custom Dialog for the document export function.
 * 
 * @author Carmen Carlan
 */
public class ExportDialog extends TitleAreaDialog {

	
	private UnicaseModelElement modelElement;
	private Combo template;
	private Combo exportType;
	private Text fileLocation;
	private Text fileName;
	private Text string;
	private Group container;
	private String stringFromBBCode;

	private Combo recursionDepth;

	static Shell platformShell;

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
	public ExportDialog(Shell parentShell,UnicaseModelElement modelElement) {
		super(parentShell);
		this.modelElement = modelElement;
		platformShell = parentShell;
		
		setHelpAvailable(false);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {

		
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

		Composite container2 = new Composite(parent, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 3;
		container2.setLayout(layout2);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container2.setLayoutData(gData);
		
		Button saveAndOpenButton = new Button(container2, SWT.PUSH);
		saveAndOpenButton.setText("Export and open");
		saveAndOpenButton.addSelectionListener(new SaveAndOpenSelectionListener());

		Button saveButton = new Button(container2, SWT.PUSH);
		saveButton.setText("Export");
		saveButton.addSelectionListener(new SaveSelectionListener());

				

		Button cancelButton = new Button(container2, SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.addSelectionListener(new CancelSelectionListener());
		
		Composite container3 = new Composite(parent, SWT.BORDER);
		container3.setLayout(new FillLayout());
		GridData gData3 = new GridData(GridData.FILL_BOTH);
		container3.setLayoutData(gData3);
	
		try{
		stringFromBBCode = CreateBBCodeFormatString.createString((Meeting) modelElement);
		Text t = new Text (container3, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI);
		t.setEditable(true);
		t.setText(stringFromBBCode);
		container3.layout();
		
		}catch (Exception ex){
			if (((Meeting) modelElement).getEndtime() == null){
				MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.CANCEL | SWT.ICON_ERROR | SWT.CENTER);
				messageBox.setMessage("The meeting could not be exported. Please insert "+ex.getMessage());
				messageBox.setText("Warning!");
				messageBox.open();}
		}return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Export document");
		String error = CreateBBCodeFormat.getErrorMessage();
		if (error == "")
		setMessage("Please select a file.", IMessageProvider.INFORMATION);
		else setMessage(error + " Please complete all fields properly.", IMessageProvider.INFORMATION);
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

	}
	
	private String getFileUrl() {
		String fileUrl = fileLocation.getText() + File.separatorChar + fileName.getText() + "."
			+ "txt";
		return fileUrl;
	}

	private void exportDocument( String fileUrl) {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getShell());
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
	
	/**
	 * Listener for the save button, which simply exports the document to a file.
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
				String fileUrl = getFileUrl();
				if (checkFileName(fileUrl)) {
					PreferenceHelper.setPreference(EXPORT_PATH_QUALIFIER, fileLocation.getText());
					if (modelElement instanceof Meeting){
						Meeting meeting = (Meeting) modelElement;
						try{
							CreateBBCodeFormat.createFile(meeting,fileUrl);
							}
							catch (Exception ex){
								if (meeting.getEndtime() == null){
									MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.CANCEL | SWT.ICON_ERROR | SWT.CENTER);
									messageBox.setMessage("The meeting could not be exported. Please insert "+ex.getMessage());
									messageBox.setText("Warning!");
									messageBox.open();
								}
									
							}
					}
					WorkspaceUtil.openFile(fileUrl);
					close();
				}
				close();
				
				}
			}
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
				String fileUrl = getFileUrl();
				if (checkFileName(fileUrl)) {
					PreferenceHelper.setPreference(EXPORT_PATH_QUALIFIER, fileLocation.getText());
					if (modelElement instanceof Meeting){
					Meeting meeting = (Meeting) modelElement;
					try{
						CreateBBCodeFormat.createFile(meeting,fileUrl);
						}
						catch (Exception ex){
							if (meeting.getEndtime() == null){
								MessageBox messageBox = new MessageBox(ExportDialog.platformShell, SWT.CANCEL | SWT.ICON_ERROR | SWT.CENTER);
								messageBox.setMessage("The file could not be exported. Please insert "+ex.getMessage());
								messageBox.setText("Warning!");
								messageBox.open();
							}
								
						}
				}
					close();
				}
				close();
			
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
	}}}
	

