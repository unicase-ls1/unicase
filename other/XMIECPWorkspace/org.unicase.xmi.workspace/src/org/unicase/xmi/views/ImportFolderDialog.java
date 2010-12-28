package org.unicase.xmi.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFolder;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

public class ImportFolderDialog extends TitleAreaDialog {

	private Text txtFolderName;
	private Text txtFolderLocation;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public ImportFolderDialog(Shell parent) {
		super(parent);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Create New Folder");
		setMessage("Please enter the name and location of the new folder.");

		// Ask for folder/container name
		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtFolderName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtFolderName.setSize(150, 20);
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE);
		location.setLayout(new FillLayout());
		txtFolderLocation = new Text(location, SWT.SINGLE | SWT.BORDER); 
		txtFolderLocation.setSize(140, 20);
		Button browseButton = new Button(location, SWT.NONE);
		browseButton.setText("Browse...");
		final Shell shell = super.getParentShell();
		browseButton.addSelectionListener(new SelectionListener() {

			DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
			String path = Platform.getLocation().toOSString();
			
			public void widgetDefaultSelected(SelectionEvent e) {
				path = dirDialog.open();
				if(txtFolderName.getText() == null || txtFolderName.getText() == "") {
					path += "/new_folder";
				}
				else {
					path += "/" + txtFolderName.getText();
				}
				txtFolderLocation.setText(path);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});
		browseButton.setEnabled(true);

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(
				defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		//TODO continue...
		new ECPCommand(null) {
			@Override
			protected void doRun() {
				try {						
					// get ECPWorkspace
					ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
					if(ws instanceof XMIECPWorkspace) {
						XMIECPFolder folder = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFolder();
						folder.setContainerName(txtFolderName.getText());
						folder.setXmiDirectoryPath(txtFolderLocation.getText());
						
						// add a new XMIFileProject to the workspace
						((XMIECPWorkspace) ws).addFolder(folder);
					}
					else {
						new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
					}
				} catch (Exception e) {
					new XMIWorkspaceException("Could not create new model element.", e);
				}
			}

		}.run(false);
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelPressed() {
		close();
	}
}
