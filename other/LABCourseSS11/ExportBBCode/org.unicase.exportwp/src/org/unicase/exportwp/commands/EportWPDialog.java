package org.unicase.exportwp.commands;

import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
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

import org.unicase.exportwp.CreateBBCodeFormat;
import org.unicase.exportwp.CreateBBCodeFormatString;
import org.unicase.exportwp.CreateBBCodeTableFormat;
import org.unicase.exportwp.CreateBBCodeTableFormatString;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.workspace.util.WorkspaceUtil;

public class EportWPDialog extends TitleAreaDialog {

	private UnicaseModelElement modelElement;
	private Combo template;
	private Combo exportType;
	private Text fileLocation;
	private Text fileName;
	private Text string;
	private Group container;
	private String stringFromBBCode;

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
	public EportWPDialog(Shell parentShell,UnicaseModelElement modelElement) {
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
		

		container = new Group(parent, SWT.BORDER| SWT.RESIZE);
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
		fileName.setRedraw(true);

		Label label2 = new Label(container, SWT.READ_ONLY);
		label2.setText("File location");
		Composite fileChooser = new Composite(container, SWT.NONE | SWT.RESIZE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		fileChooser.setLayout(gLayout);
		fileChooser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileLocation = new Text(fileChooser, SWT.BORDER| SWT.RESIZE);

		fileLocation.setText(PreferenceHelper.getPreference(EXPORT_PATH_QUALIFIER, DEFAULT_EXPORT_PATH));
		fileLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button selectFileLocation = new Button(fileChooser, SWT.PUSH| SWT.RESIZE);
		selectFileLocation.setText("choose...");
		selectFileLocation.addSelectionListener(new FileLocationSelectionListener());

		fileChooser.layout();
		fileChooser.pack();

		Composite container2 = new Composite(parent, SWT.NONE| SWT.RESIZE);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 3;
		container2.setLayout(layout2);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		container2.setLayoutData(gData);
		container2.setRedraw(true);
		Button saveAndOpenButton = new Button(container2, SWT.PUSH| SWT.RESIZE);
		saveAndOpenButton.setText("Export and open");
		saveAndOpenButton.addSelectionListener(new SaveAndOpenSelectionListener());

		Button saveButton = new Button(container2, SWT.PUSH| SWT.RESIZE);
		saveButton.setText("Export");
		saveButton.addSelectionListener(new SaveSelectionListener());		

		Button cancelButton = new Button(container2, SWT.PUSH| SWT.RESIZE);
		cancelButton.setText("Cancel");
		cancelButton.addSelectionListener(new CancelSelectionListener());
		

		
		Composite container3 = new Composite(parent, SWT.BORDER| SWT.RESIZE);
		container3.setLayout(new FillLayout());
		GridData gData3 = new GridData(GridData.FILL_BOTH);
		container3.setLayoutData(gData3);
	
		stringFromBBCode = CreateBBCodeTableFormatString.createString((WorkPackage) modelElement);
		Text t = new Text (container3, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI| SWT.RESIZE);
		t.setBounds(10, 90, 500, 200);
		t.setEditable(true);
		t.setText(stringFromBBCode);

		parent.pack();
		
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

				MessageBox messageBox = new MessageBox(EportWPDialog.platformShell, SWT.YES | SWT.NO | SWT.ICON_WARNING
					| SWT.CENTER);
				messageBox.setMessage("The file '" + fileUrl + "' already exists. Do you want to overwrite it?");
				messageBox.setText("File already exists");
				int result = messageBox.open();
				if (result == SWT.NO) {
					doIt = false;
				}
				out.close();
			} catch (FileNotFoundException e) {
				MessageBox messageBox = new MessageBox(EportWPDialog.platformShell, SWT.OK | SWT.ICON_ERROR | SWT.CENTER);
				messageBox.setMessage(e.getMessage());
				messageBox.setText("File in use");
				messageBox.open();
				doIt = false;
			} catch (IOException e) {
				MessageBox messageBox = new MessageBox(EportWPDialog.platformShell, SWT.OK | SWT.ICON_ERROR | SWT.CENTER);
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
					if (modelElement instanceof WorkPackage){
						
						WorkPackage wp = (WorkPackage) modelElement;
					//CreateBBCodeFormat.createFile(wp,fileUrl);
						CreateBBCodeTableFormat.createFile(wp, fileUrl);
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
					if (modelElement instanceof WorkPackage){
						WorkPackage wp = (WorkPackage) modelElement;
					//CreateBBCodeFormat.createFile(wp,fileUrl);
						CreateBBCodeTableFormat.createFile(wp, fileUrl);
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